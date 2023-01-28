package org.project.services.uart;

import java.nio.ByteBuffer;
import java.util.ArrayList;

import jssc.*;


public class UartReader {
    private final String port;

    private static final int MAX_DIGIT_LENGTH = Integer.MAX_VALUE;

    public UartReader(String port) {
        this.port = port;
    }

    public ArrayList<Double> read() throws SerialPortException {

        ArrayList<Double> result = new ArrayList<>();
        SerialPort port = new SerialPort(this.port);

        port.openPort();
        port.setParams(9600, 8, 1, 0);

        byte[] buffer;

        do {
            buffer = port.readBytes(MAX_DIGIT_LENGTH);

            if (buffer != null && buffer.length > 0) {
                result.add(this.toDouble(buffer));
            }

        } while ((buffer != null ? buffer.length : 0) > 0);

        port.closePort();

        return result;
    }

    private double toDouble(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getDouble();
    }
}
