import java.util.LinkedList;


public class Frogak {
	public static void main (String[] args){
		LinkedList<Ertza> HZMErtzak = new LinkedList<Ertza>();
		LinkedList<Ertza> ertzak = new LinkedList<Ertza>();
		Ertza e1 = new Ertza(0,1,4); ertzak.add(e1);
		Ertza e2 = new Ertza(0,7,9); ertzak.add(e2);
		Ertza e3 = new Ertza(1,2,9); ertzak.add(e3);
		Ertza e4 = new Ertza(1,7,11); ertzak.add(e4);
		Ertza e5 = new Ertza(2,3,7); ertzak.add(e5);
		Ertza e6 = new Ertza(2,5,4); ertzak.add(e6);
		Ertza e7 = new Ertza(2,8,2); ertzak.add(e7);
		Ertza e8 = new Ertza(3,4,10); ertzak.add(e8);
		Ertza e9 = new Ertza(3,5,15); ertzak.add(e9);
		Ertza e10 = new Ertza(4,5,11); ertzak.add(e10);
		Ertza e11 = new Ertza(5,6,2); ertzak.add(e11);
		Ertza e12 = new Ertza(6,7,1); ertzak.add(e12);
		Ertza e13= new Ertza(6,8,6); ertzak.add(e13);
		Ertza e14= new Ertza(7,8,7); ertzak.add(e14);
		
		GrafoEzZuzendua gez = new GrafoEzZuzendua();
		double pisua = gez.HZMKruskal(ertzak,HZMErtzak,9);
		System.out.println("Pisua: "+ pisua);
		for(Ertza e:HZMErtzak){
			System.out.println(e.getJatorriErpinZenbakia()+" "+e.getHelmugaErpinZenbakia()+" "+e.getPisua());
		}
	}
}
