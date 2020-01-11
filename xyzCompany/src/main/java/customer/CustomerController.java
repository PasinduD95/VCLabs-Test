package customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @RequestMapping(value = "/customer",method=RequestMethod.POST)
    public ModelAndView saveEmployee(@ModelAttribute("customer") Customer customer)
    {
        try
        {
            customerDao.getCustomerByDeptId(customer.getCustomerId());
         
        }
        catch(EmptyResultDataAccessException e)
        {
            
            customerDao.saveCustomer(customer);
        }
        return new ModelAndView("redirect:/customers");
    }
    

    @RequestMapping(value = "/customers")
    public ModelAndView listCustomers(@ModelAttribute("customer") Customer customer)
    {
        ModelAndView model = new ModelAndView("customers");

        List customerList = customerDao.getAllEmployees();
        model.addObject("customerList", customerList);
        
        return model;
    }}
