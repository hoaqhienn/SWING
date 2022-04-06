package source_codes;

import java.util.Objects;

public class Sach {
	private String maSach, tenSach, tacGia, nhaXb, iSBN;
	private int namXb, soTrang;
	private double gia;

	public Sach() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sach(String maSach) {
		super();
		this.maSach = maSach;
	}

	public Sach(String maSach, String tenSach, String tacGia, int namXb, String nhaXb, int soTrang,
			double gia,String iSBN) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.nhaXb = nhaXb;
		this.iSBN = iSBN;
		this.namXb = namXb;
		this.soTrang = soTrang;
		this.gia = gia;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getNhaXb() {
		return nhaXb;
	}

	public void setNhaXb(String nhaXb) {
		this.nhaXb = nhaXb;
	}

	public String getiSBN() {
		return iSBN;
	}

	public void setiSBN(String iSBN) {
		this.iSBN = iSBN;
	}

	public int getNamXb() {
		return namXb;
	}

	public void setNamXb(int namXb) {
		this.namXb = namXb;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		return Objects.equals(maSach, other.maSach);
	}

	@Override
	public String toString() {
		return "Sach [maSach=" + maSach + ", tenSach=" + tenSach + ", tacGia=" + tacGia + ", nhaXb=" + nhaXb + ", iSBN="
				+ iSBN + ", namXb=" + namXb + ", soTrang=" + soTrang + ", gia=" + gia + "]";
	}

}
