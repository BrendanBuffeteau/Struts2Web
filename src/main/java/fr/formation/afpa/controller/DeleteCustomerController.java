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
public class DeleteCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service = new CustomerService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteCustomerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession ses = request.getSession(false);
		Integer id = (Integer) ses.getAttribute("custtodeleteid");

		for (int i = 0; i < 20; i++) {
			System.out.println("DELETE CUSTOMER GET : " + id);
		}

		Customer custToDelete = service.findById(id);

		request.setAttribute("deletecustomer", custToDelete);

		request.getRequestDispatcher("/pages/DeleteCustomer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession ses = request.getSession(false);
		Integer custId;

		if (ses.getAttribute("custtodeleteid") != null) {
			custId = (Integer) ses.getAttribute("custtodeleteid");
			for (int i = 0; i < 20; i++) {
				System.out.println("DELETE CUSTOMER POST : " + custId);
			}

			if (null != request.getParameter("confirmdelete")) {
				request.getParameter("custId");
				service.deleteById(custId);
			}

		} else {
			String deleteid = request.getParameter("custidmodal");
			custId = Integer.parseInt(deleteid);

			for (int i = 0; i < 20; i++) {
				System.out.println("DELETE CUSTOMER POST : " + custId);
			}

			if (null != request.getParameter("deletemodalbtn")) {
				service.deleteById(custId);
			}
		}
		response.sendRedirect(request.getContextPath() + "/listecustomer");
	}
}
