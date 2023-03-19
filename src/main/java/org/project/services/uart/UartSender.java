package org.project.services.uart;

import java.util.ArrayList;

import jssc.*;

public class UartSender {

    public void send(ArrayList<Double> inputData, SerialPort senderPort, UartReader reader) throws SerialPortException, InterruptedException {
        SerialPort portReader = new SerialPort("COM4");

        //senderPort.openPort();
        portReader.openPort();

       // senderPort.setParams(9600, 8, 1, 0);

        this.getBytes(inputData,  portReader, reader, portReader);

       // portReader.closePort();
    }

    private void getBytes(ArrayList<Double> inputData, SerialPort port, UartReader reader, SerialPort portReader) throws SerialPortException, InterruptedException {

        for (Double inputDatum : inputData) {
            port.writeString(inputDatum.toString());
            Thread.sleep(1500);
            reader.read(portReader);
        }

    }
}
