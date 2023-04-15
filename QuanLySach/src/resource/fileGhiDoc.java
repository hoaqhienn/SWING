package resource;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class fileGhiDoc {
	public static void writeToFile(ListSach list, String file) throws Exception {
		ObjectOutputStream out = null;
		out = new ObjectOutputStream(new FileOutputStream(file));
		out.writeObject(list);
		out.close();
	}
	public Object readFormFile(String file) throws Exception{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Object list = ois.readObject();
		ois.close();
		return list;
	}
}
