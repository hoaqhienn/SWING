package source_codes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class DataBase {

	public DataBase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void writeFile(String fileName, DsSach lsSach) throws Exception {
		try (PrintWriter out = new PrintWriter(new FileOutputStream(fileName), true)) {
			for (Sach o : lsSach.getLs()) {
				String data = o.getMaSach()+";"+o.getTenSach()+";"+o.getTacGia()+";"+o.getNamXb()+";"+o.getNhaXb()+";"+o.getSoTrang()+";"+o.getGia()+";"+o.getiSBN();
				out.println(data);
			}
		}
	}

	public DsSach readFile(String fileName) throws Exception {
		DsSach lsSach = new DsSach();
		File f = new File(fileName);
		if (f.exists()) {
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] data = line.split(";");
				Sach o = new Sach(data[0], data[1], data[2], Integer.parseInt(data[3]), data[4], Integer.parseInt(data[5]), Double.parseDouble(data[6]), data[7]);
				lsSach.addBook(o);
			}
			sc.close();
		} else {
			f.createNewFile();
		}
		return lsSach;
	}
}
