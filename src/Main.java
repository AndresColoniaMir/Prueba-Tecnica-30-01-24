public class Main {

    // Crear un funcion que se llame decipher que funcione de la siguinte manera
    // 1. Como argumento recive dos String el priemero una cadena cifrada y la segunda una palabra conocida
    // 2. El cifrado de la cadena funciona de la siguiente manera cada letra se mueve dos espacios ejemplo love =
    // 3. La palabra conocida es una palabra que posiblemente este en el mensaje una ves decifrado
    // 4. la funcion deve retornar el mensaje decifrado si contiene la palabra conocida de lo contario retorna el String "Invalid"
    // 5. deben de respetarce los espacios, simbolos y puntuacion.
    // 6. antes de 'a' o 'A' esta la 'z' o 'Z' y viceversa.
    public static void main(String[] args) {
        String ciphertext = "!Gn rgttq gu coctknnq.";
        String knownWord = "perro";
        String decryptedText = decipher(ciphertext, knownWord);
        System.out.println("Resultado: " + decryptedText);

    }

    public static String decipher(String ciphertext, String knownWord){
        StringBuilder decryptedText = new StringBuilder();
        for(int i = 0; i < ciphertext.length(); i++){
            char encryptedCharacter = ciphertext.charAt(i);
            if (Character.isLetter(encryptedCharacter)){
                if (Character.isLowerCase(encryptedCharacter)) {
                    char decryptedCharacter = (char) (((encryptedCharacter - 'a' - 2 + 26) % 26) + 'a');
                    decryptedText.append(decryptedCharacter);
                } else if (Character.isUpperCase(encryptedCharacter)){
                    char decryptedCharacter = (char) (((encryptedCharacter - 'A' - 2 + 26) % 26) + 'A');
                    decryptedText.append(decryptedCharacter);
                }
            } else {
                decryptedText.append(encryptedCharacter);
            }
        }
        if (decryptedText.toString().contains(knownWord)){
            return decryptedText.toString();
        } else {
            return "Invalid";
        }
    }

}