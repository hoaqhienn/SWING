package source_codes;

public class clsNhanvien {
	private String empCode, empFName, empLName;
	private int age;
	private boolean gender;
	private Double salary;
	
	public clsNhanvien() {
		super();
	}

	public clsNhanvien(String empCode, String empFName, String empLName, int age, boolean gender, Double salary) {
		super();
		this.empCode = empCode;
		this.empFName = empFName;
		this.empLName = empLName;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getEmpFName() {
		return empFName;
	}

	public void setEmpFName(String empFName) {
		this.empFName = empFName;
	}

	public String getEmpLName() {
		return empLName;
	}

	public void setEmpLName(String empLName) {
		this.empLName = empLName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "clsDSNhanvien [empCode=" + empCode + ", empFName=" + empFName + ", empLName=" + empLName + ", age="
				+ age + ", gender=" + gender + ", salary=" + salary + "]";
	}
	
	
}
