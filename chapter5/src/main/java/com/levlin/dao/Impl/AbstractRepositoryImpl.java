package com.levlin.dao.Impl;

import com.levlin.dao.AbstractRepository;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
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
public class AbstractRepositoryImpl<T> implements AbstractRepository<T> {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insert(T t) {
        mongoTemplate.insert(t);
    }

    @Override
    public T findById(String id, Class<T> t) {
        return mongoTemplate.findById(id,t);
    }

    @Override
    public boolean deleteById(String id,Class<T>t) {

        Criteria criteria= Criteria.where("_id").in(id);
        if(null!=criteria){
            Query query=new Query(criteria);
            List<T> list = this.findAll(query, t) ;
            if (list != null && list.size() > 0) {
                this.delete(list.get(0));
                return true;
            }
        }
        return false;
    }
    @Override
    public void delete(T t) {
        mongoTemplate.remove(t);


    }
    @Override
    public T findOne(Query query,Class<T> t) {
        return mongoTemplate.findOne(query,t);
    }

    @Override
    public boolean updateFirst(Query query, Update update, Class<T> t) {
        UpdateResult result=mongoTemplate.updateFirst(query, update, t);
        if(result.getModifiedCount() == 1){
            return true;
        }
        return false;
    }
    @Override
    public List<T> findAll(Class<T> t) {
        return mongoTemplate.findAll(t);
    }
    @Override
    public Long getCount(Query query, Class<T> t) {
        return mongoTemplate.count(query, t);
    }
    @Override
    public List<T> findAll(Query query, Class<T> t) {
        return mongoTemplate.find(query, t);
    }
    @Override
    public List<T> findByPage(Query query, int currentPage, int lineSize,Class<T>t) {
        query.skip((currentPage - 1) * lineSize);
        query.limit(lineSize);
        return mongoTemplate.find(query, t);
    }
    @Override
    public T findAndModify(Query query,Update update,Class<T> t) {
        return mongoTemplate.findAndModify(query, update, t);
    }
    @Override
    public void saveOrUpdate(T t) {
        mongoTemplate.save(t);
    }
    @Override
    public boolean updateMulti(Query query, Update update, Class<T> t) {
        UpdateResult result=mongoTemplate.updateMulti(query, update, t);
        if(result.getModifiedCount()>=1){
            return true;
        }
        return false;
    }
    @Override
    public boolean upsert(Query query, Update update, Class<T> t) {
        UpdateResult result=mongoTemplate.upsert(query, update, t);
        if(result.getModifiedCount()>=1){
            return true;
        }
        return false;
    }
    @Override
    public void drop(Class<T> t) {
        mongoTemplate.dropCollection(t);

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
//		mongoTemplate.insert(object);
//	}
//
//	@Override
//	public T getObject(String id,Class<T> t) {
//		// TODO Auto-generated method stub
//		return mongoTemplate.findById(id, t);
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
//
//	}

}

