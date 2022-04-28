package qlsv;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.*;

public class GUI extends JFrame implements ActionListener{
	private static final long serialVersionUID = 6736610855443618564L;
	private DefaultTableModel model;
	private JTable table;
	private ManageProduct dom;
	private TableRowSorter<TableModel> sorter;
	private JButton btAdd, btDelete, btUpdate, btSave, btFilter;
	
	public GUI() { 
		setTitle("qlsv");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		String[] header = {"Mã sinh viên", "Họ tên sinh viên", "Lớp", "Nơi sinh", "Môn học"};
		add(new JScrollPane(table = new JTable(model = new DefaultTableModel(header, 0))), BorderLayout.CENTER);
		
		dom = new ManageProduct();
		updateTableData();
		sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		
		JPanel pSouth;
		add(pSouth = new JPanel(), BorderLayout.SOUTH);
		btAdd = new JButton("Add");
		btDelete = new JButton("Delete");
		btUpdate = new JButton("Update");
		btSave = new JButton("Save");
		btFilter = new JButton("Filter");
		pSouth.add(btAdd);
		pSouth.add(btDelete);
		pSouth.add(btUpdate);
		pSouth.add(btSave);
		pSouth.add(btFilter);
		
		btAdd.addActionListener(this);
		btDelete.addActionListener(this);
		btUpdate.addActionListener(this);
		btSave.addActionListener(this);
		btFilter.addActionListener(this);
		
	}


	private void updateTableData() {
		// TODO Auto-generated method stub
		while(table.getRowCount() != 0) {
			model.removeRow(0);
		}
		
		ArrayList<SinhVien> list = dom.getAllProducts();
		for(SinhVien p : list) {
			String rowdata[] = {p.getId(), p.getHoTen(), p.getLop(), p.getNoiSinh(), p.getMonHoc()+""};
			model.addRow(rowdata);
		}
		
	}
	
	public static void main(String[] args) {
		new GUI().setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btAdd)) {
			String id = JOptionPane.showInputDialog("Mã sinh viên: ");
				if (!dom.findID(id)) {
					String name = JOptionPane.showInputDialog("Tên sinh viên: ");
					String lop = JOptionPane.showInputDialog("Lớp: ");
					String ns = JOptionPane.showInputDialog("Nơi sinh: ");
					String mh = JOptionPane.showInputDialog("Môn học: ");
					
					SinhVien p = new SinhVien(id, name, lop, ns, mh);
					dom.addProduct(p);
					JOptionPane.showMessageDialog(this, "Thêm thành công!");
					updateTableData();
					dom.writeXMLFile();
				}
				else JOptionPane.showMessageDialog(this, "Trùng MSSV - Không thành công!");
					
			
		}
		
		else if(o.equals(btDelete)) {
			String id = JOptionPane.showInputDialog("Nhập mã sinh viên muốn xoá: ");
			dom.deleteStudent(id);
			updateTableData();
			dom.writeXMLFile();
			int row =  table.getSelectedRow();
		}
		
		else if(o.equals(btSave)) {
			dom.writeXMLFile();
			JOptionPane.showConfirmDialog(this, "Lưu file XML thành công!");
		}
		
		else if(o.equals(btUpdate)) {
			String productID = JOptionPane.showInputDialog("Nhập mã sinh viên: ");
			String newLop = JOptionPane.showInputDialog("Nhập lớp mới: ");
			dom.updateLopHoc(productID, newLop);
			updateTableData();
			dom.writeXMLFile();
		}
		
		else if(o.equals(btFilter)) {
			String x = JOptionPane.showInputDialog("Nhập lớp cần tìm: ");
			if(x != null && !x.trim().equals("")) {
				sorter.setRowFilter(RowFilter.regexFilter("^(?i)" + x + "$"));
			}
			else 
				sorter.setRowFilter(null);
			
		}
	}

}
