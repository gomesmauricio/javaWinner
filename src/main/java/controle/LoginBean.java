package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entidade.Usuario;

@ManagedBean(name = "LoginBean")
@SessionScoped
public class LoginBean {

	private String email, senha;
	private Usuario usuario;
	private List<Usuario> listaUsuario;

	private static final String EMAIL_PADRAO = "fuctura";
	private static final String SENHA_PADRAO = "fuctura";
	
	public LoginBean() {
		this.listaUsuario = new ArrayList<Usuario>();
		this.usuario = new Usuario();
	}

	public String entrar() {
		
		if(this.email.equalsIgnoreCase(EMAIL_PADRAO) && 
			this.senha.equalsIgnoreCase(SENHA_PADRAO)) {
			return "/telaPrincipal.xhtml?faces-redirect=true&amp;includeViewParams=true";
		}else {
			for (Usuario us : listaUsuario) {
				if(us.getEmail().equalsIgnoreCase(email) && 
					us.getSenha().equalsIgnoreCase(senha)) {
					return "/telaPrincipal.xhtml?faces-redirect=true&amp;includeViewParams=true";
				}
			}
		}
		
		FacesContext.getCurrentInstance().
        	addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Email/Senha incorretos!!!"));
		
		return "";
	}

	public void criarUsuario() {
		this.listaUsuario.add(usuario);
		this.usuario = new Usuario();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
}
