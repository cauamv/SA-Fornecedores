<<<<<<< HEAD
package br.com.senai.core.dao;

import br.com.senai.core.domain.Colaborador;

public interface DaoColaborador {

	public Colaborador buscarPor(int codigo);
	
}
=======
package br.com.senai.core.dao;

import java.util.List;

import br.com.senai.core.domain.Colaborador;

public interface DaoColaborador {
	
	public List<Colaborador> listarTodos();

}
>>>>>>> branch 'main' of https://github.com/cauamv/SA-Fornecedores.git
