/**
 * @author AndreyChesnokov
 */
package org.project.services;

import org.project.services.FreqCalcAlgoService.CalculatedData;
import org.project.services.FreqCalcAlgoService.CalculatedDataBuilder;
import org.project.services.ILogicalCalculationsKnownCoeff.ILogicalCalculationsKnownCoeff;
import org.project.services.UartSender.UartSender;
import org.project.services.buttonInteraction.ActionCheckBoxesOutputA;
import org.project.services.calculationAlgorithmFQ.PreparedCalculationItem;
import org.project.services.calculationLogic.CalculationCard1;
import org.project.services.calculationLogic.CalculationCard2;
import org.project.services.calculationLogic.CalculationCard2B;
import org.project.services.plotGraph.PlotGraph;
import org.project.services.plotGraph.PlotRealTimeNew;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.List;

public class GUIMainForm extends JFrame {
    private JPanel mainPanel;
    private JButton buttonSendParameters;
    private JPanel panelButtonChoosesCards;
    private JButton buttonWithUnknownCoef;
    private JPanel mainResults;
    private JPanel parentCardPanel;
    private JPanel cardKnownCoefficientsPanel;
    private JLabel labelArticleCard1;
    private JPanel inputCoefficientsPanelCard1RealE;
    private JTextField a0TextField0;
    private JTextField a1TextField1;
    private JTextField a2TextField2;
    private JTextField a3TextField3;
    private JTextField a4TextField4;
    private JRadioButton buttonUnCountinueMeas;
    private JRadioButton buttonContinueMeas;
    private JButton buttonPlotGraph;
    private JButton buttonInputParameters;
    private JButton buttonWithKnownCoef;
    private JPanel cardParameters;
    private JPanel inputParametersUART;
    private JPanel parametersFilter;
    private JCheckBox checkBoxA0;
    private JCheckBox checkBoxA1;
    private JCheckBox checkBoxA2;
    private JCheckBox checkBoxA3;
    private JCheckBox checkBoxA4;
    private JCheckBox checkBoxA5;
    private JCheckBox checkBoxA6;
    private JCheckBox checkBoxA7;
    private JCheckBox checkBoxA8;
    private JCheckBox checkBoxA9;
    private JPanel floatingPanel;
    private JButton mainButtonCard1;
    private JTextField valueRealEpsCard1;
    private JTextField valueImpEpsCard1;
    private JLabel titleEpsPanel;
    private JPanel cardUnknownCoefficientsPanel;
    private JPanel outputCoefficientsCard2;

