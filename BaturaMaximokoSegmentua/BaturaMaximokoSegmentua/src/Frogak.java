
public class Frogak {

	public static void main(String[] args) {
		BaturaMaximokoSegmentua bm = new BaturaMaximokoSegmentua();
		HiruZenbaki emaitza = new HiruZenbaki();
		int [] v = {8,12,-13,0,11,5,-6,2,3};
		int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
		emaitza = bm.baturaMaximokoSegmentua(a, 0, a.length-1);
		System.out.println("Segmentuaren hasiera: " + emaitza.hasiera);
		System.out.println("Segmentuaren amaiera: " + emaitza.amaiera);
		System.out.println("Batuketaren balioa: " + emaitza.batuketa);
	}

}
