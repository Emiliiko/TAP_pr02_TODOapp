package ufv.tap.vaadinTODO.VaadinTODOapp;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent;

import java.util.Date;

public class VistaElementoTarea {
	
	// Elementos Vista
	private HorizontalLayout layout;
	private Checkbox checkbox;
	private Icon prioridad;
	private Label timeLeft;
	private Label titulo;
	
	// Elementos Tarea ocultos
	private int ID;
	private Date fecha;
	private String descripcion;
	private Etiqueta etiqueta;
	
	
	
	public VistaElementoTarea(Tarea tarea) { //, VerticalLayout vl) {
		
		crearVista(tarea); //, vl);
		
	}


	private void crearVista(Tarea tarea) { //, VerticalLayout vl) {
		
		layout = new HorizontalLayout();
		checkbox = new Checkbox();
		if(tarea.isCompletada()) {
			checkbox.setValue(true);
			//VerticalLayout c = (VerticalLayout) vl.getComponentAt(1); // Tareas completadas
			//c.add(this.getLayout());
		}
		/*else {
			VerticalLayout c = (VerticalLayout) vl.getComponentAt(0); // Tareas sin completar
			c.add(this.getLayout());
		}*/
		
		prioridad = new Icon(VaadinIcon.CIRCLE);
		prioridad.setSize("15px");
		if(tarea.getPrioridad() == "Alta") {
			prioridad.setColor("red");
		}
		else if(tarea.getPrioridad() == "Media") {
			prioridad.setColor("orange");
		}
		else if(tarea.getPrioridad() == "Baja") {
			prioridad.setColor("limegreen");
		}
		else {
			prioridad.setColor("lightgray");
		}
		
		String time = calcularDiasDiferencia(tarea.getFecha());
		timeLeft = new Label(time + "D");
		
		titulo = new Label(tarea.getTitulo());
		
		layout.add(checkbox, prioridad, timeLeft, titulo);
		layout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
		
		
		ID = tarea.getID();
		fecha =  tarea.getFecha();
		descripcion = tarea.getDescripcion();
		etiqueta = tarea.getEtiqueta();
		
	}


	public HorizontalLayout getLayout() {
		return layout;
	}


	public Checkbox getCheckbox() {
		return checkbox;
	}


	public Icon getPrioridad() {
		return prioridad;
	}


	public Label getTimeLeft() {
		return timeLeft;
	}


	public Label getTitulo() {
		return titulo;
	}
	


	public int getID() {
		return ID;
	}


	public Date getFecha() {
		return fecha;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public Etiqueta getEtiqueta() {
		return etiqueta;
	}


	private String calcularDiasDiferencia(Date fecha) {

		int dias = (int) ((new Date().getTime() - fecha.getTime()) / 86400000) * -1 + 1;
	    
		return Integer.toString(dias);
	}
	
	
	
}
