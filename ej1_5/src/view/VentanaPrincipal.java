package view;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import auxiliares.*;
import dao.*;

public class VentanaPrincipal extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnDeporte, btnDeportista, btnEquipo, btnEvento, btnOlimpiada, btnParticipacion;
	private JButton btnAniadir, btnModificar, btnEliminar;
	private JList lst;
	private DefaultListModel mdl;
	private JPanel pnlActual;
	private HashMap<String, JTextField> mapaParametros;
	private JComboBox<Evento> cmbEventos;
	private JComboBox<Olimpiada> cmbOlimpiadas;
	private JComboBox<Deporte> cmbDeportes;
	private JComboBox<Deportista> cmbDeportistas;
	private JComboBox<Equipo> cmbEquipos;
	
	public VentanaPrincipal() {
		draw();
		listen();
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void draw() {
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(3, 2));
		this.getContentPane().add(panelBotones);
		btnDeporte = new JButton("Deporte");
		panelBotones.add(btnDeporte);
		btnDeportista = new JButton("Deportista");
		panelBotones.add(btnDeportista);
		btnEquipo = new JButton("Equipo");
		panelBotones.add(btnEquipo);
		btnOlimpiada = new JButton("Olimpiada");
		panelBotones.add(btnOlimpiada);
		btnEvento = new JButton("Evento");
		panelBotones.add(btnEvento);
		btnParticipacion = new JButton("Participacion");
		panelBotones.add(btnParticipacion);
		pnlActual = new JPanel();
		BorderLayout bl = new BorderLayout();
		this.getContentPane().add(pnlActual);
		pnlActual.add(new JLabel("JODER"));
		btnAniadir = new JButton("A�ADIR");
		btnModificar = new JButton("MODIFICAR");
		btnEliminar = new JButton("ELIMINAR");
		pnlActual.setLayout(new BorderLayout());
	}
	
	private void listen() {
		btnDeporte.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				habilitarBotones();
				btnDeporte.setEnabled(false);
				dibujarPanelDeporte();
				escucharPanelDeporte();
			}
			
		});
		
		btnDeportista.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				habilitarBotones();
				btnDeportista.setEnabled(false);
				dibujarPanelDeportista();
				escucharPanelDeportista();
			}
			
		});
		
		btnEquipo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				habilitarBotones();
				btnEquipo.setEnabled(false);
				dibujarPanelEquipo();
				escucharPanelEquipo();
			}
			
		});
		
		btnOlimpiada.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				habilitarBotones();
				btnOlimpiada.setEnabled(false);
				dibujarPanelOlimpiada();
				escucharPanelOlimpiada();
			}
			
		});
		
		btnEvento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				habilitarBotones();
				btnEvento.setEnabled(false);
				dibujarPanelEvento();
				escucharPanelEvento();
			}
			
		});
		
		btnParticipacion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				habilitarBotones();
				btnParticipacion.setEnabled(false);
				dibujarPanelParticipacion();
				escucharPanelParticipacion();
			}
			
		});
		
	}
	
	private void dibujarPanelDeporte() {
		pnlActual.removeAll();
		mdl = new DefaultListModel<Deporte>();
		ArrayList<Deporte> listaDeportes = DeportesDAO.getAllDeportes();
		listaDeportes.forEach(deporte -> {
			mdl.addElement(deporte);
		});
		lst = new JList<Deporte>(mdl);
		pnlActual.add(lst, BorderLayout.CENTER);
		
		mapaParametros = new HashMap<String, JTextField>();
		JPanel pnlParametros = new JPanel();
		pnlActual.add(pnlParametros, BorderLayout.NORTH);
		
		// Creamos todos los textfield para los parametros 
		mapaParametros.put("Nombre", new JTextField());
		pnlParametros.setLayout(new GridLayout(0, 2));
		
		// Los dibujamos
		for(String label: mapaParametros.keySet()) {
			pnlParametros.add(new JLabel(label,SwingConstants.CENTER));
			pnlParametros.add(mapaParametros.get(label));
		}
		// A�adir los 3 botones y el JList
		JPanel pnlBotones = new JPanel();
		pnlBotones.add(btnAniadir);
		pnlBotones.add(btnModificar);
		pnlBotones.add(btnEliminar);
		pnlActual.add(pnlBotones, BorderLayout.SOUTH);
		
		repaint();
		revalidate();
	}
	
	private void escucharPanelDeporte() {
		removeAllActionListeners(btnAniadir);
		removeAllActionListeners(btnEliminar);
		removeAllActionListeners(btnModificar);
		
		btnAniadir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nombre = mapaParametros.get("Nombre").getText();
				Deporte d = new Deporte(-1, nombre);
				if(DeportesDAO.addDeporte(d)) {
					System.out.println("Se ha añadido");
				}
				mdl.clear();
				ArrayList<Deporte> listaDeportes = DeportesDAO.getAllDeportes();
				listaDeportes.forEach(deporte -> {
					mdl.addElement(deporte);
				});
				repaint();
				revalidate();
			}
			
		});
		
		btnModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Deporte selectedDeporte = (Deporte) lst.getSelectedValue();
				if(selectedDeporte == null) {
					JOptionPane.showMessageDialog(null, "Necesitas tener seleccionado el objeto a eliminar!!!");
				}
				else {
					String nombre = mapaParametros.get("Nombre").getText();
					if(nombre.equals("")) {
						mensajeErrorVacio();
					}
					else {
						selectedDeporte.setNombre(nombre);
						DeportesDAO.modifyDeporte(selectedDeporte);
						ArrayList<Deporte> listaDeportes = DeportesDAO.getAllDeportes();
						mdl.clear();
						listaDeportes.forEach(deporte -> {
							mdl.addElement(deporte);
						});
					}
				}
				repaint();
				revalidate();
			}
			
		});
		
		btnEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Deporte selectedDeporte = (Deporte) lst.getSelectedValue();
				if(selectedDeporte == null) {
					JOptionPane.showMessageDialog(null, "Necesitas tener seleccionado el objeto a eliminar!!!");
				}
				else {
					if(!DeportesDAO.removeDeporte(selectedDeporte)) {
						JOptionPane.showMessageDialog(null, "Por favor, rellena todos los valores!!!");
					}
				}
				ArrayList<Deporte> listaDeportes = DeportesDAO.getAllDeportes();
				mdl.clear();
				listaDeportes.forEach(deporte -> {
					mdl.addElement(deporte);
				});
				repaint();
				revalidate();
			}
			
		});
	}
	
	private void dibujarPanelDeportista() {
		pnlActual.removeAll();
		mdl = new DefaultListModel<Deportista>();
		ArrayList<Deportista> listaDeportistas = DeportistasDAO.getAllDeportistas();
		listaDeportistas.forEach(deportista -> {
			mdl.addElement(deportista);
		});
		lst = new JList<Deportista>(mdl);
		pnlActual.add(lst, BorderLayout.CENTER);
		
		mapaParametros = new HashMap<String, JTextField>();
		JPanel pnlParametros = new JPanel();
		pnlActual.add(pnlParametros, BorderLayout.NORTH);
		
		// Creamos todos los textfield para los parametros 
		mapaParametros.put("Nombre", new JTextField());
		mapaParametros.put("Sexo", new JTextField());
		mapaParametros.put("Peso", new JTextField());
		mapaParametros.put("Altura", new JTextField());
		pnlParametros.setLayout(new GridLayout(0, 2));
		
		// Los dibujamos
		for(String label: mapaParametros.keySet()) {
			pnlParametros.add(new JLabel(label,SwingConstants.CENTER));
			pnlParametros.add(mapaParametros.get(label));
		}
		// A�adir los 3 botones y el JList
		JPanel pnlBotones = new JPanel();
		pnlBotones.add(btnAniadir);
		pnlBotones.add(btnModificar);
		pnlBotones.add(btnEliminar);
		pnlActual.add(pnlBotones, BorderLayout.SOUTH);
		
		repaint();
		revalidate();
	}
	
	private void escucharPanelDeportista() {
		removeAllActionListeners(btnAniadir);
		removeAllActionListeners(btnEliminar);
		removeAllActionListeners(btnModificar);
		
		btnAniadir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String nombre = mapaParametros.get("Nombre").getText();
					char sexo = Character.toUpperCase(mapaParametros.get("Sexo").getText().charAt(0));
					if(sexo != 'M' && sexo != 'H') {
						throw new Exception();
					}
					int peso = Integer.parseInt(mapaParametros.get("Peso").getText());
					int altura = Integer.parseInt(mapaParametros.get("Altura").getText());
					Deportista d = new Deportista(-1, nombre, sexo, peso, altura);
					System.out.println(d.toString());
					// TODO: NO SE AÑADE
					if(DeportistasDAO.addDeportista(d)) {
						System.out.println("Se ha añadido");
					}
				} catch(Exception e) {
					mensajeError();
				}
				mdl.clear();
				ArrayList<Deportista> listaDeportistas = DeportistasDAO.getAllDeportistas();
				mdl.clear();
				listaDeportistas.forEach(deportista -> {
					mdl.addElement(deportista);
				});
				repaint();
				revalidate();
			}
			
		});
		
		btnModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Deportista selectedDeportista = (Deportista) lst.getSelectedValue();
				if(selectedDeportista == null) {
					JOptionPane.showMessageDialog(null, "Necesitas tener seleccionado el objeto a eliminar!!!");
				}
				else {
					// GET PARAMS
					String nombre = null;
					char sexo = ' ';
					int peso = 0;
					int altura = 0;
					try {
						nombre = mapaParametros.get("Nombre").getText();
						sexo = Character.toUpperCase(mapaParametros.get("Sexo").getText().charAt(0));
						if(sexo != 'M' && sexo != 'H') {
							throw new Exception();
						}
						peso = Integer.parseInt(mapaParametros.get("Peso").getText());
						altura = Integer.parseInt(mapaParametros.get("Altura").getText());
						Deportista d = new Deportista(-1, nombre, sexo, peso, altura);

						// TODO: NO SE AÑADE
						if(DeportistasDAO.addDeportista(d)) {
							System.out.println("Se ha añadido");
						}
					} catch(Exception e) {
						mensajeErrorVacio();
					}
					if(nombre != null || sexo != ' ' || peso <= 0 || altura <= 0) { // CHECK IF THEY OK
						mensajeErrorVacio();
					}
					else {
						// ASIGN THEM TO selectedDeportista
						selectedDeportista.setNombre(nombre);
						selectedDeportista.setSexo(sexo);
						selectedDeportista.setPeso(peso);
						selectedDeportista.setAltura(altura);
						DeportistasDAO.modifyDeportista(selectedDeportista);
						ArrayList<Deportista> listaDeportistas = DeportistasDAO.getAllDeportistas();
						mdl.clear();
						listaDeportistas.forEach(deportista -> {
							mdl.addElement(deportista);
						});
					}
				}
				repaint();
				revalidate();
			}
			
		});
		
		btnEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Deportista selectedDeportista = (Deportista) lst.getSelectedValue();
				if(selectedDeportista == null) {
					JOptionPane.showMessageDialog(null, "Necesitas tener seleccionado el objeto a eliminar!!!");
				}
				else {
					if(!DeportistasDAO.removeDeportista(selectedDeportista)) {
						JOptionPane.showMessageDialog(null, "Por favor, rellena todos los valores!!!");
					}
				}
				ArrayList<Deportista> listaDeportistas = DeportistasDAO.getAllDeportistas();
				mdl.clear();
				listaDeportistas.forEach(deportista -> {
					mdl.addElement(deportista);
				});
				repaint();
				revalidate();
			}
			
		});
	}
	
	private void dibujarPanelEquipo() {
		pnlActual.removeAll();
		mdl = new DefaultListModel<Equipo>();
		ArrayList<Equipo> listaEquipos = EquiposDAO.getAllEquipos();
		listaEquipos.forEach(equipo -> {
			mdl.addElement(equipo);
		});
		lst = new JList<Equipo>(mdl);
		pnlActual.add(lst);
		
		mapaParametros = new HashMap<String, JTextField>();
		JPanel pnlParametros = new JPanel();
		pnlActual.add(pnlParametros, BorderLayout.NORTH);
		
		// Creamos todos los textfield para los parametros 
		mapaParametros.put("Nombre", new JTextField());
		mapaParametros.put("Iniciales", new JTextField());
		pnlParametros.setLayout(new GridLayout(0, 2)); 
		
		// Los dibujamos
		for(String label: mapaParametros.keySet()) {
			pnlParametros.add(new JLabel(label,SwingConstants.CENTER));
			pnlParametros.add(mapaParametros.get(label));
		}
		// A�adir los 3 botones y el JList
		JPanel pnlBotones = new JPanel();
		pnlBotones.add(btnAniadir);
		pnlBotones.add(btnModificar);
		pnlBotones.add(btnEliminar);
		pnlActual.add(pnlBotones, BorderLayout.SOUTH);
		
		repaint();
		revalidate();
	}
	
	private void escucharPanelEquipo() {
		removeAllActionListeners(btnAniadir);
		removeAllActionListeners(btnEliminar);
		removeAllActionListeners(btnModificar);
		
		btnAniadir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					// TODO: Equipo a añadir
					String nombre = mapaParametros.get("Nombre").getText();
					String iniciales = mapaParametros.get("Nombre").getText();
					Equipo e = new Equipo(-1, nombre, iniciales);
					if(EquiposDAO.addEquipo(e)) {
						System.out.println("Se ha añadido");
					}
				} catch(Exception e) {
					mensajeErrorVacio();
				}
				mdl.clear();
				ArrayList<Equipo> listaEquipos = EquiposDAO.getAllEquipos();
				mdl.clear();
				listaEquipos.forEach(equipo -> {
					mdl.addElement(equipo);
				});
				repaint();
				revalidate();
			}
			
		});
		
		btnModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Equipo selectedEquipo = (Equipo) lst.getSelectedValue();
				if(selectedEquipo == null) {
					JOptionPane.showMessageDialog(null, "Necesitas tener seleccionado el objeto a eliminar!!!");
				}
				else {
					// GET PARAMS
					
					String nombre = mapaParametros.get("Nombre").getText();
					String iniciales = mapaParametros.get("Nombre").getText();
					
					if(nombre.trim().equals("") || iniciales.trim().equals("")) { // CHECK IF THEY OK
						mensajeErrorVacio();
					}
					else {
						// ASIGN THEM TO selectedEquipo
						selectedEquipo.setNombre(nombre);
						selectedEquipo.setIniciales(iniciales);
						EquiposDAO.modifyEquipo(selectedEquipo);
						ArrayList<Equipo> listaEquipos = EquiposDAO.getAllEquipos();
						mdl.clear();
						listaEquipos.forEach(equipo -> {
							mdl.addElement(equipo);
						});
					}
				}
				repaint();
				revalidate();
			}
			
		});
		
		btnEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Equipo selectedEquipo = (Equipo) lst.getSelectedValue();
				if(selectedEquipo == null) {
					JOptionPane.showMessageDialog(null, "Necesitas tener seleccionado el objeto a eliminar!!!");
				}
				else {
					if(!EquiposDAO.removeEquipo(selectedEquipo)) {
						JOptionPane.showMessageDialog(null, "Por favor, rellena todos los valores!!!");
					}
				}
				ArrayList<Equipo> listaEquipos = EquiposDAO.getAllEquipos();
				mdl.clear();
				listaEquipos.forEach(equipo-> {
					mdl.addElement(equipo);
				});
				repaint();
				revalidate();
			}
			
		});
	}
	
	private void dibujarPanelOlimpiada() {
		pnlActual.removeAll();
		mdl = new DefaultListModel<Olimpiada>();
		ArrayList<Olimpiada> listaOlimpiadas = OlimpiadasDAO.getAllOlimpiadas();
		listaOlimpiadas.forEach(olimpiada -> {
			mdl.addElement(olimpiada);
		});
		lst = new JList<Olimpiada>(mdl);
		pnlActual.add(lst);
		
		mapaParametros = new HashMap<String, JTextField>();
		JPanel pnlParametros = new JPanel();
		pnlActual.add(pnlParametros, BorderLayout.NORTH);
		
		// Creamos todos los textfield para los parametros 
		mapaParametros.put("Nombre", new JTextField());
		mapaParametros.put("Año", new JTextField());
		mapaParametros.put("Temporada", new JTextField());
		mapaParametros.put("Ciudad", new JTextField());
		pnlParametros.setLayout(new GridLayout(0, 2));
		
		// Los dibujamos
		for(String label: mapaParametros.keySet()) {
			pnlParametros.add(new JLabel(label,SwingConstants.CENTER));
			pnlParametros.add(mapaParametros.get(label));
		}
		// A�adir los 3 botones y el JList
		JPanel pnlBotones = new JPanel();
		pnlBotones.add(btnAniadir);
		pnlBotones.add(btnModificar);
		pnlBotones.add(btnEliminar);
		pnlActual.add(pnlBotones, BorderLayout.SOUTH);
		
		repaint();
		revalidate();
	}
	
	// TODO: Panel olimpiada
	private void escucharPanelOlimpiada() {
		removeAllActionListeners(btnAniadir);
		removeAllActionListeners(btnEliminar);
		removeAllActionListeners(btnModificar);
		
		btnAniadir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					// TODO: Equipo a añadir
					String nombre = mapaParametros.get("Nombre").getText();
					String temporada = mapaParametros.get("Temporada").getText();
					String ciudad = mapaParametros.get("Ciudad").getText();
					String anio = mapaParametros.get("Año").getText();
					Olimpiada o = new Olimpiada(-1, nombre, anio, temporada, ciudad);
					if(OlimpiadasDAO.addOlimpiada(o)) {
						System.out.println("Se ha añadido");
					}
				} catch(Exception e) {
					mensajeErrorVacio();
				}
				mdl.clear();
				ArrayList<Olimpiada> listaOlimpiadas = OlimpiadasDAO.getAllOlimpiadas();
				mdl.clear();
				listaOlimpiadas.forEach(olimpiada -> {
					mdl.addElement(olimpiada);
				});
				repaint();
				revalidate();
			}
			
		});
		
		btnModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Olimpiada selectedOlimpiada = (Olimpiada) lst.getSelectedValue();
				if(selectedOlimpiada == null) {
					JOptionPane.showMessageDialog(null, "Necesitas tener seleccionado el objeto a eliminar!!!");
				}
				else {
					// GET PARAMS
					
					
					if(true) { // CHECK IF THEY OK
						mensajeErrorVacio();
					}
					else {
						// ASIGN THEM TO selectedEquipo
						
						OlimpiadasDAO.modifyOlimpiada(selectedOlimpiada);
						ArrayList<Olimpiada> listaOlimpiadas = OlimpiadasDAO.getAllOlimpiadas();
						mdl.clear();
						listaOlimpiadas.forEach(olimpiada -> {
							mdl.addElement(olimpiada);
						});
					}
				}
				repaint();
				revalidate();
			}
			
		});
		
		btnEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Olimpiada selectedOlimpiada = (Olimpiada) lst.getSelectedValue();
				if(selectedOlimpiada == null) {
					JOptionPane.showMessageDialog(null, "Necesitas tener seleccionado el objeto a eliminar!!!");
				}
				else {
					if(!OlimpiadasDAO.removeOlimpiada(selectedOlimpiada)) {
						JOptionPane.showMessageDialog(null, "Por favor, rellena todos los valores!!!");
					}
				}
				ArrayList<Olimpiada> listaOlimpiadas = OlimpiadasDAO.getAllOlimpiadas();
				mdl.clear();
				listaOlimpiadas.forEach(equipo-> {
					mdl.addElement(equipo);
				});
				repaint();
				revalidate();
			}
			
		});
	}
	
	
	private void dibujarPanelEvento() {
		pnlActual.removeAll();
		mdl = new DefaultListModel<Evento>();
		ArrayList<Evento> listaEventos = EventosDAO.getAllEventos();
		listaEventos.forEach(evento -> {
			mdl.addElement(evento);
		});
		lst = new JList<Evento>(mdl);
		pnlActual.add(lst);
		
		mapaParametros = new HashMap<String, JTextField>();
		JPanel pnlParametros = new JPanel();
		pnlActual.add(pnlParametros, BorderLayout.NORTH);
		
		// Creamos todos los textfield para los parametros 
		mapaParametros.put("Nombre", new JTextField());
		pnlParametros.setLayout(new GridLayout(0, 2));
		
		// Los dibujamos
		for(String label: mapaParametros.keySet()) {
			pnlParametros.add(new JLabel(label,SwingConstants.CENTER));
			pnlParametros.add(mapaParametros.get(label));
		}
		
		// TODO: Añadir los selectores de deporte y olimpiada
		pnlParametros.add(new JLabel("Olimpiada" ,SwingConstants.CENTER));
		DefaultComboBoxModel<Olimpiada> cmbmOl = new DefaultComboBoxModel<Olimpiada>();
		ArrayList<Olimpiada> listaOlimpiadas = OlimpiadasDAO.getAllOlimpiadas();
		listaOlimpiadas.forEach(olimpiada -> {
			cmbmOl.addElement(olimpiada);
		});
		cmbOlimpiadas = new JComboBox<Olimpiada>(cmbmOl);
		pnlParametros.add(cmbOlimpiadas);
		
		pnlParametros.add(new JLabel("Deporte" ,SwingConstants.CENTER));
		DefaultComboBoxModel<Deporte> cmbmDe = new DefaultComboBoxModel<Deporte>();
		ArrayList<Deporte> listaDeportes = DeportesDAO.getAllDeportes();
		listaDeportes.forEach(deporte -> {
			cmbmDe.addElement(deporte);
		});
		cmbDeportes = new JComboBox<Deporte>(cmbmDe);
		pnlParametros.add(cmbDeportes);
		
		// A�adir los 3 botones y el JList
		JPanel pnlBotones = new JPanel();
		pnlBotones.add(btnAniadir);
		pnlBotones.add(btnModificar);
		pnlBotones.add(btnEliminar);
		pnlActual.add(pnlBotones, BorderLayout.SOUTH);

		repaint();
		revalidate();
	}
	
	// TODO: Panel evento
	private void escucharPanelEvento() {
		removeAllActionListeners(btnAniadir);
		removeAllActionListeners(btnEliminar);
		removeAllActionListeners(btnModificar);
	}
	
	private void dibujarPanelParticipacion() {
		pnlActual.removeAll();
		mdl = new DefaultListModel<Participacion>();
		ArrayList<Participacion> listaParticipaciones = ParticipacionesDAO.getAllParticipaciones();
		listaParticipaciones.forEach(participacion -> {
			mdl.addElement(participacion);
		});
		lst = new JList<Participacion>(mdl);
		pnlActual.add(lst);
		
		mapaParametros = new HashMap<String, JTextField>();
		JPanel pnlParametros = new JPanel();
		pnlActual.add(pnlParametros, BorderLayout.NORTH);
		
		// Creamos todos los textfield para los parametros 
		mapaParametros.put("Edad", new JTextField());
		mapaParametros.put("Medalla", new JTextField());
		pnlParametros.setLayout(new GridLayout(0, 2));
		
		// TODO: Añadir los selectores de Evento, Deportista, Equipo
		pnlParametros.add(new JLabel("Evento" ,SwingConstants.CENTER));
		DefaultComboBoxModel<Evento> cmbmEv = new DefaultComboBoxModel<Evento>();
		ArrayList<Evento> listaEventos = EventosDAO.getAllEventos();
		listaEventos.forEach(evento -> {
			cmbmEv.addElement(evento);
		});
		cmbEventos = new JComboBox<Evento>(cmbmEv);
		pnlParametros.add(cmbEventos);
		
		pnlParametros.add(new JLabel("Deportista" ,SwingConstants.CENTER));
		DefaultComboBoxModel<Deportista> cmbmDe = new DefaultComboBoxModel<Deportista>();
		ArrayList<Deportista> listaDeportistas = DeportistasDAO.getAllDeportistas();
		listaDeportistas.forEach(deportista -> {
			cmbmDe.addElement(deportista);
		});
		cmbDeportistas = new JComboBox<Deportista>(cmbmDe);
		pnlParametros.add(cmbDeportistas);
		
		pnlParametros.add(new JLabel("Equipo" ,SwingConstants.CENTER));
		DefaultComboBoxModel<Equipo> cmbmEq = new DefaultComboBoxModel<Equipo>();
		ArrayList<Equipo> listaEquipos = EquiposDAO.getAllEquipos();
		listaEquipos.forEach(equipo-> {
			cmbmEq.addElement(equipo);
		});
		cmbEquipos = new JComboBox<Equipo>(cmbmEq);
		pnlParametros.add(cmbEquipos);
		
		// Los dibujamos
		for(String label: mapaParametros.keySet()) {
			pnlParametros.add(new JLabel(label,SwingConstants.CENTER));
			pnlParametros.add(mapaParametros.get(label));
		}
		// A�adir los 3 botones y el JList
		JPanel pnlBotones = new JPanel();
		pnlBotones.add(btnAniadir);
		pnlBotones.add(btnModificar);
		pnlBotones.add(btnEliminar);
		pnlActual.add(pnlBotones, BorderLayout.SOUTH);
	
		repaint();
		revalidate();
	}
	// TODO: Panel participaciones
	private void escucharPanelParticipacion() {
		removeAllActionListeners(btnAniadir);
		removeAllActionListeners(btnEliminar);
		removeAllActionListeners(btnModificar);
	}
	
	private void removeAllActionListeners(JButton btn) {
		for( ActionListener al : btn.getActionListeners() ) {
			btn.removeActionListener( al );
		}
		
	}
	private void habilitarBotones() {
		btnDeporte.setEnabled(true);
		btnDeportista.setEnabled(true);
		btnEquipo.setEnabled(true);
		btnOlimpiada.setEnabled(true);
		btnEvento.setEnabled(true);
		btnParticipacion.setEnabled(true);
	}
	
	private void mensajeErrorVacio() {
		JOptionPane.showMessageDialog(null, "Por favor, rellena todos los valores!!!");
	}
	
	private void mensajeError() {
		JOptionPane.showMessageDialog(null, "Error generico.");
	}
	
	private void mensajeErrorBorrar() {
		JOptionPane.showMessageDialog(null, "Imposible de eliminar!!!");
	}
	public static void main(String[] args) {
		new VentanaPrincipal();
	}
	
}
