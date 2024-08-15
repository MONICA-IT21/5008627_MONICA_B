import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeBatchProcessor {

    public void saveEmployees(List<Employee> employees, Session session) {
        Transaction transaction = session.beginTransaction();
        int batchSize = 20; // Set your batch size here

        for (int i = 0; i < employees.size(); i++) {
            session.save(employees.get(i));
            if (i % batchSize == 0 && i > 0) {
                session.flush();
                session.clear();
            }
        }
        
        transaction.commit();
    }
}
