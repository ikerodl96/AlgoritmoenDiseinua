import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class GrafoZuzendua {
	private Erpina [] auzokideZerrenda = null;
	
	/************************************************************
	 * 			    [1] METODO ERAIKITZAILEAK                   *
	 ************************************************************/
	
	/* (1) */
	/**
	 * Metodo honek grafo zuzendu ez pisudun bat eraikitzen du. Grafoa sortzeko, 'datuak' izeneko fitxategian dagoen 
	 * informazioaz baliatuko da.
	 * @param datuak Fitxategiaren izena, non eraiki nahi den grafoaren informazioa dagoen
	 * @return 0 itzultzen du grafoa zuzen eraiki baldin bada
	 * 		   -1 itzultzen du metodoak huts egiten badu (arazoa egon da grafoaren irakurketarekin, fitxategia ez da aurkitu...)
	 * 			Kasu honetan gertatutako arazoaren informazioa terminalean agertuko da.
	 */
	public int SortuGZ (String datuak){
		try {
			Scanner s = new Scanner(new File(datuak));
			int erpinKopurua = s.nextInt();
			auzokideZerrenda =  new Erpina [erpinKopurua];
			int arkuKopurua = s.nextInt();
			for(int i=0; i<erpinKopurua; i++){ /* Erpin guztiak sortu */ 
				auzokideZerrenda[i] =  new Erpina(i);
			}
			for(int i=0; i<arkuKopurua; i++){
				int nondik = s.nextInt();
				int nora = s.nextInt();
				s.nextLine(); /* Pisua ez dugu kontuan hartzen */
				Erpina nondikErpina = auzokideZerrenda[nondik];
				nondikErpina.arkuaGehitu(new Arkua(nora));
			}
			s.close();
			return 0;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return (-1);
		}
	}
	
	/* (3) */
	/**
	 * Metodo honek grafo zuzendu pisudun bat eraikitzen du. Grafoa sortzeko, 'datuak' izeneko fitxategian dagoen 
	 * informazioaz baliatuko da.
	 * @param datuak Fitxategiaren izena, non eraiki nahi den grafoaren informazioa dagoen
	 * @return 0 itzultzen du grafoa zuzen eraiki baldin bada
	 * 		   -1 itzultzen du metodoak huts egiten badu (arazoa egon da grafoaren irakurketarekin, fitxategia ez da aurkitu...)
	 * 			Kasu honetan gertatutako arazoaren informazioa terminalean agertuko da.
	 */
	public int SortuGZPisuduna (String datuak){
		try {
			Scanner s = new Scanner(new File(datuak));
			int erpinKopurua = s.nextInt();
			auzokideZerrenda =  new Erpina [erpinKopurua];
			int arkuKopurua = s.nextInt();
			for(int i=0; i<erpinKopurua; i++){ /* Erpin guztiak sortu */ 
				auzokideZerrenda[i] =  new Erpina(i);
			}
			for(int i=0; i<arkuKopurua; i++){
				int nondik = s.nextInt();
				int nora = s.nextInt();
				double pisua = s.nextDouble();
				Erpina nondikErpina = auzokideZerrenda[nondik];
				Arkua arkua = new Arkua(nora);
				arkua.setPisua(pisua);
				nondikErpina.arkuaGehitu(arkua);
			}
			s.close();
			return 0;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return (-1);
		}
	}
	
	/************************************************************
	 * 	         [2] ZIKLOA ETA ORDENAZIO TOPOLOGIKOA           *
	 ************************************************************/
	
	/* (5) */
	/**
	 * Metodo honek grafo zuzendu batean ziklorik dagoen ala ez erabakitzen du.
	 * Ideia:
	 * Implementazioan koloreen teknika erabili da:
	 *   Kolore zuria (0) : Erpina ez da aztertu
	 *   Kolore grisa (1) : Une honetan prozesatzen ari den erpina
	 *   Kolore beltza (2): Dagoeneko aztertuak izan diren erpinak (bere ondorengoak ere aztertuta egongo dira)
	 *   --> Erpinen prozesaketa gauzatzerakoan erpin gris batekin topo egiten badugu, grafoak zikloa izango du.
	 * @return true Grafo zuzenduak zikloa baldin badauka
	 * 		   false Grafo zuzenduak ziklorik ez badauka
	 */
	public boolean zikloaDuG(){
		boolean zikloa = false;
		for(Erpina erpina:auzokideZerrenda){
			erpina.setKolorea(0);
		}
		for(Erpina erpina:auzokideZerrenda){
			if(erpina.getKolorea()==0){ 
				zikloa=sk(erpina);
				if(zikloa) break;
			}
		}
		return zikloa;
	}
	
	private boolean sk(Erpina e){
		boolean zikloa = false;
		e.setKolorea(1); /* Kolore grisa: Une honetan aztertuko dugu 'e' erpina (eta bere auzokideak) */
		LinkedList<Arkua> arkuak = e.getArkuZerrenda();
		Iterator<Arkua> it = arkuak.iterator();
		while(it.hasNext() && !zikloa){
			Arkua arkua = it.next();
			Erpina auzokidea = auzokideZerrenda[arkua.getHelmugaErpinZenbakia()];
			if(auzokidea.getKolorea()==0){
				zikloa = sk(auzokidea);
			}else if(auzokidea.getKolorea()==1){ /* Beste erpin gris batekin topatu gara, erpin prozesaketaren "fase" berean --> Zikloa dago */
				zikloa = true;
			}
		}
		e.setKolorea(2); /* Kolore beltza: 'e' erpina guztiz aztertu dugu */
		return zikloa;
	}
	
	/* (6) */
	/**
	 * Metodo honek grafo zuzendu baten ordenazio topologikoa itzultzen digu.
	 * Ideia: 
	 * Sakonerako korritzea gauzatu eta erpin bakoitzaren tratamendua amaitzerakoan, 
	 * erpina zerrenda estekatu batean txertatu, buru bezala.
	 * @return Erpinen zerrenda (erpinen zenbakia gordetzen da soilik), ordenazio topologikoaren arabera ordenatua.
	 * 
	 */
	public LinkedList<Integer> ordenazioTopologikoa(){
		for (Erpina e: auzokideZerrenda){
			e.setAztertua(false);
		}
		LinkedList<Integer> zerrenda = new LinkedList<Integer>();
		for(Erpina e: auzokideZerrenda){
			if(!e.isAztertua()){
				sk(e, zerrenda);
			}
		}
		return zerrenda;
	}
	
	private void sk(Erpina e, LinkedList<Integer> zerrenda){
		e.setAztertua(true);
		LinkedList<Arkua> arkuak = e.getArkuZerrenda();
		Iterator<Arkua> it = arkuak.iterator();
		while(it.hasNext()){
			Arkua arkua = it.next();
			Erpina auzokidea=auzokideZerrenda[arkua.getHelmugaErpinZenbakia()];
			if(!auzokidea.isAztertua()){
				sk(auzokidea, zerrenda);
			}
		}
		/* Erpinaren prozesaketa amaitu da --> Zerrendan sartu buru bezala */
		zerrenda.addFirst(e.getErpinZenbakia());
	}
	
	
	/************************************************************
	 * 	         [3] SENDOKI KONEKTATUTAKO OSAGAIAK             *
	 ************************************************************/
	
	/* (9) */
	/**
	 * Metodo honek zerrenda bat itzultzen du, non elementu bakoitza sendoki konektaturik dagoen osagai bat adieraziz,
	 * haren erpin guztien zerrenda jasotzen duen. 
	 * Ideia:
	 *  1. Erpinen zerrenda eraiki ordenazio topologikoaren arabera ordenatuta dagoena. Horretarako grafoa sakonerako korritze batekin 
	 *     korritu behar da (ordenazio topologikoa implementatuta dagoenez, egin dugun prozedurari dei egingo diogu).
	 *  2. Grafoaren GTa kalkulatu ("alderantzizko" grafoa).
	 *  3. GTa SK bidez korritu erpinen ordena 1. pausoan lortutako zerrendakoa izanik
	 * @return Sendoki konektatutako osagaien zerrenda
	 */
	public LinkedList<LinkedList<Integer>> sendokiKonektatutakoOsagaiak(){
		LinkedList<LinkedList<Integer>> sendokiKonektatutakoOsagaiak = new LinkedList<LinkedList<Integer>>();
		/* Grafoko erpinak zerrenda batean 'sartu', ordenazio topologikoaren arabera (bere ordena jarraituz) */
		LinkedList<Integer> OTzerrenda = ordenazioTopologikoa();
		/* Alderantzizko grafoa (GT) kalkulatu */
		/* Auzokide zerrenda berri bat eraiki */
		Erpina[] auzokideZerrendaT = new Erpina[auzokideZerrenda.length];
		for(int i=0; i<auzokideZerrenda.length; i++){ /* Erpinak berriro sortu */
			auzokideZerrendaT[i] = new Erpina(i);
		}
		/* Arkuen tratamendua: grafoan (G) A-->B badugu, alderantzizko grafoan (GT) B-->A izango dugu */
		for(int i=0; i<auzokideZerrenda.length; i++){ 
			Erpina erpina = auzokideZerrenda[i];
			LinkedList<Arkua> arkuZerrenda = erpina.getArkuZerrenda();
			Iterator<Arkua> it = arkuZerrenda.iterator();
			while(it.hasNext()){
				Arkua arkua = it.next();
				Erpina erpinaT = auzokideZerrendaT[arkua.getHelmugaErpinZenbakia()];
				erpinaT.arkuaGehitu(new Arkua(i));
			}
		}
		/* Java klaseak erabiltzen duen auzokide zerrendaren aldaketa:
		 *  auzokideZerrenda (jatorrizko grafoa) aldagai batean gorde, ez galtzeko eta berreskuratu ahal izateko
		 *  auzokideZerrenda = auzokideZerrendaT;
		 */
		Erpina[] aux = auzokideZerrenda;
		auzokideZerrenda = auzokideZerrendaT;
		/* Alderantzizko grafoa (GT) korritu, 'OTzerrenda' zerrendako erpinen ordena jarraituz */
		for(Erpina e: auzokideZerrenda){
			e.setAztertua(false);
		}
		LinkedList<Integer> sendKonekOsagaiBat;
		while (!OTzerrenda.isEmpty()){
			int erpinZenbakia = OTzerrenda.removeFirst();
			Erpina erpina = auzokideZerrenda[erpinZenbakia];
			if(!erpina.isAztertua()){
				sendKonekOsagaiBat = new LinkedList<Integer>();
				sk(erpina,sendKonekOsagaiBat);
				sendokiKonektatutakoOsagaiak.add(sendKonekOsagaiBat);
			}
			
		}
		/* Auzokide zerrendaren aldaketa desegin: jatorrizko grafoa berreskuratu */
		auzokideZerrenda = aux;
		return sendokiKonektatutakoOsagaiak;
	}
	
}
