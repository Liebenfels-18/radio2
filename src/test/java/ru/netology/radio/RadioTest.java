package ru.netology.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {
    Radio radio = new Radio(15);
    Radio radioDefault = new Radio();

    @Test
    public void setStation() {
        radio.setCurrentStation(12);
        Assertions.assertEquals(12, radio.getCurrentStation());

        radioDefault.setCurrentStation(8);
        Assertions.assertEquals(8, radioDefault.getCurrentStation());

    }

    @Test
    public void setStationMoreMax() {
        radio.setCurrentStation(15);
        Assertions.assertEquals(0, radio.getCurrentStation());

        radioDefault.setCurrentStation(10);
        Assertions.assertEquals(0, radioDefault.getCurrentStation());
    }

    @Test
    public void setStationLessMin() {
        radio.setCurrentStation(-1);
        Assertions.assertEquals(0, radio.getCurrentStation());

        radioDefault.setCurrentStation(-1);
        Assertions.assertEquals(0, radioDefault.getCurrentStation());
    }

    @Test
    public void nextStation() {
        radio.setCurrentStation(10);
        radio.next();
        Assertions.assertEquals(11, radio.getCurrentStation());

        radioDefault.setCurrentStation(8);
        radioDefault.next();
        Assertions.assertEquals(9, radioDefault.getCurrentStation());
    }

    @Test
    public void nextStationAfterMax() {
        radio.setCurrentStation(14);
        radio.next();
        Assertions.assertEquals(0, radio.getCurrentStation());

        radioDefault.setCurrentStation(9);
        radioDefault.next();
        Assertions.assertEquals(0, radioDefault.getCurrentStation());
    }

    @Test
    public void prevStation() {
        radio.setCurrentStation(5);
        radio.prev();
        Assertions.assertEquals(4, radio.getCurrentStation());

        radioDefault.setCurrentStation(5);
        radioDefault.prev();
        Assertions.assertEquals(4, radioDefault.getCurrentStation());
    }

    @Test
    public void prevStationAfterMin() {
        radio.setCurrentStation(0);
        radio.prev();
        Assertions.assertEquals(14, radio.getCurrentStation());

        radioDefault.setCurrentStation(0);
        radioDefault.prev();
        Assertions.assertEquals(9, radioDefault.getCurrentStation());
    }

    @Test
    public void increaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(5);
        radio.volumeUp();

        int expected = 6;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void increaseVolumeMoreMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(101);
        radio.volumeUp();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void decreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(5);
        radio.volumeDown();

        int expected = 4;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void decreaseVolumeLessMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-5);
        radio.volumeDown();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }
}
