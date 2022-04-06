package source_codes;

import java.awt.*;
import java.awt.event.*;
import java.sql.DatabaseMetaData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Application extends JFrame implements ActionListener, MouseListener {
	private JTextField txtMa, txtTen, txtNamxb, txtSoTrang, txtTacGia, txtNhaxb, txtGia, txtISBN;
	private JButton btnAdd, btnClear, btnDel, btnFix;
	private DefaultTableModel tableModel;
	private JTable table;
	private DataBase db;
	private DsSach lsSach;
	private String fileName = "DanhMucSach.txt";

	public Application() {
		setTitle("Quản lý Sách");
		setSize(900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		createGui();
		db = new DataBase();
		try {
			loadDb();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void loadDb() throws Exception {
		lsSach = null;
		lsSach = db.readFile(fileName);
		for (Sach o : lsSach.getLs()) {
			String[] row = { o.getMaSach(), o.getTenSach(), o.getTacGia(), o.getNamXb() + "", o.getNhaXb(),
					o.getSoTrang() + "", o.getGia() + "", o.getiSBN() };
			tableModel.addRow(row);
		}

	}

	private void createGui() {
		Container con = getContentPane();
		JPanel northP = new JPanel();
		northP.setLayout(new BorderLayout());
		northP.setBorder(BorderFactory.createTitledBorder("Records Editor"));
		Box centerB = Box.createVerticalBox();
		Box row1, row2, row3, row4, row5;

		JLabel lblNamxb = new JLabel("Năm xuất bản: ");

		row1 = Box.createHorizontalBox();
		JLabel lblMa = new JLabel("Mã sách: ");
		lblMa.setPreferredSize(lblNamxb.getPreferredSize());
		txtMa = new JTextField();
		row1.add(lblMa);
		row1.add(txtMa);

		row2 = Box.createHorizontalBox();
		JLabel lblTen = new JLabel("Tựa sách: ");
		lblTen.setPreferredSize(lblNamxb.getPreferredSize());
		txtTen = new JTextField();
		JLabel lblTacgia = new JLabel("Tác giả: ");
		lblTacgia.setPreferredSize(lblNamxb.getPreferredSize());
		txtTacGia = new JTextField();
		row2.add(lblTen);
		row2.add(txtTen);
		row2.add(Box.createHorizontalStrut(10));
		row2.add(lblTacgia);
		row2.add(txtTacGia);

		row3 = Box.createHorizontalBox();
		txtNamxb = new JTextField();
		JLabel lblNhaxb = new JLabel("Nhà xuất bản: ");
		txtNhaxb = new JTextField();
		row3.add(lblNamxb);
		row3.add(txtNamxb);
		row3.add(Box.createHorizontalStrut(10));
		row3.add(lblNhaxb);
		row3.add(txtNhaxb);

		row4 = Box.createHorizontalBox();
		JLabel lblTrang = new JLabel("Số trang: ");
		lblTrang.setPreferredSize(lblNamxb.getPreferredSize());
		txtSoTrang = new JTextField();
		JLabel lblGia = new JLabel("Đơn Giá: ");
		lblGia.setPreferredSize(lblNamxb.getPreferredSize());
		txtGia = new JTextField();
		row4.add(lblTrang);
		row4.add(txtSoTrang);
		row4.add(Box.createHorizontalStrut(10));
		row4.add(lblGia);
		row4.add(txtGia);

		row5 = Box.createHorizontalBox();
		JLabel lblISBN = new JLabel("International Standard Book Number (ISBN):");
		txtISBN = new JTextField();
		row5.add(lblISBN);
		row5.add(txtISBN);

		centerB.add(row1);
		centerB.add(Box.createVerticalStrut(10));
		centerB.add(row2);
		centerB.add(Box.createVerticalStrut(10));
		centerB.add(row3);
		centerB.add(Box.createVerticalStrut(10));
		centerB.add(row4);
		centerB.add(Box.createVerticalStrut(10));
		centerB.add(row5);
		centerB.add(Box.createVerticalStrut(10));

		northP.add(centerB, BorderLayout.CENTER);
		con.add(northP, BorderLayout.NORTH);

		JPanel centerP = new JPanel();
		centerP.setLayout(new BorderLayout());
		JPanel northCP = new JPanel();
		JPanel centerCP = new JPanel();

		btnAdd = new JButton("Thêm");
		btnClear = new JButton("Xóa trắng");
		btnFix = new JButton("Sửa");
		btnDel = new JButton("Xóa");

		JLabel lblTim = new JLabel("Tìm theo mã sách");
		JComboBox cbBox = new JComboBox();
		cbBox.addItem("A001");
		cbBox.addItem("J002");
		cbBox.setEditable(true);

		northCP.setLayout(new FlowLayout());
		northCP.add(btnAdd);
		northCP.add(btnClear);
		northCP.add(btnFix);
		northCP.add(btnDel);
		northCP.add(Box.createHorizontalStrut(50));
		northCP.add(lblTim);
		northCP.add(cbBox);

		centerP.add(northCP, BorderLayout.NORTH);

		centerCP.setLayout(new BorderLayout());
		centerCP.setBorder(BorderFactory.createTitledBorder("Danh sách các cuốn sách"));

		String[] col = { "Mã sách", "Tựa sách", "Tác giả", "Năm xuất bản", "Nhà xuất bản", "Số trang", "Đơn giá",
				"ISBN" };
		tableModel = new DefaultTableModel(col, 0);
		table = new JTable(tableModel);
		centerCP.add(new JScrollPane(table), BorderLayout.CENTER);

		centerP.add(centerCP, BorderLayout.CENTER);

		con.add(centerP, BorderLayout.CENTER);

		btnAdd.addActionListener(this);
		btnClear.addActionListener(this);
		btnDel.addActionListener(this);
		btnFix.addActionListener(this);
		table.addMouseListener(this);
		

	}

	public static void main(String[] args) {
		new Application().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnClear)) {
			clear();
		} else if (o.equals(btnAdd)) {
			if (txtMa.getText().trim().equals(""))
				focus(txtMa);
			else if (txtTen.getText().trim().equals(""))
				focus(txtTen);
			else if (txtTacGia.getText().trim().equals(""))
				focus(txtTacGia);
			else if (txtNhaxb.getText().trim().equals(""))
				focus(txtNhaxb);
			else if (txtISBN.getText().trim().equals(""))
				focus(txtISBN);
			else if (!isInt(txtNamxb))
				focus(txtNamxb);
			else if (!isInt(txtSoTrang))
				focus(txtSoTrang);
			else if (!isDouble(txtGia))
				focus(txtGia);
			else {
				try {
					luu();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		} else if (o.equals(btnDel)) {
			try {
				int qes = JOptionPane.showConfirmDialog(this, "Có chắc chắn xóa?", "", JOptionPane.YES_NO_OPTION);
				if (qes == JOptionPane.YES_OPTION) {
					lsSach.delIndex(table.getSelectedRow());
					tableModel.removeRow(table.getSelectedRow());
					db.writeFile(fileName, lsSach);
					JOptionPane.showMessageDialog(this, "Đã xóa");
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Chọn sách muốn xóa!");
			}
		}
	}

	private void luu() throws Exception {
		String ma = txtMa.getText();
		String ten = txtTen.getText();
		String tg = txtTacGia.getText();
		String namXb = txtNamxb.getText();
		String nhaXb = txtNhaxb.getText();
		String soTrang = txtSoTrang.getText();
		String gia = txtGia.getText();
		String isbn = txtISBN.getText();

		Sach o = new Sach(ma, ten, tg, Integer.parseInt(namXb), nhaXb, Integer.parseInt(soTrang),
				Double.parseDouble(gia), isbn);
		if (lsSach.addBook(o)) {
			JOptionPane.showMessageDialog(this, "Lưu thành công");
			db.writeFile(fileName, lsSach);
			String[] row = { ma, ten, tg, namXb, nhaXb, soTrang, gia, isbn };
			tableModel.addRow(row);
		} else {
			JOptionPane.showMessageDialog(this, "sách đã tồn tại");
		}
	}

	private boolean isDouble(JTextField text) {
		try {
			Double.parseDouble(text.getText());
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private boolean isInt(JTextField text) {
		try {
			Integer.parseInt(text.getText());
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private void focus(JTextField text) {
		text.selectAll();
		text.requestFocus();
		JOptionPane.showMessageDialog(this, "IO ERROR!!");
	}
	
	

	public void clear() {
		txtMa.setText("");
		txtTen.setText("");
		txtTacGia.setText("");
		txtNamxb.setText("");
		txtNhaxb.setText("");
		txtSoTrang.setText("");
		txtGia.setText("");
		txtISBN.setText("");
		txtMa.requestFocus();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMa.setText(table.getValueAt(row, 0).toString());
		txtTen.setText(table.getValueAt(row, 1).toString());
		txtTacGia.setText(table.getValueAt(row, 2).toString());
		txtNamxb.setText(table.getValueAt(row, 3).toString());
		txtNhaxb.setText(table.getValueAt(row, 4).toString());
		txtSoTrang.setText(table.getValueAt(row, 5).toString());
		txtGia.setText(table.getValueAt(row, 6).toString());
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
}
