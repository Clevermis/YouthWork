package com.clevermis.service.forms;

import com.clevermis.dao.forms.FormsDao;
import com.clevermis.dao.forms.FormsDaoImpl;

/**
 * @program: YouthWork
 * @description:
 * @author: Clevermis
 * @create: 2023-01-07 13:03
 * @since JDK 1.8
 **/
public class FormsServiceImpl implements FormsService {

  private final FormsDao forms;

  public FormsServiceImpl() {
    forms = new FormsDaoImpl();
  }

  /**
   * @methodname getFormsList  的功能描述 TODO:查询表单
   * @Param: * @param
   * @return: java.lang.Object
   * @throw:
   * @Author: Clevermis
   * @version: V1.0.0
   * @Date: 2023/1/8 12:00
   */
  @Override
  public Object getFormsList() {
    return forms.getforms();
  }
}
