

public class Criptografia {

	private static final int NUMERO_DE_lETRAS = 27;
	private String frase;
	
	
	


	public void setFrase(String frase) {
		if (frase.length() % 2 == 0) {
			this.frase = frase;
		} else {
			frase += ' ';
			this.frase = frase;
		}
	}

	
	public String getFraseCodificada() {
		return getFraseCodificadaOrDecodificada(this.frase, 8,3,5,2);
	}
	
	public String DecodificaFrase(String frase) {
		return getFraseCodificadaOrDecodificada(frase,2,(-3),(-5),8);
	}
	
	private String getFraseCodificadaOrDecodificada(String frase,int a11,int a12,int a21, int a22) {
		char[] arrayFrase = frase.toCharArray();
		char[] letras = { 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', ' ' };

		String codificada = "";
		
		for (int i = 0; i < arrayFrase.length; i += 2) {
			
			char letra1 = arrayFrase[i];
			char letra2 = arrayFrase[i + 1];
			int num1 = 0;
			int num2 = 0;
			
			for (int f = 0; f < letras.length; f++) {
				if (letras[f] == letra1) {
					num1 = f;
					break;
				}
			}

			for (int j = 0; j < letras.length; j++) {
				if (letras[j] == letra2) {
					num2 = j;
					break;
				}
			}
			
			
			int result1 = (a11 * num1)+ (a12*num2);
			int result2  = (a21 * num1)+ (a22*num2);
			
			result1 = getIndice(result1);
			result2 = getIndice(result2);
		
			codificada +=  letras[result1];
			codificada += letras[result2];
		}
	
		return codificada;

	}
	
	
	private int getIndice(int num) {
		if ( num >= NUMERO_DE_lETRAS) {
			num = num % NUMERO_DE_lETRAS;
		}else if (num < 0) {
			num = NUMERO_DE_lETRAS + ( num % NUMERO_DE_lETRAS);
		}
		return num;
	}
}
