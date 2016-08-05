package org.uqbar.edu.paiu.examples.celulares.ui.arena.runnable;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.edu.paiu.examples.celulares.ui.arena.BuscarCelularesWindow;

import ar.edu.celulares.domain.Celular;
import ar.edu.celulares.domain.ModeloCelular;
import ar.edu.celulares.repo.RepositorioCelulares;
import ar.edu.celulares.repo.RepositorioModelos;

/**
 * Correr esta clase con el siguiente argument
 * 
 * -Djava.system.class.loader=com.uqbar.apo.APOClassLoader
 */
public class CelularApplication extends Application {

	public static void main(String[] args) {
		new CelularApplication().start();
	}

	@Override
	protected Window<?> createMainWindow() {
		ApplicationContext.getInstance().configureSingleton(ModeloCelular.class, new RepositorioModelos());
		ApplicationContext.getInstance().configureSingleton(Celular.class, new RepositorioCelulares());		
		return new BuscarCelularesWindow(this);
	}
	
}
