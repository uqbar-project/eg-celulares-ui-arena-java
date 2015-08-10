package org.uqbar.edu.paiu.examples.celulares.ui.arena;

import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.edu.paiu.examples.celulares.domain.Celular;
import org.uqbar.edu.paiu.examples.celulares.home.RepositorioCelulares;

public class CrearCelularWindow extends EditarCelularWindow {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CrearCelularWindow(WindowOwner owner) {
		super(owner, new Celular());
		this.setTitle("agregar un nuevo Celular");
	}

	@Override
	protected void executeTask() {
		RepositorioCelulares.repositorioCelulares().create(this.getModelObject());
		super.executeTask();
	}
	
}
