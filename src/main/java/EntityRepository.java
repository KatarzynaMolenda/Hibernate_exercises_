import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EntityRepository<T> {
    private SessionFactory sessionFactory;

    public EntityRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Object get(int id) {
        Session session = sessionFactory.openSession();
        Object t = session.get(Object.class, id);
        session.close();
        return t;
    }

    public void save(T t) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(t);
        transaction.commit();
        session.close();
    }

    public void update(T t) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(t);
        transaction.commit();
        session.close();
    }

    public void delete(T t) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(t);
        transaction.commit();
        session.close();
    }

    public void delete(int id) {
        delete((T) get(id));
    }
}
