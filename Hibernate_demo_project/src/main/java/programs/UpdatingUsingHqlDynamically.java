package programs;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mysql.cj.Query;

public class UpdatingUsingHqlDynamically {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("karthik");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		// creating dynamic HQL query
		javax.persistence.Query q = manager.createQuery("update Student s set s.age=?1 where s.name=?2");
		
		
		//take input from user
		Scanner scanner = new Scanner(System.in);
		System.out.println("ENter new age of the student: ");
		int age = scanner.nextInt();
		System.out.println("Enter name of thr student to upadate age: ");
		String name = scanner.next();
		
		//set the user entered values in place of the holders
		q.setParameter(1, age);
		q.setParameter(2, name);
		
		//execute query
		transaction.begin();
		q.executeUpdate();
		transaction.commit();
	}
}
