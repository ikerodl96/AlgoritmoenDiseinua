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


	public boolean getZeinua() {
		return zeinua;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aldagaia;
		result = prime * result + (zeinua ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KlausulaLiterala other = (KlausulaLiterala) obj;
		if (aldagaia != other.aldagaia)
			return false;
		if (zeinua != other.zeinua)
			return false;
		return true;
	}

	@Override
	public String toString() {
		if(zeinua){
			return "+" + aldagaia;
		}else{
			return "-" + aldagaia;
		}
	}  
}
