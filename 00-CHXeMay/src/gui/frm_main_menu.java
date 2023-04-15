package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;

public class frm_main_menu extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox_1;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_main_menu frame = new frm_main_menu();
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
	public frm_main_menu() {
		setTitle("Ph\u1EA7n M\u1EC1m Qu\u1EA3n L\u00FD C\u1EEDa H\u00E0ng Xe M\u00E1y");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pNorth = new JPanel();
		pNorth.setBorder(new TitledBorder(null, "\u0110\u0103ng nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		String[] phong = {"phong to chuc", "Phong ky thuat", "Phong nhan su", "Phong tai vu"};		
		pNorth.add(comboBox = new JComboBox(phong));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ROLE - ID - Name", "", "Phong ky thuat", "Phong nhan su", "Phong tai vu", "Le Hoang Hien"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setMaximumRowCount(100);
		
		JButton btnNewButton = new JButton("\u0110\u0103ng nh\u1EADp");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pNorth.add(btnNewButton);
		

		
		
		JPanel pCenter = new JPanel();
		pCenter.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng ch\u00EDnh", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel pContent = new JPanel();
		pContent.setBorder(new EmptyBorder(100, 50, 100, 50));
		pCenter.add(pContent);
		pContent.setLayout(new GridLayout(0, 3, 50, 30));
		
		JButton btn1 = new JButton("HO\u00C1 \u0110\u01A0N");
		btn1.setFont(new Font("Tahoma", Font.BOLD, 30));
		pContent.add(btn1);
		
		JButton btn2 = new JButton("B\u1EA2O H\u00C0NH");
		btn2.setFont(new Font("Tahoma", Font.BOLD, 30));
		pContent.add(btn2);
		
		JButton btn3 = new JButton("THANH TO\u00C1N");
		btn3.setFont(new Font("Tahoma", Font.BOLD, 30));
		pContent.add(btn3);
		
		JButton btn4 = new JButton("NH\u00C2N VI\u00CAN");
		btn4.setFont(new Font("Tahoma", Font.BOLD, 30));
		pContent.add(btn4);
		
		JButton btn5 = new JButton("XE M\u00C1Y");
		btn5.setFont(new Font("Tahoma", Font.BOLD, 30));
		pContent.add(btn5);
		
		JButton btn6 = new JButton("TH\u1ED0NG K\u00CA / T\u00CCM KI\u1EBEM");
		btn6.setFont(new Font("Tahoma", Font.BOLD, 30));
		pContent.add(btn6);
	}

}
