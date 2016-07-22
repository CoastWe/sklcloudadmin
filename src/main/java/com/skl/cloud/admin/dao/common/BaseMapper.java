package com.skl.cloud.admin.dao.common;

import java.util.List;
import java.util.Set;

import com.skl.cloud.admin.model.common.IdEntity;

public interface BaseMapper <T extends IdEntity>{
	/**
	 * 插入实体类 
	 * @param entity
	 */
    public void insert(T entity);
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
    public T getOne(T entity);
    /**
     * 获取所有实体
     * @return
     */
    public List<T> getAll();
    /**
     * 分页获取实体
     * @param limit
     * @param count
     * @return
     */
    public List<T> getAllByPage(Integer limit,Integer count);
    
    /**
     * 获取相关ids的实体
     * @param ids
     * @return
     */
	public List<T> getAllInIds(List<Long> ids);
}
