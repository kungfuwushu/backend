package fr.kungfunantes.backend;

import fr.kungfunantes.backend.properties.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class SportsClubBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsClubBackendApplication.class, args);
	}

}
