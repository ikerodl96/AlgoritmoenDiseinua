import java.util.Arrays;


public class TxanponKopuruMinimoa {
	private int[][] MeE;
	
	public int txanponKopuruMinimoaIt(int[] balioa, int[] kopurua, int K){
		MeE=new int[K+1][balioa.length];
		
		int[] kop = new int[kopurua.length];
		for(int i=0; i<kopurua.length; i++){
			kop[i]=kopurua[i];
		}
		
		/* Metatze-egitura hasieratu kasu nabariekin */
		for(int n=0; n<MeE[0].length; n++){
			MeE[0][n]=0;
		}
		
		for(int k=1; k<MeE.length; k++){
			if(k % balioa[0]==0 && kop[0]>=(k/balioa[0])){
				MeE[k][0]= k / balioa[0];
				kop[0]=kop[0]-(k / balioa[0]);
			}else{
				MeE[k][0]=Integer.MAX_VALUE;
			}
		}
		
		/* Kasu orokorra */
		for(int k=1; k<MeE.length; k++){
			for(int n=1; n<MeE[0].length; n++){
				if(balioa[n]<=k && kop[n]>0){
					if(1+MeE[k-balioa[n]][n] < MeE[k][n-1]){
						kop[n]--;
						MeE[k][n]=1+MeE[k-balioa[n]][n];
					}else{
						MeE[k][n]=MeE[k][n-1];
					}
				}else{
					MeE[k][n]=MeE[k][n-1];
				}
			}
		}
		System.out.println(Arrays.toString(kop));
		return MeE[MeE.length-1][MeE[0].length-1];
	}
	
	public int txanponKopuruMinimoaErrek(int[] balioa, int K){
		MeE=new int[K+1][balioa.length];
		
		/* Metatze-egitura hasieratu kasu nabariekin */
		for(int n=0; n<MeE[0].length; n++){
			MeE[0][n]=0;
		}
		for(int k=1; k<MeE.length; k++){
			if(k % balioa[0]==0){
				MeE[k][0]= k / balioa[0];
			}else{
				MeE[k][0]=Integer.MAX_VALUE;
			}
		}
		/* Besteak -1 */
		for(int k=1; k<MeE.length; k++){
			for(int n=1; n<MeE[0].length; n++){
				MeE[k][n]=-1;
			}
		}
		if(MeE[MeE.length-1][MeE[0].length-1]==-1){
			bete(MeE.length-1, MeE[0].length-1, balioa);
		}
		return MeE[MeE.length-1][MeE[0].length-1];
	}

	private void bete(int k, int n, int[] balioa) {
		if(MeE[k][n-1]==-1){
			bete(k,n-1,balioa);
		}
		MeE[k][n]=MeE[k][n-1];
		if(balioa[n]<=k){
			if(MeE[k-balioa[n]][n]==-1) bete(k-balioa[n], n, balioa);
			MeE[k][n]=Math.min(1+MeE[k-balioa[n]][n], MeE[k][n-1]);
		}
	}
}
