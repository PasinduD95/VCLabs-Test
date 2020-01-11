package customer;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public interface CustomerDao {

	public interface EmployeeDAO
	{
	    public void saveCustomer(Customer customer);
	    
	    public Customer getCustomerByDeptId(int customerId);
	    
	    public void updateCustomer(Customer customer);
	    
	    public List<Customer> getAllCustomer();
	}
	
}
