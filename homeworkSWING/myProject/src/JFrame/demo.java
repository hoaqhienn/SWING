package JFrame;
import javax.swing.JFrame;

public class demo extends JFrame {
	public demo() {
		setTitle("Demo JFrame"); 							//title.
		setSize(300, 200); 									//size.
		setDefaultCloseOperation(EXIT_ON_CLOSE);			//click to exit.
		setLocationRelativeTo(null); 						//center position.
		setResizable(false); 								//resize : false.
															
		}
		public static void main(String[] args) {
		new demo().setVisible(true); 						//show JFrame.
		}

}
