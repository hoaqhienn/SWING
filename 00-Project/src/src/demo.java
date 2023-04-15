package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.Insets;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Toolkit;
import javax.swing.JLayeredPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.SpringLayout;
import java.awt.CardLayout;
import java.awt.Component;

public class demo extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					demo frame = new demo();
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
	public demo() {
		setTitle("QUẢN LÝ BUÔN LẬU XE");
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\GIT\\SWING\\00-Project\\src\\user.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pNorth = new JPanel();
		pNorth.setBackground(Color.WHITE);
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.WHITE);
		menuBar.setBackground(Color.WHITE);
		pNorth.add(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Trang Chính");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mntmNewMenuItem.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\home.png"));
		mntmNewMenuItem.setForeground(Color.RED);
		mntmNewMenuItem.setBackground(Color.WHITE);
		menuBar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Danh Mục");
		mntmNewMenuItem_1.setForeground(Color.RED);
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mntmNewMenuItem_1.setSelectedIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\user.png"));
		mntmNewMenuItem_1.setBackground(Color.WHITE);
		mntmNewMenuItem_1.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\menu.png"));
		menuBar.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Bảo Hành");
		mntmNewMenuItem_2.setForeground(Color.RED);
		mntmNewMenuItem_2.setBackground(Color.WHITE);
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mntmNewMenuItem_2.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\medal.png"));
		menuBar.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Tìm Kiếm");
		mntmNewMenuItem_3.setForeground(Color.RED);
		mntmNewMenuItem_3.setBackground(Color.WHITE);
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mntmNewMenuItem_3.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\find-out.png"));
		menuBar.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Thống Kê");
		mntmNewMenuItem_4.setForeground(Color.RED);
		mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mntmNewMenuItem_4.setBackground(Color.WHITE);
		mntmNewMenuItem_4.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\bar-chart.png"));
		menuBar.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Trợ Giúp");
		mntmNewMenuItem_5.setForeground(Color.RED);
		mntmNewMenuItem_5.setBackground(Color.WHITE);
		mntmNewMenuItem_5.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mntmNewMenuItem_5.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\question.png"));
		menuBar.add(mntmNewMenuItem_5);
		
		JPanel pWest = new JPanel();
		pWest.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pWest, BorderLayout.WEST);
		pWest.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Trang Chính");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pWest.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Home");
		pWest.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Xe Máy");
		pWest.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Hoá Đơn");
		pWest.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Nhân Viên");
		pWest.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Khách Hàng");
		pWest.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Tìm Kiếm");
		pWest.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Bảo Hành");
		pWest.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Thông Tin Cá Nhân");
		pWest.add(btnNewButton_7);
		
		JPanel pSouth = new JPanel();
		contentPane.add(pSouth, BorderLayout.SOUTH);
		pSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel pCenter = new JPanel();
		pCenter.setBorder(null);
		contentPane.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setToolTipText("aaa\r\n");
		table.setBackground(Color.GREEN);
		pCenter.add(table);
		
		JScrollBar scrollBar = new JScrollBar();
		pCenter.add(scrollBar, BorderLayout.EAST);
		
		JPanel pEast = new JPanel();
		contentPane.add(pEast, BorderLayout.EAST);
	}
}
