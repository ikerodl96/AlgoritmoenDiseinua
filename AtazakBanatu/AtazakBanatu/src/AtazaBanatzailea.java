import java.util.Arrays;


public class AtazaBanatzailea {
	private int [][] kostuak;
	public void atazakBanatu(int [][] kostuak){
		this.kostuak=kostuak;
		int[] SP = new int[kostuak.length];
		int[] SOPT = new int[kostuak.length];
		int[] SOPTK = {100000}; /* INF */
		boolean[] agente = new boolean[kostuak.length];
		for(int i=0; i<agente.length; i++){
			agente[i]=true;
		}
		backtracking(0, SP, 0, SOPT, SOPTK, agente);
		System.out.println(SOPTK[0]);
		System.out.println(Arrays.toString(SOPT));
	}

	private void backtracking(int SPK, int[] SP, int ataza, int[] SOPT, int[] SOPTK, boolean[] agenteEgoera){
		if(ataza == kostuak.length){
			if(SPK<SOPTK[0]){
				SOPTK[0]=SPK;
				kopiatu(SP,SOPT);
			}
		}else{
			for(int ag=0; ag<kostuak.length; ag++){
				if(agenteEgoera[ag] && SPK+kostuak[ataza][ag]<SOPTK[0]){
					SP[ataza]=ag;
					agenteEgoera[ag]=false;
					backtracking(SPK+kostuak[ataza][ag], SP, ataza+1, SOPT, SOPTK, agenteEgoera);
					agenteEgoera[ag]=true;
				}
			}
		}
	}

	private void kopiatu(int[] SP, int[] SOPT) {
		for (int i = 0; i < SOPT.length; i++) {
			SOPT[i]=SP[i];
		}
	}

}
