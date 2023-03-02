package Dialog;
import javax.swing.JDialog;

public class demo extends JDialog {
	public demo() {
		setTitle("Demo JDialog"); 							//JDialog title
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 		//close
		setSize(300, 200);
		setResizable(false);


		}
		public static void main(String[] args) {
		new demo().setVisible(true);
		}
}
