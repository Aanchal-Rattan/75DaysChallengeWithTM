class Solution {
    public double angleClock(int hour, int minutes) {
        double prev = (hour * 5) % 60;
        if (minutes != 0)
            prev += 5 * ((6 * (minutes)) / 360.0);
        double ab = Math.abs(minutes - prev);
        return (ab < (60 - ab)) ? ab * 6 : (60 - ab) * 6;
    }
}