package programs;

import javax.naming.ldap.ManageReferralControl;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertingObject {
public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("karthik");
		EntityManager manger = factory.createEntityManager();
		EntityTransaction transaction = manger.getTransaction();
		
		Student student = new Student();
		student.setSid(1);
		student.setName("karthik");
		student.setAddress("krishnagiri");
		student.setAge(20);
		
		transaction.begin();
		manger.persist(student);
		transaction.commit();
	}
}
