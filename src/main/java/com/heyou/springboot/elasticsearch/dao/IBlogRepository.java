package com.heyou.springboot.elasticsearch.dao;

import com.heyou.springboot.elasticsearch.entity.Blog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2020/5/24 10:37
 */
public interface IBlogRepository extends ElasticsearchRepository<Blog,String> {
    List<Blog> findByTitleLike(String keyword);
}
