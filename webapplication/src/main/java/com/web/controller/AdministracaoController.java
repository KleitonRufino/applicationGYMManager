package com.web.controller;

import java.sql.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.accountManager.service.impl.UsuarioManagerImpl;
import br.com.accoutManager.model.Usuario;
import br.com.accoutManager.service.IUsuarioManager;
import br.com.costumerManagement.model.Client;
import br.com.costumerManagement.service.IClientManager;
import br.com.costumerManagement.service.impl.ClientManagerImpl;
import br.com.enume.DiaDaSemana;
import br.com.model.Billing;
import br.com.model.BodyCondition;
import br.com.model.Colaborator;
import br.com.model.Diet;
import br.com.model.ExtraActivity;
import br.com.model.GuiaDeTreino;
import br.com.model.Product;
import br.com.model.Supplier;
import br.com.notification.model.Notification;
import br.com.notification.service.IManagerNotification;
import br.com.notification.service.impl.ManagerNotification;
import br.com.service.IManagerBilling;
import br.com.service.IManagerBodyCondition;
import br.com.service.IManagerColaborator;
import br.com.service.IManagerDiet;
import br.com.service.IManagerExtraActivity;
import br.com.service.IManagerGuiaDeTreinos;
import br.com.service.IManagerMonthlyPayment;
import br.com.service.IManagerProduct;
import br.com.service.IManagerSupplier;
import br.com.service.impl.ManagerBilling;
import br.com.service.impl.ManagerBodyConditionImpl;
import br.com.service.impl.ManagerColaboratorImpl;
import br.com.service.impl.ManagerDietImpl;
import br.com.service.impl.ManagerExtraActivityImpl;
import br.com.service.impl.ManagerGuiaDeTreinosImpl;
import br.com.service.impl.ManagerProduct;
import br.com.service.impl.ManagerSupplierImpl;
import br.com.service.impl.MonthlyPaymentManager;

import com.service.IManagerMail;
import com.service.impl.ManagerGmail;

@Controller
@RequestMapping("administracao")
public class AdministracaoController {
	private IClientManager managerClient;
	private IManagerExtraActivity managerExtraActivity;
	private IUsuarioManager managerAccount;
	private IManagerNotification managerNotification;
	private IManagerMail managerMail;
	private IManagerBodyCondition managerBodyCondition;
	private IManagerBilling managerBilling;
	private IManagerDiet managerDiet;
	private IManagerColaborator managerColaborator;
	private IManagerSupplier managerSupplier;
	private IManagerProduct managerProduct;
	private IManagerGuiaDeTreinos managerGuiaDeTreinos;
	private IManagerMonthlyPayment managerMonthlyPayment;

