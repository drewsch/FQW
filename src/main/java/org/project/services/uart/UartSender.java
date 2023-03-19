package org.project.services.uart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

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

        //port.writeBytes(this.getBytes(inputData));
        port.writeString(Arrays.toString(getDoubleData(inputData)));
        System.out.println("передал");
        port.closePort();
    }

    /*private byte[] getBytes(ArrayList<Double> inputData) {
        byte[] result = new byte[inputData.size()];

        for (int i = 0; i < inputData.size(); i++) {
            result[i] = inputData.get(i).byteValue();
        }

        return result;
    }*/
    private double[] getDoubleData(ArrayList<Double> inputData) {
        double[] resArrays = new double[inputData.size()];
        for (int i = 0; i < inputData.size(); i++) {
            resArrays[i] = inputData.get(i);
        }
        return resArrays;
    }
}
