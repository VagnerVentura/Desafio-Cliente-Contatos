package spring.boot.desafio.Nubank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import spring.boot.desafio.Nubank.dto.ClientDto;
import spring.boot.desafio.Nubank.dto.ContactDto;
import spring.boot.desafio.Nubank.models.Client;
import spring.boot.desafio.Nubank.services.ClientService;

@RestController
@RequestMapping("/clients")
@NoArgsConstructor
@AllArgsConstructor
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@PostMapping
	public ResponseEntity<Client> createClient (@RequestBody ClientDto clientDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clientService.createClient(clientDto));
	}
		
	@GetMapping
	public ResponseEntity<List<ClientDto>> findAllClients(){
		return ResponseEntity.ok(clientService.findAllClients());
	}
	
	@GetMapping("/{id}/contacts")
	public ResponseEntity<List<ContactDto>> getContactsByClientId(@PathVariable Long id){
		return ResponseEntity.ok().body(clientService.getContactsByClientId(id));
	}
	
}
