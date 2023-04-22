package org.project;

import org.project.services.GUIMainForm;
import org.project.services.plotGraph.PlotGraph;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GUIMainForm guiMainForm = new GUIMainForm();
        guiMainForm.mainGUI();
    }
}