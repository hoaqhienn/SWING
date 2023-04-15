package resources;

import java.awt.*;
import java.awt.event.*;
import java.security.spec.DSAGenParameterSpec;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class frmNhanVien extends JFrame implements ActionListener, MouseListener{
	private DanhSachNhanVien dao;
	private List<NhanVien> list;
	private JTable table;
	private JTextField txtMaNV, txtHo, txtTen, txtTuoi, txtTienLuong, txtTim;
	private JRadioButton radNam, radNu;
	private JButton btnTim, btnThem, btnXoa, btnSua, btnLuu, btnXoaTrang;
	private DefaultTableModel tableModel;
	
	public frmNhanVien(DanhSachNhanVien dao) {
		setTitle("hihi");
		setSize(750, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		this.dao = dao;
		list = dao.getList();
		
		JPanel pNorth;
		add(pNorth = new JPanel(), BorderLayout.NORTH);
		JLabel lt;
		pNorth.add(lt = new JLabel("THONG TIN NHAN VIEN"));
		lt.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lt.setForeground(Color.BLUE);
		
		Box b = Box.createVerticalBox();
		
		Box b1, b2, b3, b4, b5;
		JLabel  lMaNV, lHo, lTen, lTuoi, lPhai, lTienLuong;
		
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(lMaNV = new JLabel("Ma nhan vien: "));
		b1.add(txtMaNV = new JTextField());
		
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lHo = new JLabel("Ho: "));
		b2.add(txtHo= new JTextField());
		b2.add(lTen = new JLabel("Ten nhan vien: "));
		b2.add(txtTen= new JTextField());
		
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(lTuoi = new JLabel("Tuoi: "));
		b3.add(txtTuoi= new JTextField());
		b3.add(lPhai= new JLabel("Sex: "));
		b3.add(radNam = new JRadioButton("Nam"));
		b3.add(radNu = new JRadioButton("Nu"));
		ButtonGroup bg = new ButtonGroup();
		bg.add(radNam);
		bg.add(radNu);
		
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b4.add(lTienLuong = new JLabel("Tien luong: "));
		b4.add(txtTienLuong = new JTextField());
		
		lHo.setPreferredSize(lMaNV.getPreferredSize());
		lTienLuong.setPreferredSize(lMaNV.getPreferredSize());
		lTuoi.setPreferredSize(lMaNV.getPreferredSize());
	
		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(10));
		String [] headers = "MaNV;Ho;Ten;Phai;Tuoi;TienLuong".split(";");
		tableModel = new DefaultTableModel(headers,0);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(25);
		b5.add(scroll);
		add(b,BorderLayout.CENTER);
		
		JSplitPane split = new  JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		add(split, BorderLayout.SOUTH);
		
		JPanel pL, pR;
		split.add(pL = new JPanel());
		split.add(pR = new JPanel());
		
		pL.add(new JLabel("Nhap vao ma so can tim"));
		pL.add(txtTim = new JTextField(10));
		pL.add(btnTim = new JButton("Tim"));
		
		pR.add(btnThem = new JButton("Them"));
		pR.add(btnXoaTrang= new JButton("Xoa Trang"));
		pR.add(btnXoa = new JButton("Xoa"));
		pR.add(btnLuu= new JButton("Luu"));		
		
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnTim.addActionListener(this);
		
		table.addMouseListener(this);
	}
	
	public static void main(String[] args) {
		DanhSachNhanVien dao = new DanhSachNhanVien();
		new frmNhanVien(dao).setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		txtMaNV.setText(table.getValueAt(row, 0).toString());
		txtHo.setText(table.getValueAt(row, 1).toString());
		txtTen.setText(table.getValueAt(row, 2).toString());
		if(table.getValueAt(row, 3).toString() == "nam") {
			radNam.setSelected(true);
			radNu.setSelected(false);
		} else {
			radNam.setSelected(false);
			radNu.setSelected(true);
		}
//		radNu.setSelected(false);
//		if (table.getValueAt(row, 3).toString().equalsIgnoreCase("true"))
//			radNu.setSelected(true);
		txtTuoi.setText(table.getValueAt(row, 4).toString());
		txtTienLuong.setText(table.getValueAt(row, 5).toString());
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
		if (o.equals(btnXoaTrang))
			xoaTrangActions();
		if (o.equals(btnTim)) {
			String searchText = txtTim.getText().toLowerCase();
			for (int row = 0; row < table.getRowCount(); row++) {
				for (int col = 0; col < table.getColumnCount(); col++) {
					String cellText = table.getValueAt(row, col).toString().toLowerCase();
					if (cellText.contains(searchText)) {
						table.getSelectionModel().setSelectionInterval(row, row);
						table.scrollRectToVisible(table.getCellRect(row, 0, true));
						return;
					}
				}
			}
			JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả phù hợp");
		}
	}
	
	private void themActions() {
		try {
			int maNV = Integer.parseInt(txtMaNV.getText());
			String ho = txtHo.getText();
			String ten = txtTen.getText();
			boolean phai = (radNu.isSelected()) ? true : false;
			int tuoi = Integer.parseInt(txtTuoi.getText());
			double tienLuong = Double.parseDouble(txtTienLuong.getText());
			NhanVien nv = new NhanVien(maNV, ho, ten, phai, tuoi, tienLuong);
			if (dao.themNhanVien(nv)) {
				String temp = "nam";
				if (nv.isPhai()==true)
					temp = "nu";
				String []row = {Integer.toString(maNV), ho, ten, temp, Integer.toString(tuoi), tienLuong+""};
				tableModel.addRow(row);
				xoaTrangActions();
			} else {
				JOptionPane.showMessageDialog(null, "Trung ma nhan vien.");
				txtMaNV.selectAll();
				txtMaNV.requestFocus();
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi nhập liệu");
			return;
		}
	}
	
	private void xoaActions() {
		int row = table.getSelectedRow();
		if (row != -1) {
			int maNV = Integer.parseInt((String)table.getModel().getValueAt(row, 0));
			int hoiNhac = JOptionPane.showConfirmDialog(this, "Chac chan xoa khong?", "Chu y", JOptionPane.YES_NO_OPTION);
			if(hoiNhac == JOptionPane.YES_OPTION)
				if(dao.xoaNhanVien(maNV))
					tableModel.removeRow(row);
		}
	}
	
	private void xoaTrangActions() {
		txtMaNV.setText("");
		txtHo.setText("");
		txtTen.setText("");
		txtTuoi.setText("");
		txtTim.setText("");
		txtTienLuong.setText("");
		radNam.setSelected(false);
		radNu.setSelected(false);
		txtMaNV.requestFocus();
	}
	
}
