/**
 * @author AndreyChesnokov
 */
package org.project.services;

import org.project.services.outDoubleArray.OutDoubleArray;
import org.project.services.plotGraph.PlotGraph;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class GUIMainForm extends JFrame {
    private JPanel mainPanel;
    private JTextField textParametresFreq1;
    private JButton button1;
    private JPanel panelButtonCard;
    private JButton button2;
    private JPanel chooserSliderPanel;
    private JPanel parametresFiltr;
    private JSlider slider1;
    private JSlider slider2;
    private JSlider slider3;
    private JTextField textParametresFreq2;
    private JTextField textParametresFreq3;
    private JPanel mainResualts;
    private JPanel parentCardPanel;
    private JPanel epsOutputPanel;
    private JPanel card1CoefficientsPanel;
    private JLabel labelArticleCard1;
    private JPanel inputCoefficientsPanelCard1;
    private JPanel chooseMeasurementsCard1;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JRadioButton одиночныеИзмеренияRadioButton;
    private JRadioButton непрервыныеИзмеренияRadioButton;
    private JButton начатьButton;
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
    public String strFormatFile;
    private Thread mainThread = null;
    private PlotGraph plotGraph = new PlotGraph();


    public void mainGUI() {
        JFrame frame = new JFrame("Microwave sensors(resonant)");
        frame.setLocation(700, 350);
        frame.setPreferredSize(new Dimension(600, 350));
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
        button1.addActionListener(e -> {
            fc.setDialogTitle("Выбор текстового файла");
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            result = fc.showOpenDialog(GUIMainForm.this);
        });


        button1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (result == JFileChooser.APPROVE_OPTION) {
                    textParametresFreq1.setText(fc.getName(fc.getSelectedFile()));
                    strFormatFile = String.valueOf(fc.getSelectedFile());
                }
            }
        });

        startButton.addActionListener(e -> {

            OutDoubleArray outDoubleArray = new OutDoubleArray();
            outDoubleArray.printDoubleFileArray(strFormatFile);

            if (mainThread != null) {
                mainThread.start();
                bandPassChebyshevRadioButton.setSelected(false);
                noneRadioButton.setSelected(true);
                noneRadioButton.setSelected(false);
                bandPassChebyshevRadioButton.setSelected(true);
//                noneRadioButton.setEnabled(false);
//                bandPassChebyshevRadioButton.setEnabled(false);
//                startButton.setEnabled(false);

            }
        });

        bandPassChebyshevRadioButton.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {

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
            }

        });

        noneRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                chooseParametersFilter.setVisible(false);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

                mainThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        plotGraph.signalPlot(strFormatFile, false);
                    }
                });
            }
        });
        chooseParametersFilter.setVisible(false);
        bandPassChebyshevRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseParametersFilter.setVisible(true);
            }

        });

        sliderFrequency.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int sliderFrequencyValue = sliderFrequency.getValue();
                plotGraph.setFs(sliderFrequencyValue);
                labelFreq.setText("Frequency : " + sliderFrequencyValue);
            }
        });
        sliderLower.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int sliderLowerValue = sliderLower.getValue();
                plotGraph.setLowCutOff(sliderLowerValue);
                labelLower.setText("Lower cut freq : " + sliderLowerValue);
            }
        });
        sliderHigher.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int sliderHigherValue = sliderHigher.getValue();
                plotGraph.setHighCutOff(sliderHigherValue);
                labelHigher.setText("Higher cut freq : " + sliderHigherValue);
            }
        });
    }

}

