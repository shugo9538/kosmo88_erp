package com.kosmo88.logistics_erp.member.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kosmo88.logistics_erp.member.dao.UserDAO;
import com.kosmo88.logistics_erp.member.dto.UserDTO;
import com.kosmo88.logistics_erp.util.QueryCode;

import io.grpc.netty.shaded.io.netty.channel.unix.Buffer;

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
    }

    @Override
    public void showChart(HttpServletRequest req, Model model) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("python", "D:/Dev88/workspace_python/kosmo88erp_django/test.py");
        Process p = pb.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "utf-8"));
        try {
            String line = "";
            while ((line = br.readLine()) != null) {
                
            }
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
