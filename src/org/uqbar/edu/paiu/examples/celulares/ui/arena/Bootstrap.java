package org.uqbar.edu.paiu.examples.celulares.ui.arena;

import org.uqbar.edu.paiu.examples.celulares.dao.RepositorioCelulares;
import org.uqbar.edu.paiu.examples.celulares.dao.RepositorioModelos;
import org.uqbar.edu.paiu.examples.celulares.domain.Celular;
import org.uqbar.edu.paiu.examples.celulares.domain.ModeloCelular;

public class Bootstrap {

   public static void setup() {
      setupModelos();
      setupCelulares();
   }

   private static void setupModelos() {
      RepositorioModelos.getInstance().create(
            new ModeloCelular("NOKIA 1100", 150, true));
      RepositorioModelos.getInstance().create(
            new ModeloCelular("Motorola M90", 350, true));
      RepositorioModelos.getInstance().create(
            new ModeloCelular("Samsung Galaxy SII", 440));
   }

   private static void setupCelulares() {
      RepositorioCelulares.getInstance().create(
            new Celular("Natalia", 1588022202, RepositorioModelos.getInstance()
                  .get("NOKIA 1100"), false));
      RepositorioCelulares.getInstance().create(
            new Celular("Bernardo", 1566378124, RepositorioModelos
                  .getInstance().get("Motorola M90"), true));
      RepositorioCelulares.getInstance().create(
            new Celular("Adalberto", 1569575222, RepositorioModelos
                  .getInstance().get("Samsung Galaxy SII"), true));
   }

}
