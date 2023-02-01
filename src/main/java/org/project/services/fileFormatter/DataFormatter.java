package org.project.services.fileFormatter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataFormatter {
    public ArrayList<Double> format(String filePath) throws FileNotFoundException {
        return this.readFile(filePath);
    }

    private ArrayList<Double> readFile(String filePath) throws FileNotFoundException {
        BufferedReader reader;
        ArrayList<Double> result = new ArrayList<>();

        reader = new BufferedReader(new FileReader(filePath));

        try {
            String line = reader.readLine();
            while (line != null) {
                result.add(Double.parseDouble(line));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
}
