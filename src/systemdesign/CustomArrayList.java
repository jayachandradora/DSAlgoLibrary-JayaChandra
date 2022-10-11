package systemdesign;

public class CustomArrayList {

	private static final int SIZE_FACTOR = 5;
	private Object data[];
	private int index;
	private int size;

	public CustomArrayList() {
		data = new Object[SIZE_FACTOR];
		size = SIZE_FACTOR;
	}

	public void add(Object obj) {
		System.out.println("index:" + index + "size:" + size + "data size:" + data.length);
		if (index == size - 1) {
			// we need to increase the size of data[]
			increaseSizeAndReallocate();
		}
		data[index] = obj;
		index++;

	}

	private void increaseSizeAndReallocate() {
		size = size + SIZE_FACTOR;
		Object newData[] = new Object[size];
		for (int i = 0; i < data.length; i++) {
			newData[i] = data[i];
		}
		data = newData;
		System.out.println("***index:" + index + "size:" + size + "data size:" + data.length);
	}

	public Object get(int i) throws Exception {
		if (i > index - 1) {
			throw new Exception("ArrayIndexOutOfBound");
		}
		if (i < 0) {
			throw new Exception("Negative Value");
		}
		return data[i];

	}

	public void remove(int i) throws Exception {
		if (i > index - 1) {
			throw new Exception("ArrayIndexOutOfBound");
		}
		if (i < 0) {
			throw new Exception("Negative Value");
		}
		System.out.println("Object getting removed:" + data[i]);
		for (int x = i; x < data.length - 1; x++) {
			data[x] = data[x + 1];
		}
		index--;
	}

	public static void main(String[] args) throws Exception {
		CustomArrayList list = new CustomArrayList();
		list.add("0");
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		list.add("7");
		list.add("8");
		list.add("9");

		list.remove(5);
		System.out.println(list.get(7));
	}

}