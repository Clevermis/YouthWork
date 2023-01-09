package com.clevermis.servlet.PackDown;

import com.clevermis.util.FolderToZipUtil;
import com.sun.xml.internal.bind.util.Which;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: YouthWork
 * @description: 打包下载
 * @author: Clevermis
 * @create: 2023-01-09 12:18
 * @since JDK 1.8
 **/
@WebServlet(name = "PackServlet", value = "/packservlet")
@MultipartConfig
public class PackServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException{

    String att_img =request.getParameter("att_img") ;
    String name = request.getParameter("name");
        downloadZip (response,name,att_img);
  }

  public void downloadZip (HttpServletResponse response,String name , String att_img) {
    String path = this.getServletContext().getRealPath("/");
    String ID = att_img;
    String zipPath = path+ID;
    String namezip = name;
    /** 创建指定目录和文件名称的文件对象*/
    File file = new File(zipPath);
    try {
      FolderToZipUtil.zip(zipPath,response,namezip);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }



  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

}
