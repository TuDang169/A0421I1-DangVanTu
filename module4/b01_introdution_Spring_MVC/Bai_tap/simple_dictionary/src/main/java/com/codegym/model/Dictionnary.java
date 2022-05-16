package com.codegym.model;

public class Dictionnary {
    private String viet;
    private String anh;

    public Dictionnary() {
    }

    public Dictionnary(String viet, String anh) {
        this.viet = viet;
        this.anh = anh;
    }

    public String getViet() {
        return viet;
    }

    public void setViet(String viet) {
        this.viet = viet;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
}
