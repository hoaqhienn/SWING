package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.BoxLayout;
import javax.swing.Box;
import net.miginfocom.swing.MigLayout;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class frm_bao_hanh extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel tableModel;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_bao_hanh frame = new frm_bao_hanh();
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
	public frm_bao_hanh() {
		setTitle("BẢO HÀNH");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pNorth = new JPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		JMenuBar menuBar = new JMenuBar();
		pNorth.add(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem_7);
		
		JPanel pCenter = new JPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new BorderLayout(0, 0));
		
		JPanel pContent = new JPanel();
		pCenter.add(pContent, BorderLayout.NORTH);
		pContent.setLayout(new MigLayout("", "[][200px][][200px]", "[][][]"));
		
		JLabel lblNewLabel = new JLabel("Kỹ Thuật Viên:");
		pContent.add(lblNewLabel, "cell 0 0,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"KTV9876 - Le Hoang Hien", "KTV6789 - Vo Trong Tai"}));
		pContent.add(comboBox, "cell 1 0,growx");
		
		JLabel lblNewLabel_3 = new JLabel("Tên Linh Kiện:");
		pContent.add(lblNewLabel_3, "cell 0 1,alignx trailing");
		
		textField = new JTextField();
		pContent.add(textField, "cell 1 1,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Lý Do Bảo Hành:");
		pContent.add(lblNewLabel_4, "cell 2 1,alignx trailing");
		
		textField_1 = new JTextField();
		pContent.add(textField_1, "cell 3 1,growx");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Lỗi Do:");
		pContent.add(lblNewLabel_1, "cell 0 2,alignx trailing");
		
		textField_2 = new JTextField();
		pContent.add(textField_2, "cell 1 2,growx");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("�?ơn Giá:");
		pContent.add(lblNewLabel_2, "cell 2 2,alignx trailing");
		
		textField_3 = new JTextField();
		pContent.add(textField_3, "cell 3 2,growx");
		textField_3.setColumns(10);
		
		String[] col = { "STT", "Tên linh kiện", "Lý do bảo hành", "Nguyên nhân", "Số lượng", "�?ơn giá", "Thành Ti�?n"};
		tableModel = new DefaultTableModel(col, 0);
		table = new JTable(tableModel);
		table.setBackground(Color.WHITE);
		pCenter.add(new JScrollPane(table), BorderLayout.CENTER);
		
		JPanel west = new JPanel();
		west.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		west.setBackground(Color.WHITE);
		contentPane.add(west, BorderLayout.WEST);
		west.setLayout(new MigLayout("", "[89px]", "[23px][][][][][][]"));
		
		JButton btnNewButton = new JButton("New button");
		west.add(btnNewButton, "cell 0 0");
		
		JButton btnNewButton_1 = new JButton("New button");
		west.add(btnNewButton_1, "cell 0 1");
		
		JButton btnNewButton_2 = new JButton("New button");
		west.add(btnNewButton_2, "cell 0 2");
		
		JButton btnNewButton_3 = new JButton("New button");
		west.add(btnNewButton_3, "cell 0 3");
		
		JButton btnNewButton_4 = new JButton("New button");
		west.add(btnNewButton_4, "cell 0 4");
		
		JButton btnNewButton_5 = new JButton("New button");
		west.add(btnNewButton_5, "cell 0 5");
		
		JButton btnNewButton_6 = new JButton("New button");
		west.add(btnNewButton_6, "cell 0 6");
		
		
		JPanel pSouth = new JPanel();
		contentPane.add(pSouth, BorderLayout.SOUTH);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 30));
		pSouth.add(btnLuu);
	}

}
