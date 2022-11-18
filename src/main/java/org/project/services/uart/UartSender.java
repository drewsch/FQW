package org.project.services.uart;

import java.util.ArrayList;

public class UartSender {
    private String host;

    public UartSender(String host) {
        this.host = host;
    }

    public void send(ArrayList<Double> inputData) throws InterruptedException {
        Uart uart = Uart.connect(this.host);

        for (int i = 0; i < inputData.length; i++) {
            uart.write(inputData.get(i));
            Thread.sleep(5000);
        }
    }
}
