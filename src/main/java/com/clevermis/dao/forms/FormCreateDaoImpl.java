package com.clevermis.dao.forms;

import com.clevermis.dao.DataBaseDao;
import com.clevermis.entity.Forms;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: YouthWork
 * @description:
 * @author: Clevermis
 * @create: 2023-01-08 16:17
 * @since JDK 1.8
 **/
public class FormCreateDaoImpl implements FormCreateDao {

  /**
   * @param name
   * @methodname addFiles  的功能描述 TODO:创建表单并提交表单名称
   * @Param: * @param forms
   * @return: boolean
   * @throw:
   * @Author: Clevermis
   * @version: V1.0.0
   * @Date: 2023/1/8 17:01
   */
  public boolean addFiles(Forms forms, String name) {
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    try {
      conn = DataBaseDao.getConnection();
      String sql = "INSERT INTO forms (name)VALUES(?)";
      pstm = conn.prepareStatement(sql);
      pstm.setString(1, name);
      int b = pstm.executeUpdate();
      if (b > 0) {
        return true;
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      DataBaseDao.closeResource(conn, pstm, rs);
    }
    return false;
  }


}
