package OnTapGiuaKy;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GUI extends JFrame implements ActionListener {
	private JLabel maLabel, hoLabel, tenLabel, phongBanLabel, luongLabel, timKiemLabel;
	private JTextField maTextField, hoTextField, tenTextField, luongTextField, timKiemTextField;
	private JComboBox phongBanBox;
	private JButton timKiemButton, themButton, xoaButton, xoaTrangButton, luuButton;
	private JTable table;
	private DefaultTableModel model;
	private QuanLyNhanVien danhSachNhanVien;
	private Database database;

	public GUI() {
		setTitle("[20013121] QUẢN LÝ NHÂN VIÊN");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		CreateGUI();
		danhSachNhanVien = new QuanLyNhanVien();
		database = new Database();
		try {
			loadData();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void CreateGUI() {
		JPanel northPanel;
		add(northPanel = new JPanel(), BorderLayout.NORTH);

		Box box = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		Box b5 = Box.createHorizontalBox();
		Box b6 = Box.createHorizontalBox();
		box.add(b1);		box.add(Box.createHorizontalStrut(5));
		box.add(b2);		box.add(Box.createHorizontalStrut(5));
		box.add(b3);		box.add(Box.createHorizontalStrut(5));
		box.add(b4);		box.add(Box.createHorizontalStrut(5));
		box.add(b5);		box.add(Box.createHorizontalStrut(5));
		box.add(b6);		box.add(Box.createHorizontalStrut(5));
		northPanel.add(box);

		maLabel = new JLabel("Mã nhân viên: ");
		maTextField = new JTextField(70);
		b1.add(maLabel);
		b1.add(maTextField);

		hoLabel = new JLabel("Họ:");
		hoTextField = new JTextField(70);
		b2.add(hoLabel);
		b2.add(hoTextField);
		hoLabel.setPreferredSize(maLabel.getPreferredSize());

		tenLabel = new JLabel("Tên: ");
		tenTextField = new JTextField(70);
		b3.add(tenLabel);
		b3.add(tenTextField);
		tenLabel.setPreferredSize(maLabel.getPreferredSize());

		phongBanLabel = new JLabel("Phòng ban:");
		phongBanBox = new JComboBox();
		phongBanBox.addItem("1. Phòng Tài Chính");
		phongBanBox.addItem("2. Phòng Kỹ Thuật");
		phongBanBox.addItem("3. Phòng Nhân Sự");
		phongBanBox.addItem("4. Phòng Kinh Doanh");
		b4.add(phongBanLabel);
		b4.add(phongBanBox);
		phongBanLabel.setPreferredSize(maLabel.getPreferredSize());

		luongLabel = new JLabel("Lương: ");
		luongTextField = new JTextField(70);
		b5.add(luongLabel);
		b5.add(luongTextField);
		luongLabel.setPreferredSize(maLabel.getPreferredSize());

		themButton = new JButton("Thêm");
		xoaButton = new JButton("Xóa");
		xoaTrangButton = new JButton("Xóa trắng");
		luuButton = new JButton("Lưu");
		b6.add(themButton);
		b6.add(xoaButton);
		b6.add(xoaTrangButton);
		b6.add(luuButton);

		themButton.addActionListener(this);
		xoaButton.addActionListener(this);
		xoaTrangButton.addActionListener(this);
		luuButton.addActionListener(this);
		
		maTextField.setEditable(false);
		hoTextField.setEditable(false);
		tenTextField.setEditable(false);
		luongTextField.setEditable(false);
		phongBanBox.setEnabled(false);

		//Create Table
		JPanel tablePanel;
		add(tablePanel = new JPanel(), BorderLayout.CENTER);
		model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Mã nhân viên");
		model.addColumn("Họ");
		model.addColumn("Tên");
		model.addColumn("Phòng ban");
		model.addColumn("Lương");
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(750, 350));
		tablePanel.add(scrollPane);
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				maTextField.setText(table.getValueAt(row, 0).toString());
				hoTextField.setText(table.getValueAt(row, 1).toString());
				tenTextField.setText(table.getValueAt(row, 2).toString());
				phongBanBox.setSelectedItem(table.getValueAt(row, 3).toString());
				luongTextField.setText(table.getValueAt(row, 4).toString());
			}
		});

		JPanel timKiemJPanel;
		add(timKiemJPanel = new JPanel(), BorderLayout.SOUTH);
		timKiemLabel = new JLabel("Tìm kiếm");
		timKiemTextField = new JTextField(30);
		timKiemButton = new JButton("Tìm");
		timKiemJPanel.add(timKiemLabel);
		timKiemJPanel.add(timKiemTextField);
		timKiemJPanel.add(timKiemButton);
		timKiemButton.addActionListener(this);
	}
	
	private void loadData() {
		danhSachNhanVien = null;
		try {
			danhSachNhanVien = (QuanLyNhanVien) database.readFile("nhanvien.dat");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (NhanVien nhanVien : danhSachNhanVien.getDanhSachNhanVien()) {
			Object[] row = {nhanVien.getMaNV(), nhanVien.getHoNv(), nhanVien.getTenNV(), nhanVien.getPhongBan(), nhanVien.getLuong()};
			model.addRow(row);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		if (object.equals(xoaTrangButton)) {
			XoaTrang();
		} else if (object.equals(luuButton)) {
			if (maTextField.getText().equals("") || hoTextField.getText().equals("") || tenTextField.getText().equals("") || luongTextField.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Không được phép lưu dữ liệu rỗng");
			}
			else {
				try {
					try {
						Luu();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		} else if (object.equals(xoaButton)) {
			xoa();
		}else if (object.equals(themButton)) {
			if (themButton.getText().equals("Thêm")) {
				setEditableForm(true);
				maTextField.grabFocus();	//focus -> maTextField.
				themButton.setText("Hủy");
			}else {
				themButton.setText("Thêm");
				setEditableForm(false);
			}
			XoaTrang();
		}else if (object.equals(timKiemButton)) {
			NhanVien temp = new NhanVien(timKiemTextField.getText(), "", "", "", 0);
			
			int index = danhSachNhanVien.getDanhSachNhanVien().indexOf(temp);
			table.scrollRectToVisible(table.getCellRect(index, 0, true));
			table.setRowSelectionInterval(index, index);
		}
	}

	private void setEditableForm(boolean b) {
		maTextField.setEditable(b);
		hoTextField.setEditable(b);
		tenTextField.setEditable(b);
		luongTextField.setEditable(b);
		phongBanBox.setEnabled(b);
	}
	
	private void XoaTrang() {
		maTextField.setText("");
		hoTextField.setText("");
		tenTextField.setText("");
		luongTextField.setText("");
	}

	private void Luu() throws Exception {
		String ma = maTextField.getText();
		String ho = hoTextField.getText();
		String ten = tenTextField.getText();
		String phongBan = phongBanBox.getSelectedItem().toString();
		if (!isDouble(luongTextField)) {
			JOptionPane.showMessageDialog(null, "Sai định dạng dữ liệu!");
			luongTextField.selectAll();
			luongTextField.requestFocus();
			return;
		}
		Double luong = Double.parseDouble(luongTextField.getText());
		NhanVien nhanVien = new NhanVien(ma, ho, ten, phongBan, luong);
		if (danhSachNhanVien.themNV(nhanVien)) {
			JOptionPane.showMessageDialog(this, "Thêm thành công");
			Object[] row = { ma, ho, ten, phongBan, luong };
			model.addRow(row);
			//Save
			database.saveFile("nhanvien.dat", danhSachNhanVien);
			XoaTrang();
			setEditableForm(false);
			themButton.setText("Thêm");
			
		}else {
			JOptionPane.showMessageDialog(this, "Mã NV đã tồn tại");
			maTextField.selectAll();
			maTextField.requestFocus();
		}

	}

	private boolean isDouble(JTextField textField) {
		try {
			Double.parseDouble(textField.getText());
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}
	
	private void xoa() {
		if (table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng để xóa");
			return;
		}
		if (JOptionPane.showConfirmDialog(this, "Chắc chắn xóa?") == JOptionPane.YES_OPTION) {
			int row = table.getSelectedRow();
			String maNV = model.getValueAt(row, 0).toString();
			danhSachNhanVien.xoaNV(maNV);
			model.removeRow(row);
			try {
				database.saveFile("nhanvien.dat", danhSachNhanVien);
				XoaTrang();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.setVisible(true);
	}
}
