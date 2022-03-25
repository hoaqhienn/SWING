package entity;

import java.util.ArrayList;

public class CongTy {
	private ArrayList<PhongBan> dspb;
	
	public CongTy() {
		dspb = new ArrayList<PhongBan>();
	}
	
	public void addPhongBan(PhongBan pb) {
		dspb.add(pb);
	}
	
	public ArrayList<PhongBan> getDspb(){
		return dspb;
	}
}
