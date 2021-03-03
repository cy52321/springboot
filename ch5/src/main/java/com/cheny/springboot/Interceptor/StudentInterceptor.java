package com.cheny.springboot.Interceptor;

import com.cheny.springboot.domain.Student;
import com.cheny.springboot.service.impl.Myserviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentInterceptor implements HandlerInterceptor {
    @Autowired
    private Myserviceimpl myserviceimpl;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Student student1= (Student) request.getSession().getAttribute("user");
       /* Student student=myserviceimpl.sel(student1.getId(),student1.getAge());*/
        if(student1==null){
           /* request.getRequestDispatcher("/stu/er.jsp").forward(request,response);*/
            response.sendRedirect(request.getContextPath()+ "/er.jsp");
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
