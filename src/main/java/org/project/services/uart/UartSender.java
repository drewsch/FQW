package org.project.services.uart;

import java.util.ArrayList;

import jssc.*;

public class UartSender {

    public void send(ArrayList<Double> inputData, SerialPort senderPort, UartReader reader) throws SerialPortException {
        SerialPort portReader = new SerialPort("COM2");

        senderPort.openPort();
        portReader.openPort();

        senderPort.setParams(9600, 8, 1, 0);

        this.getBytes(inputData, senderPort, reader, portReader);

        senderPort.closePort();
    }

    private void getBytes(ArrayList<Double> inputData, SerialPort port, UartReader reader, SerialPort portReader) throws SerialPortException {

        for (Double inputDatum : inputData) {
            port.writeString(inputDatum.toString());
            reader.read(portReader);
        }

    }
}
