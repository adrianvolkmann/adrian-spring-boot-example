package com.volkmann.persistence.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PessoaDTO {
	
	public UUID id;
	public String name;
	public List<EnderecoDTO> enderecos = new ArrayList<>();

}
