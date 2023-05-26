package org.project.services.FreqCalcAlgoService;

import org.project.services.fileFormatter.DataFormatter;

import java.io.IOException;
import java.util.Arrays;


public class PreparedCalculationItem {
    private final DataFormatter dataFormatter = new DataFormatter();

    private double[][] arrayAmplFreq;

    private double delF = 1;
    private int fmin = 3;

    public PreparedCalculationItem(String filePath) {
        this.startData(filePath);
    }

    public double[][] getArrayAmplFreq() {
        return arrayAmplFreq;
    }

    public void setDelF(double delF) {
        this.delF = delF;
    }

    public void setFmin(int fmin) {
        this.fmin = fmin;
    }

    private void createData(double[][] arrayFromData) {
        arrayAmplFreq = new double[2][arrayFromData.length - 1];
        for (int i = 0; i < arrayFromData.length - 1; i++) {
            arrayAmplFreq[1][i] = fmin + i * delF; // freq
            arrayAmplFreq[0][i] = setAmplitude(arrayFromData[i]); // amplitude
        }
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
