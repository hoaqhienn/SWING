package temp;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class StudentHandler extends DefaultHandler{
    List<Student> studentList = new ArrayList<>();
    Student currentStudent = null;
    
    boolean isRollNo = false, isFullname = false, isGender = false, isAddress = false;
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("student")) {
            currentStudent = new Student();
        } else if(qName.equalsIgnoreCase("rollNo")) {
            isRollNo = true;
        } else if(qName.equalsIgnoreCase("fullname")) {
            isFullname = true;
        } else if(qName.equalsIgnoreCase("gender")) {
            isGender = true;
        } else if(qName.equalsIgnoreCase("address")) {
            isAddress = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("student")) {
            studentList.add(currentStudent);
            currentStudent = null;
        } else if(qName.equalsIgnoreCase("rollNo")) {
            isRollNo = false;
        } else if(qName.equalsIgnoreCase("fullname")) {
            isFullname = false;
        } else if(qName.equalsIgnoreCase("gender")) {
            isGender = false;
        } else if(qName.equalsIgnoreCase("address")) {
            isAddress = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        
        if(isRollNo) {
            currentStudent.setRollNo(value);
        } else if(isFullname) {
            currentStudent.setFullname(value);
        } else if(isGender) {
            currentStudent.setGender(value);
        } else if(isAddress) {
            currentStudent.setAddress(value);
        }
    }

    public List<Student> getStudentList() {
        return studentList;
    }
}

