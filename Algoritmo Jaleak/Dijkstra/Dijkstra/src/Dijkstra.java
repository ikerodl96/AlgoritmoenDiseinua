
public class Dijkstra {
	
	private final int INF = 100;
	
	public int[] dijkstraDistantziaMinimoak(int[][] grafoa){
		int[] disTaula = new int[grafoa.length];
		boolean[] hautagaiak = new boolean [grafoa.length];
		disTaula[0]=0;
		hautagaiak[0]=false;
		/* 0 erpinetik hasten da (abiapuntua 0 da) */
		for(int i=1; i<grafoa.length; i++){
			disTaula[i]=grafoa[0][i];
			hautagaiak[i]=true;
		}
		for(int k=1; k<grafoa.length-2; k++){
			int min = INF;
			int gertuenDagoenErpina = 0;
			/* Gertuen dagoen erpina atera */
			for(int i=1; i<grafoa.length; i++){
				if(hautagaiak[i] && disTaula[i]<min){
					min = disTaula[i];
					gertuenDagoenErpina = i;
				}
			}
			/* Hautagaietatik kendu */
			hautagaiak[gertuenDagoenErpina]=false;
			/* Distantziak hobe daitezke? */
			for(int i=1; i<grafoa.length; i++){
				if(hautagaiak[i] && disTaula[gertuenDagoenErpina]+grafoa[gertuenDagoenErpina][i]<disTaula[i]){
					disTaula[i]=disTaula[gertuenDagoenErpina]+grafoa[gertuenDagoenErpina][i];
				}
			}
		}
		return disTaula;
	}
}
