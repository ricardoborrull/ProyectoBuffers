package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import model.*;
import view.*;

public class GestionEventos {

	private GestionDatos model;
	private LaunchView view;
	private ActionListener actionListener_comparar, actionListener_buscar, actionListener_copiar,
	actionListener_guardar, actionListener_recuperarL, actionListener_recuperarT;

	public GestionEventos(GestionDatos model, LaunchView view) {
		this.model = model;
		this.view = view;
	}

	public void contol() {
		actionListener_comparar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_compararContenido
				call_compararContenido();
			}
		};
		view.getComparar().addActionListener(actionListener_comparar);;

		actionListener_buscar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_buscarPalabra
				call_buscarPalabra();
			}
		};
		view.getBuscar().addActionListener(actionListener_buscar);
	
	
		actionListener_copiar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_copiaFicheros
				call_copiaFicheros();
			}
		};
		view.getCopiar().addActionListener(actionListener_copiar);
	
		actionListener_guardar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_guardaLibros
				call_guardaLibros();
			}
		};
		view.getGuardar().addActionListener(actionListener_guardar);
		
		actionListener_recuperarL = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_recuperaL
				call_recuperaLibros();
			}
		};
		view.getRecuperarL().addActionListener(actionListener_recuperarL);
		
		actionListener_recuperarT = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_recuperaT
				call_recuperaTodos();
			}
		};
		view.getRecuperarT().addActionListener(actionListener_recuperarT);
	}

	private void call_compararContenido() {

		// TODO: Llamar a la función compararContenido de GestionDatos
		
		String fichero1 = view.getFichero1().getText();
		String fichero2 = view.getFichero2().getText();
		boolean sonIguales;
		
		// TODO: Gestionar excepciones		
		
		try {
			sonIguales = model.compararContenido(fichero1, fichero2);			
			
			if (sonIguales) 
				view.getTextArea_1().setText("Los Ficheros son Iguales.");
			else
				view.getTextArea_1().setText("Los Ficheros son Diferentes.");	
			
		} catch (FileNotFoundException e) {
			
			// Si alguno de los dos campos están vacíos saldrán estos errores:
			if (fichero1.length() == 0) {
					view.showError("Por favor, introduce:  \"Fichero 1\"");
				} else if (fichero2.length() == 0) {
					view.showError("Por favor, introduce:  \"Fichero 2\"");
					} else
				// Si no existe ningún fichero con el nombre indicado saldrá este error:
				view.showError(e.getMessage()+" no existe");
			
			} catch (IOException e) {
				
			view.showError("ERROR");
		}
	}

	private void call_buscarPalabra() {
		// TODO: Llamar a la función buscarPalabra de GestionDatos
		String fichero1 = view.getFichero1().getText();
		String busqueda = view.getPalabra().getText().trim();
		
		// TODO: Gestionar excepciones
		try {		
			int resultado;
			boolean primera_aparicion = view.getPrimera().isSelected();
			resultado = model.buscarPalabra(fichero1, busqueda, primera_aparicion);	

			if (resultado > 0) {
				if (primera_aparicion)
					view.getTextArea_1().setText("\""+busqueda+"\""+" aparece por primera vez en la línea "+resultado);
				else
					view.getTextArea_1().setText("\""+busqueda+"\""+" aparece por última vez en la línea "+resultado);
			} else if (resultado == -1) {
				//Si no encuentra la palabra:
				view.getTextArea_1().setText("No se ha encontrado esa palabra");
			}
			
		}  catch (FileNotFoundException e) {
			// Si dejas el campo vacío saldrá este error:
			if (fichero1.length() == 0)
				view.showError("Por favor, introduce:   \"Fichero 1\"");
			else
				// Si no encuentra ningún fichero que se llame así saldrá este error:
				view.showError(e.getMessage()+" no existe");
		} catch (IOException e) {
			view.showError("ERROR: No existe ningún fichero con ese nombre");
		}
	}
	
	private void call_copiaFicheros() {
		
		//Declaramos y hacemos la función para copiar ficheros
		try {
			String fichero1 = view.getFichero1().getText();
			String fichero2 = view.getFichero2().getText();
			int bytesCopiados = 0;
			bytesCopiados = model.copiaFicheros(fichero1, fichero2);
			view.getTextArea_1().setText("Nuevo fichero creado, "+bytesCopiados+" bytes copiados.");
		} catch (IOException e) {
			view.showError("ERROR: Falta la ruta de destino");
		}
	}
	
	private void call_guardaLibros() {
		
		// Declaramos los strings y recogemos la información de los campos de Texto
		String titulo, autor, editor, paginas, anho;
		titulo = view.getTitulo().getText();
		autor = view.getAutor().getText();
		editor = view.getEditor().getText();
		paginas = view.getPaginas().getText();
		anho = view.getAnho().getText();
		
		if (titulo.length() != 0) {		
			try {
				model.guardaLibros(titulo, titulo, autor, editor, paginas, anho);
				view.getTextArea_1().setText("El libro "+titulo+", se ha creado con éxito");
			} catch (IOException e) {
				view.showError("ERROR");}
		
		} else
			view.showError("Es necesario que pongas un título al libro");
	}
	
	private void call_recuperaLibros() {
		
		// Obtenemos el titulo  del libro que queremos buscar:
		String titulo;
		titulo = view.getTitulo().getText();
		view.getTextArea_1().setText(titulo);
		if (titulo.length() != 0) {		
			
			try {
				
				// Si no existe saldrá este error:
				Libro libro;
				libro = model.recuperaLibros(titulo);
				view.getTextArea_1().setText(libro.toString());
			} catch (FileNotFoundException e) {
				view.showError("No se ha encontrado un libro con esa información");
			} catch (ClassNotFoundException | IOException e) {
				view.showError("ERROR");
			}
		}		
	}
	
	private void call_recuperaTodos() {
		
		//Declaramos todo
		try {
			ArrayList<Libro> libros = new ArrayList<Libro>();
			StringBuilder resultado = new StringBuilder();
			String encabezado;
			libros = model.recuperaTodos();
			
			// Comprobamos si hemos obtenido algun resultado
			encabezado = libros.size() == 0 ?  "Sin resultados" :  libros.size()+" libros en la Biblioteca:\n";
			resultado.append(encabezado);
			for (int i=0; i<libros.size(); i++){
				resultado.append("Título: "+libros.get(i).getTitulo()+"\n");
			}
			view.getTextArea_1().setText(resultado.toString());
		} catch (Exception e) {
			view.showError("ERROR");
		}
	}

}
