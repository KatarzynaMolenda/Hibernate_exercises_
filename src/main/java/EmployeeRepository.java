import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Entity;

@Entity
public class EmployeeRepository {
    private SessionFactory sessionFactory;

    public EmployeeRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Employee get(int id) {
        Session session = sessionFactory.openSession();
        Employee employee = session.get(Employee.class, id);
        session.close();
        return employee;
    }

    public void save(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
    }

    public void update(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(employee);
        transaction.commit();
        session.close();
    }

    public void delete(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(employee);
        transaction.commit();
        session.close();
    }

    public void delete(int id) {
        delete(get(id));
    }
}
