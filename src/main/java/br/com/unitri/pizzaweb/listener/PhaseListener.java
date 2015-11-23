package br.com.unitri.pizzaweb.listener;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.servlet.http.HttpSession;

import br.com.unitri.pizzaweb.entity.Cliente;
import br.com.unitri.pizzaweb.mb.LoginBean;


public class PhaseListener implements javax.faces.event.PhaseListener {

	private static final long serialVersionUID = 1L;

	@Override
    public void beforePhase(PhaseEvent event) {
    }

    @Override
    public void afterPhase(PhaseEvent event) {
        if ("/login.xhtml".equals(FacesContext.getCurrentInstance().getViewRoot().getViewId())) {
            return;
        }
        LoginBean usuarioBean = (LoginBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean");
        Cliente usuarioLogado = getUsuarioSessao();
        if (usuarioBean != null) {
            usuarioLogado = usuarioBean.getUsuariologin();
        }
        if (usuarioLogado == null) {
            FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(),null, "login?faces-redirect=true");
            FacesContext.getCurrentInstance().renderResponse();
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
    private Cliente getUsuarioSessao() {
		Cliente cliente = null;

		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		cliente = (Cliente) session.getAttribute("cliente");
		
		return cliente;
	}
}
