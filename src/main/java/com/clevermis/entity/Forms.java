package com.clevermis.entity;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @program: YouthWork
 * @description: 表单
 * @author: Clevermis
 * @create: 2023-01-07 10:44
 * @since JDK 1.8
 **/
public class Forms {

  /**
   * 表单ID
   */
  private Integer id;
  /**
   * 表单名称
   */
  private String name;
  /**
   * 创建时间
   */
  private Timestamp createdAt;
  /**
   * 状态
   */
  private Timestamp updatedAt;

  public Forms(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public Forms(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public Forms(String name) {
    this.name = name;
  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
    return "Forms{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", createdAt=" + createdAt +
        ", updatedAt=" + updatedAt +
        '}';
  }
}

