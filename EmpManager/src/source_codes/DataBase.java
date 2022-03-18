package source_codes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class DataBase implements Serializable{

	public DataBase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DanhSachNV readNV(String part) throws Exception {
		DanhSachNV ds = new DanhSachNV();
		File f = new File(part);
		if (f.exists()) {
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] data = line.split(",");
				NhanVien nv = new NhanVien(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]),
						Double.parseDouble(data[5]));
				ds.addNV(nv);
			}
			sc.close();
		} else {
			f.createNewFile();
		}
		return ds;
	}

	public void writeNV(String part, DanhSachNV ds) throws Exception {
		try (PrintWriter out = new PrintWriter(new FileOutputStream(part), true)) {
			for (NhanVien nv : ds.getLs()) {
				String data = nv.getMaNv() + "," + nv.getHo() + "," + nv.getTen() + "," + nv.getGioiTinh() + ","
						+ nv.getTuoi() + "," + nv.getLuong();
				out.println(data);
			}
		}
	}

	public void saveFile(String fileName, Object o) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
			try {
				fos = new FileOutputStream(fileName);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(o);
				oos.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "IO Error!");
				return;
			}
	}

	public Object readFile(String fileName) {
		Object o = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			o = ois.readObject();
			ois.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "IO Error!");
		}
		return o;
	}
}
