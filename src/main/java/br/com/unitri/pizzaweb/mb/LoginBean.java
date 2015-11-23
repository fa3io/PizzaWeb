package br.com.unitri.pizzaweb.mb;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.unitri.pizzaweb.dao.ClienteDAO;
import br.com.unitri.pizzaweb.entity.Cliente;



@RequestScoped
@Named
public class LoginBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String usuario = "";
	private String senha = "";
	
	Cliente usuariologin = new Cliente();
	
	@Inject
	ClienteDAO clienteDAO;
	
	public LoginBean() {
	}
	/*
	public void logar(){
		try {
			if(usuario.equals("fabio") && senha.equals("123")){
				FacesContext.getCurrentInstance().getExternalContext().redirect("menu.jsf");
			}else{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario ou senha Invalido", "Erro"));
			}
				
		} catch (IOException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao efetuar login", "Erro"));
		}
	}
	*/
	public String logar(){
		 usuariologin  = clienteDAO.getByLogin(usuario, senha);
		if(usuariologin != null){
			FacesContext fc = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
			session.setAttribute("cliente", usuariologin);
			return "menu.jsf"; 
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario ou senha Invalido", "Erro"));
		}
		return null;
	}
	
	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the usuariologin
	 */
	public Cliente getUsuariologin() {
		return usuariologin;
	}

	/**
	 * @param usuariologin the usuariologin to set
	 */
	public void setUsuariologin(Cliente usuariologin) {
		this.usuariologin = usuariologin;
	}
	
	
}
