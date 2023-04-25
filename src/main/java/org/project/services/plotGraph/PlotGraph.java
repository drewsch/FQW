package org.project.services.plotGraph;

import com.github.psambit9791.jdsp.filter.Chebyshev;
import com.github.psambit9791.jdsp.misc.Plotting;
import org.knowm.xchart.SwingWrapper;
import org.project.services.fileFormatter.DataFormatter;
import org.knowm.xchart.internal.chartpart.Chart;

import java.awt.*;

import java.io.IOException;

public class PlotGraph {
    private DataFormatter formatter = new DataFormatter();
    private Plotting fig;

    private void parametersGraph() {
        int width = 600;
        int height = 500;
        String title = "Sample Figure";
        String x_axis = "Time";
        String y_axis = "Signal";
        fig = new Plotting(width, height, title, x_axis, y_axis);
        fig.initialisePlot();

    }
    private void changeSignal(double[][] arrayFromDataFormatter) {
        int filterType = 1; //Can be 1 (for type 1) or 2 (for type 2)
        double rippleFactor = 1; //maximum ripple allowed below unity gain
        int Fs = 166; //Sampling Frequency in Hz
        int order = 4; //order of the filter
        int lowCutOff = 10; //Lower Cut-off Frequency
        int highCutOff = 50; //Higher Cut-off Frequency
        Chebyshev flt = new Chebyshev(Fs, rippleFactor, filterType);
        double[] result = flt.bandPassFilter(arrayFromDataFormatter[0], order, lowCutOff, highCutOff); //get the result after filtering
        fig.addSignal("Signal 1", arrayFromDataFormatter[1], arrayFromDataFormatter[0], false);
        fig.addSignal("Signal 2", arrayFromDataFormatter[1], result, false);
        fig.plot();
    }

    private void dataGraphFormat(double[][] arrayFromDataFormatter) {
        fig.addSignal("Signal 1" , arrayFromDataFormatter[0], arrayFromDataFormatter[1], false);
        fig.plot();
    }

    public void dataGraphFormat(String strFormatFile, boolean isWithFilter) {
        parametersGraph();
        try {
            if (isWithFilter) {
                changeSignal(formatter.format(strFormatFile));
            } else {
                dataGraphFormat(formatter.format(strFormatFile));
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

