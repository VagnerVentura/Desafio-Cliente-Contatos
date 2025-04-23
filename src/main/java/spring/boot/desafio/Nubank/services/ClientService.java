package spring.boot.desafio.Nubank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import spring.boot.desafio.Nubank.dto.ClientDto;
import spring.boot.desafio.Nubank.dto.ContactDto;
import spring.boot.desafio.Nubank.models.Client;
import spring.boot.desafio.Nubank.models.Contact;
import spring.boot.desafio.Nubank.repositories.ClientRepository;
import spring.boot.desafio.Nubank.repositories.ContactRepository;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ContactRepository contactRepository;
	
	public Client createClient (ClientDto dto) {
		Client client = new Client();
		client.setName(dto.getName());
		clientRepository.save(client);
		return client;
	}
	
	public void createContact (ContactDto contactDto) {
		Contact newContact = new Contact();
		
		Client client = clientRepository.findById(contactDto.getClientId())
				.orElseThrow(()-> new RuntimeException("Client not Found"));
				
		newContact.setPhone(contactDto.getPhone());
		newContact.setEmail(contactDto.getEmail());
		newContact.setClient(client);
		contactRepository.save(newContact);
	}
	
	public List<Client> findAll(){
		return clientRepository.findAll();
	}
	
}
