package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Dimension;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JMenuItem;
import java.awt.ScrollPane;
import javax.swing.JList;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;

public class QuanLyView extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel tableModel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyView frame = new QuanLyView();
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
	public QuanLyView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pNorth = new JPanel();
		pNorth.setForeground(Color.BLACK);
		pNorth.setBackground(Color.YELLOW);
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		pNorth.add(menuBar);
		
		JMenuItem mKhachHang = new JMenuItem("Kh\u00E1ch H\u00E0ng");
		mKhachHang.setSelected(true);
		mKhachHang.setBackground(Color.WHITE);
		mKhachHang.setIcon(new ImageIcon("E:\\GIT\\SWING\\#MOTO-SHOP\\img\\money_mini.png"));
		mKhachHang.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mKhachHang);
		
		JMenuItem mNhanVien = new JMenuItem("Qu\u1EA3n L\u00FD Nh\u00E2n Vi\u00EAn");
		mNhanVien.setBackground(Color.WHITE);
		mNhanVien.setIcon(new ImageIcon("E:\\GIT\\SWING\\#MOTO-SHOP\\img\\emp-32.png"));
		mNhanVien.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mNhanVien);
		
		JMenuItem mXeMay = new JMenuItem("Qu\u1EA3n L\u00FD Xe M\u00E1y");
		mXeMay.setBackground(Color.WHITE);
		mXeMay.setIcon(new ImageIcon("E:\\GIT\\SWING\\#MOTO-SHOP\\img\\shipping32.png"));
		mXeMay.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 16));
		menuBar.add(mXeMay);
		
		JMenuItem mThongKe = new JMenuItem("Th\u1ED1ng K\u00EA / T\u00ECm Ki\u1EBFm");
		mThongKe.setBackground(Color.WHITE);
		mThongKe.setIcon(new ImageIcon("E:\\GIT\\SWING\\#MOTO-SHOP\\img\\bar-chart-32.png"));
		mThongKe.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mThongKe);
		
		JPanel pCenter = new JPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new BorderLayout(0, 0));
		
		String[] col = { "ID", "BRAND", "MODEL", "TYPE", "ENGINE CAPACITY", "COLOR", "YEAR", "GIA NHAP", "GIA BAN", "TON KHO"};
		tableModel = new DefaultTableModel(col, 0);
		
		JPanel pSouth = new JPanel();
		pSouth.setBackground(Color.WHITE);
		contentPane.add(pSouth, BorderLayout.SOUTH);
		
		JLabel myName = new JLabel("LÊ HOÀNG HIỆN");
		pSouth.add(myName);
		
		JPanel pWest = new JPanel();
		pWest.setBackground(Color.CYAN);
		contentPane.add(pWest, BorderLayout.WEST);
		
		String[] products = {"Sản phẩm 1", "Sản phẩm 2", "Sản phẩm 3", "Sản phẩm 4", "Sản phẩm 5",
		        "Sản phẩm 6", "Sản phẩm 7", "Sản phẩm 8", "Sản phẩm 9", "Sản phẩm 10", "Sản phẩm 11",
		        "Sản phẩm 12", "Sản phẩm 13", "Sản phẩm 14", "Sản phẩm 15","Sản phẩm 1", "Sản phẩm 2", "Sản phẩm 3", "Sản phẩm 4", "Sản phẩm 5",
		        "Sản phẩm 6", "Sản phẩm 7", "Sản phẩm 8", "Sản phẩm 9", "Sản phẩm 10", "Sản phẩm 11",
		        "Sản phẩm 12", "Sản phẩm 13", "Sản phẩm 14", "Sản phẩm 15","Sản phẩm 1", "Sản phẩm 2", "Sản phẩm 3", "Sản phẩm 4", "Sản phẩm 5",
		        "Sản phẩm 6", "Sản phẩm 7", "Sản phẩm 8", "Sản phẩm 9", "Sản phẩm 10", "Sản phẩm 11",
		        "Sản phẩm 12", "Sản phẩm 13", "Sản phẩm 14", "Sản phẩm 15","Sản phẩm 1", "Sản phẩm 2", "Sản phẩm 3", "Sản phẩm 4", "Sản phẩm 5",
		        "Sản phẩm 6", "Sản phẩm 7", "Sản phẩm 8", "Sản phẩm 9", "Sản phẩm 10", "Sản phẩm 11",
		        "Sản phẩm 12", "Sản phẩm 13", "Sản phẩm 14", "Sản phẩm 15"};
		pWest.setLayout(new GridLayout(5, 1, 0, 0));
		
		JPanel p1 = new JPanel();
		pWest.add(p1);
		p1.setLayout(new GridLayout(2, 2, 0, 0));
		
		JButton btnNewButton = new JButton("New button");
		p1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		p1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		p1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		p1.add(btnNewButton_3);
		
		JPanel p2 = new JPanel();
		pWest.add(p2);
		
		JButton btnNewButton_4 = new JButton("New button");
		p2.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		p2.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		p2.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("New button");
		p2.add(btnNewButton_7);
		
		JPanel p3 = new JPanel();
		pWest.add(p3);
		
		JPanel p4 = new JPanel();
		pWest.add(p4);
		
		JPanel p5 = new JPanel();
		pWest.add(p5);
		
		JPanel pEast = new JPanel();
		pEast.setBackground(Color.CYAN);
		contentPane.add(pEast, BorderLayout.EAST);
	}
}
