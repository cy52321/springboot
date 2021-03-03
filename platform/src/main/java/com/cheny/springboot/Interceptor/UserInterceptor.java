package com.cheny.springboot.Interceptor;

import com.cheny.springboot.domain.User;
import com.cheny.springboot.service.impl.Myserviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor implements HandlerInterceptor {
    @Autowired
    private Myserviceimpl myserviceimpl;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user= (User) request.getSession().getAttribute("user");
       /* Student student=myserviceimpl.sel(student1.getId(),student1.getAge());*/
        if(user==null){
           /* request.getRequestDispatcher("/stu/er.jsp").forward(request,response);*/
            response.sendRedirect(request.getContextPath()+ "/login_error.html");
            System.out.println(request.getContextPath());
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
