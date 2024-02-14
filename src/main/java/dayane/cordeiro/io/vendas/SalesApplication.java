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
public class SalesApplication {

	@Bean
	public CommandLineRunner init(@Autowired ClientRepository repository) {
		return args -> {
			repository.save(new Client("Tatazinha"));
			repository.save(new Client("Day"));

			List<Client> clients = repository.getAll();
			clients.forEach(System.out::println);

			clients.forEach(c -> {
				c.setName(c.getName() + " atualizado");
				repository.update(c);
			});

			clients = repository.getAll();
			clients.forEach(System.out::println);

			repository.getByName("Ta").forEach(System.out::println);

			repository.delete(1);

			clients = repository.getAll();
			clients.forEach(System.out::println);
		};
	}

	public static void main(String[] args) {

		SpringApplication.run(SalesApplication.class, args);
	}

}
