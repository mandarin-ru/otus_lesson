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

    public double[] solve() throws ArithmeticException, NullPointerException {
        double e = 0.00002;
        if (Math.abs(this.a) < e){
            throw new ArithmeticException("Аргумент А не может быть равен 0");
        }
        if(Double.isNaN(this.a) || Double.isNaN(this.b) || Double.isNaN(this.c)){
            throw new NullPointerException("Коэффицент не может быть пустым");
        }

        if(Double.isInfinite(this.a) || Double.isInfinite(this.b) || Double.isInfinite(this.c)){
            throw new NullPointerException("Коэффицент не может быть пустым");
        }

        double d = this.b * this.b - 4 * this.a * this.c;
        double x1 = 0;
        double x2 = 0;
        if (d > e) {
            x1 = this.b * (-1) + Math.sqrt(d) / (2 * this.a);
            x2 = this.b * (-1) - Math.sqrt(d) / (2 * this.a);
        } else if (Math.abs(d) < e) {
            x1 = x2 = round(this.b / 2 * this.a * (-1), 4);
        }
        return new double[]{x1, x2};
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}