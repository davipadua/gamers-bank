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

import br.fai.gb.api.service.ExtratoService;
import br.fai.gb.model.Extrato;

@RestController
@RequestMapping("/api/v1/extrato")
@CrossOrigin(origins = "*")
public class ExtratoRestController {

	@Autowired
	private ExtratoService service;

	@GetMapping("/list/{id}")
	public ResponseEntity<Extrato> readAll(@PathVariable("id") final Long id) {

		return ResponseEntity.ok(service.readById(id));

	}

	@PostMapping("/create")
	public ResponseEntity<Long> create(@RequestBody final Extrato extrato) {

		return ResponseEntity.ok(service.create(extrato));
	}

}
