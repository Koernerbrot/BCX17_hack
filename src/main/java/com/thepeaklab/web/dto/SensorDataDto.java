package com.thepeaklab.web.dto;

/**
 * created on 15/03/2017
 *
 * @author David Reiher (dreiher23@gmail.com, dr@thepeaklab.com)
 */
public class SensorDataDto {

    String value;

    public SensorDataDto() {
        // nothing to do
    }

    public SensorDataDto(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
