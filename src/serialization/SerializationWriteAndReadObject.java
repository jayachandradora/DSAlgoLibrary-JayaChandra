package serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//https://www.youtube.com/watch?v=BzURQWVDG_8&list=PLzS3AYzXBoj8xTJaGXXZbObxIUCVfMc8D&index=3
public class SerializationWriteAndReadObject {
	public static void main(String[] args) {

		String fileName = "employee.ser";
		serializeObject(fileName);
		deserializeObject(fileName);

	}

	private static void deserializeObject(String fileName) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(fileName)))) {
			System.out.println("Object is deserialized..");
			Object object = ois.readObject();
			Employee employee = (Employee) object;
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
		Employee employee = new Employee();
		employee.setId(1001);
		employee.setName("KK");
		employee.setAge(30);

		employee.setEmail("imjaya@gmail.com");
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

class Employee extends Person implements Serializable {

	private static final long serialVersionUID = -4724957588046435474L;

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

	private void writeObject(ObjectOutputStream oos) throws IOException {
		// calling default functionality for Employee fields
		oos.defaultWriteObject();

		// Explicitly writing Person fields
		oos.writeInt(getId());
		oos.writeObject(getName());
		oos.writeInt(getAge());
	}

	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		// calling default functionality for Employee fields
		ois.defaultReadObject();

		// Explicitly reading Person fields and setting them
		setId(ois.readInt());
		setName((String) ois.readObject());
		setAge(ois.readInt());
	}

	@Override
	public String toString() {
		return "Employee [email=" + email + ", password=" + password + "]";
	}
}

class Person {

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
