import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;


public class Cliente {
	

	private Socket skCliente;
	public Cliente()
	{
	   run();
	}
    public void run() {
    	try {
			skCliente =  new Socket("127.0.0.1",8627); 
		    Scanner teclado = new Scanner(System.in);
		    PrintStream saida = new PrintStream(skCliente.getOutputStream());
		   
		    while(teclado.hasNextLine())
		    {
		    	   
		    	saida.println(teclado.nextLine());
		    	System.out.println("OK");
		    }
		    saida.close();
		    teclado.close();
		    skCliente.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	   
	}
}
