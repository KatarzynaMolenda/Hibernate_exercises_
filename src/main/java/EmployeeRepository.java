import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class EmployeeRepository extends EntityRepository {

    public EmployeeRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
