import java.util.Arrays;
import java.util.LinkedList;


public class Frogak {

//	public static void main(String[] args) {
//		int [] pisuak = {6,3,4,2};
//		int [] balioak = {30,14,16,9};
//		int n = pisuak.length;
//		int E = 10;
//		int outB = 0;
//		for(int i=0; i<balioak.length; i++) outB = outB+balioak[i];
//		
//		Motxila0_1 m = new Motxila0_1(pisuak, balioak, n, E);
//		
//		int [] SP = new int[n];
//		int [] SOPT = new int[n];
//		int [] SOPTB = {0};
////		m.motxilaBt01K1(0, 0, SP, 0, SOPTB, SOPT);
//		m.motxilaBt01K2(0, 0, SP, 0, SOPTB, SOPT, outB);
//		System.out.println(SOPTB[0]);
//		System.out.println(Arrays.toString(SOPT));
//	}

	
	public static void main(String[] args) {
		int [] pisuak = {6,3,4,2};
		int [] balioak = {30,14,16,9};
		int n = pisuak.length;
		int E = 10;
		int [] outB = new int[n];
		outB[n-1]=balioak[n-1];
		for(int i=n-2; i>=0; i--){
			outB[i]=outB[i+1]+balioak[i];
		}
		
		Motxila0_1 m = new Motxila0_1(pisuak, balioak, n, E);
		
		LinkedList<Integer> SP = new LinkedList<Integer>();
		LinkedList<Integer> SOPT = new LinkedList<Integer>();
		int [] SOPTB = {0};
		m.motxilaBtiNK2(0, 0, SP, 0, SOPT, SOPTB, outB);
		System.out.println(SOPTB[0]);
		System.out.println(SOPT.toString());
	}
}
