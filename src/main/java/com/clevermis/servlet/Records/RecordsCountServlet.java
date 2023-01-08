package com.clevermis.servlet.Records;

import com.alibaba.fastjson.JSON;
import com.clevermis.entity.Records;
import com.clevermis.service.Records.RecordsCountServiceImpl;
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
 * @description:
 * @author: Clevermis
 * @create: 2023-01-08 17:41
 * @since JDK 1.8
 **/
@WebServlet(name = "RecordsCountServlet", value = "/recordscountservlet")
@MultipartConfig
public class RecordsCountServlet extends HttpServlet {

  /**
   * @param response
   * @methodname doGet  的功能描述 TODO:输出记录ID对应的表单
   * @Param: * @param request
   * @return: void
   * @throw:
   * @Author: Clevermis
   * @version: V1.0.0
   * @Date: 2023/1/8 21:14
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int form_id = Integer.parseInt(request.getParameter("form_id"));

    RecordsCountServiceImpl recordsCountService = new RecordsCountServiceImpl();
    Records records = new Records(form_id);
    PrintWriter out = response.getWriter();
    Object recordsList = recordsCountService.getRecordsList(records, form_id);
    String jsonArray = JSON.toJSONString(recordsList);
    out.write(jsonArray);
    out.flush();
    out.close();

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    this.doGet(request, response);
  }

}
