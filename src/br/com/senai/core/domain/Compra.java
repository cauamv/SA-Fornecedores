package br.com.senai.core.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Compra {
	
	private int codigo;
	
	LocalDate data;
	
	private Double total;
	
	private String observacoes;
	
	private Colaborador colaborador;
	
	private Fornecedor fornecedor;
	
	private Item item;

	public Compra(LocalDate data, Double total, String observacoes, Colaborador colaborador, Fornecedor fornecedor,
			Item item) {
		this.data = data;
		this.total = total;
		this.observacoes = observacoes;
		this.colaborador = colaborador;
		this.fornecedor = fornecedor;
		this.item = item;
	}

	public Compra(int codigo, LocalDate data, Double total, String observacoes, Colaborador colaborador,
			Fornecedor fornecedor, Item item) {
		this(data, total, observacoes, colaborador, fornecedor, item);
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		return codigo == other.codigo;
	}
	
	
	
	
	
	
	
	
	

}
