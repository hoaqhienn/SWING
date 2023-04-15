package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connectDB.*;
import dao.*;
import entity.*;

import javax.swing.ScrollPaneConstants;

import javax.swing.AbstractAction;
import javax.swing.Action;
import net.miginfocom.swing.MigLayout;

public class gui2 extends JFrame implements ActionListener, MouseListener{

	private JButton btnThem, btnXoa, btnSua, btnLuu;
	
	private JPanel contentPane;
	private JTextField txtMaLop;
	private JTextField txtTenLop;
	private JTextField txtGVCN;
	private DefaultTableModel tableModel;
	private JTable table;
	
	private XeMay_DAO xeMay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui2 frame = new gui2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gui2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		xeMay = new XeMay_DAO();
		
		JPanel pNorth = new JPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("TH\u00D4NG TIN L\u1EDAP H\u1ECCC");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 60));
		pNorth.add(lblTitle);
		
		JPanel pCenter = new JPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new BorderLayout(0, 0));
		
		JPanel pContentN = new JPanel();
		pCenter.add(pContentN, BorderLayout.NORTH);
		pContentN.setLayout(new MigLayout("", "[][grow]", "[][][]"));
		
		JLabel lblMaLop = new JLabel("M\u00E3 L\u1EDBp:");
		pContentN.add(lblMaLop, "cell 0 0,alignx trailing");
		
		txtMaLop = new JTextField();
		pContentN.add(txtMaLop, "cell 1 0,growx");
		txtMaLop.setColumns(10);
		
		JLabel lblTenLop = new JLabel("T\u00EAn L\u1EDBp:");
		pContentN.add(lblTenLop, "cell 0 1,alignx trailing");
		
		txtTenLop = new JTextField();
		pContentN.add(txtTenLop, "cell 1 1,growx");
		txtTenLop.setColumns(10);
		
		JLabel lblGVCN = new JLabel("Gi\u00E1o Vi\u00EAn Ch\u1EE7 Nhi\u1EC7m:");
		pContentN.add(lblGVCN, "cell 0 2,alignx trailing");
		
		txtGVCN = new JTextField();
		pContentN.add(txtGVCN, "cell 1 2,growx");
		txtGVCN.setColumns(10);
		
		JPanel pContentC = new JPanel();
		pCenter.add(pContentC);
		pContentC.setLayout(new MigLayout("", "[1340px]", "[33px][569px]"));
		
		JPanel panel = new JPanel();
		pContentC.add(panel, "cell 0 0,growx,aligny top");
		
		btnThem = new JButton("Th\u00EAm");
		panel.add(btnThem);
		
		JButton btnXoa = new JButton("Xo\u00E1");
		panel.add(btnXoa);
		
		JButton btnSua = new JButton("S\u1EEDa");
		panel.add(btnSua);
		
		JButton btnLuu = new JButton("L\u01B0u");
		panel.add(btnLuu);
		
		String[] col = { "ID", "Brand", "Model", "Capacity", "Năm sản xuất", "màu", "Số khung", "Số sườn", "Giá nhập", "Giá bán", "Trạng thái"};
		tableModel = new DefaultTableModel(col, 0);
		table = new JTable(tableModel);
		table.setBackground(Color.WHITE);
		pContentC.add(new JScrollPane(table), "cell 0 1,grow");
		
		DocDuLieuDatabaseVaoTable();
		
		
		JPanel pSouth = new JPanel();
		contentPane.add(pSouth, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Xem danh sách sinh viên của lớp hiện tại");
		pSouth.add(btnNewButton);
		
		btnThem.addActionListener(this);
	}

	private void DocDuLieuDatabaseVaoTable() {
		ArrayList<XeMay> xe = xeMay.getAll();
		
		for (XeMay a : xe) {
			tableModel.addRow(new Object[] {
					a.getMaXeMay(),
					a.getBrand(),
					a.getModel(),
					a.getCapacity(),
					a.getNamSX(),
					a.getMausac(),
					a.getSoKhung(),
					a.getSoSuon(),
					a.getGiaNhap(),
					a.getGiaBan(),
					a.isTrangThai()
			});
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
//		if(o.equals(btnThem)) {
//			String ma = txtMaLop.getText();
//			String ten = txtTenLop.getText();
//			String gv = txtGVCN.getText();
//			
//			LopHoc a = new LopHoc(ma, ten, gv);
//			try {
//				lopHoc.create(a);
//				tableModel.addRow(new Object[] {
//						a.getMaLop(),
//						a.getTenLop(),
//						a.getgVCN()
//				});
//			} catch (Exception e1) {
//				JOptionPane.showMessageDialog(this, "Trùng!");
//			}
//		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
