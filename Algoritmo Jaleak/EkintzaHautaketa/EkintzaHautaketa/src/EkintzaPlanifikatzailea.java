import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;


public class EkintzaPlanifikatzailea {
	
	public LinkedList<Ekintza> ekintzakHautatu(LinkedList<Ekintza> ekintzak){
		LinkedList<Ekintza> emaitza = new LinkedList<Ekintza>();
		LinkedList<Ekintza> ekintzenKopia = (LinkedList<Ekintza>) ekintzak.clone();
		/* Ordenatu: Lehenen amaitzen dutenak --> Mergesort erabiltzen da */
		Collections.sort(ekintzenKopia, new Comparator<Ekintza>() {
		    public int compare(Ekintza lhs, Ekintza rhs) {
		        if (lhs.getAmaieraOrdua().getTime() < rhs.getAmaieraOrdua().getTime())
		            return -1;
		        else if (lhs.getAmaieraOrdua().getTime() == rhs.getAmaieraOrdua().getTime())
		            return 0;
		        else
		            return 1;
		    }});
		
		/* Hautaketarekin hasi */
		Ekintza lehena = ekintzenKopia.removeFirst();
		emaitza.add(lehena);
		while(!ekintzenKopia.isEmpty()){
			Ekintza hautagaia = ekintzenKopia.removeFirst();
			if(hautagaia.getHasieraOrdua().getTime()>=lehena.getAmaieraOrdua().getTime()){
				lehena = hautagaia;
				emaitza.add(lehena);
			}
		}
		return emaitza;
	}
}
