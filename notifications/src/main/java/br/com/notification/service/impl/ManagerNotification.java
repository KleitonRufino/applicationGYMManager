package br.com.notification.service.impl;

import java.util.List;

import br.com.notification.dao.NotificationDAO;
import br.com.notification.model.Notification;
import br.com.notification.service.IManagerNotification;

public class ManagerNotification implements IManagerNotification {

	private NotificationDAO dao;

	public ManagerNotification() {
		this.dao = new NotificationDAO();
	}

	@Override
	public void save(Notification notification) {
		this.dao.save(notification);
	}

	@Override
	public List<Notification> findAll() {
		return this.dao.findAll();
	}

}
