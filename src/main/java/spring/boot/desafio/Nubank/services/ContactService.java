package spring.boot.desafio.Nubank.services;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import spring.boot.desafio.Nubank.dto.ContactDto;
import spring.boot.desafio.Nubank.models.Contact;
import spring.boot.desafio.Nubank.repositories.ContactRepository;

@Service
@AllArgsConstructor
public class ContactService {

	private ContactRepository contactRepository;
	
	
	
}
