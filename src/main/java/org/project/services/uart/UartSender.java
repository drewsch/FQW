package org.project.services.uart;

import java.util.ArrayList;

import jssc.*;

public class UartSender {

    private final String port;

    public UartSender(String port) {
        this.port = port;
    }

    public void send(ArrayList<Double> inputData) throws SerialPortException {
        SerialPort port = new SerialPort(this.port);

        port.openPort();

        port.setParams(9600, 8, 1, 0);

        port.writeBytes(this.getBytes(inputData));

        port.closePort();
    }

    private byte[] getBytes(ArrayList<Double> inputData) {
        byte[] result = new byte[inputData.size()];

        for (int i = 0; i < inputData.size(); i++) {
            result[i] = inputData.get(i).byteValue();
        }

        return result;
    }
}
