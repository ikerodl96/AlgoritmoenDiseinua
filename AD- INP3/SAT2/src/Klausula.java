import java.util.ArrayList;


public class Klausula {
	private ArrayList<KlausulaLiterala> literalZerrenda;
	
	public Klausula (){
		literalZerrenda =  new ArrayList<KlausulaLiterala>();
	}
	
	public void literalaGehitu(KlausulaLiterala literala){
		literalZerrenda.add(literala);
	}
	
    public boolean klausulaBetetzenDa(Esleipenak esleipenak){
    	for(KlausulaLiterala literala : literalZerrenda){
			if(esleipenak.getLiterala(literala.getAldagaia()).balioaEsleituta() &&
					esleipenak.getLiterala(literala.getAldagaia()).esleitutakoBalioa()==literala.getZeinua()){
				return true;
			}
		}
    	return false;
    }

}
