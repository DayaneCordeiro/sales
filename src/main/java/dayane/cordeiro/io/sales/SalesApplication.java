package dayane.cordeiro.io.sales;

import dayane.cordeiro.io.sales.domain.entity.Client;
import dayane.cordeiro.io.sales.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class SalesApplication {

	@Bean
	public CommandLineRunner init(@Autowired ClientRepository repository) {
		return args -> {
			repository.save(new Client("Tatazinha"));
			repository.save(new Client("Day"));

			List<Client> clients = repository.findAll();
			clients.forEach(System.out::println);

			clients.forEach(c -> {
				c.setName(c.getName() + " atualizado");
				repository.save(c);
			});

			clients = repository.findAll();
			clients.forEach(System.out::println);

			repository.findByNameLike("Ta").forEach(System.out::println);

			repository.findAll().forEach(repository::delete);

			clients = repository.findAll();
			clients.forEach(System.out::println);
		};
	}

	public static void main(String[] args) {

		SpringApplication.run(SalesApplication.class, args);
	}

}
