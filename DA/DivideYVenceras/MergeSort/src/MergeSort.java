public class MergeSort {
	
	/** 
	 * Procedimiento que dado un vector de enteros v y dos índices del mismo,
	 * ordena ascendentemente los enteros comprendidos entre los dos índices.
	 * 
	 * @param	v	Vector de enteros
	 * @param	inicio	Índice asociado al vector v (0<=inicio<=v.length-1)
	 * @param	fin	Índice asociado al vector v (0<=inicio<=fin<=v.length-1)
	 */
	public void ordenPorMezcla(int [] v, int inicio, int fin){
		if (inicio < fin){
			ordenPorMezcla(v, inicio, (inicio+fin)/2);
			ordenPorMezcla(v, ((inicio+fin)/2)+1, fin);
			mezcla(v,inicio,(inicio+fin)/2, fin);
		}
	}
	
	/**
	 * Procedimiento que dado un vector v para el cual se cumple que v[inicio..centro]
	 * y v[centro+1..fin] están ordenados, devuelve el vector v con todos sus elementos
	 * ordenados ascendentemente.
	 * 
	 * @param	v	Vector de enteros
	 * @param	inicio	Índice de inicio del vector v 
	 * @param	fin	Índice de fin del vector v (inicio<=fin)
	 * @param	centro	Índice del centro del vector v ((inicio+fin)/2), siendo 
	 * (inicio<=centro<=fin)
	 */
	public void mezcla(int [] v, int inicio, int centro, int fin){
		int [] laMezcla = new int[v.length];
		int izda = inicio;
		int dcha = centro+1;
		int indice = inicio;
		while ((izda<=centro) && (dcha<=fin)){
			if(v[izda]<=v[dcha]){
				laMezcla[indice] = v[izda];
				izda++;
			}else{
				laMezcla[indice] = v[dcha];
				dcha++;
			}
			indice++;
		}
		if (izda>centro){
			// laMezcla[indice..fin] = v[dcha..fin]
			copiarContenido(v, laMezcla, dcha, fin, indice, fin);
		}else{
			// laMezcla[indice..fin] = v[izda..centro]
			copiarContenido(v, laMezcla, izda, centro, indice, fin);
		}
		// laMezcla[inicio..fin] = v[inicio..fin]
		copiarContenido(laMezcla, v, inicio, fin, inicio, fin);
	}
	
	/**
	 * Procedimiento que copia el contenido de v[iniciov..finv] en u[iniciou..finu].
	 * Es decir, u[iniciou..finu]=v[iniciov..finv]. Por lo tanto, se cumple que:
	 * (finv-iniciov)=(finu-iniciou)
	 * 
	 * @param	v	Vector de enteros origen (contiene los datos a copiar)
	 * @param	u	Vector de enteros destino (donde se copiarán los datos)
	 * @param	iniciov Índice de inicio del vector v
	 * @param	finv	Índice de fin del vector v (iniciov<finv)
	 * @param	iniciou Índice de inicio del vector u
	 * @param	finu	Índice de fin del vector u (iniciou<finu)
	 */
	public void copiarContenido(int[] v, int[] u, int iniciov,
			int finv, int iniciou, int finu) {
		for(int i=iniciou, j=iniciov; i<=finu && j<=finv; i++, j++){
			u[i]=v[j];
		}
	}
}
