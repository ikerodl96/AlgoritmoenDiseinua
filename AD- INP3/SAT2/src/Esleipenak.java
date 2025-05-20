
public class Esleipenak {
	private Literala[] literalak;
	int balioaKenduZaionAzkenAldagaia;
	
	public Esleipenak (int literalKopurua){
		literalak = new Literala[literalKopurua];
		balioaKenduZaionAzkenAldagaia = -1;
	}
	
	public void literalaGehitu(Literala literala){
		literalak[literala.getAldagaia()-1] = literala;
	}
	
	public Literala getLiterala(int literala){
		return literalak[literala-1];
	}
	
	public Literala baliogabekoHurrengoLiterala(){
		int i=0;
		while(i<literalak.length && literalak[i].balioaEsleituta()){
			i++;
		}
		if(i==literalak.length){
			return null;
		}else{
			return literalak[i];
		}
	}
	
	public Literala[] getLiteralak(){
		return literalak;
	}
	
}
