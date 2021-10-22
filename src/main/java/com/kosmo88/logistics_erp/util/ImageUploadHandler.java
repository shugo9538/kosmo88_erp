package com.kosmo88.logistics_erp.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.Part;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

public class ImageUploadHandler {
    private String uploadPath;

    public void setUploadPath(String url) {
        this.uploadPath = url;
    }

    public void imageUpload(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        File uploadDir = new File(uploadPath);
        // 업로드할 경로에 폴더가 없는 경우 폴더 생성
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            uploadDir.setWritable(true);
            uploadDir.setReadable(true);
            uploadDir.setExecutable(true);

            String fileName = "";
            for (Part part : req.getParts()) {
                fileName = getFileName(part);
                if (fileName != null && !"".equals(fileName)) {
                    part.write(uploadPath + File.separator + fileName);
                    // form에서 받아온 이미지 값을 attribute로 전송
                    req.setAttribute("fileName", fileName);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return null; // filename이 없는 경우 (폼필드 데이터인 경우);
    }
}