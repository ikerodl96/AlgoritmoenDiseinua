import java.util.LinkedList;


public class Frogak {
	public static void main (String[] args){
		LinkedList<Ertza> HZMErtzak = new LinkedList<Ertza>();
		int[][] grafoa = {{0, 2, Integer.MAX_VALUE, 6, Integer.MAX_VALUE},
			                {2, 0, 3, 8, 5},
			                {Integer.MAX_VALUE, 3, 0, Integer.MAX_VALUE, 7},
			                {6, 8, Integer.MAX_VALUE, 0, 9},
			                {Integer.MAX_VALUE, 5, 7, 9, 0},
			               };
		
		HZMPrim hzmp = new HZMPrim();
		double pisua = hzmp.HZMPrim(grafoa,HZMErtzak);
		System.out.println("Pisua: "+ pisua);
		for(Ertza e:HZMErtzak){
			System.out.println(e.getJatorriErpinZenbakia()+" "+e.getHelmugaErpinZenbakia()+" "+e.getPisua());
		}
	}
}
