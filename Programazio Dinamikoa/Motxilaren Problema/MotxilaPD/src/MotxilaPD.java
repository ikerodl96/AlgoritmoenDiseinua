
public class MotxilaPD {

	public static int motxilaPDErrek(int pisuMax, int[] balioa, int[] pisua){
		int[][] MeE = new int[pisuMax+1][pisua.length+1];
		/* Hasieratu */
		for(int i=0; i<MeE.length; i++){
			for(int j=0; j<MeE[0].length; j++){
				MeE[i][j]=-1;
			}
		}
		/* Kasu nabariak */
		for(int k=0; k<MeE[0].length; k++) MeE[0][k]=0;
		for(int e=1; e<MeE.length; e++) MeE[e][0]=0;
		/* Kasu orokorra: Soluzioaren gelaxka begiratu */
		if (MeE[MeE.length-1][MeE[0].length-1]==-1) bete(MeE, balioa, pisua, MeE.length-1, MeE[0].length-1);
		return MeE[MeE.length-1][MeE[0].length-1];
	}

	private static void bete(int[][] MeE, int[] balioa, int[] pisua, int E, int K) {
		if (MeE[E][K-1]==-1) bete(MeE, balioa, pisua, E, K-1);
		if(pisua[K-1]<=E && K>=1){
			if (MeE[E-pisua[K-1]][K-1]==-1) bete(MeE, balioa, pisua, E-pisua[K-1], K-1);
			MeE[E][K]=Math.max(balioa[K-1]+ MeE[E-pisua[K-1]][K-1], MeE[E][K-1]);
		}else{
			MeE[E][K]=MeE[E][K-1];
		}
	}
	
	public static int motxilaPDIter(int pisuMax, int[] balioa, int[] pisua){
		int[][] MeE = new int[pisuMax+1][pisua.length+1];
		/* Hasieratu */
		for(int i=0; i<MeE.length; i++){
			for(int j=0; j<MeE[0].length; j++){
				MeE[i][j]=0;
			}
		}
		/* Kasu nabariak */
		for(int k=0; k<MeE[0].length; k++) MeE[0][k]=0;
		for(int e=1; e<MeE.length; e++) MeE[e][0]=0;
		/* Kasu orokorra */
		for(int K=1; K<MeE[0].length; K++){
			for(int E=1; E<MeE.length; E++){
				if (E>=pisua[K-1]){
					MeE[E][K]= Math.max(balioa[K-1]+MeE[E-pisua[K-1]][K-1], MeE[E][K-1]);
				}else{
					MeE[E][K]= MeE[E][K-1];
				}
			}
		}
		return MeE[MeE.length-1][MeE[0].length-1];
	}
	
	public static int motxilaPDIterErrek(int pisuMax, int[] balioa, int[] pisua, int[] elem){
		int[][] MeE = new int[pisuMax+1][pisua.length+1];
		int[][] MeErrek = new int[pisuMax+1][pisua.length+1];
		/* Hasieratu */
		for(int i=0; i<elem.length; i++) elem[i]=0;
		for(int i=0; i<MeE.length; i++){
			for(int j=0; j<MeE[0].length; j++){
				MeE[i][j]=0; MeErrek[i][j]=0;
			}
		}
		/* Kasu nabariak */
		for(int k=0; k<MeE[0].length; k++) MeE[0][k]=0;
		for(int e=1; e<MeE.length; e++) MeE[e][0]=0;
		/* Kasu orokorra */
		for(int K=1; K<MeE[0].length; K++){
			for(int E=1; E<MeE.length; E++){
				MeE[E][K]= MeE[E][K-1];
				if (E>=pisua[K-1] && balioa[K-1]+MeE[E-pisua[K-1]][K-1]>MeE[E][K-1]){
					MeE[E][K]= balioa[K-1]+MeE[E-pisua[K-1]][K-1];
					MeErrek[E][K]=1;
				}
			}
		}
		int E = pisuMax;
		for(int K=MeE[0].length-1; K>=1; K--){
			elem[K-1]=MeErrek[E][K];
			if(elem[K-1]==1){
				E=E-pisua[K-1];
			}
		}
		return MeE[MeE.length-1][MeE[0].length-1];
	}
	
	public static void main(String[] args){
		int[] pisua = {6,3,4,2};
		int[] balioa = {30,14,16,9};
		int[] emaitza = new int[balioa.length];
		System.out.println(motxilaPDIterErrek(10, balioa, pisua, emaitza));
		for(int i=0; i<emaitza.length; i++){
			System.out.println("Objektua "+ i+": "+ emaitza[i]);
		}
	}
	
}
