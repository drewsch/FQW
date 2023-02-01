package org.project.services.uart;

import jssc.*;


public class UartReader {

    public void read(SerialPort port) throws SerialPortException {
        String buffer;

        buffer = port.readString();

        System.out.println(buffer);

    }
}
