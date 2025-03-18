package programs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SearchingObject {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("karthik");
		EntityManager manger = factory.createEntityManager();
		EntityTransaction transaction = manger.getTransaction();
		
		Student student = manger.find(Student.class, 2);
		
		if(student != null) {
			
			System.out.println("Student ID :"+ student.getSid());
			System.out.println("NAME :"+ student.getName());
			System.out.println("AGE :"+ student.getAge());
			System.out.println("ADDRESS :"+ student.getAddress());
		} else {
			System.out.println("STUDENT ID DOESNOT EXIST..");
		}

	}
}
