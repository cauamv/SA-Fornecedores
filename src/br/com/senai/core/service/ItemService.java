package br.com.senai.core.service;

import java.util.List;

import br.com.senai.core.dao.DaoItem;
import br.com.senai.core.domain.Item;
import br.com.senai.core.domain.Mercadoria;


public class ItemService {

	private DaoItem dao;
	
	public void gerarSubtotal(Item item) {
		double subTotal = item.getQtde() * item.getMercadoria().getValor();
		item.setSubTotal(subTotal);
	}
	
	//public void validar(Mercadoria mercadoria) {
	//	for (Mercadoria mercadorias : mercadoria ){
    //       if (mercadoria.equals(mercadoria)){
    //        throw new IllegalArgumentException("As mercadorias não podem se repetir");
    //        }
    //      if (mercadoria == mercadoria02) {
    //    	  throw new IllegalArgumentException("As mercadorias não podem se repetir");
    //  }          
    //  }
	//}
	
	public List<Item> listarPor(int idItem){
		if (idItem > 0) {
			int filtro =  idItem ;
			return dao.listarPor(filtro);
		}
		throw new IllegalArgumentException("O id para listagem é obrigatório e deve ser maior que zero");
	}
	public void removerPor(int idItem) {
		if (idItem > 0) {
			this.dao.removerPor(idItem);
		}else {
			throw new IllegalArgumentException("O id para remoção do projeto deve ser maior que zero");
		}
	}
	
	
}
