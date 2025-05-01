package spring.boot.desafio.Nubank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {

	private Long clientId;
	private String name;
	private String phone;
	private String email;
	
}
