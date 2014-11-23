package org.uqbar.edu.paiu.examples.celulares.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;
import org.uqbar.edu.paiu.examples.celulares.domain.ModeloCelular;

@SuppressWarnings("serial")
@Observable
public class RepositorioModelos implements Serializable {
	private static RepositorioModelos instance = new RepositorioModelos();
	private List<ModeloCelular> data = new ArrayList<ModeloCelular>();

	public static RepositorioModelos getInstance() {
		return instance;
	}

	private RepositorioModelos() {}

	public void create(ModeloCelular modelo) {
		this.data.add(modelo);
	}

   public ModeloCelular get(String descripcion) {
      return this.data
            .stream()
            .filter(m -> m.getDescripcion().equals(descripcion))
            .findAny()
            .orElseThrow(() -> //
                  new UserException("No se encontró el modelo de celular: " + descripcion));
   }

	public List<ModeloCelular> getModelos() {
		return this.data;
	}
	
}
