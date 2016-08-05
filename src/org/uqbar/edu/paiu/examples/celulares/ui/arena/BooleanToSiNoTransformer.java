package org.uqbar.edu.paiu.examples.celulares.ui.arena;

import org.apache.commons.collections15.Transformer;

/**
 * Transforma un booleano a un String, devolviendo "SÍ" en caso de ser verdadero y "NO" en caso de ser falso.
 * 
 * @author npasserini
 */
public final class BooleanToSiNoTransformer implements Transformer<Boolean, String> {
	@Override
	public String transform(Boolean recibeResumenCuenta) {
		return recibeResumenCuenta ? "SI" : "NO";
	}
}