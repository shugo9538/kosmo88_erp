package com.kosmo88.logistics_erp.hr.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.kosmo88.logistics_erp.hr.service.EmployeeService;
import com.kosmo88.logistics_erp.util.ImageUploadHandler;

@SessionAttributes({ "session", "userid" })
@MultipartConfig(location = "D:\\Dev88\\workspace\\kosmo88_erp\\src\\main\\webapp\\resources\\hr\\image\\employee_tmp", fileSizeThreshold = 1024
        * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@Controller
@RequestMapping(value = "/hr/employee")
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    private static final String IMG_UPLOAD_DIR = "D:\\Dev88\\workspace\\kosmo88_erp\\src\\main\\webapp\\resources\\hr\\image\\employee_tmp\\";
    private ImageUploadHandler imageUploader;

    @Autowired
    EmployeeService employeeService;

    // 인사관리
    @RequestMapping(value = "")
    public String employeeManagement(HttpServletRequest req, HttpServletResponse res) {
        return "hr/employeeManagement/employeeManagement";
    }

    // 인사카드 등록 화면
    @RequestMapping(value = "/insertEmployee")
    public String insertEmployee(HttpServletRequest req, HttpServletResponse res) {
        employeeService.selectCode(req, res);
        return "hr/employeeManagement/insertEmployee";
    }

    // 인사카드 등록
    @RequestMapping(value = "/insertEmployeeAction")
    public String insertEmployeeAction(MultipartHttpServletRequest req, HttpServletResponse res) {
        MultipartFile mf = req.getFile("photo");

        if (mf != null) {
            System.out.println("this null");
            String originFileName = mf.getOriginalFilename(); // 원본 파일 명
            String safeFile = IMG_UPLOAD_DIR + originFileName;

            try {
                mf.transferTo(new File(safeFile));
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        employeeService.insertEmployee(req, res);
        return "hr/employeeManagement/insertEmployee";
    }

    // 인사카드 수정
    @RequestMapping(value = "/{id}/updateEmployeeAction")
    public String updateEmployeeAction(@PathVariable("id") String id, MultipartHttpServletRequest req,
            HttpServletResponse res) {
        MultipartFile mf = req.getFile("photo");
        String originFileName = mf.getOriginalFilename(); // 원본 파일 명
        String safeFile = IMG_UPLOAD_DIR + originFileName;

        try {
            mf.transferTo(new File(safeFile));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        employeeService.updateEmployeeAction(req, res, id);
        return "redirect:/hr/employee/{id}";
    }
}
