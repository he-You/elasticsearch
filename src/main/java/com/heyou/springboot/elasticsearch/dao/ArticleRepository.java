package com.heyou.springboot.elasticsearch.dao;

import com.heyou.springboot.elasticsearch.entity.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2020/5/20 23:38
 */
@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, String> {

}
