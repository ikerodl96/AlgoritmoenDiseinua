import java.util.Arrays;


public class Main {
	/**
	 * Programa principal
	 */
	public static void main(String[] args) {
		/*Algunas pruebas*/
		QuickSort qs = new QuickSort();
		int [] v = {};
		int [] h = {10};
		int [] w = {83,26,9,23,30,14,55,9,40,5};
		int [] u = {83,26,9,23,30,14,55,5,9};
		
		System.out.println(Arrays.toString(v));
		qs.quickSort(v, 0, v.length-1);
		System.out.println(Arrays.toString(v));
		System.out.println();
		
		System.out.println(Arrays.toString(h));
		qs.quickSort(h, 0, h.length-1);
		System.out.println(Arrays.toString(h));
		System.out.println();
		
		System.out.println(Arrays.toString(w));
		qs.quickSort(w, 0, w.length-1);
		System.out.println(Arrays.toString(w));
		System.out.println();
		
		System.out.println(Arrays.toString(u));
		qs.quickSort(u, 0, u.length-1);
		System.out.println(Arrays.toString(u));
		System.out.println();
		
	}
}
