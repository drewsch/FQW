package org.project.services.fileFormatter;

import org.project.services.IRealizationGetData.IRealizationData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class DataFormatter implements IRealizationData {
    public double[][] format(String filePath) throws IOException {
        return readData(filePath);
    }
    public double[][] readData(String filePath) throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new FileReader(filePath));
        String line = reader.readLine();
        double[][] ArrayFile = new double[101][line.split(" ").length];

            while (line != null) {
                for (int i = 0; i < 101; i++) { // TODO: строки до конца файла?
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
