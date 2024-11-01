package org.alvin.leet.code;

public class Solution50 {

    public double myPow(double x, int n) {
        return n > 0 ? pow(x, n) : 1 / pow(x, -n);
    }

    private double pow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }

        double y = pow(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

}
