import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaConversorDolares4 extends JFrame {

	private JPanel contentPane;
	private JTextField valorEuros;
	private JTextField valorMoneda;
	private JTextField mensajeControl;
	
	private static String seleccion;

	/**
	 * Create the frame.
	 */
	public VentanaConversorDolares4() {
		setTitle("Conversor Divisas 4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEuros = new JLabel("Euros");
		lblEuros.setBounds(33, 63, 59, 20);
		contentPane.add(lblEuros);
		
		JLabel lblTexto1 = new JLabel("Introduzca importe para convertir");
		lblTexto1.setBounds(33, 26, 199, 14);
		contentPane.add(lblTexto1);
		
		valorEuros = new JTextField();
		valorEuros.setBounds(146, 63, 86, 20);
		contentPane.add(valorEuros);
		valorEuros.setColumns(10);
		
		mensajeControl = new JTextField();
		mensajeControl.setBounds(33, 229, 268, 20);
		contentPane.add(mensajeControl);
		mensajeControl.setColumns(10);
		mensajeControl.setBackground(Color.yellow);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				seleccion = String.valueOf(comboBox.getSelectedItem());
				mensajeControl.setText("MONEDA SELECCIONADA: "+seleccion);
				
			}
		});
		comboBox.setBounds(33, 116, 86, 20);
		contentPane.add(comboBox);
		
		String tiposMoneda[] = DatosGenerales.getTiposMoneda();
		
		
		for(int a=0;a<tiposMoneda.length;a++){
			comboBox.addItem(tiposMoneda[a]);
		}
		
		
		valorMoneda = new JTextField();
		valorMoneda.setBounds(146, 116, 86, 20);
		contentPane.add(valorMoneda);
		valorMoneda.setColumns(10);
		
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String euroString = valorEuros.getText();
				
				if(esNumerico(euroString)==false){
					mensajeControl.setText("VALORES NO NUMÉRICOS");
				}
				else{
					float euros = Float.parseFloat(euroString);
					if(euros<0 || euros >500){
						mensajeControl.setText("VALORES INCORRECTOS");
					}
					else{
						float vcd = DatosGenerales.getVcDolares();
						float vcl = DatosGenerales.getVcLibras();
						float vcy = DatosGenerales.getVcYens();
						
						switch(seleccion){
							case "DOLARES":
								valorMoneda.setText(String.valueOf(euros*vcd));
								mensajeControl.setText("TODO OK¡");
								break;
							case "LIBRAS":
								valorMoneda.setText(String.valueOf(euros*vcl));
								mensajeControl.setText("TODO OK¡");
								break;
							case "YENS":
								valorMoneda.setText(String.valueOf(euros*vcy));
								mensajeControl.setText("TODO OK¡");
								break;
						}
					}
				}
				
			}
		});
		btnConvertir.setBounds(322, 228, 89, 23);
		contentPane.add(btnConvertir);
		
		JLabel lblTexto2 = new JLabel("MENSAJE DE CONTROL");
		lblTexto2.setBounds(34, 204, 138, 14);
		contentPane.add(lblTexto2);
		
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
