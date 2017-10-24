package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GestionDatos {

	public GestionDatos() {

	}

	//TODO: Implementa una función para abrir ficheros
		public BufferedReader abreFicheros(File fichero) throws FileNotFoundException {
		return new BufferedReader(new FileReader(fichero));
		}
		
	//TODO: Implementa una función para cerrar ficheros
		public void cierraFicheros(BufferedReader br) throws IOException {
			br.close();
		}
	
	public boolean compararContenido (String fichero1, String fichero2) throws IOException{
		//TODO: Implementa la función
		
			//Declaramos los Ficheros 1 y 2
			File Fichero1 = new File(fichero1);
			File Fichero2 = new File(fichero2);
			
			//Declaramos los BufferedReaders del Fichero 1 y 2 como "Fichero Reader"
			BufferedReader FichR1 = abreFicheros(Fichero1);
			BufferedReader FichR2 = abreFicheros(Fichero2);	
			
			//Declaramos los Strings "Fichero Linea"
			String FichL1;
			String FichL2;
			
			//Creamos la función que lee nuestro fichero línea a línea y lo compara con el otro.
			while (((FichL1 = FichR1.readLine()) != null) && ((FichL2 = FichR2.readLine())!= null)) {
				if (!FichL1.equals(FichL2))
					return false;  
				} 
			
			//Cerramos los Buffers
			cierraFicheros(FichR1);
			cierraFicheros(FichR2);
			return true;		
		}

	public int buscarPalabra (String fichero1, String palabra, boolean primera_aparicion) throws IOException{
		//TODO: Implementa la función
		
		//Abrimos el Fichero1
		File Fich = new File(fichero1);	    
		BufferedReader FichR = abreFicheros(Fich);
		
		//Declaramos la línea y los contadores para las funciones.
		String linea;
		int contador = 0;
		int ultimaAparicion = 0;
		
	    // Creamos la función para encontrar la palabra en el Fichero
		
	    while ((linea = FichR.readLine()) != null) {
			contador++;
			
			if (linea.equals(palabra)) {
				if (primera_aparicion) {
					return contador;
				} else {
					ultimaAparicion = contador;
				}
			} else if (ultimaAparicion == 0){
				ultimaAparicion = -1;	    
			}
	    }
	    return ultimaAparicion;
	}
	
	//TODO: Implementamos la función para copiar ficheros.
	public int copiaFicheros(String origen, String destino) throws IOException {
		
		//Declaramos los FileIn/Out
        FileInputStream fileIS;       
        FileOutputStream fileOS;
        
        //Inicializamos las variables para marcas los bytes del origen y el destino.
        int bytesOrigen = 0;
        int bytesDestino = 0;
        
        // Creamos los streams para coger los bytes.
        fileIS = new FileInputStream(origen);
        fileOS = new FileOutputStream(destino);
        
        //Creamos la función para copiar los bytes de su origen a su destino
        while( (bytesOrigen = fileIS.read()) != -1 ){
        		bytesDestino = bytesOrigen;
        		fileOS.write(bytesOrigen);
        }
        
        // Cerramos los streams.
        fileIS.close();
        fileOS.close();  
        
        return bytesDestino;
	}
	
	public void guardaLibros(String id, String titulo, String autor, String editor, String paginas, String año) throws IOException {

		// Creamos un nuevo objeto de la clase libro
		Libro libro;
		libro = new Libro(id, titulo, autor, editor, paginas, año);
		
		// Creamos la biblioteca, donde van a ir todos nuestros libros
		FileOutputStream fileOS = null;
		fileOS = new FileOutputStream("Biblioteca\\"+id);
		
		// Guardamos los libros en ella
		ObjectOutputStream destino = null;
		destino = new ObjectOutputStream(fileOS);
		destino.writeObject(libro);
	
        // Cerramos los streams
		if (fileOS != null)
			fileOS.close();
		if (destino != null)
			destino.close();
	}
	
	public Libro recuperaLibros (String id) throws IOException, ClassNotFoundException, FileNotFoundException {
		
		// Obtenemos el fichero donde esta guardado el libro
		FileInputStream fileIS = null;
		fileIS = new FileInputStream("Biblioteca\\"+id);
		
		// Hacemos un Stream para leer el libro
		ObjectInputStream entrada = null;
		entrada = new ObjectInputStream(fileIS);
		
		// Leemos el libro
		Libro libro = null;
		libro = (Libro) entrada.readObject();
	
        // Cerramos los streams
		if (fileIS != null)
			fileIS.close();
		if (entrada != null)
			entrada.close();	
		return libro;
	}
	
	public ArrayList<Libro> recuperaTodos() throws ClassNotFoundException, FileNotFoundException, IOException {
		File biblioteca = new File("Biblioteca");
		File[] ficheros;
		ArrayList<Libro> libros = new ArrayList<Libro>();
				
		// Metemos en el array todos nuestros libros
		ficheros = biblioteca.listFiles();
		for (int i=0; i<ficheros.length; i++){
			libros.add(recuperaLibros(ficheros[i].getName()));
		}
		return libros;		
	}
}