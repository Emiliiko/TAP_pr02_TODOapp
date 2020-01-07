package ufv.tap.vaadinTODO.VaadinTODOapp;

import java.util.ArrayList;

public class ListaVistaElementoTareas {
	
	private ArrayList<VistaElementoTarea> tareas;
	
	public ListaVistaElementoTareas() {
		tareas = new ArrayList<VistaElementoTarea>();
	}
	
	public ArrayList<VistaElementoTarea> getTareas() {
		return tareas;
	}
	
	public void addTarea(VistaElementoTarea vet) {
		tareas.add(vet);
	}
	
	public void deleteTarea(int id) {
		for (VistaElementoTarea vistaTarea : tareas) {
			if(vistaTarea.getID() == id) {
				tareas.remove(vistaTarea);
				return;
			}
		}
	}

	public void updateTarea(VistaElementoTarea vet) {
		for (VistaElementoTarea vistaTarea : tareas) {
			if(vistaTarea.getID() == vet.getID()) {
				tareas.remove(vistaTarea);
				tareas.add(vet);
				return;
			}
		}
	}
}
