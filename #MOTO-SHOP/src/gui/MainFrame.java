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
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.*;
import entity.KhachHang;
import entity.NhanVien;
import entity.XeMay;

import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Component;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.JLayeredPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.ComponentOrientation;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;



public class MainFrame extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTable table;
	private JTable table_1;
	private DefaultTableModel tableModel;

	private XeMay_DAO xeMay;
	private NhanVien_DAO nhanVien;
	private DefaultTableModel tableModel2;
	private DefaultTableModel tableModel3;
	private Khachhang_DAO khachHang;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setTitle("PHẦN MỀM QUẢN LÝ CỬA HÀNG XE MÁY");
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\GIT\\SWING\\#MOTO-SHOP\\img\\cogwheel.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1366, 768);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		xeMay = new XeMay_DAO();
		nhanVien = new NhanVien_DAO();
		khachHang = new Khachhang_DAO();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBackground(Color.WHITE);
		
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JTabbedPane tpHT = new JTabbedPane(JTabbedPane.LEFT);
		tpHT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tpHT.setBackground(Color.WHITE);
		tpHT.setAlignmentY(Component.TOP_ALIGNMENT);
		tabbedPane.addTab("HỆ THỐNG", new ImageIcon("E:\\GIT\\SWING\\#MOTO-SHOP\\img\\paper_minipng.png"), tpHT, null);
		
		JPanel pThongTin = new JPanel();
		pThongTin.setBorder(new EmptyBorder(10, 10, 10, 10));
		pThongTin.setBackground(Color.WHITE);
		tpHT.addTab("Thông Tin", null, pThongTin, null);
		pThongTin.setLayout(new BorderLayout(0, 0));
		
		JLabel info = new JLabel("CODE BY: LÊ HOÀNG HIỆN - VÕ TRỌNG TÀI - BÙI NHẬT TÂM");
		info.setForeground(SystemColor.textHighlight);
		info.setFont(new Font("Tahoma", Font.BOLD, 24));
		info.setHorizontalAlignment(SwingConstants.CENTER);
		pThongTin.add(info, BorderLayout.SOUTH);
		
		JLabel img = new JLabel("");
		img.setIcon(new ImageIcon("E:\\GIT\\SWING\\#MOTO-SHOP\\img\\bia.png"));
		img.setHorizontalAlignment(SwingConstants.CENTER);
		pThongTin.add(img, BorderLayout.CENTER);
		
		JLabel dateTimeLabel = new JLabel("date-time");
		dateTimeLabel.setForeground(SystemColor.textHighlight);
		dateTimeLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		dateTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
  
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss - dd/MM/yyyy");
                String dateTime = dateFormat.format(new Date());
                dateTimeLabel.setText(dateTime);
            }
        }, 0, 1000);
        
		pThongTin.add(dateTimeLabel, BorderLayout.NORTH);	

		
		
		JPanel pTaiKhoan = new JPanel();
		tpHT.addTab("Tài Khoản", null, pTaiKhoan, null);
		tpHT.setEnabledAt(1, false);
		
		JTabbedPane tpHD = new JTabbedPane(JTabbedPane.LEFT);
		tpHD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tabbedPane.addTab("KHÁCH HÀNG", new ImageIcon("E:\\GIT\\SWING\\#MOTO-SHOP\\img\\money_mini.png"), tpHD, null);
		
		String[] col3 = { "Mã Khách Hàng", "Tên Khách Hàng", "Số CMT", "Địa Chỉ", "Số Điện Thoại", "Email"};
		tableModel3 = new DefaultTableModel(col3, 0);
		
		JPanel pHopDong = new JPanel();
		tpHD.addTab("Hợp Đồng", null, pHopDong, null);
		
		JPanel pThanhToan = new JPanel();
		tpHD.addTab("Thanh Toán", null, pThanhToan, null);
		
		JPanel pBaoHanh = new JPanel();
		tpHD.addTab("Bảo Hành", null, pBaoHanh, null);
		
		JPanel pKhachHang = new JPanel();
		tpHD.addTab("Khách Hàng", null, pKhachHang, null);
		pKhachHang.setLayout(new BorderLayout(0, 0));
		
		JPanel TableDSKH = new JPanel();
		TableDSKH.setBorder(new CompoundBorder(new EmptyBorder(10, 10, 10, 10), new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))));
		pKhachHang.add(TableDSKH, BorderLayout.CENTER);
		TableDSKH.setLayout(new BorderLayout(0, 0));
		table = new JTable(tableModel3);
		table.setBackground(Color.WHITE);
		TableDSKH.add(new JScrollPane(table));
		
				
				JPanel EditKH = new JPanel();
				EditKH.setBorder(new CompoundBorder(new EmptyBorder(10, 10, 10, 10), new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))));
				pKhachHang.add(EditKH, BorderLayout.SOUTH);
				EditKH.setLayout(new MigLayout("", "[right][fill][right][][fill]", "[][][][top]"));
				
				JLabel lblNewLabel = new JLabel("Mã KH:");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
				EditKH.add(lblNewLabel, "cell 0 0,alignx trailing");
				
				textField = new JTextField();
				textField.setEditable(false);
				textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
				EditKH.add(textField, "cell 1 0,growx");
				textField.setColumns(30);
				
				JLabel lblNewLabel_1 = new JLabel("Địa chỉ:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
				EditKH.add(lblNewLabel_1, "cell 2 0,alignx trailing");
				
				textField_1 = new JTextField();
				textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
				EditKH.add(textField_1, "cell 3 0,growx");
				textField_1.setColumns(30);
				
				JButton btnNewButton = new JButton("Thêm Khách Hàng");
				btnNewButton.setBackground(new Color(0, 255, 255));
				btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
				EditKH.add(btnNewButton, "cell 4 0");
				
				JLabel lblNewLabel_2 = new JLabel("Tên KH:");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
				EditKH.add(lblNewLabel_2, "cell 0 1,alignx trailing");
				
				textField_2 = new JTextField();
				textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
				EditKH.add(textField_2, "cell 1 1,growx");
				textField_2.setColumns(10);
				
				JLabel lblNewLabel_4 = new JLabel("Số điện thoại:");
				lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
				EditKH.add(lblNewLabel_4, "cell 2 1,alignx trailing");
				
				textField_3 = new JTextField();
				textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
				EditKH.add(textField_3, "cell 3 1,growx");
				textField_3.setColumns(10);
				
				JButton btnNewButton_2 = new JButton("Cập Nhật");
				btnNewButton_2.setBackground(Color.YELLOW);
				btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
				EditKH.add(btnNewButton_2, "cell 4 1");
				
				JLabel lblNewLabel_3 = new JLabel("Ngày sinh:");
				lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
				EditKH.add(lblNewLabel_3, "cell 0 2");
				
				
				JDateChooser dateChooser = new JDateChooser();
				dateChooser.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 16));
				dateChooser.setDateFormatString("dd/mm/yyyy");
				
				EditKH.add(dateChooser, "flowx,cell 1 2,grow");
				
				JRadioButton rGender = new JRadioButton("Nữ");
				rGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
				EditKH.add(rGender, "cell 1 2");
				
				JLabel lblNewLabel_5 = new JLabel("Lịch Sử:");
				lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
				EditKH.add(lblNewLabel_5, "cell 2 2,alignx trailing");
				
				JButton btnNewButton_5 = new JButton("Xem Lịch Sử");
				btnNewButton_5.setBackground(new Color(255, 255, 255));
				btnNewButton_5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
				EditKH.add(btnNewButton_5, "cell 4 2");
				
				JLabel lblNewLabel_6 = new JLabel("Ghi chú:");
				lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
				EditKH.add(lblNewLabel_6, "cell 0 3");
				
				JTextArea textArea = new JTextArea();
				textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
				textArea.setRows(3);
				
				textArea.setLineWrap(true);
				textArea.setWrapStyleWord(true);
				
				JScrollPane scrollPane = new JScrollPane(textArea);
				//		scrollPane.setPreferredSize(new Dimension(250, 150));
						
						EditKH.add(scrollPane, "cell 1 3,grow");
						
						JLabel lblNewLabel_7 = new JLabel("Tìm kiếm:");
						lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
						EditKH.add(lblNewLabel_7, "cell 2 3,alignx trailing,aligny top");
						
						textField_5 = new JTextField();
						textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
						EditKH.add(textField_5, "flowx,cell 3 3,growx,aligny top");
						textField_5.setColumns(10);
						
						JComboBox comboBox = new JComboBox();
						comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
						comboBox.setModel(new DefaultComboBoxModel(new String[] {"VIP", "Trả góp"}));
						EditKH.add(comboBox, "flowx,cell 3 2,growx");
						
						JButton btnNewButton_4 = new JButton("Tìm Kiếm");
						btnNewButton_4.setBackground(Color.WHITE);
						btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
						EditKH.add(btnNewButton_4, "cell 4 3");
		
		JTabbedPane tpNV = new JTabbedPane(JTabbedPane.LEFT);
		tpNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tabbedPane.addTab("NHÂN VIÊN", new ImageIcon("E:\\GIT\\SWING\\#MOTO-SHOP\\img\\emp-32.png"), tpNV, null);
		
		JPanel pDSNhanVien = new JPanel();
		tpNV.addTab("Danh Sách Nhân Viên", null, pDSNhanVien, null);
		
		String[] nv_header = { "ID", "Họ và Tên", "Địa Chỉ", "Số Điện Thoại", "Ngày Sinh", "Nữ", "Chức Vụ", "Trình Độ Học Vấn", "Mức Lương", "Ngày Vào Làm"};
		tableModel2 = new DefaultTableModel(nv_header, 0);
		pDSNhanVien.setLayout(new BorderLayout(0, 0));
		table_1 = new JTable(tableModel2);
		table_1.setBackground(Color.WHITE);
		pDSNhanVien.add(new JScrollPane(table_1));
		
		JPanel pTTNhanVien = new JPanel();
		tpNV.addTab("Thông Tin Nhân Viên", null, pTTNhanVien, null);
		
		JTabbedPane tbXM = new JTabbedPane(JTabbedPane.LEFT);
		tbXM.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tabbedPane.addTab("XE MÁY", new ImageIcon("E:\\GIT\\SWING\\#MOTO-SHOP\\img\\shipping32.png"), tbXM, null);
		
		JPanel pListXe = new JPanel();
		tbXM.addTab("Danh Sách Xe", null, pListXe, null);
		
		JPanel pAddXe = new JPanel();
		tbXM.addTab("Nhập Xe Máy", null, pAddXe, null);
		pAddXe.setLayout(new BorderLayout(0, 0));
		
		JPanel TableDSSP = new JPanel();	
		TableDSSP.setBorder(new CompoundBorder(new EmptyBorder(10, 10, 10, 10), new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))));
		pAddXe.add(TableDSSP, BorderLayout.CENTER);
		
		String[] header = { "ID", "Brand", "Model", "Capacity", "Năm sản xuất", "màu", "Số khung", "Số sườn", "Giá nhập", "Giá bán", "Trạng thái"};
		tableModel = new DefaultTableModel(header, 0);
		TableDSSP.setLayout(new BorderLayout(0, 0));
		table_1 = new JTable(tableModel);
		table_1.setBackground(Color.WHITE);
		TableDSSP.add(new JScrollPane(table_1));
		
		JPanel EditSP = new JPanel();
		EditSP.setBorder(new CompoundBorder(new EmptyBorder(10, 10, 10, 10), new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))));
		pAddXe.add(EditSP, BorderLayout.SOUTH);
		EditSP.setLayout(new MigLayout("", "[]", "[]"));
		
		JPanel pUpdateXe = new JPanel();
		tbXM.addTab("Update Thông Tin", null, pUpdateXe, null);
		table_1.getColumnModel().getColumn(8).setCellRenderer(new DecimalFormatRenderer());
		table_1.getColumnModel().getColumn(9).setCellRenderer(new DecimalFormatRenderer());
		
		DocDuLieuDatabaseVaoTable();
		
		JTabbedPane tpTK = new JTabbedPane(JTabbedPane.LEFT);
		tpTK.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tabbedPane.addTab("THỐNG KÊ", new ImageIcon("E:\\GIT\\SWING\\#MOTO-SHOP\\img\\bar-chart-32.png"), tpTK, null);
		
		
		JPanel pTKTongQuan = new JPanel();
		tpTK.addTab("Tổng Quan", null, pTKTongQuan, null);
		pTKTongQuan.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel pQ1 = new JPanel();
		pTKTongQuan.add(pQ1);
		
		JLabel lblNewLabel_8 = new JLabel("Đã Nhập:");
		pQ1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Đã Bán:");
		pQ1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Tồn Kho:");
		pQ1.add(lblNewLabel_10);
		
		JPanel pQ2 = new JPanel();
		pTKTongQuan.add(pQ2);
		
		JLabel lblNewLabel_11 = new JLabel("Tổng Nhân Viên:");
		pQ2.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Quản Lý:");
		pQ2.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Nhân Viên:");
		pQ2.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Kỹ Thuật Viên:");
		pQ2.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Kế Toán:");
		pQ2.add(lblNewLabel_15);
		
		JPanel pQ3 = new JPanel();
		pTKTongQuan.add(pQ3);
		
		JLabel lblNewLabel_16 = new JLabel("Số Lượng Khách Hàng:");
		pQ3.add(lblNewLabel_16);
		
		JPanel pQ4 = new JPanel();
		pTKTongQuan.add(pQ4);
		
		JLabel lblNewLabel_17 = new JLabel("Tổng Doanh Thu:");
		pQ4.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("Bán Hàng:");
		pQ4.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Dịch Vụ:");
		pQ4.add(lblNewLabel_19);
		
		JPanel pTKXeMay = new JPanel();
		tpTK.addTab("Thống Kê Xe Máy", null, pTKXeMay, null);
		
		JPanel pTKNhanVien = new JPanel();
		tpTK.addTab("Thống Kê Nhân Viên", null, pTKNhanVien, null);
		
		JPanel pTKKhachHang = new JPanel();
		tpTK.addTab("Thống Kê Khách Hàng", null, pTKKhachHang, null);
		
		JButton DangXuat = new JButton("ĐĂNG XUẤT");
		DangXuat.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				dispose();
				new LoginFrame().setVisible(true);
			}
		});
		DangXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		tabbedPane.addTab("ĐĂNG XUẤT", new ImageIcon("E:\\GIT\\SWING\\#MOTO-SHOP\\img\\logout.png"), DangXuat, null);


	}

	private void DocDuLieuDatabaseVaoTable() {
		ArrayList<XeMay> xe = xeMay.getAll();
		for (XeMay a : xe) {
			tableModel.addRow(new Object[] {
					a.getMaXeMay(),
					a.getBrand(),
					a.getModel(),
					a.getCapacity(),
					a.getNamSX(),
					a.getMausac(),
					a.getSoKhung(),
					a.getSoSuon(),
					a.getGiaNhap(),
					a.getGiaBan(),
					a.isTrangThai()
			});
		}
		
		ArrayList<NhanVien> nv = nhanVien.getAll();
		for (NhanVien a : nv) {
			tableModel2.addRow(new Object[] {
					a.getMaNhanVien(),
					a.getTenNhanVien(),
					a.getDiaChi(),
					a.getSoDienThoai(),
					a.getNgaySinh(),
					a.isGioiTinh(),
					a.getChucVu(),
					a.getTrinhDo(),
					a.getLuong(),
					a.getNgayVaoLam()
			});
		}
		
		ArrayList<KhachHang> khach = khachHang.getAll();
		for (KhachHang a : khach) {
			tableModel3.addRow(new Object[] {
					a.getMaKhachHang(),
					a.getTenKhachHang(),
					a.getSoCMT(),
					a.getDiaChi(),
					a.getSoDienThoai(),
					a.getEmail()
			});
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
//		Object o = e.getSource();
//		if (o.equals(btnDangXuat)) {
//			dispose();
//			new LoginFrame().setVisible(true);
//		}
//		else if (o.equals(btnHopDong)) {
//			dispose();
//			new HopDongView().setVisible(true);
//		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
