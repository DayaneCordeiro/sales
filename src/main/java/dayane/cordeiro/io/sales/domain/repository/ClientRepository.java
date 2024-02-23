package dayane.cordeiro.io.sales.domain.repository;

import dayane.cordeiro.io.sales.domain.entity.Client;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClientRepository {
    private static String SELECT_ALL = "select * from client";
    private static String UPDATE = "update client set name = ? where id = ?";
    private static String DELETE = "delete from client where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Client save(Client client) {
        entityManager.persist(client);
        return client;
    }

    public Client update(Client client) {

        jdbcTemplate.update(UPDATE, new Object[]{client.getName(), client.getId()});
        return client;
    }

    public void delete(Client client) {

        delete(client.getId());
    }

    public void delete(Integer id) {

        jdbcTemplate.update(DELETE, new Object[]{id});
    }

    public List<Client> getAll() {
        return jdbcTemplate.query(SELECT_ALL, getRowMapper());
    }

    public List<Client> getByName(String name) {
        return jdbcTemplate.query(SELECT_ALL.concat(" where name like ? "),
                new Object[]{"%" + name + "%"},
                getRowMapper());
    }

    private RowMapper<Client> getRowMapper() {
        return new RowMapper<Client>() {
            @Override
            public Client mapRow(ResultSet resultSet, int rowNum) throws SQLException {

                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                return new Client(id, name);
            }
        };
    }


}
