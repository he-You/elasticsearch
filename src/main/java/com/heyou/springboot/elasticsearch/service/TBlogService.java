package com.heyou.springboot.elasticsearch.service;

import com.heyou.springboot.elasticsearch.entity.TBlog;
import java.util.List;

/**
 * (TBlog)表服务接口
 *
 * @author heyou
 * @date 2020-03-01 19:33:34
 */
public interface TBlogService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TBlog queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TBlog> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tBlog 实例对象
     * @return 实例对象
     */
    TBlog insert(TBlog tBlog);

    /**
     * 修改数据
     *
     * @param tBlog 实例对象
     * @return 实例对象
     */
    TBlog update(TBlog tBlog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}