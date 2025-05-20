import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class MotxilaZatika {

	public double motxilaBeteZatiekin(LinkedList<Objektua> objektuak, double pisuMax, LinkedList<Objektua> emaitza){
		emaitza.clear();
		double balioMax = 0;
		LinkedList<Objektua> objKopia = (LinkedList<Objektua>) objektuak.clone();
		proportzioakKalkulatu(objKopia);
		Collections.sort(objKopia, new Comparator<Objektua>() {
			public int compare(Objektua o1, Objektua o2) {
				if(o1.getProportzioa()>o2.getProportzioa()){
					return -1;
				}else if(o1.getProportzioa()==o2.getProportzioa()){
					return 0;
				}else{
					return 1;
				}
			}
		}); /* Ordenaziorako MergeSort erabiltzen da */
		double geratzenDenPisua = pisuMax;
		while (geratzenDenPisua>0 && !objKopia.isEmpty()){
			Objektua obj = objKopia.removeFirst();
			if(obj.getPisua()<=geratzenDenPisua){
				obj.setZenbatEraman(1);
				geratzenDenPisua = geratzenDenPisua - obj.getPisua();
				balioMax =  balioMax + obj.getBalioa();
			}else{
				obj.setZenbatEraman(geratzenDenPisua/obj.getPisua());
				balioMax =  balioMax + (obj.getProportzioa()*geratzenDenPisua);
				geratzenDenPisua = 0;
			}
			emaitza.add(obj);
		}
		return balioMax;
	}

	private void proportzioakKalkulatu(LinkedList<Objektua> objektuak) {
		for(Objektua obj : objektuak){
			obj.setProportzioa(obj.getBalioa()/obj.getPisua());
		}
	}
}
