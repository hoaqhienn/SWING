package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Database {
	public Database() {
		super();
	}
	
	public EmpList read_NV(String part) throws Exception{
		EmpList ds = new EmpList();
		File f = new File(part);
		if(f.exists()) {
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String []data = line.split(",");
						Emp emp = new Emp(data[0],data[1],data[2],data[3],Integer.parseInt(data[4]),Double.parseDouble(data[5]));
						ds.insert(emp);
			}
			sc.close();
		}
		else {
			f.createNewFile();
		}
		return ds;
	}
	
	public void writeNV(String part, EmpList ds) throws Exception{
		try(
				PrintWriter out = new PrintWriter(new FileOutputStream(part),true)) {
			for(Emp nv : ds.getEmpList()) {
				String data = nv.getID()+","+nv.getLastName()+","+nv.getFirstName()+","+nv.getGender()+","+nv.getAge()+","+nv.getSalary();
				out.println(data);
			}
		}
	}
}
