package org.project.services.FreqCalcAlgoService;

public class CalculatedDataBuilder {
    private final PreparedCalculationItem preparedCalculationItem;
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
        double F0 = this.calcMaxAmplFreqRes();
        return new CalculatedData(F0, this.calculateQ(F0));
    }

    private double calcMaxAmplFreqRes() {
        arrA = preparedCalculationItem.getArrayAmplFreq()[0];
        for (int i = 0; i < arrA.length - 1; i++) {
            if (arrA[i] > maxValueAmpl) {
                maxValueAmpl = arrA[i];
                keyMaxAmpl = i;
            }
        }

        arrF = this.preparedCalculationItem.getArrayAmplFreq()[1];
        return arrF[keyMaxAmpl];
    }

    private double calculateQ(double F0) {
        return F0 / searchDifferenceFrequency();
    }

    private double searchDifferenceFrequency() {
        double ampl0707 = maxValueAmpl * 0.707;
        for (int i = 0; arrA[i] < maxValueAmpl; i++) {
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
