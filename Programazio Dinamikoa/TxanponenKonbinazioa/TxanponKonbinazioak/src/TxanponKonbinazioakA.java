
public class TxanponKonbinazioakA {
	
	public static int txanponKonbinazioakErrek(int L, int[] txanponak){
		int[][] MeE = new int[L+1][txanponak.length];
		/* Hasieraketa */
		for(int l=0; l<MeE.length; l++){
			for(int I=0; I<MeE[0].length; I++){
				MeE[l][I]=-1;
			}
		}
		/* Kasu nabariak */
		for(int I=0; I<MeE[0].length; I++) MeE[0][I]=1;
		for(int l=1; l<MeE.length; l++){
			if ((l % txanponak[0]) == 0){
				MeE[l][0] = 1;
			}else{
				MeE[l][0] = 0;
			}
		}
		if(MeE[MeE.length-1][MeE[0].length-1]==-1) bete(txanponak, MeE, MeE.length-1, MeE[0].length-1);
		for(int I=0; I<MeE[0].length; I++){
			for(int l=0; l<MeE.length; l++){
				System.out.print(MeE[l][I]+" ");
			}
			System.out.println();
		}
		return MeE[MeE.length-1][MeE[0].length-1];
	}

	private static void bete(int[] txanponak, int[][] MeE, int L, int I){
		if(MeE[L][I-1]==-1) bete(txanponak, MeE, L, I-1);
		if(txanponak[I]<=L){
			if(MeE[L-txanponak[I]][I]==-1) bete(txanponak, MeE, L-txanponak[I], I);
			MeE[L][I]= MeE[L][I-1] + MeE[L-txanponak[I]][I];
		}else{
			MeE[L][I]=MeE[L][I-1];
		}
	}
	
	public static int txanponKonbinazioakIter(int L, int[] txanponak){
		int[][] MeE = new int[L+1][txanponak.length];
		for(int I=0; I<MeE[0].length; I++) MeE[0][I]=1;
		for(int l=1; l<MeE.length; l++){
			if(l % txanponak[0] == 0){
				MeE[l][0]=1;
			}else{
				MeE[l][0]=0;
			}
		}
		for(int l=1; l<MeE.length; l++){
			for(int i=1; i<MeE[0].length; i++){
				if(txanponak[i]<=l){
					MeE[l][i]=MeE[l][i-1]+MeE[l-txanponak[i]][i-1];
				}else{
					MeE[l][i]=MeE[l][i-1];
				}
			}
		}
		for(int I=0; I<MeE[0].length; I++){
			for(int l=0; l<MeE.length; l++){
				System.out.print(MeE[l][I]+" ");
			}
			System.out.println();
		}
		return MeE[MeE.length-1][MeE[0].length-1];
	}

	public static void main (String[] args){
		int[] txanponak = {2,5,10};
		int L = 21;
		System.out.println(txanponKonbinazioakErrek(L, txanponak));
	}
}
