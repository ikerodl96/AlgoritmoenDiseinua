import java.util.Arrays;


public class Main {
	/**
	 * Programa principal
	 */
	public static void main(String[] args) {
		/* Froga sinple batzuk */
		KSelekzioa ks = new KSelekzioa();
		int [] v = {83,26,9,23,30,14,55,9,40,5};
		
		System.out.println(Arrays.toString(v));
		
		System.out.println("1.haundiena: "+ks.kSelekzioa(v, 0, v.length-1, 1));
		System.out.println();
		
		System.out.println("2.haundiena: "+ks.kSelekzioa(v, 0, v.length-1, 2));
		System.out.println();
		
		System.out.println("3.haundiena: "+ks.kSelekzioa(v, 0, v.length-1, 3));
		System.out.println();
		
		System.out.println("4.haundiena: "+ks.kSelekzioa(v, 0, v.length-1, 4));
		System.out.println();
		
		System.out.println("5.haundiena: "+ks.kSelekzioa(v, 0, v.length-1, 5));
		System.out.println();
		
		System.out.println("6.haundiena: "+ks.kSelekzioa(v, 0, v.length-1, 6));
		System.out.println();
		
		System.out.println("7.haundiena: "+ks.kSelekzioa(v, 0, v.length-1, 7));
		System.out.println();
		
		System.out.println("8.haundiena: "+ks.kSelekzioa(v, 0, v.length-1, 8));
		System.out.println();
		
		System.out.println("9.haudiena: "+ks.kSelekzioa(v, 0, v.length-1, 9));
		System.out.println();
		
		System.out.println("10.haudiena: "+ks.kSelekzioa(v, 0, v.length-1, 10));
		System.out.println();
		
	}
}
