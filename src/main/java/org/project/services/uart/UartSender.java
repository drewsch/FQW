package org.project.services.uart;

import java.util.Arrays;
import jssc.*;

public class UartSender {

    private final String port;

    public UartSender(String port) {
        this.port = port;
    }

    public void send(double[][] inputData) throws SerialPortException {
        SerialPort port = new SerialPort(this.port);

        port.openPort();

        port.setParams(9600, 8, 1, 0);

        port.writeString(Arrays.toString(getDoubleData(inputData)));
        System.out.println("передал");
        port.closePort();
    }

    private double[] getDoubleData(double[][] inputData) {
        double[] resArrays = new double[inputData.size()];
        for (int i = 0; i < inputData.size(); i++) {
            resArrays[i] = inputData.get(i);
        }
        return resArrays;
    }
}
