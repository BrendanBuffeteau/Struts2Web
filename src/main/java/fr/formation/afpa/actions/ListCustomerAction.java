package fr.formation.afpa.actions;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import fr.formation.afpa.domain.Customer;
import fr.formation.afpa.service.CustomerService;

public class ListCustomerAction extends ActionSupport {

	private static final Logger LOG = LogManager.getLogger(ListCustomerAction.class.getName());
	CustomerService service = new CustomerService();
	List<Customer> listecustomers;
	Customer customer;
	HttpSession session = ServletActionContext.getRequest().getSession(false);

	@Override
	public String execute() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("compte") == null) {
			return "login";
		} else {
			return SUCCESS;
		}
	}

	public List<Customer> getCustomers() {

		listecustomers = service.findAll();
		System.out.println("Liste customer chargée");
		return listecustomers;
	}

	public String listCustomers() {
		if (session == null || session.getAttribute("prenom") == null) {
			return "login";
		} else {
			listecustomers = service.findAll();
			System.out.println("Liste customer chargée String");
			return SUCCESS;
		}
	}

	public String changelanguagemeth() {

		return SUCCESS;
	}

	public String save() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("compte") == null) {
			return "login";
		} else {
		customer.setCustId(null);
		System.out.println("SAVE" + customer.toString());
		if (customer.getCustId() == null) {
			service.save(customer);
		} else {
			service.saveOrUpdate(customer);
		}
		return SUCCESS;
		}
	}

	public String findedit() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("compte") == null) {
			return "login";
		} else {
		Integer idtofind = customer.getCustId();
		System.out.println(customer.getCustId());

		customer = service.findById(idtofind);
		System.out.println(customer.toString());

		return SUCCESS;
		}
	}

	public String delete() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("compte") == null) {
			return "login";
		} else {
		Integer idtodelete = customer.getCustId();
		System.out.println("DELETE" + customer.toString());
		if (customer.getCustId() != null) {
			service.deleteById(idtodelete);
		} 
		return SUCCESS;
		}
	}

	public void setListcustomer(List<Customer> listcustomer) {
		this.listecustomers = listcustomer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
