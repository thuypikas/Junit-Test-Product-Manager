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

class TestISAccount {

private static AccountDAO account;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception{
		account = new AccountDAO();
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
	
	//Nhập username, pass, fullname, email và phone
	@Test
	void test1() {
		account.deleteAllAccount();
		boolean kq= account.insertAccount(new Account("hieutt", "123","Trần Trung Hiếu", "hieutt@gmail.com", "0962140533"));
		assertEquals(true, kq);
		account.deleteAccount(new Account("hieutt", "123","Trần Trung Hiếu", "hieutt@gmail.com", "0962140533"));
	}
	
	//Username 10 ký tự
	@Test
	void test2() {
		boolean kq= account.insertAccount(new Account("thuy123456", "123","Nguyễn Thị Thu Thủy", "thuyntt@gmail.com", "0962140533"));
		assertEquals(true, kq);
		account.deleteAccount(new Account("thuy123456", "123","Nguyễn Thị Thu Thủy", "thuyntt@gmail.com", "0962140533"));
	}
	
	//Username 9 ký tự 
	@Test
	void test3() {
		boolean kq= account.insertAccount(new Account("thuy123456", "123","Nguyễn Thị Thu Thủy", "thuyntt@gmail.com", "0962140533"));
		assertEquals(true, kq);
		account.deleteAccount(new Account("thuy123456", "123","Nguyễn Thị Thu Thủy", "thuyntt@gmail.com", "0962140533"));
	}
	
	
	//Username 11 ký tự 
	@Test
		void test4() {
			boolean kq= account.insertAccount(new Account("thuy12345678", "123","Nguyễn Thị Thu Thủy", "thuyntt@gmail.com", "0962140533"));
			assertEquals(false, kq);
		}
	
	//Username 0 ký tự 
	@Test
			void test5() {
				boolean kq= account.insertAccount(new Account("", "123","Nguyễn Thị Thu Thủy", "thuyntt@gmail.com", "0962140533"));
				assertEquals(false, kq);
				account.deleteAccount(new Account("", "123","Nguyễn Thị Thu Thủy", "thuyntt@gmail.com", "0962140533"));
			}
	//Username 1 ký tự 
	@Test
	void test6() {
		boolean kq= account.insertAccount(new Account("t", "123","Nguyễn Thị Thu Thủy", "thuyntt@gmail.com", "0962140533"));
		assertEquals(true, kq);
		account.deleteAccount(new Account("t", "123","Nguyễn Thị Thu Thủy", "thuyntt@gmail.com", "0962140533"));
	}

	//Pass 10 ký tự 
	@Test
		void test7() {
			boolean kq= account.insertAccount(new Account("thuy", "1234567890","Nguyễn Thị Thu Thủy", "thuyntt@gmail.com", "0962140533"));
			assertEquals(true, kq);
			account.deleteAccount(new Account("thuy", "1234567890","Nguyễn Thị Thu Thủy", "thuyntt@gmail.com", "0962140533"));
		}
		
	//Pass 11 ký tự 
	@Test
		void test8() {
			boolean kq= account.insertAccount(new Account("thuy", "12345678901","Nguyễn Thị Thu Thủy", "thuyntt@gmail.com", "0962140533"));
			assertEquals(false, kq);
		
			}
		
	//Pass 9 ký tự 
	@Test
	void test9() {
		boolean kq= account.insertAccount(new Account("thuy", "123456789","Nguyễn Thị Thu Thủy", "thuyntt@gmail.com", "0962140533"));
		assertEquals(true, kq);
		account.deleteAccount(new Account("thuy", "123456789","Nguyễn Thị Thu Thủy", "thuyntt@gmail.com", "0962140533"));
	}
	
	//Pass 0 ký tự 
	@Test
	void test10() {
		boolean kq= account.insertAccount(new Account("thuynt", "","Nguyễn Thị Thu Thủy", "thuyntt@gmail.com", "0962140533"));
		assertEquals(false, kq);
		account.deleteAccount(new Account("thuynt", "","Nguyễn Thị Thu Thủy", "thuyntt@gmail.com", "0962140533"));
	}
	
	//Pass 1 ký tự 
	@Test
	void test11() {
		boolean kq= account.insertAccount(new Account("thuy", "a","Nguyễn Thị Thu Thủy", "thuyntt@gmail.com", "0962140533"));
		assertEquals(false, kq);
		account.deleteAccount(new Account("thuy", "a","Nguyễn Thị Thu Thủy", "thuyntt@gmail.com", "0962140533"));
	}
	
	//Để rống tất cả các trường
	@Test
	void test12() {
		boolean kq= account.insertAccount(new Account(null, null,null, null, null));
		assertEquals(false, kq);
	}
	//Để rống trường username
		@Test
		void test13() {
			boolean kq= account.insertAccount(new Account(null,"123","Nguyễn Thị Thu Thủy", "thuyntt@gmail.com", "0962140533"));
			assertEquals(false, kq);
		}
	//Để rống trường password
		@Test
		void test14() {
			boolean kq= account.insertAccount(new Account("thuyntt",null,"Nguyễn Thị Thu Thủy", "thuyntt@gmail.com", "0962140533"));
			assertEquals(false, kq);
		}
	//Để trống trường fullname
		@Test
		void test15() {
			boolean kq= account.insertAccount(new Account("thuyntt", "123",null, "thuyntt@gmail.com", "0962140533"));
			assertEquals(false, kq);
		}
	//Để trống trường email
		@Test
		void test16() {
			boolean kq= account.insertAccount(new Account("thuyntt", "123","Nguyễn Thị Thu Thủy", null, "0962140533"));
			assertEquals(false, kq);
		}
	//Để trống trường sđt
		@Test
		void test17() {
			boolean kq= account.insertAccount(new Account("thuyntt", "123","Nguyễn Thị Thu Thủy", "thuyntt@gmail.com",null));
			assertEquals(false, kq);
		}
	//Trùng user name
		@Test
		void test18() {
			account.insertAccount(new Account("thuy", "123","Nguyễn Thị Thu Thủy", "thuyntt@gmail.com", "0962140533"));
			boolean kq= account.insertAccount(new Account("thuy", "123","Nguyễn Thị Thu Thủy", "thuyntt@gmail.com", "0962140533"));
			assertEquals(false, kq);
		}
		//Username là số nguyên
		@Test
		void test19() {
			boolean kq= account.insertAccount(new Account("1405", "123","Nguyễn Thị Thu Thủy", "thuyntt@gmail.com","05486714"));
			assertEquals(false, kq);
		}
		//Username la so thuc
		@Test
		void test20() {
			boolean kq= account.insertAccount(new Account("14.5", "123","Nguyễn Thị Thu Thủy", "thuyntt@gmail.com","05486714"));
			assertEquals(false, kq);
		}
		@Test
		void test21() {
			boolean kq= account.insertAccount(new Account("@!#$$", "123","Nguyễn Thị Thu Thủy", "thuyntt@gmail.com","05486714"));
			assertEquals(false, kq);
		}
		
}
