package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.Toolkit;

public class frm_login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_login frame = new frm_login();
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
	public frm_login() {
		setTitle("H\u1EC6 TH\u1ED0NG QU\u1EA2N L\u00DD C\u1EECA H\u00C0NG XE M\u00C1Y");
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\GIT\\SWING\\00-Project\\src\\icon\\cogwheel.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 768);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(50, 50, 50, 50));
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pW = new JPanel();
		pW.setBackground(Color.WHITE);
		contentPane.add(pW, BorderLayout.WEST);
		pW.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel avatar = new JLabel("");
		avatar.setBackground(Color.WHITE);
		avatar.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\icon\\avatar.png"));
		pW.add(avatar);
		
		JPanel pC = new JPanel();
		pC.setBackground(Color.WHITE);
		contentPane.add(pC, BorderLayout.CENTER);
		pC.setLayout(new BoxLayout(pC, BoxLayout.X_AXIS));
		
		Box verticalBox = Box.createVerticalBox();
		pC.add(verticalBox);
		
		Component verticalStrut_3 = Box.createVerticalStrut(100);
		verticalBox.add(verticalStrut_3);
		
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_1);
		
		JLabel lblNewLabel = new JLabel("QU\u1EA2N L\u00DD C\u1EECA H\u00C0NG XE M\u00C1Y");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		horizontalBox.add(lblNewLabel);
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		horizontalBox.add(horizontalStrut_9);
		
		Component verticalStrut = Box.createVerticalStrut(150);
		verticalBox.add(verticalStrut);
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox.add(verticalBox_1);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_1);
		
		Component horizontalStrut = Box.createHorizontalStrut(100);
		horizontalBox_1.add(horizontalStrut);
		
		Box verticalBox_2 = Box.createVerticalBox();
		horizontalBox_1.add(verticalBox_2);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00E0i kho\u1EA3n:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		verticalBox_2.add(lblNewLabel_1);
		
		Component verticalStrut_1 = Box.createVerticalStrut(50);
		verticalBox_2.add(verticalStrut_1);
		
		JLabel lblNewLabel_2 = new JLabel("M\u1EADt kh\u1EA9u:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		verticalBox_2.add(lblNewLabel_2);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(50);
		horizontalBox_1.add(horizontalStrut_1);
		
		Box verticalBox_3 = Box.createVerticalBox();
		horizontalBox_1.add(verticalBox_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		verticalBox_3.add(textField);
		textField.setColumns(10);
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		verticalBox_3.add(verticalStrut_5);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		verticalBox_3.add(textField_1);
		textField_1.setColumns(10);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(50);
		horizontalBox_1.add(horizontalStrut_2);
		
		Component verticalStrut_2 = Box.createVerticalStrut(50);
		verticalBox.add(verticalStrut_2);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_3);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox_3.add(horizontalGlue_2);
		
		JButton btnNewButton_2 = new JButton("\u0110\u0103ng Nh\u1EADp");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_2.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\icon\\enter.png"));
		horizontalBox_3.add(btnNewButton_2);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		horizontalBox_3.add(horizontalStrut_7);
		
		JButton btnNewButton_1 = new JButton("Xo\u00E1 R\u1ED7ng");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_1.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\icon\\trash.png"));
		horizontalBox_3.add(btnNewButton_1);
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		horizontalBox_3.add(horizontalStrut_8);
		
		JButton btnNewButton = new JButton("Tho\u00E1t");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setIcon(new ImageIcon("E:\\GIT\\SWING\\00-Project\\src\\icon\\logout.png"));
		horizontalBox_3.add(btnNewButton);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		horizontalBox_3.add(horizontalStrut_6);
		
		Component verticalStrut_4 = Box.createVerticalStrut(100);
		verticalBox.add(verticalStrut_4);
	}

}
