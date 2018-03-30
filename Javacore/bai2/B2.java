/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

import static bai2.IOFile.WriteFile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Son Cung
 */
public class B2 {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        try (BufferedReader br = new BufferedReader(new FileReader("C://Users//Son Cung//Desktop//01.txt"))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                //System.out.println(currentLine);
                //currentLine.trim();
                String[] words = currentLine.split("\\s");
                for (int i = 0; i < words.length; i++) {
                    if (map.containsKey(i)) {
                        continue;
                    }
                    if (map.get(words[i]) != null) {
                        int value = map.get(words[i]);
                        value++;
                        map.put(words[i], value);
                    } else {
                        map.put(words[i], 1);

                    }
                    
                }
            }

            WriteFile(map.toString());

            //Map<String,Integer> tree = new TreeMap<>(map);      //convert ve tree map
            // System.out.println(tree);
            /*for (String key : map.keySet()) {
                Integer value = map.get(key);
                WriteFile(key+" = "+value+"  ;  ");
                //System.out.println(key+" = "+value);
            }*/
            System.out.println(map.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
