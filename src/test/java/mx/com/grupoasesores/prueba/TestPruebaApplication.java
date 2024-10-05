package mx.com.grupoasesores.prueba;

import org.springframework.boot.SpringApplication;

public class TestPruebaApplication {

	public static void main(String[] args) {
		SpringApplication.from(PruebaApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
