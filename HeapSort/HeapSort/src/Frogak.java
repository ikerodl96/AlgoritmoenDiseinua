import java.util.Arrays;


public class Frogak {

	public static void main(String[] args) {
		int [] v = {12,43,5,3,21,67,100};
		Meta m = new Meta();
//		m.metaEraikiHondoratuz(v);
		m.heapsort(v);
		System.out.println(Arrays.toString(v));
	}

}
