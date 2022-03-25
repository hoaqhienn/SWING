package ui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import entity.NhanVien;

public class frmNhanvien extends JFrame {
	private ArrayList<NhanVien> dsnv;
	private JTable table;
	private DefaultTableModel tableModel;
	
	public frmNhanvien(ArrayList<NhanVien> dsnv, String title) {
		setTitle(title);
		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
//		dsnv = new ArrayList<NhanVien>();
		
		this.dsnv= dsnv;
		String column[] = {"Mã","Họ","Tên","Phòng Ban","Tuổi","Tiền Lương"};
		table = new JTable(tableModel = new DefaultTableModel(column,0));
		
		for(int i=0; i<dsnv.size(); i++) {
			NhanVien nv = dsnv.get(i);
			String[] row = {nv.getEmpCode(), nv.getlName(), nv.getfName(), nv.getPb().toString(), nv.getAge()+"",nv.getSalary()+""};
			tableModel.addRow(row);
		}
		table.setRowHeight(30);
		add(new JScrollPane(table),BorderLayout.CENTER);
	}
	
}
