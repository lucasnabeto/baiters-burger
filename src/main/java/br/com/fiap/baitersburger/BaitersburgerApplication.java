package br.com.fiap.baitersburger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "Minha API", version = "1.0", description = "Documentação da API"))
@SpringBootApplication
public class BaitersburgerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaitersburgerApplication.class, args);
	}

}
