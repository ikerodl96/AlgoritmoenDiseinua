import java.util.LinkedList;
/**
 * CNF formula bateko klausulak irudikatzeko Java klasea
 */

public class Klausula {
	private LinkedList<KlausulaLiterala> literalZerrenda;
	
	/**
	 * Metodo eraikitzailea
	 */
	public Klausula(){
		this.literalZerrenda =  new LinkedList<KlausulaLiterala>();
	}
	
	
	/**
	 * Bestelako Metodoak
	 */
	
	public boolean hutsaDa(){
		return (literalZerrenda.size()==0);
	}
	
	public void literalaGehitu(KlausulaLiterala literala){
		literalZerrenda.add(literala);
	}
	
	/**
	 * Getter eta Setterrak
	 */
	
    public LinkedList<KlausulaLiterala> getKlausularenLiteralZerrenda(){
    	return literalZerrenda;
    }

	public void setLiteralZerrenda(LinkedList<KlausulaLiterala> literalZerrenda) {
		this.literalZerrenda = literalZerrenda;
	}
	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		for(KlausulaLiterala kl : literalZerrenda){
			sb.append(kl.toString() + " v ");
		}
		if(sb.length()>3)sb.replace(sb.length()-3, sb.length()-1, ")");
		else sb.append(")");
		//sb.append(")");
		return sb.toString();
	}
	
}
