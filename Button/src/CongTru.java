import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CongTru extends JFrame implements ActionListener {
    private JButton btnGiai, btnXoa, btnThoat;
    private JRadioButton radA, radB;
    
    private JTextField tfNum1, tfNum2, tfResult;
    private Container cont;
    private JPanel panel1, panel2, panel3;

    public CongTru(String title) {
        super(title);

        cont = this.getContentPane();
        JLabel lbNum1 = new JLabel("Số 1: ");
        tfNum1 = new JTextField(10);
        JLabel lbNum2 = new JLabel("Số 2: ");
        tfNum2 = new JTextField();
        JLabel lbResult = new JLabel("Kết quả: ");
        tfResult = new JTextField();
        tfResult.setEditable(false);


        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 2));
        panel1.add(lbNum1);
        panel1.add(tfNum1);
        panel1.add(lbNum2);
        panel1.add(tfNum2);
        panel1.add(lbResult);
        panel1.add(tfResult);

        radA = new JRadioButton("Cộng");
        radB = new JRadioButton("Trừ");
        
        btnGiai= new JButton("Giải");
        btnXoa = new JButton("Xoá");
        btnThoat = new JButton("Thoát");

        panel2 = new JPanel();
        panel2.add(radA);
        panel2.add(radB);
        ButtonGroup group = new ButtonGroup();
        group.add (radA);
        group.add (radB);

        panel3 = new JPanel();
        panel3.add(btnGiai);
        panel3.add(btnXoa);
        panel3.add(btnThoat);
        
        cont.add(panel1, "North");
        cont.add(panel2, "Center");
        cont.add(panel3, "South");

        radA.addActionListener(this);
        radB.addActionListener(this);
        
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
    
    public void xoa() {
    	tfNum1.setText("");
    	tfNum2.setText("");
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
			}
        } else if (e.getActionCommand() == "Xoá") {
        	xoa();
        } else if (e.getActionCommand() == "Thoát") {
        	thoat();
        }
    }
    public static void main(String[] args) {
        CongTru congtru = new CongTru("___");
    }
}


