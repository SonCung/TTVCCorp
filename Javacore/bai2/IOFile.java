/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

import bai4.Bai4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Son Cung
 */
public class IOFile {
    public static void BuffedReader(){
        try (BufferedReader br = new BufferedReader(new FileReader("C://Users//Son Cung//Desktop//01.txt"))) {
			String currentLine;
 
			// đọc file theo dòng và in ra
			while ((currentLine = br.readLine()) != null) {
				System.out.println(currentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
     public static void WriteFile(String s){
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter("C://Users//Son Cung//Desktop//output.txt"));
            writer.write(s);
            writer.newLine();
        writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Bai4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
