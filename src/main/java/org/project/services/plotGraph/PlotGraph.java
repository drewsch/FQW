package org.project.services.plotGraph;

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
        int width = 600;
        int height = 500;
        String title = "Sample Figure";
        String x_axis = "Time";
        String y_axis = "Signal";
        fig = new Plotting(width, height, title, x_axis, y_axis);
        fig.initialisePlot();
    }
    private void signalChebushevBandPassPlot(double[][] arrayFromDataFormatter) {
        int filterType = 1; //Can be 1 (for type 1) or 2 (for type 2)
        double rippleFactor = 1; //maximum ripple allowed below unity gain
        int order = 4; //order of the filter

        Chebyshev flt = new Chebyshev(fs, rippleFactor, filterType);
        double[] result = flt.bandPassFilter(arrayFromDataFormatter[0], order, lowCutOff, highCutOff); //get the result after filtering

        fig.addSignal("Signal before ", arrayFromDataFormatter[1], arrayFromDataFormatter[0], false);
        fig.addSignal("Signal after ", arrayFromDataFormatter[1], result, false);
        fig.plot();
    }

    private void signalSimplePlot(double[][] arrayFromDataFormatter) {
        fig.addSignal("Signal 1" , arrayFromDataFormatter[0], arrayFromDataFormatter[1], false);
        fig.plot();
    }

    public void signalPlot(String strFormatFile, boolean isWithFilter) {
        parametersGraph();
        try {
            if (isWithFilter) {
                signalChebushevBandPassPlot(formatter.format(strFormatFile));
            } else {
                signalSimplePlot(formatter.format(strFormatFile));
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

