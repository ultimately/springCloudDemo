package com.levlin.service.Impl;

import com.levlin.mapper.UserMapper;
import com.levlin.model.User;
import com.levlin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private SessionRegistry sessionRegistry;

	@Autowired
	private UserMapper userDao;

	@Override
	public User getById(Integer id) {
		User user = userDao.getById(id);
		return user;
	}

	@Override
	public User getUsername(String username){
		User user = userDao.getByUserName(username);
		return user;
	}
	

}