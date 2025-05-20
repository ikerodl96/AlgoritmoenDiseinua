import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;


public class GrafoEzZuzendua {
//	private Erpina[] auzokideZerrenda;
//	
//	public GrafoEzZuzendua(int erpinKop, LinkedList<Ertza> ertzak){
//		auzokideZerrenda= new Erpina[erpinKop];
//		for(int i=0; i<erpinKop; i++){
//			auzokideZerrenda[i]= new Erpina(i);
//		}
//		Iterator<Ertza> it = ertzak.iterator();
//		while (it.hasNext()){
//			Ertza e = it.next();
//			int e1znbk = e.getJatorriErpinZenbakia();
//			int e2znbk = e.getHelmugaErpinZenbakia();
//			Erpina e1 = auzokideZerrenda[e1znbk];
//			Erpina e2 = auzokideZerrenda[e2znbk];
//			e1.ertzaGehitu(e);
//			e2.ertzaGehitu(e);
//		}
//	}
	
	public double HZMKruskal(LinkedList<Ertza> ertzZerrenda, LinkedList<Ertza> HZMErtzak, int erpinKop){
		Collections.sort(ertzZerrenda, new Comparator<Ertza>(){ /* Mergesort erabiltzen da */
			public int compare(Ertza a1, Ertza a2) {
				if(a1.getPisua()<a2.getPisua()){
					return -1;
				}else{
					return 1;
				}
			}
		});
		int ertzKop=0;
		double pisuenBatura=0;
		Partiketa partiketa = new Partiketa(erpinKop);
		while (ertzKop!=erpinKop-1){
			Ertza ertza = ertzZerrenda.removeFirst();
			int erpin1 = ertza.getHelmugaErpinZenbakia();
			int erpin2 = ertza.getJatorriErpinZenbakia();
			int etiketa1 = partiketa.bilatu3(erpin1);
			int etiketa2 = partiketa.bilatu3(erpin2);
			if (etiketa1!=etiketa2){ /* Zikloa ez da osatzen */
				partiketa.bateratu3(etiketa1, etiketa2);
				HZMErtzak.add(ertza);
				pisuenBatura = pisuenBatura + ertza.getPisua();
				ertzKop++;
			}
		}
		return pisuenBatura;
	}
}
