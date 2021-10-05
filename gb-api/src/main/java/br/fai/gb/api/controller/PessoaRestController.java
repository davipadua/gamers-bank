package br.fai.gb.api.controller;

import java.util.List;

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

import br.fai.gb.api.service.PessoaService;
import br.fai.gb.model.Pessoa;

@RestController
@RequestMapping("/api/v1/pessoa")
@CrossOrigin(origins = "*")
public class PessoaRestController {

	@Autowired
	private PessoaService service;

	@GetMapping("/read-all")
	public ResponseEntity<List<Pessoa>> readAll() {

		return ResponseEntity.ok(service.readAll());
	}

	@GetMapping("/read-by-id/{id}")
	public ResponseEntity<Pessoa> readById(@PathVariable("id") final Long id) {

		return ResponseEntity.ok(service.readById(id));

	}

	@PutMapping("/update")
	public ResponseEntity<Boolean> update(@RequestBody final Pessoa pessoa) {

		return ResponseEntity.ok(service.update(pessoa));

	}

	@PostMapping("/create")
	public ResponseEntity<Long> create(@RequestBody final Pessoa pessoa) {

		return ResponseEntity.ok(service.create(pessoa));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") final Long id) {

		return ResponseEntity.ok(service.delete(id));
	}

}
