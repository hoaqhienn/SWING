package gui;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.border.EmptyBorder;

public class LoginFrame extends JFrame implements ActionListener {
    JLabel userLabel, passLabel;
    JTextField userTextField;
    JPasswordField passTextField;
    JButton loginButton, cancelButton;
    private JPanel pNorth;
    private JPanel pWest;
    private JLabel tittle;
    private JLabel img;
    private JPanel pSouth;
    private JLabel info;
    private JPanel pCenter;

    public LoginFrame() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(".\\img\\cogwheel.png"));
        setTitle("QUẢN LÝ CỬA HÀNG XE MÁY - ĐĂNG NHẬP");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1366, 768);
        setLocationRelativeTo(null);
        
        pNorth = new JPanel();
        pNorth.setBorder(new EmptyBorder(10, 0, 0, 0));
        pNorth.setBackground(Color.WHITE);
        getContentPane().add(pNorth, BorderLayout.NORTH);
        
        tittle = new JLabel("PHẦN MỀM QUẢN LÝ CỬA HÀNG XE MÁY");
        tittle.setFont(new Font("Tahoma", Font.BOLD, 60));
        pNorth.add(tittle);
        
        pWest = new JPanel();
        pWest.setBorder(new EmptyBorder(0, 30, 0, 0));
        pWest.setBackground(Color.WHITE);
        getContentPane().add(pWest, BorderLayout.WEST);
        pWest.setLayout(new GridLayout(0, 1, 0, 0));
        
        img = new JLabel("");
        img.setIcon(new ImageIcon(".\\img\\avatar.png"));
        pWest.add(img);
        
        pSouth = new JPanel();
        pSouth.setBorder(new EmptyBorder(0, 0, 10, 0));
        pSouth.setBackground(Color.WHITE);
        getContentPane().add(pSouth, BorderLayout.SOUTH);
        
        info = new JLabel("CODE BY: LÊ HOÀNG HIỆN - VÕ TRỌNG TÀI - BÙI NHẬT TÂM");
        info.setForeground(SystemColor.textHighlight);
        info.setBackground(Color.BLACK);
        info.setFont(new Font("Tahoma", Font.BOLD, 24));
        pSouth.add(info);
                
                pCenter = new JPanel();
                pCenter.setBackground(Color.WHITE);
                pCenter.setBorder(new EmptyBorder(100, 100, 100, 100));
                getContentPane().add(pCenter, BorderLayout.CENTER);
                pCenter.setLayout(new MigLayout("", "[right][]", "[][][]"));
                
                        userLabel = new JLabel("Tài khoản:");
                        pCenter.add(userLabel, "cell 0 0");
                        userLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
                        userTextField = new JTextField(30);
                        userTextField.setText("admin");
                        pCenter.add(userTextField, "cell 1 0,growx");
                        userTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
                        passLabel = new JLabel("Mật khẩu:");
                        pCenter.add(passLabel, "cell 0 1");
                        passLabel.setHorizontalAlignment(SwingConstants.LEFT);
                        passLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
                        passTextField = new JPasswordField(30);
                        passTextField.setText("admin");
                        pCenter.add(passTextField, "cell 1 1,growx");
                        passTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
                        loginButton = new JButton("Đăng nhập");
                        pCenter.add(loginButton, "flowx,cell 1 2,growx");
                        loginButton.setIcon(new ImageIcon("E:\\GIT\\SWING\\#MOTO-SHOP\\img\\enter.png"));
                        loginButton.setBackground(Color.WHITE);
                        loginButton.setFont(new Font("Tahoma", Font.BOLD, 20));
                        cancelButton = new JButton("Hủy bỏ");
                        pCenter.add(cancelButton, "cell 1 2,growx");
                        cancelButton.setBackground(Color.WHITE);
                        cancelButton.setIcon(new ImageIcon(".\\img\\logout.png"));
                        cancelButton.setFont(new Font("Tahoma", Font.BOLD, 20));
                        cancelButton.addActionListener(this);
                        loginButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelButton) {
            System.exit(0);
        } else if (e.getSource() == loginButton) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://localhost:1433;databaseName=cuahangxemay";
                String user = "sa";
                String pass = "11111111";
                Connection con = DriverManager.getConnection(url, user, pass);

                String query = "SELECT * FROM [Account] WHERE username =? AND password=?";
                
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, userTextField.getText());
                ps.setString(2, new String(passTextField.getPassword()));
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
//                	String role = rs.getString(5);
//                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công! - " + role);
                    // điều hướng đến JFrame khác tại đây
                    dispose();
                    new MainFrame().setVisible(true);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng!");
                }

                con.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    public static void main(String[] args) {
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }
}


