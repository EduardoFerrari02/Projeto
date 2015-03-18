package unip.programa.config;

/**
 * Classe responsável 
 */
/**
 * @author Eduardo de G. Ferrari 
 *
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

	private final String caminhoArquivo = "./config/config.properties";

	private final String gravaSenhakey = "gravaSenha";
	private final String usuarioAutomaticokey = "entraAutomatico";

	private final String loginKey = "login";
	private final String senhaKey = "senha";

	private String login;
	private String senha;
	private boolean gravaSenha;
	private boolean entraAutomatico;
	private static Config instance;

	private Config() {
		ler();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
		salvar();
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
		salvar();
	}

	public boolean getGravasenha() {
		return gravaSenha;
	}

	public void setGravasenha(boolean gravaSenha) {
		this.gravaSenha = gravaSenha;
		salvar();
	}

	public boolean getEntraautomatico() {
		return entraAutomatico;
	}

	public void setEntraautomatico(boolean entraAutomatico) {
		this.entraAutomatico = entraAutomatico;
		salvar();
	}

	public static Config getConfig() {

		if (instance == null) {
			instance = new Config();
		}
		return instance;
	}

	private void ler() {
		Properties propri = new Properties();
		try {
			FileInputStream arquivo = new FileInputStream(caminhoArquivo);
			propri.load(arquivo);

			gravaSenha = Boolean.valueOf(propri.getProperty(gravaSenhakey));
			entraAutomatico = Boolean.valueOf(propri
					.getProperty(usuarioAutomaticokey));

			login = propri.getProperty(loginKey);
			senha = propri.getProperty(senhaKey);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void salvar() {
		Properties propri = new Properties();
		propri.setProperty(gravaSenhakey, "" + gravaSenha);
		propri.setProperty(usuarioAutomaticokey, "" + entraAutomatico);

		propri.setProperty(loginKey, login);
		propri.setProperty(senhaKey, senha);

		try {
			FileOutputStream arquivo = new FileOutputStream(caminhoArquivo);
			propri.store(arquivo, "");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
