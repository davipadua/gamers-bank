package br.fai.gb.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.fai.gb.model.Pessoa;
import br.fai.gb.web.service.PessoaService;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping("/list")
	public String getListPage(final Model model) {

		final List<Pessoa> pessoas = pessoaService.readAll();
		model.addAttribute("pessoas", pessoas);

		return "pessoas/list";
	}

	@GetMapping("/edit/{id}")
	public String getEditPage(@PathVariable("id") final Long id, final Model model) {

		final Pessoa pessoa = pessoaService.readById(id);
		model.addAttribute("pessoa", pessoa);
		return "pessoas/edit";
	}

	@GetMapping("/detail/{id}")
	public String getDetailPage(@PathVariable("id") final Long id, final Model model) {

		final Pessoa pessoa = pessoaService.readById(id);
		model.addAttribute("pessoa", pessoa);
		return "pessoas/detail";

	}

	@PostMapping("/update")
	public String update(final Pessoa pessoa, final Model model) {

		pessoaService.update(pessoa);

		return getDetailPage(pessoa.getId(), model);
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") final Long id, final Model model) {

		pessoaService.deleteById(id);

		return getListPage(model);
	}

}
