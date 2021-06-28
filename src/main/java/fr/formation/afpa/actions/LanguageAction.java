package fr.formation.afpa.actions;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

public class LanguageAction extends ActionSupport implements SessionAware {

	@Override
	public String execute() throws Exception {
		return SUCCESS;

	}

	public String displayList() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("compte") == null) {
			return "login";
		} else {
			return "input";
		}
	}
	public String displayLogin() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("compte") == null) {
			return "login";
		} else {
			return "input";
		}
	}
	public String displayEdit() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("compte") == null) {
			return "login";
		} else {
			return "input";
		}
	}
	public String displayAdd() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("compte") == null) {
			return "login";
		} else {
			return "input";
		}
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub

	}

}