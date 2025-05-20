import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Betegarritasun edo SAT problema ebazten duen Java klasea
 */
public class SAT {
	private CNFFormula formula;
	private int klausulaKopurua;
	private int literalKopurua;
	private HashMap<Integer,Literala> baliodunLiteralak;
	private HashMap<Integer,Literala> baliogabekoLiteralak;
	
	
	/**
	 * Formulak fitxategietatik irakurtzen dituen metodoa
	 * @param fitxategiIzena Irakurriko den fitxategiaren izena
	 * @return 0 irakurketa ondo gauzatu baldin bada eta (-1) bestela
	 */
	public int formulaEraiki(String fitxategiIzena){
		formula =  new CNFFormula();
		baliodunLiteralak = new HashMap<Integer, Literala>();
		baliogabekoLiteralak = new HashMap<Integer, Literala>();
		try {
			Scanner s = new Scanner(new File(fitxategiIzena));
			/* Hasierako 5 lerroak utzi */
			for(int i=1; i<=5; i++) s.nextLine();
			/* 6 lerroan: p cnf NV NC */
			s.next(); // p 
			s.next(); // cnf
			literalKopurua = s.nextInt();
			for(int literal=1; literal<=literalKopurua; literal++){
				Literala literala = new Literala(literal);
				baliogabekoLiteralak.put(literal, literala);
			}
			klausulaKopurua = s.nextInt();
			/* Formula osatzen duten klausulen irakurketa */
			for(int i=1; i<=klausulaKopurua; i++){
				Klausula klausulaBerria = new Klausula(i);
				int klausulaLiterala = s.nextInt();
				while(klausulaLiterala!=0){
					Literala literala = baliogabekoLiteralak.get(Math.abs(klausulaLiterala));
					if(klausulaLiterala>0){
						literala.baiezkoeiBatGehitu();
						klausulaBerria.literalaGehitu(new KlausulaLiterala(klausulaLiterala, true));
					}else{
						literala.ezezkoeiBatGehitu();
						klausulaBerria.literalaGehitu(new KlausulaLiterala(klausulaLiterala*(-1), false));
					}
					literala.klausulaGehitu(i);
					klausulaLiterala = s.nextInt();
				}
				formula.klausulaBerriaGehitu(klausulaBerria);
			}
			s.close();
			return 0;
		} catch (Exception e) {
			System.out.println("Arazoa egon da '"+ fitxategiIzena +"' fitxategiaren irakurketarekin");
			System.out.println(e.getMessage());
			return (-1);
		}
	}
	
	
	public void formulaBetearaziBt(String outFitxategiIzena){
		/* Esplorazio zuhaitzaren erpinak zenbatzeko aldagaia */
		int[] adabegiKop = {1}; /* 1etik hasten gara erroa zenbatzeko */
		/* Backtrack */
		boolean formulaBeteta = backtrack(adabegiKop);
		System.out.println(formulaBeteta);
		//emaitzaFitxategianIdatzi(outFitxategiIzena, formulaBeteta, adabegiKop[0]);
	}
	
