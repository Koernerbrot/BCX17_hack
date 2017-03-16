package com.thepeaklab.web.dto;

import java.util.List;

/**
 * created on 15/03/2017
 *
 * @author David Reiher (dreiher23@gmail.com, dr@thepeaklab.com)
 */
public class SensorDataListDto {

    private List<SensorDataDto> list;

    public SensorDataListDto() {
        // nothing to do
    }

    public SensorDataListDto(List<SensorDataDto> list) {
        this.list = list;
    }

    public List<SensorDataDto> getList() {
        return list;
    }

    public void setList(List<SensorDataDto> list) {
        this.list = list;
    }

}
