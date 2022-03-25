package entity;

public class NhanVien {
	private String empCode, fName, lName;
	private Boolean gender;
	private int age;
	private long salary;
	private PhongBan pb;
	
	public NhanVien(String empCode, String fName, String lName, Boolean gender, int age, long salary, PhongBan pb) {
		super();
		this.empCode = empCode;
		this.fName = fName;
		this.lName = lName;
		this.gender = gender;
		this.age = age;
		this.salary = salary;
		this.pb = pb;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public PhongBan getPb() {
		return pb;
	}

	public void setPb(PhongBan pb) {
		this.pb = pb;
	}

	@Override
	public String toString() {
		return "NhanVien [empCode=" + empCode + ", fName=" + fName + ", lName=" + lName + ", gender=" + gender
				+ ", age=" + age + ", salary=" + salary + ", pb=" + pb + "]";
	}
	
	
}
