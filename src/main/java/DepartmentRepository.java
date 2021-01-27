import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DepartmentRepository extends EntityRepository {

    public DepartmentRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
