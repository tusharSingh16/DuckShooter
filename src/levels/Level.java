package levels;

public class Level {
    protected int curLevel;
    protected int totalSpan;
    protected int speedMin;
    protected int speedMax;
    protected int spanSpeedMin;
    protected int spanSpeedMax;

    public Level() {
        curLevel = 1;
        totalSpan = 3;
        speedMin = 10;
        speedMax = 12;
        spanSpeedMin = 3000;
        spanSpeedMax = 5000;
    }

    public void updateLevel() {
        curLevel++;
        totalSpan += 1;
        speedMin -= 1;
        speedMax -= 1;

        if (speedMin-1 <= 0) {
            speedMin = 1;
            speedMax = 3;
        } else {
            speedMin -= 2;
            speedMax -= 2;
        }

        if (spanSpeedMin-500 <= 0) {
            spanSpeedMin = 1000;
            spanSpeedMax = 2000;
        } else {
            spanSpeedMin -= 400;
            spanSpeedMax -= 400;
        }

    }

}