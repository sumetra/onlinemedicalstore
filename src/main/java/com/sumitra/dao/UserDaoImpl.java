package com.sumitra.dao;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sumitra.model.CartModel;
import com.sumitra.model.UserModel;
import com.sumitra.model.UserroleModel;



@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sf;
	

	public void insert(UserModel userModel) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		
		
		sess.save(userModel);
		tx.commit();   
		sess.close();
		
	}

	public List<UserModel> display() {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		List<UserModel> sl;
		@SuppressWarnings("unchecked")
		Query<UserModel> q = s.createQuery("from UserModel s");
		sl = q.getResultList();
		tx.commit();
		s.close();
		return sl;
	}

	public void delete(int id) {
		UserModel userModel = new UserModel();
		userModel.setuId(id);
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(userModel);;
		tx.commit();   
		sess.close();
		
	}

	public void update(UserModel userModel) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<UserModel> q = s.createQuery("from UserModel s where uId = :uId");
		q.setParameter("uId", userModel.getuId());
		s.update(userModel);
		tx.commit();
		s.close();
		
	}

	public UserModel displayById(int id) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<UserModel> q = s.createQuery("from UserModel s where uId = :uId");
		q.setParameter("uId", id);
		UserModel usermodel = q.uniqueResult();
		tx.commit();
		s.close();
		return usermodel ;
	}

	public UserModel selectByUsername(String uName) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<UserModel> q = s.createQuery("from UserModel s where uEmail =:uName");
		q.setParameter("uName", uName);
		
		List<UserModel> userModels = q.getResultList();
		tx.commit();
		s.close();
		return userModels.get(0);
		
	}

	public List<CartModel> getUserCart(String uName) {
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<UserModel> q = s.createQuery("from UserModel s where uEmail =:uName");
		q.setParameter("uName", uName);
		
		List<UserModel> userModels = q.getResultList();
		List<CartModel> cartList=userModels.get(0).getCartList();
		for( CartModel cm:cartList ) {
			System.out.println(cm.getCartId());
		}
		
		tx.commit();
		s.close();
		return cartList;
	}

	public List<UserModel> displayByRegDate(LocalDate date) {
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<UserModel> q = s.createQuery("from UserModel s where regDate =:date");
		q.setParameter("date", date);
		
		List<UserModel> userList = q.getResultList();
		
		tx.commit();
		s.close();
		return userList;
	}
	
	
	
	

	
	

}
