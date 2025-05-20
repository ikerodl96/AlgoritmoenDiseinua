import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Betegarritasun edo SAT problema ebazten duen Java klasea
 */
public class SAT {
	private CNFFormula formula;
	private int klausulaKopurua;
	private int literalKopurua;
	private Esleipenak esleipenak;
	
	
	/**
	 * Formulak fitxategietatik irakurtzen dituen metodoa
	 * @param fitxategiIzena Irakurriko den fitxategiaren izena
	 * @return 0 irakurketa ondo gauzatu baldin bada eta (-1) bestela
	 */
	public int formulaEraiki(String fitxategiIzena){
		formula =  new CNFFormula();
		try {
			Scanner s = new Scanner(new File(fitxategiIzena));
			/* Hasierako 5 lerroak utzi */
			for(int i=1; i<=5; i++) s.nextLine();
			/* 6 lerroan: p cnf NV NC */
			s.next(); // p 
			s.next(); // cnf
			literalKopurua = s.nextInt();
			esleipenak = new Esleipenak(literalKopurua);
			for(int literal=1; literal<=literalKopurua; literal++){
				Literala literala = new Literala(literal);
				esleipenak.literalaGehitu(literala);
			}
			klausulaKopurua = s.nextInt();
			/* Formula osatzen duten klausulen irakurketa */
			for(int i=1; i<=klausulaKopurua; i++){
				Klausula klausulaBerria = new Klausula();
				int klausulaLiterala = s.nextInt();
				while(klausulaLiterala!=0){
					Literala literala = esleipenak.getLiterala(Math.abs(klausulaLiterala));
					if(klausulaLiterala>0){
						literala.baiezkoeiBatGehitu();
						klausulaBerria.literalaGehitu(new KlausulaLiterala(klausulaLiterala, true));
					}else{
						literala.ezezkoeiBatGehitu();
						klausulaBerria.literalaGehitu(new KlausulaLiterala(klausulaLiterala*(-1), false));
					}
					literala.klausulaGehitu(klausulaBerria);
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
	
	
	public void formulaBetearazi(String outFitxategiIzena){
		/* Esplorazio zuhaitzaren erpinak zenbatzeko aldagaia */
		long[] adabegiKop = {1}; /* 1etik hasten gara erroa zenbatzeko */
		/* Backtrack */
		boolean formulaBeteta = backtrack(adabegiKop);
		//emaitzaFitxategianIdatzi(outFitxategiIzena, formulaBeteta, adabegiKop[0]);
		System.out.println(formulaBeteta);
	}

	private boolean backtrack(long[] adabegiKop){
		if(formula.formulaBetetzenDa(esleipenak)){
			return true;
		}else{
			Literala literala = esleipenak.baliogabekoHurrengoLiterala();
			if(literala==null){
				return false;
			}
			boolean formulaBeteDa = false;
			literala.setBalioaEsleituta(true);
			// Adarketa 1
			literala.setEsleitutakoBalioa(true);
			adabegiKop[0]++;
			formulaBeteDa = backtrack(adabegiKop);
			/* Adarketa 2 */
			if(!formulaBeteDa){
				literala.setEsleitutakoBalioa(false);
				adabegiKop[0]++;
				formulaBeteDa = backtrack(adabegiKop);
			}
			if(!formulaBeteDa){
				literala.setBalioaEsleituta(false);
			}
			return formulaBeteDa;
		}
	}
//	private boolean backtrack(long[] adabegiKop){
//		if(formula.formulaBetetzenDa(baliodunLiteralak)){
//			return true;
//		}else if(baliogabekoLiteralak.isEmpty()){
//			return false;
//		}else{
//			boolean formulaBeteta = false;
//			Literala literala = baliogabekoLiteralak.values().iterator().next();
//			baliogabekoLiteralak.remove(literala);
//			literala.setEsleitutakoBalioa(true);
//			adabegiKop[0]++;
//			baliodunLiteralak.put(literala.getAldagaia(), literala);
//			formulaBeteta = backtrack(adabegiKop);
//			if(!formulaBeteta){
//				baliodunLiteralak.remove(literala);
//				literala.setEsleitutakoBalioa(false);
//				baliodunLiteralak.put(literala.getAldagaia(), literala);
//				adabegiKop[0]++;
//				formulaBeteta = backtrack(adabegiKop);
//			}
//			if(!formulaBeteta){
//				baliodunLiteralak.remove(literala);
//				baliogabekoLiteralak.put(literala.getAldagaia(), literala);
//			}
//			return formulaBeteta;
//		}
//	}
	
	
//	public void formulaBetearazi01(String outFitxategiIzena){
//		/* Aldagai boolearrei emandako balioak jasoko dituen bektorea hasieratu */
//		/* Lehenengo posizioa ez da erabiliko */
//		boolean [] esleipenak = new boolean [literalKopurua+1];
//		for(int i=0; i<esleipenak.length; i++) esleipenak[i]=false;
//		/* Esplorazio zuhaitzaren erpinak zenbatzeko aldagaia */
//		long[] adabegiKop = {1}; /* 1etik hasten gara erroa zenbatzeko */
//		/* Backtrack */
//		int literala = baliogabekoLiteralak.removeFirst();
//		boolean formulaBeteta = backtrack01(esleipenak, literala, adabegiKop);
//		emaitzaFitxategianIdatzi(outFitxategiIzena, formulaBeteta, adabegiKop[0], esleipenak);
//	}
//
//
//	private boolean backtrack01(boolean[] esleipenak, int literala, long[] adabegiKop) {
//		if(formula.formulaBetetzenDa(esleipenak)){
//			return true;
//		}else if(baliogabekoLiteralak.isEmpty()){
//			return false;
//		}else{
//			boolean formulaBeteta = false;
//			int hurrengoLiterala = -1;
//			/* Saiakera TRUE balioarekin */
//			esleipenak[literala] = true;
//			baliodunLiteralak.addFirst(literala);
//			adabegiKop[0]++;
//			hurrengoLiterala = baliogabekoLiteralak.removeFirst();
//			formulaBeteta = backtrack01(esleipenak, hurrengoLiterala, adabegiKop);
//			/* Saiakera FALSE balioarekin */
//			if(!formulaBeteta){
//				esleipenak[literala] = false;
//				adabegiKop[0]++;
//				formulaBeteta = backtrack01(esleipenak, hurrengoLiterala, adabegiKop);
//			}
//			if(!formulaBeteta){
//				baliogabekoLiteralak.addFirst(hurrengoLiterala);
//				baliogabekoLiteralak.addFirst(baliodunLiteralak.removeFirst());
//			}
//			return formulaBeteta;
//		}
//	}
	
	private int emaitzaFitxategianIdatzi(String outFitxategiIzena, boolean formulaBeteta, long adabegiKop){
		try {
		    File fitxategia =new File("Output/"+outFitxategiIzena);
		    BufferedWriter writer = new BufferedWriter(new FileWriter(fitxategia));
		    if(formulaBeteta){
		    	for(Literala literala: esleipenak.getLiteralak()){
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
