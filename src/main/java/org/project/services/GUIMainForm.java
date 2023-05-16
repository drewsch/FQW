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
            @Override
            public void stateChanged(ChangeEvent e) {
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
                uartSender.setFreqMin(slider1FreqMin.getValue());
                uartSender.setFreqMax(slider2FreqMax.getValue());
                uartSender.setDelFreq(slider3DelFreq.getValue());
                parametersFilter.setVisible(true);
                buttonWithKnownCoef.setEnabled(true);
                buttonWithUnknownCoef.setEnabled(true);
                //отправка параметров по sendUart
                //и ожидание чтения Uart Reader
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
                plotGraph.setFs(slider4FreqDiscr.getValue());
                plotGraph.setHighCutOff(sliderFreqHigher.getValue());
                plotGraph.setLowCutOff(sliderFreqLower.getValue());

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
         * function card1
         */
        setParametersCard1();
        checkBoxA0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a0TextField0.setEnabled(checkBoxA0.isSelected());
            }
        });
        checkBoxA1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a1TextField1.setEnabled(checkBoxA1.isSelected());
            }
        });
        checkBoxA2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a2TextField2.setEnabled(checkBoxA2.isSelected());
            }
        });
        checkBoxA3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a3TextField3.setEnabled(checkBoxA3.isSelected());
            }
        });
        checkBoxA4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a4TextField4.setEnabled(checkBoxA4.isSelected());
            }
        });
        checkBoxA5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a5TextField5.setEnabled(checkBoxA5.isSelected());
            }
        });
        checkBoxA6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a6TextField6.setEnabled(checkBoxA6.isSelected());
            }
        });
        checkBoxA7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a7TextField7.setEnabled(checkBoxA7.isSelected());
            }
        });
        checkBoxA8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a8TextField8.setEnabled(checkBoxA8.isSelected());
            }
        });
        checkBoxA9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a9TextField9.setEnabled(checkBoxA9.isSelected());
            }
        });

        buttonContinueMeas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                floatingPanel.setVisible(buttonContinueMeas.isSelected());
            }
        });
    }

    private void setParametersCard1() {
        a0TextField0.setEnabled(false);
        a1TextField1.setEnabled(false);
        a2TextField2.setEnabled(false);
        a3TextField3.setEnabled(false);
        a4TextField4.setEnabled(false);
        a5TextField5.setEnabled(false);
        a6TextField6.setEnabled(false);
        a7TextField7.setEnabled(false);
        a8TextField8.setEnabled(false);
        a9TextField9.setEnabled(false);
        floatingPanel.setVisible(false);

    }

}

