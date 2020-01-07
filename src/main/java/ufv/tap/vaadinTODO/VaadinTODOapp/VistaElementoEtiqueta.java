package ufv.tap.vaadinTODO.VaadinTODOapp;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class VistaElementoEtiqueta {

	private HorizontalLayout layout;
	private Icon icono;
	private Label nombre;
	
	public VistaElementoEtiqueta(Etiqueta e) {
		
		crearVista(e);
		
	}

	private void crearVista(Etiqueta e) {
		
		layout = new HorizontalLayout();
		icono = new Icon(VaadinIcon.TAG);
		icono.setSize("20px");
		icono.getStyle().set("transform", "rotate(135deg)");
		icono.setColor("lightgray");
		nombre = new Label(e.getNombre());
		
		layout.add(icono, nombre);
		layout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
		
	}
	
	public HorizontalLayout getLayout() {
		return layout;
	}
	
	public Icon getIcono() {
		return icono;
	}

	public Label getNombre() {
		return nombre;
	}
}
