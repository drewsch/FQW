package org.project.services.buttonInteraction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionCheckBoxesA implements ActionListener {

    private final JTextField textField;

    private ActionCheckBoxesA(JTextField textField) {
        this.textField = textField;
    }

    public static ActionCheckBoxesA build(JTextField textField) {
        return new ActionCheckBoxesA(textField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JCheckBox checkBox) {
            if (checkBox.isSelected()) {
                textField.setEnabled(true);
            } else {
                textField.setEnabled(false);
                textField.setText("0");
            }
        }
    }
}
