package source_codes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableRow;

public class Gui extends JFrame implements ActionListener, MouseListener {
	private JTextField txtMa, txtHo, txtTen, txtTuoi, txtLuong, txtTim;
	private JButton btnTim, btnXoaTrang, btnXoa, btnLuu, btnThem;
	private JRadioButton rbtnNam, rbtnNu;
	private JTable table;
	private DefaultTableModel tableModel;
	private DanhSachNV ds;
	private DataBase db;

	public Gui() {
		
		ds = new DanhSachNV();
		db = new DataBase();
		
		setTitle("???");
		setSize(900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		createGui();	
		
		try {
			loadDatabase();
		}
		catch (Exception e) {
		}
	}

	private void loadDatabase() throws Exception {
		ds = null;
//		ds = db.readNV("Nhanvien.txt");
		ds = (DanhSachNV)db.readFile("Nhanvien.dat");
		for (NhanVien nv : ds.getLs()) {
			String[] row = { nv.getMaNv(), nv.getHo(), nv.getTen(), nv.getGioiTinh(), nv.getTuoi() + "",nv.getLuong() + "" };
			tableModel.addRow(row);
		}
	}

	private void createGui() {
		Container con = getContentPane();
		JPanel northP = new JPanel();
		JLabel lblTt = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblTt.setForeground(Color.PINK);
		lblTt.setFont(new Font("Ariel", Font.BOLD, 24));
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

		JLabel lblMa = new JLabel("Mã nhân viên: ");
		txtMa = new JTextField();
		b1.add(lblMa);
		b1.add(txtMa);

		JLabel lblHo = new JLabel("Họ: ");
		JLabel lblTen = new JLabel("Tên nhân viên: ");
		txtHo = new JTextField();
		txtTen = new JTextField();
		b2.add(lblHo);
		b2.add(Box.createHorizontalStrut(59));
		b2.add(txtHo);
		b2.add(lblTen);
		b2.add(txtTen);

		JLabel lblTuoi = new JLabel("Tuổi: ");
		JLabel lblPhai = new JLabel("Phái: ");
		txtTuoi = new JTextField();
		rbtnNam = new JRadioButton("Nam");
		rbtnNu = new JRadioButton("Nữ");
		ButtonGroup g = new ButtonGroup();
		g.add(rbtnNam);
		g.add(rbtnNu);
		rbtnNam.setSelected(true);
		b3.add(lblTuoi);
		b3.add(Box.createHorizontalStrut(49));
		b3.add(txtTuoi);
		b3.add(lblPhai);
		b3.add(rbtnNam);
		b3.add(rbtnNu);

		JLabel lblLuong = new JLabel("Lương: ");
		txtLuong = new JTextField();
		b4.add(lblLuong);
		b4.add(Box.createHorizontalStrut(10));
		b4.add(txtLuong);

		boxConten.add(b1);		boxConten.add(Box.createVerticalStrut(10));
		boxConten.add(b2);		boxConten.add(Box.createVerticalStrut(10));
		boxConten.add(b3);		boxConten.add(Box.createVerticalStrut(10));
		boxConten.add(b4);		boxConten.add(Box.createVerticalStrut(10));

		String[] col = { "Mã NV", "Họ", "Tên nhân viên", "Phái", "Tuổi", "Lương" };
		tableModel = new DefaultTableModel(col, 0);
		table = new JTable(tableModel);
		TableColumn phaiCol = table.getColumnModel().getColumn(3);
		JComboBox cbBox = new JComboBox();
		cbBox.addItem("Nam");
		cbBox.addItem("Nữ");
		phaiCol.setCellEditor(new DefaultCellEditor(cbBox));

		centerP.add(boxConten, BorderLayout.NORTH);
		centerP.add(new JScrollPane(table), BorderLayout.CENTER);
		con.add(centerP, BorderLayout.CENTER);

		JSplitPane southP = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JPanel westSP = new JPanel();
		JPanel eastSP = new JPanel();
		westSP.setBorder(BorderFactory.createLoweredBevelBorder());
		eastSP.setBorder(BorderFactory.createLoweredBevelBorder());

		JLabel lblTim = new JLabel("Nhập mã nhân viên cần tìm: ");
		txtTim = new JTextField(10);
		btnTim = new JButton("Tìm");
		westSP.add(lblTim);
		westSP.add(txtTim);
		westSP.add(btnTim);
		southP.add(westSP);

		eastSP.add(btnThem = new JButton("Thêm"));
		eastSP.add(btnXoa = new JButton("Xoá"));
		eastSP.add(btnXoaTrang = new JButton("Xoá Trắng"));
		eastSP.add(btnLuu = new JButton("Lưu"));
		southP.add(eastSP);

		con.add(southP, BorderLayout.SOUTH);

		btnXoaTrang.addActionListener(this);
		btnLuu.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThem.addActionListener(this);
		btnTim.addActionListener(this);

		table.addMouseListener(this);
	}

	public static void main(String[] args) {
		new Gui().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnXoaTrang)) {
			clear();
		} else if (o.equals(btnLuu)) {
			if (txtMa.getText().equals(""))
				focus(txtMa);
			else if (txtHo.getText().equals(""))
				focus(txtHo);
			else if (txtTen.getText().equals(""))
				focus(txtTen);
			else if (!isInt(txtTuoi))
				focus(txtTuoi);
			else if (!isdouble(txtLuong))
				focus(txtLuong);
			else {
				try {
					luu();
				} catch (Exception ex) {
					// TODO: handle exception
				}
				clear();
			}
		} else if (o.equals(btnXoa)) {
			try {
				int qes = JOptionPane.showConfirmDialog(this, "Xác nhận xoá?", "qs",
						JOptionPane.YES_NO_OPTION);
				if (qes == JOptionPane.YES_OPTION) {
					ds.deleteVT(table.getSelectedRow());
					tableModel.removeRow(table.getSelectedRow());
//					db.writeNV("Nhanvien.txt", ds);
					db.saveFile("Nhanvien.dat",ds);
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Xoá?");
			}
		} else if (o.equals(btnThem)) {
			if (btnThem.getText().equals("Thêm")) {
				txtMa.setEnabled(true);
				txtHo.setEnabled(true);
				txtTen.setEnabled(true);
				txtTuoi.setEnabled(true);
				txtLuong.setEnabled(true);
				rbtnNam.setSelected(false);
				rbtnNu.setSelected(false);
				txtMa.requestFocus();
				btnXoa.setEnabled(false);
				btnThem.setText("Huỷ");
			} else {
				btnXoa.setEnabled(true);
				btnThem.setText("Thêm");
				clear();
			}
		} else if (o.equals(btnTim)) {
			String maX = txtTim.getText();
			int n = table.getRowCount();
			if (ds.timKiem(maX)) {
				for (int i = 0; i < n; i++) {
					if (table.getValueAt(i, 0).toString().equals(maX)) {
						txtMa.setText(tableModel.getValueAt(i, 0).toString());
						txtHo.setText(tableModel.getValueAt(i, 1).toString());
						txtTen.setText(tableModel.getValueAt(i, 2).toString());
						txtTuoi.setText(tableModel.getValueAt(i, 4).toString());
						if (tableModel.getValueAt(i, 3).toString().equals("Nam")) {
							rbtnNam.setSelected(true);
							rbtnNu.setSelected(false);
						} else {
							rbtnNam.setSelected(false);
							rbtnNu.setSelected(true);
						}
						txtLuong.setText(tableModel.getValueAt(i, 5).toString());
						break;
					}
				}
			} else {
				JOptionPane.showMessageDialog(this, "not found");
			}
		}
	}

