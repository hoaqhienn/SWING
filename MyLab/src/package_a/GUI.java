package package_a;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JTable;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpringLayout;
import javax.swing.JRadioButton;
import javax.swing.Box;
import javax.swing.DefaultCellEditor;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JMenuItem;
import javax.swing.border.LineBorder;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private DefaultTableModel model;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmExit = mnNewMenu.add(action);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		mntmExit.setText("Exit");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setForeground(Color.BLUE);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Nh\u1EADp m\u00E3 s\u1ED1 c\u1EA7n t\u00ECm: ");
		panel_3.add(lblNewLabel_1);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(20);
		
		JButton btnNewButton_4 = new JButton("T\u00ECm ki\u1EBFm");
		panel_3.add(btnNewButton_4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(panel_4);
		
		JButton btnNewButton = new JButton("Th\u00EAm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Xo\u00E1 tr\u1EAFng");
		panel_4.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Xo\u00E1");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_4.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("L\u01B0u");
		panel_4.add(btnNewButton_3);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.NORTH);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{874, 0};
		gbl_panel_5.rowHeights = new int[]{83, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		Box verticalBox = Box.createVerticalBox();
		GridBagConstraints gbc_verticalBox = new GridBagConstraints();
		gbc_verticalBox.fill = GridBagConstraints.BOTH;
		gbc_verticalBox.gridx = 0;
		gbc_verticalBox.gridy = 0;
		panel_5.add(verticalBox, gbc_verticalBox);
		
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);
		
		
		JLabel lblNewLabel_2 = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn:");
		horizontalBox.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		horizontalBox.add(textField_1);
		textField_1.setColumns(10);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);
		
		JLabel lblNewLabel_3 = new JLabel("H\u1ECD:");
		horizontalBox_2.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		horizontalBox_2.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("T\u00EAn nh\u00E2n vi\u00EAn:");
		horizontalBox_2.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		horizontalBox_2.add(textField_2);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);
		
		JLabel lblNewLabel_5 = new JLabel("Tu\u1ED5i:");
		horizontalBox_1.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		horizontalBox_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Ph\u00E1i:");
		horizontalBox_1.add(lblNewLabel_6);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Nam");
		horizontalBox_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("N\u1EEF");
		horizontalBox_1.add(rdbtnNewRadioButton_1);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_3);
		
		JLabel lblNewLabel_7 = new JLabel("L\u01B0\u01A1ng:");
		horizontalBox_3.add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		horizontalBox_3.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6, BorderLayout.CENTER);
		
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
		
		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setPreferredSize(new Dimension(850, 300));
		panel_6.add(sp);
		
		
		
		
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
