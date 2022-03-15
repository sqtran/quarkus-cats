package demo.steve.util;

public class DemoUtil {

    public int getOne() {
        return 1;
    }

    public int getTwo() {
        return 2;
    }

    public int getThree() {
        int sum = 0;

        while (sum != 3) {
            sum += getOne();
        }

        return sum;
    }

    public String getFour() {
        return "four";
    }

    public String getNumber(int num) {

        if (num == 1) {
            return "" + getOne();
        }
        else if (num == 2) {
            return "" + getTwo();
        }
        else if (num == 3) {
            return "" + getThree();
        }
        else if (Integer.valueOf(num) == null) {
            return "null";
        }
        else {
            return getFour();
        }
    }
}