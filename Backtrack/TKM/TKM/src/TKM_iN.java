import java.util.LinkedList;


public class TKM_iN {
	private int L;
	 private int[] balioak;
	 private int n;
	 
	public TKM_iN(int l, int[] balioak) {
		L = l;
		this.balioak = balioak;
		n = balioak.length;
	}
	 
	public void txanponKopuruMinimoa(int SPB, int SPTK, LinkedList<Integer> SP, int t, LinkedList<Integer> SOPT, int[] SOPTTK){
		if (L-SPB==0){
			if(SPTK<SOPTTK[0]){
				SOPTTK[0]=SPTK;
				kopiatu(SP,SOPT);
			}
		}else if(t==n-1){
			if((L-SPB) % balioak[t]==0){
				int zenbatT = (L-SPB) / balioak[t];
				if(SPTK + zenbatT < SOPTTK[0]){
					SOPTTK[0] = SPTK + zenbatT;
					for(int i=1; i<=zenbatT; i++) SP.add(balioak[t]);
					kopiatu(SP,SOPT);
				}
			}
		}else{
			for(int j=t; j<balioak.length; j++){
				int minimoa = geratzenDirenetikMinimoaLortu(t);
				if(L-SPB >= minimoa){
					if(SPTK+1<SOPTTK[0] && SPB+balioak[j]<=L){
						SP.addFirst(balioak[j]);
						txanponKopuruMinimoa(SPB+balioak[j], SPTK+1, SP, j, SOPT, SOPTTK);
						SP.removeFirst();
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

	private void kopiatu(LinkedList<Integer> SP, LinkedList<Integer> SOPT) {
		SOPT.clear();
		for(Integer i: SP){
			SOPT.add(i);
		}	
	}	
}
