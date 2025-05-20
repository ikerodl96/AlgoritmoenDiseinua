import java.util.LinkedList;

public class Frogak_iN {

	public static void main(String[] args) {
		int[] balioak = {1,2,5,10,20,50};
		int L = 23;
		TKM_iN tkm = new TKM_iN(L, balioak);
		LinkedList<Integer> SP = new LinkedList<Integer>();
		LinkedList<Integer> SOPT = new LinkedList<Integer>();
		int[] SOPTTK = {Integer.MAX_VALUE};
		tkm.txanponKopuruMinimoa(0, 0, SP, 0, SOPT, SOPTTK);
		System.out.println(SOPTTK[0]);
		System.out.println(SOPT.toString());
	}

}
