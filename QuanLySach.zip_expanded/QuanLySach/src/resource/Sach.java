package resource;

import java.io.Serializable;
import java.util.Objects;

public class Sach implements Serializable{
	private String maSach, tuaSach, tacGia, nhaXB, iSBN;
	private int namXB, soTrang;
	private Double donGia;


	public Sach() {
		super();
	}

	public Sach(String maSach, String tuaSach, String tacGia, int namXB, String nhaXB, int soTrang,
			Double donGia, String iSBN) {
		super();
		this.maSach = maSach;
		this.tuaSach = tuaSach;
		this.tacGia = tacGia;
		this.nhaXB = nhaXB;
		this.iSBN = iSBN;
		this.namXB = namXB;
		this.soTrang = soTrang;
		this.donGia = donGia;
	}

	public Sach(String maSach) {
		super();
		this.maSach = maSach;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTuaSach() {
		return tuaSach;
	}

	public void setTuaSach(String tuaSach) {
		this.tuaSach = tuaSach;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getNhaXB() {
		return nhaXB;
	}

	public void setNhaXB(String nhaXB) {
		this.nhaXB = nhaXB;
	}

	public String getiSBN() {
		return iSBN;
	}

	public void setiSBN(String iSBN) {
		this.iSBN = iSBN;
	}

	public int getNamXB() {
		return namXB;
	}

	public void setNamXB(int namXB) {
		this.namXB = namXB;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}

	public Double getDonGia() {
		return donGia;
	}

	public void setDonGia(Double donGia) {
		this.donGia = donGia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(donGia, iSBN, maSach, namXB, nhaXB, soTrang, tacGia, tuaSach);
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
		return Objects.equals(donGia, other.donGia) && Objects.equals(iSBN, other.iSBN)
				&& Objects.equals(maSach, other.maSach) && namXB == other.namXB && Objects.equals(nhaXB, other.nhaXB)
				&& soTrang == other.soTrang && Objects.equals(tacGia, other.tacGia)
				&& Objects.equals(tuaSach, other.tuaSach);
	}

	@Override
	public String toString() {
		return "Sach [maSach=" + maSach + ", tuaSach=" + tuaSach + ", tacGia=" + tacGia + ", nhaXB=" + nhaXB + ", iSBN="
				+ iSBN + ", namXB=" + namXB + ", soTrang=" + soTrang + ", donGia=" + donGia + "]";
	}
}
