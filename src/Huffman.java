import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Huffman {
	TreeMap<Character, Integer> charF = new TreeMap<Character, Integer>();
	TreeMap<Character, String> charBit = new TreeMap<Character, String>();
	String chars = "";
	String bits = "";
	HuffmanNode root;
	
	Huffman(String text, String bits) {
		chars = new String(text);
		this.bits = new String(bits);
	}
	
	public void getF() {
		for(int i = 0; i < chars.length(); i++) {
			char c = chars.charAt(i);
			if(charF.containsKey(c)) {
				int count = charF.get(c);
				charF.replace(c, count + 1);
			} else {
				charF.put(c, 1);
			}
		}
	}
	
	public void printF() {
		for(Map.Entry<Character,Integer> entry : charF.entrySet()) {
			Character key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + " = " + value);
		}
	}
	
	public void printCharBit() {
		for(Map.Entry<Character,String> entry : charBit.entrySet()) {
			Character key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + " = " + value);
		}
	}
	
	public void createTree() {
		PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(new MyComparator());
		for(Map.Entry<Character,Integer> entry : charF.entrySet()) {
			HuffmanNode hn = new HuffmanNode();
			hn.data = entry.getValue();
			hn.c = entry.getKey();
			q.add(hn);
		}
		
		while(q.size() > 1) {
			HuffmanNode l = q.poll();
			HuffmanNode r = q.poll();
			HuffmanNode m = new HuffmanNode();
			m.data = l.data + r.data;
			m.l = l;
			m.r = r;
			q.add(m);
			
		}
		root = q.poll();
		linkCharBit(root, "");
		if(chars.length() == 1) charBit.put(root.c, "0");
//		System.out.println(root.data);
//		System.out.println(root.l.c);
//		System.out.println(root.r.data);
//		System.out.println(q.size());
	}
	
	public void linkCharBit(HuffmanNode r, String s) {
		if(r.c == null) {
			linkCharBit(r.l, s + "0");
			linkCharBit(r.r, s + "1");
		} else {
			charBit.put(r.c, s);
		}
	}
	
	public void toBits() {
		bits = "";
		for(int i = 0; i < chars.length(); i++) {
			
			char c = chars.charAt(i);
			bits += charBit.get(c);
		}
		System.out.println(bits);
	}
	
	public void toChars() {
		chars = "";
		HuffmanNode temp = root;
		if(bits.length() == 1) {
			
			chars += root.c;
			System.out.println(chars);
			return;
		}
		for(int i = 0; i < bits.length(); i++) {
//			System.out.println(i);
			char c = bits.charAt(i);
			if(c == '0') {
				temp = temp.l;
			} else {
				temp = temp.r;
			}
			if(temp.c != null) {
				chars += temp.c;
				temp = root;
			}
			
		}
		System.out.println(chars);
	}
	
//	public static void main2() {
//		String text = "Hello World";
//		input = new String(text);
//		getF();
//		printF(); 
//	}
//	
//	public static void main(String[] args) {
//		main2();
//	
//
//	}

}
