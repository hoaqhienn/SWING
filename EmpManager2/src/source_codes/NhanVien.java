package source_codes;

import java.io.Serializable;
import java.util.Objects;

public class NhanVien implements Serializable {
	private String maNv, ho, ten, phongBan;

	public NhanVien() {
		super();
	}

	public NhanVien(String maNv, String ho, String ten, String phongBan) {
		super();
		this.maNv = maNv;
		this.ho = ho;
		this.ten = ten;
		this.phongBan = phongBan;
	}

	public String getMaNv() {
		return maNv;
	}

	public void setMaNv(String maNv) {
		this.maNv = maNv;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNv, other.maNv);
	}

	@Override
	public String toString() {
		return "NhanVien [maNv=" + maNv + ", ho=" + ho + ", ten=" + ten + ", phongBan=" + phongBan + "]";
	}

}
