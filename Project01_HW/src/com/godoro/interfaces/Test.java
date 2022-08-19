package com.godoro.interfaces;

public class Test {
    public static void main(String[] args) {

        IdentityFunction f1 = new IdentityFunction();
        FunctionDrawer drawer = new FunctionDrawer();
        drawer.draw(f1,10,15,100);

        QuadraticPolynomial quadraticPolynomial = new QuadraticPolynomial();
        drawer.draw(quadraticPolynomial, -5, 5, 100);

        SinusoidalPolynomial sinusoidalPolynomial = new SinusoidalPolynomial();
        drawer.draw(sinusoidalPolynomial, -Math.PI, Math.PI, 100);
    }
}
