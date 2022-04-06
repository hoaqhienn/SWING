package QuanLyNhanVien;

import java.io.*;

import javax.swing.JOptionPane;


public class Database {
	public Database() {
	super();
	}
	//Ghi file
	public void saveFile(String filename, Object o) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(filename);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(o);
			oos.close();
		}catch(Exception ex) {
			JOptionPane.showInternalMessageDialog(null, "IO Errorl");
			return;
		}
	}
	//Đọc File
	public Object readFile(String filename) {
		Object o = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(filename);
			ois = new ObjectInputStream(fis);
			o = ois.readObject();
			ois.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"IO Errorl");
		}
		return o;
	}
}
