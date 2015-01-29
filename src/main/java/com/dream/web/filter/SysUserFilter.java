package com.dream.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.dream.service.UserService;


public class SysUserFilter extends PathMatchingFilter {

    @Autowired
    private UserService userService;

    protected boolean onPreHandle(HttpServletRequest request, HttpServletResponse response, Object mappedValue) throws Exception {
    	HttpSession session = request.getSession();
    	String username = (String)SecurityUtils.getSubject().getPrincipal();
        session.setAttribute("user", userService.findByUsername(username));
        return true;
    }

}
