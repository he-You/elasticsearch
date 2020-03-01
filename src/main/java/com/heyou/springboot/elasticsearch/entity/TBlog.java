package com.heyou.springboot.elasticsearch.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TBlog)实体类
 *
 * @author heyou
 * @since 2020-03-01 19:33:29
 */
public class TBlog implements Serializable {
    private static final long serialVersionUID = -80054785571090814L;
    /**
    * 自增ID
    */
    private Integer id;
    /**
    * 博客标题
    */
    private String title;
    /**
    * 作者
    */
    private String auther;
    /**
    * 内容
    */
    private Object content;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}