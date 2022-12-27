package com.sumitra.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sumitra.model.RestockModel;

@Repository
@Transactional
public class RestockDaoImpl implements RestockDao {

	@Autowired
	SessionFactory sf;

	public void insert(RestockModel restockModel) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(restockModel);
		tx.commit();   
		sess.close();
		
	}

	public List<RestockModel> display() {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		List<RestockModel> sl;
		@SuppressWarnings("unchecked")
		Query<RestockModel> q = s.createQuery("from RestockModel s");
		sl = q.getResultList();
		tx.commit();
		s.close();
		return sl;
	}

	public void delete(int id) {
		RestockModel restockModel = new RestockModel();
		restockModel.setrId(id);
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(restockModel);;
		tx.commit();   
		sess.close();
		
	}

	public void update(RestockModel restockModel) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<RestockModel> q = s.createQuery("from RestockModel s where rId = :rId");
		q.setParameter("rId", restockModel.getrId());
		s.update(restockModel);
		tx.commit();
		s.close();
		
	}

	public RestockModel displayById(int id) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<RestockModel> q = s.createQuery("from RestockModel s where rId = :rId");
		q.setParameter("rId", id);
		RestockModel restockmodel = q.uniqueResult();
		tx.commit();
		s.close();
		return restockmodel ;
	}
	
	

}
