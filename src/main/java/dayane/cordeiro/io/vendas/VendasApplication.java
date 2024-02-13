package dayane.cordeiro.io.vendas;

import dayane.cordeiro.io.vendas.domain.entity.Client;
import dayane.cordeiro.io.vendas.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {

	@Bean
	public CommandLineRunner init(@Autowired ClientRepository repository) {
		return args -> {
			repository.save(new Client("Tatazinha"));
			repository.save(new Client("Day"));

			List<Client> clients = repository.getAll();
			clients.forEach(System.out::println);
		};
	}

	public static void main(String[] args) {

		SpringApplication.run(VendasApplication.class, args);
	}

}