	public AdministracaoController() {
		this.managerExtraActivity = new ManagerExtraActivityImpl();
		this.managerClient = new ClientManagerImpl();
		this.managerAccount = new UsuarioManagerImpl();
		this.managerNotification = new ManagerNotification();
		this.managerMail = new ManagerGmail();
		this.managerBodyCondition = new ManagerBodyConditionImpl();
		this.managerBilling = new ManagerBilling();
		this.managerDiet = new ManagerDietImpl();
		this.managerColaborator = new ManagerColaboratorImpl();
		this.managerSupplier = new ManagerSupplierImpl();
		this.managerProduct = new ManagerProduct();
		this.managerGuiaDeTreinos = new ManagerGuiaDeTreinosImpl();
		this.managerMonthlyPayment = new MonthlyPaymentManager();
	}

	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	public String listarClientes(Model model) {
		List<Client> clients = this.managerClient.findAll();
		model.addAttribute("clientes", clients);
		return "admin/lista";
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public String cadastrarNovoCliente(Model model) {
		return "admin/novo";
	}

	@RequestMapping(value = "/voltarIndex", method = RequestMethod.GET)
	public String voltarIndex() {
		return "admin/index";
	}

	@RequestMapping(value = "/enviaEmail", method = RequestMethod.GET)
	public String enviarEmailCliente(Model model) {
		return "admin/email";
	}

	@RequestMapping(value = "/notificaCliente", method = RequestMethod.GET)
	public String notificarCliente(Model model) {
		return "admin/notificacao";
	}

	@RequestMapping(value = "listClientCondition", method = RequestMethod.GET)
	public String listaClientesCondition(Model model) {
		model.addAttribute("clientes", this.managerClient.findAll());
		return "admin/listClientCondition";
	}

	@RequestMapping(value = "ListClientAtividadesExtras", method = RequestMethod.GET)
	public String listClientesAtividadesExtras(Model model) {
		model.addAttribute("clientes", this.managerClient.findAll());
		return "admin/ListClientAtividadesExtras";
	}

	@RequestMapping(value = "/condicaoFisica", method = RequestMethod.GET)
	public String condicaoFisica(Long id, Model model) {
		model.addAttribute("cliente", this.managerClient.find(id));
		return "admin/condition";
	}

	@RequestMapping(value = "/atividadeExtra", method = RequestMethod.GET)
	public String AtividadesExtras(Long id, Model model) {
		model.addAttribute("cliente", this.managerClient.find(id));
		return "admin/atividadeExtra";
	}

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public String editarCliente(Long id, Model model) {
		model.addAttribute("cliente", this.managerClient.find(id));
		return "admin/editar";
	}

	@RequestMapping(value = "/novaConta", method = RequestMethod.GET)
	public String novaConta(Model model) {
		return "admin/contaNova";
	}

	@RequestMapping(value = "/listaContas", method = RequestMethod.GET)
	public String listarContas(Model model) {
		model.addAttribute("contas", this.managerBilling.findAll());
		return "admin/listaConta";
	}

	@RequestMapping(value = "/listaClientesNutrition")
	public String listarClientesDietas(Model model) {
		model.addAttribute("clientes", this.managerClient.findAll());
		return "admin/listaClientesNutrition";
	}

	@RequestMapping(value = "/novaNutrition", method = RequestMethod.GET)
	public String novaNutrition(Long id, Model model) {
		model.addAttribute("idCliente", id);
		return "admin/novaNutrition";
	}

	@RequestMapping(value = "/novoFornecedor")
	public String novoFornecedor(Model model) {
		return "admin/novoFornecedor";
	}

	@RequestMapping(value = "/adicionaFornecedor")
	public String cadastrarFornecedor(Supplier supplier, Model model,
			RedirectAttributes redirect) {
		this.managerSupplier.addSupplier(supplier);
		redirect.addFlashAttribute("info", "Cadastrado " + supplier.getNome()
				+ " com sucesso!");
		return "redirect:listaFornecedor";
	}

	@RequestMapping(value = "/listaFornecedor")
	public String listarFornecedores(Model model) {
		model.addAttribute("fornecedores", this.managerSupplier.findAll());
		return "admin/listaFornecedor";
	}

	@RequestMapping(value = "/novoProduto", method = RequestMethod.GET)
	public String novoProdutoFornecedor(Long id, Model model) {
		model.addAttribute("idFornecedor", id);
		return "admin/novoProduto";
	}

	@RequestMapping(value = "/adicionaProduto")
	public String adicionaProduto(Product product,
			@RequestParam("idFornecedor") Long id, Model model,
			RedirectAttributes redirect) {
		this.managerProduct.save(product, id);
		model.addAttribute("fornecedor", this.managerSupplier.findById(id));
		model.addAttribute("produtos",
				this.managerProduct.findByIdFornecedor(id));
		redirect.addFlashAttribute("info", "Produto cadastrado com sucesso!");
		return "admin/listaProdutosFornecedor";
	}

	@RequestMapping(value = "/listarProdutos")
	public String listarProdutosFornecedor(Long id, Model model) {
		model.addAttribute("fornecedor", this.managerSupplier.findById(id));
		model.addAttribute("produtos",
				this.managerProduct.findByIdFornecedor(id));
		return "admin/listaProdutosFornecedor";
	}

	@RequestMapping(value = "/cadastraNutrition")
	public String cadastrarNutrition(
			@RequestParam("description") String description,
			@RequestParam("idCliente") Long idClient, Model model,
			RedirectAttributes redirect) {
		Diet diet = new Diet();
		diet.setDescription(description);
		diet.setDiadasemana(new Date(System.currentTimeMillis()));
		this.managerDiet.save(diet, idClient);
		redirect.addFlashAttribute("info", "Dieta cadastrada !");
		return "redirect:listaClientesNutrition";
	}

	@RequestMapping(value = "/novoColaborator")
	public String novoColaborator(Model model) {
		return "admin/novoColaborator";
	}

	@RequestMapping(value = "/cadastraColaborator")
	public String cadastrarColaborator(Colaborator colaborator, Model model,
			RedirectAttributes redirects) {
		this.managerColaborator.addColaborator(colaborator);
		redirects.addFlashAttribute("info",
				"Colaborador " + colaborator.getNome()
						+ " adicionado com sucesso!");
		return "redirect:listaColaborator";
	}

	@RequestMapping(value = "/listaColaborator", method = RequestMethod.GET)
	public String listaColaborator(Model model) {
		model.addAttribute("colaborators", this.managerColaborator.findAll());
		return "admin/listaColaborator";
	}

	@RequestMapping(value = "/alterarCliente", method = RequestMethod.POST)
	public String alterarCliente(Client client, Model model,
			RedirectAttributes redirect) {
		this.managerClient.update(client);
		redirect.addFlashAttribute("info", "Cliente " + client.getNome()
				+ " editado com sucesso");
		return "redirect:clientes";
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "adicionaCliente", method = RequestMethod.POST)
	public String adicionaCliente(@RequestParam("email") String email,
			@RequestParam("nome") String nome, @RequestParam("cpf") Long cpf,
			@RequestParam("telefone") String telefone,
			@RequestParam("dataNascimento") Date dataNascimento,
			RedirectAttributes redirect) {

		Usuario user = new Usuario();
		user.setLogin(email);
		user.setSenha("1234");

		Client cliente = new Client();
		cliente.setNome(nome);
		cliente.setTelefone(telefone);
		cliente.setCpf(cpf);
		cliente.setDataNascimento(dataNascimento);
		cliente.setDataVencimento(new Long(new Date(System.currentTimeMillis())
				.getDay()));

		this.managerAccount.save(user);
		user = this.managerAccount.find(user.getLogin());

		this.managerClient.save(cliente, user.getId());
		redirect.addFlashAttribute("info", "Cliente " + nome
				+ " adicionado com sucesso");
		return "redirect:clientes";
	}

	@RequestMapping(value = "cadastraEmail")
	public String cadastrarEmail(@RequestParam("email") String email,
			@RequestParam("titulo") String titulo, Model model,
			RedirectAttributes redirect) {
		Usuario usuario = this.managerAccount.find(email);
		Random gerador = new Random();
		Long senha = gerador.nextLong();
		usuario.setSenha(String.valueOf(senha));
		this.managerAccount.update(usuario);
		this.managerMail.email(usuario.getLogin(), titulo, "Sua nova senha � "
				+ senha);

		redirect.addFlashAttribute("info", "Email enviado com sucesso!");
		return "redirect:enviaEmail";
	}

	@RequestMapping(value = "cadastraCondicaFisicaCliente")
	public String cadastrarCondicaoFisicaCliente(BodyCondition condition,
			@RequestParam("idCliente") Long id, Model model,
			RedirectAttributes redirect) {
		this.managerBodyCondition.addBodyCondition(condition, id);
		redirect.addFlashAttribute("info",
				"Condicao Fisica cadastrada com sucesso!");
		return "redirect:listClientCondition";
	}

	@RequestMapping(value = "/cadastrarAtividadeExtra")
	public String cadastrarAtividadeExtra(ExtraActivity extraActivity,
			@RequestParam("idCliente") Long id, Model model,
			RedirectAttributes redirect) {
		this.managerExtraActivity.addExtraActivity(extraActivity, id);
		redirect.addFlashAttribute("info",
				"Atividade Extra cadastrada com sucesso!");
		return "redirect:ListClientAtividadesExtras";
	}

	@RequestMapping(value = "cadastraNovaConta")
	public String cadastrarNovaConta(Billing billing, Model model,
			RedirectAttributes redirect) {
		this.managerBilling.save(billing);
		redirect.addFlashAttribute("info", "Nova Conta cadastrada com sucesso!");
		return "redirect:listaContas";
	}

	@RequestMapping(value = "cadastraNotificacao")
	public String notificarCliente(@RequestParam("mensagem") String mensagem,
			Model model, RedirectAttributes redirect) {
		Notification notification = new Notification();
		notification.setData(new Date(System.currentTimeMillis()));
		notification.setMensagem(mensagem);
		this.managerNotification.save(notification);
		redirect.addFlashAttribute("info",
				"Notificacao cadastrada com sucesso!");
		return "redirect:notificaCliente";

	}

	@RequestMapping(value = "/listaClienteGuiaDeTreino", method = RequestMethod.GET)
	public String listarClientesParaGuiaDeTreino(Model model) {
		model.addAttribute("clientes", this.managerClient.findAll());
		return "admin/listClientGuiaDeTreino";
	}

	@RequestMapping(value = "/novoTreino", method = RequestMethod.GET)
	public String novoTreino(Long id, Model model) {
		model.addAttribute("idCliente", id);
		return "admin/novoTreino";
	}

	@RequestMapping(value = "/adicionaTreino")
	public String cadastraTreino(@RequestParam("nome") String nome,
			@RequestParam("descricaoTreino") String descricaoTreino,
			@RequestParam("idCliente") Long idCliente, Model model,
			RedirectAttributes redirect) {
		GuiaDeTreino guia = new GuiaDeTreino();
		guia.setNome(nome);
		guia.setDiaDaSemana(DiaDaSemana.QUARTA);
		guia.setDescricaoTreino(descricaoTreino);
		this.managerGuiaDeTreinos.save(guia, idCliente);
		redirect.addFlashAttribute("info",
				"Novo treino cadastrado com sucesso!");
		return "redirect:listaClienteGuiaDeTreino";
	}

	@RequestMapping(value = "/verificarPendencias")
	public String verificarPendencias(Model model) {
		this.managerMonthlyPayment.verificarMensalidade();
		model.addAttribute("clientes",
				this.managerMonthlyPayment.listarClientesNaoPagos());
		return "admin/verificaPendencias";
	}

	@RequestMapping(value = "/atualizaPendencias", method = RequestMethod.GET)
	public String atualizarPendencias(Model model) {
		return "redirect:verificarPendencias";
	}
}
