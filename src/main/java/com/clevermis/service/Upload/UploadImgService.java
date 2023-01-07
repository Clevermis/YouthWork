package com.clevermis.service.Upload;

import com.clevermis.entity.Attachments;
import com.clevermis.entity.Records;

/**
 * @program: YouthWork
 * @description:
 * @author: Clevermis
 * @create: 2023-01-08 00:36
 **/
public interface UploadImgService {
    public int RecordsIdMaxId();

    public boolean addFile(Records records, int id, int form_id, String name, String code);

    public void addImg(Attachments addAttachImg);
}
