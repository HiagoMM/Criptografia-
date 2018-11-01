import java.util.Scanner;

public class App {
	private static Scanner teclado;

	public static void main(String[] args) {

	teclado = new Scanner(System.in);
	System.out.println("Digite a frase:");
	String frase = teclado.nextLine();
	Criptografia criptografia = new Criptografia();
	criptografia.setFrase(frase);
	
	System.out.println(criptografia.getFraseCodificada());
	System.out.println(criptografia.DecodificaFrase(criptografia.getFraseCodificada()));
	}

}
