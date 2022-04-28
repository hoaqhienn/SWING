package qlsv;

public class SinhVien {
	private String id, hoTen, lop, noiSinh, monHoc;
	
	public SinhVien() {
		super();
	}
	 
	public SinhVien(String id, String hoTen, String lop, String noiSinh, String monHoc) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.lop = lop;
		this.noiSinh = noiSinh;
		this.monHoc = monHoc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public String getNoiSinh() {
		return noiSinh;
	}

	public void setNoiSinh(String noiSinh) {
		this.noiSinh = noiSinh;
	}

	public String getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(String monHoc) {
		this.monHoc = monHoc;
	}

	
	
}
