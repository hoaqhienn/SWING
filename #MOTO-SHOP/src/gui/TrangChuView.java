package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;

public class TrangChuView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnDangXuat;
	private JButton btnHopDong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChuView frame = new TrangChuView();
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
	public TrangChuView() {
		setTitle("PHẦN MỀM QUẢN LÝ CỬA HÀNG XE MÁY");
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\GIT\\SWING\\#MOTO-SHOP\\img\\cogwheel.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1366, 768);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pWest = new JPanel();
		pWest.setBackground(Color.YELLOW);
		contentPane.add(pWest, BorderLayout.WEST);
		pWest.setLayout(new BorderLayout(0, 0));
		
		JPanel pBtnMenu = new JPanel();
		pWest.add(pBtnMenu, BorderLayout.NORTH);
		pBtnMenu.setBackground(Color.WHITE);
		pBtnMenu.setBorder(new CompoundBorder(new EmptyBorder(10, 10, 10, 10), new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ch\u1EE9c n\u0103ng ch\u00EDnh", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))));
		pBtnMenu.setLayout(new MigLayout("", "[fill]", "[][][][][][][][][]"));
		
		btnHopDong = new JButton("HỢP ĐỒNG");
		btnHopDong.addActionListener(this);
		btnHopDong.setBackground(Color.WHITE);
		btnHopDong.setHorizontalAlignment(SwingConstants.LEFT);
		btnHopDong.setIcon(new ImageIcon("E:\\GIT\\SWING\\#MOTO-SHOP\\img\\paper_minipng.png"));
		btnHopDong.setFont(new Font("Tahoma", Font.BOLD, 24));
		pBtnMenu.add(btnHopDong, "cell 0 0");
		
		JButton btnThanhToan = new JButton("THANH TOÁN");
		btnThanhToan.setBackground(Color.WHITE);
		btnThanhToan.setHorizontalAlignment(SwingConstants.LEFT);
		btnThanhToan.setIcon(new ImageIcon("E:\\GIT\\SWING\\#MOTO-SHOP\\img\\share-32.png"));
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 24));
		pBtnMenu.add(btnThanhToan, "cell 0 1");
		
		JButton btnBaoHanh = new JButton("BẢO HÀNH");
		btnBaoHanh.setBackground(Color.WHITE);
		btnBaoHanh.setIcon(new ImageIcon("E:\\GIT\\SWING\\#MOTO-SHOP\\img\\medal.png"));
		btnBaoHanh.setHorizontalAlignment(SwingConstants.LEFT);
		btnBaoHanh.setFont(new Font("Tahoma", Font.BOLD, 24));
		pBtnMenu.add(btnBaoHanh, "cell 0 2");
		
		JButton btnKhachHang = new JButton("KHÁCH HÀNG");
		btnKhachHang.setBackground(Color.WHITE);
		btnKhachHang.setIcon(new ImageIcon("E:\\GIT\\SWING\\#MOTO-SHOP\\img\\money_mini.png"));
		btnKhachHang.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		pBtnMenu.add(btnKhachHang, "cell 0 3");
		
		JButton btnNhanVien = new JButton("NHÂN VIÊN");
		btnNhanVien.setBackground(Color.WHITE);
		btnNhanVien.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhanVien.setIcon(new ImageIcon("E:\\GIT\\SWING\\#MOTO-SHOP\\img\\emp-32.png"));
		pBtnMenu.add(btnNhanVien, "cell 0 4");
		
		JButton btnSanPham = new JButton("SẢN PHẨM");
		btnSanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SanPhamView().setVisible(true);
			}
		});
		btnSanPham.setBackground(Color.WHITE);
		btnSanPham.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnSanPham.setHorizontalAlignment(SwingConstants.LEFT);
		btnSanPham.setIcon(new ImageIcon("E:\\GIT\\SWING\\#MOTO-SHOP\\img\\shipping32.png"));
		pBtnMenu.add(btnSanPham, "cell 0 5");
		
		JButton btnThongKe = new JButton("THỐNG KÊ");
		btnThongKe.setBackground(Color.WHITE);
		btnThongKe.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		btnThongKe.setIcon(new ImageIcon("E:\\GIT\\SWING\\#MOTO-SHOP\\img\\bar-chart-32.png"));
		pBtnMenu.add(btnThongKe, "cell 0 6");
		
		btnDangXuat = new JButton("ĐĂNG XUẤT");
		btnDangXuat.addActionListener(this);
		btnDangXuat.setBackground(Color.WHITE);
		btnDangXuat.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnDangXuat.setHorizontalAlignment(SwingConstants.LEFT);
		btnDangXuat.setIcon(new ImageIcon("E:\\GIT\\SWING\\#MOTO-SHOP\\img\\logout.png"));
		pBtnMenu.add(btnDangXuat, "cell 0 7");
		
		JButton btnThongTin = new JButton("THÔNG TIN");
		btnThongTin.setBackground(Color.WHITE);
		btnThongTin.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnThongTin.setHorizontalAlignment(SwingConstants.LEFT);
		btnThongTin.setIcon(new ImageIcon("E:\\GIT\\SWING\\#MOTO-SHOP\\img\\question.png"));
		pBtnMenu.add(btnThongTin, "cell 0 8");
		
		JPanel pTime = new JPanel();
		pTime.setBackground(Color.WHITE);
		pWest.add(pTime, BorderLayout.SOUTH);
		
		JLabel dateTimeLabel = new JLabel();
		dateTimeLabel.setBackground(Color.WHITE);
		dateTimeLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String dateTime = dateFormat.format(new Date());
                dateTimeLabel.setText(dateTime);
            }
        }, 0, 1000);
        
        pTime.add(dateTimeLabel);
        
        JPanel pCenter = new JPanel();
        pCenter.setBackground(Color.WHITE);
        contentPane.add(pCenter, BorderLayout.CENTER);
        pCenter.setLayout(new BoxLayout(pCenter, BoxLayout.X_AXIS));
        
        Component glue1 = Box.createHorizontalGlue();
        pCenter.add(glue1);
        
        JLabel img = new JLabel("");
        img.setHorizontalAlignment(SwingConstants.CENTER);
        img.setIcon(new ImageIcon("E:\\GIT\\SWING\\#MOTO-SHOP\\img\\avatar.png"));
        pCenter.add(img);
        
        Component glue2 = Box.createHorizontalGlue();
        pCenter.add(glue2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnDangXuat)) {
			dispose();
			new LoginFrame().setVisible(true);
		}
		else if (o.equals(btnHopDong)) {
			dispose();
			new HopDongView().setVisible(true);
		}
		
	}
}
