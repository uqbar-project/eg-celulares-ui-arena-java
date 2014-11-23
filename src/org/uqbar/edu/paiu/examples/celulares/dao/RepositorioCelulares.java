package org.uqbar.edu.paiu.examples.celulares.dao;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;
import org.uqbar.edu.paiu.examples.celulares.domain.Celular;

/**
 * 
 * @author npasserini
 */
@Observable
public class RepositorioCelulares {
	private static RepositorioCelulares instance = new RepositorioCelulares();
	private List<Celular> data = new ArrayList<Celular>();

	public static RepositorioCelulares repositorioCelulares() {
		return instance;
	}
	
	private RepositorioCelulares() {}

	// ********************************************************
	// ** Altas y bajas
	// ********************************************************

	public void create(Celular celular) {
		celular.validar();
		this.validarClientesDuplicados(celular);

		celular.setId(this.data.size() + 1);
		this.data.add(celular);
	}

	public void delete(Celular celular) {
		this.data.remove(celular);
	}

	protected void validarClientesDuplicados(Celular celular) {
		if (!this.search(celular.getNumero()).isEmpty()) {
			throw new UserException("Ya existe un celular con el número: " + celular.getNumero());
		}
	}

	// ********************************************************
	// ** Búsquedas
	// ********************************************************

	public List<Celular> search(Integer numero) {
		return this.search(numero, null);
	}

	/**
	 * Busca los celulares que coincidan con los datos recibidos. Tanto número como nombre pueden ser nulos,
	 * en ese caso no se filtra por ese atributo.
	 * 
	 * Soporta búsquedas por substring, por ejemplo el celular (12345, "Juan Gonzalez") será contemplado por
	 * la búsqueda (23, "Gonza")
	 */
	public List<Celular> search(Integer numero, String nombre) {
	   return data
	         .stream()
	         .filter(c -> match(numero, c.getNumero()) && match(nombre, c.getNombre()))
	         .collect(toList());
	}

	protected boolean match(Object expectedValue, Object realValue) {
		return expectedValue == null
			|| realValue.toString().toLowerCase().contains(expectedValue.toString().toLowerCase());
	}
	
	/**
	 * Para el proyecto web - se mantiene la busqueda por Identificador
	 */
	public Celular searchById(int id) {
	   return data.stream().filter(c -> c.getId().equals(id)).findAny().orElse(null);
	}

}
