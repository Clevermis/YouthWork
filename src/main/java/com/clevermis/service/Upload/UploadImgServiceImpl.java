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

  private final UploadImgDao uploadImgDao;

  public UploadImgServiceImpl() {
    uploadImgDao = new UploadImgDaoImpl();
  }

  /**
   * @methodname RecordsIdMaxId  的功能描述 TODO:获取数据库记录ID最大值
   * @Param: * @param
   * @return: int
   * @throw:
   * @Author: Clevermis
   * @version: V1.0.0
   * @Date: 2023/1/8 11:55
   */
  public int RecordsIdMaxId() {
    int result = uploadImgDao.getRecordsIdMaxId();
    return result;
  }

  /**
   * @param id
   * @param form_id
   * @param name
   * @param code
   * @methodname addFile  的功能描述 TODO: 向数据库中添加记录基本信息
   * @Param: * @param records
   * @return: boolean
   * @throw:
   * @Author: Clevermis
   * @version: V1.0.0
   * @Date: 2023/1/8 11:50
   */
  public boolean addFile(Records records, int id, int form_id, String name, String code) {
    boolean b = uploadImgDao.addFiles(records, id, form_id, name, code);
    return b;
  }

  /**
   * @methodname addImg  的功能描述 TODO： 向数据库中添加文件信息
   * @Param: * @param addAttachImg
   * @return: void
   * @throw:
   * @Author: Clevermis
   * @version: V1.0.0
   * @Date: 2023/1/8 11:51
   */
  public void addImg(Attachments addAttachImg) {
    uploadImgDao.addImg(addAttachImg);
  }

}

