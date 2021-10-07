package com.kosmo88.logistics_erp.member.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kosmo88.logistics_erp.member.dao.UserDAO;
import com.kosmo88.logistics_erp.member.dto.UserDTO;
import com.kosmo88.logistics_erp.util.QueryCode;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    BCryptPasswordEncoder pwEncoder;

    @Autowired
    UserDAO userDAO;

    QueryCode code;

    @Override
    public void signinAction(HttpServletRequest req, Model model) {
        UserDTO dto = new UserDTO();

        dto.setId(req.getParameter("userid"));
        dto.setEmployee_id(req.getParameter("username"));
        String password = req.getParameter("password");
        String encodingPW = pwEncoder.encode(password);
        dto.setPassword(encodingPW);
        dto.setAuthorities(req.getParameter("authority"));
        dto.setEnabled('Y');
        code = QueryCode.INSERT;
        System.out.println(code.check(userDAO.insertUser(dto)));
    }
}
