package org.project.services.calculationAlgorithmFQ;

import org.project.services.fileFormatter.DataFormatter;

import java.io.IOException;


public class PreparedCalculationItem {
    private final DataFormatter dataFormatter = new DataFormatter();
    private String strFormat;
    private double arrData[][];

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
        arrayAmplFreq = new double[2][arrayFromData.length];
        for (int i = 0; i < arrayFromData.length - 1; i++) {
            arrayAmplFreq[1][i] = fmin + i * delF; // freq
        }
        for (int i = 0; i < arrayFromData.length - 1; i++) {
            double[] amplitude = arrayFromData[i];
            arrayAmplFreq[0][i] = setAmplitude(amplitude); // amplitude
        }
    }

    private double setAmplitude(double[] amplitude) {
        double Umax = 0, Umin = 0;
        for (double v : amplitude) {
            if (v > 0) {
                Umax += v;
            } else {
                Umin += v;
            }
        }
        return (Umax / amplitude.length - Umin / amplitude.length) / 2;
    }


    public void startData(String strFormat) {
        try {
            createData(dataFormatter.format(strFormat));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
