package com.cuteke.spring.boot.fileserver.controller;

import com.cuteke.spring.boot.fileserver.VO.Response;
import com.cuteke.spring.boot.fileserver.domain.File;
import com.cuteke.spring.boot.fileserver.pdf.Resume;
import com.cuteke.spring.boot.fileserver.pdf.ResumeUtil;
import com.cuteke.spring.boot.fileserver.pdf.XmlUtil;
import com.cuteke.spring.boot.fileserver.service.FileService;
import com.cuteke.spring.boot.fileserver.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by CuteKe on 2018/5/14.
 */
@CrossOrigin(origins = "*", maxAge = 3600) // 允许所有域名访问
@RestController
@RequestMapping("/pdf")
public class PdfController {
    
    @Autowired
    private PdfService pdfService;
    /**
     * 生成PDF接口
     * @param resume
     * @return
     */
    @PostMapping(value = "/resume")
    public Response generateResume(@RequestBody @Valid Resume resume, BindingResult bindingResult) {
        File result=null;
        if (bindingResult.hasErrors()) {
            return new Response(false, "传入的信息有误", bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            result=pdfService.resumeToPdf(resume);
            result.setContent(null);
        } catch (IOException | NoSuchAlgorithmException ex) {
            Response response=new Response(false, "生成PDF中出错", null);
            return response;
        }
        if(result==null){
            Response response=new Response(false, "转换xml文件失败", null);
            return response;
        }
        Response resultResponse=new Response(true, "生成PDF成功！", result);
        return resultResponse;
    }

}
