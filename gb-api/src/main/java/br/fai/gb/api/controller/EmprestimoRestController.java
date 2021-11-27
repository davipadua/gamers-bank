package br.fai.gb.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fai.gb.api.service.EmprestimoService;
import br.fai.gb.model.Emprestimo;

@RestController
@RequestMapping("/api/v1/emprestimo")
@CrossOrigin(origins = "*")
public class EmprestimoRestController {

	@Autowired
	private EmprestimoService service;

	@GetMapping("/read-by-id/{id}")
	public ResponseEntity<Emprestimo> readById(@PathVariable("id") final Long id) {

		return ResponseEntity.ok(service.readById(id));

	}

	@PostMapping("/create")
	public ResponseEntity<Long> create(@RequestBody final Emprestimo emprestimo) {

		return ResponseEntity.ok(service.create(emprestimo));
	}

}
