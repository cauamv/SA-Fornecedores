package br.com.senai.core.dao.postgresql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.core.dao.DaoCompra;
import br.com.senai.core.dao.ManagerDb;
import br.com.senai.core.domain.Colaborador;
import br.com.senai.core.domain.Compra;
import br.com.senai.core.domain.Fornecedor;


public class DaoPostgresqlCompra implements DaoCompra {

	private final String INSERT = "INSERT INTO compras (data, total, observacoes, id_fornecedor,"
			+ " id_colaborador) VALUES (?, ?, ?, ?, ?)";

	private final String SELECT_BY_ID = "SELECT compras.id, compras.data, compras.total, "
			+ "compras.observacoes, compras.id_fornecedor, colaborador.nome_completo, fornecedor.nome_fantasia "
			+ "compras.id_colaborador FROM compras, fornecedores, colaboradores WHERE compras.id = ? ";

	private final String SELECT_BY_NAME = "SELECT compras.id, data, total, observacoes, fornecedores.nome_fantasia, "
			+ "FROM compras, fornecedores WHERE Upper(nome_fantasia) LIKE Upper(?)"
			+ "AND compras.id_fornecedor = fornecedores.id  ";
	
	
	private final String SELECT_COLABORADOR = "SELECT id, nome_completo FROM colaboradores" + 
	"ORDER BY id;";

	private Connection conexao;

	public DaoPostgresqlCompra() {
		this.conexao = ManagerDb.getInstance().getConexao();
	}

	@Override
	public void inserir(List<Compra> compras) {
		PreparedStatement ps = null;
		try {
			ManagerDb.getInstance().configurarAutocommitDa(conexao, false);
			ps = conexao.prepareStatement(INSERT);
			for (Compra compra : compras) {
				ps.setDate(1, Date.valueOf(compra.getData()));
				ps.setDouble(2, compra.getTotal());
				ps.setString(3, compra.getObservacoes());
				ps.setInt(4, compra.getFornecedor().getId());
				ps.setInt(5, compra.getColaborador().getId());
				ps.execute();
			}
			this.conexao.commit();
			ManagerDb.getInstance().configurarAutocommitDa(conexao, true);
		} catch (Exception e) {
			ManagerDb.getInstance().realizarRollbackNa(conexao);
			throw new RuntimeException("Ocorreu um erro ao inserir as compras. Motivo: " + e.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
		}

	}

	@Override
	public List<Compra> listarPor(String fornecedor) {
		List<Compra> compras = new ArrayList<Compra>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conexao.prepareStatement(SELECT_BY_ID);
			ps.setInt(1, idDoFornecedor);
			rs = ps.executeQuery();
			while (rs.next()) {
				compras.add(extrairDo(rs));
			}
		} catch (Exception e) {
			throw new RuntimeException("Ocorre um erro ao listar as compras. Motivo: " + e.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
			ManagerDb.getInstance().fechar(rs);
		}
		return compras;
	}

	private Colaborador extrairDoColaborador(ResultSet rs) {
		try {

			int idDoColaborador = rs.getInt("id");
			String nomeCompleto = rs.getString("nome_completo");
			return new Colaborador(idDoColaborador, nomeCompleto);

		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao extrair os colaboradores. Motivo: " + e.getMessage());
		}
	}
	
	
	public void ListarColaborador () {
		PreparedStatement ps = null;
		List<Colaborador> colaborador = new ArrayList<Colaborador>();
		ResultSet rs = null;
		try {
			ps = conexao.prepareStatement(SELECT_COLABORADOR);
			rs = ps.executeQuery();
			 while (rs.next()) {
				 colaborador.add(extrairDo(rs));
			 }
			
			
			
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao listar os colaboradores. Motivo: " + e.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
			ManagerDb.getInstance().fechar(rs);
			
			
			
		}
		
				
				
				
		
		
	}
	

}
