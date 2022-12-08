package br.com.senai.core.dao;

import java.util.List;

import br.com.senai.core.domain.Compra;

public interface DaoCompra {

	public void inserir(List<Compra> compras);
	
	public List<Compra> listarPor(String fornecedor);
	
}
