/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pipin
 */
public class ExtendedVigenere {
    private static final int MAX_KEY_LENGTH = 25;
    private String key, text;
    
    public ExtendedVigenere(String text, String key) {
        this.text = new String(text);
        this.key = new String (key);
    }
    
    public String encrypt() {
        String result = new String();
        String plaintext = new String(text);
        for (int i=0; i<plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            result += (char) ((c + key.charAt(i%key.length())) % 256);
        }
        return result;
    }
    
    public String decrypt() {
        String result = new String();
        String ciphertext = new String(text);
        
        for (int i=0; i<ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            result += (char) ((c - key.charAt(i%key.length()) + 256) % 256);
        }
        return result;
    }
    
    public String clearSpace(String cipher) {
        return cipher.replaceAll("\\s+","");
    }
    
    public String divideIntoFive(String cipher) {
        cipher = clearSpace(cipher);
        for (int i=0, j=0; i<cipher.length(); i++) {
            if (i == j+((j+1)*5)) {
                cipher = new StringBuffer(cipher).insert(i, " ").toString();
                j++;
            }
        }
        return cipher;
    }
}
