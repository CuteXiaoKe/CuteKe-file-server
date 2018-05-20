package com.cuteke.spring.boot.fileserver.pdf.model;

/**
 * Created by CuteKe on 2018/5/14.
 */
public class Honor {
    private String date;
    private String info;
    
    public Honor() {
    }

    public Honor(String date, String info) {
        this.date = date;
        this.info = info;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
