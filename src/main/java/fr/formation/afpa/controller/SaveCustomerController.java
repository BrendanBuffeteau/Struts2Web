package fr.formation.afpa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.afpa.domain.Customer;
import fr.formation.afpa.service.CustomerService;

/**
 * Servlet implementation class ListCustomer
 */

public class SaveCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service = new CustomerService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveCustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("pages/SaveCustomer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Customer custToAdd = new Customer();
		
		String address = request.getParameter("address");
		System.out.println(address);
		String city = request.getParameter("city");
		System.out.println(city);
		String state = request.getParameter("state");
		System.out.println(state);
		String custTypeCd = request.getParameter("custTypeCd");
		System.out.println(custTypeCd);
		String fedId = request.getParameter("fedId");
		System.out.println(fedId);
		
		custToAdd.setAddress(address);
		custToAdd.setCity(city);
		custToAdd.setState(state);
		custToAdd.setCustTypeCd(custTypeCd);
		custToAdd.setFedId(fedId);
		
		service.save(custToAdd);
		
		response.sendRedirect(request.getContextPath()+"/listecustomer");
		
	}

}
