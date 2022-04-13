
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;



public class FrmNhanVien extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtDiaChi;
	private JTextField txtTuoi;
	private JTextField txtEmail;
	
	private JButton btnThem;
	private JTable table;
	private JButton btnXoaRong;


	private DefaultTableModel tableModel;
	private JLabel lblEmail;

	public FrmNhanVien() {
		setTitle("Kiểm tra biểu thức chính quy");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buildUI();
	}

	private void buildUI() {

		// Pháº§n North
		JPanel pnlNorth;
		add(pnlNorth = new JPanel(), BorderLayout.NORTH);
		pnlNorth.setPreferredSize(new Dimension(0, 180));
		pnlNorth.setBorder(BorderFactory.createTitledBorder("Thông tin"));
		pnlNorth.setLayout(null); // Absolute layout

		JLabel lblMaNV, lblHoTen, lblDiaChi, lblTuoi, lblNhaXB;
		pnlNorth.add(lblMaNV = new JLabel("Mã nhân viên: "));
		pnlNorth.add(lblHoTen = new JLabel("Họ tên nhân viên: "));
		pnlNorth.add(lblDiaChi = new JLabel("Địa chỉ: "));
		pnlNorth.add(lblTuoi = new JLabel("Tuổi: "));
		pnlNorth.add(lblEmail = new JLabel("Email: "));
		
		pnlNorth.add(txtMa = new JTextField());
		pnlNorth.add(txtTen = new JTextField());
		pnlNorth.add(txtDiaChi = new JTextField());
		pnlNorth.add(txtTuoi = new JTextField());
		pnlNorth.add(txtEmail = new JTextField());
		

		int w1 = 100, w2 = 300, h = 20;
		lblMaNV.setBounds(20, 20, w1, h);
		txtMa.setBounds(120, 20, 200, h);

		lblHoTen.setBounds(20, 45, w1, h);
		txtTen.setBounds(120, 45, w2, h);
		lblDiaChi.setBounds(450, 45, w1, h);
		txtDiaChi.setBounds(570, 45, w2, h);

		lblTuoi.setBounds(20, 70, w1, h);
		txtTuoi.setBounds(120, 70, w2, h);
		lblEmail.setBounds(450, 70, w1, h);
		txtEmail.setBounds(570, 70, w2, h);

		// Pháº§n Center
		JPanel pnlCenter;
		add(pnlCenter = new JPanel(), BorderLayout.CENTER);
		pnlCenter.add(btnThem = new JButton("Thêm kiểm tra dữ liệu..."));
		pnlCenter.add(btnXoaRong = new JButton("Xoá rỗng"));

		// Pháº§n South
		JScrollPane scroll;
		String[] headers = "MaNhanVien;HoTenNV;Tuoi;DiaChi; Email".split(";");

		tableModel = new DefaultTableModel(headers, 0);
		add(scroll = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.SOUTH);
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách"));
		table.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(0, 350));
	
		btnThem.addActionListener(this);		
		btnXoaRong.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if(o.equals(btnThem)){
			validData();

		}
		if(o.equals(btnXoaRong))
			clearTextfields();
	}
	private boolean validData(){
		String ma = txtMa.getText().trim();
		String ten = txtTen.getText().trim();
		String diaChi = txtDiaChi.getText().trim();
		String tuoi = txtTuoi.getText().trim();
		String email = txtEmail.getText().trim();

		if(!(!ma.equals("") && ma.matches("NV\\d{8}"))){
			JOptionPane.showMessageDialog(this, "Mã nhân viên theo mẫu: NV\\d{8}");
			return false;
		}

		if(!(!diaChi.equals("") && diaChi.matches("[a-zA-Z0-9' ]+"))) {
			JOptionPane.showMessageDialog(this, "Địa chỉ theo mẫu: [a-zA-Z0-9' ]+");
			return false;
		}
		if(!(!tuoi.equals("") && tuoi.matches("[0-9]+"))){
			JOptionPane.showMessageDialog(this, "Tuoi theo theo mẫu: [0-9]+");
			return false;
		} else if(Integer.parseInt(tuoi) < 18 || Integer.parseInt(tuoi)>65){
			JOptionPane.showMessageDialog(this, "Tuoi phai tu 18-65");
			return false;
		}
		if(!(!email.equals("") && email.matches("^[\\\\w-_\\\\.+]*[\\\\w-_\\\\.]\\\\@([\\\\w]+\\\\.)+[\\\\w]+[\\\\w]$"))){
			JOptionPane.showMessageDialog(this, "Email theo theo mẫu");
			return false;
		}
		
		if(!(!ten.equals("") && ten.matches("[a-zA-Z' ]+"))){
		JOptionPane.showMessageDialog(this, "Tên nhân viên theo mẫu: [a-zA-Z' ]+");
		return false;
		}

		return true;
	}

	private void clearTextfields() {
		txtMa.setText("");
		txtTen.setText("");
		txtDiaChi.setText("");
		txtTuoi.setText("");
		txtEmail.setText("");
	
		txtMa.setEditable(true);
		txtMa.requestFocus();
	}
}