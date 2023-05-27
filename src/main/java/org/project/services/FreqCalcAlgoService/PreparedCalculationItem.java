package org.project.services.FreqCalcAlgoService;

import org.project.services.fileFormatter.DataFormatter;

import java.io.IOException;
import java.util.Arrays;


public class PreparedCalculationItem {
    private final DataFormatter dataFormatter = new DataFormatter();

    private double[][] arrayAmplFreq;

    private double delF;
    private double fmin;

    public PreparedCalculationItem(String filePath, double fmin, double delF) {
        this.delF = delF;
        this.fmin = fmin;
        this.startData(filePath);
    }

    public double[][] getArrayAmplFreq() {
        return arrayAmplFreq;
    }

    private void createData(double[][] arrayFromData) {
        arrayAmplFreq = new double[2][arrayFromData.length - 1];
        for (int i = 0; i < arrayFromData.length - 1; i++) {
            arrayAmplFreq[1][i] = this.fmin + i * this.delF; // freq
            arrayAmplFreq[0][i] = setAmplitude(arrayFromData[i]); // amplitude
        }
        System.out.println(Arrays.toString(arrayAmplFreq[1]));
    }
    private double setAmplitude(double[] amplitude) {
        double sum = 0;
        for (double v : amplitude) {
            sum += Math.abs(v);
        }
        return sum / amplitude.length;
    }
    public void startData(String strFormat) {
        try {
            createData(dataFormatter.format(strFormat));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
