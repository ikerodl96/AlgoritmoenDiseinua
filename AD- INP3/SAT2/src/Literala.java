import java.util.ArrayList;


public class Literala {
	private int aldagaia;
	private int baiezkoak;
	private int ezezkoak;
	private boolean esleitutakoBalioa;
	private boolean balioaEsleituta;
	private	ArrayList<Klausula> agerpenKlausulaZerrenda;
	
	
	public Literala(int aldagaia) {
		this.aldagaia = aldagaia;
		this.baiezkoak = 0;
		this.ezezkoak = 0;
		this.balioaEsleituta = false;
		this.esleitutakoBalioa = false;
		this.agerpenKlausulaZerrenda = new ArrayList<Klausula>();
	}
	
	
	public boolean puruaDa(){
		return (baiezkoak==0 || ezezkoak==0);
	}
	
	public void baiezkoeiBatGehitu(){
		baiezkoak++;
	}
	
	public void baiezkoeiBatKendu(){
		baiezkoak--;
	}
	
	public void ezezkoeiBatGehitu(){
		ezezkoak++;
	}
	
	public void ezezkoeiBatKendu(){
		ezezkoak--;
	}
	
	public void klausulaGehitu(Klausula klausula){
		agerpenKlausulaZerrenda.add(klausula);
	}


	/* GETTER eta SETTERRAK */
	public int getAldagaia() {
		return aldagaia;
	}


	public void setAldagaia(int aldagaia) {
		this.aldagaia = aldagaia;
	}


	public int getBaiezkoak() {
		return baiezkoak;
	}


	public void setBaiezkoak(int baiezkoak) {
		this.baiezkoak = baiezkoak;
	}


	public int getEzezkoak() {
		return ezezkoak;
	}


	public void setEzezkoak(int ezezkoak) {
		this.ezezkoak = ezezkoak;
	}


	public boolean esleitutakoBalioa() {
		return esleitutakoBalioa;
	}


	public void setEsleitutakoBalioa(boolean esleitutakoBalioa) {
		this.esleitutakoBalioa = esleitutakoBalioa;
	}


	public ArrayList<Klausula> getAgerpenKlausulaZerrenda() {
		return agerpenKlausulaZerrenda;
	}


	public void setAgerpenKlausulaZerrenda(ArrayList<Klausula> agerpenKlausulaZerrenda) {
		this.agerpenKlausulaZerrenda = agerpenKlausulaZerrenda;
	}

	public boolean balioaEsleituta() {
		return balioaEsleituta;
	}
	
	public void setBalioaEsleituta(boolean balioaEsleituta) {
		this.balioaEsleituta = balioaEsleituta;
	}
}
