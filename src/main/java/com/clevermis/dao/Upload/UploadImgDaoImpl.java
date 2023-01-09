package com.clevermis.dao.Upload;

import com.clevermis.dao.DataBaseDao;
import com.clevermis.entity.Attachments;
import com.clevermis.entity.Records;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: untitled666
 * @description:
 * @author: Clevermis
 * @create: 2023-01-07 20:47
 * @since JDK 1.8
 **/
public class UploadImgDaoImpl implements UploadImgDao {

  /**
   * @methodname getRecordsIdMaxId  的功能描述 TODO:得到记录最大值
   * @Param: * @param
   * @return: int
   * @throw:
   * @Author: Clevermis
   * @version: V1.0.0
   * @Date: 2023/1/8 12:03
   */
  public int getRecordsIdMaxId() {
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    int GoodsMaxId = 0;
    try {
      conn = DataBaseDao.getConnection();
      String sql = "SELECT MAX(id) FROM records;";
      pstm = conn.prepareStatement(sql);
      rs = pstm.executeQuery();
      while (rs.next()) {
        GoodsMaxId = rs.getInt(1);
      }
      return GoodsMaxId;
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      DataBaseDao.closeResource(conn, pstm, rs);
    }
    return GoodsMaxId;
  }

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
   * @Date: 2023/1/8 12:03
   */
  public boolean addFiles(Records records, int id, int form_id, String name, String code) {
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    try {
      conn = DataBaseDao.getConnection();
      String sql = "INSERT INTO records (id,form_id,name,code)VALUES(?,?,?,?)";
      pstm = conn.prepareStatement(sql);
      pstm.setInt(1, id);
      pstm.setInt(2, form_id);
      pstm.setString(3, name);
      pstm.setString(4, code);

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

  /**
   * @param flag
   * @methodname addImg  的功能描述 TODO:添加文件（图片）信息
   * @Param: * @param addAttachImg
   * @return: void
   * @throw:
   * @Author: Clevermis
   * @version: V1.0.0
   * @Date: 2023/1/9 14:54
   */
  public void addImg(Attachments addAttachImg, int flag) {
    int record_id = addAttachImg.getRecord_id();
    String[] att_img = addAttachImg.getAtt_img();
    String fileName = addAttachImg.getName();
    String size = addAttachImg.getSize();
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    boolean b = true;
    if (flag == 0) {
      /**  windows*/
      try {
        conn = DataBaseDao.getConnection();
        for (int i = 0; i < att_img.length; i++) {
          String sql =
              "insert into attachments (record_id,att_img,name,size) values(" + record_id + ","
                  + "'" + "/" + "static" + "/" + "imgs" + "/" + att_img[i] + "'" + "," + "'"
                  + fileName + "'" + "," + "'" + size + "'" + ")";
          pstm = conn.prepareStatement(sql);
          pstm.execute();
        }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      } finally {
        DataBaseDao.closeResource(conn, pstm, rs);
      }
    } else {
      try {
        conn = DataBaseDao.getConnection();
        for (int i = 0; i < att_img.length; i++) {
          String sql =
              "insert into attachments (record_id,att_img,name,size) values(" + record_id + ","
                  + "'" + "\\\\" + "static" + "\\\\" + "imgs" + "\\\\" + att_img[i] + "'" + ","
                  + "'" + fileName + "'" + "," + "'" + size + "'" + ")";
          pstm = conn.prepareStatement(sql);
          pstm.execute();
        }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      } finally {
        DataBaseDao.closeResource(conn, pstm, rs);
      }
    }
  }
}




