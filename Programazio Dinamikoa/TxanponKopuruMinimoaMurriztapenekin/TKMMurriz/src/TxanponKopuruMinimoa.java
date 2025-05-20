import java.util.Arrays;


public class TxanponKopuruMinimoa {
	private int[][] MeE;
	private int[][] MeErrek;
	private static int INF = 100000;
	
	public int txanponKopuruMinimoaIt(int[] balioa, int[] kopurua, int K){
		MeE=new int[K+1][balioa.length];
		MeErrek=new int[K+1][balioa.length];
		
		/* Metatze-egitura hasieratu kasu nabariekin */
		for(int n=0; n<MeE[0].length; n++){
			MeE[0][n]=0;
		}
		
		for(int k=1; k<MeE.length; k++){
			if((k % balioa[0]==0) && (kopurua[0]>=(k/balioa[0]))){
				MeE[k][0]= k/balioa[0];
			}else{
				MeE[k][0]=INF;
			}
		}
		
		/* Kasu orokorra */
		for(int k=1; k<MeE.length; k++){
			for(int n=1; n<MeE[0].length; n++){
				int zenbat = Math.min(k/balioa[n],kopurua[n]);
				int minimoa = INF;
				int minP=0;
				for(int p=0; p<=zenbat; p++){
					if((p+MeE[k-(p*balioa[n])][n-1])<minimoa){
						minimoa=p+MeE[k-(p*balioa[n])][n-1];
						minP=p;
					}
				}
				MeErrek[k][n]=minP;
				MeE[k][n]=minimoa;
			}
		}
		
		
		/* Errekuperazioa */
		int[] txanponKop = new int[balioa.length];
		
		int kop = K;
		for(int tx=balioa.length-1; tx>=0; tx--){
			txanponKop[tx]=MeErrek[kop][tx];
			kop = kop - txanponKop[tx]*balioa[tx];
		}
		txanponKop[0]=kop/balioa[0];
		System.out.println(Arrays.toString(txanponKop));
		
		return MeE[MeE.length-1][MeE[0].length-1];
	}
}
