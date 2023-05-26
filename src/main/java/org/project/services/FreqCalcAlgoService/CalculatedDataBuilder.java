package org.project.services.FreqCalcAlgoService;

import org.project.services.calculationAlgorithmFQ.PreparedCalculationItem;

public class CalculatedDataBuilder {
    private double F0; //Math.pow(10,9);
    private double Q;
    private PreparedCalculationItem preparedCalculationItem;
    private double[] arrA;
    private double[] arrF;
    private double maxValueAmpl = 0;
    private int keyMaxAmpl;
    private int keyFirst0707;
    private int keySecond0707;

    public CalculatedDataBuilder(PreparedCalculationItem preparedCalculationItem) {
        this.preparedCalculationItem = preparedCalculationItem;
    }

    public CalculatedData build() {
        return new CalculatedData(this.calcMaxAmplFreqRes(), this.calculateQ());
    }

    private double calcMaxAmplFreqRes() {
        arrA = preparedCalculationItem.getArrayAmplFreq()[0];
        for (int i = 0; i < arrA.length - 1; i++) {
            if (arrA[i] > maxValueAmpl) {
                maxValueAmpl = arrA[i];
                keyMaxAmpl = i;
            }
        }

        arrF = preparedCalculationItem.getArrayAmplFreq()[1];
        return arrF[keyMaxAmpl];
    }

    private double calculateQ() {
        return F0 / searchDifferenceFrequency();
    }

    private double searchDifferenceFrequency() {
        double ampl0707 = maxValueAmpl * 0.707;
        for (int i = 0; i < maxValueAmpl; i++) {
            if (arrA[i] > ampl0707) {
                keyFirst0707 = i;
                break;
            }
        }
        for (int i = keyMaxAmpl; i < arrA.length - 1; i++) {
            if (arrA[i] > ampl0707) {
                keySecond0707 = i;
            }
        }

        return arrF[keySecond0707] - arrF[keyFirst0707];
    }
}
