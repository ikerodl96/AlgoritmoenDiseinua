
public class FloydWarshall {

	public int[][] floyd (int[][] grafoa){
		int[][] distantziak = new int[grafoa.length][grafoa[0].length];
		for(int i=0; i<grafoa.length; i++){
			for(int j=0; j<grafoa.length; j++){
				distantziak[i][j]=grafoa[i][j];
			}
		}
		
		for(int k=0; k<grafoa.length; k++){
			for(int i=0; i<grafoa.length; i++){
				for(int j=0; j<grafoa.length; j++){
					distantziak[i][j]=Math.min(distantziak[i][j], distantziak[i][k]+distantziak[k][j]);
				}
			}
		}
		
		return distantziak;
	}
}
