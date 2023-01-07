package com.clevermis.dao.Upload;

import com.clevermis.entity.Attachments;
import com.clevermis.entity.Records;

/**
 * @program: YouthWork
 * @description:
 * @author: Clevermis
 * @create: 2023-01-08 00:42
 **/
public interface UploadImgDao {
    public int getRecordsIdMaxId();

    public boolean addFiles(Records goodsBean, int id, int form_id, String name, String code);

    public void addImg(Attachments addAttachImg);
}
