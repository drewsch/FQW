package org.project.services.outDoubleArray;

import org.project.services.fileFormatter.DataFormatter;
import java.io.IOException;
import java.util.Arrays;

public class OutDoubleArray {
    DataFormatter formatter = new DataFormatter();

    public void printDoubleFileArray(String strFormatFile) {
        double[][] results;

        try {
            results = formatter.format(strFormatFile);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

//        System.out.println("Вывод массива");
//        for (double[] s : results) {
//            System.out.println(Arrays.toString(s));
//        }
    }
}
