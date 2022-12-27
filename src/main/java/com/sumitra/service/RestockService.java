package com.sumitra.service;

import java.util.List;

import com.sumitra.model.RestockModel;


public interface RestockService {
	public void insert(RestockModel restockModel) ;
	public List<RestockModel> display();
	public void delete(int id);
	public void update(RestockModel restockModel);
	public RestockModel displayById(int id);
}
		
	



