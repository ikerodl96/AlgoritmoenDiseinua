import java.util.Arrays;


public class Frogak {

	public static void main(String[] args) {
		boolean [][] grafoa={{false,false,false,true},
							 {false,false,false,true},
							 {false,false,false,true},
							 {true,true,true,false}};
		boolean [][] grafoa1={{false,false,true},
							  {false,false,true},
							  {true,true,false}};
		MapaKoloreztatu mk = new MapaKoloreztatu(grafoa1);
		int [] SP = new int[grafoa1.length];
		mk.mapaKoloreztatu4Koloreekin(0, SP);
	}

}
