
public class TxanponKonbinazioak_iN {
	private int L;
	 private int[] balioak;
	 private int n;
	 
	public TxanponKonbinazioak_iN(int l, int[] balioak) {
		L = l;
		this.balioak = balioak;
		n = balioak.length;
	}
	 
	public void txanponKonbinazioak(int SPB, int t, int[] Konbi){
		if(L-SPB==0){
			Konbi[0]=Konbi[0]+1;
		}else if(t==n-1){
			if((L-SPB) % balioak[t]==0){ /* Deskonposagarria */
				Konbi[0]=Konbi[0]+1;
			}
		}else{
			int minimoa = geratzenDirenetikMinimoaLortu(t);
			if((L-SPB) >= minimoa){
				for(int i=t; i<=n-1; i++){
					txanponKonbinazioak(SPB+balioak[i], i, Konbi);
				}
			}
		}
	}

	private int geratzenDirenetikMinimoaLortu(int t) {
		int min=balioak[t];
		for(int i=t; i<balioak.length; i++){
			if(balioak[i]<min){
				min=balioak[i];
			}
		}
		return min;
	}
}
