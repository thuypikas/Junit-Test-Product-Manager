package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Account;
import model.AccountDAO;

class TestAccount {
	private static AccountDAO accountdao;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception{
		accountdao = new AccountDAO();
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception{
		
	}
	
	@BeforeEach 
	void setUp() throws Exception{
		
	}
	
	@AfterEach
	void tearDown() throws Exception{
		
	}
	
	//Đúng Username, đúng Password
	@Test
	void test1() {
		accountdao.insertAccount(new Account("thuyntt","123","Nguyễn Thị Thu Thủy","thuyntt@gmail.com","0962140533"));
		boolean kq= accountdao.checkAccount("thuyntt","123");
		assertEquals(true, kq);;
	}
	
	//Để trống Username, sai Password
	@Test
	public void test2() {
		boolean kq= accountdao.checkAccount(null, "111");
		assertEquals(false, kq);
	}
	
	//Để trống Username, đúng Password
	@Test
	public void test3() {
		boolean kq= accountdao.checkAccount(null, "123");
		assertEquals(false, kq);
	}
	
	//Sai Username. Để trống Password
	@Test
	public void test4() {
		boolean kq= accountdao.checkAccount("thuynt", null);
		assertEquals(false, kq);
	}
	
	//Sai Username. sai Password
	@Test
	public void test5() {
		boolean kq= accountdao.checkAccount("thuynt", "111");
		assertEquals(false, kq);
	}
	
	//Sai Username, đúng Password
	@Test
	public void test6() {
		boolean kq= accountdao.checkAccount("thuynt", "123");
		assertEquals(false, kq);
	}
	
	//Đúng Username, để trống Password
	@Test
	public void test7() {
		boolean kq= accountdao.checkAccount("thuyntt", null);
		assertEquals(false, kq);
	}
	
	//Đúng Username, sai Password
	@Test
	public void test8() {
		boolean kq= accountdao.checkAccount("thuyntt", "111") ;
		assertEquals(false, kq);
	}
	
	//Để trống Username, Password
	@Test
	public void test9() {
		boolean kq= accountdao.checkAccount(null, null);
		assertEquals(false, kq);
	}
	//Username 

}
