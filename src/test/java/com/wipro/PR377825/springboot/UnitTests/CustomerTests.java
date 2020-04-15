package com.wipro.PR377825.springboot.UnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.wipro.PR377825.springboot.RestController.CustomerRestController;
import com.wipro.PR377825.springboot.entity.Customer;
import com.wipro.PR377825.springboot.repository.CustomerRepo;
import com.wipro.PR377825.springboot.services.DashboardService;


@SpringBootTest
public class CustomerTests 
{
	@InjectMocks
	CustomerRestController custRestCtrl;
	@Mock
	DashboardService dashServ;
	
	@InjectMocks
	DashboardService dashService;
	@Mock
	CustomerRepo custRepo;


	@Before
	public void init() 
	{
		MockitoAnnotations.initMocks(this);
	}



	@Test
	public void getAllCustomersTest()
	{
		String res = "";
		System.out.println("Running unit test case");
		System.out.println("fetching all customer details");

//        Customer cust = new Customer();
		Customer cust1 = new Customer("PK01", "pranav.kalra3@wipro.com", "Pranav", "Kalra", "123", "9717275141");
        custRepo.save(cust1);
		//		getting list of all customers by calling getAllCustomers method from dashboard service.		
		try
		{
			List<Customer> customer = dashService.getAllCustomers();
			if (customer != null)
			{
				System.out.println("fetched all customer details");
				System.out.println("data: "+ customer);

				res = "true";
			}
			assertEquals("true", res);
			System.out.println("test case ended");
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	//     second test case
	
	@Test
	public void getAllCustomersTest1()
	{
//		String res = "";
		System.out.println("Running unit test case");
		System.out.println("fetching all customer details");

      ResponseEntity<List<Customer>> response = custRestCtrl.getAllCustomers();
      System.out.println("result: "+response);
      String res = response.toString();
      
			assertEquals("<200 OK OK,[],[]>", res);
			System.out.println("test case ended");
		}
		

	
	
//	****************************
	
	// given
   
//    Employee employee2 = new Employee(2, "Alex", "Gussin", "example@gmail.com");
//    Employees employees = new Employees();
//    employees.setEmployeeList(Arrays.asList(employee1, employee2));
//
//    when(employeeDAO.getAllEmployees()).thenReturn(employees);
//
//    // when
//    Employees result = employeeController.getEmployees();
//
//    // then
//    assertThat(result.getEmployeeList().size()).isEqualTo(2);
//     
//    assertThat(result.getEmployeeList().get(0).getFirstName())
//                    .isEqualTo(employee1.getFirstName());
//     
//    assertThat(result.getEmployeeList().get(1).getFirstName())
//                    .isEqualTo(employee2.getFirstName());
//	
//	****************************
    
	
}

