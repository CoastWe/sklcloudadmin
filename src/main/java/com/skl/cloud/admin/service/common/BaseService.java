package com.skl.cloud.admin.service.common;

import java.util.List;
import java.util.Set;

import com.skl.cloud.admin.model.common.IdEntity;

public interface BaseService <T extends IdEntity>{
	/**
	 * 插入实体类 
	 * @param entity
	 */
    public void create(T entity);
    /**
     * 根据id删除实体
     * @param id
     */
    public void delete(Long id);
    /**
     * 只更新参数属性部位空的列
     * @param entity
     */
    public void update(T entity);
    
    /**
     * 更新全部的属性值
     * @param entity
     */
    public void updateAllAttributes(T entity);
    /**
     * 获取单个实体
     * @param entity
     * @return
     */
    public T findOne(T entity);
    /**
     * 根据id获取单个实体
     * @param id
     * @return
     */
    public T findOneById(Long id);    
    /**
     * 批量获取相关id的实体
     * @param id
     * @return
     */
    public List<T> findAllByIds(Set<Long> ids);
    /**
     * 获取所有实体
     * @return
     */
    public List<T> findAll();
    
    
    /**
     * TODO(分页查询数据)
     * <p>Creation Date: 2016年6月21日 and by Author: weibin </p>
     * @param pageNum
     * @param pageSize
     * @return
     * @return List<T>
     * @throws
     *
     */
    public List<T> findAll(Integer pageNum, Integer pageSize);
}
