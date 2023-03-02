package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bai1b extends JFrame implements ActionListener {
    private JButton btnGiai, btnXoa, btnThoat;

    
    private JTextField tfNum1, tfNum2, tfNum3, tfResult;
    private Container cont;
    private JPanel panel1, panel2, panel21, panel22, panel23, panel24, panel3;

    public Bai1b(String title) {
        super(title);
        cont = this.getContentPane();
        
        JLabel A = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI");
        A.setFont(new Font("Times New Roman", Font.BOLD, 30));
        
        JLabel lbNum1 = new JLabel("Số 1: ");
        tfNum1 = new JTextField(20);
        JLabel lbNum2 = new JLabel("Số 2: ");
        tfNum2 = new JTextField(20);
        JLabel lbNum3 = new JLabel("Số 3: ");
        tfNum3 = new JTextField(20);
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
        box1.add(Box.createHorizontalStrut(48)); 
        box1.add(tfNum1);
        
        Box box2 = Box.createHorizontalBox();
        lbNum1.setAlignmentX(Component.LEFT_ALIGNMENT);
        box2.add(lbNum2);
        box2.add(Box.createHorizontalStrut(48)); 
        box2.add(tfNum2);
        
        Box box3 = Box.createHorizontalBox();
        lbNum1.setAlignmentX(Component.LEFT_ALIGNMENT);
        box3.add(lbNum3);
        box3.add(Box.createHorizontalStrut(48)); 
        box3.add(tfNum3);
        
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

        panel3 = new JPanel();
        panel3.add(btnGiai);
        panel3.add(btnXoa);
        panel3.add(btnThoat);
        panel3.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
        
        cont.add(panel1, "North");
        cont.add(panel2, "Center");
        cont.add(panel3, "South");
        
        btnGiai.addActionListener(this);
        btnXoa.addActionListener(this);
        btnThoat.addActionListener(this);
        
//        this.setSize(700,300);
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
    
    public void xoa() {
    	tfNum1.setText("");
    	tfNum2.setText("");
    	tfNum3.setText("");
    	tfResult.setText("");
    }
    
    public void thoat() {
    	System.exit(0);
    }
    
    public void giai() {
    	String result = null;
    	
    	double num1 = Double.parseDouble(tfNum1.getText());
        double num2 = Double.parseDouble(tfNum2.getText());
        double num3 = Double.parseDouble(tfNum3.getText());
        
        if (num1 == 0) {
            if (num2 == 0) {
                result = "Vô nghiệm!";
            } else {
                result = "x = " + (-num3 / num2);
            }
        }
        
        double delta = num2*num2 - 4*num1*num3;
        double x1;
        double x2;
        
        if (delta > 0) {
            x1 = (float) ((-num2 + Math.sqrt(delta)) / (2*num1));
            x2 = (float) ((-num2 - Math.sqrt(delta)) / (2*num1));
            result = "x1 = " + x1 
                    + " và x2 = " + x2;
        } else if (delta == 0) {
            x1 = (-num2 / (2 * num1));
            Math.ceil((x1 * 1000) / 1000);
            result = "Nghiệm kép: " + "x1 = x2 = " + x1;
        } else {
            result = "Vô nghiệm!";
        }
        
        tfResult.setText(String.valueOf(result));
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Giải") {
        	giai();
        } else if (e.getActionCommand() == "Xoá rỗng") {
        	xoa();
        } else if (e.getActionCommand() == "Thoát") {
        	thoat();
        }
    }
    public static void main(String[] args) {
        Bai1b a = new Bai1b("^_^");
    }
}



