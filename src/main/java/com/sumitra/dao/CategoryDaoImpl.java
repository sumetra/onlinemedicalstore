package com.sumitra.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.stringtemplate.v4.compiler.STParser.mapExpr_return;

import com.sumitra.model.CategoryModel;
import com.sumitra.model.ProductModel;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sf;

	public void insert(CategoryModel categoryModel) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(categoryModel);
		tx.commit();   
		sess.close();
		
	}

	public List<CategoryModel> display() {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		List<CategoryModel> sl;
		@SuppressWarnings("unchecked")
		Query<CategoryModel> q = s.createQuery("from CategoryModel s");
		sl = q.getResultList();
		tx.commit();
		s.close();
		return sl;
		
	}

	public void delete(int id) {
		CategoryModel categoryModel = new CategoryModel();
		categoryModel.setcId(id);
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(categoryModel);
		tx.commit();   
		sess.close();
		
	}

	public void update(CategoryModel categoryModel) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<CategoryModel> q = s.createQuery("from CategoryModel s where cId =:cId");
		q.setParameter("cId", categoryModel.getcId());
		s.update(categoryModel);
		tx.commit();
		s.close();
		
	}

	public CategoryModel displayById(int id) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<CategoryModel> q = s.createQuery("from CategoryModel s where cId =:cId");
		q.setParameter("cId", id);
		CategoryModel categorymodel = q.uniqueResult();
		tx.commit();
		s.close();
		return categorymodel ;
	}

	public List<CategoryModel> displayForMenu() {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		List<CategoryModel> sl;
		@SuppressWarnings("unchecked")
		Query<CategoryModel> q = s.createQuery("from CategoryModel s");
		sl = q.getResultList();
		
		for(CategoryModel cm: sl) {
			for(ProductModel pm : cm.getProductsList()) {
//				System.out.println(pm.getpMedicine());
			}
		}
		tx.commit();
		s.close();
		
		
		return sl;
		
	}
	
	

}
