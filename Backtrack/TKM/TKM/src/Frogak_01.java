import java.util.Arrays;


public class Frogak_01 {

	public static void main(String[] args) {
		int[] balioak = {1,2,5,10,20,50};
		int L = 10;
		TKM_01 tkm = new TKM_01(L, balioak);
		int[] SP = new int[balioak.length];
		int[] SOPT = new int[balioak.length];
		int[] SOPTTK = {Integer.MAX_VALUE};
		tkm.txanponKopuruMinimoa(0, 0, SP, 0, SOPT, SOPTTK);
		System.out.println(SOPTTK[0]);
		System.out.println(Arrays.toString(SOPT));
	}

}
