package XML;

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
		setTitle("XML");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		String[] header = {"ProductID", "Name", "Manufacture", "Description", "SName", "Country", "Web", "Price"};
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
		
		ArrayList<Product> list = dom.getAllProducts();
		for(Product p : list) {
			String rowdata[] = {p.getProductID(), p.getName(), p.getManufacture(), p.getDescription(), p.getSupplier().getName(), p.getSupplier().getCountry(), p.getSupplier().getWebsite(), p.getPrice()+""};
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
			String id = JOptionPane.showInputDialog("Nhap vao ma san pham: ");
			String name = JOptionPane.showInputDialog("Nhap vao ten san pham: ");
			
			Supplier s = new Supplier("The gioi di dong", "Viet Nam", "Thegioididong.com");
			Product p = new Product(id, name, "Sam sung ", "Mobile", s, 300);
			dom.addProduct(p);
			JOptionPane.showMessageDialog(this, "Them thanh cong");
			updateTableData();
			dom.writeXMLFile();
		}
		
		else if(o.equals(btDelete)) {
			int row =  table.getSelectedRow();
			if(row != -1) {
				String productID = (String) table.getValueAt(row, 0);
				dom.deleteProduct(productID);
				updateTableData();
				dom.writeXMLFile();
			}
		}
		
		else if(o.equals(btSave)) {
			dom.writeXMLFile();
			JOptionPane.showConfirmDialog(this, "Luu file XML thanh cong");
		}
		
		else if(o.equals(btUpdate)) {
			String productID = JOptionPane.showInputDialog("Nhap ma san pham: ");
			double newPrice = Double.valueOf(JOptionPane.showInputDialog("Nhap gia moi: "));
			dom.updatePrice(productID, newPrice);
			updateTableData();
			dom.writeXMLFile();
		}
		
//		else if(o.equals(btUpdate)) {			
//			String x = JOptionPane.showInputDialog("Nhap ma san pham:");
//			if (x != null && !x.trim().equals("")) {
//					double newPrice = Double.valueOf(JOptionPane.showInputDialog("Nhap gia moi: "));
//					dom.updatePrice(x, newPrice);
//					updateTableData();
//					dom.writeXMLFile();
//			}
//			else JOptionPane.showMessageDialog(btUpdate, "Khong tim thay!","ERROR",JOptionPane.ERROR_MESSAGE);
//		}
		
		
		
		else if(o.equals(btFilter)) {
			String x = JOptionPane.showInputDialog("Nhap cum tu can tim: ");
			if(x != null && !x.trim().equals("")) {
				sorter.setRowFilter(RowFilter.regexFilter("(?i)" + x));
			}
			else 
				sorter.setRowFilter(null);
				JOptionPane.showMessageDialog(btAdd, "Khong tim thay!","ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}

}
