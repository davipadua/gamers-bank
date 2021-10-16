package br.fai.gb.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.fai.gb.model.Extrato;
import br.fai.gb.web.service.ExtratoService;

@Controller
@RequestMapping("/extrato")
public class ExtratoController {

	@Autowired
	private ExtratoService extratoService;

	@GetMapping("/detail/{id}")
	public String getDetailPage(@PathVariable("id") final Long id, final Model model) {

		final List<Extrato> extrato = extratoService.readAll(id);
		model.addAttribute("extrato", extrato);
		return "conta/extrato";

	}

}
