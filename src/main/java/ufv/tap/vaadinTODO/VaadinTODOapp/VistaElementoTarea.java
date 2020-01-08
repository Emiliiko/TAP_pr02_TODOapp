package ufv.tap.vaadinTODO.VaadinTODOapp;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;

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
	
	
	
	public VistaElementoTarea(Tarea tarea) {
		
		crearVista(tarea);
		
	}
	
	public VistaElementoTarea() {
		
		
	}


	private void crearVista(Tarea tarea) {
		
		layout = new HorizontalLayout();
		checkbox = new Checkbox();
		checkbox.setId(Integer.toString(tarea.getID()));
		
		if(tarea.isCompletada()) {
			checkbox.setValue(true);
			checkbox.setLabel("Terminada");
		}
		else {
			checkbox.setValue(false);
			checkbox.setLabel("");
		}
		
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


	private String calcularDiasDiferencia(Date fecha) {

		int dias = (int) ((new Date().getTime() - fecha.getTime()) / 86400000) * -1 + 1;
	    
		return Integer.toString(dias);
	}
	
	
	
}
