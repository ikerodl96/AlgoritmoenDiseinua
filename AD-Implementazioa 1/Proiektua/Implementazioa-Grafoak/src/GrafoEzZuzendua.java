import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class GrafoEzZuzendua {
	private Erpina [] auzokideZerrenda = null;
	
	/************************************************************
	 * 				[1] METODO ERAIKITZAILEAK                   *
	 ************************************************************/
	
	/* (2) */
	/**
	 * Metodo honek grafo ez zuzendu ez pisudun bat eraikitzen du. Grafoa sortzeko, 'datuak' izeneko fitxategian dagoen 
	 * informazioaz baliatuko da.
	 * @param datuak Fitxategiaren izena, non eraiki nahi den grafoaren informazioa dagoen
	 * @return 0 itzultzen du grafoa zuzen eraiki baldin bada
	 * 		   -1 itzultzen du metodoak huts egiten badu (arazoa egon da grafoaren irakurketarekin, fitxategia ez da aurkitu...)
	 * 			Kasu honetan gertatutako arazoaren informazioa terminalean agertuko da.
	 */
	public int SortuGEzZ (String datuak){
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
				/* A-->B irakurtzen badugu, B-->A ere jarri behar dugu grafoan */
				/* Egin dugun implementazioaren arabera: Ertz bat = 2 arku */
				Erpina nondikErpina = auzokideZerrenda[nondik]; 
				nondikErpina.arkuaGehitu(new Arkua(nora));
				Erpina noraErpina = auzokideZerrenda[nora];
				noraErpina.arkuaGehitu(new Arkua(nondik));
			}
			s.close();
			return 0;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return (-1);
		}
	}
	
	/* (4) */
	/**
	 * Metodo honek grafo ez zuzendu pisudun bat eraikitzen du. Grafoa sortzeko, 'datuak' izeneko fitxategian dagoen 
	 * informazioaz baliatuko da.
	 * @param datuak Fitxategiaren izena, non eraiki nahi den grafoaren informazioa dagoen
	 * @return 0 itzultzen du grafoa zuzen eraiki baldin bada
	 * 		   -1 itzultzen du metodoak huts egiten badu (arazoa egon da grafoaren irakurketarekin, fitxategia ez da aurkitu...)
	 * 			Kasu honetan gertatutako arazoaren informazioa terminalean agertuko da.
	 */
	public int SortuGEzZPisuduna (String datuak){
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
				/* A-->B irakurtzen badugu, B-->A ere jarri behar dugu grafoan */
				/* Egin dugun implementazioaren arabera: Ertz bat = 2 arku */
				Erpina nondikErpina = auzokideZerrenda[nondik];
				Arkua arkua1 = new Arkua(nora);
				arkua1.setPisua(pisua);
				nondikErpina.arkuaGehitu(arkua1);
				Erpina noraErpina = auzokideZerrenda[nora];
				Arkua arkua2 = new Arkua(nondik);
				arkua2.setPisua(pisua);
				noraErpina.arkuaGehitu(arkua2);
			}
			s.close();
			return 0;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return (-1);
		}
	}
	
	/************************************************************
	 * 		       [2] ZIKLOAK ETA OSAGAI KONEXUAK              *
	 ************************************************************/
	
	/* (7) */
	/**
	 * Metodo honek grafo ez zuzendu batean ziklorik dagoen ala ez erabakitzen du.
	 * Ideia:
	 * Sakonerako korritzea gauzatu. Erpin bat prozesatzerakoan (demagun e), bere auzokideak aztertu behar ditugu. 
	 * Aztertua izan den auzokide bat harrapatzen badugu e erpinaren gurasoa ez dena --> Grafoak zikloa du.
	 * @return true Grafo ez zuzenduak zikloa baldin badauka
	 * 		   false Grafo ez zuzenduak ziklorik ez badauka
	 */
	public boolean zikloaDuGEzZ(){
		boolean zikloa=false;
		for(Erpina erpina:auzokideZerrenda){
			erpina.setAztertua(false);
		}
		for(Erpina erpina:auzokideZerrenda){
			if(!erpina.isAztertua()){
				zikloa=sk(erpina);
				if(zikloa) break;
			}
		}
		return zikloa;
	}
	
	private boolean sk(Erpina e){
		boolean zikloa = false;
		e.setAztertua(true);
		LinkedList<Arkua> arkuak = e.getArkuZerrenda();
		Iterator<Arkua> it = arkuak.iterator();
		while(it.hasNext() && !zikloa){
			Arkua arkua = it.next();
			Erpina auzokidea = auzokideZerrenda[arkua.getHelmugaErpinZenbakia()];
			/* Aztertua izan den auzokidea eta e erpinaren gurasoa ez dena --> Zikloa */
			if((auzokidea.isAztertua()) && (e.getGurasoa()!=auzokidea.getErpinZenbakia())){
				zikloa = true;
			}else if(!auzokidea.isAztertua()){
				auzokidea.setGurasoa(e.getErpinZenbakia());
				zikloa = sk(auzokidea);
			}
		}
		return zikloa;
	}
	
	/* (8) */
	/**
	 * Metodo honek zerrenda bat itzultzen du, non elementu bakoitza osagai konexu bat adieraziz,
	 * haren erpin guztien zerrenda jasotzen duen. 
	 * Ideia: Sakonerako korritzea gauzatu edozein erpinetik abiatuta. Hasiera erpinetik bisita daitezkeen
	 * erpinen multzoa (eta erpina bera) osagai konexu bat osatuko dute. Osagai konexu guztiak topatzeko grafoa
	 * osorik korritu behar dugu, erpin guztiak aztertu arte.
	 * 
	 * @return Osagai konexuen zerrenda
	 */
	public LinkedList<LinkedList<Integer>> osagaiKonexuak(){
		LinkedList<LinkedList<Integer>> osagaiKonexuak = new LinkedList<LinkedList<Integer>>();
		for(Erpina erpina:auzokideZerrenda){
			erpina.setAztertua(false);
		}
		LinkedList<Integer> osagaiKonexuBat;
		for(Erpina erpina:auzokideZerrenda){
			if(!erpina.isAztertua()){
				osagaiKonexuBat = new LinkedList<Integer>();
				sk(erpina, osagaiKonexuBat);
				osagaiKonexuak.add(osagaiKonexuBat);
			}
		}
		return osagaiKonexuak;
	}
	
	private void sk(Erpina e, LinkedList<Integer> osagaiKonexuBat){
		e.setAztertua(true);
		osagaiKonexuBat.add(e.getErpinZenbakia());
		LinkedList<Arkua> arkuak = e.getArkuZerrenda();
		Iterator<Arkua> it = arkuak.iterator();
		while(it.hasNext()){
			Arkua arkua = it.next();
			Erpina auzokidea = auzokideZerrenda[arkua.getHelmugaErpinZenbakia()];
			if(!auzokidea.isAztertua()){
				sk(auzokidea, osagaiKonexuBat);
			}
		}
	}
	
	
	/************************************************************
	 * 	        [4] HEDAPEN ZUHAITZ MINIMOA - KRUSKAL           *
	 ************************************************************/
	
	/* (10) */
	/**
	 * Metodo honek hedapen zuhaitz minimoa (H.Z.M.) kalkulatzen du Kruskalen algoritmoa erabilita. 
	 * Garatzeko, Partiketa d.m.a. erabili da eta metodo honen irteera fitxategi batean gordeko da 
	 * ('outFitxategiIzena' izenekoa). Bere egitura honakoa izango da:
	 * 			Lehenengo lerroan, k zenbakia (naturala), soluzioa den Hedapen Zuhaitz Minimoaren (HZM) ertz kopurua adieraziz.
	 *			Bigarrengo lerroan, Kop osoko positiboa, soluzioko HZMko ertzen pisuen batura dena.
	 * 			Jarraiko k lerroetan, hiruna zenbaki: x, y eta p:
	 *				- Lehenengo biek  (x,y) ertza adierazten dute
	 * 				- Hirugarrengoak, (x,y) ertzari dagokion pisua adieraziko du
	 * @param outFitxategiIzena Metodoaren irteera-datuak fitxategi batean gordeko dira. 
	 * 							Fitxategi horren izena parametro honek ematen du.
	 * @return 0 itzultzen du H.Z.M. 'outFitxategiIzena' fitxategian zuzen idatzi baldin bada
	 * 		   -1 itzultzen du emaitzaren idazkerarekin arazoak egon badira.
	 *            Kasu honetan gertatutako arazoaren informazioa terminalean agertuko da.
	 */
	public int HZMKruskal(String outFitxategiIzena){
		LinkedList<Arkua> ertzakPisuarekikoOrdenatuak = new LinkedList<Arkua>();
		LinkedList<Arkua> HZMErtzak = new LinkedList<Arkua>();
		grafokoErtzakLortu(ertzakPisuarekikoOrdenatuak);
		Collections.sort(ertzakPisuarekikoOrdenatuak, new Comparator<Arkua>(){ /* Mergesort erabiltzen da */
			public int compare(Arkua a1, Arkua a2) {
				if(a1.getPisua()<a2.getPisua()){
					return -1;
				}else{
					return 1;
				}
			}
		});
		int ertzKop=0;
		double pisuenBatura=0;
		Partiketa partiketa = new Partiketa(auzokideZerrenda.length);
		while (ertzKop!=auzokideZerrenda.length-1){
			Arkua ertza = ertzakPisuarekikoOrdenatuak.removeFirst();
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
		return emaitzaFitxategiraEraman(HZMErtzak, pisuenBatura, outFitxategiIzena);
	}
	
	/**
	 * Metodo honek grafo ez zuzenduko ertzak lortu eta erreferentziz pasatutako zerrenda batean uzten ditu.
	 * Grafo ez zuzendua auzokide zerrenda bidez adierazita dago, eta egin dugun implementazioa kontuan hartuta: ertz 1 = 2 arku
	 * Ideia: (x,y) arkuak prozesatzerakoan, (x<y) betetzen dutenekin gelditu (errepikatuak/kontrako noranzkoak ez hartzeko)
	 * @param ertzakPisuarekikoOrdenatuak Erreferentziz pasatutako zerrenda, non metodoak grafoko ertzak gordeko dituen.
	 */
	private void grafokoErtzakLortu(LinkedList<Arkua> ertzakPisuarekikoOrdenatuak) {
		for(Erpina e : auzokideZerrenda){
			int erpinZenbakia = e.getErpinZenbakia();
			LinkedList<Arkua> arkuak = e.getArkuZerrenda();
			Iterator<Arkua> it = arkuak.iterator();
			while(it.hasNext()){
				Arkua arkua = it.next();
				if(erpinZenbakia<arkua.getHelmugaErpinZenbakia()){
					ertzakPisuarekikoOrdenatuak.add(new Arkua(erpinZenbakia, arkua.getHelmugaErpinZenbakia(), arkua.getPisua()));
				}
			}
		}
	}

	/**
	 * Metodo honek HZMKruskal() metodoan kalkulatutakoa 'outFitxategiIzena' fitxategian idazten du
	 * (lehen aipatutako egitura errespetatuz [ikusi HZMKruskal() metodoaren espezifikazioa]).
	 * @param HZMErtzak HZMko ertzak dituen zerrenda
	 * @param pisuenBatura HZMko ertzen pisuen batura
	 * @param outFitxategiIzena Sortuko den fitxategiaren izena
	 * @return 0 itzultzen du emaitza fitxategian zuzen idatzi baldin bada
	 * 		   -1 itzultzen du emaitzaren idazkerarekin arazoak egon badira.
	 */
	private int emaitzaFitxategiraEraman(LinkedList<Arkua> HZMErtzak, double pisuenBatura, String outFitxategiIzena) {
		try {
		    File fitxategia =new File("output/"+outFitxategiIzena);

		    BufferedWriter writer = new BufferedWriter(new FileWriter(fitxategia));
		    writer.write(Integer.toString(HZMErtzak.size())+"\n");
		    writer.write(Double.toString(pisuenBatura)+"\n");
		    for(Arkua ertza : HZMErtzak){
		    	writer.write(ertza.getJatorriErpinZenbakia()+" "+ertza.getHelmugaErpinZenbakia()+" "+ertza.getPisua()+"\n");
		    }
		    writer.close();
		    return 0;
		} catch(Exception e) {
			System.out.println("Arazoa egon da " + outFitxategiIzena + " fitxategia sortzerakoan");
			System.out.println(e.getMessage());
			return (-1);
		}
	}
	
	
	
}
