package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class frm_nhanvien extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private DefaultTableModel tableModel;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_nhanvien frame = new frm_nhanvien();
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
	public frm_nhanvien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 768);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel north = new JPanel();
		north.setBackground(Color.CYAN);
		contentPane.add(north, BorderLayout.NORTH);
		north.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(10, 10, 10, 10));
		north.add(menuBar);
		
		JMenuItem mn1 = new JMenuItem("Menu Ch\u00EDnh");
		mn1.setBackground(Color.WHITE);
		mn1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mn1.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\icon\\home.png"));
		menuBar.add(mn1);
		
		JMenuItem mn2 = new JMenuItem("Ho\u00E1 \u0110\u01A1n");
		mn2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mn2.setBackground(Color.WHITE);
		mn2.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\icon\\paper_minipng.png"));
		menuBar.add(mn2);
		
		JMenuItem mn3 = new JMenuItem("Nh\u00E2n Vi\u00EAn");
		mn3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mn3.setBackground(Color.WHITE);
		mn3.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\icon\\emp_mini.png"));
		mn3.setSelected(true);
		menuBar.add(mn3);
		
		JMenuItem mn4 = new JMenuItem("Kh\u00E1ch H\u00E0ng");
		mn4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mn4.setBackground(Color.WHITE);
		mn4.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\icon\\money_mini.png"));
		menuBar.add(mn4);
		
		JMenuItem mn5 = new JMenuItem("Xe M\u00E1y");
		mn5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mn5.setBackground(Color.WHITE);
		mn5.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\icon\\shipping32.png"));
		menuBar.add(mn5);
		
		JMenuItem mn6 = new JMenuItem("T\u00ECm Ki\u1EBFm");
		mn6.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mn6.setBackground(Color.WHITE);
		mn6.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\icon\\search_32.png"));
		menuBar.add(mn6);
		
		JMenuItem mn7 = new JMenuItem("Th\u1ED1ng K\u00EA");
		mn7.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mn7.setBackground(Color.WHITE);
		mn7.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\icon\\bar-chart-32.png"));
		menuBar.add(mn7);
		
		JMenuItem mn8 = new JMenuItem("Help");
		mn8.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mn8.setBackground(Color.WHITE);
		mn8.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\icon\\question.png"));
		menuBar.add(mn8);
		
		JPanel south = new JPanel();
		south.setBackground(Color.WHITE);
		contentPane.add(south, BorderLayout.SOUTH);
		south.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblAka = new JLabel("LÊ HOÀNG HIỆN aka daVi");
		south.add(lblAka);
		
		JPanel west = new JPanel();
		west.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		west.setBackground(Color.WHITE);
		contentPane.add(west, BorderLayout.WEST);
		west.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\icon\\plus-32.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		west.add(btnNewButton, "2, 2");
		
		JButton btnNewButton_1 = new JButton("Xoá");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\icon\\remove-32.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		west.add(btnNewButton_1, "2, 4");
		
		JButton btnNewButton_2 = new JButton("Cập nhật");
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\icon\\sync-32.png"));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		west.add(btnNewButton_2, "2, 6");
		
		JButton btnNewButton_3 = new JButton("Tìm kiếm");
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\icon\\search_32.png"));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		west.add(btnNewButton_3, "2, 8");
		
		JButton btnNewButton_4 = new JButton("Option");
		btnNewButton_4.setEnabled(false);
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		west.add(btnNewButton_4, "2, 10");
		
		JButton btnNewButton_5 = new JButton("Option");
		btnNewButton_5.setEnabled(false);
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		west.add(btnNewButton_5, "2, 12");
		
		JButton btnNewButton_6 = new JButton("Đăng xuất");
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\icon\\paper-plane.png"));
		btnNewButton_6.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 24));
		west.add(btnNewButton_6, "2, 14");
		
		JPanel center = new JPanel();
		center.setBackground(Color.YELLOW);
		contentPane.add(center, BorderLayout.CENTER);
		center.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		center.add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[46px][grow][][grow][]", "[14px][][][]"));
		
		JLabel lblNewLabel = new JLabel("H\u1ECD v\u00E0 T\u00EAn:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewLabel, "cell 0 0,alignx leading,aligny top");
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(textField, "cell 1 0,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ch\u1EE9c v\u1EE5:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewLabel_1, "cell 2 0,alignx leading");
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(textField_1, "cell 3 0,growx");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewLabel_2, "cell 0 1,alignx leading");
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(textField_5, "cell 1 1,growx");
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Gi\u1EDBi t\u00EDnh:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewLabel_5, "cell 2 1,alignx leading");
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(textField_6, "cell 3 1,growx");
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewLabel_3, "cell 0 2,alignx leading");
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(textField_4, "cell 1 2,growx");
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewLabel_6, "cell 2 2,alignx leading");
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(textField_7, "cell 3 2,growx");
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Ng\u00E0y sinh:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewLabel_4, "cell 0 3,alignx leading");
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(textField_2, "cell 1 3,growx");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Ng\u00E0y v\u00E0o l\u00E0m:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewLabel_7, "cell 2 3,alignx leading");
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(textField_3, "cell 3 3,growx");
		textField_3.setColumns(10);
		
		String[] col = { "Mã sách", "Tựa sách", "Tác giả", "Năm xuất bản", "Nhà xuất bản", "Số trang", "Đơn giá", "ISBN" };
		tableModel = new DefaultTableModel(col, 0);
		table = new JTable(tableModel);
		table.setBackground(Color.WHITE);
		center.add(new JScrollPane(table), BorderLayout.CENTER);
	}
}
