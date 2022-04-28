package qlsv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.crypto.dsig.Transform;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ManageProduct {
	private static String fileName = "sinhvien.xml";
	
	private DocumentBuilder builder;
	private DocumentBuilderFactory factory;
	private Document document;
	
	public ManageProduct() {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			document = (Document) builder.parse(fileName);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			// TODO: handle exception
		} catch (SAXException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public ArrayList<SinhVien> getAllProducts() {
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		
		Element root = document.getDocumentElement();
		NodeList pList = root.getElementsByTagName("sinhvien");
		
		int pCount = pList.getLength();
		for(int i = 0; i < pCount; i++) {
			Element pNode = (Element) pList.item(i);
			String id = pNode.getAttribute("id");
			String hoTen = pNode.getElementsByTagName("hoten").item(0).getTextContent();
			String lop = pNode.getElementsByTagName("lop").item(0).getTextContent();
			String noiSinh = pNode.getElementsByTagName("noisinh").item(0).getTextContent();
			String monHoc = pNode.getElementsByTagName("monhoc").item(0).getTextContent();
			
			
			SinhVien p = new SinhVien(id, hoTen, lop, noiSinh, monHoc);
			list.add(p);
		}
		return list;
		
	}
	
	public void addProduct(SinhVien p) {
		Element root = document.getDocumentElement();
		
		Element pNode = document.createElement("sinhvien");
		root.appendChild(pNode);
		pNode.setAttribute("id", p.getId());
		
		Node nameNode0 = document.createElement("hoten");
		pNode.appendChild(nameNode0);
		nameNode0.setTextContent(p.getHoTen());
		
		Node nameNode1 = document.createElement("lop");
		pNode.appendChild(nameNode1);
		nameNode1.setTextContent(p.getLop());
		
		Node nameNode2 = document.createElement("noisinh");
		pNode.appendChild(nameNode2);
		nameNode2.setTextContent(p.getNoiSinh());
			
		Node nameNode3 = document.createElement("monhoc");
		pNode.appendChild(nameNode3);
		nameNode3.setTextContent(p.getMonHoc()+"");
	}
	
	public boolean findID(String id) {
		Element root = document.getDocumentElement();
		NodeList pList = root.getElementsByTagName("sinhvien");
		for(int i = 0; i < pList.getLength(); i++) {
			Element pNode = (Element) pList.item(i);
			String productID = pNode.getAttribute("id");
			if(productID.equalsIgnoreCase(id)) { 
				return true;
			}
		}
		return false;
	}
	
	public void deleteStudent(String pid) {
		Element root = document.getDocumentElement();
		NodeList pList = root.getElementsByTagName("sinhvien");
		for(int i = 0; i < pList.getLength(); i++) {
			Element pNode = (Element) pList.item(i);
			String productID = pNode.getAttribute("id");
			if(productID.equalsIgnoreCase(pid)) { 
				pNode.getParentNode().removeChild(pNode);
				break;
			}
		}
	}
	
	public void updateLopHoc(String pid, String newlop) {
		Element root = document.getDocumentElement();
		NodeList pList = root.getElementsByTagName("sinhvien");
		for(int i = 0; i < pList.getLength(); i++) {
			Element pNode = (Element) pList.item(i);
			String productID = pNode.getAttribute("id");
			if(productID.equalsIgnoreCase(pid)) {
				Node priceNode = pNode.getElementsByTagName("lop").item(0);
				priceNode.setTextContent(newlop+ "");
				break;
			}
		}
	}
	
	public void writeXMLFile() {
		TransformerFactory factory = null;
		Transformer transformer = null;
		try {
			factory = TransformerFactory.newInstance();
			transformer = factory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(new DOMSource(document), new StreamResult(fileName));
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}
}
