package spring.boot.desafio.Nubank.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import spring.boot.desafio.Nubank.dto.ClientDto;
import spring.boot.desafio.Nubank.dto.ContactDto;
import spring.boot.desafio.Nubank.models.Client;
import spring.boot.desafio.Nubank.services.ClientService;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {

	private ClientService clientService;
	
	@PostMapping
	public ResponseEntity<ClientDto> createClient (@RequestBody ClientDto clientDto) {
		var entity = clientService.createClient(clientDto);
		ClientDto dto = new ClientDto();
		dto.setName(entity.getName());
		return ResponseEntity.ok().body(dto);
		
	}
	
	@PostMapping("/add")
	public void addContactToClient(@RequestBody ContactDto contactDto){
		clientService.createContact(contactDto);
	}
	
	@GetMapping
	public List<Client> findAll(){
		return clientService.findAll();
	}
}
