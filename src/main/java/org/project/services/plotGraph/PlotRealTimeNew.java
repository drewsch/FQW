package org.project.services.plotGraph;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;


public class PlotRealTimeNew {

    private XYChart chart;
    private SwingWrapper<XYChart> sw;

    private double[][] state;
    private final JFrame swFrame;

    private double lastStep = 0.0;

    private PlotRealTimeNew(XYChart chart, SwingWrapper<XYChart> swingWrapper, double[][] initData, JFrame swFrame) {
        this.chart = chart;
        this.sw = swingWrapper;
        this.state = initData;
        this.swFrame = swFrame;
        swFrame.setLocation(1250, 500);
    }

    public static PlotRealTimeNew instance(Component[] component) {
        double[] data = new double[]{PlotRealTimeNew.fetchData(component)};

        double[][] initData = new double[][]{new double[]{0.0}, data}; //TODO вместо хардкода добавить время

        final XYChart chart = QuickChart.getChart("График зависимости диэл-ой проницаемости от времени", "Time", "Eps1", "signal", initData[0], initData[1]);

        final SwingWrapper<XYChart> sw = new SwingWrapper<XYChart>(chart);
        JFrame swFrame = sw.displayChart();
        swFrame.setVisible(false);

        return new PlotRealTimeNew(chart, sw, initData, swFrame);
    }

    public void repaint(Component[] frame, double defaultStep, Component[] mainPanel, Component[] floatingPanel) throws Exception {
        double step = defaultStep;

        if (!this.swFrame.isVisible()) {
            for (Component comp : mainPanel) {
                if (comp instanceof JRadioButton radioButton && Objects.equals(radioButton.getName(), "infCalculationsRadio")) {
                    if (radioButton.isSelected()) {
                        this.swFrame.setVisible(true);
                    }
                }
            }
        }

        for (Component comp : floatingPanel) {
            if (comp instanceof JTextField textField && Objects.equals(textField.getName(), "fieldNameTau")) {
                if (!Objects.equals(textField.getText(), "0.5") && Double.parseDouble(textField.getText()) != defaultStep) {
                    step = Double.parseDouble(textField.getText());
                }
            }
        }


        ArrayList<Double> resultX = new ArrayList<Double>();
        ArrayList<Double> resultY = new ArrayList<Double>();
        this.lastStep = this.lastStep + step;

        //TODO соедиение массива со старым состоянием графика
        Thread.sleep(1000);

        final double[][] data = new double[][]{new double[]{lastStep}, new double[]{PlotRealTimeNew.fetchData(frame)}}; //TODO вместо хардкода добавить время (double) System.currentTimeMillis()
        double[][] lastData = this.state;
        int lastItemIndex = Math.max(lastData[1].length - 1, 0);

        if (data[1][0] != 0.0) { //TODO если данные не 0.0, 0.0

            if ((lastItemIndex > 0 && data[1][0] != lastData[1][lastItemIndex]) || lastItemIndex == 0) {

                for (int i = 0; i < lastData[0].length; i++) {
                    resultX.add(lastData[0][i]);
                }

                for (int i = 0; i < lastData[1].length; i++) {
                    resultY.add(lastData[1][i]);
                }

                resultX.add(data[0][0]);
                resultY.add(data[1][0]);

                double[] stateY = resultY.stream().mapToDouble(Double::doubleValue).toArray(); // не перезаписывать, а менять (добавлять в конец)
                double[] stateX = resultX.stream().mapToDouble(Double::doubleValue).toArray(); // не перезаписывать, а менять (добавлять в конец)

                System.out.println("test");
                System.out.println(Arrays.toString(stateX));

                this.state = new double[][]{stateX, stateY};

                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        chart.updateXYSeries("signal", resultX, resultY, null);
                        sw.repaintChart();
                    }
                });
            } else {
                this.lastStep -= step;
            }
        } else {
            this.lastStep -= step;
        }
    }

    private static double fetchData(Component[] frame) {
        double realEpsValue = 0, impEpsValue = 0;
        for (Component component : frame) {
            if (component instanceof JTextField textField && Objects.equals(textField.getName(), "epsReal")) {
                realEpsValue = Double.parseDouble(textField.getText());
            }
//            else if (component instanceof JTextField textField && Objects.equals(textField.getName(), "epsImp")) {
//                impEpsValue = Double.parseDouble(textField.getText());
//            }
        }

        return realEpsValue;
    }
}

