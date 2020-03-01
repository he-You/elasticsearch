package com.heyou.springboot.elasticsearch.dao;

import com.heyou.springboot.elasticsearch.entity.TBlog;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TBlog)表数据库访问层
 *
 * @author heyou
 * @date 2020-03-01 19:33:33
 */
public interface TBlogDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TBlog queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TBlog> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tBlog 实例对象
     * @return 对象列表
     */
    List<TBlog> queryAll(TBlog tBlog);

    /**
     * 新增数据
     *
     * @param tBlog 实例对象
     * @return 影响行数
     */
    int insert(TBlog tBlog);

    /**
     * 修改数据
     *
     * @param tBlog 实例对象
     * @return 影响行数
     */
    int update(TBlog tBlog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}