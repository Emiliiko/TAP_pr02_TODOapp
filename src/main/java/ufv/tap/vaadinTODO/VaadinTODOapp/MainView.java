package ufv.tap.vaadinTODO.VaadinTODOapp;


import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

import java.util.Date;
import java.time.ZoneId;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.flow.router.Route;

/**
 * The main view contains a button and a click listener.
 */
@Route
@PWA(name = "TODO app", shortName = "TODO app")
@Theme(value = Lumo.class, variant = Lumo.DARK)
//@Theme(value = Material.class, variant = Material.DARK)
public class MainView extends HorizontalLayout {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Contenedor Etiquetas
	public VerticalLayout tagLayout;
	public Label tagLabel; // Título
	// Subcontenedor con todas las etiquetas
	public VerticalLayout allTagsLayout;
	
	// Contenedor Tareas
	public VerticalLayout mainTasksLayout;
	public HorizontalLayout orderLayout; // Subcontenedor Título - Filtros
	public Label noteLabel; // Título
	public ComboBox<String> orderComboBox; // ComboBox para ordenar las notas
	public Grid<VistaElementoTarea> gridTareas; // Grid contenedor de tareas
	public Button newTask;// Botón para crear una nueva nota
	
	// Contenedor Edición
	public VerticalLayout editLayout;
	public Label editLabel; // Título
	// Subcontenedor Título
	public HorizontalLayout titleLayout;
	public TextField titulo;
	// Subcontenedor prioridad - fecha
	public HorizontalLayout priorityDateLayout;
	public Icon prioridadEdit;
	public ComboBox<String> priorityDateComboBox;
	public DatePicker datePicker;
	// Subcontenedor Descripción
	public TextArea descripcion;
	// Subcontenedor Etiquetas
	public ComboBox<String> tagsComboBox;
	//Subcontenedor guardar/crear - cancelar
	public HorizontalLayout saveCancelLayout;
	public HorizontalLayout saveCancelButtonsLayout;
	public Notification saveNotification;
	public Notification updateNotification;
	public Button save;
	public Button cancel;
	
