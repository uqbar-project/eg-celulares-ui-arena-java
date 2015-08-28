package org.uqbar.edu.paiu.examples.celulares.ui.arena;

import org.apache.commons.collections15.Transformer;
import org.uqbar.edu.paiu.examples.celulares.domain.Celular;

/**
 * Transforma un booleano a un String, devolviendo "SÍ" en caso de ser verdadero y "NO" en caso de ser falso.
 * 
 * @author npasserini
 */
public final class BooleanToSiNoTransformer implements Transformer<Celular, String> {
	@Override
	public String transform(Celular celular) {
		return celular.getRecibeResumenCuenta() ? "SI" : "NO";
	}
}