    final private HashMap<Integer, JTextField> A_COEFS_TO_FIELDS_MAP = new HashMap<>() {{
        put(0, outputCoefA0);
        put(1, outputCoefA1);
        put(2, outputCoefA2);
        put(3, outputCoefA3);
        put(4, outputCoefA4);
        put(5, outputCoefA5);
        put(6, outputCoefA6);
        put(7, outputCoefA7);
        put(8, outputCoefA8);
        put(9, outputCoefA9);
    }};
    final private HashMap<Integer, JTextField> B_COEFC_TO_FiELDS_MAP = new HashMap<>() {{
        put(0, outputCoefB0);
        put(1, outputCoefB1);
        put(2, outputCoefB2);
        put(3, outputCoefB3);
        put(4, outputCoefB4);
        put(5, outputCoefB5);
        put(6, outputCoefB6);
        put(7, outputCoefB7);
        put(8, outputCoefB8);
        put(9, outputCoefB9);
    }};
    private JTextField outputCoefA0;
    private JTextField outputCoefA1;
    private JTextField outputCoefA2;
    private JTextField outputCoefA3;
    private JTextField outputCoefA4;
    private JCheckBox checkBoxOutA0;
    private JCheckBox checkBoxOutA1;
    private JCheckBox checkBoxOutA2;
    private JCheckBox checkBoxOutA3;
    private JCheckBox checkBoxOutA4;
    private JPanel epsOutputPanel;
    private JTextField outputCoefA5;
    private JTextField outputCoefA6;
    private JTextField outputCoefA7;
    private JTextField outputCoefA8;
    private JTextField outputCoefA9;
    private JCheckBox checkBoxOutA9;
    private JCheckBox checkBoxOutA8;
    private JCheckBox checkBoxOutA7;
    private JCheckBox checkBoxOutA6;
    private JCheckBox checkBoxOutA5;
    private JTextField quantitySamples;
    private JTextField inputImpEps;
    private JTextField inputRealEps;
    private JButton mainButtonCard2;
    private JPanel epsMainUnknownCoefCard2;
    private JPanel epsPanelInputCard2;
    private JPanel inputMeasureCard2;
    private JLabel label1Card2;
    private JSlider slider1FreqMin;
    private JSlider slider2FreqMax;
    private JSlider slider3DelFreq;
    private JSlider slider4FreqDiscr;
    private JSlider sliderFreqLower;
    private JSlider sliderFreqHigher;
    private JTextField freqMinQuantity;
    private JTextField freqMaxQuantity;
    private JTextField delFreqQuantity;
    private JTextField freqDiscrQuantity;
    private JTextField freqLowerQuantity;
    private JTextField freqHigherQuantity;
    private JTextField a5TextField5;
    private JTextField a6TextField6;
    private JTextField a7TextField7;
    private JTextField a8TextField8;
    private JTextField a9TextField9;
    private JRadioButton radioButtonContinueMeasCard2;
    private JRadioButton radioButtonUnCountinueMeasCard2;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JTextArea количествоКолЫхОбразцовTextArea;
    private JPanel inputCoefficientsPanelCard1ImpE;
    private JTextField b0TextField0;
    private JTextField b1TextField0;
    private JTextField b2TextField0;
    private JTextField b3TextField0;
    private JTextField b4TextField0;
    private JTextField b5TextField0;
    private JTextField b6TextField0;
    private JTextField b7TextField0;
    private JTextField b8TextField0;
    private JTextField b9TextField0;
    private JTextField outputCoefB0;
    private JTextField outputCoefB1;
    private JTextField outputCoefB2;
    private JTextField outputCoefB3;
    private JTextField outputCoefB4;
    private JTextField outputCoefB5;
    private JTextField outputCoefB6;
    private JTextField outputCoefB7;
    private JTextField outputCoefB8;
    private JTextField outputCoefB9;
    private JCheckBox checkBoxB0;
    private JCheckBox checkBoxB1;
    private JCheckBox checkBoxB2;
    private JCheckBox checkBoxB3;
    private JCheckBox checkBoxB4;
    private JCheckBox checkBoxB5;
    private JCheckBox checkBoxB6;
    private JCheckBox checkBoxB7;
    private JCheckBox checkBoxB8;
    private JCheckBox checkBoxB9;
    private JButton sendQuantitySamples;
    private JCheckBox checkBoxOutB0;
    private JCheckBox checkBoxOutB1;
    private JCheckBox checkBoxOutB2;
    private JCheckBox checkBoxOutB3;
    private JCheckBox checkBoxOutB4;
    private JCheckBox checkBoxOutB5;
    private JCheckBox checkBoxOutB6;
    private JCheckBox checkBoxOutB7;
    private JCheckBox checkBoxOutB8;
    private JCheckBox checkBoxOutB9;
    private JRadioButton turnOnFilters;
    private JPanel outputCoefficientsCard2B;
    private JPanel mainPanel23;
    private JLabel deltaTime;
    private JRadioButton bandPassChebyshevRadioButton;
    private JRadioButton noneRadioButton;
    private JButton startButton;
    private JPanel chooseParametersFilter;
    private JSlider sliderFrequency;
    private JLabel labelFreq;
    private JSlider sliderLower;
    private JSlider sliderHigher;
    private JLabel labelLower;
    private JLabel labelHigher;
    private final JFileChooser fc = new JFileChooser();
    private int result;
    public String strFormatFile = "data2.txt";
    private Thread mainThread = null;
    private PlotGraph plotGraph = new PlotGraph();
    private int kHz = (int) Math.pow(10, 3);
    private int GHz = (int) Math.pow(10, 9);
    private int MGz = (int) Math.pow(10, 6);
    private int clickCounter = 0;
    private int sizeClicker;
    private int counterClickButtonCard2;
    private int[][] checkCase;
    private int[][] checkCaseB;
    private CalculationCard2 calculationCard2 = new CalculationCard2();
    private CalculationCard2B calculationCard2B = new CalculationCard2B();
    private int clickCounterB;
    private double timeGraph;