	// Lista Tareas
	public ListaTareas listaTareas = new ListaTareas();
	// Lista Vista Tareas
	public ListaVistaElementoTareas listaVistaTareas = new ListaVistaElementoTareas();
	// Lista Etiquetas
	public ListaEtiquetas listaEtiquetas = new ListaEtiquetas();
	public ListaVistaElementoEtiquetas listaVistaEtiquetas = new ListaVistaElementoEtiquetas();
	
	
	// Constructor
    public MainView() {
    	
    	// Contenedor principal
    	//this.getStyle().set("border", "1px solid black");

    	this.setPadding(true);
    	this.setMargin(false);
    	this.setSpacing(true);
    	this.getStyle().set("height", "100%");
    	//this.getStyle().set("background-color", "#26364D");
        
    	
    	// 3 contenedores
    	
    	// Contenedor Etiquetas
    	tagLayout = crearLayoutV();
    	// Título
    	tagLabel = new Label("Categorías");
    	tagLabel.getStyle().set("font-size", "2em");
    	// Subcontenedor con todas las etiquetas
    	allTagsLayout = crearLayoutV();
    	
    	//////////////
    	Etiqueta e = new Etiqueta("tag");
    	VistaElementoEtiqueta ve = new VistaElementoEtiqueta(e);
    	Etiqueta e1 = new Etiqueta("tag1");
    	VistaElementoEtiqueta ve1 = new VistaElementoEtiqueta(e1);
    	//allTagsLayout.add(ve.getLayout());
    	//////////////
    	//////////////
		Grid<VistaElementoEtiqueta> grid = new Grid<>();
		grid.getStyle().set("background", "none").set("border", "none").set("width", "200px");
		grid.setItems(ve, ve1);
		grid.addComponentColumn(item -> item.getIcono());
		grid.addComponentColumn(item -> item.getNombre());
		allTagsLayout.add(grid);
		/////////////
    	
    	tagLayout.add(tagLabel, allTagsLayout);
    	
    	
    	// Contenedor Tareas
    	mainTasksLayout = crearLayoutV();
    	// Subcontenedor Título - Filtros
    	orderLayout = crearLayoutH();
    	orderLayout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
    	orderLayout.getStyle().set("width", "100%");
    	orderLayout.getStyle().set("position", "relative");
    	orderLayout.getStyle().set("margin-bottom", "50px");
    	// Título
    	noteLabel = new Label("Tareas");
    	noteLabel.getStyle().set("font-size", "2em");
    	noteLabel.getStyle().set("margin-right", "80px");
    	// ComboBox para ordenar las notas
    	orderComboBox = new ComboBox<>();
    	orderComboBox.setItems("Todas", "Prioridad", "Fecha", "Completadas", "Vencidas", "Sin completar");
    	orderComboBox.setPlaceholder("Ordenar por...");
    	orderComboBox.getStyle().set("padding", "0").set("margin-right", "80px");
    	// Botón para crear una nueva nota
    	newTask = new Button("+", event -> {
    		editLayout.getStyle().set("left", "0");
    		clearContent();
    	});
    	newTask.getStyle().set("min-width", "auto").set("border-radius", "100%")
    	.set("font-size", "var(--lumo-font-size-xl)").set("height", "41px").set("cursor", "pointer");
    	orderLayout.add(noteLabel, orderComboBox, newTask);
    	
    	/*
		//////////////
		Tarea t1 = new Tarea("Prueba1", "Alta", new Date(), "Érase una pinga pará", false, new Etiqueta("tag1"));
		VistaElementoTarea vista1 = new VistaElementoTarea(t1);
		Tarea t2 = new Tarea("Prueba2", "Media", new Date(), "Érase un bollo bien sano", false, new Etiqueta("tag2"));
		VistaElementoTarea vista2 = new VistaElementoTarea(t2);
		/////////////
		//////////////
		Tarea t3 = new Tarea("Prueba3", "Baja", new Date(), "Érase una vez", true, new Etiqueta("tag3"));
		VistaElementoTarea vista3 = new VistaElementoTarea(t3);
		Tarea t4 = new Tarea("Prueba4", "", new Date(), "Éranse dos veces", true, new Etiqueta("tag4"));
		VistaElementoTarea vista4 = new VistaElementoTarea(t4);
		/////////////
		//////////////
		 */
		gridTareas = new Grid<>();
		gridTareas.getStyle().set("background", "none").set("border", "none").set("width", "500px");
		gridTareas.addComponentColumn(item -> item.getCheckbox());
		gridTareas.addComponentColumn(item -> item.getPrioridad());
		gridTareas.addComponentColumn(item -> item.getTimeLeft());
		gridTareas.addComponentColumn(item -> item.getTitulo());
		gridTareas.addItemClickListener(event -> {
			VistaElementoTarea vet = event.getItem();
			editLayout.getStyle().set("left", "0");
			titulo.setValue(vet.getTitulo().getText());
			String color = vet.getPrioridad().getColor();
			if(color == "red")
				priorityDateComboBox.setValue("Alta");
			else if(color == "orange")
				priorityDateComboBox.setValue("Media");
			else if(color == "limegreen")
				priorityDateComboBox.setValue("Baja");
			else
				priorityDateComboBox.setValue("Sin Prioridad");
			datePicker.setValue(vet.getFecha().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
			descripcion.setValue(vet.getDescripcion());
			tagsComboBox.setValue(vet.getEtiqueta().getNombre());
			save.setText("Guardar");
		});
		/////////////
		
		
		
		
		
		
    	mainTasksLayout.add(orderLayout, gridTareas);

    	
    	// Contenedor Edición
    	editLayout = crearLayoutV();
    	editLayout.getStyle().set("transition", ".7s").set("position", "relative").set("left", "100%");
    	// Título
    	editLabel = new Label("Edición");
    	editLabel.getStyle().set("font-size", "2em");
    	// Subcontenedor Título
    	titleLayout = crearLayoutH();
    	titleLayout.getStyle().set("position", "relative");
    	titleLayout.getStyle().set("width", "100%");
    	titleLayout.getStyle().set("margin-bottom", "15px");
    	titulo = new TextField();
    	titulo.setPlaceholder("Título");
    	titulo.getStyle().set("width", "90%");
    	titulo.getStyle().set("position", "relative");
    	titulo.getStyle().set("left", "50%");
    	titulo.getStyle().set("transform", "translateX(-50%)");
    	titleLayout.add(titulo);
    	// Subcontenedor prioridad - fecha
    	priorityDateLayout = crearLayoutH();
    	priorityDateLayout.getStyle().set("margin-bottom", "15px");
    	priorityDateLayout.getStyle().set("position", "relative").set("left", "50%").set("transform", "translateX(-50%)");
    	prioridadEdit = new Icon(VaadinIcon.CIRCLE);
		prioridadEdit.setSize("15px");
		prioridadEdit.getStyle().set("margin", "0 10px");
		prioridadEdit.setColor("lightgray");
    	priorityDateComboBox = new ComboBox<>();
    	priorityDateComboBox.setItems("Alta", "Media", "Baja", "Sin prioridad");
    	priorityDateComboBox.setPlaceholder("Prioridad");
    	priorityDateComboBox.setValue("Sin Prioridad");
    	priorityDateComboBox.getStyle().set("margin-right", "25px");
    	priorityDateComboBox.addValueChangeListener(event -> {
    	    if (event.getValue() == "Alta") {
    	    	prioridadEdit.setColor("red");
    	    } 
    	    else if (event.getValue() == "Media"){
    	    	prioridadEdit.setColor("orange");
    	    }
    	    else if (event.getValue() == "Baja"){
    	    	prioridadEdit.setColor("limegreen");
    	    }
    	    else {
    	    	prioridadEdit.setColor("lightgray");
    	    }
    	});
    	datePicker = new DatePicker();
    	datePicker.setPlaceholder("Fecha límite");
    	priorityDateLayout.add(prioridadEdit, priorityDateComboBox, datePicker);
    	priorityDateLayout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
    	// Subcontenedor Descripción
    	descripcion = new TextArea();
    	descripcion.getStyle().set("maxHeight", "150px");
    	descripcion.getStyle().set("width", "90%");
    	descripcion.getStyle().set("height", "150px");
    	descripcion.getStyle().set("position", "relative");
    	descripcion.getStyle().set("left", "50%");
    	descripcion.getStyle().set("transform", "translateX(-50%)");
    	descripcion.getStyle().set("margin-bottom", "15px");
    	descripcion.setPlaceholder("Descripción de la tarea...");
    	// Subcontenedor Etiquetas
    	tagsComboBox = new ComboBox<>();
    	//tagsComboBox.setItems("adios");
    	tagsComboBox.setPlaceholder("Categoría");
    	tagsComboBox.getStyle().set("position", "relative");
    	tagsComboBox.getStyle().set("left", "50%");
    	tagsComboBox.getStyle().set("transform", "translateX(-50%)");
    	tagsComboBox.getStyle().set("margin-bottom", "15px");
    	tagsComboBox.addCustomValueSetListener(event -> {
    		tagsComboBox.setItems(listaEtiquetas.getNombreEtiquetas(listaTareas, event.getDetail()));
    		tagsComboBox.setValue(event.getDetail());
    	});
    	//Subcontenedor guardar/crear - cancelar
    	saveCancelLayout = crearLayoutH();
    	saveCancelLayout.getStyle().set("position", "relative");
    	saveCancelLayout.getStyle().set("width", "100%");
    	saveCancelButtonsLayout = crearLayoutH();
    	saveCancelButtonsLayout.getStyle().set("position", "relative");
    	saveCancelButtonsLayout.getStyle().set("left", "50%");
    	saveCancelButtonsLayout.getStyle().set("transform", "translateX(-50%)");
    	saveNotification = new Notification("La nota se ha creado", 3500, Position.TOP_END);
    	updateNotification = new Notification("La nota se ha actualizado", 3500, Position.TOP_END);
    	save = new Button("Crear", event -> {
    		editLayout.getStyle().set("left", "100%");
    		if(save.getText().equals("Crear")) {
    			crearTarea();
    			saveNotification.open();
    		}
    		else if(save.getText().equals("Guardar")) {
    			//updateTarea();
    			updateNotification.open();
    		}
    		
    	});
    	save.getStyle().set("margin", "0 5px").set("cursor", "pointer");
    	cancel = new Button("Cancelar", event -> {
    		editLayout.getStyle().set("left", "100%");
    	});
    	cancel.getStyle().set("margin", "0 5px").set("cursor", "pointer");
    	saveCancelButtonsLayout.add(save, cancel);
    	saveCancelLayout.add(saveCancelButtonsLayout);
    	
    	editLayout.add(editLabel, titleLayout, priorityDateLayout, descripcion, tagsComboBox, saveCancelLayout);
    	
    	add(tagLayout, mainTasksLayout, editLayout);
    	
    }


	private void crearTarea() {
		
		String tituloTarea = titulo.getValue();
		String prioridad = priorityDateComboBox.getValue();
		Date fechaTarea = Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
		String descripcionTarea = descripcion.getValue();
		boolean completada = false;
		Etiqueta etiquetaTarea = new Etiqueta(tagsComboBox.getValue());
		
		// Backend
		Tarea t = new Tarea(tituloTarea, prioridad, fechaTarea, descripcionTarea, completada, etiquetaTarea);
		listaTareas.addTarea(t);
		
		// Front
		updateVista();
	}


	private void updateVista() {
		
		// Actualizar Contenedor Tareas
		listaVistaTareas.getTareas().clear();
		
		for (Tarea tarea : listaTareas.getTareas()) {
			listaVistaTareas.addTarea(new VistaElementoTarea(tarea));
		}
		
		gridTareas.setItems(listaVistaTareas.getTareas());
		
		// Actualizar Contenedor Etiquetas
		
	}


	private void clearContent() {
		titulo.clear();
		prioridadEdit.setColor("lightgray");
		priorityDateComboBox.setValue("Sin Prioridad");
		datePicker.clear();
		descripcion.clear();
		tagsComboBox.clear();
		save.setText("Crear");
	}


	public static HorizontalLayout crearLayoutH() {
    	HorizontalLayout layout = new HorizontalLayout();
    	//layout.getStyle().set("border", "1px solid white");

    	layout.setPadding(false);
    	layout.setMargin(false);
    	layout.setSpacing(false);
    	
    	return layout;
    }

	public static VerticalLayout crearLayoutV() {
		VerticalLayout layout = new VerticalLayout();
		//layout.getStyle().set("border", "1px solid white");
		layout.getStyle().set("border-radius", "10px");
		//layout.getStyle().set("background-color", "#243348");

    	layout.setPadding(true);
    	layout.setMargin(false);
    	layout.setSpacing(false);
    	
    	return layout;
	}
    
}
