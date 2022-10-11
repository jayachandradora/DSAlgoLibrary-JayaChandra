package serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//https://www.youtube.com/watch?v=4EQ8XJO7PBQ&list=PLzS3AYzXBoj8xTJaGXXZbObxIUCVfMc8D&index=5
public class SerializeAndDeSerializeObject {
	public static void main(String[] args) {

		String fileName = "employee1.ser";
		serializeObject(fileName);
		deserializeObject(fileName);

	}

	private static void deserializeObject(String fileName) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(fileName)))) {
			Object object = ois.readObject();
			Employee1 employee = (Employee1) object;
			System.out.println("Employee Object is deserialized..");
			System.out.println("ID:" + employee.getId());
			System.out.println("Name:" + employee.getName());
			System.out.println("Email:" + employee.getEmail());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void serializeObject(String fileName) {
		Employee1 employee = new Employee1();
		employee.setId(1001);
		employee.setName("KK");
		employee.setEmail("imjaya@gmail.com");
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(fileName)))) {
			oos.writeObject(employee);
			System.out.println("Employee Object is serialized..");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class Employee1 implements Serializable {

	private static final long serialVersionUID = -1579812851346930637L;
	private int id;
	private String name;
	private String email;
	private Double salary;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
}