package com.kosmo88.logistics_erp.member.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kosmo88.logistics_erp.dto.UserDTO;
import com.kosmo88.logistics_erp.member.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    BCryptPasswordEncoder pwEncoder;

    @Autowired
    UserDAO userDAO;

    @Override
    public void signinAction(HttpServletRequest req, Model model) {
        UserDTO dto = new UserDTO();

        dto.setUserid(req.getParameter("userid"));
        dto.setUsername(req.getParameter("username"));
        dto.setTel(req.getParameter("tel"));

        String password = req.getParameter("password");
        String encodingPW = pwEncoder.encode(password);
        dto.setPassword(encodingPW);
        dto.setKey("temp");
        
        int success = userDAO.insertUser(dto);
        System.out.println(success);
    }
}
