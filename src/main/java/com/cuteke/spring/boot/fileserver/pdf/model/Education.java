package com.cuteke.spring.boot.fileserver.pdf.model;

/**
 * Created by CuteKe on 2018/5/14.
 */
public class Education {
    private String date;
    private String school;
    private String major;

    public Education() {
    }

    public Education(String date, String school, String major) {
        this.date = date;
        this.school = school;
        this.major = major;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
