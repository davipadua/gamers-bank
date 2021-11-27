package br.fai.gb.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fai.gb.api.service.ContaService;
import br.fai.gb.model.Conta;

@RestController
@RequestMapping("/api/v1/conta")
@CrossOrigin(origins = "*")
public class ContaRestController {

	@Autowired
	private ContaService service;

	@GetMapping("/read-by-id/{id}")
	public ResponseEntity<Conta> readById(@PathVariable("id") final Long id) {

		return ResponseEntity.ok(service.readById(id));

	}

	@PostMapping("/create")
	public ResponseEntity<Long> create(@RequestBody final Conta conta) {

		return ResponseEntity.ok(service.create(conta));
	}

	@PutMapping("/update")
	public ResponseEntity<Boolean> update(@RequestBody final Conta conta) {

		return ResponseEntity.ok(service.update(conta));

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") final Long id) {

		return ResponseEntity.ok(service.delete(id));
	}

	@PutMapping("/transfere")
	public ResponseEntity<Boolean> transfere(@RequestBody final Conta envia, @RequestBody final Conta recebe) {

		return ResponseEntity.ok(service.transfere(envia, recebe));

	}

	@PostMapping("/login")
	public ResponseEntity<Conta> login(@RequestBody final Conta conta) {

		return ResponseEntity.ok(service.login(conta.getEmail(), conta.getSenha()));

	}

}
