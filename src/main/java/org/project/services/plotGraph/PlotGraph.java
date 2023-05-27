package org.project.services.plotGraph;

import com.github.psambit9791.jdsp.filter.Butterworth;
import com.github.psambit9791.jdsp.misc.Plotting;
import org.project.services.FreqCalcAlgoService.PreparedCalculationItem;
import org.project.services.fileFormatter.DataFormatter;

import java.util.Arrays;

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
        Butterworth butterworth = new Butterworth(fs);
        int order = 4; //order of the filter
        System.out.println(Arrays.deepToString(arrayFromDataFormatter));
        double[] amplitude = butterworth.bandPassFilter(arrayFromDataFormatter[0], order, lowCutOff, highCutOff);
        fig.addSignal("Signal2", arrayFromDataFormatter[1], amplitude, false);
        fig.plot();
    }

    public void signalPlot(String strFormatFile, boolean isWithFilter, double fmin, double delF) {
        parametersGraph();
        PreparedCalculationItem calculationItem = new PreparedCalculationItem(strFormatFile, fmin, delF);
        if (isWithFilter) {
            signalButterworthBandPassPlot(calculationItem.getArrayAmplFreq());
        }
    }
}

