package org.project.services.calculationAlgorithmFQ;

public class CalculationAlgorithm {
    private double F0; //Math.pow(10,9);
    private double Q;
    private PreparedCalculationItem preparedCalculationItem;
    private double[] arrA;
    private double[] arrF;
    private double maxValueAmpl = 0;
//    private int keyMaxAmpl;
//    private int keyFirst0707;
//    private int keySecond0707;
//
//
//    public CalculationAlgorithm(PreparedCalculationItem preparedCalculationItem) {
//        this.preparedCalculationItem = preparedCalculationItem;
//    }
//
//    private void calculateQ() {
//        Q = F0/searchDifferenceFrequency();
//    }
//    private void maxAmplFreqRes() {
//        arrA = preparedCalculationItem.getArrayAmplFreq()[0];
//        for (int i = 0; i < arrA.length - 1; i++) {
//            if (arrA[i] > maxValueAmpl) {
//                maxValueAmpl = arrA[i];
//                keyMaxAmpl = i;
//            }
//        }
//
//        arrF = preparedCalculationItem.getArrayAmplFreq()[1];
//        F0 = arrF[keyMaxAmpl];
//    }
//
//    private double searchDifferenceFrequency() {
//        maxAmplFreqRes();
//        double ampl0707 = maxValueAmpl * 0.707;
//        for (int i = 0; i < maxValueAmpl; i++) {
//            if (arrA[i] > ampl0707) {
//                keyFirst0707 = i;
//                break;
//            }
//        }
//        for (int i = keyMaxAmpl; i < arrA.length - 1; i++) {
//            if (arrA[i] > ampl0707) {
//                keySecond0707 = i;
//            }
//        }
//
//        return arrF[keySecond0707] - arrF[keyFirst0707];
//    }

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
