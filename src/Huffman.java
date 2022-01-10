import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Huffman {
	TreeMap<Character, Integer> charF = new TreeMap<Character, Integer>();
	String input = "";
	
	Huffman(String text) {
		input = new String(text);
	}
	
	public void getF() {
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
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
			
		}
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
