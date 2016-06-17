package com.skl.cloud.admin.service.common;

import java.util.List;

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
     * 获取所有实体
     * @return
     */
    public List<T> findAll();
    /**
     * 分页获取实体
     * @param limit
     * @param count
     * @return
     */
    public List<T> findAll(Integer limit,Integer count);
}
