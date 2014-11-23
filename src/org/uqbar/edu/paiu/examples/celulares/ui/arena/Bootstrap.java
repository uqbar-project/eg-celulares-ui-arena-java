package org.uqbar.edu.paiu.examples.celulares.ui.arena;

import static org.uqbar.edu.paiu.examples.celulares.dao.RepositorioCelulares.repositorioCelulares;
import static org.uqbar.edu.paiu.examples.celulares.dao.RepositorioModelos.repositorioModelos;

import org.uqbar.edu.paiu.examples.celulares.domain.Celular;
import org.uqbar.edu.paiu.examples.celulares.domain.ModeloCelular;

public class Bootstrap {

   public static void setup() {
      setupModelos();
      setupCelulares();
   }

   private static void setupModelos() {
      repositorioModelos().create(new ModeloCelular("NOKIA 1100", 150, true));
      repositorioModelos().create(new ModeloCelular("Motorola M90", 350, true));
      repositorioModelos().create(new ModeloCelular("Samsung Galaxy SII", 440));
   }

   private static void setupCelulares() {
      repositorioCelulares().create(
            new Celular("Natalia", 1588022202, repositorioModelos().get("NOKIA 1100"), false));
      repositorioCelulares().create(
            new Celular("Bernardo", 1566378124, repositorioModelos().get("Motorola M90"), true));
      repositorioCelulares().create(
            new Celular("Adalberto", 1569575222, repositorioModelos().get("Samsung Galaxy SII"), true));
   }

}