	private void clear() {
		txtMa.setText("");
		txtHo.setText("");
		txtTen.setText("");
		txtTuoi.setText("");
		txtLuong.setText("");
		rbtnNam.setSelected(true);
		txtMa.requestFocus();
	}

	private void luu() throws Exception {
		String manv = txtMa.getText();
		String ho = txtHo.getText();
		String ten = txtTen.getText();
		String gt = "";
		if (rbtnNam.isSelected())
			gt = rbtnNam.getText();
		else if (rbtnNu.isSelected())
			gt = rbtnNu.getText();
		String tuoi = txtTuoi.getText();
		String luong = txtLuong.getText();
		NhanVien nv = new NhanVien(manv, ho, ten, gt, Integer.parseInt(tuoi), Double.parseDouble(luong));
		if (ds.addNV(nv)) {
			JOptionPane.showMessageDialog(this, "Lưu thành công");
			String[] row = { manv, ho, ten, gt, tuoi, luong };
			tableModel.addRow(row);
//			db.writeNV("Nhanvien.txt", ds);
			db.saveFile("Nhanvien.dat", ds);
		} else {
			JOptionPane.showMessageDialog(this, "Id tồn tại");
		}
		this.btnThem.setText("Thêm");
		btnXoa.setEnabled(true);
	}

	private boolean isInt(JTextField txt) {
		try {
			Integer.parseInt(txt.getText());
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private boolean isdouble(JTextField txt) {
		try {
			Double.parseDouble(txt.getText());
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private void focus(JTextField txt) {
		JOptionPane.showMessageDialog(null, "?");
		txt.selectAll();
		txt.requestFocus();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMa.setText(tableModel.getValueAt(row, 0).toString());
		txtHo.setText(tableModel.getValueAt(row, 1).toString());
		txtTen.setText(tableModel.getValueAt(row, 2).toString());
		txtTuoi.setText(tableModel.getValueAt(row, 4).toString());
		if (tableModel.getValueAt(row, 3).toString().equals("Nam")) {
			rbtnNam.setSelected(true);
			rbtnNu.setSelected(false);
		} else {
			rbtnNam.setSelected(false);
			rbtnNu.setSelected(true);
		}
		txtLuong.setText(tableModel.getValueAt(row, 5).toString());
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
