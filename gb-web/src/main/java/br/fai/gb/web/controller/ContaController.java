package br.fai.gb.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.fai.gb.model.Conta;
import br.fai.gb.web.service.ContaService;

@Controller
@RequestMapping("/conta")
public class ContaController {

	@Autowired
	private ContaService contaService;

	public static Conta CONTA = null;

	@GetMapping("/detail/{id}")
	public String getDetailPage(@PathVariable("id") final Long id, final Model model) {

		final Conta conta = contaService.readById(id);
		model.addAttribute("conta", conta);
		return "conta/detail";

	}

	@GetMapping("/register-page")
	public String getCreatePage(final Conta conta) {

		return "conta/register";
	}

	@PostMapping("/create-user")
	public String create(final Conta conta) {

		final Long id = contaService.create(conta);

		if (id != -1) {

			return "redirect:/conta/detail/" + id;
		}

		return "redirect:/conta/register-page/";

		// return "redirect:/user/list";
		// return "redirect:/user/list";

	}

	@GetMapping("/edit/{id}")
	public String getEditPage(@PathVariable("id") final Long id, final Model model) {

		final Conta conta = contaService.readById(id);
		model.addAttribute("conta", conta);
		return "conta/edit";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") final Long id) {

		contaService.deleteById(id);

		return "conta/register";
	}

	@GetMapping("/transfere/{id}")
	public String getTransferenciaPage(@PathVariable("id") final Long id, final Model model) {

		final Conta conta = contaService.readById(id);
		model.addAttribute("conta", conta);
		return "conta/transfere";
	}

	@GetMapping("/guardar-dinheiro/{id}")
	public String getGuardarDinheiroPage(@PathVariable("id") final Long id, final Model model) {

		final Conta conta = contaService.readById(id);
		model.addAttribute("conta", conta);
		return "conta/transfere";
	}

	@GetMapping("/logout")
	public String logout() {
		CONTA = null;

		return "redirect:/";
	}

	@GetMapping("/login")
	public String getLoginPage(final Conta conta) {

		CONTA = null;

		return "conta/login";
	}

	@PostMapping("/login")
	public String login(final Conta conta, final RedirectAttributes redirectAttributes) {

		final Conta usuarioLogado = contaService.login(conta);
		if (usuarioLogado == null) {

			return "redirect:/conta/login";
		}

		CONTA = usuarioLogado;

		redirectAttributes.addFlashAttribute("usuarioLogado", CONTA);

		return "redirect:/conta/detail/" + usuarioLogado.getId();
	}

}
