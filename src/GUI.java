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
		
		Huffman hm = new Huffman("a", "");
		hm.getF();
//		hm.printF();
		hm.createTree();
//		hm.printCharBit();
		hm.toBits();
		hm.toChars();
		Normal nm = new Normal("a", "");
		nm.addChars();
//		System.out.println(nm.bitSize());
		nm.createMap();
//		nm.print();
		nm.toBits();
		nm.toChars();
//		System.out.println("1011001101100110110100010101100111000");
//		frm = new GUI();
//		frm.setTitle("Encryption");
//		frm.setSize(450, 200);
//		frm.setVisible(true);
	}

}
