package br.fai.gb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.fai.gb.model.Conta;

@Controller
public class HomeController {

	@GetMapping("/")
	public String getHomePage(final Conta conta, final Model model) {

		if (ContaController.CONTA != null) {
			model.addAttribute("usuarioLogado", ContaController.CONTA);
		}

		return "/home";
	}
}
