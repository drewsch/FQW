package org.project.services.uart;

import java.util.ArrayList;

import jssc.*;


public class UartReader {
    private final String port;
    public UartReader(String port) {
        this.port = port;
    }

    public ArrayList<String> read() throws SerialPortException, InterruptedException {

        ArrayList<String> result = new ArrayList<>();
        SerialPort port = new SerialPort(this.port);

        port.openPort();
        port.setParams(9600, 8, 1, 0);

        for (int i = 0; i < 5; i++) {
            Thread.sleep(1500);
            result.add(port.readString());
        }
        return result;

    }
}
