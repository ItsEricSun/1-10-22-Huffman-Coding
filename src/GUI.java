import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import BreezySwing.GBFrame;

public class GUI extends GBFrame {

	static JFrame frm;
	JTextField keyField;
	JTextField messageField;
	JButton EncryptButton;
	JButton DecryptButton;
	
	public void MainMenu() {
	}
	
	public void buttonClicked(JButton buttonObj) {
		
	}
	
	public GUI() {
		MainMenu();
	}
	
	public static void main(String[] args) {
		
		Huffman hm = new Huffman("Hello World");
		hm.getF();
		hm.printF();
//		frm = new GUI();
//		frm.setTitle("Encryption");
//		frm.setSize(450, 200);
//		frm.setVisible(true);
	}

}
