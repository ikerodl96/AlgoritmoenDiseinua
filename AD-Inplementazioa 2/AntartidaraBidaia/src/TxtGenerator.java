import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.ThreadLocalRandom;

public class TxtGenerator {

    private static TxtGenerator myTxtGen = new TxtGenerator();

    private TxtGenerator(){

    }

    public static TxtGenerator getMyTxtGen(){
        if(myTxtGen == null){
            myTxtGen = new TxtGenerator();
        }
        return myTxtGen;
    }

    public void generarTxt(){
        BufferedWriter writer = null;
        try {
            //create a temporary file
            File logFile = new File("4000.txt");

            // This will output the full path where the file will be written to...
            System.out.println("TU FICHERO 'lista.txt' ESTARA EN: "+logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(logFile));
            writer.write("10 100 4000\n");
            for (int i = 0; i < 4000; i++) {
            	int peso = ThreadLocalRandom.current().nextInt(10, 60 + 1);
            	int dinero = ThreadLocalRandom.current().nextInt(150, 600 + 1);
                writer.write(dinero + " " + peso+"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args){
        TxtGenerator.getMyTxtGen().generarTxt();
    }

}
