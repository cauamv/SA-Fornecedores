package br.com.senai.core.service;

import java.time.LocalDate;
import java.util.List;

import br.com.senai.core.dao.DaoCompra;
import br.com.senai.core.dao.FactoryDao;
import br.com.senai.core.domain.Compra;

public class CompraService {
	
	private DaoCompra dao;
	
	public CompraService() {
		this.dao = FactoryDao.getInstance().getDaoCompra();
	}
	
	public void salvar(Compra compra) {		
		this.validar(compra);		
		boolean isJaInserido = compra.getCodigo() > 0;		
		if (isJaInserido) {
			throw new IllegalArgumentException("Essa");
		}else {
			this.dao.inserir(compra);
		}
		LocalDate dataCompra = compra.getData();
	}
	
	public List<Compra> listarPor(String fornecedor){
		if (fornecedor != null && !fornecedor.isBlank()) {
			String filtro = "%" + fornecedor + "%";
			return dao.listarPor(filtro);
		}
		throw new IllegalArgumentException("O filtro para listagem é obrigatório");
	}

}
