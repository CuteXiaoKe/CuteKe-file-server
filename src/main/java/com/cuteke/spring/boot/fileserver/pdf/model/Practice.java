package com.cuteke.spring.boot.fileserver.pdf.model;

/**
 * Created by CuteKe on 2018/5/14.
 */
public class Practice {
    private String company;
    private String department;
    private String date;
    private String description;

    public Practice() {
    }

    public Practice(String company, String department, String date, String description) {
        this.company = company;
        this.department = department;
        this.date = date;
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
