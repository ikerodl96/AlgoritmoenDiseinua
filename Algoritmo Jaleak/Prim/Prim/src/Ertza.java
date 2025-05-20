
public class Ertza {
	private int jatorriErpina;
	private int helmugaErpina;
	private double pisua;
	
	/* Metodo Eraikitzailea */
	public Ertza (int jatorriErpina, int helmugaErpina, double pisua){
		this.jatorriErpina=jatorriErpina;
		this.helmugaErpina=helmugaErpina;
		this.pisua=pisua;
	}
	
	/* Getter eta Setterrak */
	public int getHelmugaErpinZenbakia() {
		return helmugaErpina;
	}
	public void setHelmugaErpina(int helmugaErpina) {
		this.helmugaErpina = helmugaErpina;
	}
	public double getPisua() {
		return pisua;
	}
	public void setPisua(double pisua) {
		this.pisua = pisua;
	}

	public int getJatorriErpinZenbakia() {
		return jatorriErpina;
	}

	public void setJatorriErpina(int jatorriErpina) {
		this.jatorriErpina = jatorriErpina;
	}
	
}
