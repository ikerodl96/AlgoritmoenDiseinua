import java.util.LinkedList;


public class Erpina {
	private int erpinZenbakia;
	private boolean aztertua;
	private LinkedList<Arkua> arkuZerrenda;
	/* Grafo ez zuzenduetan zikloa bilatzeko */
	private int gurasoa;
	/* Grafo zuzenduetan zikloa bilatzeko */
	private int kolorea; /* 0: zuria, 1: grisa, 2: beltza */
	
	/* Metodo Eraikitzailea */
	public Erpina (int erpinZenbakia){
		this.erpinZenbakia=erpinZenbakia;
		this.aztertua=false;
		this.arkuZerrenda= new LinkedList<Arkua>();
		this.gurasoa=-1;
		this.kolorea=0;
	}
	
	/* Arku zerrendari arku bat gehitzeko */
	public void arkuaGehitu(Arkua arkua){
		arkuZerrenda.add(arkua);
	}
	
	/* Getter eta Setterrak */	
	public int getErpinZenbakia() {
		return erpinZenbakia;
	}
	
	public void setErpinZenbakia(int erpinZenbakia) {
		this.erpinZenbakia = erpinZenbakia;
	}
	
	public boolean isAztertua() {
		return aztertua;
	}
	
	public void setAztertua(boolean aztertua) {
		this.aztertua = aztertua;
	}

	public LinkedList<Arkua> getArkuZerrenda() {
		return arkuZerrenda;
	}

	public void setArkuZerrenda(LinkedList<Arkua> arkuZerrenda) {
		this.arkuZerrenda = arkuZerrenda;
	}

	public int getGurasoa() {
		return gurasoa;
	}

	public void setGurasoa(int gurasoa) {
		this.gurasoa = gurasoa;
	}

	public int getKolorea() {
		return kolorea;
	}

	public void setKolorea(int kolorea) {
		this.kolorea = kolorea;
	}
	
}