	private boolean backtrack(int[] adabegiKop){
		if(formula.formulaBetetzenDa(baliodunLiteralak)){
			return true;
		}else if(baliogabekoLiteralak.isEmpty()){
			return false;
		}else{
			boolean formulaBeteta = false;
			Literala literala = baliogabekoLiteralak.values().iterator().next();
			baliogabekoLiteralak.remove(literala.getAldagaia());
			literala.setEsleitutakoBalioa(true);
			adabegiKop[0]++;
			baliodunLiteralak.put(literala.getAldagaia(), literala);
			formulaBeteta = backtrack(adabegiKop);
			if(!formulaBeteta){
				//baliodunLiteralak.remove(literala.getAldagaia());
				literala.setEsleitutakoBalioa(false);
				//baliodunLiteralak.put(literala.getAldagaia(), literala);
				adabegiKop[0]++;
				formulaBeteta = backtrack(adabegiKop);
			}
			if(!formulaBeteta){
				baliodunLiteralak.remove(literala.getAldagaia());
				baliogabekoLiteralak.put(literala.getAldagaia(), literala);
			}
			return formulaBeteta;
		}
	}
	
	
	public void formulaBetearaziDPLL(String outFitxategiIzena){
		/* Esplorazio zuhaitzaren erpinak zenbatzeko aldagaia */
		long[] adabegiKop = {1}; /* 1etik hasten gara erroa zenbatzeko */
		/* Backtrack */
		boolean formulaBeteta = DPLL(formula, baliodunLiteralak, baliogabekoLiteralak, adabegiKop);
		System.out.println(formulaBeteta);
		System.out.println(adabegiKop[0]);
	}
	
	
	private boolean DPLL(CNFFormula formula, HashMap<Integer, Literala> baliodunLiteralak, HashMap<Integer, Literala> baliogabekoLiteralak, long[] adabegiKop) {
		// ALDAGAIEN KOPIA ...
		HashMap<Integer, Literala> baliodunLiteralakKopia = hashMapaKopiatu(baliodunLiteralak);
		HashMap<Integer, Literala> baliogabekoLiteralakKopia = hashMapaKopiatu(baliogabekoLiteralak);
		//CNFFormula formulaKopia = formulaKopiatu(formula);
		
		if(klausulaHutsaDago(formula)){
			return false;
		}
		if(formula.hutsaDa()){
			return true;
		}
		
//		// Unit Propagation
//		Klausula literalBakarrekoKlausula = literalBakarrekoKlausulaDago(formulaKopia);
//		while(literalBakarrekoKlausula!=null){
//			boolean klausulaHutsaDago = literalUnitarioenHedapena(formulaKopia, literalBakarrekoKlausula, baliodunLiteralakKopia, baliogabekoLiteralakKopia);
//			if(klausulaHutsaDago) return false;
//			literalBakarrekoKlausula = literalBakarrekoKlausulaDago(formulaKopia);
//		}
////		
//		// Pure Literal
//		Literala literalPurua = literalPuruaDago(baliogabekoLiteralakKopia);
//		while(literalPurua!=null){
//			literalPuruenEzabapena(formulaKopia, literalPurua, baliodunLiteralakKopia, baliogabekoLiteralakKopia); //Pure-Literal
//			if(formulaKopia.hutsaDa()) return true;
//			literalPurua = literalPuruaDago(baliogabekoLiteralakKopia);
//		}
		
		// Kasu orokorra (SPLIT)
		boolean formulaBeteta = false;
		Literala literala = baliogabekoLiteralakKopia.values().iterator().next();
		baliogabekoLiteralakKopia.remove(literala.getAldagaia());
		literala.setEsleitutakoBalioa(true);
		adabegiKop[0]++;
		baliodunLiteralakKopia.put(literala.getAldagaia(), literala);
		literalarenBalioaFormulanJarri(formula,literala,baliogabekoLiteralakKopia);
		System.out.println(formula.toString());
		System.out.println(literala.getAldagaia() + " --> " + literala.esleitutakoBalioa());
		formulaBeteta = DPLL(formula, baliodunLiteralakKopia, baliogabekoLiteralakKopia, adabegiKop);
		
		if(!formulaBeteta){
			//formula = formulaKopiatu(formula);
			literala.setEsleitutakoBalioa(false);
			adabegiKop[0]++;
			literalarenBalioaFormulanJarri(formula,literala,baliogabekoLiteralakKopia);
			System.out.println(formula.toString());
			System.out.println(literala.getAldagaia() + " --> " + literala.esleitutakoBalioa());
			formulaBeteta = DPLL(formulaKopia, baliodunLiteralakKopia, baliogabekoLiteralakKopia, adabegiKop);
		}
//		if(!formulaBeteta){
//			baliodunLiteralak.remove(literala.getAldagaia());
//			baliogabekoLiteralak.put(literala.getAldagaia(), literala);
//		}
		return formulaBeteta;
	}


