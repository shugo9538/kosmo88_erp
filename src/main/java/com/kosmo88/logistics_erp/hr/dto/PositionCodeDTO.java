package com.kosmo88.logistics_erp.hr.dto;

import org.apache.ibatis.type.Alias;

@Alias("PositionCodeDTO")
public class PositionCodeDTO {
    private int id;
    private String name;
    private String type;
    private char enabled;

    public PositionCodeDTO() { }

    public PositionCodeDTO(int id, String name, String type, char enabled) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public char getEnabled() {
        return enabled;
    }

    public void setEnabled(char enabled) {
        this.enabled = enabled;
    }
}
