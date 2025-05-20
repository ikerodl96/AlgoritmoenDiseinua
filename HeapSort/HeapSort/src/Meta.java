import java.util.Arrays;

// MAXIMOAREN PROPIETATEA BETETZEN DUEN META
public class Meta {
	
	public void metaEraikiHondoratuz(int[] v){
		for(int i=(v.length-1)/2; i>=0; i--){
			hondoratu(v,i, v.length-1);
		}
	}
	
	public void hondoratu(int [] v,int indizea, int tamaina){
		int i = indizea;
		int aux;
		boolean jarraitu=true;
		while (((2*i)+1)<=(tamaina) && jarraitu){
			int umeMax=(2*i)+1;
			if (((2*i)+2)<=(tamaina) && v[(2*i)+2]>v[(2*i)+1]){
				umeMax=(2*i)+2;
			}
			if(v[i]<v[umeMax]){
				aux=v[i];
				v[i]=v[umeMax];
				v[umeMax]=aux;
				i=umeMax;
			}else{
				jarraitu=false;
			}
		}
	}
	
	public void heapsort(int[] v){
		metaEraikiHondoratuz(v);
		System.out.println(Arrays.toString(v));
		int amaiera=v.length-1;
		for(int i=v.length-1; i>0; i--){
			swap(v,0,i);
			System.out.println(Arrays.toString(v));
			amaiera--;
			hondoratu(v, 0, amaiera);
		}
	}

	private void swap(int[] v, int i, int i2) {
		int aux;
		aux=v[i];
		v[i]=v[i2];
		v[i2]=aux;
	}
	
}
