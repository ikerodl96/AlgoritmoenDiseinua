import java.util.LinkedList;


public class Literala {
	private int aldagaia;
	private int baiezkoak;
	private int ezezkoak;
	private boolean esleitutakoBalioa;
	private	LinkedList<Integer> agerpenKlausulaZerrenda;
	
	
	public Literala(int aldagaia) {
		this.aldagaia = aldagaia;
		this.baiezkoak = 0;
		this.ezezkoak = 0;
		this.esleitutakoBalioa = false;
		this.agerpenKlausulaZerrenda = new LinkedList<Integer>();
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
	
	public void klausulaGehitu(Integer klausula){
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


	public LinkedList<Integer> getAgerpenKlausulaZerrenda() {
		return agerpenKlausulaZerrenda;
	}


	public void setAgerpenKlausulaZerrenda(LinkedList<Integer> agerpenKlausulaZerrenda) {
		this.agerpenKlausulaZerrenda = agerpenKlausulaZerrenda;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aldagaia;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		Literala literala = (Literala) obj;
		if(literala.getAldagaia()==this.aldagaia){
			return true;
		}else{
			return false;
		}
	}
}
