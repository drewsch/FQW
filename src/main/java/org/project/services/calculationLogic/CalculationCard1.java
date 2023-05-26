package org.project.services.calculationLogic;

import org.project.services.FreqCalcAlgoService.CalculatedData;
import org.project.services.ILogicalCalculationsKnownCoeff.ILogicalCalculationsKnownCoeff;

import javax.swing.*;

public class CalculationCard1 implements ILogicalCalculationsKnownCoeff {
    private final CalculatedData calculatedData;

    public CalculationCard1(CalculatedData calculatedData) {
        this.calculatedData = calculatedData;
    }

    @Override
    public double calculationRealPArt(JTextField a0Field, JTextField a1Field, JTextField a2Field, JTextField a3Field,
                                      JTextField a4Field, JTextField a5Field, JTextField a6Field, JTextField a7Field,
                                      JTextField a8Field, JTextField a9Field) {
        double a0 = Double.parseDouble(a0Field.getText());
        double a1 = Double.parseDouble(a1Field.getText());
        double a2 = Double.parseDouble(a2Field.getText());
        double a3 = Double.parseDouble(a3Field.getText());
        double a4 = Double.parseDouble(a4Field.getText());
        double a5 = Double.parseDouble(a5Field.getText());
        double a6 = Double.parseDouble(a6Field.getText());
        double a7 = Double.parseDouble(a7Field.getText());
        double a8 = Double.parseDouble(a8Field.getText());
        double a9 = Double.parseDouble(a9Field.getText());

        return a0 + a1 * this.calculatedData.getA1() + a2 * this.calculatedData.getA2() + a3 * this.calculatedData.getA3() +
                a4 * this.calculatedData.getA4() + a5 * this.calculatedData.getA5() + a6 * this.calculatedData.getA6() +
                a7 * this.calculatedData.getA7() + a8 * this.calculatedData.getA8() + a9 * this.calculatedData.getA9();
    }

    @Override
    public double calculationImaginaryPart(JTextField b0Field, JTextField b1Field, JTextField b2Field, JTextField b3Field,
                                           JTextField b4Field, JTextField b5Field, JTextField b6Field, JTextField b7Field,
                                           JTextField b8Field, JTextField b9Field) {

        double b0 = Double.parseDouble(b0Field.getText());
        double b1 = Double.parseDouble(b1Field.getText());
        double b2 = Double.parseDouble(b2Field.getText());
        double b3 = Double.parseDouble(b3Field.getText());
        double b4 = Double.parseDouble(b4Field.getText());
        double b5 = Double.parseDouble(b5Field.getText());
        double b6 = Double.parseDouble(b6Field.getText());
        double b7 = Double.parseDouble(b7Field.getText());
        double b8 = Double.parseDouble(b8Field.getText());
        double b9 = Double.parseDouble(b9Field.getText());

        return b0 + b1 * this.calculatedData.getA1() + b2 * this.calculatedData.getA2() + b3 * this.calculatedData.getA3() +
                b4 * this.calculatedData.getA4() + b5 * this.calculatedData.getA5() + b6 * this.calculatedData.getA6() +
                b7 * this.calculatedData.getA7() + b8 * this.calculatedData.getA8() + b9 * this.calculatedData.getA9();
    }

}
