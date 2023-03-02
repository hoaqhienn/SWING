package tuan2_quanlynhanvien;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Bai1 extends JFrame implements ActionListener {
	/**
	 * 20013121 - LE HOANG HIEN
	 * BAI 1 	- QUAN LY NHAN VIEN
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMa, txtHo, txtTen, txtTuoi, txtLuong, txtTim;
	private JButton btnTim, btnXoaTrang, btnXoa, btnLuu, btnThem;
	private JRadioButton rbtnNam, rbtnNu;
	private JTable table;
	private DefaultTableModel tableModel;

	public Bai1() {
		super("QLNV");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		Container con = getContentPane();
		JPanel northP = new JPanel();
		JLabel lblTt = new JLabel("QUAN LY NHAN VIEN");
		lblTt.setForeground(Color.BLUE);
		lblTt.setFont(new Font("Times New Roman", Font.BOLD, 24));
		northP.add(lblTt);
		con.add(northP, BorderLayout.NORTH);

		JPanel centerP = new JPanel();
		centerP.setLayout(new BorderLayout());
		Box boxConten = Box.createVerticalBox();
		Box b1, b2, b3, b4;
		b1 = Box.createHorizontalBox();
		b2 = Box.createHorizontalBox();
		b3 = Box.createHorizontalBox();
		b4 = Box.createHorizontalBox();

		JLabel lblMa = new JLabel("Ma nhan vien: ");
		txtMa = new JTextField();
		b1.add(lblMa);
		b1.add(txtMa);

		JLabel lblHo = new JLabel("Ho: ");
		JLabel lblTen = new JLabel("Ten nhan vien: ");
		txtHo = new JTextField();
		txtTen = new JTextField();
		b2.add(lblHo);
		b2.add(Box.createHorizontalStrut(59));
		b2.add(txtHo);
		b2.add(lblTen);
		b2.add(txtTen);

		JLabel lblTuoi = new JLabel("Tuoi: ");
		JLabel lblPhai = new JLabel("Phai: ");
		txtTuoi = new JTextField();
		rbtnNam = new JRadioButton("Nam");
		rbtnNu = new JRadioButton("Nu");
		ButtonGroup g = new ButtonGroup();
		g.add(rbtnNam);
		g.add(rbtnNu);
		rbtnNam.setSelected(true);
		b3.add(lblTuoi);
		b3.add(Box.createHorizontalStrut(50));
		b3.add(txtTuoi);
		b3.add(lblPhai);
		b3.add(rbtnNam);
		b3.add(rbtnNu);

		JLabel lblLuong = new JLabel("Luong: ");
		txtLuong = new JTextField();
		b4.add(lblLuong);
		b4.add(Box.createHorizontalStrut(39));
		b4.add(txtLuong);

		boxConten.add(b1);		boxConten.add(Box.createVerticalStrut(10));
		boxConten.add(b2);		boxConten.add(Box.createVerticalStrut(10));
		boxConten.add(b3);		boxConten.add(Box.createVerticalStrut(10));
		boxConten.add(b4);		boxConten.add(Box.createVerticalStrut(10));

		String[] col = { "Ma NV", "Ho", "Ten Nhan Vien", "Phai", "Tuoi", "Luong" };
		tableModel = new DefaultTableModel(col, 0);
		table = new JTable(tableModel);
		TableColumn phaiCol = table.getColumnModel().getColumn(3);
		JComboBox<String> cbBox = new JComboBox<String>();
		cbBox.addItem("Nam");
		cbBox.addItem("Nu");
		phaiCol.setCellEditor(new DefaultCellEditor(cbBox));

		centerP.add(boxConten, BorderLayout.NORTH);
		centerP.add(new JScrollPane(table), BorderLayout.CENTER);
		con.add(centerP, BorderLayout.CENTER);

		JSplitPane southP = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JPanel westSP = new JPanel();
		JPanel eastSP = new JPanel();
		westSP.setBorder(BorderFactory.createLoweredBevelBorder());
		eastSP.setBorder(BorderFactory.createLoweredBevelBorder());

		JLabel lblTim = new JLabel("Nhap ma nhan vien can tim: ");
		txtTim = new JTextField(10);
		btnTim = new JButton("Tim");
		westSP.add(lblTim);
		westSP.add(txtTim);
		westSP.add(btnTim);
		southP.add(westSP);

		eastSP.add(btnThem = new JButton("Them"));
		eastSP.add(btnXoa = new JButton("Xoa"));
		eastSP.add(btnXoaTrang = new JButton("Xoa rong"));
		eastSP.add(btnLuu = new JButton("Luu"));
		southP.add(eastSP);

		con.add(southP, BorderLayout.SOUTH);
		
		pack();
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new Bai1().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}
