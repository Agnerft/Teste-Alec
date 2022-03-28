package com.makesystem.statusvenda.webservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.makesystem.statusvenda.dto.UpdateStatusVendaRequestDto;


@FeignClient(name = "statusVenda",
url = "${sales.url}")
public interface StatusVendaFeign {

	@PutMapping(value = "sale", headers = {"apikey=${sales.key}"},
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity statusVenda(@RequestBody UpdateStatusVendaRequestDto dto);
	
	
	/*@PostMapping(value = "sale", headers = {"apikey=${sales.key}"},
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<VendaUpdateRequestDto> criarTabelaVenda();
	*/

}
