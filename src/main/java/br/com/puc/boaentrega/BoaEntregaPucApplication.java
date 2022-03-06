package br.com.puc.boaentrega;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Boa Entrega API", version = "1.0.3", description = "API Boa Entrega - Logística - PUC Minas"))
public class BoaEntregaPucApplication{

	
	public static void main(String[] args) {
		SpringApplication.run(BoaEntregaPucApplication.class, args);
	}
	
}
