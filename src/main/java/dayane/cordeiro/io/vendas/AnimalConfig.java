package dayane.cordeiro.io.vendas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnimalConfig {

    @Bean(name = "dog")
    public Animal dog() {
        return new Animal() {
            @Override
            public void makeNoise() {
                System.out.println("au au");
            }
        };
    }

    @Bean(name = "cat")
    public Animal cat() {
        return new Animal() {
            @Override
            public void makeNoise() {
                System.out.println("miau");
            }
        };
    }
}
