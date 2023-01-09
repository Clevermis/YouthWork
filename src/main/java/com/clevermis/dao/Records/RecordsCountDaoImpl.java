package com.clevermis.dao.Records;

import com.clevermis.dao.DataBaseDao;
import com.clevermis.entity.Records;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: YouthWork
 * @description:
 * @author: Clevermis
 * @create: 2023-01-08 17:43
 * @since JDK 1.8
 **/
public class RecordsCountDaoImpl implements RecordsCountDao {

  /**
   * @methodname convertList  的功能描述 TODO:将rs查询结果封装为List<Map<String, Object>>对象
   * @Param: * @param rs
   * @return: java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
   * @throw:
   * @Author: Clevermis
   * @version: V1.0.0
   * @Date: 2023/1/8 21:16
   */
  public static List<Map<String, Object>> convertList(ResultSet rs) {
    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    try {
      ResultSetMetaData md = rs.getMetaData();
      int columnCount = md.getColumnCount();
      while (rs.next()) {
        Map<String, Object> rowData = new HashMap<String, Object>();
        for (int i = 1; i <= columnCount; i++) {
          rowData.put(md.getColumnName(i), rs.getObject(i));
        }
        list.add(rowData);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (rs != null) {
          rs.close();
        }
        rs = null;
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return list;
  }

  /**
   * @param form_id
   * @methodname getrecords  的功能描述 TODO:输出记录ID对应的表单
   * @Param: * @param records
   * @return: java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
   * @throw:
   * @Author: Clevermis
   * @version: V1.0.0
   * @Date: 2023/1/8 21:18
   */
  @Override
  public List<Map<String, Object>> getrecords(Records records, int form_id) {
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    try {
      conn = DataBaseDao.getConnection();
      String sql =
          "SELECT records.`name`,records.`code`,attachments.size ,attachments.att_img ,attachments.updatedAt FROM `records` INNER JOIN `attachments` ON  records.id = attachments.record_id WHERE records.form_id ="
              + form_id;
      pstm = conn.prepareStatement(sql);
      System.out.println(sql);
      rs = pstm.executeQuery();
      List<Map<String, Object>> list = convertList(rs);
      return list;
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      DataBaseDao.closeResource(conn, pstm, rs);
    }
    return null;
  }

}

