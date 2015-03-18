
package unip.programa.cript;
/**
 * 
 *
 * @author Eduardo de G. Ferrari
 */
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.Cipher;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.crypto.NoSuchPaddingException;


public  class Criptografia {

	private static Criptografia instance;
	private String IV = "AAAAAAAAAAAAAAAA";
	private String chaveCript = "9923458717abcdee";
	private Cipher cipher;
	private SecretKeySpec  chave;
	private Criptografia()
	{
		inicializar();
	}
	private void inicializar()
	{
		try
		{
		 cipher = Cipher.getInstance("AES/CBC/PKCS5Padding","SunJCE");
		 chave = new SecretKeySpec(chaveCript.getBytes("UTF-8"), "AES");
		
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		catch(NoSuchProviderException e) {
			e.printStackTrace();
		}
		catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static Criptografia getInstance()
	{
		if(instance == null)
		{
			instance = new Criptografia();
			
		}
		return instance;
	}
	public byte[] criptografar(String texto)
	{
	    byte[] textoCript = null ;
		try
		{
		cipher.init(Cipher.ENCRYPT_MODE,chave,new IvParameterSpec(IV.getBytes("UTF-8")));
		textoCript = cipher.doFinal(texto.getBytes("UTF-8"));
		}catch(UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		catch(InvalidKeyException e)
		{
			e.printStackTrace();
		}
		catch(InvalidAlgorithmParameterException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	 return textoCript;
	}
	
	public String descriptografar(byte[] vByte) 
	{
		String texto = null;
		try
		{
		 cipher.init(Cipher.DECRYPT_MODE, chave,new IvParameterSpec(IV.getBytes("UTF-8"))); 
		texto =  new String(cipher.doFinal(vByte),"UTF-8");
        }catch(UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		catch(InvalidKeyException e)
		{
			e.printStackTrace();
		}
		catch(InvalidAlgorithmParameterException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return texto;
	}
}
