/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.concurrent.Callable;

/**
 *
 * @author Son Cung
 */
public class RunCallable implements Callable<HashMap>{
    String path;

    public RunCallable(String path) {
        this.path = path;
    }

    @Override
    public HashMap call() throws Exception {
        HashMap<String, Integer> map = new HashMap<>();
        try {
            FileInputStream fis = new FileInputStream(new File(path));
            try (BufferedReader br = new BufferedReader(new InputStreamReader(fis))) {
                String currentLine;
                while ((currentLine = br.readLine()) != null) {
                //System.out.println(currentLine);
                //currentLine.trim();
                String[] words = currentLine.split("\\s");
                for (int i =0;i<words.length;i++){
                    //if (words[i].length()>1){
                    if(map.get(words[i])!=null){
                        int value=map.get(words[i]);
                        value++;
                        map.put(words[i],value);
                    }else
                            map.put(words[i],1);
                    //}
                }
            }
            }
        } catch (IOException e) {
        }
        return  map;
    }
}
