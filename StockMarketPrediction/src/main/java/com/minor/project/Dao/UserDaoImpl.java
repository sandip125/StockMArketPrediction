package com.minor.project.Dao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.minor.project.model.User;
@Configuration
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionfactory;
	@Override
	@Transactional
	public boolean login(String username, String password) {
		Session sess=sessionfactory.getCurrentSession();
		Criteria crt=sess.createCriteria(User.class);
		crt.add(Restrictions.eq("username", username)).add(Restrictions.eq("password", password));
		User u=(User) crt.uniqueResult();
		
		if(u!=null) {
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public void signup(User u) {
		try {
			Session sess=sessionfactory.getCurrentSession();
		
		
		
		 
		sess.save(u);
		}
		catch(Exception e){
			System.out.println("Error");
			
		}
	}
	
	
		
	}

	

