package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Product;
import model.ProductDAO;

class TestProduct {
	private static ProductDAO productDao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		productDao = new ProductDAO();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	// Nhập đầy đủ các trường
	@Test
	void test1() {
		productDao.deleteAllProduct();
		boolean kq = productDao.insertProduct(new Product("1", "IphoneX", 2, 20000000, "Apple"));
		assertEquals(true, kq);
	}

	// Để trống trường id
	@Test
	void test2() {
		productDao.deleteAllProduct();
		boolean kq = productDao.insertProduct(new Product(null, "IphoneX", 2, 20000000, "Apple"));
		assertEquals(false, kq);
	}

	// Để trống trường name
	@Test
	void test3() {
		productDao.deleteAllProduct();
		boolean kq = productDao.insertProduct(new Product("1", null, 2, 20000000, "Apple"));
		assertEquals(false, kq);
	}

	// Để trống trường amount
//	@Test
//	void test4() {
//		productDao.deleteAllProduct();
//		boolean kq = productDao.insertProduct(new Product("1", "IphoneX", null, 20000000, "Apple"));
//		assertEquals(true, kq);
//	}
//	//Để trống trường price
//	@Test
//	void test5() {
//		productDao.deleteAllProduct();
//		boolean kq = productDao.insertProduct(new Product("1", "IphoneX", 2, null, "Apple"));
//		
	// Để trống trường brand
	@Test
	void test6() {
		productDao.deleteAllProduct();
		boolean kq = productDao.insertProduct(new Product("1", "IphoneX", 2, 20000000, null));
		assertEquals(false, kq);
	}

	// Để trống tất cả các trường
//	@Test
//	void test27() {
//		productDao.deleteAllProduct();
//		productDao.insertProduct(new Product(null, "IphoneX", 2, 20000000, "Apple"));
//		boolean kq = productDao.insertProduct(new Product("1", "IphoneX", 2, 20000000, "Apple"));
//		assertEquals(false, kq);
//	}
	// Trùng id
	@Test
	void test8() {
		productDao.deleteAllProduct();
		productDao.insertProduct(new Product("1", "IphoneX", 2, 20000000, "Apple"));
		boolean kq = productDao.insertProduct(new Product("1", "IphoneX", 2, 20000000, "Apple"));
		assertEquals(false, kq);
	}

	// Id 5 ký tự
	@Test
	void test9() {
		productDao.deleteAllProduct();
		boolean kq = productDao.insertProduct(new Product("12345", "IphoneX", 2, 20000000, "Apple"));
		assertEquals(true, kq);
	}

	// Id 4 ký tự
	@Test
	void test10() {
		productDao.deleteAllProduct();
		boolean kq = productDao.insertProduct(new Product("1234", "IphoneX", 2, 20000000, "Apple"));
		assertEquals(true, kq);
	}

	// Id 6 ký tự
	@Test
	void test11() {
		productDao.deleteAllProduct();
		boolean kq = productDao.insertProduct(new Product("123456", "IphoneX", 2, 20000000, "Apple"));
		assertEquals(true, kq);
	}

	// Id 0 ký tự
	@Test
	void test12() {
		productDao.deleteAllProduct();
		boolean kq = productDao.insertProduct(new Product(null, "IphoneX", 2, 20000000, "Apple"));
		assertEquals(false, kq);
	}

	// Id 1 ký tự
	@Test
	void test13() {
		productDao.deleteAllProduct();
		boolean kq = productDao.insertProduct(new Product("1", "IphoneX", 2, 20000000, "Apple"));
		assertEquals(true, kq);
	}

	// Để trống id, name và nhập amount, price,brand
	@Test
	void test14() {
		productDao.deleteAllProduct();
		boolean kq = productDao.insertProduct(new Product(null, null, 2, 20000000, "Apple"));
		assertEquals(false, kq);
	}

	// Để trống id,name, brand và nhập amount,price
	@Test
	void test15() {
		productDao.deleteAllProduct();
		boolean kq = productDao.insertProduct(new Product(null, null, 2, 20000000, null));
		assertEquals(false, kq);
	}

	// Để trống name, brand nhập id, amount, price
	@Test
	void test16() {
		productDao.deleteAllProduct();
		boolean kq = productDao.insertProduct(new Product("1", null, 2, 20000000, null));
		assertEquals(false, kq);
	}

	// Để trống brand,id nhập name , amount , price
	@Test
	void test17() {
		productDao.deleteAllProduct();
		boolean kq = productDao.insertProduct(new Product(null, "IphoneX", 2, 20000000, null));
		assertEquals(false, kq);
	}

	// Brand có 10 ký tự
	@Test
	void test18() {
		productDao.deleteAllProduct();
		boolean kq = productDao.insertProduct(new Product("1", "IphoneX", 2, 20000000, "1234567890"));
		assertEquals(true, kq);
	}

	// Brand có 11 ký tự
	@Test
	void test19() {
		productDao.deleteAllProduct();
		boolean kq = productDao.insertProduct(new Product("1", "IphoneX", 2, 20000000, "12345678901"));
		assertEquals(false, kq);
	}

	// Brand có 9 ký tự
	@Test
	void test20() {
		productDao.deleteAllProduct();
		boolean kq = productDao.insertProduct(new Product("1", "IphoneX", 2, 20000000, "123456789"));
		assertEquals(true, kq);
	}

	// Brand có 0 ký tự
	@Test
	void test21() {
		productDao.deleteAllProduct();
		boolean kq = productDao.insertProduct(new Product("1", "IphoneX", 2, 20000000, ""));
		assertEquals(true, kq);
	}

	// Brand có 1 ký tự
	@Test
	void test22() {
		productDao.deleteAllProduct();
		boolean kq = productDao.insertProduct(new Product("1", "IphoneX", 2, 20000000, "1"));
		assertEquals(true, kq);
	}

	// Price có 11 ký tự
	@Test
	void test23() {
		productDao.deleteAllProduct();
		boolean kq = productDao.insertProduct(new Product("1", "IphoneX", 2, 20000000000.0, "12345"));
		double b = 1234567.2;
		assertEquals(false, kq);
	}

	// Price có 10 ký tự
	@Test
	void test24() {
		productDao.deleteAllProduct();
		boolean kq = productDao.insertProduct(new Product("1", "IphoneX", 2, 2000000000.0, "12345"));
		double b = 1234567.2;
		assertEquals(true, kq);
	}

	// Price có 1 ký tự
	@Test
	void test25() {
		productDao.deleteAllProduct();
		boolean kq = productDao.insertProduct(new Product("1", "IphoneX", 2, 2, "12345"));
		double b = 1234567.2;
		assertEquals(true, kq);
	}
//	// name 5 ký tự
//		@Test
//		void test26() {
//			productDao.deleteAllProduct();
//			boolean kq = productDao.insertProduct(new Product("12345", "IphoneX", 2, 20000000, "Apple"));
//			assertEquals(true, kq);
//		}
//	 Price có 50 ký tự:bi tran phan tu
		@Test
		void test26() {
			productDao.deleteAllProduct();
			boolean kq = productDao.insertProduct(new Product("1", "IphoneX", 2, 2.5, "12345"));
			double b = 1234567.2;
			assertEquals(true, kq);
		}
}
