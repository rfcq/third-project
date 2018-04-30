package br.com.iesp.projeto.model;

public class Cliente {
	private int id;
	private String user;
	private String passwd;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public String getUser() {
		return this.user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPasswd() {
		return this.passwd;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	} 
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
