import java.io.UnsupportedEncodingException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;


public class Criptografia {
	
	private Cipher chiper = null;
	
	private byte [] key = "chave de 16bytes".getBytes();
	
	public Criptografia(){
		try{
			chiper = Cipher.getInstance("AES/ECB/PKCS5Padding");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public String Cripto(String mensagem){
		byte [] msg = null;
		try{
			msg = mensagem.getBytes("UTF-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		byte [] encrypted = null;
		try{
			chiper.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"));
			encrypted = chiper.doFinal(msg);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return DatatypeConverter.printBase64Binary(encrypted);
	}
	
	public String Decripto(String msgEncr){
		byte [] msg = null;
		msg = DatatypeConverter.parseBase64Binary(msgEncr);
		byte [] decrypted = null;
		try{
			chiper.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"));
			decrypted = chiper.doFinal(msg);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return new String(decrypted);
	}

}
