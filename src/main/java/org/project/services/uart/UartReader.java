package org.project.services.uart;

import java.util.ArrayList;

public class UartReader {
    private String host;

    public UartReader(String host) {
        this.host = host;
    }

    public ArrayList<ArrayList<Double>> read() throws InterruptedException {
        Uart uart = Uart.connect(this.host);

        ArrayList<ArrayList<Double>> response = new ArrayList<>();

        while (response.isEmpty()) {
            response.add(uart.read());
            Thread.sleep(500);
        }

        while (true) {
            responseNew = uart.read();
            if (responseNew == null) {
                break;
            }
            response.add(responseNew);
        }

        return response;
    }
}
