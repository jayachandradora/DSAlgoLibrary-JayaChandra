package javademo;

/*
1.Declare the class as final so it can’t be extended.
2.Make all fields private so that direct access is not allowed.
3.Don’t provide setter methods for variables
4.Make all mutable fields final so that it’s value can be assigned only once.
5.Initialize all the fields via a constructor performing deep copy.
6.Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.
*/
public final class ImmutableClass implements Cloneable {

	private final String id;
	private final String name;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ImmutableClass(String cId, String cName) {
		id = cId;
		name = cName;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// for cloning the object
		// return super.clone();

		// Clone not supported here
		throw new CloneNotSupportedException("Can't clone a this object");
	}

	public static void main(String[] args) {
		ImmutableClass ic = new ImmutableClass("11", "JC");
		System.out.println(ic.getId());

		// It will not initilize the new value
		ic = new ImmutableClass("14", "JCC");

		try {
			ImmutableClass ic1 = (ImmutableClass) ic.clone();
			System.out.println(ic1.getName());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
