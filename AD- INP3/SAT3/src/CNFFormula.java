import java.util.ArrayList;

/**
 * Forma Normal Konjuntiboan (CNF) dauden formula boolearrak irudikatzeko Java klasea
 */
public class CNFFormula {
	ArrayList<ArrayList<Literala>> klausulaZerrenda;
	
	/**
	 * Metodo Eraikitzailea
	 */
	public CNFFormula(){
		klausulaZerrenda = new ArrayList<ArrayList<Literala>>();
	}
	
	/**
	 * Formulari klausula berri bat sartzen duen metodoa. Klausula hutsik egongo da.
	 */
    public void klausulaBerriaGehitu() {
    	klausulaZerrenda.add(new ArrayList<Literala>());
    }

    /**
     * Formularen azkeneko klausulari literal bat gehitzen dion metodoa.
     * @param aldagaia Literala irudikatzeko erabiltzen den zenbakia
     * @param zeinua Adagaiaren zeinua
     */
    public void azkenengoKlausulariLiteralaGehitu(int aldagaia, boolean zeinua) {
    	klausulaZerrenda.get(klausulaZerrenda.size()-1).add(new Literala(aldagaia, zeinua));
    }
    

    /**
     * Formularen klausula bati literal bat gehitzen dion metodoa.
     * @param klausula Literala formulako zein klausulari gehitu behar zaion adierazten duen zenbakia
     * @param aldagaia Literala irudikatzeko erabiltzen den zenbakia
     * @param zeinua Aldagaiaren zeinua
     */
    public void literalaGehitu(int klausula, int aldagaia, boolean zeinua) {
    	klausulaZerrenda.get(klausula).add(new Literala(aldagaia, zeinua));
    }

    /**
     * Formulak zenbat klausula dituen bueltatzen duen metodoa
     */
    public int zenbatKlausula() {
    	return klausulaZerrenda.size();
    }

    /**
     * Formularen klausula baten tamaina (literal kopurua) bueltatzen duen metodoa
     * @param klausula Formulako klausula bati erreferentzi egiten dion zenbakia
     */
    public int zenbatLiteral(int klausula) {
    	return klausulaZerrenda.get(klausula).size();
    }

    /**
     * Formularen klausula bat ezabatzen duen metodoa
     * @param klausula Formulako klausula bati (ezabatu nahi duguna) erreferentzi egiten dion zenbakia
     */
    public void klausulaEzabatu(int klausula) {
    	klausulaZerrenda.remove(klausula);
    }

    /**
     * Formularen klausula baten literal bat ezabatzen duen metodoa
     * @param klausula Formulako klausula bati erreferentzi egiten dion zenbakia
     * @param literala Klausularen barneko literal bati erreferentzi egiten dion zenbakia
     */
    public void literalaEzabatu(int klausula, int literala) {
    	klausulaZerrenda.get(klausula).remove(literala);
    }
    
       
    /**
     * CNF formula aldagaiei esleitutako balioekin betetzen den ala ez adierazten duen metodoa
     * @param esleipenak Aldagai boolear bakoitzari esleitu zaion balioa (true edo false) jasotzen duen bektorea
     * @return TRUE formula betetzen bada eta FALSE betetzen ez bada
     */
    public boolean formulaBetetzenDa(boolean[] esleipenak){
    	for(ArrayList<Literala> klausula : klausulaZerrenda){
    		if(!klausulaBetetzenDa(klausula, esleipenak)){
    			return false;
    		}
    	}
    	return true;
    }
    
    /**
     * Parametro bidez jasotako klausula aldagaiei esleitutako balioekin betetzen den ala ez adierazten duen metodoa
     * @param klausula Klausula irudikatzen duen zerrenda
     * @param esleipenak Aldagai boolear bakoitzari esleitu zaion balioa (true edo false) jasotzen duen bektorea
     * @return TRUE klausula betetzen bada eta FALSE betetzen ez bada
     */
    private boolean klausulaBetetzenDa(ArrayList<Literala> klausula, boolean[] esleipenak){
    	for(Literala literala : klausula){
			if(esleipenak[literala.getAldagaia()]==literala.getZeinua()){
				return true;
			}
		}
    	return false;
    }
}
