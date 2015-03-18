package unip.programa.grafico;

/**
 * Classe responsável por criar Frame
 */
/**
 * @author Eduardo de G. Ferrari 
 *
 */

import javax.swing.JFrame;
import java.awt.Color;

public class JanelaEntrada {

	private JFrame frame;

	public JanelaEntrada() {
		inicializar();
		// frame.setBounds(300,300,500,600);
		frame.setBackground(Color.WHITE);
		frame.setSize(500, 600);
		frame.setLocationRelativeTo(null);
	}

	private void inicializar() {
		frame = new JFrame("MICO");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// frame.add(painelPrincipal);
		frame.add(new Painel(frame).painelPrincipal());
	}

}

