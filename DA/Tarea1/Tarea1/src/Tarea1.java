
public class Tarea1 {
	
	public static void SegMaxSumaH(int [] v){
		int maxSuma = v[0];
		int inicio = 0;
		int fin = 0;
		for(int i = 0; i<v.length; i++){
			for(int j=i; j<v.length; j++){
				int suma=0;
				for(int k=i; k<=j;k++){
					suma=suma+v[k];
				}
				if (suma > maxSuma) {
					maxSuma=suma;
					inicio=i;
					fin=j;
				}
			}
		}
		System.out.println(maxSuma + ", " + inicio + ", " + fin);
	}
	
	public static void SegMaxSumaHMejorado(int [] v){
		int maxSuma = v[0];
		int inicio = 0;
		int fin = 0;
		int suma;
		for(int i=0; i<v.length; i++){
			suma=0;
			for(int j=i; j<v.length; j++){
				suma = suma + v[j];
				if (suma>maxSuma){
					maxSuma = suma;
					inicio = i;
					fin = j;
				}
			}
		}
		System.out.println(maxSuma + ", " + inicio + ", " + fin);
	}
	
	public static void main(String[] args) {
		//int v[] = {9,-1,3,4,5,0,-1};
		int v[] = {-2, 1, -3, 4,-1, 2, 1,-5,4};
		SegMaxSumaHMejorado(v);
	}

}
