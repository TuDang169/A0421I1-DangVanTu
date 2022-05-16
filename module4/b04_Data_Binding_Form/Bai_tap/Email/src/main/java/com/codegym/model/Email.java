package com.codegym.model;

public class Email {
    private String language;
    private int size;
    private boolean filter;
    private String signature;

    public Email() {
    }

    public Email(String language, int size, boolean filter, String signature) {
        this.language = language;
        this.size = size;
        this.filter = filter;
        this.signature = signature;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isFilter() {
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
