package com.clevermis.entity;

import java.sql.Date;

/**
 * @program: YouthWork
 * @description: 路径表
 * @author: Clevermis
 * @create: 2023-01-07 11:13
 * @since JDK 1.8
 **/
public class Conference {

  /**
   * 路径ID
   */
  private Integer conference_id;
  /**
   * 附件ID
   */
  private Integer id;
  /**
   * 文件名称
   */
  private String name;
  /**
   * 文件路径
   */
  private String img;
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

  public Integer getConference_id() {
    return conference_id;
  }

  public void setConference_id(Integer conference_id) {
    this.conference_id = conference_id;
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

  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
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
    return "Conference{" + "conference_id=" + conference_id + ", id=" + id + ", name='" + name
        + '\'' + ", img='" + img + '\'' + ", timestamps=" + timestamps + ", softDeletes="
        + softDeletes + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
  }
}
