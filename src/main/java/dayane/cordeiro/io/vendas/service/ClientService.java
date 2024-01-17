package dayane.cordeiro.io.vendas.service;

import dayane.cordeiro.io.vendas.model.Client;
import dayane.cordeiro.io.vendas.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public void save(Client client) {
        validate(client);

        this.repository.save(client);
    }

    public void validate(Client client) {
        // valida o cliente
    }
}
