package com.clevermis.servlet.Upload;

import com.clevermis.entity.Attachments;
import com.clevermis.entity.Records;
import com.clevermis.service.Upload.UploadImgServiceImpl;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * @program: untitled666
 * @description: 上传文件
 * @author: Clevermis
 * @create: 2023-01-07 20:35
 * @since JDK 1.8
 **/
@WebServlet(name = "UploadImgServlet", value = "/uploadServlet")
@MultipartConfig
public class UploadImgServlet extends HttpServlet {

  /**
   * @param response
   * @methodname doGet  的功能描述 TODO:上传文件 若成功则返回true 失败则返回false
   * @Param: * @param request
   * @return: void
   * @throw:
   * @Author: Clevermis
   * @version: V1.0.0
   * @Date: 2023/1/8 14:32
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setHeader("Access-Control-Allow-Credentials", "true");
    response.setHeader("Access-Control-Allow-Expose-Headers", "X-forward-port,X-forwarded-host");
    response.setHeader("Access-Control-Allow-Origin", "*");
    response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE");
    response.setHeader("Access-Control-Max-Age", "3600");

    /**获取普通表单项*/
    String name = request.getParameter("name");
    String code = request.getParameter("code");
    int form_id = Integer.parseInt(request.getParameter("form_id"));
    String size = request.getParameter("size");

    /**得到当前web项目的根目录，并在根目录中添加一个子文件夹/static/imgs*/
    String path = this.getServletContext().getRealPath("/static/imgs");
    File file = new File(path);
    if (!file.exists()) {
      /**若不存在则创建*/
      file.mkdirs();
    }

    UploadImgServiceImpl uploadImgService = new UploadImgServiceImpl();
    int id = 0;
    id = uploadImgService.RecordsIdMaxId() + 1;
    Records records = new Records(id, form_id, name, code);
    /**向数据库中添加记录信息,成功返回true*/
    boolean b = uploadImgService.addFile(records, id, form_id, name, code);
    int record_id = id;
    PrintWriter out = response.getWriter();
    for (Part part : request.getParts()) {
      if (part.getName().startsWith("myfile")) {
        String fileName = getFileName(part);
        String tup = UUID.randomUUID() + fileName;
        part.write(path + "\\" + tup);
        String[] att_img = {tup};
        Attachments addAttachImg = new Attachments(record_id, att_img, tup, size);
        uploadImgService.addImg(addAttachImg);
      }
    }
    out.write(String.valueOf(b));
  }

  /**
   * @methodname getFileName  的功能描述 TODO:获取图片的具体内容
   * @Param: * @param part
   * @return: java.lang.String
   * @throw:
   * @Author: Clevermis
   * @version: V1.0.0
   * @Date: 2023/1/8 11:29
   */
  private String getFileName(Part part) {
    String header = part.getHeader("Content-Disposition");
    String fname = header.substring(header.lastIndexOf("."), header.length() - 1);
    return fname;
  }


  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
