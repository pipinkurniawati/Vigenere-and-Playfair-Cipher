
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pipin
 */
public class MainClass {
    
    public String clearSpace(String cipher) {
        return cipher.replaceAll("\\s+","");
    }
    
    public String divideIntoN(String cipher, int n) {
        cipher = clearSpace(cipher);
        for (int i=0, j=0; i<cipher.length(); i++) {
            if (i == j+((j+1)*n)) {
                cipher = new StringBuffer(cipher).insert(i, " ").toString();
                j++;
            }
        }
        return cipher;
    }
    
    public static String readBytes(String filePath)
    {
    	Path path = Paths.get(filePath);
        String text = new String();
        try {
            byte[] bytes = Files.readAllBytes(path);
            text = new String(bytes);
        } catch (IOException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return text;
    }
    
    public static void saveResult(String output) throws IOException {
        byte data[] = output.getBytes();
        File someFile = new File("C:\\out2.docx");
        try {
            FileOutputStream fos = new FileOutputStream(someFile);
            fos.write(data);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        String text = new String ("GNGDAINDKECNEKQMUZBY");
        Scanner in = new Scanner(System.in);
        Vector<String> key = new Vector<String>();
        for (int i=0; i<5; i++) {
            key.add(in.nextLine());
        }
        
        PlayfairCipher cp = new PlayfairCipher(text, key);
        System.out.println(cp.decrypt());
    }
}
