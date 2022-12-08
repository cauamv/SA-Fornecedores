package br.com.senai.core.dao;

import br.com.senai.core.dao.postgresql.DaoPostgresqlCompra;
import br.com.senai.core.dao.postgresql.DaoPostgresqlItem;
import br.com.senai.core.dao.postgresql.DaoPostgresqlFornecedor;

public class FactoryDao {
	
private static FactoryDao instance;
	
	private FactoryDao() {}
	
	public DaoCompra getDaoInscricao() {
		return new DaoPostgresqlCompra();
	}
	
	public DaoItem getDaoAluno() {
		return new DaoPostgresqlItem();
	}
	
	public DaoFornecedor getDaoUnidadeCurricular() {
		return new DaoPostgresqlFornecedor();
	}
	
	public static FactoryDao getInstance() {
		if (instance == null) {
			instance = new FactoryDao();
		}
		return instance;
	}

}
