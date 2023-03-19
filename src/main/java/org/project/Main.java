package org.project;

import jssc.SerialPort;
import jssc.SerialPortException;
import org.apache.log4j.PropertyConfigurator;
import org.project.services.fileFormatter.DataFormatter;
import org.project.services.uart.UartReader;
import org.project.services.uart.UartSender;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    private static final String UART_PORT = "COM4";

    public static void main(String[] args) throws FileNotFoundException, SerialPortException, InterruptedException {
        configureLogger();
        DataFormatter formatter = new DataFormatter();

        UartSender sender = new UartSender();

        sender.send(formatter.format("C:\\Users\\Андрей\\Desktop\\FQW\\FQW\\test.txt"), new SerialPort(UART_PORT), new UartReader());

    }

    public static void configureLogger() {
        String sys = System.getProperty("user.dir") + File.separator + "src/log4j.properties";
        PropertyConfigurator.configure(sys);
    }
}