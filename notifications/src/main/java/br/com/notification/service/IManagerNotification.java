package br.com.notification.service;

import java.util.List;

import br.com.notification.model.Notification;

public interface IManagerNotification {
	public void save(Notification notification);
	
	
	public List<Notification> findAll();
}

