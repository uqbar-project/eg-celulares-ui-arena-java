package org.uqbar.edu.paiu.examples.celulares.ui.arena;

import org.uqbar.arena.windows.WindowOwner;

import ar.edu.celulares.domain.Celular;

public class CrearCelularWindow extends EditarCelularWindow {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CrearCelularWindow(WindowOwner owner) {
		super(owner, new Celular());
		this.setTitle("agregar un nuevo Celular");
	}

}
