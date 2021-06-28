package fr.formation.afpa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.formation.afpa.domain.Customer;
import fr.formation.afpa.service.CustomerService;

/**
 * Servlet implementation class AjoutController
 */
public class UpdateCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service = new CustomerService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCustomerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession ses = request.getSession(false);
			Integer id = (Integer) ses.getAttribute("custtoupdateid");
			
			for (int i=0;i<20;i++) {
				System.out.println("UPDATE CUSTOMER GET : "+id);
			}
			
			Customer custToUpdate = service.findById(id);
			
			request.setAttribute("updatecustomer", custToUpdate);
			
			request.getRequestDispatcher("/pages/UpdateCustomer.jsp").forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Entrée DO GET UpdateCustomerController");
		HttpSession ses = request.getSession(false);

		String custIdstring = request.getParameter("custId");
		System.out.println(custIdstring);
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

		Integer custId = (Integer) ses.getAttribute("custtoupdateid");
		
		Customer custToUpdate = service.findById(custId);
		
		custToUpdate.setAddress(address);
		custToUpdate.setCity(city);
		custToUpdate.setState(state);
		custToUpdate.setCustTypeCd(custTypeCd);
		custToUpdate.setFedId(fedId);
		
		service.saveOrUpdate(custToUpdate);
		
		response.sendRedirect(request.getContextPath()+"/listecustomer");

	}
}
