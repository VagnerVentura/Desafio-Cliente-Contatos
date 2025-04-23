package spring.boot.desafio.Nubank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.boot.desafio.Nubank.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
