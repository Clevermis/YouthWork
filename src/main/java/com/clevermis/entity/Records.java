package com.clevermis.entity;

import java.sql.Date;

/**
 * @program: YouthWork
 * @description: 记录表
 * @author: Clevermis
 * @create: 2023-01-07 10:54
 * @since JDK 1.8
 **/
public class Records {
    /**记录ID*/
    private Integer id;
    /**表单ID*/
    private Integer form_id;
    /**姓名*/
    private String name;
    /**学号*/
    private String code;
    /**时间戳*/
    private Date timestamps;
    /**删除*/
    private Date softDeletes;
    /**创建时间*/
    private Date createdAt;
    /**状态*/
    private Date updatedAt;

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
        return "Records{" +
                "id=" + id +
                ", form_id=" + form_id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", timestamps=" + timestamps +
                ", softDeletes=" + softDeletes +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
