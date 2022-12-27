package com.sumitra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumitra.dao.NotificationDao;
import com.sumitra.model.NotificationModel;
import com.sumitra.model.UserModel;

@Service

public class NotificationServiceImpl implements NotificationService {
	
	@Autowired
	NotificationDao notificationDao;

	public void insert(NotificationModel notificationModel) {
		notificationDao.insert(notificationModel);
		
	}

	public List<NotificationModel> displaybyUser(UserModel user) {
		return notificationDao.displaybyUser(user);
	}

	public void delete(int id) {
		notificationDao.delete(id);
		
	}

	

}
