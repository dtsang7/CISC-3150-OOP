
import java.io.*;

class Employee extends Person{
	private final int ID = 123456;
	static String companyName;
	transient String companyCEO;
}

class Person implements Serializable{
	public String lastName;
	static String firstName;
	transient String address;
}

public class Serialization{
	
	public static void main(String[] args){

		Employee emp = new Employee();
		emp.firstName = "Charlie";
		emp.lastName = "Brown";
		emp.address = "Hennepin County";
		emp.companyName = "Peanut";
		emp.companyCEO = "Snoopy";

		//Serializing starts here.
		try{
			FileOutputStream fileOut = new FileOutputStream("employee.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(emp);
			out.close();
			fileOut.close();
			System.out.println("Data has been serialized");
		}catch(IOException e){
			e.printStackTrace();
		}
		//Serializing ends here.

		//this line changes the value of the static variable firstName;
		emp.firstName = "Kevin";
		//this line changes the value of the public variable lastName;
		emp.lastName = "Bacon";

		//Deserializing starts here.
		Employee newEmp = null;
		try{
			FileInputStream fileIn = new FileInputStream("employee.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			newEmp = (Employee)in.readObject();
			in.close();
			fileIn.close();
			System.out.println("Data has been deserialized");
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException ex){
			ex.printStackTrace();
		}
		//Deserializing ends here.

		System.out.println("(public)lastName:\t" + newEmp.lastName);
		System.out.println("(static)firstName:\t"+newEmp.firstName);
		System.out.println("(transient)address:\t" + newEmp.address);
		System.out.println("(static)companyName:\t" + newEmp.companyName);
		System.out.println("(transient)companyCEO:\t" + newEmp.companyCEO);
	}
}