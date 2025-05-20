
public class Frogak {

	public static void main(String[] args) {
		SAT sat = new SAT();
		int emaitza = sat.formulaEraiki("Fitxategiak/uf20-01000.cnf");
		System.out.println(emaitza);
		sat.formulaBetearazi("emaitza");
	}

}
