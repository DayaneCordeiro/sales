package dayane.cordeiro.io.sales.domain.repository;

import dayane.cordeiro.io.sales.domain.entity.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ClientRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Client save(Client client) {

        entityManager.persist(client);
        return client;
    }

    @Transactional
    public Client update(Client client) {

        entityManager.merge(client);
        return client;
    }

    @Transactional
    public void delete(Client client) {

        if (!entityManager.contains(client)) {
            client = entityManager.merge(client);
        }

        entityManager.remove(client);
    }

    @Transactional
    public void delete(Integer id) {

        Client client = entityManager.find(Client.class, id);
        delete(client);
    }


    @Transactional(readOnly = true) // otimiza a busca
    public List<Client> getAll() {

        return entityManager.createQuery("FROM Client", Client.class).getResultList();
    }

    @Transactional(readOnly = true)
    public List<Client> getByName(String name) {

        String jpql = "SELECT c FROM Client c WHERE c.name LIKE :name";
        TypedQuery<Client> query = entityManager.createQuery(jpql, Client.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }
}
