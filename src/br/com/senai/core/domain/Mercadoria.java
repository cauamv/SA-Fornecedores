package br.com.senai.core.domain;

import java.util.Objects;

public class Mercadoria {
	
	private int codigo;
	
	private String descricaoCurta;
	
	private Double valor;

	public Mercadoria(String descricaoCurta, Double valor) {
		this.descricaoCurta = descricaoCurta;
		this.valor = valor;
	}

	public Mercadoria(int codigo, String descricaoCurta, Double valor) {
		this(descricaoCurta, valor);
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricaoCurta() {
		return descricaoCurta;
	}

	public void setDescricaoCurta(String descricaoCurta) {
		this.descricaoCurta = descricaoCurta;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
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
		Mercadoria other = (Mercadoria) obj;
		return codigo == other.codigo;
	}
	
	
	
	
	
	
	
	
	
	

}
