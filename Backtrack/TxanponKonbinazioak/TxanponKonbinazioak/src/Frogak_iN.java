
public class Frogak_iN {

	public static void main(String[] args) {
		int[] balioak = {2,5,10};
		int L = 10;
		TxanponKonbinazioak_iN tkm = new TxanponKonbinazioak_iN(L, balioak);
		int[] KonbinazioKop = {0};
		tkm.txanponKonbinazioak(0,0,KonbinazioKop);
		System.out.println(KonbinazioKop[0]);
	}

}
