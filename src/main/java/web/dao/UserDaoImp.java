package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public User getById(int id) {
        return entityManager.find(User.class, (long)id);
    }

    @Override
    public List<User> allUsers() {
        return entityManager.createQuery("SELECT users FROM User users").getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(User user) {
        entityManager.remove(entityManager.merge(user));
    }

    @Override
    public void edit(int id, User user) {
        User user2=getById(id);
        user2.setFirstName(user.getFirstName());
        user2.setLastName(user.getLastName());
        user2.setEmail(user.getEmail());
        entityManager.merge(user2);

    }

}

//@Repository
//public class UserDaoImp implements UserDao {
//    @Autowired
//    private SessionFactory sessionFactory;
//
//
//
//    @Override
//    public User getById(int id) {
//        return sessionFactory.getCurrentSession().get(User.class, (long)id);
//    }
//
//    @Override
//    public List<User> allUsers() {
//        return sessionFactory.getCurrentSession().createQuery("from User").list();
//    }
//
//    @Override
//    public void add(User user) {
//        sessionFactory.getCurrentSession().persist(user);
//    }
//
//    @Override
//    public void delete(User user) {
//        sessionFactory.getCurrentSession().delete(user);
//    }
//
//    @Override
//    public void edit(int id, User user) {
//        User user2=getById(id);
//        user2.setFirstName(user.getFirstName());
//        user2.setLastName(user.getLastName());
//        user2.setEmail(user.getEmail());
//        sessionFactory.getCurrentSession().update(user2);
//
//    }
//
//}
