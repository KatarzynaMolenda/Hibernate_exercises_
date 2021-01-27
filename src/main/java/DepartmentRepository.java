import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DepartmentRepository {
    private SessionFactory sessionFactory;

    public DepartmentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Department get(int id) {
        Session session = sessionFactory.openSession();
        Department department = session.get(Department.class, id);
        session.close();
        return department;
    }

    public void save(Department department) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(department);
        transaction.commit();
        session.close();
    }

    public void update(Department department) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(department);
        transaction.commit();
        session.close();
    }

    public void delete(Department department) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(department);
        transaction.commit();
        session.close();
    }

    public void delete(int id) {
        delete(get(id));
    }

}
