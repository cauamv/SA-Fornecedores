package br.com.senai.core.domain;

import java.util.Objects;

public class Fornecedor {
	
	private int codigo;
	
	private String razaoSocial;
	
	private String nomeFantasia;
	
	private int cnpj;

	public Fornecedor(String razaoSocial, String nomeFantasia, int cnpj) {
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
	}

	public Fornecedor(int codigo, String razaoSocial, String nomeFantasia, int cnpj) {
		this(razaoSocial, nomeFantasia, cnpj);
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
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
		Fornecedor other = (Fornecedor) obj;
		return codigo == other.codigo;
	}
	
	
	
	
	
	
	
	
	
	

}
