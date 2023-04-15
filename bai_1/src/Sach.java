import java.io.Serializable;
import java.util.Objects;

public class Sach implements Serializable{
	private String maSach;
	private String tuaSach;
	private String tacGia;
	private int namXB;
	private String nhaXB;
	private int soTrang;
	private double donGia;
	private String ISBN;
	
	public Sach(String maSach, String tuaSach, String tacGia, int namXB, String nhaXB, int soTrang, double donGia,
			String iSBN) {
		super();
		this.maSach = maSach;
		this.tuaSach = tuaSach;
		this.tacGia = tacGia;
		this.namXB = namXB;
		this.nhaXB = nhaXB;
		this.soTrang = soTrang;
		this.donGia = donGia;
		this.ISBN = iSBN;
	}

	public Sach(String maSach) {
		this(maSach, "", "", 0, "", 0, 0, "");
	}

	public Sach() {
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

	public int getNamXB() {
		return namXB;
	}

	public void setNamXB(int namXB) {
		this.namXB = namXB;
	}

	public String getNhaXB() {
		return nhaXB;
	}

	public void setNhaXB(String nhaXB) {
		this.nhaXB = nhaXB;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maSach);
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
		return maSach + ";" + tuaSach + ";" + tacGia + ";" + namXB
				+ ";" + nhaXB + ";" + soTrang + ";" + donGia + ";" + ISBN;
	}
	
	
}
