package org.project.services.plotGraph;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class PlotRealTimeNew {

    private final XYChart chart;
    private final SwingWrapper<XYChart> sw;

    private PlotRealTimeNew(XYChart chart, SwingWrapper<XYChart> swingWrapper) {

        this.chart = chart;
        this.sw = swingWrapper;
    }

    public static PlotRealTimeNew instance(Container frame) {
        double[] data = PlotRealTimeNew.fetchData(frame);

        double[][] initData = new double[][]{data, new double[]{123.123, 123.321}}; //TODO вместо хардкода добавить время

        final XYChart chart = QuickChart.getChart("Simple XChart Real-time Demo", "Radians", "Sine", "sine", initData[0], initData[1]);

        final SwingWrapper<XYChart> sw = new SwingWrapper<XYChart>(chart);

        sw.displayChart();

        return new PlotRealTimeNew(chart, sw);
    }

    public void repaint(Container frame, double[][] oldState) throws Exception { //, step, globalTime
//        globalTime / step === maxStepsCount
//
//        if (data.count() < maxStepsCount) {
//            vseOk .... stroim grafik
//        } else {
//            ydalyaemn pervuyu tochku
//        }
        Thread.sleep(1000);

        final double[][] data = new double[][]{PlotRealTimeNew.fetchData(frame), new double[]{321.123, 123.321}}; //TODO вместо хардкода добавить время
        if (true) { //TODO если данные не 0.0, 0.0
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    chart.updateXYSeries("sine", data[0], data[1], null);
                    sw.repaintChart();
                }
            });
        }
    }

    private static double[] fetchData(Container frame) {
        double realEpsValue = 0, impEpsValue = 0;
        for (Component component : frame.getComponents()) { //TODO разобраться с получением значений из тектовых полей
            if (component instanceof JTextField textField && Objects.equals(textField.getName(), "epsReal")) {
                realEpsValue = Double.parseDouble(textField.getText());
            } else if (component instanceof JTextField textField && Objects.equals(textField.getName(), "epsImpl")) {
                impEpsValue = Double.parseDouble(textField.getText());
            }
        }

        System.out.println(realEpsValue + ":" + impEpsValue);
        return new double[]{realEpsValue, impEpsValue};
    }
}
