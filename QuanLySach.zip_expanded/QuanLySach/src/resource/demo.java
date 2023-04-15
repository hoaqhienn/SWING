package resource;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class demo extends JFrame implements ActionListener, MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnThem, btnXoaRong, btnXoa, btnSua, btnLuu;
	private JTextField txtMaSach, txtTuaSach, txtTacGia, txtNamXB, txtNhaXB, txtSoTrang, txtDonGia, txtISBN;
	private JComboBox cbo;	
	private JTable table;
	private DefaultTableModel tableModel;
	
	private ListSach list;
	fileGhiDoc fi;
	private static final String tenfile = "sach.txt";
	
	public demo() {
		super("^^");
//		setSize(700,450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		JPanel pnl1, pnl2, pnl3;
//		add(pnl1 = new JPanel(),BorderLayout.NORTH);
		
		JLabel lblMaSach, lblTuaSach, lblTacGia, lblNamXB, lblNhaXB, lblSoTrang, lblDonGia, lblISBN;
		Box b = Box.createVerticalBox();
		Box b1, b2, b3, b4, b5;
		add(b,BorderLayout.NORTH);
		b.setBorder(BorderFactory.createTitledBorder("Records Editor"));
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(Box.createHorizontalStrut(20));
		b1.add(lblMaSach = new JLabel("Ma sach:"));
		b1.add(Box.createHorizontalStrut(20));
		b1.add(txtMaSach = new JTextField());
//		b1.add(Box.createHorizontalStrut(400));
		//
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(Box.createHorizontalStrut(20));
		b2.add(lblTuaSach = new JLabel("Tua sach:"));
		b2.add(Box.createHorizontalStrut(20));
		b2.add(txtTuaSach = new JTextField());
		b2.add(Box.createHorizontalStrut(20));
		b2.add(lblTacGia = new JLabel("Tac gia:"));
		b2.add(Box.createHorizontalStrut(20));
		b2.add(txtTacGia = new JTextField());
		
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(Box.createHorizontalStrut(20));
		b3.add(lblNamXB = new JLabel("Nam xuat ban:"));
		b3.add(Box.createHorizontalStrut(20));
		b3.add(txtNamXB = new JTextField());
		b3.add(Box.createHorizontalStrut(20));
		b3.add(lblNhaXB = new JLabel("Nha xuat ban:"));
		b3.add(Box.createHorizontalStrut(20));
		b3.add(txtNhaXB = new JTextField());
		
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b4.add(Box.createHorizontalStrut(20));
		b4.add(lblSoTrang= new JLabel("So trang:"));
		b4.add(Box.createHorizontalStrut(20));
		b4.add(txtSoTrang= new JTextField());
		b4.add(Box.createHorizontalStrut(20));
		b4.add(lblDonGia= new JLabel("Don gia:"));
		b4.add(Box.createHorizontalStrut(20));
		b4.add(txtDonGia= new JTextField());
		//
		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b5.add(Box.createHorizontalStrut(20));
		b5.add(lblISBN= new JLabel("International Standard Book Number:"));
		b5.add(Box.createHorizontalStrut(10));
		b5.add(txtISBN= new JTextField());
		
		lblMaSach.setPreferredSize(lblNamXB.getPreferredSize());
		lblTuaSach.setPreferredSize(lblNamXB.getPreferredSize());
		lblTacGia.setPreferredSize(lblNamXB.getPreferredSize());
		lblNhaXB.setPreferredSize(lblNamXB.getPreferredSize());
		lblSoTrang.setPreferredSize(lblNamXB.getPreferredSize());
		lblDonGia.setPreferredSize(lblNamXB.getPreferredSize());
		
//		txtISBN.setPreferredSize(txtNamXB.getPreferredSize());
		
		add(pnl2 = new JPanel(),BorderLayout.CENTER);
		pnl2.add(btnThem = new JButton("Them"));
		pnl2.add(btnXoaRong = new JButton("Xoa rong"));
		pnl2.add(btnXoa = new JButton("Xoa"));
		pnl2.add(btnSua = new JButton("Sua"));
		pnl2.add(btnLuu = new JButton("Luu"));
		pnl2.add(new JLabel("Tim theo ma sach:"));
		
		String city[] = { "A001", "A002", "B003", 
                "D003", "D005" };
		pnl2.add(cbo = new JComboBox(city));
		
		
		add(pnl3 = new JPanel(),BorderLayout.SOUTH);
		pnl3.setBorder(BorderFactory.createTitledBorder("Danh sach cac cuon sach"));
		String [] headers = "MaSach;TuaSach;TacGia;NamXuatBan;NhaXuatBan;SoTrang;DonGia;ISBN".split(";");
		tableModel = new DefaultTableModel(headers,0);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(tableModel));
		scroll.setPreferredSize(new Dimension(700,200));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		pnl3.add(scroll);
		
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnSua.addActionListener(this);
		btnLuu.addActionListener(this);
		table.addMouseListener(this);
		
		list = new ListSach();
		fi = new fileGhiDoc();
		try {
			list = (ListSach)fi.readFormFile(tenfile);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Khong tim thay file!");
		}
		setResizable(false);
		setLocationRelativeTo(null);
		this.pack();
		showTable();
	}
	
	public void showTable() {
		for (int i = 0; i < list.tong(); i++) {
			Sach sach = list.getSach(i);
			if (sach != null) {
				String[] dataRow = {sach.getMaSach()+"",sach.getTuaSach(),sach.getTacGia(),sach.getNamXB()+"",sach.getNhaXB(),sach.getSoTrang()+"",sach.getDonGia()+"",sach.getiSBN()};
				tableModel.addRow(dataRow);
			}
		}
	}

	private void xoaTrangActions() {
		txtMaSach.setText("");
		txtTuaSach.setText("");
		txtTacGia.setText("");
		txtNamXB.setText("");
		txtNhaXB.setText("");
		txtSoTrang.setText("");
		txtDonGia.setText("");
		txtISBN.setText("");
		txtMaSach.requestFocus();
	}
	
	private void themActions() {

		try {
			String maSach = txtMaSach.getText();
			String tuaSach = txtTuaSach.getText();
			String tacGia = txtTacGia.getText();
//			boolean phai = (radNu.isSelected()) ? true : false;
			int namXB = Integer.parseInt(txtNamXB.getText());
//			String phong = (String)cboPhong.getSelectedItem();
			String nhaXB = txtNhaXB.getText();
			int soTrang = Integer.parseInt(txtSoTrang.getText());
			double donGia = Double.parseDouble(txtDonGia.getText());
			String iSNB = txtISBN.getText();
			
			Sach sach = new Sach(maSach, tuaSach, tacGia, namXB, nhaXB, soTrang, donGia, iSNB);
			if (list.themSach(sach)) {
				String []row = {maSach, tuaSach, tacGia, Integer.toString(namXB), nhaXB, Integer.toString(soTrang), Double.toString(donGia), iSNB+""};
				tableModel.addRow(row);
				xoaTrangActions();
			} else {
				JOptionPane.showMessageDialog(null, "Trung ma nhan vien.");
				txtMaSach.selectAll();
				txtMaSach.requestFocus();
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi nhập liệu");
			return;
		}
	
	}
	
	private void xoaActions() {
		int row = table.getSelectedRow();
		if (row != -1) {
			String maSach = (String)table.getModel().getValueAt(row, 0);
			int hoiNhac = JOptionPane.showConfirmDialog(this, "Chac chan xoa khong?", "Chu y", JOptionPane.YES_NO_OPTION);
			if(hoiNhac == JOptionPane.YES_OPTION)
				if(list.xoaSach(maSach))
					tableModel.removeRow(row);
		}
	}
	
	public static void main(String[] args) {
		new demo().setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		txtMaSach.setText(table.getValueAt(row, 0).toString());
		txtTuaSach.setText(table.getValueAt(row, 1).toString());
		txtTacGia.setText(table.getValueAt(row, 2).toString());
		txtNamXB.setText(table.getValueAt(row, 3).toString());
		txtNhaXB.setText(table.getValueAt(row, 4).toString());
		txtSoTrang.setText(table.getValueAt(row, 5).toString());
		txtDonGia.setText(table.getValueAt(row, 6).toString());
		txtISBN.setText(table.getValueAt(row, 7).toString());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem))
			themActions();
		if (o.equals(btnXoa))
			xoaActions();
		if (o.equals(btnXoaRong))
			xoaTrangActions();
		if (o.equals(btnLuu)) {
			fi = new fileGhiDoc();
			try {
				fi.writeToFile(list, tenfile);
			} catch (Exception e1) {
				// TODO: handle exception
				e1.printStackTrace();
			}
		}
//		if (o.equals(btnSua))
//			suaActions();
	}
}
