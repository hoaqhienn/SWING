package entity;

public class NhanVien {
	private String maNV;
	private String hoNV;
	private String tenNV;
	private int tuoi;
	private boolean Phai;
	private float luong;
	
	private PhongBan phong;

	public NhanVien(String maNV, String hoNV, String tenNV, int tuoi, boolean phai, PhongBan phong, float luong) {
		super();
		this.maNV = maNV;
		this.hoNV = hoNV;
		this.tenNV = tenNV;
		this.tuoi = tuoi;
		Phai = phai;
		this.phong = phong;
		this.luong = luong;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getHoNV() {
		return hoNV;
	}

	public void setHoNV(String hoNV) {
		this.hoNV = hoNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public boolean isPhai() {
		return Phai;
	}

	public void setPhai(boolean phai) {
		Phai = phai;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(Float luong) {
		this.luong = luong;
	}

	public PhongBan getPhong() {
		return phong;
	}

	public void setPhong(PhongBan phong) {
		this.phong = phong;
	}
	
	
}
