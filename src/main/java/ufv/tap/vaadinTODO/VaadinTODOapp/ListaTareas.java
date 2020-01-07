package ufv.tap.vaadinTODO.VaadinTODOapp;

import java.util.ArrayList;

public class ListaTareas {
	
	private ArrayList<Tarea> tareas;
	

	public ListaTareas() {
		tareas = new ArrayList<Tarea>();
	}
	
	public ArrayList<Tarea> getTareas() {
		return tareas;
	}
	
	public void addTarea(Tarea t) {
		tareas.add(t);
	}
	
	public void deleteTarea(int id) {
		for (Tarea tarea : tareas) {
			if(tarea.getID() == id) {
				tareas.remove(tarea);
				return;
			}
		}
	}
	
	public void updateTarea(Tarea t) {
		for (Tarea tarea : tareas) {
			if(tarea.getID() == t.getID()) {
				tareas.remove(tarea);
				tareas.add(t);
				return;
			}
		}
	}
}