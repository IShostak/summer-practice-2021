package com.ishostak.tasks.lec7_immutable;

public class MutableInfo implements Cloneable {
    private String info;

    public MutableInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
