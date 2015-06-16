package com.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.costumerManagement.model.Client;
import br.com.costumerManagement.service.IClientManager;
import br.com.costumerManagement.service.impl.ClientManagerImpl;
import br.com.model.BodyCondition;
import br.com.model.Diet;
import br.com.model.ExtraActivity;
import br.com.notification.model.Notification;
import br.com.notification.service.IManagerNotification;
import br.com.notification.service.impl.ManagerNotification;
import br.com.service.IManagerBodyCondition;
import br.com.service.IManagerDiet;
import br.com.service.IManagerExtraActivity;
import br.com.service.IManagerGuiaDeTreinos;
import br.com.service.impl.ManagerBodyConditionImpl;
import br.com.service.impl.ManagerDietImpl;
import br.com.service.impl.ManagerExtraActivityImpl;
import br.com.service.impl.ManagerGuiaDeTreinosImpl;

@Controller
@RequestMapping("cliente")
public class ClienteController {
	private IClientManager managerClient;
	private IManagerDiet managerDiet;
	private IManagerExtraActivity managerExtraActivity;
	private IManagerNotification managerNotification;
	private IManagerBodyCondition managerBodyCondition;
	private IManagerGuiaDeTreinos managerGuiaDeTreinos;

	public ClienteController() {
		this.managerExtraActivity = new ManagerExtraActivityImpl();
		this.managerDiet = new ManagerDietImpl();
		this.managerClient = new ClientManagerImpl();
		this.managerNotification = new ManagerNotification();
		this.managerBodyCondition = new ManagerBodyConditionImpl();
		this.managerGuiaDeTreinos = new ManagerGuiaDeTreinosImpl();
	}

	@RequestMapping(value = "/listarnotifications", method = RequestMethod.GET)
	public String listarNotifications(Model model) {
		List<Notification> notifications = this.managerNotification.findAll();
		model.addAttribute("notifications", notifications);
		return "cliente/listaNotificacao";
	}

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public String editarCliente(Model model, HttpSession session) {
		model.addAttribute("cliente", this.managerClient.findByIdUser(Long
				.parseLong(session.getAttribute("idUser").toString())));
		return "cliente/editar";
	}

	@RequestMapping(value = "/alterarCliente", method = RequestMethod.POST)
	public String alterarCliente(Client client, Model model,
			RedirectAttributes redirect) {
		this.managerClient.update(client);
		redirect.addFlashAttribute("info", "Cliente " + client.getNome()
				+ " editado com sucesso");
		return "cliente/index";
	}

	@RequestMapping(value = "/voltarIndex", method = RequestMethod.GET)
	public String voltarIndex() {
		return "cliente/index";
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

	@RequestMapping(value = "/listarHistoricoTreino")
	public String listarHistoricoTreino(Model model, HttpSession session) {
		Long id = Long.parseLong(session.getAttribute("idUser").toString());
		Client client = this.managerClient.findByIdUser(id);
		model.addAttribute("treinos",
				this.managerGuiaDeTreinos.findTreinos(client.getId()));
		return "cliente/listaHistoricoTreino";
	}

	@RequestMapping(value = "/listarAtividadesExtras")
	public String listarAtividadesExtras(Model model, HttpSession session) {
		List<ExtraActivity> activities = this.managerExtraActivity
				.findByExtraActivityByUser(managerClient.findByIdUser(
						Long.parseLong(session.getAttribute("idUser")
								.toString())).getId());
		model.addAttribute("activities", activities);
		return "cliente/listaAtividadesExtras";
	}
}
