import java.util.InputMismatchException;
import java.util.Scanner;

public class Frogak {

	static Scanner s = new Scanner(System.in);
	static AntartidaraBidaia ab = new AntartidaraBidaia();
	static Kronometroa kronometroa = new Kronometroa();
	
    public static void main(String[] args) { 
        hasierakoMenua();
    }

	private static void hasierakoMenua() {
		hasierakoMenuaImprimatu();
		int aukera;
		boolean ondoIrakurrita=false;
		while(!ondoIrakurrita){
			System.out.print("--> Zure aukera: ");
			try {
	            aukera = s.nextInt();
	            switch (aukera) {
	                case 1:
	                	ondoIrakurrita=true;
	                	fitxategitikBidaiDatuakIrakurri();
	                    break;
	                case 2:
	                	System.out.println();
	                    System.out.println("__________________________________________");
	                    System.out.println("Programa nagusitik zuzen irten zara");
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Bakarrik 1 eta 2 arteko zenbakiak onartzen dira...");
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("1 eta 2 arteko zenbakia sartu behar duzu...");     
	            s.next();
	        }
		}
	}
	
	public static void hasierakoMenuaImprimatu(){
		System.out.println();
		System.out.println();
		System.out.println("/***************************************");
		System.out.println(" *  ANTARTIDARA BIDAIA [PD+BT]  -  AD  *");
		System.out.println(" ***************************************/");
		System.out.println();
		System.out.println("Aukerak: ");
		System.out.println("1. Sarrera datuak fitxategi batetik irakurri");
        System.out.println("2. Irten");
	}
	
	private static void fitxategitikBidaiDatuakIrakurri() {
		System.out.println();
		System.out.println();
		System.out.println("/***************************************");
		System.out.println(" *           DATUEN IRAKURKETA         *");
		System.out.println(" ***************************************/");
		System.out.println();	
		System.out.println("OHARRA: Fitxategia 'Fitxategiak' karpetan egon behar du");
		System.out.println();
		boolean ondoIrakurrita = false;
		int irakurketarenEmaitza;
		while (!ondoIrakurrita){
			System.out.print("Fitxategiaren izena: ");
			String fitxategiIzena = "Fitxategiak/"+s.next();
			kronometroa.start();
			irakurketarenEmaitza=ab.datuakIrakurri(fitxategiIzena);
			if (irakurketarenEmaitza==0){
				ondoIrakurrita=true;
				kronometroa.stop();
				System.out.println("Datuak zuzen irakurri dira");
				ebaztekoAukerenMenua();
			}else{
				System.out.println("Arazoa egon da " + fitxategiIzena + " fitxategiaren irakurketarekin");
			}
		}
	}

	
	private static void ebaztekoAukerenMenua() {
		ebaztekoAukerenMenuaImprimatu();
		int aukera;
		boolean ondoIrakurrita=false;
		while(!ondoIrakurrita){
			System.out.print("--> Zure aukera: ");
			try {
	            aukera = s.nextInt();
	            String fitxIzena = null;
	            int emaitza;
	            switch (aukera) {
	                case 1:
	                	ondoIrakurrita=true;
	                	System.out.print("Irteera fitxategiaren izena sartu ('Output' karpetan kokatuko da fitxategi hau):");
	                	fitxIzena=s.next();
	                    kronometroa.start();
	                    System.out.println("Emaitza:");
	                    emaitza=ab.agentziakLorDezakeenEtekinMaxPD(fitxIzena);
	                    if(emaitza==0){
	                    	System.out.println("Medodoa zuzen exekutatu da. Emaitza 'Output/"+ fitxIzena +"' fitxategian duzu.");
	                    }else{
	                    	System.out.println("Arazoa egon da metodoa exekutatzerakoan...");
	                    }
	                    kronometroa.stop();
	                    System.out.println();
	                    ebaztekoAukerenMenua();
	                    break;
	                case 2:
	                	ondoIrakurrita=true;
	                	System.out.print("Irteera fitxategiaren izena sartu ('Output' karpetan kokatuko da fitxategi hau):");
	                	fitxIzena=s.next();
	                    kronometroa.start();
	                    System.out.println("Emaitza:");
	                    emaitza=ab.agentziakLorDezakeenEtekinMaxBT01(fitxIzena);
	                    if(emaitza==0){
	                    	System.out.println("Medodoa zuzen exekutatu da. Emaitza 'Output/"+ fitxIzena +"' fitxategian duzu.");
	                    }else{
	                    	System.out.println("Arazoa egon da metodoa exekutatzerakoan...");
	                    }
	                    kronometroa.stop();
	                    System.out.println();
	                    ebaztekoAukerenMenua();
	                    break;
	                case 3:
	                	ondoIrakurrita=true;
	                	System.out.print("Irteera fitxategiaren izena sartu ('Output' karpetan kokatuko da fitxategi hau):");
	                	fitxIzena=s.next();
	                    kronometroa.start();
	                    System.out.println("Emaitza:");
	                    emaitza=ab.agentziakLorDezakeenEtekinMaxBT1N(fitxIzena);
	                    if(emaitza==0){
	                    	System.out.println("Medodoa zuzen exekutatu da. Emaitza 'Output/"+ fitxIzena +"' fitxategian duzu.");
	                    }else{
	                    	System.out.println("Arazoa egon da metodoa exekutatzerakoan...");
	                    }
	                    kronometroa.stop();
	                    System.out.println();
	                    ebaztekoAukerenMenua();
	                    break;
	                case 4:
	                	ondoIrakurrita=true;
	                	hasierakoMenua();
	                    break;
	                default:
	                    System.out.println("Bakarrik 1 eta 4 arteko zenbakiak onartzen dira...");
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("1 eta 4 arteko zenbakia sartu behar duzu...");
	            s.next();
	        }
		}
	}
	
	public static void ebaztekoAukerenMenuaImprimatu(){
		System.out.println();
		System.out.println();
		System.out.println("/***************************************");
		System.out.println(" *      PROBLEMA EBAZTEKO AUKERAK      *");
		System.out.println(" ***************************************/");
		System.out.println();
		System.out.println("Metodoak: ");
		System.out.println("1. Programazio Dinamikoa");
        System.out.println("2. Backtrack [0/1] zuhaitza");
        System.out.println("3. Backtrack [1/N] zuhaitza");
        System.out.println("4. Atzera");
	}
}
