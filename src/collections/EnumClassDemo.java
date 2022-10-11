package collections;

import java.util.EnumMap;
import java.util.Iterator;

public class EnumClassDemo {

	enum Color {
		red, blak, blue,green
	}

	public static void main(String[] args) {

		EnumMap<Color, String> colorMap = new EnumMap<Color, String>(Color.class);
		colorMap.put(Color.blak, "Black");
		colorMap.put(Color.red, "Red");
		colorMap.put(Color.blue, "Blue");

		System.out.println(Color.green.hashCode());
		System.out.println(Color.green.hashCode());
		System.out.println(colorMap);

		Iterator<Color> itr = colorMap.keySet().iterator();
		while (itr.hasNext()) {

			Color str = itr.next();
			System.out.println(colorMap.get(str));
			itr.remove();
		}
	}

}
