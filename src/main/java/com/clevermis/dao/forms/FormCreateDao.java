package com.clevermis.dao.forms;

import com.clevermis.entity.Forms;

/**
 * @program: YouthWork
 * @description:
 * @author: Clevermis
 * @create: 2023-01-08 16:17
 **/
public interface FormCreateDao {

  /**
   * @param name
   * @methodname addFiles  的功能描述 TODO：创建表单并提交表单名称
   * @Param: * @param forms
   * @return: boolean
   * @throw:
   * @Author: Clevermis
   * @version: V1.0.0
   * @Date: 2023/1/8 17:00
   */
  boolean addFiles(Forms forms, String name);

}
