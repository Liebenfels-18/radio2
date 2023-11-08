package ru.netology.radio;

public class Radio {
    private int currentStation = 10;
    private int quantityRadioStation = 10;
    private int minRadioStation = 0;
    private int currentVolume;
    private int maxVolume = 100;
    private int minVolume = 0;

    public Radio() {
    }

    public Radio(int quantityRadioStation) {
        this.quantityRadioStation = quantityRadioStation - 1;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation > quantityRadioStation) {
            currentStation = minRadioStation;
        }
        if (currentStation < minRadioStation) {
            currentStation = quantityRadioStation;
        }
        this.currentStation = currentStation;
    }

    public void pressNextStation() {
        if (currentStation >= quantityRadioStation) {
            setCurrentStation(minRadioStation);
        } else {
            setCurrentStation(currentStation + 1);
        }
    }

    public void pressPrevStation() {
        if (currentStation <= minRadioStation) {
            setCurrentStation(quantityRadioStation);
        } else {
            setCurrentStation(currentStation - 1);
        }
    }

    public int getQuantityRadioStation() {
        return quantityRadioStation;
    }

    public void setQuantityRadioStation(int quantityRadioStation) {
        this.quantityRadioStation = quantityRadioStation;
    }

    public int getMinRadioStation() {
        return minRadioStation;
    }

    public void setMinRadioStation(int minRadioStation) {
        this.minRadioStation = minRadioStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume > maxVolume) {
            currentVolume = minVolume;
        }
        if (currentVolume < minVolume) {
            currentVolume = maxVolume;
        }
        this.currentVolume = currentVolume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(int maxVolume) {
        this.maxVolume = maxVolume;
    }

    public int getMinVolume() {
        return minVolume;
    }

    public void setMinVolume(int minVolume) {
        this.minVolume = minVolume;
    }

    public void pressVolumeUp() {
        setCurrentVolume(currentVolume + 1);

    }

    public void pressVolumeDown() {
        setCurrentVolume(currentVolume - 1);
    }
}
