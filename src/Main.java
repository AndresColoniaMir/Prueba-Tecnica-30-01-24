public class Main {


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