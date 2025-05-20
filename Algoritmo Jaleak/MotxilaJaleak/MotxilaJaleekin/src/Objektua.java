public class Objektua{
	private int pisua;
	private int balioa;
	private double proportzioa;
	private double zenbatEraman;
	
	public Objektua(int pisua, int balioa){
		this.pisua=pisua;
		this.balioa=balioa;
		this.proportzioa=0;
		this.zenbatEraman=0;
	}

	public int getPisua() {
		return pisua;
	}

	public void setPisua(int pisua) {
		this.pisua = pisua;
	}

	public int getBalioa() {
		return balioa;
	}

	public void setBalioa(int balioa) {
		this.balioa = balioa;
	}

	public double getProportzioa() {
		return proportzioa;
	}

	public void setProportzioa(double proportzioa) {
		this.proportzioa = proportzioa;
	}

	public double getZenbatEraman() {
		return zenbatEraman;
	}

	public void setZenbatEraman(double zenbatEraman) {
		this.zenbatEraman = zenbatEraman;
	}

	@Override
	public String toString() {
		return "Objektua [pisua=" + pisua + ", balioa=" + balioa
				+ ", proportzioa=" + proportzioa + ", zenbatEraman="
				+ zenbatEraman + "]";
	}
}
