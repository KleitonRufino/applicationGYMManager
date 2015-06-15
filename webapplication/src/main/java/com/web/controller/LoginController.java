package com.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.accountManager.service.impl.UsuarioManagerImpl;
import br.com.accoutManager.model.Usuario;
import br.com.accoutManager.service.IUsuarioManager;

@Controller
@RequestMapping
public class LoginController {
	private IUsuarioManager iUsuarioManager;

	public LoginController() {
		this.iUsuarioManager = new UsuarioManagerImpl();
	}

	@RequestMapping(value = "/sair", method = RequestMethod.GET)
	public String sair(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		request.getSession().invalidate();
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
		model.addAttribute("erro", "Usuario e/ou senha invalidos");
		return "login";
	}

	@RequestMapping(value = "/efetuaLogin", method = RequestMethod.POST)
	public String efetuaLogin(@RequestParam(value = "email") String email,
			@RequestParam(value = "senha") String senha,
			HttpServletRequest request) {
		if (!email.isEmpty() && !senha.isEmpty()) {
			Usuario user = this.iUsuarioManager.find(email, senha);
			if ("admin@gmail.com".equals(user.getLogin())
					&& "1234".equals(user.getSenha())) {
				HttpSession session = request.getSession(true);
				session.setAttribute("idUser", user.getId());
				session.setAttribute("email", user.getLogin());
				session.setAttribute("senha", user.getSenha());
				return "/admin/index";
			} else {
				if ("eri_squall@hotmail.com".equals(user.getLogin())
						&& "1234".equals(user.getSenha())) {
					HttpSession session = request.getSession(true);
					session.setAttribute("idUser", user.getId());
					session.setAttribute("email", user.getLogin());
					session.setAttribute("senha", user.getSenha());
					return "/cliente/index";
				}
			}
		}
		return "redirect:loginfailed";
	}
}
