package org.project.services.calculationLogic;

import com.github.psambit9791.jdsp.misc.UtilMethods;
import org.project.services.FreqCalcAlgoService.CalculatedData;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculationCard2 {
    private List<Double> coefficientEquations = new ArrayList<>();
    private List<Double> realEps = new ArrayList<>();
    private List<Integer> columns;

    public List<Integer> getColumns() {
        return columns;
    }

    public void linearEquations(Component[] comps, int[][] checkCase, int counterClickButtonCard2, JTextField inputRealEps, CalculatedData calculatedData) {
        realEps.add(Double.parseDouble(inputRealEps.getText()));
        for (Component comp : comps) {
            if (comp instanceof JCheckBox box) {
                if (box.isSelected()) {
                    switch (box.getName()) {
                        case "zero" -> coefficientEquations.add(0.0);
                        case "one" -> {
                            coefficientEquations.add(calculatedData.getA1());
                            checkCase[counterClickButtonCard2 - 1][1] = 1;
                        }
                        case "two" -> {
                            coefficientEquations.add(calculatedData.getA2());
                            checkCase[counterClickButtonCard2 - 1][2] = 1;
                        }
                        case "free" -> {
                            coefficientEquations.add(calculatedData.getA3());
                            checkCase[counterClickButtonCard2 - 1][3] = 1;
                        }
                        case "four" -> {
                            coefficientEquations.add(calculatedData.getA4());
                            checkCase[counterClickButtonCard2 - 1][4] = 1;
                        }
                        case "five" -> {
                            coefficientEquations.add(calculatedData.getA5());
                            checkCase[counterClickButtonCard2 - 1][5] = 1;
                        }
                        case "six" -> {
                            coefficientEquations.add(calculatedData.getA6());
                            checkCase[counterClickButtonCard2 - 1][6] = 1;
                        }
                        case "seven" -> {
                            coefficientEquations.add(calculatedData.getA7());
                            checkCase[counterClickButtonCard2 - 1][7] = 1;
                        }
                        case "eight" -> {
                            coefficientEquations.add(calculatedData.getA8());
                            checkCase[counterClickButtonCard2 - 1][8] = 1;
                        }
                        case "nine" -> {
                            coefficientEquations.add(calculatedData.getA9());
                            checkCase[counterClickButtonCard2 - 1][9] = 1;
                        }
                    }
                }
            }
        }
    }

    public double[][] addNumberInMatrix(int sizeClicker, int[][] checkCase) {
        double[][] arrayMatrix = new double[sizeClicker][sizeClicker];
        columns = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < sizeClicker; j++) {
                if (checkCase[j][i] == 1) {
                    columns.add(i);
                    break;
                }
            }
        }
        System.out.println(columns);
        for (int i = 0; i < sizeClicker; i++) {
            for (int j = 0; j < sizeClicker; j++) {
                arrayMatrix[j][i] = checkCase[j][columns.get(i)];

            }
        }
        int key = 0;
        for (int i = 0; i < sizeClicker; i++) {
            for (int j = 0; j < sizeClicker; j++) {
                if (arrayMatrix[i][j] == 1.0) {
                    arrayMatrix[i][j] = coefficientEquations.get(key);
                    key++;
                }
            }
        }
        return arrayMatrix;

    }

    public double[][] calculationMatrix(double[][] arrayMatrix) {
        double[][] matrixEps = new double[realEps.size()][1];
        for (int i = 0; i < realEps.size(); i++) {
                matrixEps[i][0] = realEps.get(i);
        }
        double[][] operation1 = UtilMethods.pseudoInverse(UtilMethods.matrixMultiply(UtilMethods.transpose(arrayMatrix), arrayMatrix));
        double[][] operation2 = UtilMethods.matrixMultiply(operation1, UtilMethods.transpose(arrayMatrix));
        double[][] operation3 = UtilMethods.matrixMultiply(operation2, matrixEps);
        System.out.println(Arrays.deepToString(operation3));
        for (int i = 0; i < operation3.length; i++) {
            operation3[i][0] = UtilMethods.round(operation3[i][0],4);
        }
        System.out.println(Arrays.deepToString(operation3));
        return operation3;
    }
}
