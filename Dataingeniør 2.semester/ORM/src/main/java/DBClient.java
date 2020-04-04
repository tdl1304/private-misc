import javax.persistence.*;
import java.util.List;

public class DBClient {
    public static void main(String[] args) {
        String persistUnitName = "Accounts";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistUnitName);
        EntityManager em = emf.createEntityManager();


        em.getTransaction().begin();
        try {
            //em.persist(new Account(1,100,500,"John"));
            em.getTransaction().commit();
            TypedQuery<Account> q = em.createQuery("SELECT e FROM Account AS e", Account.class);
            List<Account> list = q.getResultList();
            System.out.println(list.get(0).getAccountNum());
        }catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
