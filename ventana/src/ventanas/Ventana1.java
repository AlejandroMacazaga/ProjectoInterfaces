package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JButton;

public class Ventana1 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana1 window = new Ventana1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {105, 105, 105, 105};
		gridBagLayout.rowHeights = new int[] {20, 20, 20, 20, 0, 20, 20, 0, 20, 20, 20};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE, 0.0, 0.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblProfesion = new JLabel("Profesion:");
		lblProfesion.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblProfesion = new GridBagConstraints();
		gbc_lblProfesion.anchor = GridBagConstraints.EAST;
		gbc_lblProfesion.fill = GridBagConstraints.VERTICAL;
		gbc_lblProfesion.insets = new Insets(0, 0, 5, 5);
		gbc_lblProfesion.gridx = 0;
		gbc_lblProfesion.gridy = 0;
		frame.getContentPane().add(lblProfesion, gbc_lblProfesion);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNHermanos = new JLabel("Nº Hermanos:");
		lblNHermanos.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNHermanos = new GridBagConstraints();
		gbc_lblNHermanos.insets = new Insets(0, 0, 5, 5);
		gbc_lblNHermanos.gridx = 0;
		gbc_lblNHermanos.gridy = 1;
		frame.getContentPane().add(lblNHermanos, gbc_lblNHermanos);
		
		JSpinner spinnerNHermanos = new JSpinner();
		GridBagConstraints gbc_spinnerNHermanos = new GridBagConstraints();
		gbc_spinnerNHermanos.anchor = GridBagConstraints.WEST;
		gbc_spinnerNHermanos.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerNHermanos.gridx = 1;
		gbc_spinnerNHermanos.gridy = 1;
		frame.getContentPane().add(spinnerNHermanos, gbc_spinnerNHermanos);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblEdad = new GridBagConstraints();
		gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdad.anchor = GridBagConstraints.EAST;
		gbc_lblEdad.gridx = 2;
		gbc_lblEdad.gridy = 1;
		frame.getContentPane().add(lblEdad, gbc_lblEdad);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Menores de 18", "Entre 18 y 30", "Entre 31 y 50", "Entre 51 y 70", "Mayores de 70"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 1;
		frame.getContentPane().add(comboBox, gbc_comboBox);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(99, 130, 191)), "Sexo", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		frame.getContentPane().add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JRadioButton rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setSelected(true);
		panel.add(rdbtnHombre);
		
		JRadioButton rdbtnMujer = new JRadioButton("Mujer");
		panel.add(rdbtnMujer);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Practicas Algun Deporte?");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.gridwidth = 2;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 0;
		gbc_chckbxNewCheckBox.gridy = 3;
		frame.getContentPane().add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u00BFC\u00FAal?", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 3;
		frame.getContentPane().add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Tenis", "Fútbol", "Baloncesto", "Natación", "Ciclismo", "Otro"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel_1.add(list);
		
		JLabel lblAficion = new JLabel("Marque del 1 al 10 su grado de aficion a:");
		lblAficion.setFont(new Font("Dialog", Font.BOLD, 12));
		GridBagConstraints gbc_lblAficion = new GridBagConstraints();
		gbc_lblAficion.insets = new Insets(0, 0, 5, 0);
		gbc_lblAficion.gridwidth = 4;
		gbc_lblAficion.gridx = 0;
		gbc_lblAficion.gridy = 4;
		frame.getContentPane().add(lblAficion, gbc_lblAficion);
		
		JLabel lblNewLabel = new JLabel("Compras:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 5;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JSlider slider = new JSlider();
		GridBagConstraints gbc_slider = new GridBagConstraints();
		gbc_slider.fill = GridBagConstraints.HORIZONTAL;
		gbc_slider.gridwidth = 3;
		gbc_slider.insets = new Insets(0, 0, 5, 0);
		gbc_slider.gridx = 1;
		gbc_slider.gridy = 5;
		frame.getContentPane().add(slider, gbc_slider);
		
		JLabel lblNewLabel_1 = new JLabel("Ver television:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 6;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JSlider slider_1 = new JSlider();
		GridBagConstraints gbc_slider_1 = new GridBagConstraints();
		gbc_slider_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_slider_1.gridwidth = 3;
		gbc_slider_1.insets = new Insets(0, 0, 5, 0);
		gbc_slider_1.gridx = 1;
		gbc_slider_1.gridy = 6;
		frame.getContentPane().add(slider_1, gbc_slider_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ir al cine:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 7;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JSlider slider_2 = new JSlider();
		GridBagConstraints gbc_slider_2 = new GridBagConstraints();
		gbc_slider_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_slider_2.gridwidth = 3;
		gbc_slider_2.insets = new Insets(0, 0, 5, 0);
		gbc_slider_2.gridx = 1;
		gbc_slider_2.gridy = 7;
		frame.getContentPane().add(slider_2, gbc_slider_2);
		
		JButton btnAceptar = new JButton("Aceptar");
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 8;
		frame.getContentPane().add(btnAceptar, gbc_btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 2;
		gbc_btnCancelar.gridy = 8;
		frame.getContentPane().add(btnCancelar, gbc_btnCancelar);
	}

}
