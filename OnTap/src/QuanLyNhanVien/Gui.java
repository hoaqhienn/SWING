package QuanLyNhanVien;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

public class Gui extends JFrame implements ActionListener{
	private JLabel lbMaNhanVien, lbHo, lbTenNhanVien, lbPhongban, lbTienluong, lbTim;
	private JTextField txtMaNhanVien, txtHo, txtTenNhanVien, txtTienLuong, txtTim;
	private JButton btnXoa, btnThem, btnXoaTrang, btnLuu, btnTim;	
	private DefaultTableModel model;
	private JTable table;
	JComboBox combobox;
	
	
	private NhanVien nv;
	private DsNhanVien ds = new DsNhanVien(); 
	private Database database = new Database();
//	private Databasee database = new Databasee();
	
	public Gui() {
		setTitle("Quản Lý Nhân Viên");
		setSize(900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		GiaoDien();
		try {
			loadData();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void GiaoDien() {
		JPanel pnNorth;
		add(pnNorth = new JPanel(), BorderLayout.NORTH);
		
		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		Box b5 = Box.createHorizontalBox();
		Box b6 = Box.createHorizontalBox();
		b.add(b1);
		b.add(Box.createVerticalStrut(5));
		b.add(b2);
		b.add(Box.createVerticalStrut(5));
		b.add(b3);
		b.add(Box.createVerticalStrut(5));
		b.add(b4);
		b.add(Box.createVerticalStrut(5));
		b.add(b5);
		b.add(Box.createVerticalStrut(5));
		b.add(b6);
		b.add(Box.createVerticalStrut(5));
		pnNorth.add(b);
		
		lbMaNhanVien = new JLabel("Mã Nhân Viên: ");
		txtMaNhanVien = new JTextField(70);
		b1.add(lbMaNhanVien);
		b1.add(txtMaNhanVien);
		
		lbHo = new JLabel("Họ:");
		txtHo =  new JTextField();
		b2.add(lbHo);
		b2.add(txtHo);
		lbHo.setPreferredSize(lbMaNhanVien.getPreferredSize());
		
		lbTenNhanVien = new JLabel("Tên nhân viên: ");
		txtTenNhanVien = new JTextField();
		b3.add(lbTenNhanVien);
		b3.add(txtTenNhanVien);
		lbTenNhanVien.setPreferredSize(lbMaNhanVien.getPreferredSize());
		
		lbPhongban = new JLabel("Phòng ban: ");
		combobox = new JComboBox();
		combobox.addItem("1.Phòng tổ chức");
		combobox.addItem("2.Phòng kỹ thuật");
		combobox.addItem("3.Phòng nhân sự");
		combobox.addItem("4.Phòng tài vụ");
		b4.add(lbPhongban);
		b4.add(combobox);
		lbPhongban.setPreferredSize(lbMaNhanVien.getPreferredSize());
		
		lbTienluong = new JLabel("Tiền lương: ");
		txtTienLuong = new JTextField();
		b5.add(lbTienluong);
		b5.add(txtTienLuong);
		lbTienluong.setPreferredSize(lbMaNhanVien.getPreferredSize());
		
		btnXoa = new JButton("Xoá");
		btnThem = new JButton("Thêm");
		btnXoaTrang = new JButton("Xoá Trắng");
		btnLuu = new JButton("Lưu");
		b6.add(btnXoa);
		b6.add(btnThem);
		b6.add(btnXoaTrang);
		b6.add(btnLuu);
		
		btnXoa.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnLuu.addActionListener(this);
		taoBang();
		
		JPanel pnTim;
		add(pnTim = new JPanel(),BorderLayout.SOUTH);
		lbTim = new JLabel("Tìm kiếm: ");
		txtTim = new JTextField(30);
		btnTim = new JButton("Tìm");
		
		pnTim.add(lbTim);
		pnTim.add(txtTim);
		pnTim.add(btnTim);
		btnTim.addActionListener(this);
		
	}
	
	public void taoBang() {
		JPanel pnTable;
		add(pnTable = new JPanel(),BorderLayout.CENTER);
		model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Mã NV");
		model.addColumn("Họ");
		model.addColumn("Tên");
		model.addColumn("Phòng ban");
		model.addColumn("Tiền lương");
		JScrollPane sp = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
											JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setPreferredSize(new Dimension(750, 350));
		pnTable.add(sp);
		
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
				txtMaNhanVien.setText(model.getValueAt(row, 0).toString());
				txtHo.setText(model.getValueAt(row, 1).toString());
				txtTenNhanVien.setText(model.getValueAt(row, 2).toString());
				txtTienLuong.setText(model.getValueAt(row, 4).toString());
				combobox.setSelectedItem(table.getValueAt(row, 3).toString());
			}
		});
	}
	
