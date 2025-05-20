import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;


public class AntartidaraBidaia {
	/* Problemaren aldagaiak [GLOBALAK] */
	private int T;
	private int P;
	private int E;
	private int[] ordaindu = null;
	private int[] ekipaiKG = null;
	
	
	/************************************************************
	 * 	         SARRERA DATUAK IRAKURTZEKO METODOA             *
	 ************************************************************/
	
	public int datuakIrakurri(String fitxategiIzena){
		try {
			Scanner s = new Scanner(new File(fitxategiIzena));
			P = s.nextInt();
			T = s.nextInt();
			E = s.nextInt();
			ordaindu = new int[E];
			ekipaiKG = new int[E];

			for(int eskaera=0; eskaera<E; eskaera++){
				int ordaintzekoPrest = s.nextInt();
				int gehienezkoEkipaiKG = s.nextInt();
				ordaindu[eskaera]=ordaintzekoPrest;
				ekipaiKG[eskaera]=gehienezkoEkipaiKG;
			}
			s.close();
			return 0;
		} catch (Exception e) {
			System.out.println("Arazoa egon da '"+ fitxategiIzena +"' fitxategiaren irakurketarekin");
			System.out.println(e.getMessage());
			return (-1);
		}
	}
	
	
	/************************************************************
	 * 	                PROGRAMAZIO DINAMIKOA 	                *
	 ************************************************************/
	/* Problemaren aldagaiak [GLOBALAK] */
		/* Metatze-egitura */
	private int[][][] MeE;
		/* Errekuperaziorako erabiliko den egitura */
	private int[][][] MeErrek;
	
	public int agentziakLorDezakeenEtekinMaxPD(String outFitxategiIzena){
		/* Metatze-egitura hasieratu */
		MeE = new int[T+1][P+1][E+1];
		for(int t=0; t<=T; t++){
			for(int p=0; p<=P; p++){
				for(int b=0; b<=E; b++){
					MeE[t][p][b]=-1;
				}
			}
		}
		
		/* Errekuperaziorako egitura hasieratu */
		MeErrek = new int[T+1][P+1][E+1];
		/* Hautatutako bidaiariak jasoko dituen zerrenda
		 * Errekuperazioa egiterakoan beteko da */
		LinkedList<Integer> hautatutakoBidaiariak = new LinkedList<Integer>();
		
		/* Metatze-egitura hasieratu kasu nabariekin */
		/* KN1 */
		for(int p=0; p<=P; p++){
			for(int e=0; e<=E; e++){
				MeE[0][p][e]=0;
			}
		}
		/* KN2 */
		for(int t=0; t<=T; t++){
			for(int e=0; e<=E; e++){
				MeE[t][0][e]=0;
			}
		}
		/* KN3 */
		for(int t=0; t<=T; t++){
			for(int p=0; p<=P; p++){
				MeE[t][p][0]=0;
			}
		}
		
		/* Kasu orokorra: soluzioa */
		if(MeE[T][P][E]==-1){
			bete(T,P,E);
		}
		
		/* Errekuperazioa */
		/* Errekuperazioa gauzatzeko aldagaiak */
		int Kilo = T;
		int Plaza = P;
		for(int eskatzailea = E-1; eskatzailea>=0; eskatzailea--){
			//bidaiariHautaketa[eskatzaile]=MeErrek[Kilo][Plaza][eskatzaile+1];
			if(MeErrek[Kilo][Plaza][eskatzailea+1]==1){
				hautatutakoBidaiariak.add(eskatzailea);
				Plaza = Plaza-1;
				Kilo = Kilo - ekipaiKG[eskatzailea];
			}
		}
		
		return emaitzaFitxategianIdatziPD(outFitxategiIzena, hautatutakoBidaiariak);
	}

