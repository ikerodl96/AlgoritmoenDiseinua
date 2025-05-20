import java.util.HashMap;

/**
 * Forma Normal Konjuntiboan (CNF) dauden formula boolearrak irudikatzeko Java klasea
 */
public class CNFFormula{
	private HashMap<Integer,Klausula> klausulaZerrenda;
	
	/**
	 * Metodo Eraikitzailea
	 */
	public CNFFormula(){
		this.klausulaZerrenda = new HashMap<Integer,Klausula>();
	}
	
	public boolean hutsaDa(){
		return (klausulaZerrenda.size()==0);
	}
	
	public HashMap<Integer,Klausula> getKlausulaZerrenda(){
		return klausulaZerrenda;
	}
	
	/**
	 * Formulari klausula berri bat sartzen duen metodoa. Klausula hutsik egongo da.
	 */
    public void klausulaBerriaGehitu(Klausula klausula) {
    	klausulaZerrenda.put(klausula.klausularenIDa(), klausula);
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
    public void klausulaEzabatu(Klausula klausula) {
    	klausulaZerrenda.remove(klausula.klausularenIDa());
    }

//    /**
//     * Formularen klausula baten literal bat ezabatzen duen metodoa
//     * @param klausula Formulako klausula bati erreferentzi egiten dion zenbakia
//     * @param literala Klausularen barneko literal bati erreferentzi egiten dion zenbakia
//     */
//    public void literalaEzabatu(int klausula, int literala) {
//    	klausulaZerrenda.get(klausula).remove(literala);
//    }
    
       

    public boolean formulaBetetzenDa(HashMap<Integer,Literala> esleipenak){
    	for(Klausula klausula : klausulaZerrenda.values()){
    		if(!klausula.klausulaBetetzenDa(esleipenak)){
    			return false;
    		}
    	}
    	return true;
    }
    
    public Klausula literalBakarrekoKlausulaBilatu(){
    	for(Klausula k : klausulaZerrenda.values()){
    		if(k.literalKopurua()==1){
    			return k;
    		}
    	}
    	return null;
    }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for(Klausula k : klausulaZerrenda.values()){
			sb.append(k.toString() + "y ");
		}
		if(sb.length()>3)sb.replace(sb.length()-3, sb.length()-1, ")");
		else sb.append(")");
		return sb.toString();
	}
}
