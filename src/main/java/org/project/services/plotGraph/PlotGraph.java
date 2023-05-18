package org.project.services.plotGraph;

import com.github.psambit9791.jdsp.filter.Butterworth;
import com.github.psambit9791.jdsp.filter.Chebyshev;
import com.github.psambit9791.jdsp.misc.Plotting;
import org.project.services.fileFormatter.DataFormatter;

import java.io.IOException;

public class PlotGraph {
    private DataFormatter formatter = new DataFormatter();
    private Plotting fig;
    private int fs = 166;//Sampling Frequency in Hz
    private int lowCutOff = 10; //Lower Cut-off Frequency

    private int highCutOff = 50; //Higher Cut-off Frequency
    private double freqQuantity;
    private double delF = 1;
    private double[][] arrayFreqAmpl;
    private int fmax = 12;
    private int fmin = 3;

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
        String x_axis = "Frequency";
        String y_axis = "Signal";
        fig = new Plotting(width, height, title, x_axis, y_axis);
        fig.initialisePlot();
        fig.addStylerCursor();
    }
    private void signalButterworthBandPassPlot(double[][] arrayFromDataFormatter) {
        arrayFreqAmpl = new double[2][arrayFromDataFormatter.length - 1];
        Butterworth butterworth = new Butterworth(fs);
        int order = 4; //order of the filter

        for (int i = 0; i < arrayFromDataFormatter.length -1; i++ ){
            double[] amplitude = butterworth.bandPassFilter(arrayFromDataFormatter[i], order, lowCutOff, highCutOff);
            arrayFreqAmpl[0][i] = setAmplitude(amplitude);
        }

        for (int i = 0; i < arrayFromDataFormatter.length - 1; i++) {
            arrayFreqAmpl[1][i] = fmin + i * delF;
        }

        fig.addSignal("Signal before ", arrayFreqAmpl[1], arrayFreqAmpl[0], false);
        fig.plot();
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
        return (Umax/amplitude.length - Umin/amplitude.length) / 2;
    }

    private void signalSimplePlot(double[][] arrayFromDataFormatter) {
        fig.addSignal("Signal 1" , arrayFromDataFormatter[0], arrayFromDataFormatter[1], false);
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
}

