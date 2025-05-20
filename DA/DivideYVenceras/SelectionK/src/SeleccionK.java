public class SeleccionK {
	
	/**
	 * Procedimiento que permuta los elementos del vector v, devolviendo un �ndice i (dentro
	 * del rango de v) de manera que todos los elementos en posiciones inferiores a la i son 
	 * menores o iguales que v[i] y todos los elementos en posiciones superiores a la i son
	 * mayores que v[i].
	 * 
	 * @param v	Vector de enteros
	 * @param	inicio	�ndice de inicio asociado al vector v (0<=inicio<=v.length-1)
	 * @param	fin	�ndice de fin asociado al vector v (0<=inicio<=fin<=v.length-1)
	 * @return	�ndice i que cumple lo indicado anteriormente (inicio<=i<=fin)
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
	 * Procedimiento que dado un vector de enteros, sus �ndices de inicio y fin y un 
	 * entero k, devuelve el elemento k-�simo m�s grande del vector.
	 * 
	 * @param v	Vector de enteros NO vacio
	 * @param k	Es un entero que, suponiendo que el vector v estuviera ordenado ascendentemente,
	 * hace referencia al elemento que se encuentra en dicha 'posici�n' (k-1). Es decir, el k m�s
	 * grande del vector.
	 * Precondici�n: inicio+1<=k<=fin+1, ya que el primer �ndice de los vectores es 0
	 * @param	inicio	�ndice de inicio asociado al vector v (0<=inicio<=v.length-1)
	 * @param	fin	�ndice de fin asociado al vector v (0<=inicio<=fin<=v.length-1)
	 * @return	Entero que viene a ser el k-�simo mayor elemento del vector v
	 */
	public int seleccionK (int [] v, int k, int inicio, int fin){
		/* s es el �ndice k pero relativo al vector v[inicio..fin] (k es el �ndice relativo a v[0..v.length-1]) */
		int s = inicio+k-1;
		int p;
		if (inicio==fin){
			return v[inicio];
		}else{
			p = particion(v,inicio,fin);
			if (p==s) return v[p];
			/* El elemento a devolver est� en la parte izquierda */
			else if (p<s) return seleccionK(v, s-p, p+1, fin);
			/* El elemento a devolver est� en la parte derecha */
			else return seleccionK(v, k, inicio, p-1);
		}
	}
}
