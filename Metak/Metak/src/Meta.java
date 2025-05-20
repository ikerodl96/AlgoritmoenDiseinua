import java.util.Arrays;

public class Meta {
	private int[] bektorea;
	
	public void metaEraiki (int [] v){
		bektorea=v;
		//metaEraikiAzaleratuz();
		metaEraikiHondoratuz();
	}
	
	public void azaleratu(int indizea){
		int i=indizea;
		int aux;
		while (bektorea[i]>bektorea[i/2]){
			aux=bektorea[i];
			bektorea[i]=bektorea[i/2];
			bektorea[i/2]=aux;
			i=i/2;
		}
	}
	
	public void azaleratu(int indizea, int hasiera, int amaiera){
		int i=indizea;
		int aux;
		while ((hasiera<indizea) && (bektorea[i]>bektorea[i/2])){
			aux=bektorea[i];
			bektorea[i]=bektorea[i/2];
			bektorea[i/2]=aux;
			i=i/2;
		}
	}
	
	public void hondoratu(int indizea){
		int i=indizea;
		boolean jarraitu = true;
		int aux, umeMax;
		while (((2*i)<bektorea.length) && jarraitu){
			if ((2*i)<(bektorea.length-1) && (bektorea[2*i]<bektorea[(2*i)+1])){
				umeMax=(2*i)+1;
			}else{
				umeMax=(2*i);
			}
			if(bektorea[i]<bektorea[umeMax]){
				aux=bektorea[i];
				bektorea[i]=bektorea[umeMax];
				bektorea[umeMax]=aux;
				i=umeMax;
			}else{
				jarraitu = false;
			}
		}
	}
	
	public void metaEraikiAzaleratuz(){
		for(int i=1; i<bektorea.length; i++){
			azaleratu(i, 0, i);
		}
	}
	
	public void metaEraikiHondoratuz(){
		int i=(bektorea.length-1)/2;
		while (i>=0){
			hondoratu(i);
			i--;
		}
	}
	
	public void print(){
		System.out.println(Arrays.toString(bektorea));
	}
}
