package application.dao;

import application.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

//    private final EntityManager entityManager;
//
//    @Autowired
//    public UserDaoImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<User> getUserList() {
        return null;
    }

    @Override
    public void addUser(User user) {
//        entityManager.persist(user);
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }
}
