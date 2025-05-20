import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;


public class Frogak {

	public static void main(String[] args) {
		LinkedList<Ekintza> ekintzak = new LinkedList<Ekintza>();
		Ekintza e1 = new Ekintza(StringToDate("2018-04-18 08:30:00"),StringToDate("2018-04-18 09:30:00"));
		Ekintza e2 = new Ekintza(StringToDate("2018-04-18 12:00:00"),StringToDate("2018-04-18 12:45:00"));
		Ekintza e3 = new Ekintza(StringToDate("2018-04-18 11:30:00"),StringToDate("2018-04-18 12:15:00"));
		Ekintza e4 = new Ekintza(StringToDate("2018-04-18 11:00:00"),StringToDate("2018-04-18 12:30:00"));
		Ekintza e5 = new Ekintza(StringToDate("2018-04-18 10:00:00"),StringToDate("2018-04-18 10:50:00"));
		ekintzak.add(e1);
		ekintzak.add(e2);
		ekintzak.add(e3);
		ekintzak.add(e4);
		ekintzak.add(e5);
		EkintzaPlanifikatzailea ep = new EkintzaPlanifikatzailea();
		LinkedList<Ekintza> emaitza = ep.ekintzakHautatu(ekintzak);
		for(Ekintza e : emaitza){
			System.out.println(e.getHasieraOrdua().toString()+"  "+e.getAmaieraOrdua().toString());
		}
		
	}
	
	public static Date StringToDate(String s){

	    Date result = null;
	    try{
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        result  = dateFormat.parse(s);
	    }

	    catch(ParseException e){
	        e.printStackTrace();

	    }
	    return result ;
	}
}
