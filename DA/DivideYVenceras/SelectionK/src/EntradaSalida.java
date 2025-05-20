import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EntradaSalida {
	
	/**
	 * Procedimiento que dado un fichero que contiene un vector de enteros
	 * representado en un formato adecuado*, lee y carga todos los enteros del
	 * fichero en un vector que devuelve como resultado.
	 * 
	 * @param fich Nombre del fichero de texto en el que se encuentran los 
	 * enteros del vector
	 * @return Vector con los enteros leidos desde el fichero fich
	 * 
	 * *FORMATO: Cada fichero representa un vector y el formato es el siguiente:
	 * Primera linea: Número de elementos que contiene el vector 
	 * Segunda línea: Números enteros que componen el vector separados por espacios
	 */
	public int[] leerVectorDesdeFichero(String fich){
		int[] vector = null;
		try {
			Scanner s = new Scanner(new File(fich));
			int numElementos = s.nextInt();
			vector = new int[numElementos];
			for(int i=0; i<numElementos; i++){
				vector[i] = s.nextInt();
			}
			s.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error en la lectura del vector desde el fichero " + fich);
			e.printStackTrace();
			System.exit(-1);
		}
		return vector;
	}
	
	/**
	 * Procedimiento que dado un vector de enteros, lo escribe en un fichero (fich) 
	 * siguiendo un determinado formato*. 
	 * 
	 * @param fich Nombre del fichero de texto de salida (si no está creado se crea 
	 *  y sino se sobreescribe)
	 * @param vector Vector de números enteros a escribir en el fichero
	 * 
	 * *FORMATO: Un fichero representa un único vector y el formato es el siguiente:
	 * Primera linea: Número de elementos que contiene el vector 
	 * Segunda línea: Números enteros que componen el vector separados por espacios
	 */
	public void escribirEnFichero(String fich, String contenido){
		BufferedWriter outputWriter;
		try {
			outputWriter = new BufferedWriter(new FileWriter(fich));
			outputWriter.write(contenido);
			outputWriter.flush();  
			outputWriter.close();  
		} catch (IOException e) {
			System.out.println("Error al realizar la escritura en el fichero " + fich);
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
}
