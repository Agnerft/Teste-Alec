package com.makesystem.statusvenda.dto;

import java.lang.reflect.Field;

import com.opencsv.bean.CsvBindByName;

public class VendaUpdateRequestDto {

	@CsvBindByName(column = "Identificador")
	private String identificador;
	@CsvBindByName(column = "Contrato")
	private String contrato;
	@CsvBindByName(column = "Documento")
	private String documento;
	@CsvBindByName(column = "Data Venda Mínima")
	private String minDataVenda;
	@CsvBindByName(column = "Data Venda Máxima")
	private String maxDataVenda;
	

	public VendaUpdateRequestDto() {

	}

	public VendaUpdateRequestDto(String identificador, String contrato, String documento, String minDataVenda,
			String maxDataVenda) {
		super();
		this.identificador = identificador;
		this.contrato = contrato;
		this.documento = documento;
		this.minDataVenda = minDataVenda;
		this.maxDataVenda = maxDataVenda;
	}

	public VendaUpdateRequestDto(String identificador) {

		this.identificador = identificador;
	}

	public VendaUpdateRequestDto(String minDataVenda, String maxDataVenda) {
		this.minDataVenda = minDataVenda;
		this.maxDataVenda = maxDataVenda;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getMinDataVenda() {
		return minDataVenda;
	}

	public void setMinDataVenda(String minDataVenda) {
		this.minDataVenda = minDataVenda;
	}

	public String getMaxDataVenda() {
		return maxDataVenda;
	}

	public void setMaxDataVenda(String maxDataVenda) {
		this.maxDataVenda = maxDataVenda;
	}

	@Override
	public String toString() {
		return "VendaUpdateRequestDto [identificador=" + identificador + ", contrato=" + contrato + ", documento="
				+ documento + ", minDataVenda=" + minDataVenda + ", maxDataVenda=" + maxDataVenda + "]";
	}

	

}
