package com.cuteke.spring.boot.fileserver.pdf.model;

import java.util.List;

/**
 * Created by CuteKe on 2018/5/14.
 */
public class Project {
    private String name;
    private String duty;
    private String date;
    private String introduction;
    private List<String> jobs;

    public Project() {
    }

    public Project(String name, String duty, String date, String introduction, List<String> jobs) {
        this.name = name;
        this.duty = duty;
        this.date = date;
        this.introduction = introduction;
        this.jobs = jobs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public List<String> getJobs() {
        return jobs;
    }

    public void setJobs(List<String> jobs) {
        this.jobs = jobs;
    }
}
