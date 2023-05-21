package org.project.services.buttonInteraction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionCheckBoxesOutputA implements ActionListener {
    private int clickCounter;

    private final int sizeClicker;
    public ActionCheckBoxesOutputA(int clickCounter, int sizeClicker) {
        this.clickCounter = clickCounter;
        this.sizeClicker = sizeClicker;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        System.out.println(obj.getClass().toString());
        if (obj instanceof JCheckBox checkBox) {
            if (clickCounter < sizeClicker && checkBox.isSelected()) {
                clickCounter++;
            } else if (clickCounter == sizeClicker && checkBox.isSelected()) {
                checkBox.setSelected(false);
            } else {
                clickCounter--;
            }
            System.out.println("test");
            System.out.println(clickCounter);
            System.out.println(sizeClicker);
        }
    }
}
