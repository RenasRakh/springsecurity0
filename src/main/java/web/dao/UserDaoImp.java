package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

//    private UserRepository userRepository;
//
//    @Autowired
//    public void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }



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

    @Override
    public User getUserByUserName(String username) {
        System.out.println("____");
        User user = entityManager.createQuery(
                "SELECT u from User u WHERE u.username = :username", User.class).
                setParameter("username", username).getSingleResult();
        System.out.println(user.toString());
        return  user;
    }

    @Override
    public void start(){

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
