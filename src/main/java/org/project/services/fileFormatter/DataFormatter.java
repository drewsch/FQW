package org.project.services.fileFormatter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DataFormatter {
    private int arrayFileLength = 100;
    public double[][] format(String filePath) throws FileNotFoundException {
        return this.readFile(filePath);
    }

    private double[][] readFile(String filePath) throws FileNotFoundException {
        BufferedReader reader;
        double[][] ArrayFile = new double[2][arrayFileLength];

        reader = new BufferedReader(new FileReader(filePath));

        try {
            String line = reader.readLine();
            while (line != null) {
                for (int i = 0; i < line.split(" ").length; i++) {
                    for (int j = 0; j < line.split(" ").length; j++) {

                        ArrayFile[i][j] = Double.parseDouble(line.split(" ")[i]);// ??
                    }
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return ArrayFile;
    }
}
