package com.cuteke.spring.boot.fileserver.pdf;

/**
 * Created by ASUS on 2018/5/14.
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.cuteke.spring.boot.fileserver.pdf.model.*;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
/**
 * 把信息存储到xml文件中
 */
public class XmlUtil {
    public static  boolean resumeToXml(Resume resume) {
        String filename=resume.getPerson().getName();
        String filePath=String.format("%s%s.xml",ResumeUtil.XMLTARGET,filename);
        File file=new File(filePath);
        Document doc=DocumentHelper.createDocument();
        
        Element root=doc.addElement("resume");
        //添加个人信息
        Element person=root.addElement("person");
        Person personEntity=resume.getPerson();
        person.addElement("name").addText(personEntity.getName());
        person.addElement("birth").addText(personEntity.getBirth());
        person.addElement("telephone").addText(personEntity.getTelephone());
        person.addElement("politics").addText(personEntity.getPolitics());
        person.addElement("email").addText(personEntity.getEmail());
        person.addElement("target").addText(personEntity.getTarget());
        person.addElement("location").addText(personEntity.getLocation());
        Element imgName=person.addElement("imgName");
        if(personEntity.getImgName()!=null)
            imgName.addText(personEntity.getImgName());
        
        //添加教育信息
        Element education=root.addElement("education");
        List<Education> educations=resume.getEducations();
        for(Education educationTemp:educations){
            Element educationOne=education.addElement("educationOne");
            educationOne.addElement("date").addText(educationTemp.getDate());
            educationOne.addElement("school").addText(educationTemp.getSchool());
            educationOne.addElement("major").addText(educationTemp.getMajor());
        }
        
        //添加技能
        Element skill=root.addElement("skill");
        List<String> skills=resume.getSkills();
        for(String skillTemp:skills)
            skill.addElement("skillOne").addText(skillTemp);
        
        //添加实习经历
        Element practice=root.addElement("practice");
        List<Practice> practices=resume.getPractices();
        if(practices!=null) {
            for (Practice practiceTemp : practices) {
                Element practiceOne = practice.addElement("practiceOne");
                practiceOne.addElement("company").addText(practiceTemp.getCompany());
                practiceOne.addElement("department").addText(practiceTemp.getDepartment());
                practiceOne.addElement("date").addText(practiceTemp.getDate());
                practiceOne.addElement("description").addText("&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;" + practiceTemp.getDescription());
            }
        }
        
        //添加项目经历
        Element project=root.addElement("project");
        List<Project> projects=resume.getProjects();
        for(Project projectTemp:projects){
            Element projectOne=project.addElement("projectOne");
            projectOne.addElement("name").addText(projectTemp.getName());
            projectOne.addElement("duty").addText(projectTemp.getDuty());
            projectOne.addElement("date").addText(projectTemp.getDate());
            projectOne.addElement("introduction").addText("&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;" +projectTemp.getIntroduction());
            Element job=projectOne.addElement("job");
            List<String> jobs=projectTemp.getJobs();
            for(String jobTemp:jobs)
                job.addElement("jobOne").addText(jobTemp);
        }
        
        //添加获得荣誉
        Element honor=root.addElement("honor");
        List<Honor> honors=resume.getHonors();
        if(honors!=null) {
            for (Honor honorTemp : honors) {
                Element honorOne = honor.addElement("honorOne");
                honorOne.addElement("date").addText(honorTemp.getDate());
                honorOne.addElement("info").addText(honorTemp.getInfo());
            }
        }
        
        //写入目标文件
        XMLWriter xmlWriter = null;
        try {
            FileWriter fw = new FileWriter(filePath);
            OutputFormat outFormat = OutputFormat.createPrettyPrint();
            outFormat.setEncoding("UTF-8");
            outFormat.setTrimText(false);
            xmlWriter= new XMLWriter(fw,outFormat);
            xmlWriter.setEscapeText(false);
            xmlWriter.write(doc);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }finally{
            if(xmlWriter!=null) {
                try {
                    xmlWriter.close();
                    return false;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
