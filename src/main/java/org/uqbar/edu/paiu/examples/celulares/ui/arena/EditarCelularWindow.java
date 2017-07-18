package org.uqbar.edu.paiu.examples.celulares.ui.arena;

import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.applicationContext.ApplicationContext;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

import ar.edu.celulares.domain.Celular;
import ar.edu.celulares.domain.ModeloCelular;
import ar.edu.celulares.repo.RepositorioCelulares;
import ar.edu.celulares.repo.RepositorioModelos;


public class EditarCelularWindow extends TransactionalDialog<Celular> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EditarCelularWindow(WindowOwner owner, Celular model) {
		super(owner, model);
		this.setTitle("Editar Celulares");
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(2));

		new Label(form).setText("Número");
		new TextBox(form).setWidth(150).bindValueToProperty("numero");

		new Label(form).setText("Nombre del cliente");
		new TextBox(form).setWidth(250).bindValueToProperty("nombre");

		new Label(form).setText("Modelo del aparato");
		
		Selector<ModeloCelular> selector = new Selector<ModeloCelular>(form) //
			.allowNull(false);
		selector.setWidth(150);
		selector.bindValueToProperty("modeloCelular");

		Binding<ModeloCelular, Selector<ModeloCelular>, ListBuilder<ModeloCelular>> itemsBinding = selector.bindItems( //
			new ObservableProperty<ModeloCelular>(repositorioModelos(), "modelos"));

		itemsBinding.setAdapter( //
			new PropertyAdapter(ModeloCelular.class, "descripcionEntera"));
		
		new Label(form).setText("Recibe resumen cuenta en domicilio");
		CheckBox chkRecibe = new CheckBox(form);
		chkRecibe.bindValueToProperty("recibeResumenCuenta");
		chkRecibe.bindEnabledToProperty("habilitaResumenCuenta");

	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions)
			.setCaption("Aceptar")
			.onClick(this::accept)
			.setAsDefault()
			.disableOnError();

		new Button(actions) //
			.setCaption("Cancelar")
			.onClick(this::cancel);
	}

	public RepositorioCelulares getRepoCelulares() {
		return (RepositorioCelulares) ApplicationContext.getInstance().getSingleton(Celular.class);
	}

	public RepositorioModelos repositorioModelos() {
		return (RepositorioModelos) ApplicationContext.getInstance().getSingleton(ModeloCelular.class);
	}

	@Override 
	public void executeTask() {
		Celular modelObject = this.getModelObject();
		if (modelObject.isNew()) {
			getRepoCelulares().create(modelObject);
		} else {
			getRepoCelulares().update(modelObject);
		}
		super.executeTask();
	}
}
