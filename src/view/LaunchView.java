package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JSeparator;
import java.awt.Color;

public class LaunchView extends JFrame {

	private JPanel Principal, Gestor, Biblioteca, Consola;	
	private JTextField fichero1, fichero2, palabra;
	private JCheckBox primera;
	private JTextField titulo, autor, editor, paginas, anho;
	private JButton copiar, guardar, comparar, recuperarL, recuperarT, buscar;
	private JTextArea textArea_1;

	public LaunchView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,200,1000,450);
		setTitle("Proyecto Buffers - Ricardo Borrull Vilches");
		Principal = new JPanel();
		Principal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Principal);
		Principal.setLayout(new GridLayout(1, 0, 0, 0));
		
		Gestor = new JPanel();
		Principal.add(Gestor);
		GridBagLayout gbl_Gestor = new GridBagLayout();
		gbl_Gestor.columnWidths = new int[]{74, 90, 0, 0};
		gbl_Gestor.rowHeights = new int[]{37, 0, 14, 19, 0, 0, 0, 26, 0, 0, 21, 0, 0, 0, 26, 0};
		gbl_Gestor.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_Gestor.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		Gestor.setLayout(gbl_Gestor);
		
		JSeparator separator_2 = new JSeparator();
		GridBagConstraints gbc_separator_2 = new GridBagConstraints();
		gbc_separator_2.insets = new Insets(0, 0, 5, 5);
		gbc_separator_2.gridx = 1;
		gbc_separator_2.gridy = 0;
		Gestor.add(separator_2, gbc_separator_2);
		
		JLabel etGestor = new JLabel("Gestor de");
		etGestor.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_etGestor = new GridBagConstraints();
		gbc_etGestor.gridwidth = 2;
		gbc_etGestor.insets = new Insets(0, 0, 5, 5);
		gbc_etGestor.gridx = 0;
		gbc_etGestor.gridy = 1;
		Gestor.add(etGestor, gbc_etGestor);
		
		JLabel etFicheros = new JLabel("Ficheros");
		etFicheros.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_etFicheros = new GridBagConstraints();
		gbc_etFicheros.gridwidth = 2;
		gbc_etFicheros.insets = new Insets(0, 0, 5, 5);
		gbc_etFicheros.gridx = 0;
		gbc_etFicheros.gridy = 2;
		Gestor.add(etFicheros, gbc_etFicheros);
		
		JSeparator separator_6 = new JSeparator();
		GridBagConstraints gbc_separator_6 = new GridBagConstraints();
		gbc_separator_6.insets = new Insets(0, 0, 5, 5);
		gbc_separator_6.gridx = 1;
		gbc_separator_6.gridy = 3;
		Gestor.add(separator_6, gbc_separator_6);
		
		JLabel etFichero1 = new JLabel("Fichero 1:");
		GridBagConstraints gbc_etFichero1 = new GridBagConstraints();
		gbc_etFichero1.anchor = GridBagConstraints.EAST;
		gbc_etFichero1.insets = new Insets(0, 0, 5, 5);
		gbc_etFichero1.gridx = 0;
		gbc_etFichero1.gridy = 4;
		Gestor.add(etFichero1, gbc_etFichero1);
		
		fichero1 = new JTextField("", 10);
		GridBagConstraints gbc_fichero1 = new GridBagConstraints();
		gbc_fichero1.insets = new Insets(0, 0, 5, 5);
		gbc_fichero1.fill = GridBagConstraints.HORIZONTAL;
		gbc_fichero1.gridx = 1;
		gbc_fichero1.gridy = 4;
		Gestor.add(fichero1, gbc_fichero1);
		
		JLabel etFichero2 = new JLabel("Fichero 2:");
		GridBagConstraints gbc_etFichero2 = new GridBagConstraints();
		gbc_etFichero2.anchor = GridBagConstraints.EAST;
		gbc_etFichero2.insets = new Insets(0, 0, 5, 5);
		gbc_etFichero2.gridx = 0;
		gbc_etFichero2.gridy = 5;
		Gestor.add(etFichero2, gbc_etFichero2);
		
		fichero2 = new JTextField("", 10);
		GridBagConstraints gbc_fichero2 = new GridBagConstraints();
		gbc_fichero2.insets = new Insets(0, 0, 5, 5);
		gbc_fichero2.fill = GridBagConstraints.HORIZONTAL;
		gbc_fichero2.gridx = 1;
		gbc_fichero2.gridy = 5;
		Gestor.add(fichero2, gbc_fichero2);
		
		JLabel Warning = new JLabel("*ATENCI\u00D3N: Usar siempre la ruta total de los ficheros.*");
		Warning.setForeground(Color.RED);
		Warning.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_Warning = new GridBagConstraints();
		gbc_Warning.gridwidth = 2;
		gbc_Warning.insets = new Insets(0, 0, 5, 5);
		gbc_Warning.gridx = 0;
		gbc_Warning.gridy = 6;
		Gestor.add(Warning, gbc_Warning);
		
		JSeparator separator_4 = new JSeparator();
		GridBagConstraints gbc_separator_4 = new GridBagConstraints();
		gbc_separator_4.insets = new Insets(0, 0, 5, 5);
		gbc_separator_4.gridx = 1;
		gbc_separator_4.gridy = 7;
		Gestor.add(separator_4, gbc_separator_4);
		
		JLabel etPalabra = new JLabel("Palabra:");
		GridBagConstraints gbc_etPalabra = new GridBagConstraints();
		gbc_etPalabra.anchor = GridBagConstraints.EAST;
		gbc_etPalabra.insets = new Insets(0, 0, 5, 5);
		gbc_etPalabra.gridx = 0;
		gbc_etPalabra.gridy = 8;
		Gestor.add(etPalabra, gbc_etPalabra);
		
		palabra = new JTextField("", 10);
		GridBagConstraints gbc_palabra = new GridBagConstraints();
		gbc_palabra.insets = new Insets(0, 0, 5, 5);
		gbc_palabra.fill = GridBagConstraints.HORIZONTAL;
		gbc_palabra.gridx = 1;
		gbc_palabra.gridy = 8;
		Gestor.add(palabra, gbc_palabra);
		
		primera = new JCheckBox("Primera aparici\u00F3n");
		GridBagConstraints gbc_primera = new GridBagConstraints();
		gbc_primera.insets = new Insets(0, 0, 5, 5);
		gbc_primera.gridx = 1;
		gbc_primera.gridy = 9;
		Gestor.add(primera, gbc_primera);
		
		JSeparator separator_5 = new JSeparator();
		GridBagConstraints gbc_separator_5 = new GridBagConstraints();
		gbc_separator_5.insets = new Insets(0, 0, 5, 5);
		gbc_separator_5.gridx = 1;
		gbc_separator_5.gridy = 10;
		Gestor.add(separator_5, gbc_separator_5);
		
		comparar = new JButton("Comparar Contenido");
		comparar.setPreferredSize(new Dimension(150, 26));
		GridBagConstraints gbc_comparar = new GridBagConstraints();
		gbc_comparar.insets = new Insets(0, 0, 5, 5);
		gbc_comparar.gridx = 1;
		gbc_comparar.gridy = 11;
		Gestor.add(comparar, gbc_comparar);
		
		buscar = new JButton("Buscar Palabra");
		buscar.setPreferredSize(new Dimension(150, 26));
		GridBagConstraints gbc_buscar = new GridBagConstraints();
		gbc_buscar.insets = new Insets(0, 0, 5, 5);
		gbc_buscar.gridx = 1;
		gbc_buscar.gridy = 12;
		Gestor.add(buscar, gbc_buscar);
		
		copiar = new JButton("Copiar Fichero");
		copiar.setPreferredSize(new Dimension(150, 26));
		GridBagConstraints gbc_copiar = new GridBagConstraints();
		gbc_copiar.insets = new Insets(0, 0, 5, 5);
		gbc_copiar.gridx = 1;
		gbc_copiar.gridy = 13;
		Gestor.add(copiar, gbc_copiar);
		
		JSeparator separator_3 = new JSeparator();
		GridBagConstraints gbc_separator_3 = new GridBagConstraints();
		gbc_separator_3.insets = new Insets(0, 0, 0, 5);
		gbc_separator_3.gridx = 1;
		gbc_separator_3.gridy = 14;
		Gestor.add(separator_3, gbc_separator_3);
		
		Biblioteca = new JPanel();
		Principal.add(Biblioteca);
		GridBagLayout gbl_Biblioteca = new GridBagLayout();
		gbl_Biblioteca.columnWidths = new int[]{0, 0, 0, 0};
		gbl_Biblioteca.rowHeights = new int[]{57, 0, 23, 0, 0, 0, 0, 0, 22, 0, 0, 0, 24, 0};
		gbl_Biblioteca.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_Biblioteca.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		Biblioteca.setLayout(gbl_Biblioteca);
		
		JLabel label_6 = new JLabel("");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 1;
		gbc_label_6.gridy = 0;
		Biblioteca.add(label_6, gbc_label_6);
		
		JLabel etBiblioteca = new JLabel("Biblioteca");
		etBiblioteca.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_etBiblioteca = new GridBagConstraints();
		gbc_etBiblioteca.gridwidth = 2;
		gbc_etBiblioteca.insets = new Insets(0, 0, 5, 5);
		gbc_etBiblioteca.gridx = 0;
		gbc_etBiblioteca.gridy = 1;
		Biblioteca.add(etBiblioteca, gbc_etBiblioteca);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 2;
		Biblioteca.add(separator, gbc_separator);
		
		JLabel label = new JLabel("Titulo");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.gridx = 0;
		gbc_label.gridy = 3;
		Biblioteca.add(label, gbc_label);
		
		titulo = new JTextField("", 10);
		GridBagConstraints gbc_titulo = new GridBagConstraints();
		gbc_titulo.insets = new Insets(0, 0, 5, 5);
		gbc_titulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_titulo.gridx = 1;
		gbc_titulo.gridy = 3;
		Biblioteca.add(titulo, gbc_titulo);
		
		JLabel label_1 = new JLabel("Autor");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 4;
		Biblioteca.add(label_1, gbc_label_1);
		
		autor = new JTextField("", 10);
		GridBagConstraints gbc_autor = new GridBagConstraints();
		gbc_autor.insets = new Insets(0, 0, 5, 5);
		gbc_autor.fill = GridBagConstraints.HORIZONTAL;
		gbc_autor.gridx = 1;
		gbc_autor.gridy = 4;
		Biblioteca.add(autor, gbc_autor);
		
		JLabel label_2 = new JLabel("Editor");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 5;
		Biblioteca.add(label_2, gbc_label_2);
		
		editor = new JTextField("", 10);
		GridBagConstraints gbc_editor = new GridBagConstraints();
		gbc_editor.insets = new Insets(0, 0, 5, 5);
		gbc_editor.fill = GridBagConstraints.HORIZONTAL;
		gbc_editor.gridx = 1;
		gbc_editor.gridy = 5;
		Biblioteca.add(editor, gbc_editor);
		
		JLabel label_3 = new JLabel("Páginas");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 6;
		Biblioteca.add(label_3, gbc_label_3);
		
		paginas = new JTextField("", 10);
		GridBagConstraints gbc_paginas = new GridBagConstraints();
		gbc_paginas.insets = new Insets(0, 0, 5, 5);
		gbc_paginas.fill = GridBagConstraints.HORIZONTAL;
		gbc_paginas.gridx = 1;
		gbc_paginas.gridy = 6;
		Biblioteca.add(paginas, gbc_paginas);
		
		JLabel label_4 = new JLabel("A\u00F1o");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 7;
		Biblioteca.add(label_4, gbc_label_4);
		
		anho = new JTextField("", 10);
		GridBagConstraints gbc_anho = new GridBagConstraints();
		gbc_anho.insets = new Insets(0, 0, 5, 5);
		gbc_anho.fill = GridBagConstraints.HORIZONTAL;
		gbc_anho.gridx = 1;
		gbc_anho.gridy = 7;
		Biblioteca.add(anho, gbc_anho);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 1;
		gbc_separator_1.gridy = 8;
		Biblioteca.add(separator_1, gbc_separator_1);
		
		guardar = new JButton("Guardar Libro");
		guardar.setPreferredSize(new Dimension(150, 26));
		GridBagConstraints gbc_guardar = new GridBagConstraints();
		gbc_guardar.insets = new Insets(0, 0, 5, 5);
		gbc_guardar.gridx = 1;
		gbc_guardar.gridy = 9;
		Biblioteca.add(guardar, gbc_guardar);
		
		recuperarL = new JButton("Recuperar Libro");
		recuperarL.setPreferredSize(new Dimension(150, 26));
		GridBagConstraints gbc_recuperarL = new GridBagConstraints();
		gbc_recuperarL.insets = new Insets(0, 0, 5, 5);
		gbc_recuperarL.gridx = 1;
		gbc_recuperarL.gridy = 10;
		Biblioteca.add(recuperarL, gbc_recuperarL);
		
		recuperarT = new JButton("Recuperar Todos");
		recuperarT.setPreferredSize(new Dimension(150, 26));
		GridBagConstraints gbc_recuperarT = new GridBagConstraints();
		gbc_recuperarT.insets = new Insets(0, 0, 5, 5);
		gbc_recuperarT.gridx = 1;
		gbc_recuperarT.gridy = 11;
		Biblioteca.add(recuperarT, gbc_recuperarT);
		
		JLabel label_5 = new JLabel("");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 0, 5);
		gbc_label_5.gridx = 1;
		gbc_label_5.gridy = 12;
		Biblioteca.add(label_5, gbc_label_5);
		
		Consola = new JPanel();
		Principal.add(Consola);
		
		textArea_1 = new JTextArea(20, 20);
		
		textArea_1.setEditable(false);
		Consola.add(textArea_1);
	}
	
	public JButton getComparar() {
		return comparar;
	}

	public void setComparar(JButton comparar) {
		this.comparar = comparar;
	}
	public JButton getCopiar() {
		return copiar;
	}

	public void setCopiar(JButton copiar) {
		this.copiar = copiar;
	}
	
	public JButton getBuscar() {
		return buscar;
	}

	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
				}

	public JButton getGuardar() {
		return guardar;
	}

	public void setGuardar(JButton guardar) {
		this.guardar = guardar;
	}

	public JButton getRecuperarL() {
		return recuperarL;
	}

	public void setRecuperarL(JButton recuperarL) {
		this.recuperarL = recuperarL;
	}

	public JButton getRecuperarT() {
		return recuperarT;
	}

	public void setRecuperarT(JButton recuperarT) {
		this.recuperarT = recuperarT;
	}

	public JTextArea getTextArea_1() {
		return textArea_1;
	}

	public void setTextArea(JTextArea textArea_1) {
		this.textArea_1 = textArea_1;
	}

	public void showError(String m) {
		JOptionPane.showMessageDialog(this.textArea_1,
			    m,
			    "Error",
			    JOptionPane.ERROR_MESSAGE);
		
	}

	public JTextField getFichero1() {
		return fichero1;
	}
	
	public void setFichero1(JTextField fichero1) {
		this.fichero1 = fichero1;
	}
	
	public JTextField getFichero2() {
		return fichero2;
	}
	
	public void setFichero2(JTextField fichero2) {
		this.fichero2 = fichero2;
	}
	
	public JTextField getPalabra() {
		return palabra;
	}

	public void setPalabra(JTextField palabra) {
		this.palabra = palabra;
	}

	public JCheckBox getPrimera() {
		return primera;
	}

	public void setPrimera(JCheckBox primera) {
		this.primera = primera;
	}
	
	public JTextField getTitulo() {
		return titulo;
	}
	
	public void setTitulo(JTextField titulo) {
		this.titulo = titulo;
	}
	
	public JTextField getAutor() {
		return autor;
	}
	
	public void setAutor(JTextField autor) {
		this.autor = autor;
	}
	
	public void setEditor(JTextField editor) {
		this.editor = editor;
	}
	
	public JTextField getEditor() {
		return editor;
	}
	
	public void setPaginas(JTextField paginas) {
		this.paginas = paginas;
	}
	
	public JTextField getPaginas() {
		return paginas;
	}
	
	public JTextField getAnho() {
		return anho;
	}
	
	public void setAnho(JTextField anho) {
		this.anho = anho;
	}

}
