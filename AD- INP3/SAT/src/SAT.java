import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Betegarritasun edo SAT problema ebazten duen Java klasea
 */
public class SAT {
	private CNFFormula formula;
	private int klausulaKopurua;
	private int literalKopurua;
	private boolean[] esleipenak;
	private long adabegiKop;
	
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
			klausulaKopurua = s.nextInt();
			/* Formula osatzen duten klausulen irakurketa */
			for(int i=1; i<=klausulaKopurua; i++){
				Klausula klausulaBerria = new Klausula();
				//formula.klausulaBerriaGehitu();
				int literala = s.nextInt();
				while(literala!=0){
					klausulaBerria.literalaGehitu(new KlausulaLiterala(Math.abs(literala), (literala>0)));
					literala = s.nextInt();
				}
				formula.klausulaBerriaGehitu(klausulaBerria);
			}
			s.close();
			return 0;
		} catch (Exception e) {
			System.out.println("Arazoa egon da '"+ fitxategiIzena +"' fitxategiaren irakurketarekin");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return (-1);
		}
	}
	
	
	public void formulaBetearazi01(String outFitxategiIzena){
		/* Aldagai boolearrei emandako balioak jasoko dituen bektorea hasieratu */
		/* 0tik hasten da eta literalak aldiz 1etik --> beti 1 kendu */
		esleipenak = new boolean [literalKopurua];
		for(int i=0; i<literalKopurua; i++) esleipenak[i]=false;
		/* Esplorazio zuhaitzaren erpinak zenbatzeko aldagaia */
		adabegiKop = 1; /* 1etik hasten gara erroa zenbatzeko */
		/* Backtrack */
		boolean formulaBeteta = backtrack01(1);
		emaitzaFitxategianIdatzi(outFitxategiIzena, formulaBeteta);
	}


	private boolean backtrack01(int aldagaia) {
		if(formula.formulaBetetzenDa(esleipenak)){
			return true;
		}else if(aldagaia >= literalKopurua+1){
			return false;
		}else{
			boolean formulaBeteta = false;
			/* Saiakera TRUE balioarekin */
			esleipenak[aldagaia-1] = true;
			adabegiKop++;
			formulaBeteta = backtrack01(aldagaia+1);
			/* Saiakera FALSE balioarekin */
			if(!formulaBeteta){
				esleipenak[aldagaia-1] = false;
				formulaBeteta = backtrack01(aldagaia+2);
			}
			return formulaBeteta;
		}
	}
	
	private int emaitzaFitxategianIdatzi(String outFitxategiIzena, boolean formulaBeteta){
		try {
		    File fitxategia =new File("Output/"+outFitxategiIzena);
		    BufferedWriter writer = new BufferedWriter(new FileWriter(fitxategia));
		    if(formulaBeteta){
		    	for(int aldagaia=0; aldagaia<literalKopurua; aldagaia++){
			    	if(esleipenak[aldagaia]){
			    		writer.write("+" + (aldagaia+1) + " ");
			    	}else{
			    		writer.write("-" + (aldagaia+1) + " ");
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
			e.printStackTrace();
			return (-1);
		}
	}
}
