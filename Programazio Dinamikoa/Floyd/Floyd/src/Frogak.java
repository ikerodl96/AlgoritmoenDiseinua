
public class Frogak {
	private static int INF = 1000;
	public static void main(String[] args) {
		FloydWarshall fw = new FloydWarshall();
		int[][] grafoa = {
				{0,5,INF,INF},
				{50,0,15,5},
				{30,INF,0,15},
				{15,INF,5,0}
		};
		int[][] emaitza = fw.floyd(grafoa);
		for(int i=0; i<grafoa.length; i++){
			for(int j=0; j<grafoa.length; j++){
				System.out.print(emaitza[i][j] + " ");
			}
			System.out.println();
		}
	}

}
