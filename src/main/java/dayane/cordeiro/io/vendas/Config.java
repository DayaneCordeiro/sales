package dayane.cordeiro.io.vendas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class Config {

    @Bean
    public CommandLineRunner exec() {
        return args -> {
            System.out.println("Running config");
        };
    }
}
