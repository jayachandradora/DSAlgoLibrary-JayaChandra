package intv.tree;

public class Pair<T1, T2> {
	T1 root1 = null;
	T2 root2 = null;

	T1 key = null;
	T2 value = null;

	public Pair(T1 root1, T2 root2) {
		this.root1 = root1;
		this.root2 = root2;
		setKey(root1);
		setValue(root2);
	}

	public T1 getKey() {
		return key;
	}

	public void setKey(T1 key) {
		this.key = key;
	}

	public T2 getValue() {
		return value;
	}

	public void setValue(T2 value) {
		this.value = value;
	}

}
