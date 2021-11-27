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

		Long id = Long.valueOf(-1);

		final String endpoint = "http://localhost:8080/api/v1/conta/create";

		try {

			final RestTemplate restTemplate = new RestTemplate();
			final HttpEntity<Conta> httpEntity = new HttpEntity<Conta>(conta);

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
	public Conta readById(final Long id) {

		final String endpoint = "http://localhost:8080/api/v1/conta/read-by-id/" + id;

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

		boolean response = false;

		final String endpoint = "http://localhost:8080/api/v1/conta/update";

		try {
			final RestTemplate restTemplate = new RestTemplate();

			final HttpEntity<Conta> httpEntity = new HttpEntity<Conta>(conta);

			final ResponseEntity<Boolean> responseEntity = restTemplate.exchange(endpoint, HttpMethod.PUT, httpEntity,
					Boolean.class);

			response = responseEntity.getBody();

		} catch (final Exception e) {
			System.out.println(e.getMessage());
		}

		return response;
	}

	@Override
	public boolean deleteById(final Long id) {

		boolean response = false;

		final String endpoint = "http://localhost:8080/api/v1/conta/delete/" + id;

		try {
			final RestTemplate restTemplate = new RestTemplate();

			final HttpEntity<String> httpEntity = new HttpEntity<String>("");

			final ResponseEntity<Boolean> requestResponse = restTemplate.exchange(endpoint, HttpMethod.DELETE,
					httpEntity, Boolean.class);

			response = requestResponse.getBody();

		} catch (final Exception e) {
			System.out.println(e.getMessage());
		}

		return response;
	}

	@Override
	public boolean transfere(final Conta envia, final Conta recebe) {

		boolean response = false;

		final String endpoint = "http://localhost:8080/api/v1/conta/transfere";

		try {
			final RestTemplate restTemplate = new RestTemplate();

			final HttpEntity<Conta> httpEntity = new HttpEntity<Conta>(envia);

			final ResponseEntity<Boolean> responseEntity = restTemplate.exchange(endpoint, HttpMethod.PUT, httpEntity,
					Boolean.class);

			response = responseEntity.getBody();

		} catch (final Exception e) {
			System.out.println(e.getMessage());
		}

		return response;
	}

	@Override
	public Conta login(final Conta conta) {

		Conta response = null;

		final String endpoint = "http://localhost:8080/api/v1/conta/login";

		try {
			final RestTemplate restTemplate = new RestTemplate();

			final HttpEntity<Conta> httpEntity = new HttpEntity<Conta>(conta);

			final ResponseEntity<Conta> responseEntity = restTemplate.exchange(endpoint, HttpMethod.POST, httpEntity,
					Conta.class);

			response = responseEntity.getBody();

		} catch (final Exception e) {
			System.out.println(e.getMessage());
		}

		return response;
	}

}
