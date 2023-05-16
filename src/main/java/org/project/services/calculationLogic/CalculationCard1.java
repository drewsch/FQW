package org.project.services.calculationLogic;

import org.project.services.ILogicalCalculations.ILogicalCalculations;
import org.project.services.calculationAlgorithmFQ.CalculationAlgorithm;

import javax.swing.*;

public class CalculationCard1 implements ILogicalCalculations {
    private int a0;
    private int a1;
    private int a2;
    private int a3;
    private int a4;
    private int a5;
    private int a6;
    private int a7;
    private int a8;
    private int a9;
    private CalculationAlgorithm algorithm;

    private CalculationCard1() {
        algorithm = new CalculationAlgorithm();
    }

    @Override
    public double calculation(JTextField a0, JTextField a1, JTextField a2, JTextField a3,
                              JTextField a4, JTextField a5, JTextField a6, JTextField a7,
                              JTextField a8, JTextField a9)
    {
        double F0 = algorithm.getF0();
        double Q = algorithm.getQ();
        this.a0 = Integer.parseInt(a0.getText());
        this.a1 = Integer.parseInt(a1.getText());
        this.a2 = Integer.parseInt(a2.getText());
        this.a3 = Integer.parseInt(a3.getText());
        this.a4 = Integer.parseInt(a4.getText());
        this.a5 = Integer.parseInt(a5.getText());
        this.a6 = Integer.parseInt(a6.getText());
        this.a7 = Integer.parseInt(a7.getText());
        this.a8 = Integer.parseInt(a8.getText());
        this.a9 = Integer.parseInt(a9.getText());
        return this.a0 + this.a1 * F0 + this.a2 * Q + this.a3 * Math.pow(F0,2) +
                this.a4 * Math.pow(Q,2) + this.a5 * F0 * Q + this.a6  ;
    }
}
