/**
 * @author AndreyChesnokov
 */
package org.project.services;

import org.project.services.UartSender.UartSender;
import org.project.services.plotGraph.PlotGraph;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class GUIMainForm extends JFrame {
    private JPanel mainPanel;
    private JButton buttonSendParameters;
    private JPanel panelButtonChoosesCards;
    private JButton buttonWithUnknownCoef;
    private JPanel mainResults;
    private JPanel parentCardPanel;
    private JPanel cardKnownCoefficientsPanel;
    private JLabel labelArticleCard1;
    private JPanel inputCoefficientsPanelCard1;
    private JPanel chooseMeasurementsCard1;
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
    private JTextField textField1;
    private JTextField textField2;
    private JPanel floatingPanel;
    private JButton mainButtonСard1;
    private JTextField textField3;
    private JTextField textField9;
    private JLabel titleEpsPanel;
    private JPanel cardUnknownCoefficientsPanel;
    private JPanel outputCoefficientsCard2;
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
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JButton mainButtonCard2;
    private JPanel epsMainUnknownCoefCard2;
    private JPanel epsPanelInputCard2;
    private JPanel chooseMeasureCard2;
    private JPanel inputMeasureCard2;
    private JTextField tmaxCard2;
    private JTextField tauCard2;
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
    private JComboBox comboBox7;
    private JComboBox comboBox8;
    private JComboBox comboBox9;
    private JComboBox comboBox10;
    private JTextArea количествоКолЫхОбразцовTextArea;
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
    public String strFormatFile = "data.txt";
    private Thread mainThread = null;
    private PlotGraph plotGraph = new PlotGraph();
    private int kHz = (int) Math.pow(10, 3);
    private int GHz = (int) Math.pow(10, 9);
    private int MGz = (int) Math.pow(10, 6);


    public void mainGUI() {
        JFrame frame = new JFrame("Microwave sensors(resonant)");
        frame.setLocation(500, 250);
        frame.setPreferredSize(new Dimension(1000, 600));
        frame.setContentPane(new GUIMainForm().mainPanel);
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

    public GUIMainForm() {
        parametersFilter.setVisible(false);
        buttonWithUnknownCoef.setEnabled(false);
        buttonWithKnownCoef.setEnabled(false);
        label1Card2.setText("ε");
        System.out.println("₁");
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
//
//        startButton.addActionListener(e -> {
//
//            OutDoubleArray outDoubleArray = new OutDoubleArray();
//            outDoubleArray.printDoubleFileArray(strFormatFile);
//
//            if (mainThread != null) {
//                mainThread.start();
//                bandPassChebyshevRadioButton.setSelected(false);
//                noneRadioButton.setSelected(true);
//                noneRadioButton.setSelected(false);
//                bandPassChebyshevRadioButton.setSelected(true);
////                noneRadioButton.setEnabled(false);
////                bandPassChebyshevRadioButton.setEnabled(false);
////                startButton.setEnabled(false);
//
//            }
//        });
//
//        bandPassChebyshevRadioButton.addItemListener(new ItemListener() {
//
//            @Override
//            public void itemStateChanged(ItemEvent e) {
//
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException ex) {
//                    throw new RuntimeException(ex);
//                }
//                mainThread = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        plotGraph.signalPlot(strFormatFile, true);
//                    }
//                });
//            }
//
//        });
//
//        noneRadioButton.addItemListener(new ItemListener() {
//            @Override
//            public void itemStateChanged(ItemEvent e) {
//                chooseParametersFilter.setVisible(false);
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException ex) {
//                    throw new RuntimeException(ex);
//                }
//
//                mainThread = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        plotGraph.signalPlot(strFormatFile, false);
//                    }
//                });
//            }
//        });
//        chooseParametersFilter.setVisible(false);
//        bandPassChebyshevRadioButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                chooseParametersFilter.setVisible(true);
//            }
//
//        });
//
//        sliderFrequency.addChangeListener(new ChangeListener() {
//            @Override
//            public void stateChanged(ChangeEvent e) {
//                int sliderFrequencyValue = sliderFrequency.getValue();
//                plotGraph.setFs(sliderFrequencyValue);
//                labelFreq.setText("Frequency : " + sliderFrequencyValue);
//            }
//        });
//        sliderLower.addChangeListener(new ChangeListener() {
//            @Override
//            public void stateChanged(ChangeEvent e) {
//                int sliderLowerValue = sliderLower.getValue();
//                plotGraph.setLowCutOff(sliderLowerValue);
//                labelLower.setText("Lower cut freq : " + sliderLowerValue);
//            }
//        });
//        sliderHigher.addChangeListener(new ChangeListener() {
//            @Override
//            public void stateChanged(ChangeEvent e) {
//                int sliderHigherValue = sliderHigher.getValue();
//                plotGraph.setHighCutOff(sliderHigherValue);
//                labelHigher.setText("Higher cut freq : " + sliderHigherValue);
//            }
//        });

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
                parametersFilter.setVisible(true);
                buttonWithKnownCoef.setEnabled(true);
                buttonWithUnknownCoef.setEnabled(true);
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
                plotGraph.setHighCutOff(sliderFreqHigher.getValue() * returnPow(comboBox5));
                plotGraph.setLowCutOff(sliderFreqLower.getValue() * returnPow(comboBox6));

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
            }
        });
        buttonUnCountinueMeas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                floatingPanel.setVisible(false);
            }
        });
        mainButtonСard1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: calculation algorithms
            }
        });


        /**
         * -----!function card2!------
         */
        radioButtonUnCountinueMeasCard2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputMeasureCard2.setVisible(false);
            }
        });
        radioButtonContinueMeasCard2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputMeasureCard2.setVisible(true);
            }
        });
        mainButtonCard2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: calculation matrix
            }
        });
    }

    private int returnPow(JComboBox comboBox) {
        if (comboBox.getSelectedIndex() == 0) {
            return kHz;
        } else if (comboBox1.getSelectedIndex() == 1) {
            return MGz;
        } else {
            return GHz;
        }
    }
}

