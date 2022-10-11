package serialization;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SerializationExternalizable {

	public static void main(String[] args) {

		String fileName = "employee2.ser";
		serializeObject(fileName);
		deserializeObject(fileName);

	}

	private static void deserializeObject(String fileName) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(fileName)))) {
			System.out.println("Object is deserialized..");
			Object object = ois.readObject();
			Employee2 employee = (Employee2) object;
			System.out.println("ID:" + employee.getId());
			System.out.println("Name:" + employee.getName());
			System.out.println("Age:" + employee.getAge());
			System.out.println("Email:" + employee.getEmail());
			System.out.println("Password:" + employee.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void serializeObject(String fileName) {
		Employee2 employee = new Employee2();
		employee.setId(1001);
		employee.setName("KK");
		employee.setAge(30);

		employee.setEmail("kishan.javatrainer@gmail.com");
		employee.setPassword("pass@123");

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(fileName)))) {
			oos.writeObject(employee);
			System.out.println("Object is serialized..");
			System.out.println("-------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Employee2 extends Person2 implements Externalizable {

	public Employee2() {
		System.out.println("Employee default constructor is called..");
	}

	private String email;
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// Writing parent class ClassA fields
		out.writeInt(getId());
		out.writeObject(getName());
		out.writeInt(getAge());

		// Writing child class fields
		out.writeObject(getEmail());
		out.writeObject(getPassword());
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// Setting parent class fields
		setId(in.readInt());
		setName((String) in.readObject());
		setAge(in.readInt());

		// Setting child class fields
		setEmail((String) in.readObject());
		setPassword((String) in.readObject());
	}
}

class Person2 {

	private int id;
	private String name;
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}