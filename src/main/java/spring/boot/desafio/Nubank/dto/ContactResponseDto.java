package spring.boot.desafio.Nubank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContactResponseDto {

	private Long id;
	private String phone;
	private String email;
	private Long clientId;
	
}
