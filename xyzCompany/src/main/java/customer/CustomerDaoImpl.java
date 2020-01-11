package customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class CustomerDaoImpl implements CustomerDao {

	private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    
    public void saveCustomer(Customer customer)
    {
        String sql = "insert into customer values(?,?,?,?,?)";

        jdbcTemplate.update(sql, new Object[]
        { customer.getCustomerId(), customer.getDeptId(), customer.getCustomerName(), customer.getContactNo(), customer.getAddress() });
    }

 
    public Customer getCustomerByDeptId(int customerId)
    {
        String sql = "select * from customer where deptId=?";
        Customer customer = (Customer) jdbcTemplate.queryForObject(sql, new Object[]
        { customerId }, new RowMapper()
        {
            @Override
            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                Customer customer = new Customer();
                customer.setCustomerId(rs.getInt(1));
                customer.setDeptId(rs.getInt(2));
                customer.setCustomerName(rs.getString(3));
                customer.setContactNo(rs.getString(4));
                customer.setAddress(rs.getString(5));
                return customer;
            }
        });
        return customer;
    }

    
    public List<Customer> getAlCustomer()
    {
        String sql = "select * from customer";

        List<Customer> customerList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Customer>>()
        {
            @Override
            public List<Customer> extractData(ResultSet rs) throws SQLException, DataAccessException
            {
                List<Customer> list = new ArrayList<Customer>();
                while (rs.next())
                {
                    Customer customer = new Customer();
                    customer.setCustomerId(rs.getInt(1));
                    customer.setDeptId(rs.getInt(2));
                    customer.setCustomerName(rs.getString(3));
                    customer.setContactNo(rs.getString(4));
                    customer.setAddress(rs.getString(4));
                    list.add(customer);
                }
                return list;
            }

        });
        return customerList;
    }

    public void updateCustomer(Customer customer)
    {
        String sql = "update customer set deptId =?, customerName=?, contactNo=? address=? where ustomerId=?";
        jdbcTemplate.update(sql, new Object[]
        { customer.getDeptId(), customer.getCustomerName(), customer.getContactNo(), customer.getAddress(), customer.getCustomerId() });
    }

}
