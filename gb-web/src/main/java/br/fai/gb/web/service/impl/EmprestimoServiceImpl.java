package br.fai.gb.web.service.impl;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.fai.gb.model.Emprestimo;
import br.fai.gb.web.service.EmprestimoService;

@Service
public class EmprestimoServiceImpl implements EmprestimoService {

	@Override
	public List<Emprestimo> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long create(final Emprestimo emprestimo) {

		Long id = Long.valueOf(-1);

		final String endpoint = "http://localhost:8080/api/v1/emprestimo/create";

		try {

			final RestTemplate restTemplate = new RestTemplate();
			final HttpEntity<Emprestimo> httpEntity = new HttpEntity<Emprestimo>(emprestimo);

			final ResponseEntity<Long> responseEntity = restTemplate.exchange(endpoint, HttpMethod.POST, httpEntity,
					Long.class);
			id = responseEntity.getBody();

		} catch (final Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}

		return id;
	}

	@Override
	public Emprestimo readById(final Long id) {

		final String endpoint = "http://localhost:8080/api/v1/emprestimo/read-by-id/" + id;

		Emprestimo response = null;

		try {
			final RestTemplate restTemplate = new RestTemplate();

			final HttpEntity<String> httpEntity = new HttpEntity<String>("");

			final ResponseEntity<Emprestimo> requestResponse = restTemplate.exchange(endpoint, HttpMethod.GET,
					httpEntity, Emprestimo.class);

			response = requestResponse.getBody();

		} catch (final Exception e) {
			System.out.println(e.getMessage());
		}

		return response;
	}

	@Override
	public boolean update(final Emprestimo emprestimo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(final Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
