package ru.kargin;

import java.io.IOException;
public class Module {

    private double x1;
    private double x2;
    private double a;
    private double b;
    private double c;

    public static void main(String[] args) {
    }

    public Module(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] solve() throws ArithmeticException {
        double e = 0.00002;
        if ((Math.abs(this.a) < e)){
            throw new ArithmeticException("000000!");
        }
        double d = this.b * this.b - 4 * this.a * this.c;
        double x1 = 0;
        double x2 = 0;
        if (d > 0) {
            x1 = this.b * (-1) + Math.sqrt(d) / (2 * this.a);
            x2 = this.b * (-1) - Math.sqrt(d) / (2 * this.a);
        } else if (d == 0) {
            x1 = x2 = this.b / 2 * this.a * (-1);
        }
        return new double[]{x1, x2};
    }
}