	private boolean klausulaHutsaDago(CNFFormula formulaKopia) {
		for(Klausula k : formulaKopia.getKlausulaZerrenda().values()){
			if(k.hutsaDa()){
				return true;
			}
		}
		return false;
	}


//	private boolean literalarenBalioaFormulanJarri(CNFFormula formula, Literala literala, HashMap<Integer, Literala> baliogabekoLiteralak) {
//		HashMap<Integer,Klausula> klausulaZerrenda = formula.getKlausulaZerrenda();
//		for(Integer i : literala.getAgerpenKlausulaZerrenda()){
//			Klausula klausula = klausulaZerrenda.get(i);
//			if(klausula!=null){
//				if(klausula.klausulaLiteralaDago(new KlausulaLiterala(literala.getAldagaia(), literala.esleitutakoBalioa()))){
//					for(KlausulaLiterala kl : klausula.getKlausularenLiteralZerrenda()){
//						Literala lit = baliogabekoLiteralak.get(kl.getAldagaia());
//						if(lit!=null){
//							if(kl.getZeinua()){
//								lit.baiezkoeiBatKendu();
//							}else{
//								lit.ezezkoeiBatKendu();
//							}
//						}
//					}
//					klausulaZerrenda.remove(klausula.klausularenIDa());
//				}else if(klausula.klausulaLiteralaDago(new KlausulaLiterala(literala.getAldagaia(), !literala.esleitutakoBalioa()))){
//					klausula.klausulaLiteralaEzabatu(new KlausulaLiterala(literala.getAldagaia(), !literala.esleitutakoBalioa()));
//				}
//			}
//		}
//		return false;
//	}
	
	private CNFFormula literalarenBalioaFormulanJarri(CNFFormula formula, Literala literala, HashMap<Integer, Literala> baliogabekoLiteralak){
		HashMap<Integer,Klausula> klausulaZerrenda = formula.getKlausulaZerrenda();
		CNFFormula formulaBerria = new CNFFormula();
		for(Klausula klausula : klausulaZerrenda.values()){
			Klausula klausularenKopia = klausula.kopia();
			if(klausula.klausulaLiteralaDago(new KlausulaLiterala(literala.getAldagaia(), literala.esleitutakoBalioa()))){
				for(KlausulaLiterala kl : klausula.getKlausularenLiteralZerrenda()){
					Literala lit = baliogabekoLiteralak.get(kl.getAldagaia());
					if(kl.getZeinua()){
						lit.baiezkoeiBatKendu();
					}else{
						lit.ezezkoeiBatKendu();
					}
				}
			}else if(klausula.klausulaLiteralaDago(new KlausulaLiterala(literala.getAldagaia(), !literala.esleitutakoBalioa()))){
				klausularenKopia.klausulaLiteralaEzabatu(new KlausulaLiterala(literala.getAldagaia(), !literala.esleitutakoBalioa()));
				formulaBerria.klausulaBerriaGehitu(klausularenKopia);
			}else{
				formulaBerria.klausulaBerriaGehitu(klausularenKopia);
			}
		}
		return formulaBerria;
	}


	public Klausula literalBakarrekoKlausulaDago(CNFFormula formula){
		/* INEFICIENTE */
		for(Klausula klausula : formula.getKlausulaZerrenda().values()){
			if (klausula.literalKopurua()==1){
				return klausula;
			}
		}
		return null;
	}

	private boolean literalUnitarioenHedapena(CNFFormula formula, Klausula literalBakarrekoKlausula, HashMap<Integer, Literala> baliodunLiteralak, HashMap<Integer, Literala> baliogabekoLiteralak){
		HashMap<Integer,Klausula> klausulaZerrenda = formula.getKlausulaZerrenda();
		KlausulaLiterala literalUnitarioa = literalBakarrekoKlausula.getLehenengoLiterala();
		//literalenAgerpenKlausulakEguneratu();  EZ DIRA EGUNERATUKO
		Literala literala = baliogabekoLiteralak.get(literalUnitarioa.getAldagaia());
		baliogabekoLiteralak.remove(literala.getAldagaia());
		literala.setEsleitutakoBalioa(literalUnitarioa.getZeinua());
		baliodunLiteralak.put(literala.getAldagaia(), literala);
		LinkedList<Integer> agerpenKlausulaZerrenda = literala.getAgerpenKlausulaZerrenda();
		for(Integer i : agerpenKlausulaZerrenda){
			Klausula klausula = klausulaZerrenda.get(i);
			if(klausula!=null){
				if(klausula.klausulaLiteralaDago(literalUnitarioa)){
					for(KlausulaLiterala kl : klausula.getKlausularenLiteralZerrenda()){
						Literala lit = baliogabekoLiteralak.get(kl.getAldagaia());
						if(lit!=null){
							if(kl.getZeinua()){
								lit.baiezkoeiBatKendu();
							}else{
								lit.ezezkoeiBatKendu();
							}
						}
					}
					klausulaZerrenda.remove(klausula.klausularenIDa());
				}else{
					klausula.klausulaLiteralaEzabatu(new KlausulaLiterala(literalUnitarioa.getAldagaia(), !literalUnitarioa.getZeinua()));
					if(klausula.hutsaDa()) return true;
				}
			}
		}
		return false;
	}
	
