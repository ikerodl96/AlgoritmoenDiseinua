import java.util.Arrays;

public class Main {
	/**
	 * Programa principal
	 */
	public static void main(String[] args) {
		/*Algunas pruebas*/
		EntradaSalida io = new EntradaSalida();
		SeleccionK sk = new SeleccionK();
		StringBuilder contenidoAEscribir = new StringBuilder();
		
		int [] y = io.leerVectorDesdeFichero("data/v1.txt");
		contenidoAEscribir.append("Vector 1 (�nico elemento): " + Arrays.toString(y) + "\n");
		contenidoAEscribir.append("Elemento 1-�simo m�s grande: " + sk.seleccionK(y,1,0,y.length-1) + "\n");
		
		int [] w = io.leerVectorDesdeFichero("data/v2.txt");
		contenidoAEscribir.append("Vector 2 (12 elementos): " + Arrays.toString(w) + "\n");
		contenidoAEscribir.append("Elemento 1-�simo m�s grande: " + sk.seleccionK(w,1,0,w.length-1) + "\n");
		w = io.leerVectorDesdeFichero("data/v2.txt");
		contenidoAEscribir.append("Elemento 2-�simo m�s grande: " + sk.seleccionK(w,2,0,w.length-1) + "\n");
		w = io.leerVectorDesdeFichero("data/v2.txt");
		contenidoAEscribir.append("Elemento 3-�simo m�s grande: " + sk.seleccionK(w,3,0,w.length-1) + "\n");
		w = io.leerVectorDesdeFichero("data/v2.txt");
		contenidoAEscribir.append("Elemento 4-�simo m�s grande: " + sk.seleccionK(w,4,0,w.length-1) + "\n");
		w = io.leerVectorDesdeFichero("data/v2.txt");
		contenidoAEscribir.append("Elemento 5-�simo m�s grande: " + sk.seleccionK(w,5,0,w.length-1) + "\n");
		w = io.leerVectorDesdeFichero("data/v2.txt");
		contenidoAEscribir.append("Elemento 6-�simo m�s grande: " + sk.seleccionK(w,6,0,w.length-1) + "\n");
		w = io.leerVectorDesdeFichero("data/v2.txt");
		contenidoAEscribir.append("Elemento 7-�simo m�s grande: " + sk.seleccionK(w,7,0,w.length-1) + "\n");
		w = io.leerVectorDesdeFichero("data/v2.txt");
		contenidoAEscribir.append("Elemento 8-�simo m�s grande: " + sk.seleccionK(w,8,0,w.length-1) + "\n");
		w = io.leerVectorDesdeFichero("data/v2.txt");
		contenidoAEscribir.append("Elemento 9-�simo m�s grande: " + sk.seleccionK(w,9,0,w.length-1) + "\n");
		w = io.leerVectorDesdeFichero("data/v2.txt");
		contenidoAEscribir.append("Elemento 10-�simo m�s grande: " + sk.seleccionK(w,10,0,w.length-1) + "\n");
		w = io.leerVectorDesdeFichero("data/v2.txt");
		contenidoAEscribir.append("Elemento 11-�simo m�s grande: " + sk.seleccionK(w,11,0,w.length-1) + "\n");
		w = io.leerVectorDesdeFichero("data/v2.txt");
		contenidoAEscribir.append("Elemento 12-�simo m�s grande: " + sk.seleccionK(w,12,0,w.length-1) + "\n");
		
		System.out.println(contenidoAEscribir.toString());
		io.escribirEnFichero("data/salida.txt", contenidoAEscribir.toString());
	}
}
