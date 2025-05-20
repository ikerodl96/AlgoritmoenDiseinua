import java.util.LinkedList;


public class Erpina {
	private int erpinZenbakia;
	private boolean aztertua;
	private LinkedList<Ertza> ertzZerrenda;
	
	public Erpina(int erpinZenbk){
		this.erpinZenbakia=erpinZenbk;
		this.aztertua=false;
		this.ertzZerrenda=new LinkedList<Ertza>();
	}

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

	public LinkedList<Ertza> getErtzZerrenda() {
		return ertzZerrenda;
	}

	public void setErtzZerrenda(LinkedList<Ertza> ertzZerrenda) {
		this.ertzZerrenda = ertzZerrenda;
	}
	
	public void ertzaGehitu(Ertza e){
		ertzZerrenda.add(e);
	}
	
	public void ertzZerrendatikEzabatu(Ertza e){
		ertzZerrenda.remove(e);
	}
}
