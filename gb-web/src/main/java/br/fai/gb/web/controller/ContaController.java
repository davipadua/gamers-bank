package br.fai.gb.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.fai.gb.model.Conta;
import br.fai.gb.web.service.ContaService;

@Controller
@RequestMapping("/conta")
public class ContaController {

	@Autowired
	private ContaService contaService;

	@GetMapping("/detail/{id}")
	public String getDetailPage(@PathVariable("id") final Long id, final Model model) {

		final Conta conta = contaService.readById(id);
		model.addAttribute("conta", conta);
		return "conta/detail";

	}

}
