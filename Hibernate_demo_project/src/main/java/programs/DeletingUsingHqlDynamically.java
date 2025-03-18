package programs;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeletingUsingHqlDynamically {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("karthik");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		// creating dynamic HQL query
		javax.persistence.Query q = manager.createQuery("Delect s from Student s where s.age =>?1 ");
		
		
		//take input from user
		Scanner scanner = new Scanner(System.in);
		System.out.println("ENter the age: ");
		int age = scanner.nextInt();
		
		
		//set the user entered values in place of the holders
		q.setParameter(1, age);
	
		
		//execute query
		transaction.begin();
		q.executeUpdate();
		transaction.commit();
	}
}
