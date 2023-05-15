package org.project.services.plotGraph;

import com.github.psambit9791.jdsp.filter.Butterworth;
import com.github.psambit9791.jdsp.misc.Plotting;
import org.project.services.fileFormatter.DataFormatter;

import java.io.IOException;

public class PlotGraph {
    private DataFormatter formatter = new DataFormatter();
    private Plotting fig;
    private int fs = 166;//Sampling Frequency in Hz
    private int lowCutOff = 10; //Lower Cut-off Frequency
    private double freqQuantity;
    private double delF = 3;
    private double[][] arrayFreq;
    private int fmax = 12;
    private int fmin = 3;

    private int highCutOff = 50; //Higher Cut-off Frequency

    public void setFs(int fs) {
        this.fs = fs;
    }

    public void setLowCutOff(int lowCutOff) {
        this.lowCutOff = lowCutOff;
    }

    public void setHighCutOff(int highCutOff) {
        this.highCutOff = highCutOff;
    }

    private void parametersGraph() {
        int width = 1400;
        int height = 800;
        String title = "Sample Figure";
        String x_axis = "Time";
        String y_axis = "Signal";
        fig = new Plotting(width, height, title, x_axis, y_axis);
        fig.initialisePlot();
        fig.addStylerCursor();
    }

    private void signalButterworthBandPassPlot(double[][] arrayFromDataFormatter) {
        int order = 4; //order of the filter
        arrayFreq = new double[2][arrayFromDataFormatter.length - 1]; //setFreqQuantity
        Butterworth flt = new Butterworth(fs);
        for (int j = 0; j < 3; j++) { // j < setFreqQuantity()
            double[] amplitude = flt.bandPassFilter(arrayFromDataFormatter[j], order, lowCutOff, highCutOff);
            arrayFreq[0][j] = setAmplitude(amplitude);
        }

        for (int i = 0; i < 3; i++) {
            arrayFreq[1][i] = fmin + i * delF;
        }
        fig.addSignal("Signal Ampl/Freq", arrayFreq[1],arrayFreq[0], true );
        fig.plot();


    }

    private void signalSimplePlot(double[][] arrayFromDataFormatter) {
        fig.addSignal("Signal 1", arrayFromDataFormatter[0], arrayFromDataFormatter[1], false);
        fig.plot();

    }

    public void signalPlot(String strFormatFile, boolean isWithFilter) {
        parametersGraph();
        try {
            if (isWithFilter) {
                signalButterworthBandPassPlot(formatter.format(strFormatFile));
            } else {
                signalSimplePlot(formatter.format(strFormatFile));
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private double setFreqQuantity() {
        freqQuantity = (fmax - fmin) / delF;
        return freqQuantity;
    }

    private double setAmplitude(double[] amplitude) {
        double Umax = 0, Umin = 0;
        for (int i = 0; i < amplitude.length; i++) {
            if (amplitude[i] > 0) {
                Umax += amplitude[i];
            } else {
                Umin += amplitude[i];
            }
        }
        return (Umax/amplitude.length - Umin/amplitude.length) / 2;
    }
}

