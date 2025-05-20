import java.util.Arrays;


public class Main {
	/**
	 * Programa principal
	 */
	public static void main(String[] args) {
		/*Algunas pruebas*/
		MergeSort mg = new MergeSort();
		int [] v = {};
		int [] h = {10};
		int [] w = {83,26,9,23,30,14,55,9,40,5};
		int [] u = {83,26,9,23,30,14,55,5,9};
		
		System.out.println(Arrays.toString(v));
		mg.mergeSort(v, 0, v.length-1);
		System.out.println(Arrays.toString(v));
		System.out.println();
		
		System.out.println(Arrays.toString(h));
		mg.mergeSort(h, 0, h.length-1);
		System.out.println(Arrays.toString(h));
		System.out.println();
		
		System.out.println(Arrays.toString(w));
		mg.mergeSort(w, 0, w.length-1);
		System.out.println(Arrays.toString(w));
		System.out.println();
		
		System.out.println(Arrays.toString(u));
		mg.mergeSort(u, 0, u.length-1);
		System.out.println(Arrays.toString(u));
		System.out.println();
		
	}
}