    public void mainGUI() {
        GUIMainForm form = this;
        JFrame frame = new JFrame("Microwave sensors(resonant)");
        frame.setLocation(500, 250);
        frame.setPreferredSize(new Dimension(1000, 600));
        frame.setContentPane(form.mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                Object[] options = {"Да", "Нет"};
                int n = JOptionPane
                        .showOptionDialog(e.getWindow(), "Закрыть окно?",
                                "Подтверждение выхода", JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.ERROR_MESSAGE, null, options,
                                options[0]);
                if (n == 0) {
                    e.getWindow().setVisible(false);
                    System.exit(0);
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
    }

    private Thread pressF(JPanel epsOutputPanel, PlotRealTimeNew plotRealTimeNew, JPanel mainPanel) {
        Component[] components = epsOutputPanel.getComponents();

        return new Thread(() -> {
            while (true) {
                try {

                    plotRealTimeNew.repaint(components, 50, mainPanel.getComponents());

                    Thread.sleep(1000); // Delay for 1 second
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GUIMainForm() {
        parametersFilter.setVisible(false);
        buttonWithUnknownCoef.setEnabled(false);
        buttonWithKnownCoef.setEnabled(false);
        PlotRealTimeNew plotRealTimeNew = PlotRealTimeNew.instance(this.epsOutputPanel.getComponents());
        Thread repaintChartThread = pressF(this.epsOutputPanel, plotRealTimeNew, this.mainPanel23);

        /** код для чтения выбранного файла
         buttonSendParameters.addActionListener(e -> {
         fc.setDialogTitle("Выбор текстового файла");
         fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
         result = fc.showOpenDialog(GUIMainForm.this);
         });
         buttonSendParameters.addChangeListener(new ChangeListener() {
        @Override public void stateChanged(ChangeEvent e) {
        if (result == JFileChooser.APPROVE_OPTION) {
        textParametresFreq1.setText(fc.getName(fc.getSelectedFile()));
        strFormatFile = String.valueOf(fc.getSelectedFile());
        }
        }
        });*/

        buttonInputParameters.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentCardPanel.removeAll();
                parentCardPanel.add(cardParameters);
                parentCardPanel.repaint();
                parentCardPanel.revalidate();
            }
        });
        buttonWithKnownCoef.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentCardPanel.removeAll();
                parentCardPanel.add(cardKnownCoefficientsPanel);
                parentCardPanel.repaint();
                parentCardPanel.revalidate();
                if (buttonContinueMeas.isSelected()) {
                    repaintChartThread.start();
                }
            }
        });
        buttonWithUnknownCoef.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentCardPanel.removeAll();
                parentCardPanel.add(cardUnknownCoefficientsPanel);
                parentCardPanel.repaint();
                parentCardPanel.revalidate();
            }
        });
        buttonSendParameters.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UartSender uartSender = new UartSender();
                uartSender.setFreqMin(slider1FreqMin.getValue() * returnPow(comboBox1));
                uartSender.setFreqMax(slider2FreqMax.getValue() * returnPow(comboBox2));
                uartSender.setDelFreq(slider3DelFreq.getValue() * returnPow(comboBox3));
                turnOnFilters.setEnabled(true);
                buttonWithKnownCoef.setEnabled(true);
                buttonWithUnknownCoef.setEnabled(true);
