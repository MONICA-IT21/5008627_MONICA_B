package DESIGN_AND_PATTERN.DependencyInjectionExample;

public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public Customer findCustomerById(String id) {
        
        if ("123".equals(id)) {
            return new Customer("IT182", "MONICA B");
        }
        return null;
    }
}

