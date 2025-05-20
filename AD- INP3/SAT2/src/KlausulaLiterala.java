/**
 * CNF formula bateko klausulen aldagaiak irudikatzeko Java klasea
 */
public class KlausulaLiterala {
	private int aldagaia;
	private boolean zeinua; /* - == NOT */
	
	/**
	 * Metodo Eraikitzailea
	 * @param aldagaia
	 * @param zeinua
	 */
	public KlausulaLiterala(int aldagaia, boolean zeinua) {
		this.aldagaia = aldagaia;
		this.zeinua = zeinua;
	}
	
	/**
	 * Getter eta Setterrak
	 */

	public int getAldagaia() {
		return aldagaia;
	}

	public void setAldagaia(int aldagaia) {
		this.aldagaia = aldagaia;
	}

	public boolean getZeinua() {
		return zeinua;
	}

	public void setZeinua(boolean zeinua) {
		this.zeinua = zeinua;
	}  
}
