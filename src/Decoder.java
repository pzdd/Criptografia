import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;


public class Decoder {
	
	private String nomeArquivo;
	private String nomeArquivoSaida;
	private String contextFile;

	/**
	 *@param nomeArquivo
	 *nome do arquivo a ser lido
	 *@param nomeArquivoSaida
	 *nome do arquivo aonde será gravado os dados de saida
	 *@param contextFile
	 *caminho do arquivo
	 **/
	public Decoder(String nomeArquivo, String nomeArquivoSaida,String contextFile){
		this.nomeArquivo = nomeArquivo;
		this.nomeArquivoSaida = nomeArquivoSaida;
		this.contextFile = contextFile;
	}
	
	public void GenerateFileCripto(){
		try{
			//ler o arquivo desejado
			//String path = "C:/Users/Geraldo/Downloads/teste.txt";
			StringBuilder sb = new StringBuilder();
			String path = getContextFile()+getNomeArquivo();
			BufferedReader lerArq = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
			
			String linha = lerArq.readLine();
			while(linha != null){
				sb.append(linha);
				sb.append("\n");
				linha = lerArq.readLine();
			}
			lerArq.close();
			
			//encripta os dados lidos
			Criptografia crip = new Criptografia();
			String aux = crip.Cripto(sb.toString());
			//gravando em um arquivo os dados encriptados
			FileWriter arq = new FileWriter(getContextFile()+getNomeArquivoSaida());
			PrintWriter pwrite = new PrintWriter(arq);
			pwrite.println(aux);
			pwrite.close();
			System.out.println("Sucessfully!");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void ReadFileDecript(){
		try{
			Criptografia crip = new Criptografia();
			BufferedReader ler = new BufferedReader(new InputStreamReader(new FileInputStream(getContextFile()+getNomeArquivoSaida()), "UTF-8"));
			String l = ler.readLine();
			StringBuilder sb2 = new StringBuilder();
			while(l != null){
				sb2.append(l);
				l = ler.readLine();
			}
			ler.close();
			System.out.println("Texto decriptado: ");
			System.out.println(new String(crip.Decripto(sb2.toString()).getBytes(),Charset.forName("UTF-8")));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	public String getNomeArquivo() {
		return nomeArquivo;
	}
	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	public String getNomeArquivoSaida() {
		return nomeArquivoSaida;
	}
	public void setNomeArquivoSaida(String nomeArquivoSaida) {
		this.nomeArquivoSaida = nomeArquivoSaida;
	}
	public String getContextFile() {
		return contextFile;
	}
	public void setContextFile(String contextFile) {
		this.contextFile = contextFile;
	}

}
