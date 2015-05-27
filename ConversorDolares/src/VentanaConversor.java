import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaConversor extends JFrame {

	private JPanel contentPane;
	private JTextField valorEuros;
	private JTextField valorDolares;

	/**
	 * Create the frame.
	 */
	public VentanaConversor(float valorConversion) {
		setTitle("Conversor de divisas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEuros = new JLabel("Euros \u20AC");
		lblEuros.setBounds(39, 82, 46, 14);
		contentPane.add(lblEuros);
		
		JLabel lblDlares = new JLabel("D\u00F3lares $");
		lblDlares.setBounds(39, 146, 61, 14);
		contentPane.add(lblDlares);
		
		valorEuros = new JTextField();
		valorEuros.setBounds(110, 79, 86, 20);
		contentPane.add(valorEuros);
		valorEuros.setColumns(10);
		
		valorDolares = new JTextField();
		valorDolares.setBounds(110, 143, 86, 20);
		contentPane.add(valorDolares);
		valorDolares.setColumns(10);
		
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				float euros;
				euros = Float.parseFloat(valorEuros.getText());
				valorDolares.setText(String.valueOf(euros*valorConversion));
				
			}
		});
		btnConvertir.setBounds(315, 228, 89, 23);
		contentPane.add(btnConvertir);
		
		JLabel lblTexto = new JLabel("Introduzca importe para convertir:");
		lblTexto.setBounds(39, 28, 201, 14);
		contentPane.add(lblTexto);
	}
}
