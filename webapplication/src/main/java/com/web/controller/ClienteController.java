package com.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.costumerManagement.service.IClientManager;
import br.com.costumerManagement.service.impl.ClientManagerImpl;
import br.com.model.BodyCondition;
import br.com.model.Diet;
import br.com.notification.model.Notification;
import br.com.notification.service.IManagerNotification;
import br.com.notification.service.impl.ManagerNotification;
import br.com.service.IManagerBodyCondition;
import br.com.service.IManagerDiet;
import br.com.service.impl.ManagerBodyConditionImpl;
import br.com.service.impl.ManagerDietImpl;

@Controller
@RequestMapping("cliente")
public class ClienteController {
	private IClientManager managerClient;
	private IManagerDiet managerDiet;
	private IManagerNotification managerNotification;
	private IManagerBodyCondition managerBodyCondition;

	public ClienteController() {
		this.managerDiet = new ManagerDietImpl();
		this.managerClient = new ClientManagerImpl();
		this.managerNotification = new ManagerNotification();
		this.managerBodyCondition = new ManagerBodyConditionImpl();
	}

	@RequestMapping(value = "/listarnotifications", method = RequestMethod.GET)
	public String listarNotifications(Model model) {
		List<Notification> notifications = this.managerNotification.findAll();
		model.addAttribute("notifications", notifications);
		return "cliente/listaNotificacao";
	}

	@RequestMapping(value = "/listarBodyCondition", method = RequestMethod.GET)
	public String listarBodyCondition(Model model, HttpSession session) {
		List<BodyCondition> bodyConditions = this.managerBodyCondition
				.findByUser(Long.parseLong(session.getAttribute("idUser")
						.toString()));
		model.addAttribute("bodyConditions", bodyConditions);
		return "cliente/listaBodyCondition";
	}

	@RequestMapping(value = "/listarHistoricoDieta", method = RequestMethod.GET)
	public String listarHistoricoDieta(Model model, HttpSession session) {
		List<Diet> dietas = this.managerDiet.historyDiet(managerClient
				.findByIdUser(
						Long.parseLong(session.getAttribute("idUser")
								.toString())).getId());
		model.addAttribute("dietas", dietas);
		return "cliente/listaDieta";
	}
}
