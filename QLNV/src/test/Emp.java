package test;

public class Emp {
	private String ID;
	private String lastName;
	private String firstName;
	private String gender;
	private int age;
	private double salary;
	
	

	public Emp(String ID, String lastName, String firstName, String faction, int age, double salary) {
		super();
		this.ID = ID;
		setAge(age);
		setGender(gender);
		setFirstName(firstName);
		setLastName(lastName);
		setSalary(salary);
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getID() {
		return ID;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String Gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Emp [ID=" + ID + ", lastName=" + lastName + ", firstName=" + firstName + ", gender=" + gender
				+ ", age=" + age + ", salary=" + salary + "]";
	}
	
}
