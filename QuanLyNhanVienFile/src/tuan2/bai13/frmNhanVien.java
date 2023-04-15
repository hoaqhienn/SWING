package tuan2.bai13;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class frmNhanVien extends JFrame implements ActionListener, MouseListener{
	private DanhSachNhanVien dsnv;
	private JTable table;
	private JTextField txtMaNV, txtHo, txtTen, txtTuoi, txtTienLuong, txtTim, txtPhong;
	private JRadioButton radNu, radNam;
	private JButton btnTim, btnThem, btnXoa, btnLuu, btnXoaTrang;
	private DefaultTableModel tableModel;
	fileDocGhi fi;
	private JLabel lblPhong;
	private JComboBox cboPhong;
	private static final String tenfile = "abcd.txt";
	public frmNhanVien(DanhSachNhanVien dao) throws Exception {
		setTitle("hihi");
		setSize(700, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel pnlNorth, pnlSouth, pnlWest, pnlEast;
		add(pnlNorth = new JPanel(), BorderLayout.NORTH);
		JLabel lblTieuDe;
		pnlNorth.add(lblTieuDe = new JLabel("THÔNG TIN NHÂN VIÊN"));
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		lblTieuDe.setForeground(Color.BLUE);
		
		Box b = Box.createVerticalBox();
		Box b1, b2, b3, b4, b5;
		JLabel lblMaNV, lblHo, lblTen, lblTuoi, lblPhai, lblTienLuong;
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(lblMaNV = new JLabel("Ma nhan vien: "));
		b1.add(txtMaNV = new JTextField());
		
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lblHo = new JLabel("Ho: "));
		b2.add(txtHo = new JTextField());
		b2.add(lblTen = new JLabel("Ten: "));
		b2.add(txtTen = new JTextField());
		
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(lblTuoi = new JLabel("Tuoi: "));
		b3.add(txtTuoi = new JTextField());
		b3.add(lblPhai = new JLabel("Phai: "));
		b3.add(radNam = new JRadioButton("Nam"));
		b3.add(radNu = new JRadioButton("Nu"));
		
		ButtonGroup g = new ButtonGroup();
		g.add(radNam);
		g.add(radNu);
		
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b4.add(lblPhong = new JLabel("Phong:"));
		String[] phong = {"phong to chuc", "Phong ky thuat", "Phong nhan su", "Phong tai vu"};
		b4.add(cboPhong = new JComboBox(phong));
		b4.add(lblTienLuong = new JLabel("Tien luong:"));
		b4.add(txtTienLuong = new JTextField());
		
		lblHo.setPreferredSize(lblMaNV.getPreferredSize());
//		lblPhai.setPreferredSize(lblMaNV.getPreferredSize());
		lblPhong.setPreferredSize(lblMaNV.getPreferredSize());
		lblTuoi.setPreferredSize(lblMaNV.getPreferredSize());
		
		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		String [] headers = "MaNV;Ho;Ten;Phai;Tuoi;Phong;TienLuong".split(";");
		tableModel = new DefaultTableModel(headers,0);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		
		b5.add(scroll);
		add(b, BorderLayout.CENTER);
		
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		add(split, BorderLayout.SOUTH);
		JPanel pnlL, pnlR;
		split.add(pnlL = new JPanel());
		split.add(pnlR = new JPanel());
		
		pnlL.add(new JLabel("Nhap ma so can tim:"));
		pnlL.add(txtTim = new JTextField(10));
		pnlL.add(btnTim = new JButton("Tim"));
		
		pnlR.add(btnThem = new JButton("Them"));
		pnlR.add(btnXoaTrang = new JButton("Xoa trang"));
		pnlR.add(btnXoa = new JButton("Xoa"));
		pnlR.add(btnLuu = new JButton("Luu"));
		
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnLuu.addActionListener(this);
		btnTim.addActionListener(this);
		table.addMouseListener(this);
		
		
		dsnv = new DanhSachNhanVien();
		fi = new fileDocGhi();
		try {
			dsnv = (DanhSachNhanVien)fi.readFromFile(tenfile);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Khong tim thay file!");
		}
		hienTable();
}
	
	
	public void hienTable() {
		// TODO Auto-generated method stub
		for (int i = 0; i < dsnv.tong(); i++) {
			NhanVien nv = dsnv.getNhanVien(i);
			String[] dataRow = {nv.getMaNV() + "", nv.getHo(),nv.getTen(),Boolean.toString(nv.isPhai()),nv.getTuoi()+"",nv.getPhong(),nv.getTien()+""};
			tableModel.addRow(dataRow);
		}
	}
	
	private void xoaTrangActions() {
		txtMaNV.setText("");
		txtHo.setText("");
		txtTen.setText("");
		txtTuoi.setText("");
		txtTim.setText("");
		txtTen.setText("");
		radNam.setSelected(false);
		radNu.setSelected(false);
		txtMaNV.requestFocus();
	}
	
	private void themActions() {
		try {
			int maNV = Integer.parseInt(txtMaNV.getText());
			String ho = txtHo.getText();
			String ten = txtTen.getText();
			boolean phai = (radNu.isSelected()) ? true : false;
			int tuoi = Integer.parseInt(txtTuoi.getText());
			String phong = (String)cboPhong.getSelectedItem();
			double tien = Double.parseDouble(txtTienLuong.getText());
			NhanVien nv = new NhanVien(maNV, ho, ten, phai, tuoi, phong, tien);
			if (dsnv.themNhanVien(nv)) {
				String temp = "nam";
				if (nv.isPhai()==true)
					temp = "nu";
				String []row = {Integer.toString(maNV), ho, ten, temp, Integer.toString(tuoi), phong, tien+""};
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
				if(dsnv.xoaNhanVien(maNV))
					tableModel.removeRow(row);
		}
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
		txtTienLuong.setText(table.getValueAt(row, 6).toString());
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
		if (o.equals(btnThem))
			themActions();
		if (o.equals(btnXoa))
			xoaActions();
		if (o.equals(btnXoaTrang))
			xoaTrangActions();
		if (o.equals(btnLuu)) {
			fi = new fileDocGhi();
			try {
				fi.writeToFile(dsnv, tenfile);
			} catch (Exception e1) {
				// TODO: handle exception
				e1.printStackTrace();
			}
		}
		
		
	}
}
	
