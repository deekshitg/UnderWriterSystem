package com.us.service;

import java.util.ArrayList;

import com.us.beans.Coverage;
import com.us.beans.InsuranceProduct;
import com.us.beans.InsuranceType;
import com.us.beans.User;
import com.us.dao.UserDtlDao;

public class UserDtlService {

	public User getUserDetails(String uName,String role,String password){
	
		User user = null;
		
		try{
			
			UserDtlDao userDtlDao = new UserDtlDao();
			user = userDtlDao.loadUserDetails(uName,role,password);
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return user;
	}
	public static ArrayList<Coverage> fetchCoverage() {
		UserDtlDao userDtlDao=new UserDtlDao();
		return userDtlDao.fetchCoverage();
		
	}

	public static int addProduct(InsuranceProduct insuranceProduct,int createdBy,int updatedBy) {
		
		UserDtlDao userDtlDao=new UserDtlDao();
	 return userDtlDao.addProduct(insuranceProduct,createdBy,updatedBy);	
	}

	public static int updateProduct(InsuranceProduct insuranceProduct,int updatedBy) {
		UserDtlDao userDtlDao=new UserDtlDao();
		 return userDtlDao.updateProduct(insuranceProduct,updatedBy);
	}
	public ArrayList<InsuranceProduct> viewProduct()
	 {
		 UserDtlDao userDtlDao=new UserDtlDao();
		 return userDtlDao.viewProduct();
	 }

	public InsuranceProduct autoFill(int product_id) {
		
		UserDtlDao userDtlDao=new UserDtlDao();
		return userDtlDao.autoFill(product_id);
	}

	public int deleteProduct(int product_id) {
		UserDtlDao userDtlDao=new UserDtlDao();
		return userDtlDao.deleteProduct(product_id);
	}
	public int createUser(User user) throws Exception{
		UserDtlDao userDtlDaoObj = new UserDtlDao();
		return userDtlDaoObj.createUser(user);
	}

	public ArrayList<User> displayUsers() {
		UserDtlDao userDtlDaoObj = new UserDtlDao();
		ArrayList<User> userList = userDtlDaoObj
				.displayUsers();
		return userList;
	}

	public String deleteUser(int id) {
		UserDtlDao userDtlDaoObj = new UserDtlDao();
		return userDtlDaoObj.deleteUser(id);
	}

	public User updateUser(int id) {
		UserDtlDao userDtlDaoObj = new UserDtlDao();
		return userDtlDaoObj.updateUser(id);
	}

	public int updatedUser(User user) {
		UserDtlDao userDtlDaoObj = new UserDtlDao();
		return userDtlDaoObj.updatedUser(user);
	}
//---------------------coverage Service------------------------------------------------
	
public int createCoverage(Coverage coverage,int createdBy){
		
		UserDtlDao userDtlDao = new UserDtlDao();
		return userDtlDao.createCoverage(coverage, createdBy);
	}
	public ArrayList<Coverage> ViewCoverageDetails() {
		
		UserDtlDao userDtlDao = new UserDtlDao();
		return userDtlDao.ViewCoverageDetails();
		
	}
	public ArrayList<Coverage> updateCoverage(Coverage coverage,int updatedBy) {
		// TODO Auto-generated method stub
		UserDtlDao userDtlDao = new UserDtlDao();
		return userDtlDao.updateCoverage(coverage, updatedBy);
	}
	public int DeleteCoverage(int coverageID) {
		// TODO Auto-generated method stub
		UserDtlDao userDao=new UserDtlDao();
		return userDao.DeleteCoverage(coverageID);
	}
	public ArrayList<Coverage> fetchupdateCoverage(int coverageID) {
		// TODO Auto-generated method stub
		UserDtlDao userDtlDao = new UserDtlDao();
		return userDtlDao.fetchupdateCoverage(coverageID);
	}
	
//-------------------Coverage Service----------------------------------------------------	
	
	
	//start by harichandna for insurance type
	
	public static ArrayList<InsuranceProduct> fetchInsuranceProduct() {
		
		UserDtlDao dao=new UserDtlDao();
		return dao.fetchInsuranceProduct();
		
	}
	public static int addinsuranceType(InsuranceType insurancetype,int createdBy,int updatedBy) {
		
		UserDtlDao dao=new UserDtlDao();
	 return dao.addInsuranceType(insurancetype,createdBy,updatedBy);	
	}
	
	public ArrayList<InsuranceType> viewType()
	 {
		 UserDtlDao userDao=new UserDtlDao();
		 return userDao.viewType();
	 }
	
	public int deleteType(int type_id)
	 {
		 UserDtlDao userDao=new UserDtlDao();
		 return userDao.deleteType(type_id);
	 }

	public InsuranceType autoFillInsuranceType(int type_id) {
		UserDtlDao userDao=new UserDtlDao();
		return userDao.autoFillInsuranceType(type_id);
	}

	public static int updateProduct(InsuranceType insuranceType,
			int updatedBy) {
		UserDtlDao userDao=new UserDtlDao();
		return userDao.updateProduct(insuranceType,updatedBy);
	}
	
	//start by harichandna for insurance type
	
}
