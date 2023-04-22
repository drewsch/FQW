package org.project.services.plotGraph;

import com.github.psambit9791.jdsp.filter.Chebyshev;
import com.github.psambit9791.jdsp.misc.Plotting;
import org.project.services.fileFormatter.DataFormatter;

import javax.swing.JFrame;
import java.io.IOException;

public class PlotGraph extends JFrame {
    private DataFormatter formatter = new DataFormatter();
    private Plotting fig;

    public void dataGraphFilterOne(String strFormatFile) {
        parametersGraph();
        try {
            changeSignal(formatter.format(strFormatFile));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }


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
    private void changeSignal(double[][] arrayFromDataFormatter) {
        //Sampling Frequency in Hz
        int fs = 150;
        //maximum ripple allowed below unity gain
        double rippleFactor = 1;
        //Can be 1 (for type 1) or 2 (for type 2)
        int filterType = 1;
        Chebyshev flt = new Chebyshev(fs, rippleFactor, filterType);
        //Cut-off Frequency
        int cutOff = 5;
        //order of the filter
        int order = 4;
        double[] result = flt.lowPassFilter(arrayFromDataFormatter[0], order, cutOff); //get the result after filtering
        fig.addSignal("Signal 1", arrayFromDataFormatter[0], arrayFromDataFormatter[1], false);
        fig.addSignal("Signal 2", result, arrayFromDataFormatter[1], false);
        fig.plot();
    }

    private void dataGraphWithoutFilter(double[][] arrayFromDataFormatter) {
        fig.addSignal("Signal 1" , arrayFromDataFormatter[0], arrayFromDataFormatter[1], false);
        fig.plot();
    }

    public void dataGraphWithoutFilter(String strFormatFile) {
        parametersGraph();
        try {
            dataGraphWithoutFilter(formatter.format(strFormatFile));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }


    }
}

