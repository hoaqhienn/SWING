import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;

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


public class GUI extends JFrame implements ActionListener, MouseListener{
	
	private JTable table;
	private JTextField txtMaSach, txtTuaSach, txtTacGia, txtNamXB, txtNhaXB, txtSoTrang, txtDonGia, txtISBN, txtMess;
	private JButton btnThem, btnXoaRong, btnXoa, btnSua, btnLuu;
	private DefaultTableModel tableModel;
	private JLabel lbMaSach, lbTuaSach, lbTacGia, lbNamXb, lbNhaXb, lbSoTrang, lbDonGia, lbISBN;
	private JComboBox cboMa;
	private DanhSachSach ds;
	FileDocGhi file;
	private static final String tenfile = "sach.dat";
	
	public GUI(DanhSachSach dao) throws Exception{
		setTitle("Quan ly sach");
		setSize(900, 550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		Box b = Box.createVerticalBox();
		
		Box b1, b2, b3, b4, b5, b6;
		
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(Box.createHorizontalStrut(20));
		b1.add(lbMaSach = new JLabel("Ma sach: "));
		b1.add(Box.createHorizontalStrut(20));
		b1.add(txtMaSach = new JTextField());
		b1.add(Box.createHorizontalStrut(550));
		
		
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(Box.createHorizontalStrut(20));
		b2.add(lbTuaSach = new JLabel("Tua sach: "));
		b2.add(Box.createHorizontalStrut(20));
		b2.add(txtTuaSach = new JTextField());
		b2.add(Box.createHorizontalStrut(20));
		b2.add(lbTacGia = new JLabel("Tac gia: "));
		b2.add(Box.createHorizontalStrut(20));
		b2.add(txtTacGia = new JTextField());
		
		
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(Box.createHorizontalStrut(20));
		b3.add(lbNamXb = new JLabel("Nam xuat ban: "));
		b3.add(Box.createHorizontalStrut(22));
		b3.add(txtNamXB = new JTextField());
		b3.add(Box.createHorizontalStrut(20));
		b3.add(lbNhaXb = new JLabel("Nha xuat ban: "));
		b3.add(Box.createHorizontalStrut(20));
		b3.add(txtNhaXB = new JTextField());
		
		
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b4.add(Box.createHorizontalStrut(20));
		b4.add(lbSoTrang = new JLabel("So trang: "));
		b4.add(Box.createHorizontalStrut(20));
		b4.add(txtSoTrang = new JTextField());
		b4.add(Box.createHorizontalStrut(20));
		b4.add(lbDonGia = new JLabel("Don gia: "));
		b4.add(Box.createHorizontalStrut(20));
		b4.add(txtDonGia = new JTextField());
		
		
		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b5.add(Box.createHorizontalStrut(20));
		b5.add(lbISBN = new JLabel("International Standard Book Number: "));
		b5.add(Box.createHorizontalStrut(20));
		b5.add(txtISBN = new JTextField());
		b5.add(Box.createHorizontalStrut(438));
		
		
		b.add(b6 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b6.add(Box.createHorizontalStrut(20));
		b6.add(txtMess = new JTextField());
		b6.add(Box.createHorizontalStrut(320));
		txtMess.setEditable(false);
		b.add(Box.createVerticalStrut(30));
		
		
		lbMaSach.setPreferredSize(lbNamXb.getPreferredSize());
		lbTuaSach.setPreferredSize(lbNamXb.getPreferredSize());
		lbTacGia.setPreferredSize(lbNamXb.getPreferredSize());
		lbNhaXb.setPreferredSize(lbNamXb.getPreferredSize());
		lbSoTrang.setPreferredSize(lbNamXb.getPreferredSize());
		lbDonGia.setPreferredSize(lbNamXb.getPreferredSize());
		
		b.setBorder(BorderFactory.createTitledBorder("Records Editor"));
		add(b,BorderLayout.NORTH);
		
		JPanel pCenter;
		add(pCenter = new JPanel(), BorderLayout.CENTER);
		pCenter.add(btnThem = new JButton("Them"));
		pCenter.add(btnXoaRong = new JButton("Xoa rong"));
		pCenter.add(btnXoa = new JButton("Xoa"));
		pCenter.add(btnSua = new JButton("Sua"));
		pCenter.add(btnLuu = new JButton("Luu"));
		
		JLabel lbTim;
		pCenter.add(lbTim = new JLabel("Tim theo ma sach: "));
		String[] ma = {"A001", "J002", "H003"};
		pCenter.add(cboMa = new JComboBox(ma));
		
		
		String[] header = "MaSach;TuaSach;TacGia;NamXuatBan;NhaXuatBan;SoTrang;DonGia;ISBN".split(";");
		tableModel = new DefaultTableModel(header, 0);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(tableModel));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sach cac cuon sach"));
		scroll.setPreferredSize(new Dimension(880, 270));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		
		pCenter.add(scroll);
		
		btnThem.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnLuu.addActionListener(this);
		table.addMouseListener(this);
		
		
		ds = new DanhSachSach();
		file = new FileDocGhi();
		try {
//			ds = (DanhSachSach)file.readFromFile(tenfile);
			ds = file.read_Sach(tenfile);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Khong tim thay file");
		}
		hienTable();
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
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			txtMess.setText("");
//			if(!checkRegex())
//				return;
			themAction();
		}
		if(o.equals(btnXoa))
			xoaAction();
		if(o.equals(btnXoaRong))
			xoaRongAction();
		if(o.equals(btnLuu)) {
			file = new FileDocGhi();
			try {
//				file.writeToFle(ds, tenfile);
				file.write_Sach(tenfile, ds);
				JOptionPane.showMessageDialog(null, "Luu thanh cong!");
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("aa");
				e2.printStackTrace();
			}
		}
		if(o.equals(btnSua))
			SuaAction();
	}
	
