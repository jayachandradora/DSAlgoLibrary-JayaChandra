package javademo;

import java.util.HashMap;
import java.util.Map;

public class HashMapInternalImpl {

	public static void main(String[] args) {

		int index = 118 & (16 - 1);
		System.out.println(index);
		Map<Key, Integer> map = new HashMap<Key, Integer>();
		map.put(new Key("Jc"), 100);
	}
}

class Key{
	String key = null;
	
	public Key(String key){
		this.key = key;
	}
	
	public int hasCode(){
		return (int)key.charAt(0);
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}