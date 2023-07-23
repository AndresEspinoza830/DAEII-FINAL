package pe.isil.ExamenFinalDAE_II;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.dialect.springdata.SpringDataDialect;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

@SpringBootApplication
public class ExamenFinalDaeIiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenFinalDaeIiApplication.class, args);
	}
	@Bean
	public SpringDataDialect springDataDialect(){
		return new SpringDataDialect();
	}
	@Bean
	public SpringSecurityDialect springSecurityDialect(){
		return new SpringSecurityDialect();
	}

}
