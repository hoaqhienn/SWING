package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frm_admin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_admin frame = new frm_admin();
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
	public frm_admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1366, 768);
		setLocationRelativeTo(contentPane);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pNorth = new JPanel();
		pNorth.setBorder(new TitledBorder(null, "Th\u00F4ng tin c\u00E1 nh\u00E2n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pNorth.setBackground(Color.WHITE);
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new BoxLayout(pNorth, BoxLayout.X_AXIS));
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		pNorth.add(horizontalStrut);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(null);
		pNorth.add(horizontalBox);
		
		JPanel pLeft = new JPanel();
		pLeft.setBackground(Color.WHITE);
		horizontalBox.add(pLeft);
		pLeft.setLayout(new BoxLayout(pLeft, BoxLayout.X_AXIS));
		
		Box verticalBox = Box.createVerticalBox();
		pLeft.add(verticalBox);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBackground(Color.WHITE);
		verticalBox.add(horizontalBox_1);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue);
		
		JLabel lblNewLabel_4 = new JLabel("");
		horizontalBox_1.add(lblNewLabel_4);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\icon\\user.png"));
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_1);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_2);
		
		JButton btnNewButton = new JButton("\u0110\u0103ng xu\u1EA5t");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		horizontalBox_2.add(btnNewButton);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_3);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalBox.add(horizontalStrut_1);
		
		JPanel pRight = new JPanel();
		pRight.setBackground(Color.WHITE);
		horizontalBox.add(pRight);
		pRight.setBorder(new EmptyBorder(10, 10, 10, 10));
		pRight.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
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
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("H\u1ECD v\u00E0 T\u00EAn:");
		pRight.add(lblNewLabel, "2, 2");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setEditable(false);
		pRight.add(textField, "4, 2");
		textField.setColumns(20);
		
		JLabel lblNewLabel_5 = new JLabel("Ch\u1EE9c v\u1EE5:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pRight.add(lblNewLabel_5, "8, 2");
		
		textField_5 = new JTextField();
		textField_5.setBackground(Color.WHITE);
		textField_5.setEditable(false);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pRight.add(textField_5, "10, 2");
		textField_5.setColumns(20);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn:");
		pRight.add(lblNewLabel_1, "2, 4");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField_2 = new JTextField();
		textField_2.setBackground(Color.WHITE);
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pRight.add(textField_2, "4, 4");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Gi\u1EDBi T\u00EDnh:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pRight.add(lblNewLabel_6, "8, 4");
		
		textField_7 = new JTextField();
		textField_7.setBackground(Color.WHITE);
		textField_7.setEditable(false);
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pRight.add(textField_7, "10, 4");
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		pRight.add(lblNewLabel_2, "2, 6");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.WHITE);
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pRight.add(textField_1, "4, 6");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pRight.add(lblNewLabel_7, "8, 6");
		
		textField_6 = new JTextField();
		textField_6.setBackground(Color.WHITE);
		textField_6.setEditable(false);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pRight.add(textField_6, "10, 6");
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Ng\u00E0y sinh:");
		pRight.add(lblNewLabel_3, "2, 8");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField_3 = new JTextField();
		textField_3.setBackground(Color.WHITE);
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pRight.add(textField_3, "4, 8");
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Ng\u00E0y v\u00E0o l\u00E0m:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pRight.add(lblNewLabel_8, "8, 8");
		
		textField_9 = new JTextField();
		textField_9.setBackground(Color.WHITE);
		textField_9.setEditable(false);
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pRight.add(textField_9, "10, 8");
		textField_9.setColumns(10);
		
		JPanel pCenter = new JPanel();
		pCenter.setBackground(Color.WHITE);
		pCenter.setBorder(new TitledBorder(null, "Ch\u1EE9c N\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new EmptyBorder(100, 50, 100, 50));
		pCenter.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 3, 50, 30));
		
		JButton btn1 = new JButton("Nh\u00E2n Vi\u00EAn");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn1.setFont(new Font("Tahoma", Font.BOLD, 24));
		btn1.setBackground(Color.WHITE);
		btn1.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\icon\\employee.png"));
		panel_1.add(btn1);
		
		JButton btn2 = new JButton("Kh\u00E1ch H\u00E0ng");
		btn2.setBackground(Color.WHITE);
		btn2.setFont(new Font("Tahoma", Font.BOLD, 24));
		btn2.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\icon\\money.png"));
		panel_1.add(btn2);
		
		JButton btn3 = new JButton("Xe M\u00E1y  ");
		btn3.setBackground(Color.WHITE);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn3.setFont(new Font("Tahoma", Font.BOLD, 24));
		btn3.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\icon\\shipping.png"));
		panel_1.add(btn3);
		
		JButton btn4 = new JButton("Ho\u00E1 \u0110\u01A1n  ");
		btn4.setBackground(Color.WHITE);
		btn4.setFont(new Font("Tahoma", Font.BOLD, 24));
		btn4.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\icon\\paper.png"));
		panel_1.add(btn4);
		
		JButton btn5 = new JButton("Th\u1ED1ng K\u00EA  ");
		btn5.setBackground(Color.WHITE);
		btn5.setFont(new Font("Tahoma", Font.BOLD, 24));
		btn5.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\icon\\bar-chart.png"));
		panel_1.add(btn5);
		
		JButton btn6 = new JButton("T\u00ECm Ki\u1EBFm");
		btn6.setBackground(Color.WHITE);
		btn6.setFont(new Font("Tahoma", Font.BOLD, 24));
		btn6.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\icon\\index.png"));
		panel_1.add(btn6);
	}
}
