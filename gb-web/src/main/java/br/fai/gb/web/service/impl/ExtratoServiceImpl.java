package br.fai.gb.web.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.fai.gb.model.Extrato;
import br.fai.gb.web.service.ExtratoService;

@Service
public class ExtratoServiceImpl implements ExtratoService {

	@Override
	public List<Extrato> readAll(final Long id) {

		final String endpoint = "http://localhost:8080/api/v1/extrato/read-all/" + id;

		List<Extrato> response = null;

		try {

			final RestTemplate restTemplate = new RestTemplate();

			final HttpEntity<String> httpEntity = new HttpEntity<String>("");

			final ResponseEntity<Extrato[]> requestResponse = restTemplate.exchange(endpoint, HttpMethod.GET,
					httpEntity, Extrato[].class);

			response = Arrays.asList(requestResponse.getBody());

		} catch (final Exception e) {
			System.out.println(e.getMessage());

		}

		return response;
	}

	@Override
	public Long create(final Extrato extrato) {

		Long id = Long.valueOf(-1);

		final String endpoint = "http://localhost:8080/api/v1/extrato/create";

		try {

			final RestTemplate restTemplate = new RestTemplate();
			final HttpEntity<Extrato> httpEntity = new HttpEntity<Extrato>(extrato);

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
	public Extrato readById(final Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(final Extrato extrato) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(final Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
