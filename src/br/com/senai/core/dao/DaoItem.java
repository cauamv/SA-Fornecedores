package br.com.senai.core.dao;

import java.util.List;

import br.com.senai.core.domain.Item;

public interface DaoItem {

	public void inserir(Item item);
	
	public void removerPor(int id);

	public List<Item> listarPor(int idDaMercadoria);
	
}
