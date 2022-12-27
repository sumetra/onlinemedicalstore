package com.sumitra.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sumitra.model.CartModel;
import com.sumitra.model.CategoryModel;
import com.sumitra.model.UserModel;

@Repository
@Transactional
public class CartDaoImpl implements CartDao{
	@Autowired
	SessionFactory sf;
	

	public void insert(CartModel cartModel) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(cartModel);
		tx.commit();   
		sess.close();
		
	}

	public List<CartModel> display() {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		List<CartModel> sl;
		@SuppressWarnings("unchecked")
		Query<CartModel> q = s.createQuery("from CartModel s");
		sl = q.getResultList();
		tx.commit();
		s.close();
		return sl;

	}

	public void delete(int id) {
		
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		CartModel cModel = new CartModel();
		cModel.setCartId(id);
		sess.delete(cModel);	
		tx.commit();   
		sess.close();
		
	}
	
public void deleteCarts( List<Integer> ids) {
		
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		for(int id: ids) {
		System.out.println(id);
		CartModel cModel = new CartModel();
		cModel.setCartId(id);
		sess.delete(cModel);		
		}
		tx.commit();   
		sess.close();
		
	}

	public void update(CartModel cartModel) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		s.update(cartModel);
		tx.commit();
		s.close();
		
	}

	public CartModel displayById(int id) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<CartModel> q = s.createQuery("from CartModel s where cartId = :cartId");
		q.setParameter("cartId", id);
		CartModel cartmodel = q.uniqueResult();
		tx.commit();
		s.close();
		return cartmodel ;
	}

	public List<CartModel> selectbyUser(UserModel user) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<CartModel> q = s.createQuery("from CartModel s where s.user.uId=:user");
		q.setParameter("user", user.getuId());
		List<CartModel> cartList = q.getResultList();
		
		tx.commit();
		s.close();
		return cartList ;
	}

	
	

	
}
