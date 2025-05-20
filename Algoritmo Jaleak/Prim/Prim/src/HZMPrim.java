import java.util.LinkedList;


public class HZMPrim {
	
	public double HZMPrim(int[][] grafoa, LinkedList<Ertza> HZMErtzak){
		int[] pisuMin = new int[grafoa.length];
		int[] auzokide = new int [grafoa.length];
		
		for(int i=1; i<grafoa.length; i++){
			pisuMin[i]=grafoa[0][i];
			auzokide[i]=0;
		}
		
		double pisuenBatura=0;
		for(int i=1; i<grafoa.length; i++){
			int min = Integer.MAX_VALUE;
			int erpina=-1;
			for(int j=1; j<grafoa.length; j++){
				if(pisuMin[j]>0 && pisuMin[j]<min){
					min=pisuMin[i];
					erpina=j;
				}
			}
			pisuenBatura=pisuenBatura+min;
			HZMErtzak.add(new Ertza(erpina, auzokide[erpina], min));
			pisuMin[erpina]=-1;
			
			for(int j=1; j<grafoa.length; j++){
				if(grafoa[erpina][j]<pisuMin[j]){
					pisuMin[j]=grafoa[erpina][j];
					auzokide[j]=erpina;
				}
			}
		}
		return pisuenBatura;
	}

}
