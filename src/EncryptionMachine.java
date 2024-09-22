import java.util.Scanner;

/**
 * This code implements a basic Caesar Cipher for encrypting messages.
 * It prompts the user for a key and a message,
 * encrypts the message using the provided key,and displays the resulting ciphertext
 */
public class EncryptionMachine {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final int SHIFT = 3;

    /**
     * Encrypts a single letter based on the provided shift=3.
     * Returns an encrypted param letter
     */
    public static char encryptLetter(char letter) {
        int letter_index = ALPHABET.indexOf(letter);
        if (letter_index == -1) {
            return letter;
        }
        int letter_newIndex = (letter_index + SHIFT) % ALPHABET.length();
        return ALPHABET.charAt(letter_newIndex);
    }

    /**
     * Encrypts a word by encrypting each letter.
     * Returns an encrypted param word
     */
    public static String encryptWord(String word) {
        StringBuilder encryptedWord = new StringBuilder();
        char [] letters = word.toCharArray();
        for (char letter : letters) {
            encryptedWord.append(encryptLetter(letter));
        }
        return encryptedWord.toString();
    }

    // accepts user inputs and prints encrypted word.

   public static void runEncryption() {
       Scanner scanner = new Scanner(System.in);

       System.out.println("Welcome to the CSCI717 Encryption Machine Construction\nThe program lets you encrypt a message\nwith a key for your recipient to decrypt!");

       //Request User for key
       System.out.print("Enter key:\n");
       String key = scanner.nextLine();
       String encryptedKey = encryptWord(key);
       System.out.println("\"" + key + "\" has been encrypted to: " + encryptedKey);

       // Request for the number of words to be encrypted
       System.out.print("How many words is your message?:\n");
       int numberOfWords = scanner.nextInt();
       scanner.nextLine();

       for (int i = 0; i < numberOfWords; i++) {
           System.out.print("Next word: \n");
           String word = scanner.nextLine();
           String encryptedWord = encryptWord(word);
           System.out.println("\"" + word + "\" has been encrypted to: " + encryptedWord);
       }

       System.out.println("Message fully encrypted. Happy secret messaging!");
       scanner.close();
   }

    public static void main(String[] args) {
        runEncryption();
    }
}
