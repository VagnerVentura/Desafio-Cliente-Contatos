package spring.boot.desafio.Nubank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.boot.desafio.Nubank.models.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

}
