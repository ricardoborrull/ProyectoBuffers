package model;

import java.io.Serializable;

public class Libro implements Serializable{

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getPaginas() {
		return paginas;
	}

	public void setPaginas(String paginas) {
		this.paginas = paginas;
	}

	private String id;
	private String titulo;
	private String autor;
	private String editor;
	private String paginas;
	private String año;
	
	public Libro(String id, String titulo, String autor, String editor, String paginas, String año) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.editor = editor;
		this.paginas = paginas;
		this.año = año;
	}
	
	@Override
	public String toString() {
		String libro = "Título: "+titulo+"\nAutor: "+autor+"\nEditor: "+editor+"\nPáginas: "+paginas+"\nAño: "+año;
		return libro;
	}}
