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
		JLabel textLabel = addLabel("Text (Don't Use Characters that Don't Appear in Input Text)                                                                     <====>", 6,1,2,1);
		textArea = addTextArea("", 7, 1, 2, 4);
		textArea.setLineWrap(true);
		JLabel bitLabel = addLabel("Bits", 6,3,2,1);
		bitArea = addTextArea("", 7, 3, 2, 4);
		bitArea.setLineWrap(true);
		JLabel hmLabel = addLabel("Huffman Character to Bit Mapping (No Need to Input Anything)", 11,1,2,1);
		huffmanArea = addTextArea("", 12, 1, 2, 10);
		textArea.setLineWrap(true);
		JLabel nmLabel = addLabel("Normal Character to Bit Mapping (No Need to Input Anything)", 11,3,2,1);
		normalArea = addTextArea("", 12, 3, 2, 10);
		bitArea.setLineWrap(true);
		hmCharBitButton = addButton("Convert Text to Bits with Huffman Mapping", 23,1,1,1);
		hmBitCharButton = addButton("Convert Bits to Text with Huffman Mapping", 23,2,1,1);
		nmCharBitButton = addButton("Convert Text to Bits with Normal Mapping", 23,3,1,1);
		nmBitCharButton = addButton("Convert Bits to Text with Normal Mapping", 23,4,1,1);
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(inputTextArea.getText().length() == 0) {
			messageBox("Error: Please Enter Input Text");
			return;
		}
		Huffman hm = new Huffman(inputTextArea.getText());
		Normal nm = new Normal(inputTextArea.getText());
		hm.createMapping();
		huffmanArea.setText(hm.printMapping());
		nm.createMapping();
		normalArea.setText(nm.printMapping());
		if(buttonObj == hmCharBitButton) {
			if(textArea.getText().length() == 0) {
				messageBox("Error: Please Enter Text");
				return;
			}
			String output = hm.toBits(textArea.getText());
			if(output == null) {
				messageBox("Error: Please Make Sure Text Contains Characters that also Appear in the Input Text");
				return;
			}
			bitArea.setText(output);
		} else if(buttonObj == hmBitCharButton) {
			if(bitArea.getText().length() == 0) {
				messageBox("Error: Please Enter Bits");
				return;
			}
			String output = hm.toChars(bitArea.getText());
			if(output == null) {
				messageBox("Error: Bits Don't Match with Mapping");
				return;
			}
			textArea.setText(output);
		} else if(buttonObj == nmCharBitButton) {
			if(textArea.getText().length() == 0) {
				messageBox("Error: Please Enter Text");
				return;
			} 
			String output = nm.toBits(textArea.getText());
			if(output == null) {
				messageBox("Error: Please Make Sure Text Contains Characters that also Appear in the Input Text");
				return;
			}
			bitArea.setText(output);
		} else if(buttonObj == nmBitCharButton) {
			if(bitArea.getText().length() == 0) {
				messageBox("Error: Please Enter Bits");
				return;
			}
			String output = nm.toChars(bitArea.getText());
			if(output == null) {
				messageBox("Error: Bits Don't Match with Mapping");
				return;
			}
			textArea.setText(output);
		}
	}
	
	public GUI() {
		initMainMenu();
	}
	
	public static void main(String[] args) {
		frm = new GUI();
		frm.setTitle("Huffman Tree vs. Normal Tree");
		frm.setSize(1200, 800);
		frm.setVisible(true);
	}
}
