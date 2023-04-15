import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.management.loading.PrivateClassLoader;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class FrmLopHoc extends JFrame implements ActionListener, MouseListener{
	private JTextField txtMaLop, txtTenLop, txtGVCN;
	private JButton btnThem, btnXoa, btnSua, btnLuu, btnXemDSSV;
	private DefaultTableModel dataModel;
	private JTable table;
	DanhSachLopHoc dslh = new DanhSachLopHoc();
	public FrmLopHoc() {
		setTitle("THONG TIN LOP HOC");
		setSize(1366, 768);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Box b, b1, b2, b3, b4, b5, b6, b7;
		
		add(b = Box.createVerticalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(10));
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(10));
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(10));
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(10));
		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(10));
		b.add(b6 = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(10));
		b.add(b7 = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(10));
		
		JLabel lblTieuDe, lblMaLop, lblTenLop, lblGVCN;
		b1.add(lblTieuDe = new JLabel("THONG TIN LOP HOC",JLabel.CENTER));
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 26));
		
		b2.add(lblMaLop = new JLabel("Ma lop: ", JLabel.RIGHT));
		b2.add(txtMaLop = new JTextField());
		
		b3.add(lblTenLop = new JLabel("Ten lop: ", JLabel.RIGHT));
		b3.add(txtTenLop = new JTextField());
		
		b4.add(lblGVCN = new JLabel("Giao vien chu nhiem: ", JLabel.RIGHT));
		b4.add(txtGVCN = new JTextField());
		
		lblMaLop.setPreferredSize(lblGVCN.getPreferredSize());
		lblTenLop.setPreferredSize(lblGVCN.getPreferredSize());
		
		b5.add(Box.createHorizontalStrut(70));
		b5.add(btnThem = new JButton("Them"));
		b5.add(btnLuu = new JButton("Luu"));
		b5.add(btnSua = new JButton("Xoa"));
		b5.add(btnXoa = new JButton("Sua"));
		
		String[] headers = {"Ma so lop","Ten lop","Giao vien chu nhiem"	};
		
		dataModel = new DefaultTableModel(headers,0);
		JScrollPane scroll;
		b6.add(scroll = new JScrollPane(table = new JTable(dataModel)));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sach lop hoc"));
		b7.add(Box.createHorizontalStrut(600));
		b7.add(btnXemDSSV = new JButton("Xem danh sach sinh vien cua lop hien tai"));
		btnXemDSSV.setForeground(Color.RED);
		
		btnThem.addActionListener(this);
		btnLuu.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnXemDSSV.addActionListener(this);
		
		table.addMouseListener(this);
		Database.getInstance().connect();
		updateTableData();
	}
		
		
		
	

	private void updateTableData() {
		DanhSachLopHoc ds = new DanhSachLopHoc();
		List<LopHoc> list = ds.docTuBang();
		for(LopHoc s : list) {
			String [] rowData = { s.getMaLop(), s.getTenLop(), s.getGiaoVienCN() +""};
			dataModel.addRow(rowData);
		}
		table.setModel(dataModel);
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMaLop.setText(table.getValueAt(row, 0).toString());
		txtTenLop.setText(table.getValueAt(row, 1).toString());
		txtGVCN.setText(table.getValueAt(row, 2).toString());
		
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
		if (o.equals(btnThem)) {
			xoaRongTextfields();
			txtMaLop.setEditable(true);
		} else if (o.equals(btnLuu)) {
			LopHoc lh = new LopHoc(txtMaLop.getText(), txtMaLop.getText(), txtGVCN.getText());
			if (dslh.create(lh)) {
				Object[] rowData = {txtMaLop.getText(),txtTenLop.getText(),txtGVCN.getText()};
				dataModel.addRow(rowData);
			}
		} else if (o.equals(btnSua)) {
			int row = table.getSelectedRow();
			if(row >=0) {
				LopHoc lh = new LopHoc(txtMaLop.getText(),txtTenLop.getText(),txtGVCN.getText());
				if(dslh.update(lh)) {
					table.setValueAt(txtTenLop.getText(), row, 1);
					table.setValueAt(txtGVCN.getText(), row, 2);
				}
			}
		} else if (o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			if(row >= 0) {
				String maLop = (String) table.getValueAt(row, 0);
				if (dslh.delete(maLop)) {
					dataModel.removeRow(row);
					xoaRongTextfields();
				}
			}
		}
		
		
	}
	
	private void xoaRongTextfields() {
		txtMaLop.setText("");
		txtTenLop.setText("");
		txtGVCN.setText("");
		txtMaLop.requestFocus();
		
	}
}