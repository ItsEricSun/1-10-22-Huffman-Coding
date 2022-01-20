import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Huffman {
	TreeMap<Character, Integer> charF = new TreeMap<Character, Integer>();
	TreeMap<Character, String> charBit = new TreeMap<Character, String>();
	String text = "";
	HuffmanNode root;
	
	Huffman(String text) {
		this.text = new String(text);
	}
	
	public void createMapping() {
		getF();
		createTree();
	}
	
	public String printMapping() {
		String s = "";
		for(Map.Entry<Character,String> entry : charBit.entrySet()) {
			Character key = entry.getKey();
			String value = entry.getValue();
			s += key + " = " + value + "\n";
		}
		return s;
	}
	
	public void getF() {
		for(int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if(charF.containsKey(c)) {
				int count = charF.get(c);
				charF.replace(c, count + 1);
			} else {
				charF.put(c, 1);
			}
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
		if(root.r == null) charBit.put(root.c, "0");
	}
	
	public void linkCharBit(HuffmanNode r, String s) {
		if(r.c == null) {
			linkCharBit(r.l, s + "0");
			linkCharBit(r.r, s + "1");
		} else {
			charBit.put(r.c, s);
		}
	}
	
	public String toBits(String s) {
		String bits = "";
		for(int i = 0; i < s.length(); i++) {
			String s2 = charBit.get(s.charAt(i));
			if(s2 == null) return null;
			bits += s2;
		}
		return bits;
	}
	
	public String toChars(String s) {
		String chars = "";
		HuffmanNode temp = root;
		if(root.l == null) {
			for(int i = 0; i < s.length(); i++) {
				if(!(charBit.get(charBit.keySet().iterator().next())).equals("" + s.charAt(i))) return null;
				chars += root.c;
			}
			return chars;
		}
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '0') {
				temp = temp.l;
			} else if(c == '1'){
				temp = temp.r;
			}
			if(i == s.length() - 1 && temp.c == null) return null;
			if(temp.c != null) {
				chars += temp.c;
				temp = root;
			}
		}
		return chars;
	}
}
