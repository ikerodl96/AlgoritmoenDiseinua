import java.util.LinkedList;

public class Motxila0_1 {
	private int [] pisuak;
	private int [] balioak;
	private int n;
	private int E;
	
	public Motxila0_1(int[] pisuak, int[] balioak, int n, int e) {
		super();
		this.pisuak = pisuak;
		this.balioak = balioak;
		this.n = n;
		E = e;
	}

	public void motxilaBt01K1(int SPB, int SPP, int [] SP, int i, int [] SOPTB, int [] SOPT){
		if(i==n){
			if(SPB>SOPTB[0]){
				kopia(SP,SOPT);
				SOPTB[0]=SPB;
			}
		}else{
			for(int j=0; j<=1; j++){
				if(SPP+(j*pisuak[i])<=E){
					SP[i]=j;
					motxilaBt01K1(SPB+(j*balioak[i]), SPP+(j*pisuak[i]), SP, i+1, SOPTB, SOPT);
				}
			}
		}
	}
	
	public void motxilaBt01K2(int SPB, int SPP, int [] SP, int i, int [] SOPTB, int [] SOPT, int outB){
		if(i==n){
			if(SPB>SOPTB[0]){
				kopia(SP,SOPT);
				SOPTB[0]=SPB;
			}
		}else{
			for(int j=0; j<=1; j++){
				if(SPP+(j*pisuak[i])<=E && SOPTB[0]<SPB+outB){
					SP[i]=j;
					motxilaBt01K2(SPB+(j*balioak[i]), SPP+(j*pisuak[i]), SP, i+1, SOPTB, SOPT, outB-balioak[i]);
				}
			}
		}
	}
	
	public void motxilaBtiNK2(int SPB, int SPP, LinkedList<Integer> SP, int i, LinkedList<Integer> SOPT, int[] SOPTB, int [] outB){
		if(i==n){
			if(SPB>SOPTB[0]){
				kopia(SP,SOPT);
				SOPTB[0]=SPB;
			}
		}else{
			for(int j=i; j<n; j++){
				if(SPP+pisuak[j]<=E && SOPTB[0]<SPB+outB[j]){
					SP.addFirst(j);
					motxilaBtiNK2(SPB+balioak[j], SPP+pisuak[j], SP, j+1, SOPT, SOPTB, outB);
					SP.removeFirst();
				}
			}
			if(SPB>SOPTB[0]){
				kopia(SP,SOPT);
				SOPTB[0]=SPB;
			}
		}
	}
	
	private void kopia(LinkedList<Integer> sP, LinkedList<Integer> sOPT) {
		sOPT.clear();
		for(Integer i: sP)	{
			sOPT.add(i);
		}
	}

	private static void kopia(int[] sP, int[] sOPT) {
		for(int i=0; i<sP.length; i++)	{
			sOPT[i]=sP[i];
		}
	}

}
