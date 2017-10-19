package com.us.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.us.beans.CommonVO;
import com.us.beans.Coverage;
import com.us.beans.InsuranceProduct;
import com.us.beans.InsuranceType;
import com.us.beans.User;
import com.us.service.UserDtlService;

/**
 * Servlet implementation class US_M1_Controller
 */
public class UserDtlController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDtlController() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String actionVal = request.getParameter("action");

		if ("logout".equals(actionVal)) {

			HttpSession httpSession = request.getSession();

			httpSession.removeAttribute("uId");
			httpSession.removeAttribute("uName");
			httpSession.removeAttribute("role");
			httpSession.invalidate();

			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("jsp/login.jsp");
			requestDispatcher.forward(request, response);
			return;
		}

		ArrayList<Coverage> arraylist = new ArrayList<Coverage>();
		if (actionVal.equals("fetchCoverage")) {
			arraylist = UserDtlService.fetchCoverage();
			// session.setAttribute("coverageDetails", arraylist);

			request.setAttribute("arraylist", arraylist);
			// request.setAttribute("temp", temp);
			request.setAttribute("action", actionVal);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("jsp/userdtls/registerProduct.jsp");
			requestDispatcher.forward(request, response);
		}
		
		/* Done by Mini and Deekshit */
		/* start */
		
		else if (actionVal.equals("viewProduct")) {

			UserDtlService us = new UserDtlService();
			ArrayList<InsuranceProduct> productList = us.viewProduct();
			request.setAttribute("productList", productList);
			RequestDispatcher rd = request
					.getRequestDispatcher("jsp/userdtls/viewProduct.jsp");
			rd.forward(request, response);

		} else if (actionVal.equals("autoFill")) {
			int product_id = Integer.parseInt(request
					.getParameter("product_id"));
			UserDtlService us = new UserDtlService();
			InsuranceProduct insuranceProduct = new InsuranceProduct();
			insuranceProduct = us.autoFill(product_id);
			request.setAttribute("insuranceProduct", insuranceProduct);
			arraylist = UserDtlService.fetchCoverage();
			request.setAttribute("arraylist", arraylist);
			String flag = "autoFill";
			request.setAttribute("action", flag);
			RequestDispatcher rd = request
					.getRequestDispatcher("jsp/userdtls/registerProduct.jsp");
			rd.forward(request, response);

		} else if (actionVal.equals("deleteProduct")) {
			int result = 0;
			int product_id = Integer.parseInt(request
					.getParameter("product_id"));
			UserDtlService us = new UserDtlService();
			result = us.deleteProduct(product_id);
			request.setAttribute("product_id", product_id);
			if (result != 0) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('deleted successfully');");
				out.println("location='UserDtlController?action=viewProduct';");
				out.println("</script>");
				
				
				
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('deletion failed');");
				out.println("location='UserDtlController?action=viewProduct';");
				out.println("</script>");
			}
		}

		/* by mini and deekshit. End */

		else if ("viewUsers".equals(actionVal)) {
			UserDtlService userDtlServiceObj = new UserDtlService();
			ArrayList<User> userlist = userDtlServiceObj.displayUsers();

			request.setAttribute("usersList", userlist);

			/*
			 * if(userlist!=null){
			 * k("<script type=\"text/javascript\">");
			 * out.println("location='jsp/userdtls/viewUsers.jsp';");
			 * out.println("</script>"); }
			 */

			RequestDispatcher reqDispatcher = request
					.getRequestDispatcher("jsp/userdtls/viewUsers.jsp");
			reqDispatcher.forward(request, response);

		} else if ("deleteUser".equals(actionVal)) {
			int id = Integer.parseInt(request.getParameter("id"));
			UserDtlService userDtlServiceObj = new UserDtlService();
			String custAct = userDtlServiceObj.deleteUser(id);

			request.setAttribute("response", custAct);

			RequestDispatcher reqDispatcher = request
					.getRequestDispatcher("UserDtlController?action=viewUsers");
			reqDispatcher.forward(request, response);

		} else if ("updateUser".equals(actionVal)) {
			int id = Integer.parseInt(request.getParameter("id"));
			UserDtlService userDtlServiceObj = new UserDtlService();
			User user = userDtlServiceObj.updateUser(id);
			request.setAttribute("user", user);
			request.setAttribute("flag", "update");

			RequestDispatcher reqDispatcher = request
					.getRequestDispatcher("jsp/userdtls/createUser.jsp");

			reqDispatcher.forward(request, response);

		} else if (actionVal.equals("showHome")) {

			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("jsp/userdtls/adminHome.jsp");
			requestDispatcher.forward(request, response);
		}
		// --------------coverage
		// starting------------------------------------------

		if ("createCoverage".equals(actionVal)) {
			UserDtlService userDtlService = new UserDtlService();
			HttpSession session = request.getSession();
			// int
			// createdBy=Integer.parseInt((String)session.getAttribute("uName"));
			int createdBy = 209;
			int coverageID = 0;
			RequestDispatcher requestDispatcher = null;
			String coveragename = request.getParameter("coverageName");
			Coverage coverage = new Coverage();
			coverage.setName(coveragename);
			coverageID = userDtlService.createCoverage(coverage, createdBy);
			if (coverageID > 0) {
				out.println("<script type=\"text/javascript\">");
				out.println("location='jsp/userdtls/coverageHome.html';");
				out.println("alert('creation successful');");
				out.println("</script>");
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('creation failed');");
				out.println("location='jsp/userdtls/coverageHome.html';");
				out.println("</script>");
//				requestDispatcher = request
//						.getRequestDispatcher("jsp/userdtls/coverageHome.html");
//				requestDispatcher.forward(request, response);
			}

		}

		if ("coverageCreation".equals(actionVal)) {
			RequestDispatcher requestDispatcher = null;
			requestDispatcher = request
					.getRequestDispatcher("jsp/userdtls/createCoverage.jsp?flag=coverageCreation");
			requestDispatcher.forward(request, response);

		}

		// ----------------View
		// Coverage-----------------------------------------------------------------

		if ("viewCoverage".equals(actionVal)) {
			UserDtlService userDtlService = new UserDtlService();
			ArrayList<Coverage> viewList = new ArrayList<Coverage>();
			RequestDispatcher requestDispatcher = null;

			viewList = userDtlService.ViewCoverageDetails();
			if (viewList.size() > 0) {

				request.setAttribute("ViewCoverageList", viewList);
				requestDispatcher = request
						.getRequestDispatcher("jsp/userdtls/viewCoverage.jsp");
				requestDispatcher.forward(request, response);
			} else {

				out.println("<script type=\"text/javascript\">");
				out.println("alert('view Coverage Error');");
				out.println("location='jsp/userdtls/coverageHome.html';");
				out.println("</script>");
//				requestDispatcher = request
//						.getRequestDispatcher("jsp/userdtls/coverageHome.html");
//				requestDispatcher.forward(request, response);
			}

		}

		// ----------------Update
		// Coverage-----------------------------------------------------------------

		if ("updateCoverage".equals(actionVal)) {
			UserDtlService userDtlService = new UserDtlService();
			RequestDispatcher requestDispatcher = null;
			// int
			// updatedby=Integer.parseInt((String)session.getAttribute("uName"));
			ArrayList<Coverage> updateCoverage = new ArrayList<Coverage>();
			int coverageId = (Integer.parseInt(request
					.getParameter("coverageid")));
			String coveragename = request.getParameter("coverageName");
			String status = request.getParameter("status");
			Coverage coverage = new Coverage();
			coverage.setName(coveragename);
			coverage.setId(coverageId);
			coverage.setStatus(status);
			int updatedby = 209;
			updateCoverage = userDtlService.updateCoverage(coverage, updatedby);
			out.println("<script type=\"text/javascript\">");
			out.println("alert('updation successful');");
			out.println("location='UserDtlController?action=viewCoverage';");
			out.println("</script>");
//			requestDispatcher = request
//					.getRequestDispatcher("UserDtlController?action=viewCoverage");
//			requestDispatcher.forward(request, response);
		}
		if ("coverageUpdation".equals(actionVal)) {
			UserDtlService userDtlService = new UserDtlService();
			RequestDispatcher requestDispatcher = null;
			ArrayList<Coverage> updateCoverage = new ArrayList<Coverage>();
			updateCoverage = userDtlService.fetchupdateCoverage(Integer
					.parseInt(request.getParameter("id")));
			request.setAttribute("updateCoverage", updateCoverage);
			requestDispatcher = request
					.getRequestDispatcher("jsp/userdtls/createCoverage.jsp?flag=coverageUpdation");
			requestDispatcher.forward(request, response);
		}

		// ----------------Delete
		// Coverage-----------------------------------------------------------------

		if ("deleteCoverage".equals(actionVal)) {
			UserDtlService userDtlService = new UserDtlService();
			int deletecount = userDtlService.DeleteCoverage(Integer
					.parseInt(request.getParameter("id")));
			if (deletecount > 0) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('deletion successful');");
				out.println("location='UserDtlController?action=viewCoverage';");
				out.println("</script>");
//				requestDispatcher = request
//						.getRequestDispatcher("jsp/userdtls/coverageHome.html");
//				requestDispatcher.forward(request, response);

			} else {

				out.println("<script type=\"text/javascript\">");
				out.println("alert('Invalid Credentials');");
				out.println("location='UserDtlController?action=viewCoverage';");
				out.println("</script>");
//				requestDispatcher = request
//						.getRequestDispatcher("jsp/userdtls/coverageHome.html");
//				requestDispatcher.forward(request, response);
			}

		}

		// start by harichandna for insurance type

		else if ("fetchingProductDetails".equals(actionVal)) {
			try {
				ArrayList<InsuranceProduct> productList = new ArrayList<InsuranceProduct>();
				productList = UserDtlService.fetchInsuranceProduct();
				request.setAttribute("productList", productList);
				String flag = "fetchingProductDetails";
				request.setAttribute("action", flag);
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("jsp/userdtls/registrationInsuranceType.jsp");
				requestDispatcher.forward(request, response);
			} catch (Exception e) {

				System.out.println(e);
			}
		}

		else if (actionVal.equals("autoFillInsuranceType")) {

			ArrayList<InsuranceProduct> productList = new ArrayList<InsuranceProduct>();
			int type_id = Integer.parseInt(request.getParameter("type_id"));
			UserDtlService us = new UserDtlService();
			InsuranceType insuranceType = new InsuranceType();
			insuranceType = us.autoFillInsuranceType(type_id);
			request.setAttribute("insuranceType", insuranceType);
			productList = UserDtlService.fetchInsuranceProduct();
			request.setAttribute("productList", productList);
			String flag = "autoFill";
			request.setAttribute("action", flag);
			RequestDispatcher rd = request
					.getRequestDispatcher("jsp/userdtls/registrationInsuranceType.jsp");
			rd.forward(request, response);

		} else if ("viewInsuranceType".equals(actionVal)) {
			UserDtlService us = new UserDtlService();
			ArrayList<InsuranceType> typelist = us.viewType();
			request.setAttribute("typelist", typelist);
			RequestDispatcher rd = request
					.getRequestDispatcher("jsp/userdtls/viewInsuranceType.jsp");
			rd.forward(request, response);

		} else if ("deleteType".equals(actionVal)) {
			int result = 0;
			int type_id = Integer.parseInt(request.getParameter("type_id"));
			UserDtlService us = new UserDtlService();
			result = us.deleteType(type_id);
			if (result != 0) {

				out.println("<script type=\"text/javascript\">");
				out.println("alert('deleted successfully');");
				out.println("location='UserDtlController?action=viewInsuranceType';");
				out.println("</script>");
			}
				
			// request.setAttribute("type_id", type_id);
			// RequestDispatcher
			// rd=request.getRequestDispatcher("deleteInsuranceType.jsp");
			// rd.include(request, response);
		}

		// end by harichandna for insurance type

		else if(actionVal.equalsIgnoreCase("showhome")){
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/userdtls/adminHome.jsp");
			requestDispatcher.forward(request, response);
		}
		// ---------------coverage
		// ended------------------------------------------------------
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String actionVal = request.getParameter("action");
		UserDtlService userDtlService = new UserDtlService();

		if ("login".equals(actionVal)) {

			System.out.println("Inside Login");
			
			User user = getLoginDetails(request, response);

			user = userDtlService.getUserDetails(user.getUserName(),
					user.getRole(), user.getPassword());

			RequestDispatcher requestDispatcher = null;

			if (user != null) {

				HttpSession httpSession = request.getSession(true);

				httpSession.setAttribute("uName", user.getUserName());
				httpSession.setAttribute("role", user.getRole());
				httpSession.setAttribute("uId", user.getUserId());

				if (user.getRole().equalsIgnoreCase("admin")) {
					requestDispatcher = request
							.getRequestDispatcher("jsp/userdtls/adminHome.jsp");
				} else if (user.getRole().equalsIgnoreCase("underwriter")) {
					requestDispatcher = request
							.getRequestDispatcher("jsp/userdtls/underwriterHome.jsp");
				} else if (user.getRole().equalsIgnoreCase("manager")) {
					requestDispatcher = request
							.getRequestDispatcher("jsp/userdtls/managerHome.jsp");
				}
//				requestDispatcher.forward(request, response);
			} else {
				
				request.setAttribute("invalid", "");
				requestDispatcher = request
						.getRequestDispatcher("jsp/login.jsp");
			}
			requestDispatcher.forward(request, response);
		} else if (actionVal.equals("createProduct")) {

			// int createdBy=(int)session.getAttribute("createdBy");
			int createdBy = 0;
			int updatedBy = 0;

			// int updatedBy=(int)session.getAttribute("updatedBy");
			String productName = request.getParameter("productName");
			String[] coverages = request.getParameterValues("coverage");

			ArrayList<Coverage> coverageList = new ArrayList<>();

			for (String coverage : coverages) {

				coverageList.add(new Coverage(Integer.parseInt(coverage), "",
						"active"));

			}

			String status = "active";
			InsuranceProduct product = new InsuranceProduct();
			product.setName(productName);
			product.setCoverage(coverageList.toArray(new Coverage[coverageList
					.size()]));
			product.setStatus(status);
			int i = UserDtlService.addProduct(product, createdBy, updatedBy);

			if (i != 0) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('insertion successfull');");
				out.println("location='jsp/userdtls/insuranceProductHome.jsp';");
				out.println("</script>");
			}
		}

		else if (actionVal.equals("updateProduct")) {

			int productId = Integer.parseInt(request.getParameter("productId"));
			int updatedBy = 0;
			// int updatedBy=(int)session.getAttribute("updatedBy");
			String productName = request.getParameter("productName");
			String[] coverages = request.getParameterValues("coverage");
			String status = request.getParameter("status");

			ArrayList<Coverage> coverageList = new ArrayList<>();

			for (String coverage : coverages) {

				coverageList.add(new Coverage(Integer.parseInt(coverage), "",
						"active"));

			}

			InsuranceProduct product = new InsuranceProduct();
			product.setId(productId);
			product.setName(productName);
			product.setStatus(status);
			product.setCoverage(coverageList.toArray(new Coverage[coverageList
					.size()]));

			int i = UserDtlService.updateProduct(product, updatedBy);

			if (i != 0) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('updated successfully');");
				out.println("location='UserDtlController?action=viewProduct';");
				out.println("</script>");
			}
		}

		/* by manikrishna start */

		if ("createUser".equals(actionVal)) {

			HttpSession httpSession = request.getSession();
			String uName = httpSession.getAttribute("uName").toString();
			int uId = Integer.parseInt(httpSession.getAttribute("uId")
					.toString());
			
			RequestDispatcher requestDispatcher = null;

			if (uId != 0 && uName != null) {

				String userName, password, role, userStatus;
				try {
					
					userName = request.getParameter("name");
					password = request.getParameter("pwd");
					role = request.getParameter("role");
					userStatus = request.getParameter("status");

					User user = new User();
					user.setUserId(1);
					user.setUserName(userName);
					user.setPassword(password);
					user.setRole(role);
					user.setUserStatus(userStatus);

					UserDtlService userDtlServiceobj = new UserDtlService();

					int userId = userDtlServiceobj.createUser(user);
					request.setAttribute("userId", userId);

					if (userId != 0) {

						out.println("<script type=\"text/javascript\">");
						out.println("alert('insertion successfull');");
						out.println("location='jsp/userdtls/userHome.jsp';");
						out.println("</script>");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {

				requestDispatcher = request
						.getRequestDispatcher("jsp/login.jsp");
				requestDispatcher.forward(request, response);
			}

		} else if ("updatedUser".equals(actionVal)) {
			String userName, password, role, userStatus;
			try {

				userName = request.getParameter("name");
				password = request.getParameter("pwd");
				role = request.getParameter("role");
				userStatus = request.getParameter("status");
				
				User user = new User();
				user.setUserId(Integer.parseInt(request.getParameter("userId")));
				user.setUserName(userName);
				user.setPassword(password);
				user.setRole(role);
				user.setUserStatus(userStatus);

				UserDtlService userDtlServiceobj = new UserDtlService();

				int custAct = userDtlServiceobj.updatedUser(user);

				if (custAct != 0) {

					out.println("<script type=\"text/javascript\">");
					out.println("alert('updated successfully');");
					 out.println("location='UserDtlController?action=viewUsers';");
					out.println("</script>");
				}

				/*
				 * request.setAttribute("uId", custAct); RequestDispatcher
				 * reqDispatcher = request
				 * .getRequestDispatcher("jsp/userdtls/userHome.jsp");
				 * reqDispatcher.forward(request, response);
				 */

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// start by harichandna for insurance type
		ArrayList<InsuranceProduct> productList = new ArrayList<InsuranceProduct>();

		if ("createInsuranceType".equals(actionVal)) {
			// int createdBy=Integer.parseInt((String)
			// session.getAttribute("createdBy"));
			// int updatedBy=Integer.parseInt((String)
			// session.getAttribute("updatedBy"));
			String typeName = request.getParameter("insuranceTypeName");
			String[] insuranceproducts = request.getParameterValues("product");

			for (String insurancetype : insuranceproducts) {

				productList.add(new InsuranceProduct(Integer
						.parseInt(insurancetype), "", "Active", null));
			}
			String status = "Active";
			InsuranceType type = new InsuranceType();
			type.setName(typeName);
			type.setInsuranceProducts((productList
					.toArray(new InsuranceProduct[productList.size()])));
			type.setStatus(status);
			int i = UserDtlService.addinsuranceType(type, 2, 2);

			if (i != 0) {

				out.println("<script type=\"text/javascript\">");
				out.println("alert('created successfully');");
				out.println("location='jsp/userdtls/insuranceTypeHome.html';");
				out.println("</script>");
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('created failed!!');");
				out.println("location='jsp/userdtls/insuranceTypeHome.html';");
				out.println("</script>");
			}

			request.setAttribute("i", i);
		} else if (actionVal.equals("updateInsuranceType")) {

			// int typeId=Integer.parseInt(request.getParameter("type_id"));
			int updatedBy = 0;
			// int updatedBy=(int)session.getAttribute("updatedBy");
			// String
			// insuranceTypeName=request.getParameter("insuranceTypeName");
			String[] products = request.getParameterValues("product");
			String status = request.getParameter("status");

			for (String insuranceProduct : products) {

				productList.add(new InsuranceProduct(Integer
						.parseInt(insuranceProduct), "", "Active", null));

			}

			InsuranceType insuranceType = new InsuranceType();
			insuranceType.setId(Integer.parseInt(request
					.getParameter("type_id")));
			insuranceType.setName(request.getParameter("insuranceTypeName"));
			insuranceType.setStatus(status);
			insuranceType.setInsuranceProducts(productList
					.toArray(new InsuranceProduct[productList.size()]));

			int i = UserDtlService.updateProduct(insuranceType, updatedBy);

			if (i != 0) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('updated successfully');");
				out.println("location='UserDtlController?action=viewInsuranceType';");
				out.println("</script>");
			}
		}
	}

	public User getLoginDetails(HttpServletRequest request,
			HttpServletResponse response) {

		User user = new User();

		String uName = request.getParameter("uname");
		String password = request.getParameter("password");
		String role = request.getParameter("role");

		user.setUserName(uName);
		user.setRole(role);
		user.setPassword(password);

		return user;
	}

	public CommonVO prepareCommonVo(HttpServletRequest request,
			HttpServletResponse response) {

		CommonVO commonVO = null;

		HttpSession httpSession = request.getSession();

		int uId = Integer.parseInt(httpSession.getAttribute("uId").toString());

		if (httpSession != null) {

			commonVO = new CommonVO();
			commonVO.setCrtUser(uId);
			commonVO.setCrtDate(new Date());
			commonVO.setUpdtUser(uId);
			commonVO.setUpdtDate(new Date());

		}
		return commonVO;
	}
}
