
public class Frogak {
	public static void main (String[] args){
		final int INF = 1000;
		int[][] grafoa = {
							{0,5,INF,2,INF,INF},
							{INF,0,1,INF,INF,1},
							{INF,INF,0,INF,INF,INF},
							{INF,2,1,0,INF,5},
							{1,INF,4,INF,0,INF},
							{INF,INF,INF,1,INF,0}
			               };
		
		Dijkstra d = new Dijkstra();
		int[] distantziaMinimoak = d.dijkstraDistantziaMinimoak(grafoa);
		for(int i=0; i<distantziaMinimoak.length; i++){
			System.out.println("Erpina: " + i + " Distantzia: " + distantziaMinimoak[i]);
		}
	}
}
