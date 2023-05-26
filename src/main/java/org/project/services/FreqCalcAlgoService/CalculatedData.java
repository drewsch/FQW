package org.project.services.FreqCalcAlgoService;

public class CalculatedData {
    private final double Q;
    private final double F0;

    public CalculatedData(double F0, double Q) {
        this.F0 = F0;
        this.Q = Q;
    }

    public double getF0() {
        return F0;
    }

    public double getQ() {
        return Q;
    }

    public double getA1() {
        return F0;
    }

    public double getA2() {
        return Q;
    }

    public double getA3() {
        return Math.pow(F0, 2);
    }

    public double getA4() {
        return Math.pow(Q, 2);
    }

    public double getA5() {
        return F0 * Q;
    }

    public double getA6() {
        return Math.pow(F0, 3);
    }

    public double getA7() {
        return Math.pow(Q, 3);
    }

    public double getA8() {
        return Math.pow(F0, 2) * Q;
    }

    public double getA9() {
        return Math.pow(Q, 2) * F0;
    }
}
