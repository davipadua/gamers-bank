package br.fai.gb.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}
