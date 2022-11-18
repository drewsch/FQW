package org.project;

import org.project.services.fileFormatter.DataFormatter;
import org.project.services.matrixMath.Matrix;
import org.project.services.presentor.Presenter;
import org.project.services.uart.UartReader;
import org.project.services.uart.UartSender;

import java.io.FileNotFoundException;

public class Main {
    private static final String UART_HOST = "localhost:3213";

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        DataFormatter formatter = new DataFormatter();
        UartSender sender = new UartSender(UART_HOST);

        sender.send(formatter.format("/Users//IdeaProjects/kids_project/test.txt"));

        UartReader reader = new UartReader(UART_HOST);

        Matrix matrix = new Matrix(reader.read());

        matrix.someMath();

        Presenter presenter = new Presenter(matrix.math());

        presenter.getGraphs();
    }
}

/*


2) formatter -- formatted data //
3) uart -- transfer to uart/grep data from uart
4) matrixMath -- make some math
5) complexMath -- make some math with complex nums
6) output (graphs)

 */