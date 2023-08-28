package com.banking.fellswargo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.validator.PublicClassValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.banking.fellswargo.model.Customer;
import com.banking.fellswargo.repository.CustomerRepository;
import com.banking.fellswargo.service.CustomerService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {
	
	@MockBean
	private CustomerRepository customerRepository;
	
	@Autowired
	CustomerService customerService;

//	@Autowired
//	userController userC;
//	@Autowired
//	UserStatus us;
//
//	@Autowired
//	User user;
//	
	@Test
	public void createCustomerTest() {
		LocalDate date = LocalDate.now();
		Customer customer = new Customer("pass", false,false,date );
		//Mock database
		when(customerRepository.save(customer)).thenReturn(customer);
		
		assertEquals(customer.getPassword(), customerService.createCustomer(customer).getPassword());
		
	}
	@Test
	public void findAllCustomer() {
		LocalDate date = LocalDate.now();
		Customer customer = new Customer("pass", false,false,date );
		Customer customer2 = new Customer("pass", false,false,date );

		List<Customer> list = new ArrayList<>();
		list.add(customer);
		list.add(customer2);
		when(customerRepository.findAll()).thenReturn(list);
		assertEquals(2, customerService.getAllCustomers().size());
	}
	
	@Test
	public void getUsersTest() {
		
		assertEquals(1, 1);
	}
	
	
//	@Test
//	public void addUserTest() {
//		
//		User user=new User(4456,"ddfgh",(long)4556667,"ftgfg","drcfvg");
//		UserStatus us=new UserStatus(true, 0);
//		when(userData.save(user))
//		.thenReturn(user);
////		
//		assertEquals(us.getErrcode(), um.addUser(user).getErrcode() );
////		User res = userData.save(user);
////		assertTrue(user.equals(user));
//	}
	
//	@Test
//	public void registerTest()
//	{
//		User user=new User(4456,"ddfgh",(long)4556667,"ftgfg","drcfvg");
//
//		UserStatus us=new UserStatus(true, 0);
//		
////		when(um.addUser(user)).thenReturn(us);
//		when(userData.save(user))
//		.thenReturn(user);
//		assertEquals( us.getErrcode(), userC.register(user).getErrcode() );
//		
//		
//	}
	
//	
//	public void getDetailsTest() {
//		
//		
//		when(null)
//		
//		assertEquals(0, userC.getDetails(authReq));
//		
//		
//	}
//	@Test
//	public void loginTest() {
//		
//		AuthReq authReq = new AuthReq("hbhdfbjbj@gmail.com", "dfgh345678");
//		User user1=new User(4456,"ddfgh",(long)4556667,"hbhdfbjbj@gmail.com","dfgh345678");
//		User user2=new User(4457,"dfgvbn",(long)4556467,"hbhdfbjbj@gmail.com","dfgh345678");
//		AuthStatus aStatus=new AuthStatus(true,0, (long) 45678.67);
//		
//		ArrayList<User> lst = new ArrayList<User>(2);
//		lst.add(user1);
//		lst.add(user2);
//		when(userData.findByEmail("hbhdfbjbj@gmail.com")).thenReturn(lst);
//		
//		
//		assertEquals(aStatus.getErrcode(), userC.login(authReq).getErrcode());
//	}
	
	
	
//	public void getDetailsTest() {
//		
//		Optional<User> user1=Optional.ofNullable(new User(1,"ddfgh",(long)4556667,"hbhdfbjbj@gmail.com","dfgh345678"));
//		when(userData.findById(long)"1").thenReturn(user1));
//		assertEquals(user1, userC.getDetails("1"));
//	}
//	
//	public void deleteTest() {
//		
//	}

	
	
}
