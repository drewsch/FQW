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
import java.util.Set;

public class GUIMainForm extends JFrame {
    private JPanel mainPanel;
    private JPanel chooserFilesPanel;
    private JPanel chFileNamePanel;
    private JTextField textField1;
    private JPanel chButtonPanel;
    private JButton button1;
    private JPanel chLabelPanel;
    private JPanel ParametersPanel;
    private JPanel radioPanel;
    private JRadioButton bandPassChebyshevRadioButton;
    private JRadioButton noneRadioButton;
    private JPanel showParameters;
    private JPanel outputParameters;
    private JTextField textField2;
    private JTextField textField3;
    private JPanel footer;
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
                    textField1.setText(fc.getName(fc.getSelectedFile()));
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

