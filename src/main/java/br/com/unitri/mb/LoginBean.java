package br.com.unitri.mb;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


@ManagedBean
@RequestScoped
public class LoginBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String usuario = "";
	private String senha = "";
	
	public LoginBean() {
	}
	
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
}
