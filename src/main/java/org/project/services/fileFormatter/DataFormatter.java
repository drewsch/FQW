package org.project.services.fileFormatter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DataFormatter {
    public double[][] format(String filePath) throws IOException {
        return readFile(filePath);
    }
    private double[][] readFile(String filePath) throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new FileReader(filePath));
        String line = reader.readLine();
        double[][] ArrayFile = new double[2][line.split(" ").length];

            while (line != null) {
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < line.split(" ").length; j++) {
                        ArrayFile[i][j] = Double.parseDouble(line.split(" ")[j]);
                    }
                    line = reader.readLine();
                }
            }
            reader.close();

        return ArrayFile;
    }
}
