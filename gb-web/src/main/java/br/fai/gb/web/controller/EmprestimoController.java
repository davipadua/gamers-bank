package br.fai.gb.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.fai.gb.model.Emprestimo;
import br.fai.gb.web.service.EmprestimoService;

@Controller
@RequestMapping("/emprestimo")
public class EmprestimoController {

	@Autowired
	private EmprestimoService emprestimoService;

	@GetMapping("/detail/{id}")
	public String getDetailPage(@PathVariable("id") final Long id, final Model model) {

		final Emprestimo emprestimo = emprestimoService.readById(id);
		model.addAttribute("emprestimo", emprestimo);
		return "conta/detail";

	}

	@GetMapping("/{id}")
	public String getCreatePage(@PathVariable("id") final Long id, final Emprestimo emprestimo,
			final RedirectAttributes redirectAttributes, final Model model) {

		model.addAttribute("conta", ContaController.CONTA);

		if (ContaController.CONTA != null) {
			model.addAttribute("usuarioLogado", ContaController.CONTA);
		}

		return "conta/emprestimo";
	}

	@PostMapping("/create-emprestimo")
	public String create(final Emprestimo emprestimo) {

		final Long id = emprestimoService.create(emprestimo);

		if (id != -1) {

			return "redirect:/conta/detail/" + id;
		}

		return "redirect:/emprestimo/" + ContaController.CONTA.getId();

		// return "redirect:/user/list";
		// return "redirect:/user/list";

	}

}
