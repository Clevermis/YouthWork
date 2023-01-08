package com.clevermis.servlet.Forms;

import com.clevermis.entity.Forms;
import com.clevermis.service.forms.FormCreateServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: YouthWork
 * @description: 创建表单
 * @author: Clevermis
 * @create: 2023-01-08 16:15
 * @since JDK 1.8
 **/
@WebServlet(name = "FormCreateServlet", value = "/formcreateservlet")
@MultipartConfig
public class FormCreateServlet extends HttpServlet {

  /**
   * @param response
   * @methodname doGet  的功能描述 TODO:创建表单 成功返回true,失败返回false
   * @Param: * @param request
   * @return: void
   * @throw:
   * @Author: Clevermis
   * @version: V1.0.0
   * @Date: 2023/1/8 16:57
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String name = request.getParameter("name");
    PrintWriter out = response.getWriter();
    FormCreateServiceImpl formCreateService = new FormCreateServiceImpl();
    Forms forms = new Forms(name);
    boolean b = formCreateService.addFile(forms, name);
    out.write(String.valueOf(b));
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    this.doGet(request, response);
  }

}
