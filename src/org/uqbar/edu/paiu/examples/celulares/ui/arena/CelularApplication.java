package org.uqbar.edu.paiu.examples.celulares.ui.arena;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

/**
 * Correr esta clase con el siguiente argument
 * 
 * -Djava.system.class.loader=com.uqbar.apo.APOClassLoader
 */
public class CelularApplication extends Application {

	public static void main(String[] args) {
	   Bootstrap.setup();
		new CelularApplication().start();
	}

	@Override
	protected Window<?> createMainWindow() {
		return new BuscarCelularesWindow(this);
	}
	
}
