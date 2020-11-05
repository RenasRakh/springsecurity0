package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.Set;

@Repository
public class RoleDaoImp implements RoleDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Set<Role> getRoleSet(Set<String> role) {
        return new HashSet<>(entityManager.createQuery("SELECT r FROM Role r WHERE r.name in (:roleStringSet)")
                .setParameter("roleStringSet", role)
                .getResultList());
    }

    @Override
    public Role getRoleById(int id){
        return entityManager.find(Role.class, (long)id);
    }

    @Override
    public Role getRoleByName(String name) {
        Role role = entityManager.createQuery(
                "SELECT u from Role u WHERE u.name = :name", Role.class).
                setParameter("name", name).getSingleResult();
        return  role;
    }
}
