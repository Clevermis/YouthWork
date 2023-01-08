package com.clevermis.entity;

import java.sql.Date;

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
   * 时间戳
   */
  private Date timestamps;
  /**
   * 删除
   */
  private Date softDeletes;
  /**
   * 创建时间
   */
  private Date createdAt;
  /**
   * 状态
   */
  private Date updatedAt;

  public Forms(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public Forms(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public Forms(String name) {
    this.name=name;
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

  public Date getTimestamps() {
    return timestamps;
  }

  public void setTimestamps(Date timestamps) {
    this.timestamps = timestamps;
  }

  public Date getSoftDeletes() {
    return softDeletes;
  }

  public void setSoftDeletes(Date softDeletes) {
    this.softDeletes = softDeletes;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public String toString() {
    return "Forms{" + "id=" + id + ", name='" + name + '\'' + ", timestamps=" + timestamps
        + ", softDeletes=" + softDeletes + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
        + '}';
  }
}

