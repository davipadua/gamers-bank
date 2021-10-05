package br.fai.gb.web.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.fai.gb.model.Pessoa;
import br.fai.gb.web.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {

	@Override
	public List<Pessoa> readAll() {

		final String endpoint = "http://localhost:8081/api/v1/pessoas/read-all";

		List<Pessoa> response = null;

		try {

			final RestTemplate restTemplate = new RestTemplate();

			final HttpEntity<String> httpEntity = new HttpEntity<String>("");

			final ResponseEntity<Pessoa[]> requestResponse = restTemplate.exchange(endpoint, HttpMethod.GET, httpEntity,
					Pessoa[].class);

			response = Arrays.asList(requestResponse.getBody());

		} catch (final Exception e) {
			System.out.println(e.getMessage());

		}

		return response;

	}

	@Override
	public Long create(final Pessoa pessoa) {

		Long id = Long.valueOf(-1);

		final String endpoint = "http://localhost:8081/api/v1/pessoas/create";

		try {

			final RestTemplate restTemplate = new RestTemplate();
			final HttpEntity<Pessoa> httpEntity = new HttpEntity<Pessoa>(pessoa);

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
	public Pessoa readById(final Long id) {

		final String endpoint = "http://localhost:8081/api/v1/pessoas/read-by-id/" + id;

		Pessoa response = null;

		try {
			final RestTemplate restTemplate = new RestTemplate();

			final HttpEntity<String> httpEntity = new HttpEntity<String>("");

			final ResponseEntity<Pessoa> requestResponse = restTemplate.exchange(endpoint, HttpMethod.GET, httpEntity,
					Pessoa.class);

			response = requestResponse.getBody();

		} catch (final Exception e) {
			System.out.println(e.getMessage());
		}

		return response;
	}

	@Override
	public boolean update(final Pessoa pessoa) {

		boolean response = false;

		final String endpoint = "http://localhost:8081/api/v1/pessoas/update";

		try {
			final RestTemplate restTemplate = new RestTemplate();

			final HttpEntity<Pessoa> httpEntity = new HttpEntity<Pessoa>(pessoa);

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

		final String endpoint = "http://localhost:8081/api/v1/pessoas/delete/" + id;

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

}
