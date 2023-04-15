package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NNguyenTo extends JFrame implements ActionListener {
	private JTextField txt;
	private JButton btn;
	private JTextArea ta;
	private JPanel p;
	
	public NNguyenTo() {
		super("^_^");
		
		p = new JPanel();
		p.setLayout(null);
		this.add(p);
		
		p.add(txt = new JTextField());
        txt.setBounds(50, 30, 200, 30);
        txt.setToolTipText("Nhập vào N");
        
        p.add(btn = new JButton("Click!"));
		btn.setBounds(250, 30 , 100, 30);
		
		JScrollPane scroll;
		p.add(scroll = new JScrollPane(ta = new JTextArea()));
		scroll.setBounds(50, 70, 300, 170);
		ta.setToolTipText("Danh sách số nguyên tố");
		ta.setEditable(false);
		
		this.setSize(400, 300);
//      this.pack();
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		btn.addActionListener(this);
	}
	
		
	public static void main(String[] args) {
		new NNguyenTo();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		ta.setText("");
		try {
			int n = Integer.parseInt(txt.getText());
			if(n > 0) {
				for(int i = 2; i < Integer.MAX_VALUE; i++) {
					if (isPrime(i)) {
						n--;
						ta.append(i + "\n");
					}
					if(n == 0)
						break;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Nhap so nguyen");
			}
			
		} catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Loi nhap lieu");
		}
		focus();
	}
	
	private void focus() {
		txt.selectAll();
		txt.requestFocus();
		return;
	}
	
	private boolean isPrime(int n) {
		for(int i = 2; i < n; i++)
			if (n % i == 0)
				return false;
		return true;
	}
}
