package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MayTinh extends JFrame implements ActionListener {
    private JButton btnGiai, btnXoa, btnThoat;

    
    private JTextField tfNum1, tfNum2, tfNum3, tfResult;
    private Container cont;
    private JPanel panel1, panel2, panela, panel3, panel4;
    private JRadioButton radA, radB, radC, radD;

    public MayTinh(String title) {
        super(title);
        cont = this.getContentPane();
        
        JLabel A = new JLabel("CỘNG TRỪ NHÂN CHIA");
        A.setFont(new Font("Times New Roman", Font.BOLD, 30));
        
        JLabel lbNum1 = new JLabel("Nhập a: ");
        tfNum1 = new JTextField(20);
        JLabel lbNum2 = new JLabel("Nhập b: ");
        tfNum2 = new JTextField(20);

        JLabel lbResult = new JLabel("Kết quả: ");
        tfResult = new JTextField(20);
        tfResult.setEditable(false);


        panel1 = new JPanel();
        panel1.add(A);
        panel1.setBackground(Color.cyan);
        
        btnGiai= new JButton("Giải");
        btnXoa = new JButton("Xoá rỗng");
        btnThoat = new JButton("Thoát");
        
        panel2 = new JPanel();
//        panel2.setLayout(new GridLayout(4, 2));
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

        Box box1 = Box.createHorizontalBox();
        lbNum1.setAlignmentX(Component.LEFT_ALIGNMENT);
        box1.add(lbNum1);
        box1.add(Box.createHorizontalStrut(35)); 
        box1.add(tfNum1);
        
        Box box2 = Box.createHorizontalBox();
        lbNum1.setAlignmentX(Component.LEFT_ALIGNMENT);
        box2.add(lbNum2);
        box2.add(Box.createHorizontalStrut(35)); 
        box2.add(tfNum2);
        
        Box box3 = Box.createHorizontalBox();
        panela = new JPanel();
        box3.add(panela);
        panela.setBorder(BorderFactory.createTitledBorder("Phép toán"));
        panela.setLayout(new GridLayout(2,2));
        radA = new JRadioButton("Cộng");
        radB = new JRadioButton("Trừ");
        radC = new JRadioButton("Nhân");
        radD = new JRadioButton("Chia");
        panela.add(radA);
        panela.add(radB);
        panela.add(radC);
        panela.add(radD);
        ButtonGroup group = new ButtonGroup();
        group.add (radA);
        group.add (radB);
        group.add (radC);
        group.add (radD);
        
        
        Box box4 = Box.createHorizontalBox();
        lbNum1.setAlignmentX(Component.LEFT_ALIGNMENT);
        box4.add(lbResult);
        box4.add(Box.createRigidArea(new Dimension(30,0))); 
        box4.add(tfResult);
        
        panel2.add(Box.createVerticalStrut(10));
        panel2.add(box1);
        panel2.add(Box.createVerticalStrut(10));
        panel2.add(box2);
        panel2.add(Box.createVerticalStrut(10));
        panel2.add(box3);
        panel2.add(Box.createVerticalStrut(10));
        panel2.add(box4);
        panel2.setBorder(BorderFactory.createTitledBorder("Tính toán"));

        panel3 = new JPanel();
        panel3.add(btnGiai);
        panel3.add(btnXoa);
        panel3.add(btnThoat);
        panel3.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
        panel3.setLayout(new GridLayout(3,1));
        
        panel4 = new JPanel();
        JButton a = new JButton("");
        a.setBackground(Color.BLUE);
        a.setPreferredSize(new Dimension(30, 30));
        panel4.add(a);
        JButton b = new JButton("");
        b.setBackground(Color.RED);
        b.setPreferredSize(new Dimension(30, 30));
        panel4.add(b);
        JButton c = new JButton("");
        c.setBackground(Color.YELLOW);
        c.setPreferredSize(new Dimension(30, 30));
        panel4.add(c);
        panel4.setBackground(Color.PINK);
            
        cont.add(panel1, "North");
        cont.add(panel2, "Center");
        cont.add(panel3, "West");
        cont.add(panel4, "South");
        
        radA.addActionListener(this);
        radB.addActionListener(this);
        radC.addActionListener(this);
        radD.addActionListener(this);
        
        btnGiai.addActionListener(this);
        btnXoa.addActionListener(this);
        btnThoat.addActionListener(this);
        
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void cong() {
        double num1 = Double.parseDouble(tfNum1.getText());
        double num2 = Double.parseDouble(tfNum2.getText());
        double result = num1 + num2;
        tfResult.setText(String.valueOf(result));
    }

    public void tru() {
        double num1 = Double.parseDouble(tfNum1.getText());
        double num2 = Double.parseDouble(tfNum2.getText());
        double result = num1 - num2;
        tfResult.setText(String.valueOf(result));
    }
    
    public void nhan() {
        double num1 = Double.parseDouble(tfNum1.getText());
        double num2 = Double.parseDouble(tfNum2.getText());
        double result = num1 * num2;
        tfResult.setText(String.valueOf(result));
    }

    public void chia() {
        double num1 = Double.parseDouble(tfNum1.getText());
        double num2 = Double.parseDouble(tfNum2.getText());
        double result = num1 / num2;
        tfResult.setText(String.valueOf(result));
    }
    
    public void xoa() {
    	tfNum1.setText("");
    	tfNum2.setText("");
    	tfResult.setText("");
    }
    
    public void thoat() {
    	System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	if (e.getActionCommand() == "Giải") {
			if (radA.isSelected()) {
				cong();
			} else if (radB.isSelected()) {
				tru();
			} else if (radC.isSelected()) {
				nhan();
			} else if (radD.isSelected()) {
				chia();
			}
        } else if (e.getActionCommand() == "Xoá rỗng") {
        	xoa();
        } else if (e.getActionCommand() == "Thoát") {
        	thoat();
        }
    }
    public static void main(String[] args) {
        MayTinh a = new MayTinh("^_^");
    }
}



