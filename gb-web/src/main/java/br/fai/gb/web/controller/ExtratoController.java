package br.fai.gb.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

		model.addAttribute("conta", ContaController.CONTA);

		if (ContaController.CONTA != null) {
			model.addAttribute("usuarioLogado", ContaController.CONTA);
		}

		final List<Extrato> extratos = extratoService.readAll(id);
		model.addAttribute("extratos", extratos);
		return "conta/extrato";

	}

	@GetMapping("/{id}")
	public String getCreatePage(@PathVariable("id") final Long id, final Extrato extrato) {

		return "conta/create-buy";
	}

	@PostMapping("/create-compra")
	public String create(final Extrato extrato) {

		final Long id = extratoService.create(extrato);

		if (id != -1) {

			return "redirect:/extrato/detail/" + id;
		}

		return "redirect:/extrato/detail/" + id;
		// return "redirect:/user/list";
		// return "redirect:/user/list";

	}

}
