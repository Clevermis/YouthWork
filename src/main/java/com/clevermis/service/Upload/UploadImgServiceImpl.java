package com.clevermis.service.Upload;

import com.clevermis.dao.Upload.UploadImgDao;
import com.clevermis.dao.Upload.UploadImgDaoImpl;
import com.clevermis.entity.Attachments;
import com.clevermis.entity.Records;

/**
 * @program: YouthWork
 * @description:
 * @author: Clevermis
 * @create: 2023-01-08 00:36
 * @since JDK 1.8
 **/
public class UploadImgServiceImpl implements UploadImgService {
    private UploadImgDao uploadImgDao;

    public UploadImgServiceImpl() {
         uploadImgDao = (UploadImgDao) new UploadImgDaoImpl();
    }


    public int RecordsIdMaxId() {
        int result = uploadImgDao.getRecordsIdMaxId();
        return result;
    }

    public boolean addFile(Records records, int id, int form_id, String name, String code) {
        boolean b = uploadImgDao.addFiles(records, id, form_id, name, code);
        return b;
    }

    public void addImg(Attachments addAttachImg) {
        uploadImgDao.addImg(addAttachImg);
    }

}

