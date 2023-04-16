package org.project.services.uart;

import java.util.ArrayList;

import jssc.*;
import org.project.services.IReader;


public class UartReader implements IReader {
    private final String port;

    public UartReader(String port) {
        this.port = port;
    }

    public double[][] read() throws SerialPortException, InterruptedException {

        double[][] arrayReadPort = new double[][];
        SerialPort port = new SerialPort(this.port);

        port.openPort();
        port.setParams(9600, 8, 1, 0);

        for (int i = 0; i < 5; i++) {
            Thread.sleep(1500);
            result.add(port.readString());
        }
        return result;

    }

    @Override
    public double[][] uartRead() {
        return new double[0][];
    }
}
