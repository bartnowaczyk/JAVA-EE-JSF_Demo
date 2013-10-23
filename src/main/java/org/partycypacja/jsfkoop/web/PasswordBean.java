package org.partycypacja.jsfkoop.web;  

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.partycypacja.jsfkoop.domain.KoopMember;
import org.partycypacja.jsfkoop.service.KoopMemberManager;
  
@SessionScoped
@Named("passBean") 
public class PasswordBean implements Serializable {  
  
		
	private static final long serialVersionUID = 1L;
		private FacesContext fc = FacesContext.getCurrentInstance();
		private HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
		private KoopMember member = (KoopMember) session.getAttribute("user");
	
	   private String password = "llll";  
	   
	   @Inject
	   KoopMemberManager km;
	   
	   public String getPassword() {  
	        return password;  
	    }  
	  
	    public void setPassword(String password) {  
	        this.password = password;  
	    }  
	  

	    public String change (ActionEvent actionEvent) {  
	    	km.changePass(member);
	    	
	        FacesContext context = FacesContext.getCurrentInstance();  
	        context.addMessage(null, new FacesMessage("Hasło zmienione!"));  
	    	return null;
	    }

		public KoopMember getMember() {
			return member;
		}

		public void setMember(KoopMember member) {
			this.member = member;
		}  
	    
	    
	}  