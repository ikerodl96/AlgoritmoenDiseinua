
public class Frogak {

	public static void main(String[] args) {
		SAT sat = new SAT();
		int emaitza = sat.formulaEraiki("Fitxategiak/froga");
		System.out.println(emaitza);
		sat.formulaBetearazi01("emaitza");
	}

}
