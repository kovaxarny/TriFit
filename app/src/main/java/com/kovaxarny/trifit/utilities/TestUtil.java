package com.kovaxarny.trifit.utilities;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.kovaxarny.trifit.data.workout.ExerciseContract;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {

    public static void insertFakeData(SQLiteDatabase db) {
        if (db == null) {
            return;
        }
        //create a list of fake data
        List<ContentValues> list = new ArrayList<ContentValues>();

        ContentValues cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Barbell Bench Press");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Chest");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Lie back on a flat bench. Using a medium width grip (a grip that creates a 90-degree angle in the middle of the movement between the forearms and the upper arms), lift the bar from the rack and hold it straight over you with your arms locked. This will be your starting position.\n" +
                "2. From the starting position, breathe in and begin coming down slowly until the bar touches your middle chest.\n" +
                "3. After a brief pause, push the bar back to the starting position as you breathe out. Focus on pushing the bar using your chest muscles. Lock your arms and squeeze your chest in the contracted position at the top of the motion, hold for a second and then start coming down slowly again. Tip: Ideally, lowering the weight should take about twice as long as raising it.\n" +
                "4. Repeat the movement for the prescribed amount of repetitions.\n" +
                "5. When you are done, place the bar back in the rack.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "Barbell");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Barbell Incline Bench Press");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Chest");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Load the bar to an appropriate weight for your training.\n" +
                "2. Lay on the bench with your feet flat on the ground, driving through to your hips. Your back should be arched, and your shoulder blades retracted.\n" +
                "3. Take a medium, pronated grip covering the rings on the bar. Remove the bar from the rack, holding the weight above your chest with your arms extended. This will be your starting position.\n" +
                "4. Lower the bar to the sternum by flexing the elbows. Maintain control and do not bounce the bar off of your chest. Your lats should stay tight and elbows slightly drawn in.\n" +
                "5. After touching your torso with the bar, extend the elbows to return the bar to the starting position.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "Barbell");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Low Cable Crossover");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Chest");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. To move into the starting position, place the pulleys at the low position, select the resistance to be used and grasp a handle in each hand.\n" +
                "2. Step forward, gaining tension in the pulleys. Your palms should be facing forward, hands below the waist, and your arms straight. This will be your starting position.\n" +
                "3. With a slight bend in your arms, draw your hands upward and toward the midline of your body. Your hands should come together in front of your chest, palms facing up.\n" +
                "4. Return your arms back to the starting position after a brief pause. ");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "Cable");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Cable Crossover");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Chest");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. To get yourself into the starting position, place the pulleys on a high position (above your head), select the resistance to be used and hold the pulleys in each hand.\n" +
                "2. Step forward in front of an imaginary straight line between both pulleys while pulling your arms together in front of you. Your torso should have a small forward bend from the waist. This will be your starting position.\n" +
                "3. With a slight bend on your elbows in order to prevent stress at the biceps tendon, extend your arms to the side (straight out at both sides) in a wide arc until you feel a stretch on your chest. Breathe in as you perform this portion of the movement. Tip: Keep in mind that throughout the movement, the arms and torso should remain stationary; the movement should only occur at the shoulder joint.\n" +
                "4. Return your arms back to the starting position as you breathe out. Make sure to use the same arc of motion used to lower the weights.\n" +
                "5. Hold for a second at the starting position and repeat the movement for the prescribed amount of repetitions.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "Cable");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Cable Iron Cross");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Chest");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Begin by moving the pulleys to the high position, select the resistance to be used, and take a handle in each hand.\n" +
                "2. Stand directly between both pulleys with your arms extended out to your sides. Your head and chest should be up while your arms form a â€œTâ€\u009D. This will be your starting position.\n" +
                "3. Keeping the elbows extended, pull your arms straight to your sides.\n" +
                "4. Return your arms back to the starting position after a pause at the peak contraction.\n" +
                "5. Continue the movement for the prescribed number of repetitions.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "Cable");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Push Up");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Triceps");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Lie back on a flat bench. Using a close grip (around shoulder width), lift the bar from the rack and hold it straight over you with your arms locked. This will be your starting position.\n" +
                "2. As you breathe in, come down slowly until you feel the bar on your middle chest. Tip: Make sure that - as opposed to a regular bench press - you keep the elbows close to the torso at all times in order to maximize triceps involvement.\n" +
                "3. After a second pause, bring the bar back to the starting position as you breathe out and push the bar using your triceps muscles. Lock your arms in the contracted position, hold for a second and then start coming down slowly again. Tip: It should take at least twice as long to go down than to come up.\n" +
                "4. Repeat the movement for the prescribed amount of repetitions.\n" +
                "5. When you are done, place the bar back in the rack.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "Barbell");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Push Up");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Triceps");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Attach a V-Bar to a high pulley and grab with an overhand grip (palms facing down) at shoulder width.\n" +
                "2. Standing upright with the torso straight and a very small inclination forward, bring the upper arms close to your body and perpendicular to the floor. The forearms should be pointing up towards the pulley as they hold the bar. The thumbs should be higher than the small finger. This is your starting position.\n" +
                "3. Using the triceps, bring the bar down until it touches the front of your thighs and the arms are fully extended perpendicular to the floor. The upper arms should always remain stationary next to your torso and only the forearms should move. Exhale as you perform this movement.\n" +
                "4. After a second hold at the contracted position, bring the V-Bar slowly up to the starting point. Breathe in as you perform this step.\n" +
                "5. Repeat for the recommended amount of repetitions.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "Cable");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Push Up");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Triceps");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. To begin, stand up with a dumbbell held by both hands. Your feet should be about shoulder width apart from each other. Slowly use both hands to grab the dumbbell and lift it over your head until both arms are fully extended.\n" +
                "2. The resistance should be resting in the palms of your hands with your thumbs around it. The palm of the hands should be facing up towards the ceiling. This will be your starting position.\n" +
                "3. Keeping your upper arms close to your head with elbows in and perpendicular to the floor, lower the resistance in a semicircular motion behind your head until your forearms touch your biceps. Tip: The upper arms should remain stationary and only the forearms should move. Breathe in as you perform this step.\n" +
                "4. Go back to the starting position by using the triceps to raise the dumbbell. Breathe out as you perform this step.\n" +
                "5. Repeat for the recommended amount of repetitions.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "Dumbbell");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Wide-Grip Lat Pulldown");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Back");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Sit down on a pull-down machine with a wide bar attached to the top pulley. Make sure that you adjust the knee pad of the machine to fit your height. These pads will prevent your body from being raised by the resistance attached to the bar.\n" +
                "2. Grab the bar with the palms facing forward using the prescribed grip. Note on grips: For a wide grip, your hands need to be spaced out at a distance wider than shoulder width. For a medium grip, your hands need to be spaced out at a distance equal to your shoulder width and for a close grip at a distance smaller than your shoulder width.\n" +
                "3. As you have both arms extended in front of you holding the bar at the chosen grip width, bring your torso back around 30 degrees or so while creating a curvature on your lower back and sticking your chest out. This is your starting position.\n" +
                "4. As you breathe out, bring the bar down until it touches your upper chest by drawing the shoulders and the upper arms down and back. Tip: Concentrate on squeezing the back muscles once you reach the full contracted position. The upper torso should remain stationary and only the arms should move. The forearms should do no other work except for holding the bar; therefore do not try to pull down the bar using the forearms.\n" +
                "5. After a second at the contracted position squeezing your shoulder blades together, slowly raise the bar back to the starting position when your arms are fully extended and the lats are fully stretched. Inhale during this portion of the movement.\n" +
                "6. Repeat this motion for the prescribed amount of repetitions.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "Cable");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Underhand Cable Pulldowns");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Back");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Sit down on a pull-down machine with a wide bar attached to the top pulley. Adjust the knee pad of the machine to fit your height. These pads will prevent your body from being raised by the resistance attached to the bar.\n" +
                "2. Grab the pull-down bar with the palms facing your torso (a supinated grip). Make sure that the hands are placed closer than the shoulder width.\n" +
                "3. As you have both arms extended in front of you holding the bar at the chosen grip width, bring your torso back around 30 degrees or so while creating a curvature on your lower back and sticking your chest out. This is your starting position.\n" +
                "4. As you breathe out, pull the bar down until it touches your upper chest by drawing the shoulders and the upper arms down and back. Tip: Concentrate on squeezing the back muscles once you reach the fully contracted position and keep the elbows close to your body. The upper torso should remain stationary as your bring the bar to you and only the arms should move. The forearms should do no other work other than hold the bar.\n" +
                "5. After a second on the contracted position, while breathing in, slowly bring the bar back to the starting position when your arms are fully extended and the lats are fully stretched.\n" +
                "6. Repeat this motion for the prescribed amount of repetitions.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "Cable");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Bent Over Barbell Row");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Back");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Holding a barbell with a pronated grip (palms facing down), bend your knees slightly and bring your torso forward, by bending at the waist, while keeping the back straight until it is almost parallel to the floor. Tip: Make sure that you keep the head up. The barbell should hang directly in front of you as your arms hang perpendicular to the floor and your torso. This is your starting position.\n" +
                "2. Now, while keeping the torso stationary, breathe out and lift the barbell to you. Keep the elbows close to the body and only use the forearms to hold the weight. At the top contracted position, squeeze the back muscles and hold for a brief pause.\n" +
                "3. Then inhale and slowly lower the barbell back to the starting position.\n" +
                "4. Repeat for the recommended amount of repetitions.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "Barbell");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Face Pull");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Back");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Facing a high pulley with a rope or dual handles attached, pull the weight directly towards your face, separating your hands as you do so. Keep your upper arms parallel to the ground.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "Cable");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "One Arm Lat Pulldown");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Back");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Select an appropriate weight and adjust the knee pad to help keep you down. Grasp the handle with a pronated grip. This will be your starting position.\n" +
                "2. Pull the handle down, squeezing your elbow to your side as you flex the elbow.\n" +
                "3. Pause at the bottom of the motion, and then slowly return the handle to the starting position.\n" +
                "4. For multiple repetitions, avoid completely returning the weight to keep tension on the muscles being worked.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "Cable");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Seated Cable Rows");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Back");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. For this exercise you will need access to a low pulley row machine with a V-bar. Note: The V-bar will enable you to have a neutral grip where the palms of your hands face each other. To get into the starting position, first sit down on the machine and place your feet on the front platform or crossbar provided making sure that your knees are slightly bent and not locked.\n" +
                "2. Lean over as you keep the natural alignment of your back and grab the V-bar handles.\n" +
                "3. With your arms extended pull back until your torso is at a 90-degree angle from your legs. Your back should be slightly arched and your chest should be sticking out. You should be feeling a nice stretch on your lats as you hold the bar in front of you. This is the starting position of the exercise.\n" +
                "4. Keeping the torso stationary, pull the handles back towards your torso while keeping the arms close to it until you touch the abdominals. Breathe out as you perform that movement. At that point you should be squeezing your back muscles hard. Hold that contraction for a second and slowly go back to the original position while breathing in.\n" +
                "5. Repeat for the recommended amount of repetitions.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "Cable");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "EZ-Bar Curl");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Biceps");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Stand up straight while holding an EZ curl bar at the wide outer handle. The palms of your hands should be facing forward and slightly tilted inward due to the shape of the bar. Keep your elbows close to your torso. This will be your starting position.\n" +
                "2. Now, while keeping your upper arms stationary, exhale and curl the weights forward while contracting the biceps. Focus on only moving your forearms.\n" +
                "3. Continue to raise the weight until your biceps are fully contracted and the bar is at shoulder level. Hold the top contracted position for a moment and squeeze the biceps.\n" +
                "4. Then inhale and slowly lower the bar back to the starting position.\n" +
                "4. Repeat for the recommended amount of repetitions.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "EZ-Bar");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Hammer Curls");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Biceps");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Stand up with your torso upright and a dumbbell on each hand being held at arms length. The elbows should be close to the torso.\n" +
                "2. The palms of the hands should be facing your torso. This will be your starting position.\n" +
                "3. Now, while holding your upper arm stationary, exhale and curl the weight forward while contracting the biceps. Continue to raise the weight until the biceps are fully contracted and the dumbbell is at shoulder level. Hold the contracted position for a brief moment as you squeeze the biceps. Tip: Focus on keeping the elbow stationary and only moving your forearm.\n" +
                "4. After the brief pause, inhale and slowly begin the lower the dumbbells back down to the starting position.\n" +
                "5. Repeat for the recommended amount of repetitions.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "Dumbbell");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Concentration Curls");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Biceps");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Sit down on a flat bench with one dumbbell in front of you between your legs. Your legs should be spread with your knees bent and feet on the floor.\n" +
                "2. Use your right arm to pick the dumbbell up. Place the back of your right upper arm on the top of your inner right thigh. Rotate the palm of your hand until it is facing forward away from your thigh. Tip: Your arm should be extended and the dumbbell should be above the floor. This will be your starting position.\n" +
                "3. While holding the upper arm stationary, curl the weights forward while contracting the biceps as you breathe out. Only the forearms should move. Continue the movement until your biceps are fully contracted and the dumbbells are at shoulder level. Tip: At the top of the movement make sure that the little finger of your arm is higher than your thumb. This guarantees a good contraction. Hold the contracted position for a second as you squeeze the biceps.\n" +
                "4. Slowly begin to bring the dumbbells back to starting position as your breathe in. Caution: Avoid swinging motions at any time.\n" +
                "5. Repeat for the recommended amount of repetitions. Then repeat the movement with the left arm.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "Dumbbell");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Military Press");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Shoulder");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Start by placing a barbell that is about chest high on a squat rack. Once you have selected the weights, grab the barbell using a pronated (palms facing forward) grip. Make sure to grip the bar wider than shoulder width apart from each other.\n" +
                "2. Slightly bend the knees and place the barbell on your collar bone. Lift the barbell up keeping it lying on your chest. Take a step back and position your feet shoulder width apart from each other.\n" +
                "3. Once you pick up the barbell with the correct grip length, lift the bar up over your head by locking your arms. Hold at about shoulder level and slightly in front of your head. This is your starting position.\n" +
                "4. Lower the bar down to the collarbone slowly as you inhale.\n" +
                "5. Lift the bar back up to the starting position as you exhale.\n" +
                "6. Repeat for the recommended amount of repetitions.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "Barbell");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Arnold Dumbbell Press");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Shoulder");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Sit on an exercise bench with back support and hold two dumbbells in front of you at about upper chest level with your palms facing your body and your elbows bent. Tip: Your arms should be next to your torso. The starting position should look like the contracted portion of a dumbbell curl.\n" +
                "2. Now to perform the movement, raise the dumbbells as you rotate the palms of your hands until they are facing forward.\n" +
                "3. Continue lifting the dumbbells until your arms are extended above you in straight arm position. Breathe out as you perform this portion of the movement.\n" +
                "4. After a second pause at the top, begin to lower the dumbbells to the original position by rotating the palms of your hands towards you. Tip: The left arm will be rotated in a counter clockwise manner while the right one will be rotated clockwise. Breathe in as you perform this portion of the movement.\n" +
                "5. Repeat for the recommended amount of repetitions.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "Dumbbell");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Side Lateral Raise");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Shoulder");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Pick a couple of dumbbells and stand with a straight torso and the dumbbells by your side at arms length with the palms of the hand facing you. This will be your starting position.\n" +
                "2. While maintaining the torso in a stationary position (no swinging), lift the dumbbells to your side with a slight bend on the elbow and the hands slightly tilted forward as if pouring water in a glass. Continue to go up until you arms are parallel to the floor. Exhale as you execute this movement and pause for a second at the top.\n" +
                "3. Lower the dumbbells back down slowly to the starting position as you inhale.\n" +
                "4. Repeat for the recommended amount of repetitions.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "Dumbbell");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Front Dumbbell Raise");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Shoulder");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Pick a couple of dumbbells and stand with a straight torso and the dumbbells on front of your thighs at arms length with the palms of the hand facing your thighs. This will be your starting position.\n" +
                "2. While maintaining the torso stationary (no swinging), lift the left dumbbell to the front with a slight bend on the elbow and the palms of the hands always facing down. Continue to go up until you arm is slightly above parallel to the floor. Exhale as you execute this portion of the movement and pause for a second at the top. Inhale after the second pause.\n" +
                "3. Now lower the dumbbell back down slowly to the starting position as you simultaneously lift the right dumbbell.\n" +
                "4. Continue alternating in this fashion until all of the recommended amount of repetitions have been performed for each arm.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "Dumbbell");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Reverse Flyes");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Shoulder");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. To begin, lie down on an incline bench with the chest and stomach pressing against the incline. Have the dumbbells in each hand with the palms facing each other (neutral grip).\n" +
                "2. Extend the arms in front of you so that they are perpendicular to the angle of the bench. The legs should be stationary while applying pressure with the ball of your toes. This is the starting position.\n" +
                "3. Maintaining the slight bend of the elbows, move the weights out and away from each other (to the side) in an arc motion while exhaling. Tip: Try to squeeze your shoulder blades together to get the best results from this exercise.\n" +
                "4. The arms should be elevated until they are parallel to the floor.\n" +
                "5. Feel the contraction and slowly lower the weights back down to the starting position while inhaling.\n" +
                "6. Repeat for the recommended amount of repetitions.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "Dumbbell");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Crunches");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Abs");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Lie flat on your back with your feet flat on the ground, or resting on a bench with your knees bent at a 90 degree angle. If you are resting your feet on a bench, place them three to four inches apart and point your toes inward so they touch.\n" +
                "2. Now place your hands lightly on either side of your head keeping your elbows in. Tip: Don't lock your fingers behind your head.\n" +
                "3. While pushing the small of your back down in the floor to better isolate your abdominal muscles, begin to roll your shoulders off the floor.\n" +
                "4. Continue to push down as hard as you can with your lower back as you contract your abdominals and exhale. Your shoulders should come up off the floor only about four inches, and your lower back should remain on the floor. At the top of the movement, contract your abdominals hard and keep the contraction for a second. Tip: Focus on slow, controlled movement - don't cheat yourself by using momentum.\n" +
                "5. After the one second contraction, begin to come down slowly again to the starting position as you inhale.\n" +
                "6. Repeat for the recommended amount of repetitions.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "None");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Straight-Legged Hip Raise");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Abs");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Begin by lying on your back on the ground. Your legs should be straight and your arms at your side. This will be your starting position.\n" +
                "2. To perform the movement, rotate and elevate your pelvis to raise your glutes from the floor.\n" +
                "3. After a brief pause, return to the starting position.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "None");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Leg Raise");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Abs");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Lie with your back flat on a bench and your legs extended in front of you off the end.\n" +
                "2. Place your hands either under your glutes with your palms down or by the sides holding on to the bench. This will be your starting position.\n" +
                "3. As you keep your legs extended, straight as possible with your knees slightly bent but locked raise your legs until they make a 90-degree angle with the floor. Exhale as you perform this portion of the movement and hold the contraction at the top for a second.\n" +
                "4. Now, as you inhale, slowly lower your legs back down to the starting position.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "None");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Russian Twist");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Abs");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Lie down on the floor placing your feet either under something that will not move or by having a partner hold them. Your legs should be bent at the knees.\n" +
                "2. Elevate your upper body so that it creates an imaginary V-shape with your thighs. Your arms should be fully extended in front of you perpendicular to your torso and with the hands clasped. This is the starting position.\n" +
                "3. Twist your torso to the right side until your arms are parallel with the floor while breathing out.\n" +
                "4. Hold the contraction for a second and move back to the starting position while breathing out. Now move to the opposite side performing the same techniques you applied to the right side.\n" +
                "5. Repeat for the recommended amount of repetitions.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "None");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Plank");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Abs");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Get into a prone position on the floor, supporting your weight on your toes and your forearms. Your arms are bent and directly below the shoulder.\n" +
                "2. Keep your body straight at all times, and hold this position as long as possible. To increase difficulty, an arm or leg can be raised.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "None");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Barbell Deadlift");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Legs");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Approach the bar so that it is centered over your feet. Your feet should be about hip-width apart. Bend at the hip to grip the bar at shoulder-width allowing your shoulder blades to protract. Typically, you would use an alternating grip.\n" +
                "2. With your feet and your grip set, take a big breath and then lower your hips and flex the knees until your shins contact the bar. Look forward with your head. Keep your chest up and your back arched, and begin driving through the heels to move the weight upward.\n" +
                "3. After the bar passes the knees aggressively pull the bar back, pulling your shoulder blades together as you drive your hips forward into the bar.\n" +
                "4. Lower the bar by bending at the hips and guiding it to the floor. ");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "Barbell");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Barbell Full Squat");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Legs");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. This exercise is best performed inside a squat rack for safety purposes. To begin, first set the bar on a rack just above shoulder level. Once the correct height is chosen and the bar is loaded, step under the bar and place the back of your shoulders (slightly below the neck) across it.\n" +
                "2. Hold on to the bar using both arms at each side and lift it off the rack by first pushing with your legs and at the same time straightening your torso.\n" +
                "3. Step away from the rack and position your legs using a shoulder-width medium stance with the toes slightly pointed out. Keep your head up at all times and maintain a straight back. This will be your starting position.\n" +
                "4. Begin to slowly lower the bar by bending the knees and sitting back with your hips as you maintain a straight posture with the head up. Continue down until your hamstrings are on your calves. Inhale as you perform this portion of the movement.\n" +
                "5. Begin to raise the bar as you exhale by pushing the floor with the heel or middle of your foot as you straighten the legs and extend the hips to go back to the starting position.\n" +
                "6. Repeat for the recommended amount of repetitions.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "Barbell");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Leg Press");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Legs");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Using a leg press machine, sit down on the machine and place your legs on the platform directly in front of you at a medium (shoulder width) foot stance. (Note: For the purposes of this discussion we will use the medium stance described above which targets overall development; however you can choose any of the three stances described in the foot positioning section).\n" +
                "2. Lower the safety bars holding the weighted platform in place and press the platform all the way up until your legs are fully extended in front of you. Tip: Make sure that you do not lock your knees. Your torso and the legs should make a perfect 90-degree angle. This will be your starting position.\n" +
                "3. As you inhale, slowly lower the platform until your upper and lower legs make a 90-degree angle.\n" +
                "4. Pushing mainly with the heels of your feet and using the quadriceps go back to the starting position as you exhale.\n" +
                "5. Repeat for the recommended amount of repetitions and ensure to lock the safety pins properly once you are done. You do not want that platform falling on you fully loaded.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "Press Machine");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Calf Press");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Legs");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Using a leg press machine, sit down on the machine and place your legs on the platform directly in front of you at a medium (shoulder width) foot stance.\n" +
                "2. Lower the safety bars holding the weighted platform in place and press the platform all the way up until your legs are fully extended in front of you without locking your knees. (Note: In some leg press units you can leave the safety bars on for increased safety. If your leg press unit allows for this, then this is the preferred method of performing the exercise.) Your torso and the legs should make perfect 90-degree angle. Now carefully place your toes and balls of your feet on the lower portion of the platform with the heels extending off. Toes should be facing forward, outwards or inwards as described at the beginning of the chapter. This will be your starting position.\n" +
                "3. Press on the platform by raising your heels as you breathe out by extending your ankles as high as possible and flexing your calf. Ensure that the knee is kept stationary at all times. There should be no bending at any time. Hold the contracted position by a second before you start to go back down.\n" +
                "4. Go back slowly to the starting position as you breathe in by lowering your heels as you bend the ankles until calves are stretched.\n" +
                "5. Repeat for the recommended amount of repetitions.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "Press Machine");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Barbell Lunge");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Gym");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Legs");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. This exercise is best performed inside a squat rack for safety purposes. To begin, first set the bar on a rack just below shoulder level. Once the correct height is chosen and the bar is loaded, step under the bar and place the back of your shoulders (slightly below the neck) across it.\n" +
                "2. Hold on to the bar using both arms at each side and lift it off the rack by first pushing with your legs and at the same time straightening your torso.\n" +
                "3. Step away from the rack and step forward with your right leg and squat down through your hips, while keeping the torso upright and maintaining balance. Inhale as you go down. Note: Do not allow your knee to go forward beyond your toes as you come down, as this will put undue stress on the knee joint. li>\n" +
                "4. Using mainly the heel of your foot, push up and go back to the starting position as you exhale.\n" +
                "5. Repeat the movement for the recommended amount of repetitions and then perform with the left leg.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "Barbell");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Plank");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Calisthenics");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Pull");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Get into a prone position on the floor, supporting your weight on your toes and your forearms. Your arms are bent and directly below the shoulder.\n" +
                "2. Keep your body straight at all times, and hold this position as long as possible. To increase difficulty, an arm or leg can be raised.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "None");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Squat");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Calisthenics");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Pull");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Stand with your feet shoulder width apart. You can place your hands behind your head. This will be your starting position.\n" +
                "2. Begin the movement by flexing your knees and hips, sitting back with your hips.\n" +
                "3. Continue down to full depth if you are able,and quickly reverse the motion until you return to the starting position. As you squat, keep your head and chest up and push your knees out.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "None");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Push-Ups");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Calisthenics");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Push");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Lie on the floor face down and place your hands about 36 inches apart while holding your torso up at arms length.\n" +
                "2. Next, lower yourself downward until your chest almost touches the floor as you inhale.\n" +
                "3. Now breathe out and press your upper body back up to the starting position while squeezing your chest.\n" +
                "4. After a brief pause at the top contracted position, you can begin to lower yourself downward again for as many repetitions as needed.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "None");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Push-Ups With Feet Elevated");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Calisthenics");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Push");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Lie on the floor face down and place your hands about 36 inches apart from each other holding your torso up at arms length.\n" +
                "2. Place your toes on top of a flat bench. This will allow your body to be elevated. Note: The higher the elevation of the flat bench, the higher the resistance of the exercise is.\n" +
                "3. Lower yourself until your chest almost touches the floor as you inhale.\n" +
                "4. Using your pectoral muscles, press your upper body back up to the starting position and squeeze your chest. Breathe out as you perform this step.\n" +
                "5. After a second pause at the contracted position, repeat the movement for the prescribed amount of repetitions.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "None");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Push-Ups - Close Triceps");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Calisthenics");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Push");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Lie on the floor face down and place your hands closer than shoulder width for a close hand position. Make sure that you are holding your torso up at arms' length.\n" +
                "2. Lower yourself until your chest almost touches the floor as you inhale.\n" +
                "3. Using your triceps and some of your pectoral muscles, press your upper body back up to the starting position and squeeze your chest. Breathe out as you perform this step.\n" +
                "4. After a second pause at the contracted position, repeat the movement for the prescribed amount of repetitions.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "None");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Handstand Push-Ups");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Calisthenics");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Push");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. With your back to the wall bend at the waist and place both hands on the floor at shoulder width.\n" +
                "2. Kick yourself up against the wall with your arms straight. Your body should be upside down with the arms and legs fully extended. Keep your whole body as straight as possible. Tip: If doing this for the first time, have a spotter help you. Also, make sure that you keep facing the wall with your head, rather than looking down.\n" +
                "3. Slowly lower yourself to the ground as you inhale until your head almost touches the floor. Tip: It is of utmost importance that you come down slow in order to avoid head injury.\n" +
                "4. Push yourself back up slowly as you exhale until your elbows are nearly locked.\n" +
                "5. Repeat for the recommended amount of repetitions.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "None");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Bench Dips");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Calisthenics");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Push");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. For this exercise you will need to place a bench behind your back. With the bench perpendicular to your body, and while looking away from it, hold on to the bench on its edge with the hands fully extended, separated at shoulder width. The legs will be extended forward, bent at the waist and perpendicular to your torso. This will be your starting position.\n" +
                "2. Slowly lower your body as you inhale by bending at the elbows until you lower yourself far enough to where there is an angle slightly smaller than 90 degrees between the upper arm and the forearm. Tip: Keep the elbows as close as possible throughout the movement. Forearms should always be pointing down.\n" +
                "3. Using your triceps to bring your torso up again, lift yourself back to the starting position.\n" +
                "4. Repeat for the recommended amount of repetitions.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "None");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Dips - Chest Version");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Calisthenics");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Push");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. For this exercise you will need access to parallel bars. To get yourself into the starting position, hold your body at arms length (arms locked) above the bars.\n" +
                "2. While breathing in, lower yourself slowly with your torso leaning forward around 30 degrees or so and your elbows flared out slightly until you feel a slight stretch in the chest.\n" +
                "3. Once you feel the stretch, use your chest to bring your body back to the starting position as you breathe out. Tip: Remember to squeeze the chest at the top of the movement for a second.\n" +
                "4. Repeat the movement for the prescribed amount of repetitions.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "None");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Dips - Triceps Version");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Calisthenics");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Push");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. To get into the starting position, hold your body at arm's length with your arms nearly locked above the bars.\n" +
                "2. Now, inhale and slowly lower yourself downward. Your torso should remain upright and your elbows should stay close to your body. This helps to better focus on tricep involvement. Lower yourself until there is a 90 degree angle formed between the upper arm and forearm.\n" +
                "3. Then, exhale and push your torso back up using your triceps to bring your body back to the starting position.\n" +
                "4. Repeat the movement for the prescribed amount of repetitions.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "None");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Neutral-Grip Pull Ups");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Calisthenics");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Pull");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Take a neutral grip on parallel pull-up bars, hanging freely with your arms extended. This will be your starting position.\n" +
                "2. Pull yourself up by flexing the elbows and extending the glenohumeral joint. Do not swing or use momentum to complete the movement. Attempt to get your chin above your hands.\n" +
                "3. Pause at the top of the motion before lowering yourself to the starting position. ");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "None");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Pullups");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Calisthenics");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Pull");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Grab the pull-up bar with the palms facing forward using the prescribed grip. Note on grips: For a wide grip, your hands need to be spaced out at a distance wider than your shoulder width. For a medium grip, your hands need to be spaced out at a distance equal to your shoulder width and for a close grip at a distance smaller than your shoulder width.\n" +
                "2. As you have both arms extended in front of you holding the bar at the chosen grip width, bring your torso back around 30 degrees or so while creating a curvature on your lower back and sticking your chest out. This is your starting position.\n" +
                "3. Pull your torso up until the bar touches your upper chest by drawing the shoulders and the upper arms down and back. Exhale as you perform this portion of the movement. Tip: Concentrate on squeezing the back muscles once you reach the full contracted position. The upper torso should remain stationary as it moves through space and only the arms should move. The forearms should do no other work other than hold the bar.\n" +
                "4. After a second on the contracted position, start to inhale and slowly lower your torso back to the starting position when your arms are fully extended and the lats are fully stretched.\n" +
                "5. Repeat this motion for the prescribed amount of repetitions.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "None");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Inverted Row");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Calisthenics");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Pull");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Position a bar in a rack to about waist height. You can also use a smith machine.\n" +
                "2. Take a wider than shoulder width grip on the bar and position yourself hanging underneath the bar. Your body should be straight with your heels on the ground with your arms fully extended. This will be your starting position.\n" +
                "3. Begin by flexing the elbow, pulling your chest towards the bar. Retract your shoulder blades as you perform the movement.\n" +
                "4. Pause at the top of the motion, and return yourself to the start position.\n" +
                "5. Repeat for the desired number of repetitions.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "None");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Crunches");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Calisthenics");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Pull");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Lie flat on your back with your feet flat on the ground, or resting on a bench with your knees bent at a 90 degree angle. If you are resting your feet on a bench, place them three to four inches apart and point your toes inward so they touch.\n" +
                "2. Now place your hands lightly on either side of your head keeping your elbows in. Tip: Don't lock your fingers behind your head.\n" +
                "3. While pushing the small of your back down in the floor to better isolate your abdominal muscles, begin to roll your shoulders off the floor.\n" +
                "4. Continue to push down as hard as you can with your lower back as you contract your abdominals and exhale. Your shoulders should come up off the floor only about four inches, and your lower back should remain on the floor. At the top of the movement, contract your abdominals hard and keep the contraction for a second. Tip: Focus on slow, controlled movement - don't cheat yourself by using momentum.\n" +
                "5. After the one second contraction, begin to come down slowly again to the starting position as you inhale.\n" +
                "6. Repeat for the recommended amount of repetitions.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "None");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Hanging Leg Raise");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Calisthenics");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Pull");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Hang from a chin-up bar with both arms extended at arms length in top of you using either a wide grip or a medium grip. The legs should be straight down with the pelvis rolled slightly backwards. This will be your starting position.\n" +
                "2. Raise your legs until the torso makes a 90-degree angle with the legs. Exhale as you perform this movement and hold the contraction for a second or so.\n" +
                "3. Go back slowly to the starting position as you breathe in.\n" +
                "4. Repeat for the recommended amount of repetitions.");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "None");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Lunges");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Calisthenics");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Pull");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "1. Stand erect with your feet hip-width apart, chest out, and shoulders back, maintaining the natural curvature of your spine. Your knees should be unlocked and your hand on your hips. This is your starting position.\n" +
                "2. Take a moderate-length step forward with one foot, descending to a point in which your rear knee approaches the floor without touching, maintaining your body's upright posture. Your front knee should bend about 90 degrees, but for knee health it should not be forward of the vertical plane that extends straight up from your toes. If so, take a slightly longer step.\n" +
                "3. From the bottom position, push back up from your forward foot, bringing it back beside the other.\n" +
                "4. Repeat on the opposite side for the required number of repetitions. ");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "None");
        list.add(cv);

        //insert all data in one transaction
        try {
            db.beginTransaction();
            //clear the table first
            db.delete(ExerciseContract.ExerciseEntry.TABLE_NAME, null, null);
            //go through the list and add one by one
            for (ContentValues c : list) {
                db.insert(ExerciseContract.ExerciseEntry.TABLE_NAME, null, c);
            }
            db.setTransactionSuccessful();
        } catch (SQLException e) {
            //too bad :(
        } finally {
            db.endTransaction();
        }

    }
}