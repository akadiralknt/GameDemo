package Concrete;

import Abstract.BaseCustomerManager;
import Abstract.CustomerCheckService;
import Abstract.CustomerService;
import Entities.Customer;

public class StarbucksCustomerManager extends BaseCustomerManager {
	
	private CustomerCheckService customerCheckService;
	
	
	public StarbucksCustomerManager(CustomerCheckService customerCheckService) {
		super();
		this.customerCheckService = customerCheckService;
	}


	@Override
	public void save(Customer customer) {
		try {
            if (customerCheckService.checkIfRealPerson(customer)){
                System.out.println("Successfully saved : "+customer.getFirstName()+" "+customer.getLastName());
            }
            else{
                System.out.println("Customer could not be verified. : "+customer.getFirstName()+" "+customer.getLastName());
            }
        } catch (Exception e) {
            System.out.println("Can't access MERNÝS validation service. Please try again.");
            System.out.println(e.getMessage());
        }
		/*
		 * if(customerCheckService.checkIfRealPerson(customer)) { super.save(customer);
		 * } else { System.err.println("Not a valid person"); }
		 */
	}

}
