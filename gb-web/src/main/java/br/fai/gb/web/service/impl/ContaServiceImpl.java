package br.fai.gb.web.service.impl;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.fai.gb.model.Conta;
import br.fai.gb.web.service.ContaService;

@Service
public class ContaServiceImpl implements ContaService {

	@Override
	public List<Conta> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long create(final Conta conta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Conta readById(final Long id) {

		final String endpoint = "http://localhost:8081/api/v1/conta/read-by-id/" + id;

		Conta response = null;

		try {
			final RestTemplate restTemplate = new RestTemplate();

			final HttpEntity<String> httpEntity = new HttpEntity<String>("");

			final ResponseEntity<Conta> requestResponse = restTemplate.exchange(endpoint, HttpMethod.GET, httpEntity,
					Conta.class);

			response = requestResponse.getBody();

		} catch (final Exception e) {
			System.out.println(e.getMessage());
		}

		return response;
	}

	@Override
	public boolean update(final Conta conta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(final Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
