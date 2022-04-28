
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
 
public class DOMExample {
    public static void main(String[] args) {
        List<Student> listStudents = DOMExample.readListStudents();
        // hiển thị các đối tượng student ra màn hình
        for (Student student : listStudents) {
            System.out.println(student.toString());
        }
    }
 
    public static List<Student> readListStudents() {
        List<Student> listStudents = new ArrayList<>();
        Student student = null;
 
        try {
            // đọc file input.xml
            File inputFile = new File("E:\\Workspace\\GIT\\SWING\\DOM\\Data.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
 
            // in phần tử gốc ra màn hình
            System.out.println("Phần tử gốc:"
                    + doc.getDocumentElement().getNodeName());
 
            // đọc tất cả các phần tử có tên thẻ là "student"
            NodeList nodeListStudent = doc.getElementsByTagName("student");
 
            // duyệt các phần tử student
            for (int i = 0; i < nodeListStudent.getLength(); i++) {
                // tạo đối tượng student
                student = new Student();
                // đọc các thuộc tính của student
                Node nNode = nodeListStudent.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    student.setId(eElement.getAttribute("id"));
                    student.setFirstName(eElement.getElementsByTagName("firstname")
                            .item(0).getTextContent());
                    student.setLastName(eElement.getElementsByTagName("lastname")
                            .item(0).getTextContent());
                    student.setMarks(eElement.getElementsByTagName("marks")
                            .item(0).getTextContent());
                }
                // add đối tượng student vào listStudents
                listStudents.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listStudents;
    }
}
