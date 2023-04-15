package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
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

public class frm_thong_ke extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_thong_ke frame = new frm_thong_ke();
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
	public frm_thong_ke() {
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
		
		JPanel panel = new JPanel();
		pCenter.add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[]", "[]"));
		
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
