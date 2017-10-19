package com.us.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import com.us.beans.Coverage;
import com.us.beans.InsuranceProduct;
import com.us.beans.InsuranceType;
import com.us.beans.User;
import com.us.connection.DBTransaction;

public class UserDtlDao {

	Connection connection = null; 
	StringBuffer stringBuffer = null;
	PreparedStatement preparedStatement = null;
	PreparedStatement preparedStatement1 = null;
	PreparedStatement preparedStatement2 = null;
	ResultSet resultSet = null;
	private ResultSet rs = null;
	private int userId;
	DBTransaction dbTransaction = null;
	
	public int createUser(User user) throws ParseException {
		try {

			dbTransaction = new DBTransaction();
			Connection con = dbTransaction.getConnection();
			preparedStatement1 = con.prepareStatement("insert into user_dtls values (sequence_user.nextval,?,?,?,?,?,?,?,?)");
			preparedStatement1.setString(1, user.getUserName());
			preparedStatement1.setString(2, user.getRole());
			preparedStatement1.setString(3, "Active");
			preparedStatement1.setString(4, user.getPassword());
			preparedStatement1.setInt(5, 1);

			Calendar calendar = Calendar.getInstance();
			java.util.Date now = calendar.getTime();
			java.sql.Date currentDate = new java.sql.Date(now.getTime());

			preparedStatement1.setDate(6, currentDate);
			preparedStatement1.setInt(7, 3);
			preparedStatement1.setDate(8, currentDate);

			preparedStatement1.executeUpdate();

			preparedStatement2 = con
					.prepareStatement("select sequence_user.currval from dual");
			rs = preparedStatement2.executeQuery();
			while (rs.next()) {
				userId = rs.getInt(1);
			}

		} catch (SQLException S) {
			S.printStackTrace();
		}
		dbTransaction.closeConnection();
		return userId;
	}

	public ArrayList<User> displayUsers() {
		
		dbTransaction = new DBTransaction();
		
		ArrayList<User> userList = new ArrayList<User>();
		Connection con = dbTransaction.getConnection();
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		try {
			pstmt1 = con.prepareStatement("Select * from user_dtls order by user_id");
			rs = pstmt1.executeQuery();

			while (rs.next()) {
				int userId = rs.getInt("USER_ID");
				String userName = rs.getString("USER_NAME");
				String role = rs.getString("ROLE");
				String status = rs.getString("USER_STATUS");
				String userpwd = rs.getString("PASSWORD");
				
				User user = new User();
				user.setUserId(userId);
				user.setUserName(userName);
				user.setRole(role);
				user.setUserStatus(status);
				user.setPassword(userpwd);

				userList.add(user);
			}

		} catch (SQLException S) {
			S.printStackTrace();
		}
		dbTransaction.closeConnection();
		return userList;
	}

	public String deleteUser(int id) {

		dbTransaction = new DBTransaction();
		
		int i = 0;
		Connection con = dbTransaction.getConnection();
		try {
			preparedStatement1 = con
					.prepareStatement("UPDATE user_dtls SET USER_STATUS='Disabled' WHERE USER_ID ="
							+ id);
			i = preparedStatement1.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbTransaction.closeConnection();
		}
		if (i == 1) {
			return ("successfully Deleted " + id);
		} else {
			return ("Deletion failed :" + id);
		}

	}

	public User updateUser(int id) {
		
		dbTransaction = new DBTransaction();
		Connection con = dbTransaction.getConnection();
		ResultSet rs = null;
		User user = new User();
		try {
			preparedStatement1 = con
					.prepareStatement("Select * from user_dtls where USER_ID="
							+ id);
			rs = preparedStatement1.executeQuery();

			while (rs.next()) {
				int userId = rs.getInt("USER_ID");
				String userName = rs.getString("USER_NAME");
				String role = rs.getString("ROLE");
				String status = rs.getString("USER_STATUS");
				String userpwd = rs.getString("PASSWORD");

				user.setUserId(userId);
				user.setUserName(userName);
				user.setRole(role);
				user.setUserStatus(status);
				user.setPassword(userpwd);

			}
		} catch (SQLException S) {
			S.printStackTrace();
		}
		return user;
	}

