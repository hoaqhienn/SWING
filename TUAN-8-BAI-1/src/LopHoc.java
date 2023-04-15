
public class LopHoc {
	private String maLop, tenLop, giaoVienCN;

	public String getMaLop() {
		return maLop;
	}
	
	public LopHoc(String maLop, String tenLop, String giaoVienCN) {
		super();
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.giaoVienCN = giaoVienCN;
	}
	
	public LopHoc(String maLop) {
		this(maLop, "Tên lớp", "GVCN");
	}
	
	public LopHoc() {
		this("Mã lớp");
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public String getGiaoVienCN() {
		return giaoVienCN;
	}

	public void setGiaoVienCN(String giaoVienCN) {
		this.giaoVienCN = giaoVienCN;
	}
	
	
	
}
