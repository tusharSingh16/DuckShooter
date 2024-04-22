package levels;

public class Level { // Declaring the public class 'Level'
    protected int curLevel;
    protected int totalSpan;
    protected int speedMin;
    protected int speedMax;
    protected int spanSpeedMin;
    protected int spanSpeedMax;

     // Constructor for the 'Level' class
    public Level() {
        // Initializing instance variables with default values
        curLevel = 1;
        totalSpan = 3;
        speedMin = 10;
        speedMax = 12;
        spanSpeedMin = 3000;
        spanSpeedMax = 5000;
    }

     // Method to update the level parameters
    public void updateLevel() {
        curLevel++; // Incrementing the current level
        totalSpan += 1; // Incrementing the total span
        speedMin -= 1; // Decreasing the minimum speed
        speedMax -= 1; // Decreasing the maximum speed

        //Adjusting speed values to ensure that they don't go below certain thresholds
        if (speedMin-1 <= 0) {
            speedMin = 1;
            speedMax = 3;
        } else {
            speedMin -= 2;
            speedMax -= 2;
        }
         // Adjusting span speed values to ensure they don't go below certain thresholds
        if (spanSpeedMin-500 <= 0) {
            spanSpeedMin = 1000;
            spanSpeedMax = 2000;
        } else {
            spanSpeedMin -= 400;
            spanSpeedMax -= 400;
        }

    }

}