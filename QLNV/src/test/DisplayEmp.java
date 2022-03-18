package test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class DisplayEmp extends JFrame implements ActionListener, MouseListener {
	
	private JTextField txtCustomerID, txtLastName, txtFirstName, txtAge, txtSalary;
	private JRadioButton rbtMan, rbtWoman;
	private JButton btAdd, btClear, btDelete, btSave;
	private DefaultTableModel model;
	private JTable table;
	
	public DisplayEmp() {
		setTitle("Customer");
		setSize(700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		createGUI();
		
	}
	
	public void createGUI() {
		JPanel pNorth, pCenter, pSouth, pCenterNort, pCenterCenter;
		
		// title
		add(pNorth = new JPanel(), BorderLayout.NORTH);
		JLabel lbTitle = new JLabel("THÔNG TIN NHÂN VIÊN");
		lbTitle.setFont(new Font("Arial", Font.BOLD, 25));
		pNorth.add(lbTitle);
		
		// create center
		add(pCenter = new JPanel(), BorderLayout.CENTER);
		pCenterNort = new JPanel();
		pCenterCenter = new JPanel();
		pCenter.add(pCenterNort, BorderLayout.NORTH);
		pCenter.add(pCenterCenter, BorderLayout.CENTER);
		
		// Phan north Center cua nhan vien
		// Khoi tao cac box
//		pCenterNort.setLayout(new BoxLayout(pCenterCenter, BoxLayout.Y_AXIS));
		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		b.add(b1);
		b.add(Box.createVerticalStrut(5));
		b.add(b2);
		b.add(Box.createVerticalStrut(5));
		b.add(b3);
		b.add(Box.createVerticalStrut(5));
		b.add(b4);
		b.add(Box.createVerticalStrut(5));
		pCenterNort.add(b);
		
		// them label va text vao
		
		JLabel lbCustomerID = new JLabel("Mã nhân viên: ");
		txtCustomerID = new JTextField(50);
		b1.add(lbCustomerID); b1.add(txtCustomerID);
		
		JLabel lbLastName = new JLabel("Họ: ");
		JLabel lbFirstName = new JLabel("Tên NV: ");
		txtLastName = new JTextField();
		txtFirstName = new JTextField();
		b2.add(lbLastName); b2.add(txtLastName);
		b2.add(lbFirstName); b2.add(txtFirstName);
		
		JLabel lbAge = new JLabel("Tuổi: ");
		JLabel lbFaction = new JLabel("Phái: ");
		txtAge = new JTextField();
		ButtonGroup grFaction = new ButtonGroup();
		rbtMan = new JRadioButton("Nam");
		rbtWoman = new JRadioButton("Nữ");
		grFaction.add(rbtMan);
		grFaction.add(rbtWoman);
		b3.add(lbAge); b3.add(txtAge);
		b3.add(lbFaction); b3.add(rbtMan); b3.add(rbtWoman);
		
		JLabel lbSalary = new JLabel("Tiền lương");
		txtSalary = new JTextField();
		b4.add(lbSalary); b4.add(txtSalary);
		
		// tao bảng
		createTable();
		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setPreferredSize(new Dimension(700, 250));
		pCenterCenter.add(sp);
		
		// add các nút
		add(pSouth = new JPanel(), BorderLayout.SOUTH);
		pSouth.add(btAdd = new JButton("Thêm"));
		pSouth.add(btClear = new JButton("Xoá trắng"));
		pSouth.add(btDelete = new JButton("Xoá"));
		pSouth.add(btSave = new JButton("Lưu"));
	}
	
	public void createTable() {
		JPanel pbTable = new JPanel();
		String []header = {"Mã NV", "Họ", "Tên", "Phái", "Tuổi", "Tiền lương"};
		model = new DefaultTableModel(header, 0);
		table = new JTable(model);
		
		TableColumn faction = table.getColumnModel().getColumn(3);
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Nam");
		comboBox.addItem("Nữ");
		faction.setCellEditor(new DefaultCellEditor(comboBox));
		TableColumn column = new TableColumn();
		column.setPreferredWidth(100);
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(center);
		table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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
	
	public static void main(String[] args) {
		new DisplayEmp().setVisible(true);
	}
	
}