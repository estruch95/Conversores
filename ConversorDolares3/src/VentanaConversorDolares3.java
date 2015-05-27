import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class VentanaConversorDolares3 extends JFrame {

	private JPanel contentPane;
	private JTextField valorEuros;
	private JTextField valor;
	private JTextField mensajeControl;

	private static String seleccion;
	private static float euros;

	/**
	 * Create the frame.
	 */
	public VentanaConversorDolares3(float valorConversionDolares, float valorConversionLibras, float valorConversionYens) {
		setTitle("Conversor Divisas 3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEuros = new JLabel("Euros");
		lblEuros.setBounds(29, 50, 46, 14);
		contentPane.add(lblEuros);
		
		valorEuros = new JTextField();
		valorEuros.setBounds(127, 47, 86, 20);
		contentPane.add(valorEuros);
		valorEuros.setColumns(10);
		
		valor = new JTextField();
		valor.setBounds(127, 108, 86, 20);
		contentPane.add(valor);
		valor.setColumns(10);
		
		JLabel lblTexto2 = new JLabel("MENSAJE DE CONTROL");
		lblTexto2.setBounds(29, 201, 214, 14);
		contentPane.add(lblTexto2);
		
		mensajeControl = new JTextField();
		mensajeControl.setBounds(29, 226, 269, 20);
		contentPane.add(mensajeControl);
		mensajeControl.setColumns(10);
		mensajeControl.setBackground(Color.yellow);
		
		JLabel lblTexto1 = new JLabel("Introduzca importe a convertir:");
		lblTexto1.setBounds(29, 11, 229, 14);
		contentPane.add(lblTexto1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				seleccion = String.valueOf(comboBox.getSelectedItem());
				mensajeControl.setText("SELECCIONADA LA MONEDA:	"+seleccion);
			}
		});
		comboBox.setBounds(22, 108, 95, 20);
		contentPane.add(comboBox);
		
		comboBox.addItem("DOLARES");
		comboBox.addItem("LIBRAS");
		comboBox.addItem("YENS");
		
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String euroString = valorEuros.getText();
				
				if(esNumerico(euroString)==true){
					euros = Float.parseFloat(euroString);
					if(euros<0 || euros>500){
						mensajeControl.setText("VALORES INCORRECTOS");
					}
					else{
						
						switch(seleccion){
						case "DOLARES":
							euros = Float.parseFloat(valorEuros.getText());
							valor.setText(String.valueOf(euros*valorConversionDolares));
							break;
						case "LIBRAS":
							euros = Float.parseFloat(valorEuros.getText());
							valor.setText(String.valueOf(euros*valorConversionLibras));
							break;
						case "YENS":
							euros = Float.parseFloat(valorEuros.getText());
							valor.setText(String.valueOf(euros*valorConversionYens));
							break;
						}
						mensajeControl.setText("TODO OK¡");
					}
				}
				else{
					mensajeControl.setText("VALORES NO NUMÉRICOS");
				}
				
				
					
				
				
			}
		});
		btnConvertir.setBounds(321, 225, 89, 23);
		contentPane.add(btnConvertir);
	}
	
	public static boolean esNumerico(String valor){
		try{
			Integer.parseInt(valor);
			return true;
		}
		catch(NumberFormatException nfe){
			return false;
		}
	}
	
}
