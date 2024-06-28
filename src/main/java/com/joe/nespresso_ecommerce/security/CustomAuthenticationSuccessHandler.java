package com.joe.nespresso_ecommerce.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;

import com.joe.nespresso_ecommerce.entity.User;
import com.joe.nespresso_ecommerce.repository.UserRepository;
import com.joe.nespresso_ecommerce.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

    @Autowired
    @Lazy
    UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        
        HttpSession session = request.getSession();
        
        //Adding the user to the session
        User user = userService.findByUsername(authentication.getName());
        session.setAttribute("user", user);

        //Setting session loggedin attribute to true
        Boolean loggedin = true;
        session.setAttribute("loggedin", loggedin);

        //redirecting to homepage
        response.sendRedirect("/");
    }

    
    
}
