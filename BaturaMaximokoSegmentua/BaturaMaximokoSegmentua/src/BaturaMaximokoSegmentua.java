
public class BaturaMaximokoSegmentua {
	
	public HiruZenbaki baturaMaximokoSegmentua(int [] v, int hasiera, int amaiera){
		if(hasiera==amaiera){
			HiruZenbaki h = new HiruZenbaki();
			h.hasiera=hasiera;
			h.amaiera=amaiera;
			h.batuketa=v[hasiera];
			return h;
		}else{
			HiruZenbaki h1,h2,h3 = new HiruZenbaki();
			h1 = baturaMaximokoSegmentua(v, hasiera, (hasiera+amaiera)/2);
			h2 = baturaMaximokoSegmentua(v, ((hasiera+amaiera)/2)+1, amaiera);
			h3 = baturaMaximokoSegmentuaErdian(v, hasiera, (hasiera+amaiera)/2, amaiera);
			if ((h2.batuketa <= h1.batuketa) && (h3.batuketa <= h1.batuketa)) return h1;
			else if ((h1.batuketa <= h2.batuketa) && (h3.batuketa <= h2.batuketa)) return h2;
			else /*if ((h2.batuketa <= h1.batuketa) && (h3.batuketa <= h1.batuketa))*/ return h3;
		}
	}

	private HiruZenbaki baturaMaximokoSegmentuaErdian(int[] v, int hasiera,
			int erdia, int amaiera) {
		HiruZenbaki h = new HiruZenbaki();
		
		int ezkerrekoIndizea = erdia;
		int ezkerrekoBaturaMax=v[erdia];
		int ezkerrekoBaturaPartziala=v[erdia];
		for(int e=erdia-1; e>=hasiera; e--){
			ezkerrekoBaturaPartziala=ezkerrekoBaturaPartziala+v[e];
			if(ezkerrekoBaturaPartziala>ezkerrekoBaturaMax){
				ezkerrekoBaturaMax=ezkerrekoBaturaPartziala;
				ezkerrekoIndizea=e;
			}
		}
		
		int eskuinekoIndizea = erdia+1;
		int eskuinekoBaturaMax = v[erdia+1];
		int eskuinekoBaturaPartziala = v[erdia+1];
		for(int e=erdia+2; e<=amaiera; e++){
			eskuinekoBaturaPartziala=eskuinekoBaturaPartziala+v[e];
			if(eskuinekoBaturaPartziala>eskuinekoBaturaMax){
				eskuinekoBaturaMax=eskuinekoBaturaPartziala;
				eskuinekoIndizea=e;
			}
		}
		h.batuketa=(ezkerrekoBaturaMax+eskuinekoBaturaMax);
		h.hasiera=ezkerrekoIndizea;
		h.amaiera=eskuinekoIndizea;
		return h;
	}
}
