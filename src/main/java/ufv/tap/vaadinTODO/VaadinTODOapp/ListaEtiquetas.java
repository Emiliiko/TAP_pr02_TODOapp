package ufv.tap.vaadinTODO.VaadinTODOapp;

import java.util.ArrayList;

public class ListaEtiquetas {
	
	private ArrayList<Etiqueta> etiquetas;
	

	public ListaEtiquetas() {
		etiquetas = new ArrayList<Etiqueta>();
	}
	
	public ArrayList<Etiqueta> getEtiquetas() {
		return etiquetas;
	}
	
	public void addEtiqueta(Etiqueta e) {
		etiquetas.add(e);
	}
	
	public ArrayList<String> getNombreEtiquetas(ListaTareas listaTareas, String valorActual) {
		
		ArrayList<String> nombres = new ArrayList<String>();
		nombres.add(valorActual);
		
		if(listaTareas.getTareas().size() == 0) {
			return nombres;
		}
			
		
		for (Tarea tarea : listaTareas.getTareas()) {
			if(!nombres.contains(tarea.getEtiqueta().getNombre()))
				nombres.add(tarea.getEtiqueta().getNombre());
		}
		
		return nombres;
	}
	
}