	private void bete(int t, int p, int e) {
		if(MeE[t][p][e-1]==-1) bete(t, p, e-1);
		MeE[t][p][e]=MeE[t][p][e-1];
		if(ekipaiKG[e-1]<=t){
			if(MeE[t-ekipaiKG[e-1]][p-1][e-1]==-1) bete(t-ekipaiKG[e-1], p-1, e-1);
			if(ordaindu[e-1]+MeE[t-ekipaiKG[e-1]][p-1][e-1]>MeE[t][p][e-1]){
				MeE[t][p][e]=ordaindu[e-1]+MeE[t-ekipaiKG[e-1]][p-1][e-1];
				MeErrek[t][p][e]=1;
			}
		}
	}
		
	private int emaitzaFitxategianIdatziPD(String outFitxategiIzena, LinkedList<Integer> hautatutakoBidaiariak) {
		try {
			int ekipaienPisuTotala = 0;
		    File fitxategia =new File("Output/"+outFitxategiIzena);
		    BufferedWriter writer = new BufferedWriter(new FileWriter(fitxategia));
		    writer.write(Integer.toString(hautatutakoBidaiariak.size())+"\n");
		    for(Integer bidaiaria : hautatutakoBidaiariak){
		    	writer.write(bidaiaria+" "+ordaindu[bidaiaria]+" "+ekipaiKG[bidaiaria]+"\n");
		    	ekipaienPisuTotala = ekipaienPisuTotala + ekipaiKG[bidaiaria];
		    }
		    writer.write(Integer.toString(MeE[T][P][E])+" "+ekipaienPisuTotala+"\n");
		    writer.write(Integer.toString(P*T*E)+"\n");
		    writer.close();
		    return 0;
		} catch(Exception e) {
			System.out.println("Arazoa egon da " + outFitxategiIzena + " fitxategia sortzerakoan");
			System.out.println(e.getMessage());
			return (-1);
		}
	}
	
	
	/************************************************************
	 *  	          BACKTRACKING [0/1 ZUHAITZA]  	            *
	 ************************************************************/
	
	public int agentziakLorDezakeenEtekinMaxBT01(String outFitxategiIzena){
		int[] SP = new int[E];
		int[] SOPT = new int[E];
		int[] SOPTE = {0};
		int[] SOPTB = {0};
		int outEtekina=0;
		for(int eskaera=0; eskaera<E; eskaera++) outEtekina=outEtekina + ordaindu[eskaera];
		long [] adabegiKop = {1}; /* 1etik hasi, zuhaitzaren erroa zenbatzeko */
		bidaiariakHautatu01(0, 0, 0, SP, 0, SOPTE, SOPT, SOPTB, outEtekina, adabegiKop);
		return emaitzaFitxategianIdatziBT01(outFitxategiIzena,SOPT, SOPTE[0], SOPTB[0], adabegiKop[0]);
	}

	private void bidaiariakHautatu01(int SPBK, int SPEK, int SPE, int[] SP, int esk, int[] SOPTE, int[] SOPT, int[] SOPTB, int outEtekina, long[] adabegiKop){
		if (esk==E){
			if(SPE>SOPTE[0]){
				SOPTE[0]=SPE;
				SOPTB[0]=SPBK;
				kopiatu(SP, SOPT);
			}
		}else{
			for(int j=0; j<=1; j++){
				if(SPBK+(j*1)<=P /*Kima1*/ && 
				   SPEK+(j*ekipaiKG[esk])<=T /*Kima2*/ && 
				   SOPTE[0]<SPE+outEtekina /*Kima3*/){
					adabegiKop[0]++;
					SP[esk]=j;
					bidaiariakHautatu01(SPBK+(j*1), SPEK+(j*ekipaiKG[esk]), SPE+(j*ordaindu[esk]), SP, esk+1, SOPTE, SOPT, SOPTB, outEtekina-ordaindu[esk], adabegiKop);
				}
			}
		}
	}

	
	private void kopiatu(int[] SP, int[] SOPT) {
		for(int i=0; i<SP.length; i++){
			SOPT[i]=SP[i];
		}
	}
	
