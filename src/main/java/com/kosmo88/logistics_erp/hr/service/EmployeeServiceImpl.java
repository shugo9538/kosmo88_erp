package com.kosmo88.logistics_erp.hr.service;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.kosmo88.logistics_erp.hr.dao.ConfigurationDAO;
import com.kosmo88.logistics_erp.hr.dao.EmployeeDAO;
import com.kosmo88.logistics_erp.hr.dto.AttendanceCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.DepartmentCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.EmployeeDTO;
import com.kosmo88.logistics_erp.hr.dto.HRCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.PositionCodeDTO;
import com.kosmo88.logistics_erp.util.QueryCode;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDAO employeeDAO;

    @Autowired
    ConfigurationDAO configDAO;

    QueryCode state;

    @Override
    public ArrayList<EmployeeDTO> employeeManagement() {
        return (ArrayList<EmployeeDTO>) employeeDAO.employeeList();
    }

    @Override
    public void insertEmployee(MultipartHttpServletRequest req, HttpServletResponse res) {
        MultipartFile file = req.getFile("photo");

        String photo = "/logistics_erp/resources/hr/image/employee_tmp/" + file.getOriginalFilename();

        EmployeeDTO dto = new EmployeeDTO();
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        int department_id = Integer.parseInt(req.getParameter("department_id"));
        String email1 = req.getParameter("email1");
        String email2 = req.getParameter("email2");
        StringBuilder sb = new StringBuilder(email1).append("@").append(email2);
        String email = sb.toString();
        System.out.println(email);
        Date hire_date = Date.valueOf(req.getParameter("hire_date"));
        String phone1 = req.getParameter("phone1");
        String phone2 = req.getParameter("phone2");
        String phone3 = req.getParameter("phone3");
        StringBuilder sb2 = new StringBuilder(phone1).append("-").append(phone2).append("-").append(phone3);
        String phone = sb2.toString();
        System.out.println(phone);
        int position_id = Integer.parseInt(req.getParameter("position_id"));
        String resident_reg_num1 = req.getParameter("resident_reg_num1");
        String resident_reg_num2 = req.getParameter("resident_reg_num2");
        StringBuilder sb3 = new StringBuilder(resident_reg_num1).append("-").append(resident_reg_num2);
        String resident_reg_num = sb3.toString();
        System.out.println(resident_reg_num);
        String id = "";
        String detail_address = req.getParameter("detail_address");
        System.out.println("address : " + address);
        System.out.println("detail_address" + detail_address);
        int zip_code = Integer.parseInt(req.getParameter("zip_code"));
        switch (position_id) {
        case 100:
            id = "HR";
            break;
        case 200:
            id = "ACT";
            break;
        case 300:
            id = "SAL";
            break;
        case 400:
            id = "PUR";
            break;

        default:
            id = "WMS";
            break;
        }

        dto.setId(id);
        dto.setPhoto(photo);
        dto.setName(name);
        dto.setAddress(address);
        dto.setDepartment_id(department_id);
        dto.setEmail(email);
        dto.setEnabled('Y');
        dto.setHire_date(hire_date);
        dto.setPhone(phone);
        dto.setPosition_id(position_id);
        dto.setResident_reg_num(resident_reg_num);
        dto.setDetail_address(detail_address);
        dto.setZip_code(zip_code);

        state = QueryCode.INSERT;
        req.setAttribute("insert_code", state.check(employeeDAO.insertEmployee(dto)));
    }

    @Override
    public void selectCode(HttpServletRequest req, HttpServletResponse res) {
        ArrayList<DepartmentCodeDTO> departmentCodeDTOs = (ArrayList<DepartmentCodeDTO>) configDAO.selectDepartments();
        ArrayList<PositionCodeDTO> positionCodeDTOs = (ArrayList<PositionCodeDTO>) configDAO.selectPosition();

        req.setAttribute("departmentCodeDTOs", departmentCodeDTOs);
        req.setAttribute("positionCodeDTOs", positionCodeDTOs);
    }

    @Override
    public void detailEmployee(ModelAndView mav, String id) {
        EmployeeDTO dto = employeeDAO.detailEmployee(id);
        mav.addObject("employee", dto);
    }

    @Override
    public void updateEmployee(ModelAndView mav, String id) {
        ArrayList<DepartmentCodeDTO> departmentCodeDTOs = (ArrayList<DepartmentCodeDTO>) configDAO.selectDepartments();
        ArrayList<PositionCodeDTO> positionCodeDTOs = (ArrayList<PositionCodeDTO>) configDAO.selectPosition();
        EmployeeDTO dto = employeeDAO.detailEmployee(id);

        mav.addObject("departmentCodeDTOs", departmentCodeDTOs);
        mav.addObject("positionCodeDTOs", positionCodeDTOs);
        mav.addObject("employee", dto);
    }

    @Override
    public void updateEmployeeAction(MultipartHttpServletRequest req, HttpServletResponse res, String id) {
        MultipartFile file = req.getFile("photo");
        String photo;
        if(file != null) {
            photo = "/logistics_erp/resources/hr/image/employee_tmp/" + file.getOriginalFilename();
        } else {
            photo = req.getParameter("img");
        }

        EmployeeDTO dto = new EmployeeDTO();
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        int department_id = Integer.parseInt(req.getParameter("department_id"));
        String email1 = req.getParameter("email1");
        String email2 = req.getParameter("email2");
        StringBuilder sb = new StringBuilder(email1).append("@").append(email2);
        String email = sb.toString();
        System.out.println(email);
        Date hire_date = Date.valueOf(req.getParameter("hire_date"));
        String phone1 = req.getParameter("phone1");
        String phone2 = req.getParameter("phone2");
        String phone3 = req.getParameter("phone3");
        StringBuilder sb2 = new StringBuilder(phone1).append("-").append(phone2).append("-").append(phone3);
        String phone = sb2.toString();
        System.out.println(phone);
        int position_id = Integer.parseInt(req.getParameter("position_id"));
        String resident_reg_num1 = req.getParameter("resident_reg_num1");
        String resident_reg_num2 = req.getParameter("resident_reg_num2");
        StringBuilder sb3 = new StringBuilder(resident_reg_num1).append("-").append(resident_reg_num2);
        String resident_reg_num = sb3.toString();
        System.out.println(resident_reg_num);
        String detail_address = req.getParameter("detail_address");
        System.out.println("address : " + address);
        System.out.println("detail_address" + detail_address);
        int zip_code = Integer.parseInt(req.getParameter("zip_code"));

        dto.setPhoto(photo);
        dto.setId(id);
        dto.setName(name);
        dto.setAddress(address);
        dto.setDepartment_id(department_id);
        dto.setEmail(email);
        dto.setEnabled('Y');
        dto.setHire_date(hire_date);
        dto.setPhone(phone);
        dto.setPosition_id(position_id);
        dto.setResident_reg_num(resident_reg_num);
        dto.setDetail_address(detail_address);
        dto.setZip_code(zip_code);

        state = QueryCode.UPDATE;
        req.setAttribute("update_code", state.check(employeeDAO.updateEmployee(dto)));
    }

    @Override
    public void signIn(ModelAndView mav, String id) {
        EmployeeDTO dto = employeeDAO.detailEmployee(id);

        mav.addObject("employee", dto);
    }
}
