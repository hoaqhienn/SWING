package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GiaiPhuongTrinhBacHai extends JFrame implements ActionListener {
    
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnGiai, btnXoa, btnThoat;
    private JTextField tfNum1, tfNum2, tfNum3, tfResult;
    private Container cont;
    private JPanel panel1, panel2, panel21, panel22, panel23, panel24, panel3;

    
    public GiaiPhuongTrinhBacHai() {
    	super("---");
        cont = this.getContentPane();
        
        JLabel A = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI");
        A.setFont(new Font("Times New Roman", Font.BOLD, 30));
        panel1 = new JPanel();
        panel1.add(A);
        panel1.setBackground(Color.cyan);
        
        
        
        panel2 = new JPanel();
//        panel2.setLayout(new GridLayout(4, 2));
        panel2.setLayout(null);
        
        JLabel lbNum1, lbNum2, lbNum3, lbResult;
        panel2.add(lbNum1 = new JLabel("Nhập a: "));
        int x = 100, y = 20, width = 100, height = 30;
        lbNum1.setBounds(x, y, width, height);
        
        panel2.add(lbNum2 = new JLabel("Nhập b: "));
        y += 50;
        lbNum2.setBounds(x, y, width, height);
        
        panel2.add(lbNum3 = new JLabel("Nhập c: "));
        y += 50;
        lbNum3.setBounds(x, y, width, height);
        
        panel2.add(lbResult = new JLabel("Kết quả: "));
        y += 50;
        lbResult.setBounds(x, y, width, height);
        
        panel2.add(tfNum1 = new JTextField());
        x = 200; y = 20; width = 300; height = 30;
        tfNum1.setBounds(x, y, width, height);
        
        panel2.add(tfNum2 = new JTextField());
        y += 50;
        tfNum2.setBounds(x, y, width, height);
        
        panel2.add(tfNum3 = new JTextField());
        y += 50;
        tfNum3.setBounds(x, y, width, height);
        
        panel2.add(tfResult = new JTextField());
        y += 50;
        tfResult.setBounds(x, y, width, height);
        tfResult.setEditable(false);
        
        btnGiai= new JButton("Giải");
        btnXoa = new JButton("Xoá rỗng");
        btnThoat = new JButton("Thoát");

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
        
        this.setSize(630,380);
//        this.pack();
        this.setVisible(true);
        this.setResizable(false);
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
        new GiaiPhuongTrinhBacHai();
    }
}