	public int updatedUser(User user) {
		
		dbTransaction = new DBTransaction();
		
		int i = 0;
		Connection con = dbTransaction.getConnection();
		try {
			preparedStatement1 = con
					.prepareStatement("UPDATE user_dtls SET USER_NAME=?,ROLE=?,UPDT_USER=?,UPDT_DATE=?,user_STATUS=?,password=? WHERE USER_ID =?");
			preparedStatement1.setString(1, user.getUserName());
			preparedStatement1.setString(2, user.getRole());
			
			Calendar calendar = Calendar.getInstance();
			java.util.Date now = calendar.getTime();
			java.sql.Date currentDate = new java.sql.Date(now.getTime());
			
			preparedStatement1.setInt(3, 101);
			preparedStatement1.setDate(4, currentDate);
			preparedStatement1.setString(5, "Active");
			preparedStatement1.setString(6, user.getPassword());
			preparedStatement1.setInt(7, user.getUserId());
			i = preparedStatement1.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbTransaction.closeConnection();
		}
		
		return i;
		
	}
	
	public User loadUserDetails(String uName,String role,String password){
		
		User user = null;
		
		DBTransaction dbTransaction = null;
		dbTransaction = new DBTransaction();
		
		try{
			
			dbTransaction = new DBTransaction();
			connection = dbTransaction.getConnection();
			stringBuffer = new StringBuffer();
			stringBuffer.append("select * from user_dtls where USER_NAME=? and ROLE=? and user_status='Active' ");
			preparedStatement = connection.prepareStatement(stringBuffer.toString());
			preparedStatement.setString(1, uName);
			preparedStatement.setString(2, role);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				
				String tempPass = resultSet.getString("PASSWORD");
				
				if(tempPass.equals(password)){
					
					user = new User();
					user.setUserId(resultSet.getInt("USER_ID"));
					user.setUserName(resultSet.getString("USER_NAME"));
					user.setPassword(password);
					user.setUserStatus(resultSet.getString("USER_STATUS"));
					user.setRole(resultSet.getString("ROLE"));
				}
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return user;
	}
	public ArrayList<Coverage> fetchCoverage()  {
		
		dbTransaction = new DBTransaction();
		ArrayList<Coverage> arraylist=new ArrayList<Coverage>();
		try{
			connection=dbTransaction.getConnection();
			preparedStatement=connection.prepareStatement("select * from coverage_dtls where status='Active'");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Coverage coverage=new Coverage();
				coverage.setId(Integer.parseInt(resultSet.getString("id")));
				coverage.setName(resultSet.getString("name"));

				arraylist.add(coverage);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return arraylist;
	}
	public ArrayList<InsuranceProduct> viewProduct()
	{
		int prev=0;
		DBTransaction dbTransaction = null;
		dbTransaction = new DBTransaction();
		ArrayList<InsuranceProduct> productList=new ArrayList<InsuranceProduct>();
		try {
			connection=dbTransaction.getConnection();
			preparedStatement=connection.prepareStatement("select p.id AS PRODUCT_ID,p.name AS PRODUCT_NAME,c.name AS COVERAGE_NAME,c.id AS COVERAGE_ID,p.status AS STATUS from product_dtls p JOIN product_coverage_mpg pc on p.id=pc.product_id JOIN coverage_dtls c on c.id=pc.coverage_id order by product_id"); 


			resultSet=preparedStatement.executeQuery();
			ArrayList<Coverage> al= new ArrayList<>();
			InsuranceProduct ip = new InsuranceProduct();

			while(resultSet.next())
			{

				int id=resultSet.getInt("PRODUCT_ID");

				if(id==prev)
				{
					prev=id;
				}
				else
				{
					if(prev!=0)
					{
						Coverage[] coverage=al.toArray(new Coverage[al.size()]);
						ip.setCoverage(coverage);
						al.clear();
						productList.add(ip);
						ip = new InsuranceProduct();
					}


					ip.setId(resultSet.getInt("PRODUCT_ID"));
					ip.setName(resultSet.getString("PRODUCT_NAME"));
					ip.setStatus(resultSet.getString("STATUS"));
					prev=id;
				}

				Coverage coverage = new Coverage();
				coverage.setId(resultSet.getInt("COVERAGE_ID"));
				coverage.setName(resultSet.getString("COVERAGE_NAME"));
				al.add(coverage);

			}

			Coverage[] coverage=al.toArray(new Coverage[al.size()]);
			ip.setCoverage(coverage);
			al.clear();
			productList.add(ip);

		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		
		return productList;
	}
	public int addProduct(InsuranceProduct insuranceProduct,int createdBy,int updatedBy) {

		
		DBTransaction dbTransaction = null;
		dbTransaction = new DBTransaction();
		
		int i=0;
		int id=0;
		try{
			connection=dbTransaction.getConnection();
			preparedStatement=connection.prepareStatement("insert into product_dtls values(sequence_product.nextval,?,?,?,?,?,?)");
			preparedStatement.setString(1, insuranceProduct.getName());
			preparedStatement.setString(2, insuranceProduct.getStatus());
			preparedStatement.setInt(3, 4);
			Calendar calendar = Calendar.getInstance();
			java.util.Date now = calendar.getTime();
			java.sql.Date currentDate = new java.sql.Date(now.getTime());
			preparedStatement.setDate(4,currentDate);
			preparedStatement.setInt(5,4);
			preparedStatement.setDate(6, currentDate);
			i=preparedStatement.executeUpdate();
			preparedStatement1=connection.prepareStatement("select sequence_product.currval from dual");
			resultSet=preparedStatement1.executeQuery();
			while(resultSet.next())
			{
				id=resultSet.getInt(1);
			}
			for(int var=0;var<insuranceProduct.getCoverage().length;var++)
			{
				preparedStatement2 = connection.prepareStatement("insert into product_coverage_mpg values(SEQUENCE_PRODUCT_COVERAGE_MPG.nextval,?,?)");
				preparedStatement2.setInt(1, id);
				preparedStatement2.setInt(2,insuranceProduct.getCoverage()[var].getId());
				preparedStatement2.execute();
			}





		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return i;
	}

	public int updateProduct(InsuranceProduct insuranceProduct, int updatedBy) {
		PreparedStatement preparedStatement3=null;
		DBTransaction dbTransaction = null;
		dbTransaction = new DBTransaction();
		int i=0;
		try{
			connection=dbTransaction.getConnection();
			preparedStatement=connection.prepareStatement("update product_dtls set name=?,status=?,updt_user=?,updt_date=? where id=?");
			preparedStatement.setString(1, insuranceProduct.getName());
			preparedStatement.setString(2, "Active");
			preparedStatement.setInt(3, 4);
			Calendar calendar = Calendar.getInstance();
			java.util.Date now = calendar.getTime();
			java.sql.Date currentDate = new java.sql.Date(now.getTime());
			preparedStatement.setDate(4,currentDate);
			preparedStatement.setInt(5,insuranceProduct.getId());

			i=preparedStatement.executeUpdate();

			if(i==1)
			{
				preparedStatement3=connection.prepareStatement("delete from product_coverage_mpg where product_id=?");
				preparedStatement3.setInt(1,insuranceProduct.getId() );
				preparedStatement3.executeQuery();
			}


			for(int var=0;var<insuranceProduct.getCoverage().length;var++)
			{

				preparedStatement2 = connection.prepareStatement("insert into product_coverage_mpg values(SEQUENCE_PRODUCT_COVERAGE_MPG.nextval,?,?)");
				preparedStatement2.setInt(1, insuranceProduct.getId());
				preparedStatement2.setInt(2,insuranceProduct.getCoverage()[var].getId());
				preparedStatement2.execute();
			}


		}catch(SQLException e)

		{
			e.printStackTrace();
		}
		
		return i;
	}
	public InsuranceProduct autoFill(int product_id) {
		int prev=0;
		DBTransaction dbTransaction = null;
		dbTransaction = new DBTransaction();
		ArrayList<Coverage> al= new ArrayList<>();
		InsuranceProduct ip = new InsuranceProduct();
		try{
			connection=dbTransaction.getConnection();
			preparedStatement=connection.prepareStatement("select distinct p.id AS PRODUCT_ID,p.name AS PRODUCT_NAME,c.name AS COVERAGE_NAME,c.id AS COVERAGE_ID,p.status AS STATUS from product_dtls p JOIN product_coverage_mpg pc on p.id=pc.product_id JOIN coverage_dtls c on c.id=pc.coverage_id where p.id=?"); 
			preparedStatement.setInt(1, product_id);
			resultSet=preparedStatement.executeQuery();

			while(resultSet.next())
			{
				int id=resultSet.getInt("PRODUCT_ID");
				if(id==prev)
				{
					prev=id;
				}
				else
				{
					ip.setId(resultSet.getInt("PRODUCT_ID"));
					ip.setName(resultSet.getString("PRODUCT_NAME"));
					ip.setStatus(resultSet.getString("STATUS"));
					prev=id;
				}
				Coverage coverage = new Coverage();
				coverage.setId(resultSet.getInt("COVERAGE_ID"));
				coverage.setName(resultSet.getString("COVERAGE_NAME"));
				al.add(coverage);
			}
			Coverage[] coverage=al.toArray(new Coverage[al.size()]);
			ip.setCoverage(coverage);
			al.clear();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return ip;
	}
	public int deleteProduct(int product_id) {
		int i=0;
		DBTransaction dbTransaction = null;
		dbTransaction = new DBTransaction();
		try{
			connection=dbTransaction.getConnection();
			preparedStatement=connection.prepareStatement("update product_dtls set status='Inactive' where id=?");
			preparedStatement.setInt(1, product_id);
			i=preparedStatement.executeUpdate();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		
			
			return i;
	}
//----------------------------------------------coverage DAo-----------------------------------------------------
	//-----------------Coverage Creation------------------------------------ 
	
		public int createCoverage(Coverage coverage,int createdBy) {
			// TODO Auto-generated method stub
			int CoverageID=0;
			DBTransaction dbTransaction = null;
			Connection connection = null; 
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try{
				dbTransaction = new DBTransaction();
				connection = dbTransaction.getConnection();
				preparedStatement = connection.prepareStatement("insert into coverage_dtls values(sequence_coverage.nextval,?,'Active',?,sysdate,?,sysdate)");
				preparedStatement.setString(1, coverage.getName());
				preparedStatement.setInt(2, createdBy);
				preparedStatement.setInt(3, createdBy);//in creating the ID of created and updated done by same 
				preparedStatement.execute();
				connection.commit();
				
				preparedStatement = connection.prepareStatement("select sequence_coverage.currval as id from dual");
				ResultSet rs=preparedStatement.executeQuery();
				
				if(rs.next()){
					CoverageID=rs.getInt("id");
					}
				connection.commit();
				connection.close();
				}catch (Exception e) {
					System.out.println(e);
				}
				return CoverageID;
		}
		//-----------------View Coverage Details------------------------------------ 
		
		public ArrayList<Coverage> ViewCoverageDetails() {
			DBTransaction dbTransaction = null;
			Connection connection = null; 
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			ArrayList<Coverage> viewCoverage=new ArrayList<Coverage>();
			Coverage coverage=null;
			try{
				
				dbTransaction = new DBTransaction();
				connection = dbTransaction.getConnection();
//				connection.commit();S
				preparedStatement=connection.prepareStatement("select * from coverage_Dtls order by id");
				resultSet=preparedStatement.executeQuery();
				while(resultSet.next()){
					coverage = new Coverage();
					coverage.setId(resultSet.getInt("id"));
					coverage.setName(resultSet.getString("name"));
					coverage.setStatus(resultSet.getString("status"));
					viewCoverage.add(coverage);
					}
				}catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
				
				return viewCoverage;
		}
	//----------------Delete Coverage-------------------------------------------------
		public int DeleteCoverage(int coverageID) {
			DBTransaction dbTransaction = null;
			Connection connection = null; 
			PreparedStatement preparedStatement = null;
			int result = 0;
			try{
				
				dbTransaction = new DBTransaction();
				connection = dbTransaction.getConnection();
				preparedStatement=connection.prepareStatement("update coverage_Dtls  set status=? where id=?");
				preparedStatement.setString(1, "Inactive");
				preparedStatement.setInt(2, coverageID);
				result=preparedStatement.executeUpdate();
				connection.commit();
				connection.close();
					
				}catch (Exception e) {
					System.out.println(e);
				}
				return result;
		}
		//-------------------------update----------------------------
		public ArrayList<Coverage> updateCoverage(Coverage coverage,int updatedBy) {
			DBTransaction dbTransaction = null;
			Connection connection = null; 
			PreparedStatement preparedStatement = null;
			int result = 0;
			ArrayList<Coverage> updateCoverage=new ArrayList<Coverage>();
			try{
				
				dbTransaction = new DBTransaction();
				connection = dbTransaction.getConnection();
				preparedStatement=connection.prepareStatement("update coverage_Dtls  set Name=?,status=?,UPDT_USER=?,UPDT_DATE=sysdate where id=?");
				preparedStatement.setString(1, coverage.getName());
				preparedStatement.setString(2, "Active");
				preparedStatement.setInt(3, updatedBy);
				preparedStatement.setInt(4, coverage.getId());
				result=preparedStatement.executeUpdate();
				connection.commit();
				connection.close();
					
				}catch (Exception e) {
					System.out.println(e);
				}
				return updateCoverage;
		}

		public ArrayList<Coverage> fetchupdateCoverage(int coverageID) {
			DBTransaction dbTransaction = null;
			Connection connection = null; 
			PreparedStatement preparedStatement = null;
			ResultSet resultSet=null;
			ArrayList<Coverage> fetchupdateCoverageList=new ArrayList<Coverage>();
			try{
				
				dbTransaction = new DBTransaction();
				connection = dbTransaction.getConnection();
				preparedStatement=connection.prepareStatement("select * from coverage_Dtls where id=?");
				preparedStatement.setInt(1,coverageID);
				resultSet=preparedStatement.executeQuery();
				if(resultSet.next()){
					Coverage coverage=new Coverage();
					coverage.setId(coverageID);
					coverage.setName(resultSet.getString("name"));
					coverage.setStatus(resultSet.getString("status"));
					fetchupdateCoverageList.add(coverage);
					connection.commit();
					connection.close();
				}
				
				}catch (Exception e) {
					System.out.println(e);
				}
				
				return fetchupdateCoverageList;
				}
	
//----------------------------------------------coverage DAo ----------------------------------------------

		
		//start by harichandna for insurance type
		
		
		public ArrayList<InsuranceProduct> fetchInsuranceProduct() {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rss = null;
			ArrayList<InsuranceProduct> productlist = new ArrayList<InsuranceProduct>();
			try {
				dbTransaction = new DBTransaction();
				con = dbTransaction.getConnection();
				ps = con.prepareStatement("select * from product_dtls");
				rss = ps.executeQuery();
				while (rss.next()) {
					
					InsuranceProduct insuranceproduct=new InsuranceProduct();
					insuranceproduct.setId(rss.getInt("id"));
					insuranceproduct.setName(rss.getString("name"));
					insuranceproduct.setStatus(rss.getString("status"));
					productlist.add(insuranceproduct);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				dbTransaction.closeConnection();
				if (rss != null) {
					try {
						rss.close();
					} catch (Exception ez) {
						ez.printStackTrace();
					}
				}
				if (ps != null) {
					try {
						ps.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

			}
			return productlist;
		}

		
			public int addInsuranceType(InsuranceType insurancetype,int createdBy,int updatedBy) {
			
				Connection con=null;
				PreparedStatement ps=null;
				PreparedStatement ps1=null;
				PreparedStatement ps2=null;
				ResultSet rs=null;
			    int i=0;
			    int id=0;
			try{
				dbTransaction = new DBTransaction();
				con=dbTransaction.getConnection();
				ps=con.prepareStatement("insert into insurance_type_dtls values(sequence_insurance_type.nextval,?,?,?,?,?,?)");
				ps.setString(1,insurancetype.getName());
				ps.setInt(2, 23);
				Calendar calendar = Calendar.getInstance();
				java.util.Date now = calendar.getTime();
				java.sql.Date currentDate = new java.sql.Date(now.getTime());
				ps.setDate(3,currentDate);
				ps.setInt(4, 4);
				ps.setDate(5,currentDate);
				ps.setString(6, insurancetype.getStatus());
				i=ps.executeUpdate();
				ps1=con.prepareStatement("select sequence_insurance_type.currval from dual");
				rs=ps1.executeQuery();
				while(rs.next())
				{ 
					id=rs.getInt(1);
				}
				for(int var=0;var<insurancetype.getInsuranceProducts().length;var++)
				{
					ps2 = con.prepareStatement("insert into insurance_product_type_mpg values(sequence_product_type_mpg.nextval,?,?,?,sysdate,?,sysdate)");
					ps2.setInt(1,insurancetype.getInsuranceProducts()[var].getId());
					ps2.setInt(2,id);
					
					ps2.setInt(3, 26);
					ps2.setInt(4, 26);
				
					ps2.execute();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}finally
			{
				dbTransaction.closeConnection();
				if(rs!=null)
				{
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(ps!=null)
				{
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return i;
		}
		
		
		
		
			public ArrayList<InsuranceType> viewType()
			{
				Connection con=null;
				PreparedStatement ps=null;
				
				ResultSet rs=null;
				int prev=0;
				ArrayList<InsuranceType> insuranceList=new ArrayList<InsuranceType>();
				try {
					dbTransaction = new DBTransaction();
					
					con=dbTransaction.getConnection();
					
					ps=con.prepareStatement("select it.id AS INSURANCE_TYPE_ID,it.name AS TYPE_NAME,it.status AS TYPE_STATUS,p.name AS PRODUCT_NAME,p.id AS PRODUCT_ID from insurance_type_dtls it JOIN insurance_product_type_mpg ipm ON ipm.insurance_type_id=it.id JOIN product_dtls p ON p.id=ipm.product_id order by it.id"); 

					rs=ps.executeQuery();
					ArrayList<InsuranceProduct> al= new ArrayList<InsuranceProduct>();
					InsuranceType it = new InsuranceType();

					while(rs.next())
					{

						int id=rs.getInt("INSURANCE_TYPE_ID");

						if(id==prev)
						{
							prev=id;
						}
						else
						{
							if(prev!=0)
							{
								InsuranceProduct[] ip=al.toArray(new InsuranceProduct[al.size()]);
								it.setInsuranceProducts(ip);
								al.clear();
								insuranceList.add(it);
								it = new InsuranceType();
							}


							it.setId(rs.getInt("INSURANCE_TYPE_ID"));
							it.setName(rs.getString("TYPE_NAME"));
							it.setStatus(rs.getString("TYPE_STATUS"));
							prev=id;
						}

						InsuranceProduct insuranceProduct = new InsuranceProduct();
						insuranceProduct.setId(rs.getInt("PRODUCT_ID"));
						insuranceProduct.setName(rs.getString("PRODUCT_NAME")); 
						al.add(insuranceProduct);

					}

					InsuranceProduct[] insuranceProducts=al.toArray(new InsuranceProduct[al.size()]);
					it.setInsuranceProducts(insuranceProducts);
					al.clear();
					insuranceList.add(it);

				}
				catch(SQLException ex)
				{
					ex.printStackTrace();
				}
				
				return insuranceList;
			}
		
		
		
			public int deleteType(int type_id)
			{ int i=0;
				try{
					dbTransaction = new DBTransaction();
					Connection con=null;
					PreparedStatement ps1=null;
					con = dbTransaction.getConnection();
					
				ps1=con.prepareStatement("update insurance_type_dtls set status='Inactive' where id=?");
				ps1.setInt(1,type_id);
				i=ps1.executeUpdate();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				
				return i;
			}


			public InsuranceType autoFillInsuranceType(int typeId) {
				int prev=0;
				ArrayList<InsuranceProduct> al= new ArrayList<InsuranceProduct>();
				InsuranceType it = new InsuranceType();
				Connection con=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
				try{
					dbTransaction = new DBTransaction();
					con=dbTransaction.getConnection();
					ps=con.prepareStatement("select it.id AS TYPE_ID,it.name AS TYPE_NAME,it.status AS TYPE_STATUS,p.name AS PRODUCT_NAME,p.id AS PRODUCT_ID from insurance_type_dtls it JOIN insurance_product_type_mpg ipm ON ipm.insurance_type_id=it.id JOIN product_dtls p ON p.id=ipm.product_id where it.id=? order by it.id"); 
					ps.setInt(1, typeId);
					rs=ps.executeQuery();
					while(rs.next())
					{
						int id=rs.getInt("TYPE_ID");
						if(id==prev)
						{
							prev=id;
						}
						else
						{
							it.setId(rs.getInt("TYPE_ID"));
							it.setName(rs.getString("TYPE_NAME"));
							it.setStatus(rs.getString("TYPE_STATUS"));
							prev=id;
						}
						InsuranceProduct insuranceProduct = new InsuranceProduct();
						insuranceProduct.setId(rs.getInt("PRODUCT_ID"));
						insuranceProduct.setName(rs.getString("PRODUCT_NAME"));
						al.add(insuranceProduct);
					}
					InsuranceProduct[] insuranceProduct=al.toArray(new InsuranceProduct[al.size()]);
					it.setInsuranceProducts(insuranceProduct);
					al.clear();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				
				return it;
			}


			public int updateProduct(InsuranceType insuranceType, int updatedBy) {
				Connection con=null;
				ResultSet rs=null;
				PreparedStatement ps=null;
				PreparedStatement ps2=null;
				PreparedStatement ps3=null;
				int i=0;
				try{
					dbTransaction = new DBTransaction();
					con=dbTransaction.getConnection();
					ps=con.prepareStatement("update insurance_type_dtls set name=?,status=?,updt_user=?,updt_date=? where id=?");
					ps.setString(1, insuranceType.getName());
					ps.setString(2, insuranceType.getStatus());
					ps.setInt(3, 4);
					Calendar calendar = Calendar.getInstance();
					java.util.Date now = calendar.getTime();
					java.sql.Date currentDate = new java.sql.Date(now.getTime());
					ps.setDate(4,currentDate);
					ps.setInt(5,insuranceType.getId());

					i=ps.executeUpdate();

					if(i==1)
					{
						ps3=con.prepareStatement("delete from insurance_product_type_mpg where INSURANCE_TYPE_ID=?");
						ps3.setInt(1,insuranceType.getId() );
						ps3.executeQuery();
					
						for(int var=0;var<insuranceType.getInsuranceProducts().length;var++)
						{
							ps2 = con.prepareStatement("insert into insurance_product_type_mpg values(sequence_product_type_mpg.nextval,?,?,?,sysdate,?,sysdate)");
							ps2.setInt(1,insuranceType.getInsuranceProducts()[var].getId());
							ps2.setInt(2, insuranceType.getId());
							ps2.setInt(3, 23);
							ps2.setInt(4, 23);
							ps2.execute();
						}
					}

				}catch(SQLException e)

				{
					e.printStackTrace();
				}
				
				return i;
			}
			
			
			//end by harichandna for insurance type
		
		
}
