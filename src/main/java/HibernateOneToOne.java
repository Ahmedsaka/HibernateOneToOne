import Model.User;
import Model.UserProfile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.Month;

public class HibernateOneToOne {

    private static final String PERSISTENCE_UNIT_NAME = "my-pu";

    public static void main(String [] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = emf.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            User user1 = new User("Ahmed Saka", "ahmedsaka91@gmal.com");
            UserProfile userProfile1 = new UserProfile("+2348135199661", "Aborishade Street, Lawanson Surulere", LocalDate.of(1991, Month.AUGUST, 9));
            user1.setUserProfile(userProfile1);
            userProfile1.setUser(user1);
            entityManager.persist(user1);

            User user2 = new User("Lucia", "lucia12@yahoo.com");
            UserProfile userProfile2 = new UserProfile("0854919671", "Bazova 12, Brezno", LocalDate.of(1993, Month.JULY, 12));
            user2.setUserProfile(userProfile2);
            userProfile2.setUser(user2);
            entityManager.persist(user2);

            entityManager.close();
            emf.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
