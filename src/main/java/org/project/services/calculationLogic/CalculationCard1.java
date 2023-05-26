package org.project.services.calculationLogic;

import org.project.services.ILogicalCalculationsKnownCoeff.ILogicalCalculationsKnownCoeff;
import org.project.services.calculationAlgorithmFQ.CalculationAlgorithm;
import org.project.services.calculationAlgorithmFQ.PreparedCalculationItem;

import javax.swing.*;

public class CalculationCard1 implements ILogicalCalculationsKnownCoeff {
    private double a0,b0;
    private double a1,b1;
    private double a2,b2;
    private double a3,b3;
    private double a4,b4;
    private double a5,b5;
    private double a6,b6;
    private double a7,b7;
    private double a8,b8;
    private double a9,b9;
    private CalculationAlgorithm algorithm;
    private double F0;
    private double Q;

    public CalculationCard1(String filePath) {
        algorithm = new CalculationAlgorithm(new PreparedCalculationItem(filePath));
        this.F0 = algorithm.getF0();
        this.Q = algorithm.getQ();
    }
    @Override
    public double calculationRealPArt(JTextField a0, JTextField a1, JTextField a2, JTextField a3,
                                      JTextField a4, JTextField a5, JTextField a6, JTextField a7,
                                      JTextField a8, JTextField a9)
    {
        this.a0 = Double.parseDouble(a0.getText());
        this.a1 = Double.parseDouble(a1.getText());
        this.a2 = Double.parseDouble(a2.getText());
        this.a3 = Double.parseDouble(a3.getText());
        this.a4 = Double.parseDouble(a4.getText());
        this.a5 = Double.parseDouble(a5.getText());
        this.a6 = Double.parseDouble(a6.getText());
        this.a7 = Double.parseDouble(a7.getText());
        this.a8 = Double.parseDouble(a8.getText());
        this.a9 = Double.parseDouble(a9.getText());
        return this.a0 + this.a1 * algorithm.getA1() + this.a2 * algorithm.getA2() + this.a3 * algorithm.getA3() +
                this.a4 * algorithm.getA4() + this.a5 * algorithm.getA5() + this.a6 * algorithm.getA6() +
                this.a7 * algorithm.getA7() + this.a8 * algorithm.getA8() + this.a9 * algorithm.getA9();
    }

    @Override
    public double calculationImaginaryPart(JTextField b0, JTextField b1, JTextField b2, JTextField b3,
                                           JTextField b4, JTextField b5, JTextField b6, JTextField b7,
                                           JTextField b8, JTextField b9) {

        this.b0 = Double.parseDouble(b0.getText());
        this.b1 = Double.parseDouble(b1.getText());
        this.b2 = Double.parseDouble(b2.getText());
        this.b3 = Double.parseDouble(b3.getText());
        this.b4 = Double.parseDouble(b4.getText());
        this.b5 = Double.parseDouble(b5.getText());
        this.b6 = Double.parseDouble(b6.getText());
        this.b7 = Double.parseDouble(b7.getText());
        this.b8 = Double.parseDouble(b8.getText());
        this.b9 = Double.parseDouble(b9.getText());

        return this.b0 + this.b1 * algorithm.getA1() + this.b2 * algorithm.getA2() + this.b3 * algorithm.getA3() +
                this.b4 * algorithm.getA4() + this.b5 * algorithm.getA5() + this.b6 * algorithm.getA6() +
                this.b7 * algorithm.getA7() + this.b8 * algorithm.getA8() + this.b9 * algorithm.getA9();
    }

}
