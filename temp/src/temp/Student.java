package temp;

public class Student {
    String rollNo, fullname, gender, address;

    public Student() {
    }

    public Student(String rollNo, String fullname, String gender, String address) {
        this.rollNo = rollNo;
        this.fullname = fullname;
        this.gender = gender;
        this.address = address;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" + "rollNo=" + rollNo + ", fullname=" + fullname + ", gender=" + gender + ", address=" + address + '}';
    }
    
    public String getXMLString() {
        return "<student>\n" +
"		<rollNo>"+rollNo+"</rollNo>\n" +
"		<fullname>"+fullname+"</fullname>\n" +
"		<address>"+address+"</address>\n" +
"		<gender>"+gender+"</gender>\n" +
"	</student>";
    }
}

