package davi_right_here;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.Connection;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class NhanVien_GUI extends JFrame implements ActionListener {	
	private JTable table;
	private JTextField txtMaNV;
	private JTextField txthoTen;
	private JTextField txtTuoi;
	private JTextField txtTienLuong;
	private JTextField txtTim;
	private JButton btnTim;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnLuu;
	private JButton btnXoaTrang;
	private DefaultTableModel tableModel;
	private JLabel lblPhong;
	private JTextField txtPhong;
	private JComboBox cboPhong;
	private JButton btnSua;
	
  public NhanVien_GUI() { 	
		setTitle("^-^");
		setSize(700, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		JPanel pnlNorth;
		add(pnlNorth = new JPanel(), BorderLayout.NORTH);
		JLabel lblTieuDe;
		pnlNorth.add(lblTieuDe = new JLabel("THÔNG TIN NHÂN VIÊN"));
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		lblTieuDe.setForeground(Color.BLUE);

		Box b = Box.createVerticalBox();

		Box b1, b2, b3, b4, b5;
		JLabel lblMaNV, lblhoTen, lblTuoi, lblTienLuong;

		b.add(b1 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10));
		b1.add(lblMaNV = new JLabel("Mã nhân viên: "));
		b1.add(txtMaNV = new JTextField());

		b.add(b2 = Box.createHorizontalBox()); 
		b.add(Box.createVerticalStrut(10));
		b2.add(lblhoTen = new JLabel("Họ tên: "));
		b2.add(txthoTen = new JTextField());
		
		b.add(b3 = Box.createHorizontalBox()); 
		b.add(Box.createVerticalStrut(10));
		b3.add(lblTuoi = new JLabel("Tuổi: ")); 
		b3.add(txtTuoi = new JTextField());
		b.add(b4 = Box.createHorizontalBox()); 
		b.add(Box.createVerticalStrut(10));
		
		b4.add(lblPhong = new JLabel("Mã phòng: ")); 
		
		b4.add(cboPhong = new JComboBox<String>());
		cboPhong.setEditable(true);		
				
		
		b4.add(lblTienLuong = new JLabel("Tiền lương: ")); 
		b4.add(txtTienLuong = new JTextField());
		
		lblhoTen.setPreferredSize(lblMaNV.getPreferredSize());
		lblPhong.setPreferredSize(lblMaNV.getPreferredSize());
		lblTuoi.setPreferredSize(lblMaNV.getPreferredSize());

		b.add(b5 = Box.createHorizontalBox()); 
		b.add(Box.createVerticalStrut(10));
		String [] headers = "MaNV;Họ tên;Tuổi;Phòng;Tiền lương".split(";");
		tableModel=new DefaultTableModel(headers,0);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		
		b5.add(scroll);
		add(b, BorderLayout.CENTER);
		
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		add(split, BorderLayout.SOUTH);
		JPanel pnlLeft, pnlRight;
		split.add(pnlLeft = new JPanel());
		split.add(pnlRight = new JPanel());

		pnlLeft.add(new JLabel("Nhập mã cần tìm: "));
		pnlLeft.add(txtTim = new JTextField(10));
		pnlLeft.add(btnTim = new JButton("Tìm"));

		pnlRight.add(btnThem = new JButton("Thêm"));
		pnlRight.add(btnSua = new JButton("Sửa"));
		pnlRight.add(btnXoa = new JButton("Xoá"));
		pnlRight.add(btnLuu = new JButton("Lưu"));	
	}
  
  public static void main(String[] args) {
	  new NhanVien_GUI().setVisible(true);
 }
@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}

}
