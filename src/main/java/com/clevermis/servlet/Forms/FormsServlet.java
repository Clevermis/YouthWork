package com.clevermis.servlet.Forms;

import com.alibaba.fastjson.JSON;
import com.clevermis.entity.Forms;
import com.clevermis.service.forms.FormsService;
import com.clevermis.service.forms.FormsServiceImpl;
import com.mysql.cj.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.System.out;

/**
 * @program: YouthWork
 * @description:
 * @author: Clevermis
 * @create: 2023-01-07 13:10
 * @since JDK 1.8
 **/

@WebServlet(name = "FormsServlet", value = "/FormsList")
public class FormsServlet extends HttpServlet {
    /**
    * @methodname  doGet  的功能描述 TODO:打印表单ID及表单名称
    *
    * @Param:  * @param request
     * @param response
    * @return: void
    * @throw: ServletException, IOException
    *
    * @Author: Clevermis
    * @version: V1.0.0
    * @Date: 2023/1/7 13:30
    */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FormsServiceImpl formsService = new FormsServiceImpl();
        Object formsList = formsService.getFormsList();
        Object jsonArray = JSON.toJSONString(formsList);
        response.getWriter().println(jsonArray);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}


