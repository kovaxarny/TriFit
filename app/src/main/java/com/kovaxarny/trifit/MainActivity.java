package com.kovaxarny.trifit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.kovaxarny.trifit.adapter.RSSFeedAdapter;
import com.kovaxarny.trifit.common.CheckNetwork;
import com.kovaxarny.trifit.common.HTTPDataHandler;
import com.kovaxarny.trifit.data.BodyStatsDbHelper;
import com.kovaxarny.trifit.data.BodyStatsModel;
import com.kovaxarny.trifit.data.BodyStatsOperations;
import com.kovaxarny.trifit.drawer.AboutActivity;
import com.kovaxarny.trifit.drawer.ChallengesActivity;
import com.kovaxarny.trifit.drawer.ProfileActivity;
import com.kovaxarny.trifit.drawer.SettingsActivity;
import com.kovaxarny.trifit.drawer.WorkoutProgramsActivity;
import com.kovaxarny.trifit.rss.RSSObject;
import com.kovaxarny.trifit.statistics.BodyIndex;

import java.util.Locale;


//TODO fix issues, search for udemy course
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";
    private static final Integer firstRunActivityCode = 1;
    private static final Integer addBodyStatsActivityCode = 2;

    Toolbar toolbar;

    RecyclerView rssFeedRecycleView;
    RSSObject rssObject;

    private static final String RSS_LINK = "https://www.bodybuilding.com/rss/articles";
    private static final String RSS_TO_JSON_API = " https://api.rss2json.com/v1/api.json?rss_url=";

    private SharedPreferences preferences;
    TextView tvUserName;
    TextView tvUserBirthDate;
    TextView tvUserBMI;
    TextView tvUserBMR;
    BodyIndex bodyIndex = new BodyIndex();

    private BodyStatsOperations bodyStatsOperations;
    private BodyStatsDbHelper dbHelper = new BodyStatsDbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Setting up the Toolbar for our activity */
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /* Floating action button what we will need in the future for new stat input */
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addBodyStatActivity = new Intent(MainActivity.this, AddBodyStatActivity.class);
                startActivityForResult(addBodyStatActivity, addBodyStatsActivityCode);
            }
        });

        /* Drawer for our secondary activities */
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        /* Navigation view*/
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /* Making our preferences available in the whole activity */
        preferences = getSharedPreferences("com.kovaxarny.trifit.Preferences", MODE_PRIVATE);

        /* Accessing the db behind the app */
        bodyStatsOperations = new BodyStatsOperations(dbHelper);
        Cursor cursor = bodyStatsOperations.getAllBodyStats();

        /* Showing database data on the Main Activity*/
