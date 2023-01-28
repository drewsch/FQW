package org.project;

import jssc.SerialPortException;
import org.project.services.fileFormatter.DataFormatter;
import org.project.services.uart.UartReader;
import org.project.services.uart.UartSender;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    private static final String UART_PORT = "COM1";

    public static void main(String[] args) throws FileNotFoundException, SerialPortException {
        DataFormatter formatter = new DataFormatter();
        UartSender sender = new UartSender(UART_PORT);

        sender.send(formatter.format("/Users/IdeaProjects/kids_project/test.txt"));

        UartReader reader = new UartReader(UART_PORT);

        ArrayList<Double> results = reader.read();

        for (Double s: results) {
            System.out.println(s);
        }

    }
}