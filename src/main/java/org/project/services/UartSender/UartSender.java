package org.project.services.UartSender;

public class UartSender {
    private int freqMin = 1;
    private int freqMax = 100;
    private double delFreq = 0.5;

    public int getFreqMin() {
        return freqMin;
    }

    public void setFreqMin(int freqMin) {
        this.freqMin = freqMin;
    }

    public int getFreqMax() {
        return freqMax;
    }

    public void setFreqMax(int freqMax) {
        this.freqMax = freqMax;
    }

    public double getDelFreq() {
        return delFreq;
    }

    public void setDelFreq(int delFreq) {
        this.delFreq = delFreq;
    }
}
