import java.util.Map;
import java.util.TreeMap;

public class Normal {
	TreeMap<Character, String> charBit = new TreeMap<Character, String>();
	TreeMap<String, Character> bitChar = new TreeMap<String, Character>();
	String chars = "";
	String bits = "";
	
	Normal(String text, String bits) {
		chars = new String(text);
		this.bits = new String(bits);
	}
	
	public void addChars() {
		for(int i = 0; i < chars.length(); i++) {
			char c = chars.charAt(i);
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
	
	public void print() {
		for(Map.Entry<Character,String> entry : charBit.entrySet()) {
			Character key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + " = " + value);
		}
		for(Map.Entry<String,Character> entry : bitChar.entrySet()) {
			String key = entry.getKey();
			Character value = entry.getValue();
			System.out.println(key + " = " + value);
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
		for(int i = 0; i < bits.length() / bitSize(); i++) {
			String s = bits.substring(i * bitSize(), i * bitSize() + bitSize());
			chars += bitChar.get(s);
		}
		System.out.println(chars);
	}
}
