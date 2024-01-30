package dayane.cordeiro.io.vendas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Development
public class Config {

    @Bean
    public CommandLineRunner exec() {
        return args -> {
            System.out.println("Running config");
        };
    }
}
