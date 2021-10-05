package br.fai.gb.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "br.fai.gb.*" })
public class GbApiApplication {

	public static void main(final String[] args) {
		SpringApplication.run(GbApiApplication.class, args);
	}

}
