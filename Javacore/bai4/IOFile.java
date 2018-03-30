/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Son Cung
 */
public class IOFile {
     public static void Buffer(String s){
        try {
            BufferedWriter writer;
            
            writer = new BufferedWriter(new FileWriter("C://Users//Son Cung//Desktop//output4.txt"));
            writer.write(s);
            writer.newLine();
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Bai4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
