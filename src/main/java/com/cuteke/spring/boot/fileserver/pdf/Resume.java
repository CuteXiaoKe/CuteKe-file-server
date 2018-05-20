package com.cuteke.spring.boot.fileserver.pdf;

import com.cuteke.spring.boot.fileserver.pdf.model.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by CuteKe on 2018/5/14.
 */

/**
 * 用来存储用户输入的信息并把信息存储到xml中
 * @author CuteKe
 * @date 2018年5月14日
 */
public class Resume {
    @NotNull(message = "个人信息必传")
    private Person  person;
    @NotNull(message = "教育背景必填")
    private List<Education> educations;
    @NotNull(message = "专业技能必填")
    private List<String> skills;
    private List<Practice> practices;
    @NotNull(message = "项目经验")
    private List<Project> projects;
    private List<Honor> honors;

    public Resume() {
    }

    public Resume(Person person, List<Education> educations, List<String> skills, List<Practice> practices, List<Project> projects, List<Honor> honors) {
        this.person = person;
        this.educations = educations;
        this.skills = skills;
        this.practices = practices;
        this.projects = projects;
        this.honors = honors;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<Practice> getPractices() {
        return practices;
    }

    public void setPractices(List<Practice> practices) {
        this.practices = practices;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Honor> getHonors() {
        return honors;
    }

    public void setHonors(List<Honor> honors) {
        this.honors = honors;
    }
}
