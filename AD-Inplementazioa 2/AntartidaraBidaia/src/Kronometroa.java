/* Gafoen gaineko metodoen exekuzio denbora neurtzeko implementatu den Java klasea */
/* (Frogetan erabiltzen da bakarrik) */
public class Kronometroa {
	private long start;
	private long end;
	
	public void start(){
		start=System.currentTimeMillis();
	}
	
	public void stop(){
		end=System.currentTimeMillis();
		System.out.println("Erabilitako denbora: " + String.valueOf(end-start)+ " milisegundo");
	}
}
