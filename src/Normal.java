import java.util.Map;
import java.util.TreeMap;

public class Normal {
	TreeMap<Character, String> charBit = new TreeMap<Character, String>();
	TreeMap<String, Character> bitChar = new TreeMap<String, Character>();
	String text = "";
	
	Normal(String text) {
		this.text = new String(text);
	}
	
	public void createMapping() {
		addChars();
		createMap();
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
	
	public void addChars() {
		for(int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if(!charBit.containsKey(c)) {
				charBit.put(c, "");
			}
		}
	}
	
	public int bitSize() {
		if((int) Math.ceil(Math.log(charBit.size()) / Math.log(2)) == 0) return 1;
		return (int) Math.ceil(Math.log(charBit.size()) / Math.log(2));
	}
	
	public void createMap() {
		String s = "0";
		for(Map.Entry<Character,String> entry : charBit.entrySet()) {
			s = fix(s);
			Character key = entry.getKey();
			charBit.replace(key, s);
			bitChar.put(s, key);
			s = Integer.toBinaryString(Integer.valueOf(s, 2) + 1);
		}
	}
	
	public String incrementBit(String s) {
		return Integer.toBinaryString(Integer.valueOf(s, 2) + 1);
	}
	
	public String fix(String s) {
		String temp = "";
		for(int i = 0; i < bitSize() - s.length(); i++) {
			temp += "0";
		}
		return temp + s;
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
		if(s.length() % bitSize() != 0) return null;
		for(int i = 0; i < s.length() / bitSize(); i++) {
			String s2 = s.substring(i * bitSize(), i * bitSize() + bitSize());
			Character s3 = bitChar.get(s2);
			if(s3 == null) return null;
			chars += s3;
		}
		return chars;
	}
}
