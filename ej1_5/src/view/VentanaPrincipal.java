package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class VentanaPrincipal extends JFrame {
	
	private JButton btnDeporte, btnDeportista, btnEquipo, btnEvento, btnOlimpiada, btnParticipacion;
	private JButton btnAniadir, btnModificar, btnEliminar;
	private JPanel panelDatos;
	private JList listaDatos;
	private ListModel modeloLista;
	public VentanaPrincipal() {
		draw();
		listen();
		setSize(500, 500);
		setVisible(true);
	}
	
	private void draw() {
		this.getContentPane().setLayout(new GridLayout(0, 1));
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
	}
	
	private void listen() {
		btnDeporte.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				habilitarBotones();
				btnDeporte.setEnabled(false);
				
			}
			
		});
		
		btnDeportista.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				habilitarBotones();
				btnDeportista.setEnabled(false);
				
			}
			
		});
		
		btnEquipo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				habilitarBotones();
				btnEquipo.setEnabled(false);
				
			}
			
		});
		btnDeporte.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				habilitarBotones();
				btnDeporte.setEnabled(false);
				
			}
			
		});
		
		btnOlimpiada.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				habilitarBotones();
				btnOlimpiada.setEnabled(false);
				
			}
			
		});
		
		btnEvento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				habilitarBotones();
				btnEvento.setEnabled(false);
				
			}
			
		});
		
		btnParticipacion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				habilitarBotones();
				btnParticipacion.setEnabled(false);
				
			}
			
		});
		
	}
	
	private void habilitarBotones() {
		btnDeporte.setEnabled(true);
		btnDeportista.setEnabled(true);
		btnEquipo.setEnabled(true);
		btnOlimpiada.setEnabled(true);
		btnEvento.setEnabled(true);
		btnParticipacion.setEnabled(true);
	}
	
	public static void main(String[] args) {
		new VentanaPrincipal();
	}
	
}
