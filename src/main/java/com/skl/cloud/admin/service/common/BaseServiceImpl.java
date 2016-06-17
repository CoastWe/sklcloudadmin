package com.skl.cloud.admin.service.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.skl.cloud.admin.dao.common.BaseMapper;
import com.skl.cloud.admin.model.common.IdEntity;

@Transactional
public class BaseServiceImpl<T extends IdEntity> implements BaseService<T>{
	
	private static Logger log = LoggerFactory.getLogger(BaseServiceImpl.class);
	
	protected BaseMapper<T> baseMapper;
	
	public BaseMapper<T> getBaseMapper() {
		return baseMapper;
	}
	public void setBaseMapper(BaseMapper<T> baseMapper) {
		this.baseMapper = baseMapper;
	}

	@Override
	public void create(T entity) {
		// TODO Auto-generated method stub
		baseMapper.insert(entity);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		baseMapper.delete(id);
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		baseMapper.update(entity);
	}

	@Override
	public void updateAllAttributes(T entity) {
		// TODO Auto-generated method stub
		baseMapper.updateAllAttributes(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public T findOne(T entity) {
		// TODO Auto-generated method stub
		return baseMapper.getOne(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public T findOneById(Long id) {
		// TODO Auto-generated method stub
		Class<T> clazz = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		T object = null;
		try {
			object = (T)clazz.newInstance();
			log.info("反射出来的实体类{}",object);
			try {
				clazz.getMethod("setId", new Class[]{Long.class}).invoke(object, id);
				log.info("转化完的实体类{}",object);
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				log.error("没有找到方法{},传入参数id{},转化实体类{}","setId",id,object,e);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				log.error("传入参数id{},转化实体类{}",id,object,e);
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				log.error("调用方法{}失败,传入参数id{},转化实体类{}","setId",id,object,e);
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			log.error("转化实体类{}失败,传入参数id{},转化实体类{}","setId",id,object,e);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			log.error("转化实体类{}失败,传入参数id{},转化实体类{}","setId",id,object,e);
		}
		return baseMapper.getOne(object);
	}

	@Override
	@Transactional(readOnly=true)
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return baseMapper.getAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<T> findAll(Integer limit, Integer count) {
		// TODO Auto-generated method stub
		return baseMapper.getAllByPage(limit, count);
	}

}
