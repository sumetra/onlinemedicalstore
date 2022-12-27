package com.sumitra.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.sumitra.model.OrderModel;
import com.sumitra.model.UserModel;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	SessionFactory sf;

	public void insert(OrderModel orderModel) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(orderModel);
		tx.commit();   
		sess.close();
		
	}

	public List<OrderModel> display() {
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		List<OrderModel> sl;
		@SuppressWarnings("unchecked")
		Query<OrderModel> q = s.createQuery("from OrderModel o");
		sl = q.getResultList();
		tx.commit();
		s.close();
		return sl;
	}

	public void delete(int id) {
		OrderModel orderModel = new OrderModel();
		orderModel.setoId(id);
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(orderModel);;
		tx.commit();   
		sess.close();
		
	}

	public void update(OrderModel orderModel) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
	
		s.update(orderModel);
		tx.commit();
		s.close();
		
		
	}

	
	public OrderModel displayById(int id) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<OrderModel> q = s.createQuery("from OrderModel s where oId = :oId");
		q.setParameter("oId", id);
		OrderModel ordermodel = q.uniqueResult();
		tx.commit();
		s.close();
		return ordermodel ;
	
	}

	public List<OrderModel> selectByUser(UserModel user) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<OrderModel> q = s.createQuery("from OrderModel s where s.user.uId=:userId");
		q.setParameter("userId", user.getuId());
		List<OrderModel> orderList = q.getResultList();
		
		tx.commit();
		s.close();
	
		return orderList ;
	}

	public List<OrderModel> displayByDate(String date) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<OrderModel> q = s.createQuery("from OrderModel s where date = :date");
		q.setParameter("date", date);
		List<OrderModel> ordermodel = q.list();
		tx.commit();
		s.close();
		return ordermodel ;
	}
	
	

	

}
