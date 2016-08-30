/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pipin
 */
public class StandardVigenere {
    private static final int MAX_KEY_LENGTH = 25;
    private String key, text;
    
    public StandardVigenere(String text, String key) {
        this.text = new String(text);
        this.key = new String (key.toUpperCase());
    }
    
    public String encrypt() {
        String result = new String();
        String plaintext = new String(text.toUpperCase());
        int j = 0;
        for (int i=0; i<plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                result += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
                j = (j+1) % key.length();
            } else {
                result += c;
            }
        }
        return result;
    }
    
    public String decrypt() {
        String result = new String();
        String ciphertext = new String(text.toUpperCase());
        int j = 0;
        
        for (int i=0; i<ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                result += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
                j = (j+1) % key.length();
            } else {
                result += c;
            }
        }
        return result.toLowerCase();
    }
}
