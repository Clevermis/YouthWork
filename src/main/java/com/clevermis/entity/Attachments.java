package com.clevermis.entity;

import java.sql.Date;

/**
 * @program: YouthWork
 * @description: 附件表
 * @author: Clevermis
 * @create: 2023-01-07 10:59
 * @since JDK 1.8
 **/
public class Attachments {

  /**
   * 附件ID
   */
  private Integer id;
  /**
   * 记录ID
   */
  private Integer record_id;
  /**
   * 文件名称
   */
  private String name;
  /**
   * 文件大小
   */
  private String size;
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
  private String[] att_img;

  public Attachments(Integer record_id,String[] att_img,String name,String size) {
    this.record_id = record_id;
    this.att_img = att_img;
    this.name = name;
    this.size = size;

  }

  public String[] getAtt_img() {
    return att_img;
  }

  public void setAtt_img(String[] att_img) {
    this.att_img = att_img;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getRecord_id() {
    return record_id;
  }

  public void setRecord_id(Integer record_id) {
    this.record_id = record_id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
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
    return "Attachments{" + "id=" + id + ", record_id=" + record_id + ", name='" + name + '\''
        + ", size='" + size + '\'' + ", timestamps=" + timestamps + ", softDeletes=" + softDeletes
        + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
  }
}
