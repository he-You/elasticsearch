package com.heyou.springboot.elasticsearch.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2020/5/20 23:38
 */
@Data
@ToString
@Document(indexName = "blog", type = "article")
public class Article {
    /**
     * 主键ID
     */
    //@Field(type = FieldType.Keyword)
    private String id;

    /**
     * 文章标题
     */
    //@Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String title;

    /**
     * 文章内容
     */
    //@Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String content;

    /**
     * 创建时间
     */
    //@Field(type = FieldType.Date, pattern = "yyyy-MM-dd HH:mm:ss", format = DateFormat.custom)
    private String createTime;
}
