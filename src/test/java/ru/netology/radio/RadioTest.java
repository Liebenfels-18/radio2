package ru.netology.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {

    Radio radio = new Radio();
    Radio radioDefault = new Radio();

    @Test
    public void shouldGetCurrentStation() {
        radio.setCurrentStation(0);
        radio.setCurrentStation(-1);
        radio.setCurrentStation(11);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldPressNextStation() {
        radio.setCurrentStation(0);
        radio.pressNextStation();
        assertEquals(1, radio.getCurrentStation());

        radio.setCurrentStation(10);
        radio.pressNextStation();
        assertEquals(0, radio.getCurrentStation());

        radio.setCurrentStation(-1);
        radio.pressNextStation();
        assertEquals(0, radio.getCurrentStation());

        radio.setCurrentStation(11);
        radio.pressNextStation();
        assertEquals(1, radio.getCurrentStation());
    }

    @Test
    public void shouldPressPrevStation() {
        radio.setCurrentStation(0);
        radio.pressPrevStation();
        assertEquals(10, radio.getCurrentStation());

        radio.setCurrentStation(10);
        radio.pressPrevStation();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void shouldGetToMaxStation() {
        assertEquals(10, radio.getMaxRadioStation());
    }

    @Test
    public void shouldSetMaxStation() {
        radio.setMaxRadioStation(-1);
        radio.setMaxRadioStation(0);
        radio.setMaxRadioStation(11);
        assertEquals(11, radio.getMaxRadioStation());
    }

    @Test
    public void shouldGetToMinStation() {
        assertEquals(0, radio.getMinRadioStation());
    }

    @Test
    public void shouldSetMinStation() {
        radio.setMinRadioStation(-1);
        radio.setMinRadioStation(0);
        radio.setMinRadioStation(11);
        assertEquals(11, radio.getMinRadioStation());
    }

    @Test
    public void shouldSetCurrentVolume() {
        radio.setCurrentVolume(101);
        assertEquals(0, radio.getCurrentVolume());

        radio.setCurrentVolume(-1);
        assertEquals(100, radio.getCurrentVolume());

        radio.setCurrentVolume(8);
        assertEquals(8, radio.getCurrentVolume());
    }

    @Test
    public void shouldGetMinVolume() {
        assertEquals(0, radio.getMinVolume());
    }

    @Test
    public void shouldGetMaxVolume() {
        assertEquals(100, radio.getMaxVolume());
    }

    @Test
    public void shouldSetMinVolume() {
        radio.setMaxVolume(100);
        radio.setMinVolume(1);
        assertEquals(1, radio.getMinVolume());
    }

    @Test
    public void shouldSetMaxVolume() {
        radio.setMinVolume(1);
        radio.setMaxVolume(101);
        assertEquals(101, radio.getMaxVolume());
    }

    @Test
    public void shouldPressVolumeUp() {
        radio.setCurrentVolume(4);
        radio.pressVolumeUp();
        assertEquals(5, radio.getCurrentVolume());

        radio.setCurrentVolume(100);
        radio.pressVolumeUp();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldPressVolumeDown() {
        radio.setCurrentVolume(4);
        radio.pressVolumeDown();
        assertEquals(3, radio.getCurrentVolume());

        radio.setCurrentVolume(0);
        radio.pressVolumeDown();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldCreateStationsWithLimits() {
        Radio radio = new Radio(1);
        assertEquals(0, radio.getMaxRadioStation());

        Radio radio1 = new Radio(100);
        assertEquals(99, radio1.getMaxRadioStation());

        Radio radio2 = new Radio(10);
        assertEquals(0, radio2.getMinRadioStation());
    }
}
