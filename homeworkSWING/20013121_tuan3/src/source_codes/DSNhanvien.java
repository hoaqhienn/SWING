package source_codes;


import java.util.ArrayList;

import source_codes.*;

public class DSNhanvien {
	
	private ArrayList ls;
	
	public DSNhanvien() {
		 ls = new ArrayList<>();
	}
	
	public boolean addNV(clsNhanvien nv){
		if(ls.contains(nv)) {
			return false;
		}
		return ls.add(nv);
	}
	
	public ArrayList<clsNhanvien> getLs(){
		return ls;
	}
	
	public int numofemp(){
		return ls.size();
	}
	
	public boolean delemp(int index) {
		if(index >= 0 && index <= ls.size()-1) {
			ls.remove(index);
			return true;
		}
		else
			return false;
	}
	
	public boolean editemp(String empCode, String empFName, String empLName, int age, boolean gender, Double salary) {
		clsNhanvien nv = new clsNhanvien(empCode, empFName, empLName, age, gender, salary);
		if(ls.contains(nv)){
			nv.setEmpCode(empCode);
			nv.setEmpFName(empFName);
			nv.setEmpLName(empLName);
			nv.setAge(age);
			nv.setGender(gender);
			nv.setSalary(salary);
			return true;
		}
		else
			return false;
	}
}
