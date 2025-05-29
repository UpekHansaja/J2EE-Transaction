package lk.jiat.ee.jta.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lk.jiat.ee.jta.ejb.local.UserBean;
import lk.jiat.ee.jta.entity.User;
import org.hibernate.Session;

@Stateless
public class UserBeanImpl implements UserBean {

    @PersistenceContext(unitName = "JTAPU")
    private EntityManager em;

    @Override
    public boolean login(String email, String password) {
        return false;
    }

    @Override
    public boolean register(String name, String email, String password, String contact) {

        try {

            Session session = em.unwrap(Session.class);

            // Create a new User entity
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setContact(contact);

            // Persist the User entity
//            em.persist(user);
            session.save(user);

            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }

    }
}
