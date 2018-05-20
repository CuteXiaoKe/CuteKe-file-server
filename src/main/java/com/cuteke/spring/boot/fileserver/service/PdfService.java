package com.cuteke.spring.boot.fileserver.service;

/**
 * Created by ASUS on 2018/5/15.
 */

import com.cuteke.spring.boot.fileserver.domain.File;
import com.cuteke.spring.boot.fileserver.pdf.Resume;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * PDF服务接口
 * @author CuteKe
 * @date 2018年5月15日
 */
public interface PdfService {
    /**
     * 把resume对象转换成pdf
     * @param resume
     * @return
     */
    File resumeToPdf(Resume resume) throws IOException, NoSuchAlgorithmException;
}
