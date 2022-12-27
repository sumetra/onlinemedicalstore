package com.sumitra.dao;



import java.util.List;
import java.util.Map;

import org.antlr.v4.parse.ANTLRParser.exceptionGroup_return;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sumitra.model.ProductModel;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory sf;

	public void insert(ProductModel productModel) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(productModel);
		tx.commit();   
		sess.close();
		
	}

	public List<ProductModel> display() {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		List<ProductModel> sl;
		@SuppressWarnings("unchecked")
		Query<ProductModel> q = s.createQuery("from ProductModel s");
		sl = q.getResultList();
		tx.commit();
		s.close();
		return sl;
	}

	public void delete(int id) {
		ProductModel productModel = new ProductModel();
		productModel.setpId(id);
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(productModel);;
		tx.commit();   
		sess.close();
		
	}

	public void update(ProductModel productModel) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<ProductModel> q = s.createQuery("from ProductModel s where pId = :pId");
		q.setParameter("pId", productModel.getpId());
		s.update(productModel);
		tx.commit();
		s.close();
		
	}

	public ProductModel displayById(int id) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<ProductModel> q = s.createQuery("from ProductModel s where pId = :pId");
		q.setParameter("pId", id);
		ProductModel productmodel = q.uniqueResult();
		tx.commit();
		s.close();
		return productmodel ;
	}

	public List<ProductModel>  search(ProductModel productmodel) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		 List<ProductModel> productsList=null;
		try {
			System.out.println("hey iam in dao");	
		@SuppressWarnings("unchecked")
		Query<ProductModel> q = s.createQuery("from ProductModel s where search like :search");
		q.setParameter("search","%"+productmodel.getSearch()+"%");
		 productsList = q.list();
		//System.out.println("heeeey iam in dao" +productmodel.getSearch());
		tx.commit();
		s.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("abcde");
			return null;
		}
		return productsList ;
	}

	
	
	

}
