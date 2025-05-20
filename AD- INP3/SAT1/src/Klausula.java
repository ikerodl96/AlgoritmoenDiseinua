import java.util.HashMap;
import java.util.HashSet;


public class Klausula {
	private HashSet<KlausulaLiterala> literalZerrenda;
	private int id;
	
	public Klausula(int id){
		this.literalZerrenda =  new HashSet<KlausulaLiterala>();
		this.id = id;
	}
	
	public int klausularenIDa(){
		return id;
	}
	
	public boolean hutsaDa(){
		return (literalZerrenda.size()==0);
	}
	
	public void literalaGehitu(KlausulaLiterala literala){
		literalZerrenda.add(literala);
	}
	
	public KlausulaLiterala getLehenengoLiterala(){
		return literalZerrenda.iterator().next();
	}

	public boolean klausulaLiteralaDago(KlausulaLiterala klausulaLiterala){
		return literalZerrenda.contains(klausulaLiterala);
	}
	
	public void klausulaLiteralaEzabatu(KlausulaLiterala klausulaLiterala){
		literalZerrenda.remove(klausulaLiterala);
	}
	
    public boolean klausulaBetetzenDa(HashMap<Integer,Literala> esleipenak){
    	for(KlausulaLiterala literala : literalZerrenda){
			if(esleipenak.get(literala.getAldagaia())!=null && esleipenak.get(literala.getAldagaia()).esleitutakoBalioa()==literala.getZeinua()){
				return true;
			}
		}
    	return false;
    }
    
    public HashSet<KlausulaLiterala> getKlausularenLiteralZerrenda(){
    	return literalZerrenda;
    }
    
    public int literalKopurua(){
    	return literalZerrenda.size();
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Klausula other = (Klausula) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public void setLiteralZerrenda(HashSet<KlausulaLiterala> literalZerrenda) {
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
