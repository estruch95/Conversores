import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class VentanaConversorMejorado extends JFrame {

	private JPanel contentPane;
	private JTextField valorEuros;
	private JTextField valorDolares;
	private JTextField mensajeControl;

	/**
	 * Create the frame.
	 */
	public VentanaConversorMejorado(float valorConversion) {
		setTitle("Conversor de divisas mejorado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEuros = new JLabel("Euros \u20AC");
		lblEuros.setBounds(35, 95, 46, 14);
		contentPane.add(lblEuros);
		
		JLabel lblDlares = new JLabel("D\u00F3lares $");
		lblDlares.setBounds(35, 158, 65, 14);
		contentPane.add(lblDlares);
		
		valorEuros = new JTextField();
		valorEuros.setBounds(117, 92, 86, 20);
		contentPane.add(valorEuros);
		valorEuros.setColumns(10);
		
		valorDolares = new JTextField();
		valorDolares.setBounds(117, 155, 86, 20);
		contentPane.add(valorDolares);
		valorDolares.setColumns(10);
		
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				float euros;
				String valor = (valorEuros.getText());
				
				if(esNumerico(valor)==true){
					euros = Float.parseFloat(valor);
					
					if(euros < 0 || euros > 500){
						mensajeControl.setText("VALORES INCORRECTOS");
					}
					else{
						valorDolares.setText(String.valueOf(euros*valorConversion));
					}	
				}
				else{
					mensajeControl.setText("VALORES NO NUMÉRICOS");
				}
					
			}
		});
		btnConvertir.setBounds(316, 228, 89, 23);
		contentPane.add(btnConvertir);
		
		JLabel lblTexto = new JLabel("Introduzca importe a convertir (Entre 0 y 500 \u20AC)");
		lblTexto.setBounds(34, 28, 282, 14);
		contentPane.add(lblTexto);
		
		JLabel lblTexto2 = new JLabel("MENSAJE DE CONTROL");
		lblTexto2.setBounds(35, 202, 144, 14);
		contentPane.add(lblTexto2);
		
		mensajeControl = new JTextField();
		mensajeControl.setBounds(29, 229, 259, 20);
		contentPane.add(mensajeControl);
		mensajeControl.setColumns(10);
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
