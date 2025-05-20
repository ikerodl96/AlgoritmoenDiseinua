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
	private int aldagaiKopurua;
	
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
			aldagaiKopurua = s.nextInt();
			klausulaKopurua = s.nextInt();
			/* Formula osatzen duten klausulen irakurketa */
			for(int i=1; i<=klausulaKopurua; i++){
				formula.klausulaBerriaGehitu();
				int literala = s.nextInt();
				while(literala!=0){
					formula.azkenengoKlausulariLiteralaGehitu(Math.abs(literala), (literala>0));
					literala = s.nextInt();
				}
			}
			s.close();
			return 0;
		} catch (Exception e) {
			System.out.println("Arazoa egon da '"+ fitxategiIzena +"' fitxategiaren irakurketarekin");
			System.out.println(e.getMessage());
			return (-1);
		}
	}
	
	
	public void formulaBetearazi01(String outFitxategiIzena){
		/* Aldagai boolearrei emandako balioak jasoko dituen bektorea hasieratu */
		/* Lehenengo posizioa ez da erabiliko */
		boolean [] esleipenak = new boolean [aldagaiKopurua+1];
		for(int i=0; i<esleipenak.length; i++) esleipenak[i]=false;
		/* Esplorazio zuhaitzaren erpinak zenbatzeko aldagaia */
		long[] adabegiKop = {1}; /* 1etik hasten gara erroa zenbatzeko */
		/* Backtrack */
		boolean formulaBeteta = backtrack01(esleipenak, 1, adabegiKop);
		emaitzaFitxategianIdatzi(outFitxategiIzena, formulaBeteta, adabegiKop[0], esleipenak);
	}


	private boolean backtrack01(boolean[] esleipenak, int aldagaia, long[] adabegiKop) {
		if(formula.formulaBetetzenDa(esleipenak)){
			return true;
		}else if(aldagaia == aldagaiKopurua){
			return false;
		}else{
			boolean formulaBeteta = false;
			/* Saiakera TRUE balioarekin */
			esleipenak[aldagaia] = true;
			adabegiKop[0]++;
			formulaBeteta = backtrack01(esleipenak, aldagaia+1, adabegiKop);
			/* Saiakera FALSE balioarekin */
			if(!formulaBeteta){
				esleipenak[aldagaia] = false;
				adabegiKop[0]++;
				formulaBeteta = backtrack01(esleipenak, aldagaia+1, adabegiKop);
			}
			return formulaBeteta;
		}
	}
	
	private int emaitzaFitxategianIdatzi(String outFitxategiIzena, boolean formulaBeteta, long adabegiKop, boolean [] esleipenak){
		try {
		    File fitxategia =new File("Output/"+outFitxategiIzena);
		    BufferedWriter writer = new BufferedWriter(new FileWriter(fitxategia));
		    if(formulaBeteta){
		    	for(int aldagaia=1; aldagaia<=aldagaiKopurua; aldagaia++){
			    	if(esleipenak[aldagaia]){
			    		writer.write(aldagaia + " ");
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
