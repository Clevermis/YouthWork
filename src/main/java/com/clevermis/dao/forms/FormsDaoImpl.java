package com.clevermis.dao.forms;

import com.clevermis.dao.DataBaseDao;
import com.clevermis.entity.Forms;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: YouthWork
 * @description: 实现类
 * @author: Clevermis
 * @create: 2023-01-07 12:48
 * @since JDK 1.8
 **/
public class FormsDaoImpl implements FormsDao {

  /**
   * @methodname getforms  的功能描述 TODO:获取Forms表单数据  id及name
   * @Param: * @param
   * @return: java.lang.Object
   * @throw:
   * @Author: Clevermis
   * @version: V1.0.0
   * @Date: 2023/1/7 12:55
   */
  public Object getforms() {
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    List<Forms> list = new ArrayList<>();
    try {
      conn = DataBaseDao.getConnection();
      String sql = "select * from forms";
      pstm = conn.prepareStatement(sql);
      rs = pstm.executeQuery();
      while (rs.next()) {
        list.add(new Forms(rs.getInt("id"), rs.getString("name")));
      }
      return list;
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      DataBaseDao.closeResource(conn, pstm, rs);
    }
    return list;
  }
}