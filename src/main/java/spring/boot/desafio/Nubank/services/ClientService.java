package spring.boot.desafio.Nubank.services;

import java.util.List;
import java.util.stream.Collectors;

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
	
	public Client createClient (ClientDto clientDto) {
		
		Client client = new Client();
		client.setName(clientDto.getName());
		clientRepository.save(client);
		
		if(clientDto.getContacts() != null && clientDto.getContacts().size() > 0) {
			
			List<Contact> contacts = clientDto.getContacts()
			.stream().map(c->{
				Contact contact = new Contact();
				contact.setClient(client);
				contact.setName(c.getName());
				contact.setEmail(c.getEmail());
				contact.setPhone(c.getPhone());
				return contact;
			}).collect(Collectors.toList());
			contactRepository.saveAll(contacts);
			client.setContacts(contacts);
		}
		return client;
	}
	
	public List<ClientDto> findAllClients(){
		return clientRepository.findAll()
				.stream()
				.map(c -> {
					List<ContactDto> contactsDto = c.getContacts()
					.stream()
					.map(contacts -> {
						ContactDto contact = new ContactDto();
						contact.setClientId(c.getId());
						contact.setEmail(contacts.getEmail());
						contact.setName(contacts.getName());
						contact.setPhone(contacts.getPhone());
						return contact;
					}).collect(Collectors.toList());
					
					ClientDto clients = new ClientDto();
					clients.setId(c.getId());
					clients.setName(c.getName());
					clients.setContacts(contactsDto);
					return clients;
				}).collect(Collectors.toList());				
				
	}
	
	public List<ContactDto> getContactsByClientId(Long id) {
		Client client = clientRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Client not Found!"));
	
		List<ContactDto> contacts = client.getContacts()
		.stream()
		.map(c -> {
			ContactDto contact = new ContactDto();
			contact.setClientId(client.getId());
			contact.setName(c.getName());
			contact.setEmail(c.getEmail());
			contact.setPhone(c.getPhone());
			return contact;
		})
		.collect(Collectors.toList());	
		
		return contacts;		
	}

}
