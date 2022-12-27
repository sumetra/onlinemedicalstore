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
import com.sumitra.model.NotificationModel;
import com.sumitra.model.UserModel;

@Repository
@Transactional
public class NotificationDaoImpl implements NotificationDao{
	@Autowired
	SessionFactory sf;

	public void insert(NotificationModel notificationModel) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(notificationModel);
		tx.commit();   
		sess.close();

		
	}
//	to add user notifications

	public List<NotificationModel> displaybyUser(UserModel user) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<NotificationModel> q = s.createQuery("from NotificationModel s where s.userModel.uId=:user");
		q.setParameter("user", user.getuId());
		List<NotificationModel> userList = q.getResultList();
		tx.commit();
		s.close();
		return userList ;
	}

	public void delete(int id) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		NotificationModel nModel = new NotificationModel();
		nModel.setnId(id);
		sess.delete(nModel);	
		tx.commit();   
		sess.close();
		
	}
	

	
	

	

}
