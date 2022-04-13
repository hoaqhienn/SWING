package country_;
import java.io.*;
import javax.swing.JOptionPane;

public class Database {

	public Database() {
		super();
	}
	//Save File
	public void saveFile(String fileName, Object o) throws Exception {
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(o);
		oos.close();
	}
	//Read File
	public Object readFile(String fileName) throws Exception {
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object o =null;
		o = ois.readObject();
		ois.close();
		return o;
	}
}
