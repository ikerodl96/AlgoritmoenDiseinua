/* Partiketa D.M.A. implementatzen duen Java klasea */
/* Klasean ikusitako hurbilketen artetik, hirugarren hurbilketa hautatu da implementazioa egiteko.
 * OHARRA: Egin dugun grafoen implementazioa dela eta, erpinek zero zenbakia izan dezakete ('identifikazio' moduan).
 * 			Horregatik, zuhaitzen sakonerak -1 zenbakitik hasiko dira (hau da, 0ko sakonera duen zuhaitzak, -1 izango du sakonera balio moduan). 
 * */
public class Partiketa {
	private int[] partiketa = null;
	
	/* Metodo Eraikitzailea */
	public Partiketa(int tamaina){
		partiketa =  new int[tamaina];
		for(int i=0; i<tamaina; i++){
			partiketa[i]=-1;
		}
	}
	
	/**
	 * 'elementua' zenbakia partaidea den multzoko etiketa itzultzen du metodo honek
	 * 
	 * @param elementua 'Bilatu' behar den elementua, bere multzoaren etiketa bueltatzeko
	 * @return Multzoaren etiketa
	 * [Klasean ikusitako implementazio berdina]
	 */
	public int bilatu3(int elementua){
		int aux = elementua;
		while(partiketa[aux]>=0){  /* >=0 izan behar du, gure implementazioan 0 zenbakia duten erpinak egon daitezkeelako */
			aux=partiketa[aux];
		}
		return aux;
	}
	
	/**
	 * Bi multzotako etiketak emanda (etiketak desberdinak izanik), bi multzoen bateraketa gauzatzen du metodo honek
	 * 
	 * @param e1 Multzo bateko etiketa
	 * @param e2 Multzo bateko etiketa
	 * [Klasean ikusitako implementazio berdina]
	 */
	public void bateratu3(int e1, int e2){
		if(partiketa[e1]==partiketa[e2]){ /* Sakonera berdineko zuhaitzak (s1==s2) */
			partiketa[e1]=partiketa[e1]-1;
			partiketa[e2]=e1;
		}else if(partiketa[e1]<partiketa[e2]){ /* sakonera(s2)>sakonera(s1) --> Sakonera berria (batu ondoren): s2 */
			partiketa[e2]=e1;
		}else{ /* sakonera(s2)<sakonera(s1) --> Sakonera berria (batu ondoren): s1 */
			partiketa[e1]=e2;
		}
	}
}
