package com.clevermis.service.forms;

import com.clevermis.entity.Forms;

/**
 * @program: YouthWork
 * @description:
 * @author: Clevermis
 * @create: 2023-01-08 16:16
 **/
public interface FormCreateService {

  /**
   * @param name
   * @methodname addFile  的功能描述 TODO:创建表单并提交表单名称
   * @Param: * @param forms
   * @return: boolean
   * @throw:
   * @Author: Clevermis
   * @version: V1.0.0
   * @Date: 2023/1/8 16:58
   */
  boolean addFile(Forms forms, String name);

}
