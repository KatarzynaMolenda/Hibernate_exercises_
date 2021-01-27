import org.hibernate.SessionFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
        EmployeeRepository employeeRepository = new EmployeeRepository(sessionFactory);
        Employee employee = (Employee) employeeRepository.get(1);
        System.out.println(employee);

        Employee newEmployee = new Employee("Adam", "Adamski", LocalDate.of(1988, 11, 11));
        employeeRepository.save(newEmployee);
        employee.setFirstName("Benek");
        newEmployee.setFirstName("Tomasz");
        employeeRepository.update(employee);
        employeeRepository.update(newEmployee);
        employeeRepository.delete(employee);
        sessionFactory.close();
    }

}
