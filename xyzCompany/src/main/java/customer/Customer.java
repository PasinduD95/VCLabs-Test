package customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import department.Department;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerId;
	
	private int deptId;
		
	private String customerName;
		
	private String contactNo;
		
	private String address;
	
	@ManyToOne
    @JoinColumn(name="deptId", nullable=false)
    private Department department;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	 @Override
	 public String toString(){
	 
		 return "Customer [customerId=" + customerId + ", deptId=" + deptId + ", customerName=" + customerName + ", contactNo=" + contactNo + "]";
	 }
	
}
