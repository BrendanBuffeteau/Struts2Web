package fr.formation.afpa.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import fr.formation.afpa.domain.Compte;
import fr.formation.afpa.service.CompteService;


/*

Nom du projet Struts2Web

authentification session - mdp bdd
pages doivent respecter la présentation
responsive

Header menu

Menu 
à gauche Accueil
Liste Customer
Ajouter Customer
Contact lien mail
Qui sommes nous ?
Menu à droite logout

CONTENU

footer

Boutons Anglais / français

Url érronée : nomduprojet/abc
> afficher liste si login
> afficher login si loggedout

 */

public class LoginAction extends ActionSupport implements SessionAware  {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1991276273097457111L;
	private static final Logger LOG = LogManager.getLogger(LoginAction.class.getName());
	private Map<String, Object> session;
	private CompteService service;
	private Compte compte;



	@Override
	public String execute() throws Exception {

		//System.out.println("compte page"+compte.toString());
		
		
//		Compte newcpt = null;
//		
//		try {
//			newcpt = service.findByLogingAndPassword(compte.getLogin(), compte.getPassword());
//		}catch(Exception e){
//			System.out.println("catch");
//		}
//		
//		System.out.println(newcpt.toString());
		
//		
//		if (compte.getLogin().equals(newcpt.getLogin()) 
//				&& 
//				compte.getPassword().equals(newcpt.getPassword())
//						)
		
		if (compte.getLogin().equals("loblake") && compte.getPassword().equals("123456")) {
			
			if (session == null) System.out.println("Session null");
			
			session.put("compte", compte);
			
			return SUCCESS;
		}
		else
			return "loginfail";
	}
	
	public String changelanguagemeth() {

		return SUCCESS;
	}
	
    public String logout() {
    	session = ActionContext.getContext().getSession();
    	if (session.get("compte")!= null)  	session.remove("compte");
        return SUCCESS;
    }

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	
}