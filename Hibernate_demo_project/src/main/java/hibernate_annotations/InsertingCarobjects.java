package hibernate_annotations;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertingCarobjects {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("karthik");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		car car = new car();
		
		car.setBrand("BENZ");
		car.setColor("Black");
		car.setPrice(2000000);
		
		transaction.begin();
		manager.persist(car);
		transaction.commit();
	}
}
