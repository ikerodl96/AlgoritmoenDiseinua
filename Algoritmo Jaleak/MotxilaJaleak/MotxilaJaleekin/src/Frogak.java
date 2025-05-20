import java.util.LinkedList;

public class Frogak {

	public static void main(String[] args) {
		LinkedList<Objektua> objektuak = new LinkedList<Objektua>();
		objektuak.add(new Objektua(10, 60));
		objektuak.add(new Objektua(20, 100));
		objektuak.add(new Objektua(30, 120));
		LinkedList<Objektua> emaitza = new LinkedList<Objektua>();
		MotxilaZatika mz = new MotxilaZatika();
		System.out.println(mz.motxilaBeteZatiekin(objektuak, 50, emaitza));
		System.out.println(emaitza.toString());
	}

}
