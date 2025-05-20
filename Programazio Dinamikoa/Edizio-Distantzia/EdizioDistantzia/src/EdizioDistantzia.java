
public class EdizioDistantzia {
	/* Metatze-egitura */
	private int[][] MeE;
	/* Errekuperazioa */
	private int[][] MeEErrek;
	
	private String s1;
	private String s2;
	
	public int edizioDistantziaKalkulatu(String s1, String s2){
		this.s1=s1;
		this.s2=s2;
		MeE = new int[s1.length()+1][s2.length()+1];
		MeEErrek = new int[s1.length()+1][s2.length()+1];
		for(int i=0; i<MeE.length; i++){
			for(int j=0; j<MeE[0].length; j++){
				MeEErrek[i][j]=-1;
			}
		}
		
		/* Kasu nabariak bete */
		for(int j=0; j<MeE[0].length; j++){
			MeE[0][j]=j;
		}
		
		for(int i=0; i<MeE.length; i++){
			MeE[i][0]=i;
		}
		
		/* Kasu orokorra */
		for(int i=1; i<MeE.length; i++){
			for(int j=1; j<MeE[0].length; j++){
				MeE[i][j]=1+MeE[i-1][j];
				MeEErrek[i][j]=2;
				if(1+MeE[i][j-1]<MeE[i][j]){
					MeE[i][j]=1+MeE[i][j-1];
					MeEErrek[i][j]=3;
				}
				if(difer(i,j)+MeE[i-1][j-1]<MeE[i][j]){
					MeE[i][j]=difer(i,j)+MeE[i-1][j-1];
					MeEErrek[i][j]=difer(i,j);
				}
			}
		}
		
		int S1 = s1.length();
		int S2 = s2.length();
		while (S1>0 && S2>0){
			if(MeEErrek[S1][S2]==1){
				System.out.println("BI");
				S1--;
				S2--;
			}else if(MeEErrek[S1][S2]==2){
				System.out.println("K");
				S1--;
			}else if(MeEErrek[S1][S2]==3){
				System.out.println("G");
				S2--;
			}else{
				System.out.println("BE");
				S1--;
				S2--;
			}
		}
		for(int i=0; i<MeE.length; i++){
			for(int j=0; j<MeE[0].length; j++){
				System.out.print(MeEErrek[i][j]+" ");
			}
			System.out.println();
		}
		/*
		int[] errekSol = new int[s2.length()];
		int E = s1.length();
		for(int i=s2.length(); i>0; i--){
			errekSol[i-1]=MeEErrek[E][i];
			if(errekSol[i-1]==1){
				
			}else if(errekSol[i-1]==2){
				
			}else if(errekSol[i-1]==3){
				
			}else{ 
				
			}
		}
		*/
		return MeE[MeE.length-1][MeE[0].length-1];
	}

	private int difer(int i, int j) {
		char c1 = s1.charAt(i-1);
		char c2 = s2.charAt(j-1);
		if (c1==c2){
			return 0;
		}else{
			return 1;
		}
	}

}
