import java.util.ArrayList;
import java.util.HashMap;

/**
 * Forma Normal Konjuntiboan (CNF) dauden formula boolearrak irudikatzeko Java klasea
 */
public class CNFFormula {
	ArrayList<Klausula> klausulaZerrenda;
	
	/**
	 * Metodo Eraikitzailea
	 */
	public CNFFormula(){
		klausulaZerrenda = new ArrayList<Klausula>();
	}
	
	/**
	 * Formulari klausula berri bat sartzen duen metodoa. Klausula hutsik egongo da.
	 */
    public void klausulaBerriaGehitu(Klausula klausula) {
    	klausulaZerrenda.add(klausula);
    }

//    /**
//     * Formularen azkeneko klausulari literal bat gehitzen dion metodoa.
//     * @param aldagaia Literala irudikatzeko erabiltzen den zenbakia
//     * @param zeinua Adagaiaren zeinua
//     */
//    public void azkenengoKlausulariLiteralaGehitu(int aldagaia, boolean zeinua) {
//    	klausulaZerrenda.get(klausulaZerrenda.size()-1).add(new KlausulaLiterala(aldagaia, zeinua));
//    }
    

//    /**
//     * Formularen klausula bati literal bat gehitzen dion metodoa.
//     * @param klausula Literala formulako zein klausulari gehitu behar zaion adierazten duen zenbakia
//     * @param aldagaia Literala irudikatzeko erabiltzen den zenbakia
//     * @param zeinua Aldagaiaren zeinua
//     */
//    public void literalaGehitu(int klausula, int aldagaia, boolean zeinua) {
//    	klausulaZerrenda.get(klausula).add(new KlausulaLiterala(aldagaia, zeinua));
//    }

//    /**
//     * Formulak zenbat klausula dituen bueltatzen duen metodoa
//     */
//    public int zenbatKlausula() {
//    	return klausulaZerrenda.size();
//    }

//    /**
//     * Formularen klausula baten tamaina (literal kopurua) bueltatzen duen metodoa
//     * @param klausula Formulako klausula bati erreferentzi egiten dion zenbakia
//     */
//    public int zenbatLiteral(int klausula) {
//    	return klausulaZerrenda.get(klausula).size();
//    }

    /**
     * Formularen klausula bat ezabatzen duen metodoa
     * @param klausula Formulako klausula bati (ezabatu nahi duguna) erreferentzi egiten dion zenbakia
     */
    public void klausulaEzabatu(ArrayList<KlausulaLiterala> klausula) {
    	klausulaZerrenda.remove(klausula);
    }

//    /**
//     * Formularen klausula baten literal bat ezabatzen duen metodoa
//     * @param klausula Formulako klausula bati erreferentzi egiten dion zenbakia
//     * @param literala Klausularen barneko literal bati erreferentzi egiten dion zenbakia
//     */
//    public void literalaEzabatu(int klausula, int literala) {
//    	klausulaZerrenda.get(klausula).remove(literala);
//    }
    
       

    public boolean formulaBetetzenDa(Esleipenak esleipenak){
    	for(Klausula klausula : klausulaZerrenda){
    		if(!klausula.klausulaBetetzenDa(esleipenak)){
    			return false;
    		}
    	}
    	return true;
    }
}