	private int emaitzaFitxategianIdatziBT01(String outFitxategiIzena, int[] SOPT, int irabazia, int bidaiariKop, long adabegiKop) {
		try {
			int ekipaienPisuTotala = 0;
		    File fitxategia =new File("Output/"+outFitxategiIzena);
		    BufferedWriter writer = new BufferedWriter(new FileWriter(fitxategia));
		    writer.write(Integer.toString(bidaiariKop)+"\n");
		    for(int eskaera=0; eskaera<E; eskaera++){
		    	if(SOPT[eskaera]==1){
			    	writer.write(eskaera+" "+ordaindu[eskaera]+" "+ekipaiKG[eskaera]+"\n");
			    	ekipaienPisuTotala = ekipaienPisuTotala + ekipaiKG[eskaera];
		    	}
		    }
		    writer.write(irabazia+" "+ekipaienPisuTotala+"\n");
		    writer.write(adabegiKop+"\n");
		    writer.close();
		    return 0;
		} catch(Exception e) {
			System.out.println("Arazoa egon da " + outFitxategiIzena + " fitxategia sortzerakoan");
			System.out.println(e.getMessage());
			return (-1);
		}
	}
	
	/************************************************************
	 *  	          BACKTRACKING [1/N ZUHAITZA]  	            *
	 ************************************************************/
	
	public int agentziakLorDezakeenEtekinMaxBT1N(String outFitxategiIzena){
		LinkedList<Integer> SP = new LinkedList<Integer>();
		LinkedList<Integer> SOPT = new LinkedList<Integer>();
		int[] SOPTE = {0};
		int[] outEtekina = new int[E];
		outEtekina[E-1]=ordaindu[E-1];
		for(int eskaera=E-2; eskaera>=0; eskaera--){
			outEtekina[eskaera]=ordaindu[eskaera]+outEtekina[eskaera+1];
		}
		long[] adabegiKop = {1}; /* 1etik hasi, zuhaitzaren erroa zenbatzeko */
		bidaiariakHautatu1N(0, 0, 0, SP, 0, SOPTE, SOPT, outEtekina, adabegiKop);
		return emaitzaFitxategianIdatziBT1N(outFitxategiIzena,SOPT, SOPTE[0], adabegiKop[0]);
	}

	private void bidaiariakHautatu1N(int SPBK, int SPEK, int SPE, LinkedList<Integer> SP, int esk, int[] SOPTE, LinkedList<Integer> SOPT, int[] outEtekina, long[] adabegiKop){
		if(esk==E){
			if(SPE>SOPTE[0]){
				SOPTE[0]=SPE;
				kopiatu(SP,SOPT);
			}
		}else{
			for(int eskaera=esk; eskaera<E; eskaera++){
				if(SPBK+1<=P && /* Kima 1 */
						SPEK+ekipaiKG[eskaera]<=T && /* Kima 2 */
						SPE+outEtekina[eskaera]>SOPTE[0]){ /* Kima 3 */
					adabegiKop[0]++;
					SP.addFirst(eskaera);
					bidaiariakHautatu1N(SPBK+1, SPEK+ekipaiKG[eskaera], SPE+ordaindu[eskaera], SP, eskaera+1, SOPTE, SOPT, outEtekina, adabegiKop);
					SP.removeFirst();
				}
			}
			if(SPE>SOPTE[0]){
				SOPTE[0]=SPE;
				kopiatu(SP,SOPT);
			}
		}
	}

	private void kopiatu(LinkedList<Integer> SP, LinkedList<Integer> SOPT) {
		SOPT.clear();
		for(Integer bidaiaria: SP){
			SOPT.add(bidaiaria);
		}
	}
	
	private int emaitzaFitxategianIdatziBT1N(String outFitxategiIzena, LinkedList<Integer> SOPT, int irabazia, long adabegiKop) {
		try {
			int ekipaienPisuTotala = 0;
		    File fitxategia =new File("Output/"+outFitxategiIzena);
		    BufferedWriter writer = new BufferedWriter(new FileWriter(fitxategia));
		    writer.write(Integer.toString(SOPT.size())+"\n");
		    for(Integer eskaera: SOPT){
			    writer.write(eskaera+" "+ordaindu[eskaera]+" "+ekipaiKG[eskaera]+"\n");
			    ekipaienPisuTotala = ekipaienPisuTotala + ekipaiKG[eskaera];
		    }
		    writer.write(irabazia+" "+ekipaienPisuTotala+"\n");
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
