package org.partycypacja.jsfkoop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "member.all", query = "Select p from KoopMember p"),
	@NamedQuery(name = "member.log", query = "Select p from KoopMember p where p.login = login"),
	@NamedQuery(name = "member.upd", query = "Update KoopMember p SET p.login = :login, p.nazwisko= :nazwisko, p.mail= :mail, p.telefon= :telefon WHERE p.id= :id" ),
	@NamedQuery(name = "member.pass", query = "Update KoopMember p SET p.passwd = :pass WHERE p.id = :id")
})
public class KoopMember {
	private int id;
	private String login;
	private String passwd;
	private String nazwisko;
	private String mail;
	private String telefon;
	private int admin;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	
	
	
}
