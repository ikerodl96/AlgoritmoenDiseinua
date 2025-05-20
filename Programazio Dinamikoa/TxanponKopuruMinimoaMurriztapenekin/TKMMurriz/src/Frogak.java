
public class Frogak {
	
	public static void main(String[] args) {
		int[] balioak = {1,2,5,10,20,50};
		int[] kopuruak = {5,5,5,10,1,1};
		TxanponKopuruMinimoa tkm = new TxanponKopuruMinimoa();
		System.out.println(tkm.txanponKopuruMinimoaIt(balioak,kopuruak,40));
	}

}
