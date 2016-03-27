


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Decoder dec = new Decoder("pp.txt", "criptado.txt", "C:\\Users\\Geraldo\\Downloads\\");
		dec.GenerateFileCripto();
		dec.ReadFileDecript();
	}
}
