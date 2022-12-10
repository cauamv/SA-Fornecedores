package br.com.senai.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;

public class ViewConsultaCompra extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable tableCompra;

	/**
	 * Create the frame.
	 */
	public ViewConsultaCompra() {
		setTitle("Gerenciar Compra - Listagem");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 411, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBackground(SystemColor.textHighlight);
		btnRegistrar.setBounds(294, 12, 89, 23);
		contentPane.add(btnRegistrar);
		
		JLabel lblFiltro = new JLabel("Filtro");
		lblFiltro.setBounds(12, 47, 55, 16);
		contentPane.add(lblFiltro);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(12, 75, 216, 20);
		contentPane.add(textField);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setForeground(Color.WHITE);
		btnListar.setBackground(SystemColor.textHighlight);
		btnListar.setBounds(240, 72, 89, 23);
		contentPane.add(btnListar);
		
		JLabel lblResultados = new JLabel("Resultados");
		lblResultados.setBounds(12, 107, 74, 16);
		contentPane.add(lblResultados);
		
		JScrollPane spCompras = new JScrollPane((Component) null);
		spCompras.setBounds(12, 135, 375, 86);
		contentPane.add(spCompras);
		
		tableCompra = new JTable();
		spCompras.setViewportView(tableCompra);
		
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.setForeground(Color.WHITE);
		btnVisualizar.setBackground(SystemColor.textHighlight);
		btnVisualizar.setBounds(277, 233, 106, 23);
		contentPane.add(btnVisualizar);
	}
}
