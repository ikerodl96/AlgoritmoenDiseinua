
public class Frogak {

//	public static void main(String[] args) {
//		int [] v = {3,5,4,2,1,10,6,9};
//		Meta m = new Meta();
//		m.metaEraiki(v);
//		m.print();
//	}
	
//	public static void main(String[] args) {
//		int [] v = new int[100];
//		for(int i=0; i<100; i++) v[i]=(int)(Math.random()*1000000000);
//		Meta m = new Meta();
//		m.metaEraiki(v);
//		m.print();
//	}
	
//	public static void main(String[] args) {
//		int [] v = new int[10000];
//		for(int i=0; i<10000; i++) v[i]=(int)(Math.random()*1000000000);
//		Meta m = new Meta();
//		m.metaEraiki(v);
//		m.print();
//	}
	
	public static void main(String[] args) {
		int [] v = new int[1000000];
		for(int i=0; i<1000000; i++) v[i]=(int)(Math.random()*1000000000);
		Meta m = new Meta();
		m.metaEraiki(v);
		m.print();
	}

}
