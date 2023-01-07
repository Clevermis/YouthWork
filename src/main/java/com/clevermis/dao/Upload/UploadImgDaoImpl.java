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
public class UploadImgDaoImpl implements UploadImgDao{
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
        }finally {
            DataBaseDao.closeResource(conn,pstm,rs);
        }
        return GoodsMaxId;
    }



    public boolean addFiles(Records goodsBean, int id, int form_id, String name, String code) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = DataBaseDao.getConnection();
            String sql = "INSERT INTO records (id,form_id,name,code)VALUES(?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,id);
            pstm.setInt(2,form_id);
            pstm.setString(3,name);
            pstm.setString(4,code);

            int b = pstm.executeUpdate();
            if (b > 0) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DataBaseDao.closeResource(conn,pstm,rs);
        }
        return false;
    }




    public  void addImg(Attachments addAttachImg ) {
        int record_id = addAttachImg.getRecord_id();
        String[] att_img = addAttachImg.getAtt_img();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        boolean b = true;
        try {
            conn = DataBaseDao.getConnection();
            for (int i = 0; i < att_img.length; i ++) {
                String sql = "insert into attachments (record_id,att_img) values("+record_id+","+ "\'" + "http://localhost:8080/static/imgs/" + att_img[i]+"\'"+")";
                pstm = conn.prepareStatement(sql);
                pstm.execute();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DataBaseDao.closeResource(conn,pstm,rs);
        }
    }
}
