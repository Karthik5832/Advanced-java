package programs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteingObject {
	
public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("karthik");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Student student = manager.find(Student.class,1);
		
		if(student != null) {
			student.setAge(22);
			student.setAddress("banglore");
			transaction.begin();
			manager.remove(student);
			transaction.commit();
		} else {
			System.out.println("Student id does not exist");
		}
		
	}
}
