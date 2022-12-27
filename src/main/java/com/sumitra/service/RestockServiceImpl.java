package com.sumitra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumitra.dao.RestockDao;

import com.sumitra.model.RestockModel;

@Service
public class RestockServiceImpl implements RestockService{
	
    @Autowired
    RestockDao restockDao;
	
	public void insert(RestockModel restockModel) {
		restockDao.insert(restockModel);
		
	}

	public List<RestockModel> display() {
		return restockDao.display();
	}

	public void delete(int id) {
		restockDao.delete(id);
		
	}

	public void update(RestockModel restockModel) {
		restockDao.update(restockModel);
		
	}

	public RestockModel displayById(int id) {
		return restockDao.displayById(id);
	}

	

}
