package view;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
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
		panelBotones.setLayout(new FlowLayout());
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
		pnlActual.add(new JLabel("Deportista"));
		 
		
		
		repaint();
		revalidate();
	}
	
	private void escucharPanelDeportista() {
		removeAllActionListeners(btnAniadir);
		removeAllActionListeners(btnEliminar);
		removeAllActionListeners(btnModificar);
	}
	
	private void dibujarPanelEquipo() {
		pnlActual.removeAll();
		mdl = new DefaultListModel<Equipo>();
		ArrayList<Equipo> listaEquipos = EquiposDAO.getAllEquipos();
		listaEquipos.forEach(equipo -> {
			mdl.addElement(equipo);
		});
		lst = new JList<Equipo>(mdl);
		pnlActual.add(new JLabel("Equipo"));
		
		
		
		
		repaint();
		revalidate();
	}
	
	private void escucharPanelEquipo() {
		removeAllActionListeners(btnAniadir);
		removeAllActionListeners(btnEliminar);
		removeAllActionListeners(btnModificar);
	}
	
	private void dibujarPanelOlimpiada() {
		pnlActual.removeAll();
		mdl = new DefaultListModel<Olimpiada>();
		ArrayList<Olimpiada> listaOlimpiadas = OlimpiadasDAO.getAllOlimpiadas();
		listaOlimpiadas.forEach(olimpiada -> {
			mdl.addElement(olimpiada);
		});
		lst = new JList<Olimpiada>(mdl);
		pnlActual.add(new JLabel("Olimpiada"));
		
		
		
		
		repaint();
		revalidate();
	}
	
	private void escucharPanelOlimpiada() {
		removeAllActionListeners(btnAniadir);
		removeAllActionListeners(btnEliminar);
		removeAllActionListeners(btnModificar);
	}
	
	private void dibujarPanelEvento() {
		pnlActual.removeAll();
		mdl = new DefaultListModel<Evento>();
		ArrayList<Evento> listaEventos = EventosDAO.getAllEventos();
		listaEventos.forEach(evento -> {
			mdl.addElement(evento);
		});
		lst = new JList<Evento>(mdl);
		pnlActual.add(new JLabel("Evento"));
		
		
		
		repaint();
		revalidate();
	}
	
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
		pnlActual.add(new JLabel("Participacion"));
		
		
		
		
		repaint();
		revalidate();
	}
	
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
	
	private void mensajeErrorBorrar() {
		JOptionPane.showMessageDialog(null, "Imposible de eliminar!!!");
	}
	public static void main(String[] args) {
		new VentanaPrincipal();
	}
	
}
