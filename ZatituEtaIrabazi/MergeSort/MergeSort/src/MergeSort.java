
public class MergeSort {
	
	public void mergeSort (int [] v, int hasiera, int amaiera){
		int erdia;
		if (hasiera < amaiera){
			erdia = (hasiera+amaiera)/2;
			mergeSort(v, hasiera, erdia);
			mergeSort(v, erdia+1, amaiera);
			merge(v, hasiera, erdia, amaiera);
		}
	}

	private void merge(int[] v, int hasiera, int erdia, int amaiera) {
		int i1, i2, iaux;
		int [] vaux = new int[v.length];
		i1=hasiera;
		i2=erdia+1;
		iaux=hasiera;
		while ((i1<=erdia) && (i2<=amaiera)){
			if(v[i1]<=v[i2]){
				vaux[iaux]=v[i1];
				i1++;
			}else{
				vaux[iaux]=v[i2];
				i2++;
			}
			iaux++;
		}
		if (i1==erdia+1){ 
			//vaux[i3..amaiera]=v[i2..amaiera]
			kopiatu(v, i2, amaiera, vaux, iaux);
		}else{
			kopiatu(v, i1, erdia, vaux, iaux);
		}
		kopiatu(vaux, hasiera, amaiera, v, hasiera);
	}

	private void kopiatu(int[] jatorria, int hasieraInd, int amaieraInd, int[] kopia, int kopiaInd) {
		for(int i=hasieraInd; i<=amaieraInd; i++){
			kopia[kopiaInd]=jatorria[i];
			kopiaInd++;
		}
	}
	
}