	public void loadData() throws Exception{
		ds = null;
		ds = (DsNhanVien)database.readFile("NhanVien.dat");
		for(NhanVien nv : ds.getls()) {
			String [] row = {nv.getMaNV(), nv.getHoNV(), nv.getTenNV(),
							 nv.getPb(), nv.getTienLuong()+" "};
			model.addRow(row);
		}
	}
	public static void main(String[] args) {
		Gui gui = new Gui();
		gui.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnXoaTrang))
			xoatrang();
		
		else if(o.equals(btnLuu)) {
			if(txtMaNhanVien.getText().equals("")||txtHo.getText().equals("")||
					txtTenNhanVien.getText().equals("")||txtTienLuong.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Loi luu khong duoc rong");
				txtMaNhanVien.setText("");
			}
			else {
				try 
				{
					luu();
				} catch (Exception e1) {
					e1.printStackTrace();
				}	
		}}
		else if(o.equals(btnXoa)) {
			try {
				xoaDong();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		else if(o.equals(btnThem)) {
			if(btnThem.getText().equals("Thêm")) {
				txtMaNhanVien.setEditable(true);
				txtHo.setEditable(true);
				txtTenNhanVien.setEditable(true);
				combobox.setEditable(true);
				txtTienLuong.setEditable(true);
				txtMaNhanVien.requestFocus();
				btnXoa.setEnabled(false);
				btnThem.setText("Huy");
				xoatrang();
			}else {
				btnXoa.setEnabled(true);
				btnThem.setText("Thêm");
			}
		}
		else if(o.equals(btnTim)) {
			try {
				tim();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	
	private void xoatrang() {
		txtMaNhanVien.setText("");
		txtHo.setText("");
		txtTenNhanVien.setText("");
		txtTienLuong.setText("");
		txtTim.setText("");
		combobox.setSelectedIndex(0);
	}
	
	private void luu() throws Exception{
		String ma = txtMaNhanVien.getText();
		String ho = txtHo.getText();
		String ten = txtTenNhanVien.getText();
		String pb = combobox.getSelectedItem().toString();
		String luong = txtTienLuong.getText();
		NhanVien nv = new NhanVien(ma, ho, ten, pb, Double.parseDouble(luong));
		
		if(ds.addNV(nv)) {
			{
				JOptionPane.showMessageDialog(this,"Lưu thành công");
				String []row = {ma,ho,ten,pb, luong};
				model.addRow(row);
				database.saveFile("NhanVien.dat", ds);
		}
		
	}
	}
	public void xoaDong() throws Exception{
		int r = table.getSelectedRow();
		if(r != -1) {
			int tb = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xoá dòng này ?",
					"Delete", JOptionPane.YES_NO_CANCEL_OPTION);
			if(tb == JOptionPane.YES_OPTION) {
				ds.removeNV(r);
				model.removeRow(r);
				xoatrang();
				database.saveFile("NhanVien.dat", ds);
			}
		}
	}
	public void tim() throws Exception{
		NhanVien nhanVien = new NhanVien(txtTim.getText(),"","","",0);
		int index = ds.getls().indexOf(nhanVien);
		table.setRowSelectionInterval(index, index);
		
	}
}
