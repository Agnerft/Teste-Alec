package com.makesystem.statusvenda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.makesystem.statusvenda.dto.RequestError;
import com.makesystem.statusvenda.dto.UpdateStatusVendaRequestDto;
import com.makesystem.statusvenda.dto.UsuarioRequestDTO;
import com.makesystem.statusvenda.dto.VendaUpdateRequestDto;
import com.makesystem.statusvenda.webservice.StatusVendaFeign;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import feign.FeignException;


@EnableFeignClients
@SpringBootApplication
public class StatusVendaApplication{

	private static final Logger log = LoggerFactory.getLogger(StatusVendaApplication.class);
	
	
	
	@Autowired
	private StatusVendaFeign ws;
	
	public static void main(String[] args) {
		SpringApplication.run(StatusVendaApplication.class, args);		
	}

	
	public void teste() {
		ObjectMapper mapper = new ObjectMapper();
		UpdateStatusVendaRequestDto dto = new UpdateStatusVendaRequestDto();
		
		dto.setVenda(new VendaUpdateRequestDto("MOB7u1643920153"));
		dto.setLocalizadorStatus("Teste Agner");
		dto.setUsuario(new UsuarioRequestDTO("tiago"));
		
		
	
		try {
			log.info(mapper.writeValueAsString(dto));
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			
			ws.statusVenda(dto);
			log.info("status da venda Atualizada com sucesso");
			
		}catch (FeignException e) {
			try {
				switch (e.status()) {
				case 400: {
				   RequestError erro = mapper.readValue(e.contentUTF8(), RequestError.class);	
				   log.error(erro.getErrorDescription());
				   break;
				}
				case 401:
					log.error("apikey invalido!");
					break;
				}
			}catch (Exception ex) {
				e.printStackTrace();
			}
		}	
		}
	
	private static final String ArquivoCSV = "D:\\Arquivo csv\\teste.csv";
	
	@Bean
	public void teste2() throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException {

		
		//LEITURA DE ARQUIVO 
		//VALIDAÇÃO DA LINHA
		//EXEC DO MÉTODO DO WEBSERV
		//GRAVAR O .log do QUE ACONTECEU COM O REGISTRO
		
		Reader reader = Files.newBufferedReader(Paths.get(ArquivoCSV));
		
		
		List<UpdateStatusVendaRequestDto> csvUpdateStatus = new CsvToBeanBuilder(reader)
				.withType(UpdateStatusVendaRequestDto.class)
				.withIgnoreLeadingWhiteSpace(true)
				.withSkipLines(0)
				.build().parse();
		
		Iterator<UpdateStatusVendaRequestDto> csvUpdateStatusIteratorDTO = csvUpdateStatus.iterator();
		
		
		while(csvUpdateStatusIteratorDTO.hasNext()) {
			
			UpdateStatusVendaRequestDto UpdateStatusvendaDTO = csvUpdateStatusIteratorDTO.next();

			System.out.println(UpdateStatusvendaDTO);
			/*System.out.println("Login = " + UpdateStatusvendaDTO.getUsuario().getLogin());
			System.out.println("Nome = " + UpdateStatusvendaDTO.getUsuario().getNome());
			System.out.println("Login de Terceiros = " + UpdateStatusvendaDTO.getUsuario().getLoginTerceiro());
			System.out.println("Identificador = " + UpdateStatusvendaDTO.getVenda().getIdentificador());
			System.out.println("Contrato = " + UpdateStatusvendaDTO.getVenda().getContrato());
			System.out.println("Data Venda Mínima = " + UpdateStatusvendaDTO.getVenda().getMinDataVenda());
			System.out.println("Data Venda Maxima = " + UpdateStatusvendaDTO.getVenda().getMaxDataVenda());
			System.out.println("Localizador do Status = " + UpdateStatusvendaDTO.getLocalizadorStatus());*/
			
		}
		
	
		
	}
}
	
	