	private Literala literalPuruaDago(HashMap<Integer, Literala> baliogabekoLiteralak) {
		for(Literala literala : baliogabekoLiteralak.values()){
			if(literala.puruaDa()){
				return literala;
			}
		}
		return null;
	}

	
	private void literalPuruenEzabapena(CNFFormula formula, Literala literalPurua, HashMap<Integer, Literala> baliodunLiteralak, HashMap<Integer, Literala> baliogabekoLiteralak){
		boolean zeinua;
		HashMap<Integer,Klausula> klausulaZerrenda = formula.getKlausulaZerrenda();
		if(literalPurua.getBaiezkoak()==0){
			zeinua = false; 
		}else{
			zeinua = true;
		}
		baliogabekoLiteralak.remove(literalPurua.getAldagaia());
		literalPurua.setEsleitutakoBalioa(zeinua);
		baliodunLiteralak.put(literalPurua.getAldagaia(), literalPurua);
		
		LinkedList<Integer> agerpenKlausulaZerrenda = literalPurua.getAgerpenKlausulaZerrenda();
		for(Integer i : agerpenKlausulaZerrenda){
			Klausula klausula = klausulaZerrenda.get(i);
			if(klausula!=null && klausula.klausulaLiteralaDago(new KlausulaLiterala(literalPurua.getAldagaia(), zeinua))){
				for(KlausulaLiterala kl : klausula.getKlausularenLiteralZerrenda()){
					Literala lit = baliogabekoLiteralak.get(kl.getAldagaia());
					if(lit!=null){
						if(kl.getZeinua()){
							lit.baiezkoeiBatKendu();
						}else{
							lit.ezezkoeiBatKendu();
						}
					}
				}
				klausulaZerrenda.remove(klausula.klausularenIDa());
			}
		}	
	}
	
	// KOPIAK
	private CNFFormula formulaKopiatu(CNFFormula formula) {
		CNFFormula formulaBerria = new CNFFormula();
		for(Klausula k : formula.getKlausulaZerrenda().values()){
			Klausula kb = new Klausula(k.klausularenIDa());
			kb.setLiteralZerrenda(new HashSet<KlausulaLiterala>(k.getKlausularenLiteralZerrenda()));
			formulaBerria.klausulaBerriaGehitu(kb);
		}
		return formulaBerria;
	}

	private HashMap<Integer, Literala> hashMapaKopiatu(HashMap<Integer, Literala> hashMap) {
		 HashMap<Integer, Literala> hashMapBerria = new HashMap<Integer, Literala>();
		 for(Literala literala : hashMap.values()){
			 Literala literalBerria = new Literala(literala.getAldagaia());
			 literalBerria.setAgerpenKlausulaZerrenda((LinkedList<Integer>) literala.getAgerpenKlausulaZerrenda().clone());
			 literalBerria.setBaiezkoak(literala.getBaiezkoak());
			 literalBerria.setEsleitutakoBalioa(literala.esleitutakoBalioa());
			 literalBerria.setEzezkoak(literala.getEzezkoak());
			 hashMapBerria.put(literala.getAldagaia(), literalBerria);
		 }
		 return hashMapBerria;
	}
	
	// EMAITZA FITXATEGIAN IDATZI
	private int emaitzaFitxategianIdatzi(String outFitxategiIzena, boolean formulaBeteta, int adabegiKop){
		try {
		    File fitxategia =new File("Output/"+outFitxategiIzena);
		    BufferedWriter writer = new BufferedWriter(new FileWriter(fitxategia));
		    if(formulaBeteta){
		    	for(Literala literala: baliodunLiteralak.values()){
			    	if(literala.esleitutakoBalioa()){
			    		writer.write(literala.getAldagaia() + " ");
			    	}
			    }
		    }else{
		    	writer.write("BETEEZINA");
		    }
		    writer.write("\n");
		    writer.write(adabegiKop+"\n");
		    writer.close();
		    return 0;
		} catch(Exception e) {
			System.out.println("Arazoa egon da " + outFitxategiIzena + " fitxategia sortzerakoan");
			System.out.println(e.getMessage());
			return (-1);
		}
	}
}
