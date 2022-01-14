import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BreezySwing.GBFrame;

public class GUI extends GBFrame {

	static JFrame frm;
	JTextArea inputTextArea;
	JTextArea textArea;
	JTextArea bitArea;
	JTextArea huffmanArea;
	JTextArea normalArea;
	JButton hmCharBitButton;
	JButton hmBitCharButton;
	JButton nmCharBitButton;
	JButton nmBitCharButton;
	
	public void initMainMenu() {
		JLabel inputTextLabel = addLabel("Input Text to be used for Mapping", 1,1,4,1);
		inputTextArea = addTextArea("", 2, 1, 4, 3);
		inputTextArea.setLineWrap(true);
		JLabel textLabel = addLabel("Text", 6,1,2,1);
		textArea = addTextArea("", 7, 1, 2, 4);
		textArea.setLineWrap(true);
		JLabel bitLabel = addLabel("Bits", 6,3,2,1);
		bitArea = addTextArea("", 7, 3, 2, 4);
		bitArea.setLineWrap(true);
		JLabel hmLabel = addLabel("Huffman Character to Bit Mapping", 11,1,2,1);
		huffmanArea = addTextArea("", 12, 1, 2, 10);
		textArea.setLineWrap(true);
		JLabel nmLabel = addLabel("Normal Character to Bit Mapping", 11,3,2,1);
		normalArea = addTextArea("", 12, 3, 2, 10);
		bitArea.setLineWrap(true);
		hmCharBitButton = addButton("Convert Text to Bits with Huffman Mapping", 23,1,1,1);
		hmBitCharButton = addButton("Convert Bits to Text with Huffman Mapping", 23,2,1,1);
		nmCharBitButton = addButton("Convert Text to Bits with Normal Mapping", 23,3,1,1);
		nmBitCharButton = addButton("Convert Bits to Text with Normal Mapping", 23,4,1,1);
	}
	
	public void MainMenu() {
		frm.getContentPane().removeAll();
		frm.setSize(1200, 800);
		frm.repaint();
		JLabel inputTextLabel = addLabel("Input Text to be used for Mapping", 1,1,4,1);
		inputTextArea = addTextArea("", 2, 1, 4, 3);
		inputTextArea.setLineWrap(true);
		JLabel textLabel = addLabel("Text", 6,1,2,1);
		textArea = addTextArea("", 7, 1, 2, 4);
		textArea.setLineWrap(true);
		JLabel bitLabel = addLabel("Bits", 6,3,2,1);
		bitArea = addTextArea("", 7, 3, 2, 4);
		bitArea.setLineWrap(true);
		JLabel hmLabel = addLabel("Huffman Character to Bit Mapping", 11,1,2,1);
		huffmanArea = addTextArea("", 12, 1, 2, 4);
		textArea.setLineWrap(true);
		JLabel nmLabel = addLabel("Normal Character to Bit Mapping", 11,3,2,1);
		normalArea = addTextArea("", 12, 3, 2, 4);
		bitArea.setLineWrap(true);
		hmCharBitButton = addButton("Convert Text to Bits with Huffman Mapping", 17,1,1,1);
		hmBitCharButton = addButton("Convert Bits to Text with Huffman Mapping", 17,2,1,1);
		nmCharBitButton = addButton("Convert Text to Bits with Normal Mapping", 17,3,1,1);
		nmBitCharButton = addButton("Convert Bits to Text with Normal Mapping", 17,4,1,1);
		frm.validate();
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(inputTextArea.getText().length() == 0) {
			messageBox("Error: Please Enter Input Text");
			MainMenu();
			return;
		}
		Huffman hm = new Huffman(inputTextArea.getText());
		Normal nm = new Normal(inputTextArea.getText());
		hm.createMapping();
		huffmanArea.setText(hm.printMapping());
		nm.createMapping();
		normalArea.setText(nm.printMapping());
	}
	
	public GUI() {
		initMainMenu();
	}
	
	public static void main(String[] args) {
		
//		Huffman hm = new Huffman("bbbbbaaabbbacc", "");
//		hm.getF();
////		hm.printF();
//		hm.createTree();
////		hm.printCharBit();
//		hm.toBits();
//		hm.toChars();
//		Normal nm = new Normal("bbbbbaaabbbacc", "");
//		nm.addChars();
////		System.out.println(nm.bitSize());
//		nm.createMap();
////		nm.print();
//		nm.toBits();
//		nm.toChars();
//		System.out.println("1011001101100110110100010101100111000");
		frm = new GUI();
		frm.setTitle("Huffman Tree vs. Normal Tree");
		frm.setSize(1200, 800);
		frm.setVisible(true);
	}

}
