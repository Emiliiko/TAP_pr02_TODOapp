package ufv.tap.vaadinTODO.VaadinTODOapp;

import java.util.ArrayList;
import java.util.Comparator;

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
	
	public Tarea getTareaById(int id) {
		Tarea t = new Tarea();
		for (Tarea tarea : tareas) {
			if(tarea.getID() == id) {
				t = tarea;
				break;
			}	
		}
		return t;
	}
	
	public ListaTareas getCompletadas() {
		ListaTareas lt = new ListaTareas();
		
		for (Tarea tarea : tareas) {
			if(tarea.isCompletada())
				lt.addTarea(tarea);
		}
		return lt;
	}
	
	public ListaTareas getSinCompletar() {
		ListaTareas lt = new ListaTareas();
		
		for (Tarea tarea : tareas) {
			if(!tarea.isCompletada())
				lt.addTarea(tarea);
		}
		return lt;
	}
	
	public void getTareasOrdenadas(String filtro) {
		
		// Si el filtro es Fecha
		if(filtro.equals("Fecha de fin"))
			tareas.sort(Comparator.comparing(Tarea::getFecha));
		else if(filtro.equals("Prioridad Asc")) {
			tareas.sort(Comparator.comparing(Tarea::getPrioridadNum));
		}
		else if(filtro.equals("Prioridad Desc")) {
			tareas.sort(Comparator.comparing(Tarea::getPrioridadNum).reversed());
		}
	}
}