	public void hienTable() {
		tableModel.setRowCount(0);
		for (int i = 0; i < ds.tong(); i++) {
			Sach sach = ds.getSach(i);
			String[] dataRow = {sach.getMaSach(), sach.getTuaSach(), sach.getTacGia(), sach.getNamXB() + "", sach.getNhaXB(), sach.getSoTrang() + "", sach.getDonGia() + "", sach.getISBN()};
			tableModel.addRow(dataRow);
		}
	}
	
	private void xoaRongAction() {
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
	
	private void themAction() {
		try {
			Sach sach = null;
			String maSach = txtMaSach.getText();
			String tuaSach = txtTuaSach.getText();
			String tacGia = txtTacGia.getText();
			int namXB = Integer.parseInt(txtNamXB.getText());
			String nhaXB = txtNhaXB.getText();
			int soTrang = Integer.parseInt(txtSoTrang.getText());
			double donGia = Double.parseDouble(txtDonGia.getText());
			String iSBN = txtISBN.getText();
			
			sach = new Sach(maSach, tuaSach, tacGia, namXB, nhaXB, soTrang, donGia, iSBN);
			if(ds.themSach(sach)) {
				String[] row = {sach.getMaSach(), sach.getTuaSach(), sach.getTacGia(), sach.getNamXB() + "", sach.getNhaXB(), sach.getSoTrang() + "", sach.getDonGia() + "", sach.getISBN()};
				tableModel.addRow(row);
				xoaRongAction();
			} else {
				JOptionPane.showMessageDialog(null, "Trung ma sach!");
				txtMaSach.selectAll();
				txtMaSach.requestFocus();
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Loi nhap lieu!");
		}
	}
	
	private void xoaAction() {
		int row = table.getSelectedRow();
		if(row != -1) {
			String maSach = (String) table.getModel().getValueAt(row, 0);
			int hoiNhac = JOptionPane.showConfirmDialog(this, "Chac chan xoa khong?", "Chu y", JOptionPane.YES_NO_OPTION);
			if(hoiNhac == JOptionPane.YES_OPTION)
				if(ds.xoaSach(maSach)) {
					tableModel.removeRow(row);
					xoaRongAction();
				}
		}
	}
	
	private void SuaAction() {
		String maSach = txtMaSach.getText();
		String tuaSach = txtTuaSach.getText();
		String tacGia = txtTacGia.getText();
		int namXB = Integer.parseInt(txtNamXB.getText());
		String nhaXB = txtNhaXB.getText();
		int soTrang = Integer.parseInt(txtSoTrang.getText());
		double donGia = Double.parseDouble(txtDonGia.getText());
		String iSBN = txtISBN.getText();
		
		Sach sachNew = new Sach(maSach, tuaSach, tacGia, namXB, nhaXB, soTrang, donGia, iSBN);
		if(ds.suaSach(maSach, sachNew)) {
			hienTable();
		} else {
			JOptionPane.showMessageDialog(this, "Can chon cuon sach de cap nhat!");
	
		}
	}
	
	private boolean checkRegex() {
		String maSach = txtMaSach.getText().trim();
		String tuaSach = txtTuaSach.getText().trim();
		String tacGia = txtTacGia.getText().trim();
		String namXB = txtNamXB.getText().trim();
		String nhaXB = txtNhaXB.getText().trim();
		String soTrang = txtSoTrang.getText().trim();
		String donGia = txtDonGia.getText().trim();
		String iSBN = txtISBN.getText();
		
		if(maSach.trim().equals("") || !(maSach.matches("[A-Z]\\d{3}"))) {
			txtMess.setText("Error: Ma sach phai [A-Z]\\d{3}");
			return false;
		}
		
		if(tuaSach.trim().equals("") || !(tuaSach.matches("[a-zA-Z0-9-, ]+"))) {
			txtMess.setText("Error: Tua sach phai [a-zA-Z0-9-, ]+");
			return false;
		}
		
		if(tacGia.trim().equals("") || !(tacGia.matches("[a-zA-Z' ]+"))) {
			txtMess.setText("Error: Tac gia phai [a-zA-Z' ]+");
			return false;
		}
		
		if (namXB.length() > 0) {
			try {
				int x = Integer.parseInt(namXB);
				int namHienTai = Calendar.getInstance().get(Calendar.YEAR);
				if (!(x >= 1900 && x < namHienTai)) {
					txtMess.setText("Error: 1900 < Nam xuat ban < 2022");
					return false;
				}
			} catch (NumberFormatException ex) {
				txtMess.setText("Error: Nam xuat ban phai nhap so.");
				return false;
			}
		}
		
		if(nhaXB.trim().equals("") || !(nhaXB.matches("[a-zA-Z' ]+"))) {
			txtMess.setText("Error: Nha xuat ban phai [a-zA-Z' ]+");
			return false;
		}
		
		if (soTrang.length() > 0) {
			try {
				int x = Integer.parseInt(soTrang);
				if (x <= 0) {
					txtMess.setText("Error: So trang phai nhap so duong");
					return false;
				}
			} catch (NumberFormatException ex) {
				txtMess.setText("Error: So trang phai nhap so duong");
				return false;
			}
		}

		if (donGia.length() > 0) {
			try {
				double y = Double.parseDouble(donGia);
				if (y < 0) {
					txtMess.setText("Error: Don gia phai lon hon 0");
					return false;
				}
			} catch (NumberFormatException ex) {
				txtMess.setText("Error: Don gia phai nhap so");
				return false;
			}
		}
		
		if(iSBN.length() > 0) {
			if(!iSBN.matches("\\d+(-\\d+){3,4}")) {
				txtMess.setText("Error: ISBN co dinh dang la X-X-X-X (hoac X-X-X-X-X)");
				return false;
			}
		}
		
		return true;
	}
}
