package com.clevermis.servlet.Upload;

import com.clevermis.entity.Attachments;
import com.clevermis.entity.Records;
import com.clevermis.service.Upload.UploadImgService;
import com.clevermis.service.Upload.UploadImgServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @program: untitled666
 * @description:
 * @author: Clevermis
 * @create: 2023-01-07 20:35
 * @since JDK 1.8
 **/
@WebServlet(name = "UploadImgServlet", value = "/uploadServlet")
@MultipartConfig
public class UploadImgServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Expose-Headers", "X-forward-port,X-forwarded-host");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");

        String name = request.getParameter("name");
        String code = request.getParameter("code");
        int form_id = Integer.parseInt(request.getParameter("form_id"));


        String path = this.getServletContext().getRealPath("/static/imgs");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        UploadImgServiceImpl uploadImgService = new UploadImgServiceImpl();
        int id = 0;
        id = uploadImgService.RecordsIdMaxId() + 1;
        Records records = new Records(id, form_id, name, code);
        boolean b = uploadImgService.addFile(records, id, form_id, name, code);
        int record_id = id;
        for (Part part : request.getParts()) {
            if (part.getName().startsWith("myfile")) {
                String fileName = getFileName(part);
                String tup = UUID.randomUUID() + fileName;
                part.write(path + "\\" + tup);
                String[] att_img = {tup};
                Attachments addAttachImg = new Attachments(record_id, att_img);
                uploadImgService.addImg(addAttachImg);
            }
        }
    }

    private String getFileName(Part part) {
        String header = part.getHeader("Content-Disposition");
        String fname = header.substring(header.lastIndexOf("."), header.length() - 1);
        return fname;
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