//                DataFileFromCalculation dataFileFromCalculation = new DataFileFromCalculation();
//                dataFileFromCalculation.startData(strFormatFile);
                // TODO: отправка параметров по sendUart
                // TODO: ожидание чтения Uart Reader
            }
        });
        slider1FreqMin.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                freqMinQuantity.setText(String.valueOf(slider1FreqMin.getValue()));
            }
        });
        slider2FreqMax.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                freqMaxQuantity.setText(String.valueOf(slider2FreqMax.getValue()));
            }
        });
        slider3DelFreq.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                delFreqQuantity.setText(String.valueOf(slider3DelFreq.getValue()));
            }
        });

        slider4FreqDiscr.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                freqDiscrQuantity.setText(String.valueOf(slider4FreqDiscr.getValue()));
            }
        });
        sliderFreqHigher.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                freqHigherQuantity.setText(String.valueOf(sliderFreqHigher.getValue()));
            }
        });
        sliderFreqLower.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                freqLowerQuantity.setText(String.valueOf(sliderFreqLower.getValue()));
            }
        });

        buttonPlotGraph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                plotGraph.setFs(slider4FreqDiscr.getValue() * returnPow(comboBox4));
                plotGraph.setLowCutOff(sliderFreqLower.getValue() * returnPow(comboBox5));
                plotGraph.setHighCutOff(sliderFreqHigher.getValue() * returnPow(comboBox6));
                System.out.println(slider4FreqDiscr.getValue() * returnPow(comboBox4));

                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                mainThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        plotGraph.signalPlot(strFormatFile, true);
                    }
                });
                mainThread.start();
            }
        });


        /**
         * -----!function card1!------
         */

        checkBoxA0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxA0.isSelected()) {
                    a0TextField0.setEnabled(true);
                } else {
                    a0TextField0.setEnabled(false);
                    a0TextField0.setText("0");
                }


            }
        });
        checkBoxA1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxA1.isSelected()) {
                    a1TextField1.setEnabled(true);
                } else {
                    a1TextField1.setEnabled(false);
                    a1TextField1.setText("0");
                }

            }
        });
        checkBoxA2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxA2.isSelected()) {
                    a2TextField2.setEnabled(true);
                } else {
                    a2TextField2.setEnabled(false);
                    a2TextField2.setText("0");
                }

            }
        });
        checkBoxA3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxA3.isSelected()) {
                    a3TextField3.setEnabled(true);
                } else {
                    a3TextField3.setEnabled(false);
                    a3TextField3.setText("0");
                }

            }
        });
        checkBoxA4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxA4.isSelected()) {
                    a4TextField4.setEnabled(true);
                } else {
                    a4TextField4.setEnabled(false);
                    a4TextField4.setText("0");
                }

            }
        });
        checkBoxA5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxA5.isSelected()) {
                    a5TextField5.setEnabled(true);
                } else {
                    a5TextField5.setEnabled(false);
                    a5TextField5.setText("0");
                }
                a5TextField5.setEnabled(checkBoxA5.isSelected());
            }
        });
        checkBoxA6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxA6.isSelected()) {
                    a6TextField6.setEnabled(true);
                } else {
                    a6TextField6.setEnabled(false);
                    a6TextField6.setText("0");
                }

            }
        });
        checkBoxA7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxA7.isSelected()) {
                    a7TextField7.setEnabled(true);
                } else {
                    a7TextField7.setEnabled(false);
                    a7TextField7.setText("0");
                }

            }
        });
        checkBoxA8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxA8.isSelected()) {
                    a8TextField8.setEnabled(true);
                } else {
                    a8TextField8.setEnabled(false);
                    a8TextField8.setText("0");
                }

            }
        });
        checkBoxA9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxA9.isSelected()) {
                    a9TextField9.setEnabled(true);
                } else {
                    a9TextField9.setEnabled(false);
                    a9TextField9.setText("0");
                }

            }
        });

        buttonContinueMeas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                floatingPanel.setVisible(true);
                // timeGraph = Double.parseDouble(deltaTime.getText());
            }
        });
        buttonUnCountinueMeas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                floatingPanel.setVisible(false);
            }
        });
        mainButtonCard1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ILogicalCalculationsKnownCoeff calculations = new CalculationCard1(
                        new CalculatedDataBuilder(
                                new PreparedCalculationItem(strFormatFile)
                        )
                );
                valueRealEpsCard1.setText(String.valueOf((calculations.calculationRealPArt(a0TextField0, a1TextField1, a2TextField2, a3TextField3, a4TextField4,
                        a5TextField5, a6TextField6, a7TextField7, a8TextField8, a9TextField9))));

                valueImpEpsCard1.setText(String.valueOf(calculations.calculationImaginaryPart(b0TextField0, b1TextField0, b2TextField0, b3TextField0, b4TextField0,
                        b5TextField0, b6TextField0, b7TextField0, b8TextField0, b9TextField0)));
            }
        });
        checkBoxB0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxB0.isSelected()) {
                    b0TextField0.setEnabled(true);
                } else {
                    b0TextField0.setEnabled(false);
                    b0TextField0.setText("0");
                }
            }
        });
        checkBoxB1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxB1.isSelected()) {
                    b1TextField0.setEnabled(true);
                } else {
                    b1TextField0.setEnabled(false);
                    b1TextField0.setText("0");
                }
            }
        });
        checkBoxB2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxB2.isSelected()) {
                    b2TextField0.setEnabled(true);
                } else {
                    b2TextField0.setEnabled(false);
                    b2TextField0.setText("0");
                }
            }
        });
        checkBoxB3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxB3.isSelected()) {
                    b3TextField0.setEnabled(true);
                } else {
                    b3TextField0.setEnabled(false);
                    b3TextField0.setText("0");
                }
            }
        });
        checkBoxB4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxB4.isSelected()) {
                    b4TextField0.setEnabled(true);
                } else {
                    b4TextField0.setEnabled(false);
                    b4TextField0.setText("0");
                }
            }
        });
        checkBoxB5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxB5.isSelected()) {
                    b5TextField0.setEnabled(true);
                } else {
                    b5TextField0.setEnabled(false);
                    b5TextField0.setText("0");
                }
            }
        });
        checkBoxB6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxB6.isSelected()) {
                    b6TextField0.setEnabled(true);
                } else {
                    b6TextField0.setEnabled(false);
                    b6TextField0.setText("0");
                }
            }
        });
        checkBoxB7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxB7.isSelected()) {
                    b7TextField0.setEnabled(true);
                } else {
                    b7TextField0.setEnabled(false);
                    b7TextField0.setText("0");
                }
            }
        });
        checkBoxB8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxB8.isSelected()) {
                    b8TextField0.setEnabled(true);
                } else {
                    b8TextField0.setEnabled(false);
                    b8TextField0.setText("0");
                }
            }
        });
        checkBoxB9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxB9.isSelected()) {
                    b9TextField0.setEnabled(true);
                } else {
                    b9TextField0.setEnabled(false);
                    b9TextField0.setText("0");
                }
            }
        });


        /**
         * -----!function card2!------
         */
        mainButtonCard2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalculatedDataBuilder dataBuilder = new CalculatedDataBuilder(new PreparedCalculationItem(strFormatFile));
                CalculatedData data = dataBuilder.build();
                counterClickButtonCard2++;
                Component[] comps = outputCoefficientsCard2.getComponents();
                calculationCard2.linearEquations(comps, checkCase, counterClickButtonCard2, inputRealEps, data);
                if (counterClickButtonCard2 == sizeClicker) {
                    returnCoefficients(calculationCard2.calculationMatrix(calculationCard2.addNumberInMatrix(sizeClicker, checkCase)));
                }

                Component[] compsB = outputCoefficientsCard2B.getComponents();
                calculationCard2B.linearEquations(compsB, checkCaseB, counterClickButtonCard2, inputImpEps, data);
                if (counterClickButtonCard2 == sizeClicker) {
                    returnCoefficientsB(calculationCard2B.calculationMatrix(calculationCard2B.addNumberInMatrix(sizeClicker, checkCaseB)));
                }
            }
        });
        sendQuantitySamples.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainButtonCard2.setEnabled(true);
                inputRealEps.setEnabled(true);
                inputImpEps.setEnabled(true);
                sendQuantitySamples.setEnabled(false);
                quantitySamples.setEnabled(false);
                sizeClicker = Integer.parseInt(quantitySamples.getText());
                checkCase = new int[sizeClicker][10];
                checkCaseB = new int[sizeClicker][10];

                ActionCheckBoxesOutputA actionCheckBoxesOutputA = new ActionCheckBoxesOutputA(clickCounter, sizeClicker);
                Component[] componentCheckBoxA = outputCoefficientsCard2.getComponents();
                for (Component component : componentCheckBoxA) {
                    if (component instanceof JCheckBox checkBox) {
                        checkBox.addActionListener(actionCheckBoxesOutputA);
                    }
                }
                ActionCheckBoxesOutputA actionCheckBoxesOutputB = new ActionCheckBoxesOutputA(clickCounterB, sizeClicker);
                Component[] componentCheckBoxB = outputCoefficientsCard2B.getComponents();
                for (Component component : componentCheckBoxB) {
                    if (component instanceof JCheckBox checkBox) {
                        checkBox.addActionListener(actionCheckBoxesOutputB);
                    }
                }
            }
        });
        turnOnFilters.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turnOnFilters.isSelected()) {
                    parametersFilter.setVisible(true);
                } else {
                    parametersFilter.setVisible(false);
                }
            }
        });
    }

    private void returnCoefficients(double[][] matrix) {
        setTextInCoefficientsA(matrix, calculationCard2.getColumns());
    }

    private void returnCoefficientsB(double[][] matrix) {
        setTextInCoefficientsB(matrix, calculationCard2B.getColumns());
    }

    private void setTextInCoefficientsA(double[][] matrix, List<Integer> columns) {

        for (int i = 0; i < columns.size(); i++) {
            int key = columns.get(i);
            setOutputText(getOutputFieldA(key), matrix, i);
        }
    }

    private JTextField getOutputFieldA(int key) {
        return A_COEFS_TO_FIELDS_MAP.get(key);
    }

    private JTextField getOutputFieldB(int key) {
        return B_COEFC_TO_FiELDS_MAP.get(key);
    }

    private void setOutputText(JTextField output, double[][] matrix, int i) {
        output.setText(String.valueOf(matrix[i][0]));
    }

    private void setTextInCoefficientsB(double[][] matrix, List<Integer> columns) {
        for (int i = 0; i < columns.size(); i++) {
            int key = columns.get(i);
            setOutputText(getOutputFieldB(key), matrix, i);
        }
    }

    private int returnPow(JComboBox comboBox) {
        if (comboBox.getSelectedIndex() == 0) {
            return kHz;
        } else if (comboBox.getSelectedIndex() == 1) {
            return MGz;
        } else {
            return GHz;
        }
    }
}

