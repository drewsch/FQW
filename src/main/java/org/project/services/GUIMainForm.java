package org.project.services;

import jssc.SerialPortException;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import org.project.services.fileFormatter.DataFormatter;
import org.project.services.uart.UartReader;
import org.project.services.uart.UartSender;
import java.util.ArrayList;

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
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JPanel showParameters;
    private JPanel outputParameters;
    private JTextField textField2;
    private JTextField textField3;
    private JPanel footer;
    private JButton startButton;
    private final JFileChooser fc = new JFileChooser();
    private int result;
    private String strFormatFile;

    public void mainGUI() {
        JFrame frame = new JFrame("Microwave sensors(resonant)");
        frame.setLocation(700,350);
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
                Object[] options = { "Да", "Нет" };
                int n = JOptionPane
                        .showOptionDialog(e.getWindow(), "Закрыть окно?",
                                "Подтверждение выхода", JOptionPane.YES_NO_OPTION,
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
                if (result == JFileChooser.APPROVE_OPTION ) {
                    textField1.setText(fc.getName(fc.getSelectedFile()));
                    strFormatFile = String.valueOf(fc.getSelectedFile());
                }
            }
        });

        startButton.addActionListener(new ActionListener() {
            private static final String UART_PORT = "COM4";
            @Override
            public void actionPerformed(ActionEvent e) {
                DataFormatter formatter = new DataFormatter();
                UartSender sender = new UartSender(UART_PORT);
                try {
                    //sender.send(formatter.format("C:\\Users\\Андрей\\Desktop\\FQW\\FQW\\test.txt"));
                    sender.send(formatter.format(strFormatFile));
                } catch (SerialPortException | FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                UartReader reader = new UartReader(UART_PORT);
                System.out.println("передал х2");
                ArrayList<String> results = null;
                try {
                    results = reader.read();
                } catch (SerialPortException | InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println("Вывод");
                for (String s: results) {
                    System.out.println(s);
                }
            }
        });
    }
}

