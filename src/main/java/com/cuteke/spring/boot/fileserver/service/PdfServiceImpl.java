package com.cuteke.spring.boot.fileserver.service;

import com.cuteke.spring.boot.fileserver.domain.File;
import com.cuteke.spring.boot.fileserver.pdf.Resume;
import com.cuteke.spring.boot.fileserver.pdf.ResumeUtil;
import com.cuteke.spring.boot.fileserver.pdf.XmlUtil;
import com.cuteke.spring.boot.fileserver.util.FileUtil;
import com.cuteke.spring.boot.fileserver.util.MD5Util;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.TransformerException;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Pdf服务类实现
 * @author  CuteKe
 * @date 2018年5月15日
 */
@Service
public class PdfServiceImpl implements   PdfService {
    
    @Autowired
    private  FileService fileService;

    @Override
    public File resumeToPdf(Resume resume) throws IOException, NoSuchAlgorithmException {
        java.io.File file = new java.io.File(ResumeUtil.PDFTARGET);
        file.mkdirs();
        if(XmlUtil.resumeToXml(resume))
            return  null;
        ResumeUtil app = new ResumeUtil();
        String filename = resume.getPerson().getName();
        String filePath = String.format("%s%s.xml", ResumeUtil.XMLTARGET, filename);
        String resultPath = String.format("%s%s.pdf", ResumeUtil.PDFTARGET,filename);
        try {
            app.createPdf(app.createHtml(filePath, ResumeUtil.XSL), ResumeUtil.BASEURI, resultPath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        java.io.File fileResult=new java.io.File(resultPath);
        File file1=new File(fileResult.getName(),"application/pdf",fileResult.length(), new Binary(FileUtil.fileToBytes(resultPath)));
        FileInputStream fis = new FileInputStream(resultPath);
        file1.setMd5(MD5Util.getMD5(fis));
        fileService.saveFile(file1);
        return file1;
    }
}
