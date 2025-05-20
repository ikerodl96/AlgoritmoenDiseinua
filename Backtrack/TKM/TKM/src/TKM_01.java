
public class TKM_01 {
	 private int L;
	 private int[] balioak;
	 private int n;
	 
	public TKM_01(int l, int[] balioak) {
		L = l;
		this.balioak = balioak;
		n = balioak.length;
	}
	 
	public void txanponKopuruMinimoa(int SPB, int SPTK, int[] SP, int t, int[] SOPT, int[] SOPTTK){
		if (L-SPB==0){
			if(SPTK<SOPTTK[0]){
				SOPTTK[0]=SPTK;
				for(int i=t; t<SP.length; t++) SP[i]=0;
				kopiatu(SP,SOPT);
			}
		}else if(t==n-1){
			if((L-SPB) % balioak[t]==0){ // deskonposagarria
				int zenbatT = (L-SPB) / balioak[t];
				if(zenbatT+SPTK<SOPTTK[0]){
					SP[t]=zenbatT;
					kopiatu(SP,SOPT);
					SOPTTK[0]=SPTK+zenbatT;
				}
			}
		}else{
			int minimoa = geratzenDirenetikMinimoaLortu(t);
			if(L-SPB >= minimoa){
				int zenbatTxanponGehienez = (L-SPB) / balioak[t];
				for(int zenbat=0; zenbat<=zenbatTxanponGehienez; zenbat++){
					if(SPTK+zenbat<SOPTTK[0]){
						SP[t]=zenbat;
						txanponKopuruMinimoa(SPB+(zenbat*balioak[t]), SPTK+zenbat, SP, t+1, SOPT, SOPTTK);
					}
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

	private void kopiatu(int[] SP, int[] SOPT) {
		for(int i=0; i<SP.length; i++){
			SOPT[i]=SP[i];
		}	
	}	
}
