import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class FileDocGhi {
	public static void writeToFle(DanhSachSach ds, String file) throws Exception{
		ObjectOutputStream out = null;
		
		out = new ObjectOutputStream(new FileOutputStream(file));
		out.writeObject(ds);
		out.close();
	}
	
	public Object readFromFile(String file) throws Exception{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Object list = ois.readObject();
		ois.close();
		return list;
	}
	
	/*
	 * Cach 2: File txt
	 */
	
	public DanhSachSach read_Sach(String part) throws Exception {
		DanhSachSach ds = new DanhSachSach();
		File f = new File(part);
		if(f.exists()) {
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String []data = line.split(";");
				Sach sach = new Sach(data[0], data[1], data[2], Integer.parseInt(data[3]), data[4], Integer.parseInt(data[5]), Double.parseDouble(data[6]), data[7]);
				ds.themSach(sach);
			}
			sc.close();
		} else {
			f.createNewFile();
		}
		return ds;
	}
	
	public void write_Sach(String part, DanhSachSach ds) throws Exception{
		try {
			PrintWriter out = new PrintWriter(new FileOutputStream(part), true);
			for(Sach sach : ds.getList()) {
				String data = sach.getMaSach() + ";" + sach.getTuaSach() + ";" + sach.getTacGia() + ";" + sach.getNamXB() + ";" + sach.getNhaXB() + ";"
						+ sach.getSoTrang() + ";" + sach.getDonGia() + ";" + sach.getISBN();
				out.println(data);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
