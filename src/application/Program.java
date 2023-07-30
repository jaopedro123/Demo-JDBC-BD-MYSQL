package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("==== TEST 1: seller findByld ====");
		Seller seller = sellerDao.findByld(3);
		System.out.println(seller);
	
		System.out.println("\n==== TEST 2: seller findByld ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByldDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
	}
}
