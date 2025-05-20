
public class TxanponKonbinazioak {
	
	public static int txanponKonbinazioak(int L, int[] txanponak){
		int[][] MeE = new int[L+1][txanponak.length+1];
		/* Hasieraketa */
		for(int l=0; l<MeE.length; l++){
			for(int I=1; I<MeE[0].length; I++){
				MeE[l][I]=-1;
			}
		}
		/* Kasu nabariak */
		for(int I=1; I<MeE[0].length; I++) MeE[0][I]=1;
		//for(int l=1; l<MeE.length; l++) MeE[l][0]=1;
		for(int l=1; l<MeE.length; l++){
			if (l % txanponak[0] == 0){
				MeE[l][1] = 1;
			}else{
				MeE[l][1] = 0;
			}
		}
		if(MeE[MeE.length-1][MeE[0].length-1]==-1) bete(txanponak, MeE, MeE.length-1, MeE[0].length-1);
		return MeE[MeE.length-1][MeE[0].length-1];
	}

	private static void bete(int[] txanponak, int[][] MeE, int L, int I){
		if(MeE[L][I-1]==-1) bete(txanponak, MeE, L, I-1);
		if(txanponak[I-1]<=L){
			if(MeE[L-txanponak[I-1]][I-1]==-1) bete(txanponak, MeE, L-txanponak[I-1], I-1);
			MeE[L][I]=MeE[L][I-1]+ MeE[L-txanponak[I-1]][I-1];
		}else{
			MeE[L][I]=MeE[L][I-1];
		}
	}

	public static void main (String[] args){
		int[] txanponak = {2,5,10};
		int L = 21;
		System.out.println(txanponKonbinazioak(L, txanponak));
	}
}
