package DESIGN_AND_PATTERN.DependencyInjectionExample;

public interface CustomerRepository {
    Customer findCustomerById(String id);
}

