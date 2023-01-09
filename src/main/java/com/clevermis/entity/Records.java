package com.clevermis.entity;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @program: YouthWork
 * @description: 记录表
 * @author: Clevermis
 * @create: 2023-01-07 10:54
 * @since JDK 1.8
 **/
public class Records {

  /**
   * 记录ID
   */
  private Integer id;
  /**
   * 表单ID
   */
  private Integer form_id;
  /**
   * 姓名
   */
  private String name;
  /**
   * 学号
   */
  private String code;
  /**
   * 创建时间
   */
  private Timestamp createdAt;
  /**
   * 状态
   */
  private Timestamp updatedAt;

  public Records(Integer id, Integer form_id, String name, String code) {
    this.id = id;
    this.form_id = form_id;
    this.name = name;
    this.code = code;
  }

  public Records(int form_id) {
    this.form_id=form_id;
  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getForm_id() {
    return form_id;
  }

  public void setForm_id(Integer form_id) {
    this.form_id = form_id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  public Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public String toString() {
    return "Records{" +
        "id=" + id +
        ", form_id=" + form_id +
        ", name='" + name + '\'' +
        ", code='" + code + '\'' +
        ", createdAt=" + createdAt +
        ", updatedAt=" + updatedAt +
        '}';
  }

  public void Records(int goods_id, int sort_id, String goods_name, String goods_price,
      String goods_describe, java.util.Date goods_time, int user_id) {

  }

}
