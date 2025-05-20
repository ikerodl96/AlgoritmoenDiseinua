import java.util.Arrays;


public class MapaKoloreztatu {
	private boolean [][] grafoa;
	
	public MapaKoloreztatu(boolean [][] grafoa){
		this.grafoa = grafoa;
	}
	
	public void mapaKoloreztatu4Koloreekin(int herrialdea, int [] SP){
		if(herrialdea==grafoa.length){
			System.out.println("Koloreztatu daiteke");
			System.out.println(Arrays.toString(SP));
		}else{
			for(int kolorea=0; kolorea<4; kolorea++){
				if(onargarriaDa(kolorea, herrialdea, SP)){
					SP[herrialdea]=kolorea;
					mapaKoloreztatu4Koloreekin(herrialdea+1, SP);
				}
			}
		}
	}

	private boolean onargarriaDa(int kolorea, int herrialdea, int [] SP) {
		int i=0;
		boolean onargarria = true;
		while (i<herrialdea && onargarria){
			if(grafoa[herrialdea][i] && SP[i]==kolorea){
				onargarria = false;
			}
			i++;
		}
		return onargarria;
	}

}
