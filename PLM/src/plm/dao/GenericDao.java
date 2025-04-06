package plm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import plm.model.BaseEntity;

@Repository
@Transactional
public abstract class GenericDao<T extends BaseEntity> {

    @Autowired
    private SessionFactory sessionFactory;

    public T get(String reference, String version, int iteration) {
        // Implementation and returned value are not relevant for this exercise
        return null;
    }

    public void create(T entity) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(entity);
        currentSession.flush();
    }

    public void update(T entity) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(entity);
        currentSession.flush();
    }
}
