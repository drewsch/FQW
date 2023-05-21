package org.project.services.calculationAlgorithmFQ;

public class CalculationAlgorithm {
    private double F0 = 1.56 * Math.pow(10,9);
    private double Q = 86.227;

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
        return Math.pow(F0,2);
    }
    public double getA4() {
        return Math.pow(Q,2);
    }
    public double getA5() {
        return F0 * Q;
    }
    public double getA6() {
        return Math.pow(F0,3);
    }
    public double getA7() {
        return Math.pow(Q,3);
    }
    public double getA8() {
        return Math.pow(F0,2) * Q;
    }
    public double getA9() {
        return Math.pow(Q,2) * F0;
    }

}
