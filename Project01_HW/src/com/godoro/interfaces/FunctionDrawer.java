package com.godoro.interfaces;

public class FunctionDrawer implements MathFunction {
    
    void draw(MathFunction function, double x1, double x2, int n) {
        double dx = (x2 - x1) / n; 
        System.out.println("inline");
        for (double x = x1; x <= x2; x += dx) {
            double y = function.evaluate(x);
            System.out.println(x + " . " + y);
        }
    }

    @Override
    public double evaluate(double x) {
        return x;
    }
    
}
