import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
 
public class Frogak {
	static Scanner s = new Scanner(System.in);
	static GrafoZuzendua gz = new GrafoZuzendua();
	static GrafoEzZuzendua gez = new GrafoEzZuzendua();
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
	                    grafoZuzenduenMenua();
	                    break;
	                case 2:
	                	ondoIrakurrita=true;
	                	grafoEzZuzenduenMenua();
	                    break;
	                case 3:
	                	System.out.println();
	                    System.out.println("__________________________________________");
	                    System.out.println("Programa nagusitik zuzen irten zara");
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Bakarrik 1 eta 3 arteko zenbakiak onartzen dira...");
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("1 eta 3 arteko zenbakia sartu behar duzu...");     
	            s.next();
	        }
		}
	}
	
	public static void hasierakoMenuaImprimatu(){
		System.out.println();
		System.out.println();
		System.out.println("/***************************************");
		System.out.println(" * GRAFOEN GAINEKO IMPLEMENTAZIOA - AD *");
		System.out.println(" ***************************************/");
		System.out.println();
		System.out.println("Aukerak: ");
		System.out.println("1. Grafo Zuzenduen gaineko metodoak frogatu");
        System.out.println("2. Grafo Ez Zuzenduen gaineko metodoak frogatu");
        System.out.println("3. Irten");
	}
	
	
	private static void grafoZuzenduenMenua() {
		grafoZuzenduenMenuaImprimatu();
		int aukera;
		boolean ondoIrakurrita=false;
		while(!ondoIrakurrita){
			System.out.print("--> Zure aukera: ");
			try {
	            aukera = s.nextInt();
	            switch (aukera) {
	                case 1:
	                	ondoIrakurrita=true;
	                    fitxategitikGrafoaIrakurri(0);
	                    break;
	                case 2:
	                	ondoIrakurrita=true;
	                	fitxategitikGrafoaIrakurri(1);
	                    break;
	                case 3:
	                	ondoIrakurrita=true;
	                	hasierakoMenua();
	                    break;
	                default:
	                    System.out.println("Bakarrik 1 eta 3 arteko zenbakiak onartzen dira...");
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("1 eta 3 arteko zenbakia sartu behar duzu...");
	            s.next();
	        }
		}
	}

	public static void grafoZuzenduenMenuaImprimatu(){
		System.out.println();
		System.out.println();
		System.out.println("/***************************************");
		System.out.println(" *           GRAFO ZUZENDUAK           *");
		System.out.println(" ***************************************/");
		System.out.println();
		System.out.println("Aukerak: ");
		System.out.println("1. Grafo Zuzendua Eraiki");
        System.out.println("2. Grafo Zuzendu Pisuduna Eraiki");
        System.out.println("3. Atzera");
	}
	
	private static void grafoEzZuzenduenMenua() {
		grafoEzZuzenduenMenuaImprimatu();
		int aukera;
		boolean ondoIrakurrita=false;
		while(!ondoIrakurrita){
			System.out.print("--> Zure aukera: ");
			try {
	            aukera = s.nextInt();
	            switch (aukera) {
	                case 1:
	                	ondoIrakurrita=true;
	                    fitxategitikGrafoaIrakurri(2);
	                    break;
	                case 2:
	                	ondoIrakurrita=true;
	                	fitxategitikGrafoaIrakurri(3);
	                    break;
	                case 3:
	                	ondoIrakurrita=true;
	                	hasierakoMenua();
	                    break;
	                default:
	                    System.out.println("Bakarrik 1 eta 3 arteko zenbakiak onartzen dira...");
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("1 eta 3 arteko zenbakia sartu behar duzu...");
	            s.next();
	        }
		}
	}

	public static void grafoEzZuzenduenMenuaImprimatu(){
		System.out.println();
		System.out.println();
		System.out.println("/***************************************");
		System.out.println(" *          GRAFO  EZ ZUZENDUAK        *");
		System.out.println(" ***************************************/");
		System.out.println();
		System.out.println("Aukerak: ");
		System.out.println("1. Grafo Ez Zuzendua Eraiki");
        System.out.println("2. Grafo Ez Zuzendu Pisuduna Eraiki");
        System.out.println("3. Atzera");
	}
	
	
	private static void fitxategitikGrafoaIrakurri(int grafoMota) {
		System.out.println();
		System.out.println();
		System.out.println("/***************************************");
		System.out.println(" *         GRAFOEN IRAKURKETA          *");
		System.out.println(" ***************************************/");
		System.out.println();	
		System.out.println("OHARRA: Grafoaren fitxategia 'GrafoFitxategiak' karpetan egon behar du");
		System.out.println();
		boolean ondoIrakurrita = false;
		int irakurketarenEmaitza;
		while (!ondoIrakurrita){
			System.out.print("Fitxategiaren izena: ");
			String fitxategiIzena = "GrafoFitxategiak/"+s.next();
			kronometroa.start();
			if (grafoMota==0){ /* Grafo Zuzendua Eraiki */
				irakurketarenEmaitza=gz.SortuGZ(fitxategiIzena);
			}else if (grafoMota==1){ /* Grafo Zuzendu Pisuduna Eraiki */
				irakurketarenEmaitza=gz.SortuGZPisuduna(fitxategiIzena);
			}else if(grafoMota==2){ /* Grafo Ez Zuzendua Eraiki */
				irakurketarenEmaitza=gez.SortuGEzZ(fitxategiIzena);
			} else { /* Grafo Ez Zuzendu Pisuduna Eraiki */
				irakurketarenEmaitza=gez.SortuGEzZPisuduna(fitxategiIzena);
			}
			if (irakurketarenEmaitza==0){
				ondoIrakurrita=true;
				kronometroa.stop();
				System.out.println("Grafoa zuzen irakurri da");
				if (grafoMota==0 || grafoMota==1){ 
					grafoZuzenduPEtaEzPMenua();
				}else if(grafoMota==2){ 
					grafoEzZuzenduEzPMenua();
				} else { 
					grafoEzZuzenduPisudunenMenua();
				}
			}else{
				System.out.println("Arazoa egon da " + fitxategiIzena + " fitxategiaren irakurketarekin");
			}
		}
	}

	private static void grafoZuzenduPEtaEzPMenua() {
		grafoZuzenduPEtaEzPMenuaImprimatu();
		int aukera;
		boolean ondoIrakurrita=false;
		while(!ondoIrakurrita){
			System.out.print("--> Zure aukera: ");
			try {
	            aukera = s.nextInt();
	            switch (aukera) {
	                case 1:
	                	ondoIrakurrita=true;
	                    kronometroa.start();
	                    System.out.println("Emaitza:");
	                    System.out.println(gz.zikloaDuG());
	                    kronometroa.stop();
	                    System.out.println();
	                    grafoZuzenduPEtaEzPMenua();
	                    break;
	                case 2:
	                	ondoIrakurrita=true;
	                    kronometroa.start();
	                    System.out.println("Emaitza:");
	                    System.out.println(gz.ordenazioTopologikoa());
	                    kronometroa.stop();
	                    System.out.println();
	                    grafoZuzenduPEtaEzPMenua();
	                    break;
	                case 3:
	                	ondoIrakurrita=true;
	                    kronometroa.start();
	                    System.out.println("Emaitza:");
	                    LinkedList<LinkedList<Integer>> zerrenda =gz.sendokiKonektatutakoOsagaiak();
	                    kronometroa.stop();
	                    for(LinkedList<Integer> z : zerrenda){
	                    	System.out.print("Osagai bat: ");
	                    	System.out.println(z.toString());
	                    }
	                    System.out.println();
	                    grafoZuzenduPEtaEzPMenua();
	                    break;
	                case 4:
	                	ondoIrakurrita=true;
	                	grafoZuzenduenMenua();
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
	
	public static void grafoZuzenduPEtaEzPMenuaImprimatu(){
		System.out.println();
		System.out.println();
		System.out.println("/***************************************");
		System.out.println(" *            GRAFO ZUZENDUAK          *");
		System.out.println(" ***************************************/");
		System.out.println();
		System.out.println("Metodoak: ");
		System.out.println("1. ZikloaDuG()");
        System.out.println("2. OrdenazioTopologikoa()");
        System.out.println("3. SendokiKonektatutakoOsagaiak()");
        System.out.println("4. Atzera");
	}
	
	private static void grafoEzZuzenduEzPMenua() {
		grafoEzZuzenduEzPMenuaImprimatu();
		int aukera;
		boolean ondoIrakurrita=false;
		while(!ondoIrakurrita){
			System.out.print("--> Zure aukera: ");
			try {
	            aukera = s.nextInt();
	            switch (aukera) {
	                case 1:
	                	ondoIrakurrita=true;
	                    kronometroa.start();
	                    System.out.println("Emaitza:");
	                    System.out.println(gez.zikloaDuGEzZ());
	                    kronometroa.stop();
	                    System.out.println();
	                    grafoEzZuzenduEzPMenua();
	                    break;
	                case 2:
	                	ondoIrakurrita=true;
	                    kronometroa.start();
	                    System.out.println("Emaitza:");
	                    LinkedList<LinkedList<Integer>> zerrenda =gez.osagaiKonexuak();
	                    kronometroa.stop();
	                    for(LinkedList<Integer> z : zerrenda){
	                    	System.out.print("Osagai bat: ");
	                    	System.out.println(z.toString());
	                    }
	                    System.out.println();
	                    grafoEzZuzenduEzPMenua();
	                    break;
	                case 3:
	                	ondoIrakurrita=true;
	                	grafoEzZuzenduenMenua();
	                    break;
	                default:
	                    System.out.println("Bakarrik 1 eta 3 arteko zenbakiak onartzen dira...");
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("1 eta 3 arteko zenbakia sartu behar duzu...");
	            s.next();
	        }
		}
	}
	
	public static void grafoEzZuzenduEzPMenuaImprimatu(){
		System.out.println();
		System.out.println();
		System.out.println("/***************************************");
		System.out.println(" *           GRAFO EZ ZUZENDUAK        *");
		System.out.println(" ***************************************/");
		System.out.println();
		System.out.println("Metodoak: ");
		System.out.println("1. ZikloaDuGEzZ()");
        System.out.println("2. OsagaiKonexuak()");
        System.out.println("3. Atzera");
	}
	
	private static void grafoEzZuzenduPisudunenMenua() {
		grafoEzZuzenduPisudunenMenuaImprimatu();
		int aukera;
		boolean ondoIrakurrita=false;
		while(!ondoIrakurrita){
			System.out.print("--> Zure aukera: ");
			try {
	            aukera = s.nextInt();
	            switch (aukera) {
	                case 1:
	                	ondoIrakurrita=true;
	                    kronometroa.start();
	                    System.out.println("Emaitza:");
	                    System.out.println(gez.zikloaDuGEzZ());
	                    kronometroa.stop();
	                    System.out.println();
	                    grafoEzZuzenduPisudunenMenua();
	                    break;
	                case 2:
	                	ondoIrakurrita=true;
	                    kronometroa.start();
	                    System.out.println("Emaitza:");
	                    LinkedList<LinkedList<Integer>> zerrenda =gez.osagaiKonexuak();
	                    kronometroa.stop();
	                    for(LinkedList<Integer> z : zerrenda){
	                    	System.out.print("Osagai bat: ");
	                    	System.out.println(z.toString());
	                    }
	                    System.out.println();
	                    grafoEzZuzenduPisudunenMenua();
	                    break;
	                case 3:
	                	String fitxIzena = null;
	                	ondoIrakurrita=true;
	                	System.out.print("Irteera fitxategiaren izena sartu ('output' karpetan kokatuko da fitxategi hau):");
	                	fitxIzena=s.next();
	                    kronometroa.start();
	                    System.out.println("Emaitza:");
	                    int emaitza=gez.HZMKruskal(fitxIzena);
	                    if(emaitza==0){
	                    	System.out.println("Medodoa zuzen exekutatu da. Emaitza 'output/"+ fitxIzena +"' fitxategian duzu.");
	                    }else{
	                    	System.out.println("Arazoa egon da metodoa exekutatzerakoan...");
	                    }
	                    kronometroa.stop();
	                    System.out.println();
	                    grafoEzZuzenduPisudunenMenua();
	                    break;
	                case 4:
	                	ondoIrakurrita=true;
	                	grafoEzZuzenduenMenua();
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
	
	public static void grafoEzZuzenduPisudunenMenuaImprimatu(){
		System.out.println();
		System.out.println();
		System.out.println("/***************************************");
		System.out.println(" *      GRAFO EZ ZUZENDU PISUDUNAK     *");
		System.out.println(" ***************************************/");
		System.out.println();
		System.out.println("Metodoak: ");
		System.out.println("1. ZikloaDuGEzZ()");
        System.out.println("2. OsagaiKonexuak()");
        System.out.println("3. HZMKruskal()");
        System.out.println("4. Atzera");
	}
}
