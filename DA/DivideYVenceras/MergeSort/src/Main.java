import java.util.Arrays;


public class Main {
	/**
	 * Programa principal
	 */
	public static void main(String[] args) {
		/*Algunas pruebas*/
		EntradaSalida io = new EntradaSalida();
		MergeSort mg = new MergeSort();
		
		int [] v = io.leerVectorDesdeFichero("data/v0.txt");
		System.out.print("Vector 0 (vacio): " + Arrays.toString(v) + "\n");
		mg.ordenPorMezcla(v,0,v.length-1);
		System.out.print("Vector 0 ordenado: " + Arrays.toString(v) + "\n");
		io.escribirVectorAFichero("data/v0out.txt", v);
		
		int [] y = io.leerVectorDesdeFichero("data/v1.txt");
		System.out.print("Vector 1 (único elemento): " + Arrays.toString(y) + "\n");
		mg.ordenPorMezcla(y,0,y.length-1);
		System.out.print("Vector 1 ordenado: " + Arrays.toString(y) + "\n");
		io.escribirVectorAFichero("data/v1out.txt", y);
		
		int [] w = io.leerVectorDesdeFichero("data/v2.txt");
		System.out.print("Vector 2 (número impar de elementos): " + Arrays.toString(w) + "\n");
		mg.ordenPorMezcla(w,0,w.length-1);
		System.out.print("Vector 2 ordenado: " + Arrays.toString(w) + "\n");
		io.escribirVectorAFichero("data/v2out.txt", w);
		
		int [] x = io.leerVectorDesdeFichero("data/v3.txt");
		System.out.print("Vector 3 (número par de elementos): " + Arrays.toString(x) + "\n");
		mg.ordenPorMezcla(x,0,x.length-1);
		System.out.print("Vector 3 ordenado: " + Arrays.toString(x) + "\n");
		io.escribirVectorAFichero("data/v3out.txt", x);
	}
}
