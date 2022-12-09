package br.com.senai.view;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.senai.core.domain.Colaborador;
import br.com.senai.core.domain.Fornecedor;
import br.com.senai.core.domain.Mercadoria;
import br.com.senai.core.service.ColaboradorService;
import br.com.senai.core.service.CompraService;
import br.com.senai.core.service.FornecedorService;
import br.com.senai.core.service.ItemService;
import br.com.senai.core.service.MercadoriaService;

public class ViewCadastroCompra extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private JTable tableItens;
	
	private JTextField edtDataDaCompra;
	private JTextField edtQtde;
	private JTextField edtTotal;
	
	private JComboBox<Colaborador> cbColaborador;
	private JComboBox<Fornecedor> cbFornecedor;
	private JComboBox<Mercadoria> cbMercadoria;
	
	private CompraService compraService;
	private ColaboradorService colaboradorService;
	private FornecedorService fornecedorService;
	private MercadoriaService mercadoriaService;
	private ItemService itemService;
	
	public void carregarComboColaborador() {
		List<Colaborador> colaboradores = colaboradorService.listarTodos();
		for (Colaborador u : colaboradores) {
			cbColaborador.addItem(u);
		}
	}
	
	public void carregarComboFornecedor() {
		List<Fornecedor> colaboradores = fornecedorService.listarPor();
		for (Fornecedor u : colaboradores) {
			cbFornecedor.addItem(u);
		}
	}
	
	public void carregarComboMercadoria() {
		List<Mercadoria> mercadorias = mercadoriaService.listarTodas();
		for (Mercadoria u : mercadorias) {
			cbMercadoria.addItem(u);
		}
	}
	
	/**
	 * Create the frame.
	 */
	public ViewCadastroCompra() {
		setTitle("Gerenciar Compra - Cadastro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 491, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setBackground(SystemColor.textHighlight);
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConsultar.setBounds(374, 12, 89, 23);
		contentPane.add(btnConsultar);
		
		JLabel lblColaborador = new JLabel("Colaborador*");
		lblColaborador.setBounds(10, 48, 82, 16);
		contentPane.add(lblColaborador);
		
		JComboBox cbColaborador = new JComboBox();
		cbColaborador.setBounds(10, 75, 332, 25);
		contentPane.add(cbColaborador);
		
		JLabel lblDataDaCompra = new JLabel("Data da Compra");
		lblDataDaCompra.setBounds(354, 48, 108, 16);
		contentPane.add(lblDataDaCompra);
		
		edtDataDaCompra = new JTextField();
		edtDataDaCompra.setEnabled(false);
		edtDataDaCompra.setBounds(354, 75, 109, 25);
		contentPane.add(edtDataDaCompra);
		edtDataDaCompra.setColumns(10);
		
		JLabel lblFornecedor = new JLabel("Fornecedor*");
		lblFornecedor.setBounds(10, 112, 82, 16);
		contentPane.add(lblFornecedor);
		
		JComboBox cbFornecedor = new JComboBox();
		cbFornecedor.setBounds(10, 140, 453, 25);
		contentPane.add(cbFornecedor);
		
		JLabel lblMercadoria = new JLabel("Mercadoria*");
		lblMercadoria.setBounds(10, 177, 82, 16);
		contentPane.add(lblMercadoria);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 205, 211, 25);
		contentPane.add(comboBox);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setForeground(Color.WHITE);
		btnRemover.setBackground(SystemColor.textHighlight);
		btnRemover.setBounds(374, 204, 89, 23);
		contentPane.add(btnRemover);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setForeground(Color.WHITE);
		btnAdicionar.setBackground(SystemColor.textHighlight);
		btnAdicionar.setBounds(273, 204, 89, 23);
		contentPane.add(btnAdicionar);
		
		edtQtde = new JTextField();
		edtQtde.setBounds(233, 205, 28, 25);
		contentPane.add(edtQtde);
		edtQtde.setColumns(10);
		
		JLabel lblQtde = new JLabel("Qtde");
		lblQtde.setBounds(233, 177, 55, 16);
		contentPane.add(lblQtde);
		
		JLabel lblItens = new JLabel("Itens");
		lblItens.setBounds(12, 242, 57, 16);
		contentPane.add(lblItens);
		
		JScrollPane spItens = new JScrollPane();
		spItens.setBounds(10, 270, 453, 87);
		contentPane.add(spItens);
		
		tableItens = new JTable();
		spItens.setViewportView(tableItens);
		
		JLabel lblTotal = new JLabel("Total (R$)");
		lblTotal.setBounds(349, 369, 55, 16);
		contentPane.add(lblTotal);
		
		edtTotal = new JTextField();
		edtTotal.setEnabled(false);
		edtTotal.setBounds(349, 397, 114, 20);
		contentPane.add(edtTotal);
		edtTotal.setColumns(10);
		
		JLabel lblObservacoes = new JLabel("Observa\u00E7\u00F5es");
		lblObservacoes.setBounds(10, 429, 89, 16);
		contentPane.add(lblObservacoes);
		
		JTextArea taObservacoes = new JTextArea();
		taObservacoes.setBounds(10, 458, 453, 87);
		contentPane.add(taObservacoes);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBackground(SystemColor.textHighlight);
		btnSalvar.setBounds(374, 559, 89, 23);
		contentPane.add(btnSalvar);
	}
}
