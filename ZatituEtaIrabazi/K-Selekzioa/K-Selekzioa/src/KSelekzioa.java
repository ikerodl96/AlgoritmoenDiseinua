public class KSelekzioa {
	
	public int banaketa(int [] v, int hasiera, int amaiera){
		int i1=hasiera;
		int i2=amaiera;
		//v[hasiera] pibotea da
		while (i1<i2){
			while (v[i1]<=v[hasiera] && i1<i2) i1++;
			while (v[i2]>v[hasiera]) i2--;
			if (i1<i2){
				swap(v, i1, i2);
				i1++;
				i2--;
			}
		}
		swap(v, hasiera, i2);
		return i2;
	}
	
	public int banaketa2(int []v, int hasiera, int amaiera){
		//amaiera=v.length-1
		int pibotea=v[hasiera];
		int banaketaPuntua=hasiera;
		for(int i=hasiera+1; i<=amaiera;i++){
			if(v[i]<pibotea){
				banaketaPuntua++;
				swap(v,banaketaPuntua,i);
			}
		}
		swap(v, hasiera, banaketaPuntua);
		return banaketaPuntua;
	}
	
	public void swap (int [] v, int i, int j){
		try{
			int aux;
			aux=v[i];
			v[i]=v[j];
			v[j]=aux;
		}catch(Exception e){
			System.out.println("Array hutsa");
		}
	}
	
	public int kSelekzioa(int [] v, int hasiera, int amaiera, int k){
		// s = k-ren posizio erlatiboa bektorean
		int s = hasiera+k-1;
		if (amaiera-hasiera+1 == 1){
			return v[hasiera];
		}else{
			int b = banaketa(v,hasiera,amaiera);
			if (s==b) return v[s];
			else if (b<s) return kSelekzioa(v, b+1, amaiera, s-b);
			else return kSelekzioa(v, hasiera, b-1, k);
		}
	}
	
}
