public class SeleccionK {
	
	/**
	 * Procedimiento que permuta los elementos del vector v, devolviendo un índice i (dentro
	 * del rango de v) de manera que todos los elementos en posiciones inferiores a la i son 
	 * menores o iguales que v[i] y todos los elementos en posiciones superiores a la i son
	 * mayores que v[i].
	 * 
	 * @param v	Vector de enteros
	 * @param	inicio	Índice de inicio asociado al vector v (0<=inicio<=v.length-1)
	 * @param	fin	Índice de fin asociado al vector v (0<=inicio<=fin<=v.length-1)
	 * @return	Índice i que cumple lo indicado anteriormente (inicio<=i<=fin)
	 */
	public int particion(int [] v, int inicio, int fin){
		int pivote = v[inicio];
		int izda = inicio;
		int dcha = fin;
		int aux;
		while (izda < dcha){
			while (v[izda]<=pivote) izda++;
			while (v[dcha]>pivote) dcha--;
			if (izda < dcha){
				/* swap v[izda]=v[dcha] */
				aux = v[dcha];
				v[dcha] = v[izda];
				v[izda] = aux;
			}
		}
		/* swap v[inicio]=v[dcha] */
		v[inicio] = v[dcha];
		v[dcha] = pivote;
		return dcha;
	}
	
	/**
	 * Procedimiento que dado un vector de enteros, sus índices de inicio y fin y un 
	 * entero k, devuelve el elemento k-ésimo más grande del vector.
	 * 
	 * @param v	Vector de enteros NO vacio
	 * @param k	Es un entero que, suponiendo que el vector v estuviera ordenado ascendentemente,
	 * hace referencia al elemento que se encuentra en dicha 'posición' (k-1). Es decir, el k más
	 * grande del vector.
	 * Precondición: inicio+1<=k<=fin+1, ya que el primer índice de los vectores es 0
	 * @param	inicio	Índice de inicio asociado al vector v (0<=inicio<=v.length-1)
	 * @param	fin	Índice de fin asociado al vector v (0<=inicio<=fin<=v.length-1)
	 * @return	Entero que viene a ser el k-ésimo mayor elemento del vector v
	 */
	public int seleccionK (int [] v, int k, int inicio, int fin){
		/* s es el índice k pero relativo al vector v[inicio..fin] (k es el índice relativo a v[0..v.length-1]) */
		int s = inicio+k-1;
		int p;
		if (inicio==fin){
			return v[inicio];
		}else{
			p = particion(v,inicio,fin);
			if (p==s) return v[p];
			/* El elemento a devolver está en la parte izquierda */
			else if (p<s) return seleccionK(v, s-p, p+1, fin);
			/* El elemento a devolver está en la parte derecha */
			else return seleccionK(v, k, inicio, p-1);
		}
	}
}
