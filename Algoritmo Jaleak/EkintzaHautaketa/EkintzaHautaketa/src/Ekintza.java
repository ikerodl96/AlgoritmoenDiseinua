import java.util.Date;


public class Ekintza {
	private Date hasieraOrdua;
	private Date amaieraOrdua;
	
	public Ekintza(Date hasieraOrdua, Date amaieraOrdua) {
		this.hasieraOrdua = hasieraOrdua;
		this.amaieraOrdua = amaieraOrdua;
	}
	public Date getHasieraOrdua() {
		return hasieraOrdua;
	}
	public void setHasieraOrdua(Date hasieraOrdua) {
		this.hasieraOrdua = hasieraOrdua;
	}
	public Date getAmaieraOrdua() {
		return amaieraOrdua;
	}
	public void setAmaieraOrdua(Date amaieraOrdua) {
		this.amaieraOrdua = amaieraOrdua;
	}
	
}
