package fr.formation.afpa.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.formation.afpa.domain.Compte;
import fr.formation.afpa.service.CompteService;


/**
 * Servlet implementation class SessionExample
 */

public class Logincontroller extends HttpServlet {

	@SuppressWarnings("unused")
	/**
	 * 
	 */
	private static final long serialVersionUID = 504817536290109331L;
	CompteService service;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Logincontroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
	  super.init();
	 service = new CompteService();
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
System.out.println("Login Do get");
		request.setAttribute("message", null);
		HttpSession ses = request.getSession(false);
		boolean sesexist;
		if (ses!=null) sesexist=true;
		else sesexist =false;
		for (int i=0;i<20;i++) {
			System.out.println("Session = "+sesexist);
		}
		request.getRequestDispatcher("pages/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession ses = request.getSession(false);
		String m = (String)ses.getAttribute("message");
		System.out.println(m);
		String email = request.getParameter("login");
		String password = request.getParameter("password");
		
		Compte cpt = service.findByLogingAndPassword(email, password);

		if (cpt != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("compte", cpt);
			System.out.println(cpt.getCustomer().getCustId()+" "+cpt.getCustomer().getAddress());
			response.sendRedirect(request.getContextPath()+"/listecustomer");
		}
		else {
			request.setAttribute("message", "Email ou mot de passe incorrect, merci de réessayer.");
			request.getRequestDispatcher("pages/login.jsp").forward(request, response);
		}
	}
}
