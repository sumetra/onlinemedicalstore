package com.sumitra.dao;

import java.util.List;

import com.sumitra.model.NotificationModel;
import com.sumitra.model.UserModel;

public interface NotificationDao {

	public void insert(NotificationModel notificationModel) ;
	public List<NotificationModel> displaybyUser(UserModel userModel);
	public void delete(int id);
	
}
