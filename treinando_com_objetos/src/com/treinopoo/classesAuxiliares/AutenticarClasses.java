package com.treinopoo.classesAuxiliares;

import com.treinopoo.interfaces.PermitirAcesso;

public class AutenticarClasses {
	
	PermitirAcesso permitirAcesso;
	
	public boolean autenticar() {
		
		return permitirAcesso.Autenticar();
	}
	
	public AutenticarClasses(PermitirAcesso permitirAcesso) {
		this.permitirAcesso = permitirAcesso;
	}
}
