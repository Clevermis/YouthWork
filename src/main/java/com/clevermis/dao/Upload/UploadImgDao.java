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

  /**
   * @methodname getRecordsIdMaxId  的功能描述 TODO:得到记录最大值
   * @Param: * @param
   * @return: int
   * @throw:
   * @Author: Clevermis
   * @version: V1.0.0
   * @Date: 2023/1/8 12:04
   */
  int getRecordsIdMaxId();

  /**
   * @param id
   * @param form_id
   * @param name
   * @param code
   * @methodname addFiles  的功能描述 TODO:添加记录基础数据
   * @Param: * @param goodsBean
   * @return: boolean
   * @throw:
   * @Author: Clevermis
   * @version: V1.0.0
   * @Date: 2023/1/8 12:05
   */
  boolean addFiles(Records goodsBean, int id, int form_id, String name, String code);

  /**
   * @methodname addImg  的功能描述 TODO:添加文件（图片）信息
   * @Param: * @param addAttachImg
   * @return: void
   * @throw:
   * @Author: Clevermis
   * @version: V1.0.0
   * @Date: 2023/1/8 12:05
   */
  void addImg(Attachments addAttachImg);
}
