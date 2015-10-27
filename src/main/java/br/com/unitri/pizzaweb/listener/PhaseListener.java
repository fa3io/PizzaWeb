package br.com.unitri.pizzaweb.listener;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;

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
        Cliente usuarioLogado = null;
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
}
