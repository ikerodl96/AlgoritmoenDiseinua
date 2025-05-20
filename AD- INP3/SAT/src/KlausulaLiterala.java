/**
 * CNF formula bateko klausulen aldagaiak irudikatzeko Java klasea
 */
public class KlausulaLiterala {
	private int literalZenbakia;
	private boolean zeinua; /* - == NOT == FALSE */
	
	/**
	 * Metodo Eraikitzailea
	 * @param aldagaia
	 * @param zeinua
	 */
	public KlausulaLiterala(int aldagaia, boolean zeinua) {
		super();
		this.literalZenbakia = aldagaia;
		this.zeinua = zeinua;
	}
	
	/**
	 * Getter eta Setterrak
	 */

	public int getLiteralZenbakia() {
		return literalZenbakia;
	}

	public void setAldagaia(int aldagaia) {
		this.literalZenbakia = aldagaia;
	}

	public boolean getZeinua() {
		return zeinua;
	}

	public void setZeinua(boolean zeinua) {
		this.zeinua = zeinua;
	}
	
	
  
}
