package com.clevermis.service.forms;

import com.clevermis.dao.forms.FormCreateDao;
import com.clevermis.dao.forms.FormCreateDaoImpl;
import com.clevermis.entity.Forms;

/**
 * @program: YouthWork
 * @description:
 * @author: Clevermis
 * @create: 2023-01-08 16:16
 * @since JDK 1.8
 **/
public class FormCreateServiceImpl implements FormCreateService {

  private final FormCreateDao formCreateDao;

  public FormCreateServiceImpl() {
    formCreateDao = new FormCreateDaoImpl();
  }

  /**
   * @param name
   * @methodname addFile  的功能描述 TODO：创建表单并提交表单名称
   * @Param: * @param forms
   * @return: boolean
   * @throw:
   * @Author: Clevermis
   * @version: V1.0.0
   * @Date: 2023/1/8 17:00
   */
  @Override
  public boolean addFile(Forms forms, String name) {
    boolean b = formCreateDao.addFiles(forms, name);
    return b;
  }
}
