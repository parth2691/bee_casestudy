package com.parth.bee.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.parth.bee.app.model.User;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@PersistenceContext	
	private EntityManager entityManager;	
	
	@Autowired
	DataSource datasource;
	
	
	public User findByUserName(String userName) {
		User user = null;
		try {
			Query query = entityManager.createQuery("from User us where us.username=:username").setParameter("username", userName);
			user = (User) query.getSingleResult();
		} catch(NoResultException e) {
			e.printStackTrace();
		}
	   return user;
	}

	public User findByUserId(Integer userId) {
		System.out.println("Entity Manager:-" +entityManager.toString());
		return entityManager.find(User.class, userId);
	}

	public List<User> findAllActiveUsers() {
		List<User> users =  entityManager.createQuery("FROM User as us").getResultList();
		return users;
	}

}
