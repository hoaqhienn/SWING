package entity;

import java.util.Objects;

public class LopHoc {
	private String maLop, tenLop, gVCN;

	public LopHoc() {
		super();
	}

	public LopHoc(String maLop) {
		super();
		this.maLop = maLop;
	}

	public LopHoc(String maLop, String tenLop, String gVCN) {
		super();
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.gVCN = gVCN;
	}

	public String getMaLop() {
		return maLop;
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

	public String getgVCN() {
		return gVCN;
	}

	public void setgVCN(String gVCN) {
		this.gVCN = gVCN;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gVCN, maLop, tenLop);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LopHoc other = (LopHoc) obj;
		return Objects.equals(gVCN, other.gVCN) && Objects.equals(maLop, other.maLop)
				&& Objects.equals(tenLop, other.tenLop);
	}

	@Override
	public String toString() {
		return "LopHoc [maLop=" + maLop + ", tenLop=" + tenLop + ", gVCN=" + gVCN + "]";
	}
	
	
}
