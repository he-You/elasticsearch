package com.heyou.springboot.elasticsearch.service.impl;

import com.heyou.springboot.elasticsearch.entity.TBlog;
import com.heyou.springboot.elasticsearch.dao.TBlogDao;
import com.heyou.springboot.elasticsearch.service.TBlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TBlog)表服务实现类
 *
 * @author heyou
 * @date 2020-03-01 19:33:35
 */
@Service("tBlogService")
public class TBlogServiceImpl implements TBlogService {
    @Resource
    private TBlogDao tBlogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TBlog queryById(Integer id) {
        return this.tBlogDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TBlog> queryAllByLimit(int offset, int limit) {
        return this.tBlogDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tBlog 实例对象
     * @return 实例对象
     */
    @Override
    public TBlog insert(TBlog tBlog) {
        this.tBlogDao.insert(tBlog);
        return tBlog;
    }

    /**
     * 修改数据
     *
     * @param tBlog 实例对象
     * @return 实例对象
     */
    @Override
    public TBlog update(TBlog tBlog) {
        this.tBlogDao.update(tBlog);
        return this.queryById(tBlog.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tBlogDao.deleteById(id) > 0;
    }
}