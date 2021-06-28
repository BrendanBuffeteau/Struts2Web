package fr.formation.afpa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.formation.afpa.domain.Customer;
import fr.formation.afpa.service.CustomerService;

/**
 * Servlet implementation class ListCustomer
 */

public class ListeCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service = new CustomerService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListeCustomerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int indexpage = 1;

		int customerParPage = 6;

		if (request.getParameter("page") != null) {
			indexpage = Integer.parseInt(request.getParameter("page"));
		}

		//List<Customer> list = service.findForTable((indexpage - 1) * customerParPage, customerParPage);
		List<Customer> listtotal = service.findAll();
		int noOfRecords = listtotal.size();

		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / customerParPage);
		request.setAttribute("noOfPages", noOfPages);
		request.setAttribute("currentPage", indexpage);
		//request.setAttribute("customers", list);

		request.getRequestDispatcher("pages/ListeCustomers.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession ses = request.getSession(false);
		String stringid;
		Integer id = null;
		if (null != request.getParameter("update")) {
			stringid = request.getParameter("custid");
			id = Integer.parseInt(stringid);
			for (int i = 0; i < 20; i++) {
				System.out.println("LISTE CUSTOMER POST : " + id);
			}

			ses.setAttribute("custtoupdateid", id);
			response.sendRedirect(request.getContextPath() + "/updatecustomer");
		}

		else if (null != request.getParameter("delete")) {
			stringid = request.getParameter("custid");
			id = Integer.parseInt(stringid);

			for (int i = 0; i < 20; i++) {
				System.out.println("DELETE CUSTOMER POST : " + stringid);
			}

				service.deleteById(id);

		
			
			response.sendRedirect(request.getContextPath() + "/listecustomer");
		}
	}
}
