package test;

import java.util.ArrayList;

public class EmpList {
	private ArrayList<Emp> empList;
	private String luaChon;
	private String tenFile;
	
	public EmpList() {
		this.empList = new ArrayList<Emp>();
		this.luaChon="";
		this.tenFile="";
	}
	
	public EmpList(ArrayList<Emp> empList) {
		this.empList = empList;
	}
	
	public ArrayList<Emp> getEmpList() {
		return empList;
	}

	public void setDsThiSinh(ArrayList<Emp> empList) {
		this.empList = empList;
	}
	
	public void insert(Emp emp) {
		this.empList.add(emp);
	}
	
	public void delete(Emp emp) {
		this.empList.remove(emp);
	}
	
	public void update(Emp emp) {
		this.empList.remove(emp);
		this.empList.add(emp);
	}

	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	public boolean kiemTraTonTai(Emp nv) {
		for(Emp Emp: empList) {
			if(nv.getID() == nv.getID())
				return true;
		}
		return false;
	}
}
