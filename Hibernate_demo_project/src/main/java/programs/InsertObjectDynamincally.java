package programs;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertObjectDynamincally {
	
public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("karthik");
		EntityManager manger = factory.createEntityManager();
		EntityTransaction transaction = manger.getTransaction();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter student id: ");
		int id = scanner.nextInt();
		System.out.println("Enter name: ");
		String name = scanner.next();
		System.out.println("Enter age:");
		int age = scanner.nextInt();
		System.out.println("Enter address: ");
		String address = scanner.next();
		
		
		Student student = new Student();
		student.setSid(id);
		student.setName(name);
		student.setAddress(address);
		student.setAge(age);
		
		transaction.begin();
		manger.persist(student);
		transaction.commit();
	}
}