//        statsListRecycleView = (RecyclerView) findViewById(R.id.all_body_stats_view);
//        statsListRecycleView.setLayoutManager(new LinearLayoutManager(this));
//
//        mAdapter = new StatsListAdapter(this, cursor);
//        statsListRecycleView.setAdapter(mAdapter);

        /* RSS feed*/
        rssFeedRecycleView = (RecyclerView) findViewById(R.id.all_body_stats_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false);
        rssFeedRecycleView.setLayoutManager(linearLayoutManager);

        loadRSS();
    }

    private void loadRSS() {
        if (CheckNetwork.isInternetAvailable(MainActivity.this)) {
            AsyncTask<String, String, String> loadRSSAsync = new AsyncTask<String, String, String>() {

                @Override
                protected String doInBackground(String... strings) {
                    String result;
                    HTTPDataHandler httpDataHandler = new HTTPDataHandler();
                    result = httpDataHandler.GetHTTPData(strings[0]);
                    return result;
                }

                @Override
                protected void onPostExecute(String s) {
                    findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                    rssObject = new Gson().fromJson(s, RSSObject.class);
                    RSSFeedAdapter rssFeedAdapter = new RSSFeedAdapter(rssObject, getBaseContext());
                    rssFeedRecycleView.setAdapter(rssFeedAdapter);
                    rssFeedAdapter.notifyDataSetChanged();
                }
            };

            StringBuilder url_get_data = new StringBuilder(RSS_TO_JSON_API).append(RSS_LINK);
            loadRSSAsync.execute(url_get_data.toString());
        } else {
            Toast.makeText(MainActivity.this, "No Internet Connection", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (preferences.getBoolean("isFirstRun", true)) {
            Intent startFirstRunActivityIntent = new Intent(MainActivity.this, FirstRunActivity.class);
            startActivityForResult(startFirstRunActivityIntent, firstRunActivityCode);
        } else {
            updateUserInfo();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == firstRunActivityCode && resultCode == RESULT_OK && data != null) {
            getSharedPreferences("com.kovaxarny.trifit.Preferences", MODE_PRIVATE)
                    .edit()
                    .putString("firstName", data.getStringExtra("firstName"))
                    .putString("lastName", data.getStringExtra("lastName"))
                    .putString("birthDay", data.getStringExtra("birthDay"))
                    .putString("gender", data.getStringExtra("gender"))
                    .apply();

            BodyStatsModel model = new BodyStatsModel();
            model.setHeight(data.getIntExtra("height", 1));
            model.setWeight(data.getDoubleExtra("weight", 1.0));
            model.setTimestamp(data.getStringExtra("date"));

            bodyStatsOperations.addNewBodyStat(model);
            updateUserInfo();
        }

        if (requestCode == addBodyStatsActivityCode && resultCode == RESULT_OK && data != null) {
            Integer addHeight = data.getIntExtra("addHeight", 1);
            Double addWeight = data.getDoubleExtra("addWeight", 1);
            String addDate = data.getStringExtra("addDate");

            bodyStatsOperations.addNewBodyStat(addHeight, addWeight, addDate);
        }
    }

    private void updateUserInfo() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        tvUserName = (TextView) headerView.findViewById(R.id.tv_users_name);
        tvUserBirthDate = (TextView) headerView.findViewById(R.id.tv_birth_day);
        tvUserBMI = (TextView) headerView.findViewById(R.id.tv_bmi);
        tvUserBMR = (TextView) headerView.findViewById(R.id.tv_bmr);

        String result = preferences.getString("firstName", "firstName") + " " + preferences.getString("lastName", "lastName");

        tvUserName.setText(result);
        tvUserBirthDate.setText(preferences.getString("birthDay", "birthDay"));

        BodyStatsModel model = new BodyStatsModel(bodyStatsOperations.getLatestData());
        tvUserBMI.setText(String.format(Locale.US, "%.2f",
                bodyIndex.calculateBodyMassIndex(
                        model.getHeight(),
                        model.getWeight()
                )));
        tvUserBMR.setText(String.format(Locale.US, "%d",
                bodyIndex.calculateBasalMetabolicRate(
                        model.getHeight(),
                        model.getWeight(),
                        preferences.getString("gender", "gender"),
                        preferences.getString("birthDay", "birthDay")
                )));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_refresh) {
            loadRSS();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            Intent startProfileActivityIntent = new Intent(MainActivity.this, ProfileActivity.class);
            startProfileActivityIntent.putExtra("Text", "Drawer > Profile: " + id);
            startActivity(startProfileActivityIntent);
        } else if (id == R.id.nav_workout_programs) {
            Intent startWorkoutProgramsActivityIntent = new Intent(MainActivity.this, WorkoutProgramsActivity.class);
            startWorkoutProgramsActivityIntent.putExtra("Text", "Drawer > Workout Programs: " + id);
            startActivity(startWorkoutProgramsActivityIntent);
        } else if (id == R.id.nav_challanges) {
            Intent startChallengesActivityIntent = new Intent(MainActivity.this, ChallengesActivity.class);
            startChallengesActivityIntent.putExtra("Text", "Drawer > Challenges: " + id);
            startActivity(startChallengesActivityIntent);
        } else if (id == R.id.nav_settings) {
            Intent startSettingsActivityIntent = new Intent(MainActivity.this, SettingsActivity.class);
            startSettingsActivityIntent.putExtra("Text", "Drawer > Settings: " + id);
            startActivity(startSettingsActivityIntent);
        } else if (id == R.id.nav_about) {
            Intent startAboutActivityIntent = new Intent(MainActivity.this, AboutActivity.class);
            startAboutActivityIntent.putExtra("Text", "Drawer > About: " + id);
            startActivity(startAboutActivityIntent);
        } else if (id == R.id.nav_reset) {
            //TODO this 4 lines has to be deleted, before release. Now its in just for testing
            getSharedPreferences("com.kovaxarny.trifit.Preferences", MODE_PRIVATE)
                    .edit()
                    .putBoolean("isFirstRun", true)
                    .apply();
            bodyStatsOperations.deleteData();
//            mAdapter.swapCursor(bodyStatsOperations.getAllBodyStats());
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}