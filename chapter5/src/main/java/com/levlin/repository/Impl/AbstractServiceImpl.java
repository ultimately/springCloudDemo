package com.levlin.repository.Impl;

import com.levlin.dao.AbstractRepository;
import com.levlin.repository.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: levlin
 * @Date: 2018/8/26
 * @version: 1.0
 * @Description:
 */
@Component
public class AbstractServiceImpl<T> implements AbstractService<T> {

    @Autowired
    private AbstractRepository<T> dao;

    /**
     * 插入对象
     *
     * @param t
     */
    @Override
    public void insert(T t) {
        dao.insert(t);
    }

    @Override
    public T findById(String id, Class<T> t) {
        return dao.findById(id,t);
    }

    /**
     * 根据id删除对象
     *
     * @param id
     * @param t
     * @return
     */
    @Override
    public boolean deleteById(String id, Class<T> t) {
        return dao.deleteById(id,t);
    }

    /**
     * 删除对象
     *
     * @param t
     */
    @Override
    public void delete(T t) {
        dao.delete(t);
    }

    /**
     * 根据条件查询单个对象数据
     *
     * @param query
     * @param t
     * @return
     */
    @Override
    public T findOne(Query query, Class<T> t) {
        return dao.findOne(query, t);
    }

    /**
     * 根据条件更新一个对象
     *
     * @param query
     * @param update
     * @param t
     * @return
     */
    @Override
    public boolean updateFirst(Query query, Update update, Class<T> t) {
        return dao.updateFirst(query,update,t);
    }

    /**
     * 查询所有数据
     *
     * @param t
     * @return
     */
    @Override
    public List<T> findAll(Class<T> t) {
        return dao.findAll(t);
    }

    /**
     * 查询总记录数
     *
     * @param query
     * @param t
     * @return
     */
    @Override
    public Long getCount(Query query, Class<T> t) {
        return dao.getCount(query,t);
    }

    /**
     * 根据条件查询所有数据
     *
     * @param query
     * @param t
     * @return
     */
    @Override
    public List<T> findAll(Query query, Class<T> t) {
        return dao.findAll(query,t);
    }

    /**
     * 根据条件分页查询所有数据
     *
     * @param query
     * @param currentPage
     * @param lineSize
     * @param t           @return
     */
    @Override
    public List<T> findByPage(Query query, int currentPage, int lineSize, Class<T> t) {
        return dao.findByPage(query,currentPage,lineSize,t);
    }

    /**
     * 返回更新后的数据
     *
     * @param query
     * @param update
     * @param t      @return
     */
    @Override
    public T findAndModify(Query query, Update update, Class<T> t) {
        return dao.findAndModify(query,update,t);
    }

    /**
     * 保存对象，如果对象存在就更新对象，如果对象不存在则保存对象
     *
     * @param t
     */
    @Override
    public void saveOrUpdate(T t) {
        dao.saveOrUpdate(t);
    }

    /**
     * 根据条件更新多个对象
     *
     * @param query
     * @param update
     * @param t
     * @return
     */
    @Override
    public boolean updateMulti(Query query, Update update, Class<T> t) {
        return dao.updateMulti(query,update,t);
    }

    /**
     * 更新对象，如果对象不存在则插入对象
     *
     * @param query
     * @param update
     * @param t
     * @return
     */
    @Override
    public boolean upsert(Query query, Update update, Class<T> t) {
        return dao.upsert(query,update,t);
    }

    /**
     * 删除表
     *
     * @param t
     */
    @Override
    public void drop(Class<T> t) {
        dao.drop(t);
    }

//	@Override
//	public List<T> getAllObjects() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void saveObject(T object) {
//		// TODO Auto-generated method stub
//		dao.saveObject(object);
//	}
//
//	@Override
//	public T getObject(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public WriteResult updateObject(String id, String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void deleteObject(String id) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void createCollection() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void dropCollection() {
//		// TODO Auto-generated method stub
//	}

}
