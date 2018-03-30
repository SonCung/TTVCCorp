/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 *
 * @author Son Cung
 */
public class B3 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        File dir = new File("C://Users//Son Cung//Desktop//input 3");
        File[] paths = dir.listFiles();       // Doc ten cac file co trong thu muc 
        HashMap<String, Integer> map = new HashMap<>();
        List<Future<HashMap>> list = new ArrayList<>();
        for (File path : paths) {
            RunCallable c = new RunCallable(path.getAbsolutePath());
            Future<HashMap> future = executor.submit(c);
            //System.out.println(path);
            list.add(future);
        }
        // Gop các hashMap vao map 
        for (Future<HashMap> future : list) {
            Iterator<Map.Entry<String,Integer>> iteritor = future.get().entrySet().iterator();
            while (iteritor.hasNext()) {
                Map.Entry mape = iteritor.next();
                String key = (String) mape.getKey();
                if(map.containsKey(key)){
                    map.put(key, (int) map.get(key) + (int) mape.getValue());
                }
                else{
                    map.put(key, (int) mape.getValue());
                }
            }
        }

        Map<String, Integer> sortedMap = sortByValue(map);
        print10Min(sortedMap);
        System.out.println("\n");
        print10Max(sortedMap);
        executor.shutdown();
    }
    //sortByValue() hỗ trợ generics.
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> unsortMap) {
        // 1. Convert Map thành List of Map
            List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(unsortMap.entrySet());
        // 2. Sort list với Collections.sort(), sử dụng custom Comparator
        //    Đổi vị trí o1 o2 để thay đổi kiểu order
            Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
                public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                 return (o1.getValue()).compareTo(o2.getValue());
                }
            });
        // 3. Lặp sorted list và đổ vào insertion order Map mới LinkedHashMap
            Map<K, V> result = new LinkedHashMap<K, V>();
            for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
}
    public static <K, V> void print10Min(Map map){
        System.out.println("Top 10 tu xuat hien it nhat: ");
        Iterator it = map.entrySet().iterator();
        for(int i=0;i<10;i++){
            Map.Entry entry= (Map.Entry<K, V>)it.next();
            System.out.println(entry.toString());
        }
    }
    
    public static <K, V> void print10Max(Map map){
        System.out.println("Top 10 tu xuat hien nhieu nhat");
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        for(int i=list.size()-1;i>=(list.size()-10);i--){
            System.out.println(list.get(i).toString());
        }
    }
    
}

