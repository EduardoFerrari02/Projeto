package unip.programa.grafico;

/**
 * Classe responsável por moldar os Paineis
 *
 * @author Wanderson Santiago ,Jefferson Luperini
 */
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import unip.programa.config.Config;

public class Painel {

	private Color corFundo = Color.WHITE;

	private JFrame frame;

	public Painel(JFrame frame) {

		this.frame = frame;
	}

	/**
	 * Metodo que desenha o painel Login.
	 *
	 */
	private JPanel menuLogin() {

		JPanel painelLogin = new JPanel();

		JLabel lEnd = new JLabel("Endereco:");
		JLabel lExemploEmail = new JLabel(
				"Exemplos: ciencia_da_computacao@unip.com.br");
		JLabel lSenha = new JLabel("Senha:");
		JLabel lnovoCadastro = new JLabel("Ainda não e cadastrado?");
		JLabel novoCadastro = new JLabel("Clique Aqui");
		novoCadastro.setForeground(Color.BLUE);

		JTextField textLogin = new JTextField(20);

		JPasswordField password = new JPasswordField(8);

		JButton bEntrar = new JButton("Entrar");
		JCheckBox gravarSenha = new JCheckBox("Gravar minha Senha");
		gravarSenha.setBackground(corFundo);

		JCheckBox entrarAutomatic = new JCheckBox("Entrar Automaticamente");

		entrarAutomatic.setBackground(corFundo);

		painelLogin.setLayout(new GridLayout(11, 1));
		painelLogin.setOpaque(false);

		JPanel painelBotao = new JPanel();
		painelBotao.setLayout(new FlowLayout(1));
		painelBotao.setBackground(corFundo);
		painelBotao.add(bEntrar);

		painelLogin.add(lEnd);
		painelLogin.add(textLogin);
		painelLogin.add(lExemploEmail);
		painelLogin.add(lSenha);
		painelLogin.add(password);
		painelLogin.add(painelBotao);
		painelLogin.add(gravarSenha);
		painelLogin.add(entrarAutomatic);
		painelLogin.add(lnovoCadastro);
		painelLogin.add(novoCadastro);

		painelLogin.setVisible(true);
		// Border borda;
		// borda = BorderFactory.createLineBorder(Color.black,1);

		entrarAutomatic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("automatico");
			}
		});
		gravarSenha.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("senha gravada");

			}
		});

		/*
		 * bCadastrar.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * System.out.println("cadastro");
		 * 
		 * } });
		 */

		bEntrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//frame.setSize(1000, 1000);
              
			  
			}
		});
		return painelLogin;
	}

	/*
	 * public JPanel menuCadastrar() { return }
	 */
	/*
	 * public JPanel painelLogo() { return }
	 */
	public JPanel painelPrincipal() {

		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setLayout(new FlowLayout(1));

		Icon icon = new ImageIcon(getClass().getResource("micoleao.png"));
		JLabel img = new JLabel(icon, JLabel.CENTER);
		painelPrincipal.setBackground(Color.WHITE);
		painelPrincipal.add(img);
		painelPrincipal.add(menuLogin());
		return painelPrincipal;
	}

	private void eventoBotao() {
		/*
		 * bEntrar.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * System.out.println("TESTE"); } });
		 */
	}
}
