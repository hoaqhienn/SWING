package test;

import javax.swing.*;

public class GiaiPTBac2 extends JFrame {
    private JTextField aTextField;
    private JTextField bTextField;
    private JTextField cTextField;
    private JLabel resultLabel;

    public GiaiPTBac2() {
        setTitle("Giải phương trình bậc hai");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel aLabel = new JLabel("Nhập a:");
        aTextField = new JTextField();
        panel.add(aLabel);
        panel.add(aTextField);

        JLabel bLabel = new JLabel("Nhập b:");
        bTextField = new JTextField();
        panel.add(bLabel);
        panel.add(bTextField);

        JLabel cLabel = new JLabel("Nhập c:");
        cTextField = new JTextField();
        panel.add(cLabel);
        panel.add(cTextField);

        JButton solveButton = new JButton("Giải");
        solveButton.addActionListener(e -> {
            double a = Double.parseDouble(aTextField.getText());
            double b = Double.parseDouble(bTextField.getText());
            double c = Double.parseDouble(cTextField.getText());

            double delta = b * b - 4 * a * c;

            if (delta < 0) {
                resultLabel.setText("Phương trình vô nghiệm");
            } else if (delta == 0) {
                double x1 = -b / (2 * a);
                resultLabel.setText(String.format("Phương trình có nghiệm kép x = %f", x1));
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                resultLabel.setText(String.format("Phương trình có hai nghiệm phân biệt x1 = %f, x2 = %f", x1, x2));
            }
        });
        panel.add(solveButton);

        resultLabel = new JLabel();
        panel.add(resultLabel);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        GiaiPTBac2 frame = new GiaiPTBac2();
    }
}
