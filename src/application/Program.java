package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("==== TEST 1: seller findByld ====");
		Seller seller = sellerDao.findByld(3);
		System.out.println(seller);
	
		System.out.println("\n==== TEST 2: seller findByldDepartment ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByldDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== TEST 3: seller findAll ====");
        list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
	
		System.out.println("\n==== TEST 4: seller Insert ====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n==== TEST 5: seller Update ====");
		seller = sellerDao.findByld(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");
	
		System.out.println("\n==== TEST 6: seller Delete ====");
		System.out.print("Entre com ID para o teste de deletar: ");
		int id = sc.nextInt();
		sellerDao.deleteByld(id);
		System.out.println("Delete completed");
		
		sc.close();
	}
}
