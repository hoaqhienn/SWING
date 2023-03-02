package source_codes;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class test extends JFrame{
	private static final long serialVerionUID = 1L;
	
    private JButton addBtn;
    private JButton editBtn;
    private JButton deleteBtn;
    private JButton clearBtn;

    private JTable empTable;
     
    private JLabel idLabel;
    private JLabel FnameLabel;
    private JLabel LnameLabel;
    private JLabel ageLabel;
    private JLabel gpaLabel;
     
    private JTextField idField;
    private JTextField nameField;
    private JTextField ageField;
    private JTextArea addressTA;
    private JTextField gpaField;

	
    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addBtn = new JButton("Add");
        editBtn = new JButton("Edit");
        deleteBtn = new JButton("Delete");
        clearBtn = new JButton("Clear");


        empTable = new JTable();
        
        // khởi tạo các label
        idLabel = new JLabel("Ma nhan vien");
        FnameLabel = new JLabel("Ho");
        LnameLabel = new JLabel("Ten nhan vien");
        ageLabel = new JLabel("Tuoi");
        gpaLabel = new JLabel("Tien luong");
        
        idField = new JTextField(6);
        idField.setEditable(false);
        nameField = new JTextField(15);
        ageField = new JTextField(6);
        addressTA = new JTextArea();
        addressTA.setColumns(15);
        addressTA.setRows(5);
        gpaField = new JTextField(6);
        

        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();
        panel.setSize(800, 420);
        panel.setLayout(layout);
        
        panel.add(addBtn);
        panel.add(editBtn);
        panel.add(deleteBtn);
        panel.add(clearBtn);
        
        panel.add(idLabel);
        panel.add(FnameLabel);
        panel.add(ageLabel);
        panel.add(LnameLabel);
        panel.add(gpaLabel);
        
        panel.add(idField);
        panel.add(nameField);
        panel.add(ageField);
        panel.add(gpaField);
        
        layout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, FnameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, LnameLabel, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ageLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ageLabel, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, gpaLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, gpaLabel, 200, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, idField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idField, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameField, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ageField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ageField, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, gpaField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, gpaField, 200, SpringLayout.NORTH, panel);    
        
        layout.putConstraint(SpringLayout.WEST, addBtn, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editBtn, 60, SpringLayout.WEST, addBtn);
        layout.putConstraint(SpringLayout.NORTH, editBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteBtn, 60, SpringLayout.WEST, editBtn);
        
        layout.putConstraint(SpringLayout.NORTH, clearBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearBtn, 80, SpringLayout.WEST, deleteBtn);
        
        layout.putConstraint(SpringLayout.NORTH, deleteBtn, 240, SpringLayout.NORTH, panel);

        this.add(panel);
        this.pack();
        this.setTitle("Quan Ly Nhan Vien");
        this.setSize(800, 420);
        editBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
        addBtn.setEnabled(true);
    }
    
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		
		jf.setTitle("^_^");
		jf.setSize(600, 400);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		

	}
}
