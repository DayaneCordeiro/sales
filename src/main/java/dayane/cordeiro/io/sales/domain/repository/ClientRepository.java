package dayane.cordeiro.io.sales.domain.repository;

import dayane.cordeiro.io.sales.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> { // primeiro parâmetro a entidade e segundo parâmetro o tipo do Id da entidade
    List<Client> findByNameLike(String name);

}
