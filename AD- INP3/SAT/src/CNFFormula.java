import java.util.Arrays;
import java.util.LinkedList;

/**
 * Forma Normal Konjuntiboan (CNF) dauden formula boolearrak irudikatzeko Java klasea
 */
public class CNFFormula {
	LinkedList<Klausula> klausulaZerrenda;
	
	/**
	 * Metodo Eraikitzailea
	 */
	public CNFFormula(){
		klausulaZerrenda = new LinkedList<Klausula>();
	}
	
	/**
	 * Formulari klausula berri bat (parametroz pasatzen dena) sartzen dion metodoa.
	 */
    public void klausulaBerriaGehitu(Klausula klausula) {
    	klausulaZerrenda.add(klausula);
    }
       
    /**
     * CNF formula aldagaiei esleitutako balioekin betetzen den ala ez adierazten duen metodoa
     * @param esleipenak Aldagai boolear bakoitzari esleitu zaion balioa (true edo false) jasotzen duen bektorea
     * @return TRUE formula betetzen bada eta FALSE betetzen ez bada
     */
    public boolean formulaBetetzenDa(boolean[] esleipenak){
    	System.out.println("fbd"+Arrays.toString(esleipenak));
    	for(Klausula klausula : klausulaZerrenda){
    		if(!klausulaBetetzenDa(klausula, esleipenak)){
    			return false;
    		}
    	}
    	System.out.println("true");
    	return true;
    }
    
    /**
     * Parametro bidez jasotako klausula aldagaiei esleitutako balioekin betetzen den ala ez adierazten duen metodoa
     * @param klausula Klausula irudikatzen duen zerrenda
     * @param esleipenak Aldagai boolear bakoitzari esleitu zaion balioa (true edo false) jasotzen duen bektorea
     * @return TRUE klausula betetzen bada eta FALSE betetzen ez bada
     */
    private boolean klausulaBetetzenDa(Klausula klausula, boolean[] esleipenak){
    	for(KlausulaLiterala literala : klausula.getKlausularenLiteralZerrenda()){
			if(esleipenak[literala.getLiteralZenbakia()-1]==literala.getZeinua()){
				return true;
			}
		}
    	return false;
    }
}
