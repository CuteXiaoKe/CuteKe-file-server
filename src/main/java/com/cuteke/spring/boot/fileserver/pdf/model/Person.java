package com.cuteke.spring.boot.fileserver.pdf.model;

/**
 * Created by CuteKe on 2018/5/14.
 */
public class Person {
    private String name;
    private String birth;
    private String telephone;
    private String email;
    private String politics;
    private String target;
    private String location;
    private String imgName;

    public Person() {
    }

    public Person(String name, String birth, String telephone, String email, String politics, String target, String location, String imgName) {
        this.name = name;
        this.birth = birth;
        this.telephone = telephone;
        this.email = email;
        this.politics = politics;
        this.target = target;
        this.location = location;
        this.imgName = imgName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }
}
