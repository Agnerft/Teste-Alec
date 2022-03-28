package com.makesystem.statusvenda.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvRecurse;

public class UpdateStatusVendaRequestDto {
	@CsvRecurse
	private UsuarioRequestDTO usuario;
	@CsvRecurse
	private VendaUpdateRequestDto venda;
	//@CsvBindByName(column = "localizadorStatus")
	@CsvBindByPosition(position = 9)
	private String localizadorStatus;
	

	
	
	public UsuarioRequestDTO getUsuario() {
		return usuario;
	}
	
	public void setUsuario(UsuarioRequestDTO usuario) {
		this.usuario = usuario;
	}
	
	public VendaUpdateRequestDto getVenda() {
		return venda;
	}
	
	public void setVenda(VendaUpdateRequestDto venda) {
		this.venda = venda;
	}
	
	public String getLocalizadorStatus() {
		return localizadorStatus;
	}
	
	public void setLocalizadorStatus(String localizadorStatus) {
		this.localizadorStatus = localizadorStatus;
	}

	@Override
	public String toString() {
		return "Login = " + usuario.getLogin() +
				" Nome = " + usuario.getNome() +
				" Login Terceiro = " + usuario.getLoginTerceiro() +
				" Identificador = " + venda.getIdentificador() +
				" Contrato = " + venda.getContrato() +
				" Documento = " + venda.getDocumento() + 
				" Data Minima = " + venda.getMinDataVenda() + 
				" Data Máxima = " + venda.getMaxDataVenda() +
				" Localizador de Status = " + localizadorStatus;
	}
	
}
