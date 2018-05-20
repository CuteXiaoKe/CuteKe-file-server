package com.cuteke.spring.boot.fileserver.aspect;

import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by CuteKe on 2018/5/9.
 */
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(MaxUploadSizeExceededException.class)
    public String handleMaxSizeException(MaxUploadSizeExceededException e,RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message","File is too large!");
        return "redirect:/";
    }
}
