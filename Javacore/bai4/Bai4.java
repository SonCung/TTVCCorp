/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai4;

import static bai4.IOFile.Buffer;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Son Cung
 */
public class Bai4 {
    static int rand(int min,int max){
        try {
            Random rn = new Random();
            int range = max - min + 1;
            int randomNum = min + rn.nextInt(range);
            return randomNum;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
   
    public static void main(String[] args) {
        
        Set<String> hset = new HashSet<>();
        Point p = new Point();
        int dem =0,dem2=0,dem3=0;
        while (true) {
            int x =rand(400, 1200);
            int y = rand(400, 1200);
            if(Math.sqrt(Math.pow(x-800, 2)+Math.pow(y-800, 2))<=400){
                if(!hset.contains(p.addPoint(x, y))){
              hset.add(p.addPoint(x, y));
            dem++;
                }
            }
                if(dem==8000) break;
        }
         while (true) {
            int x2 =rand(3500, 4500);
            int y2 = rand(300, 1300);
            if(Math.sqrt(Math.pow(x2-4000, 2)+Math.pow(y2-800, 2))<=500){
                if(!hset.contains(p.addPoint(x2, y2))){
              hset.add(p.addPoint(x2, y2));
            dem2++;
                }
            }
               if(dem2==10000) break;
        }
        while (!false) {
            int x3 =rand(1800, 3000);
            int y3 = rand(1800, 3000);
            if(Math.sqrt(Math.pow(x3-2400, 2)+Math.pow(y3-2400, 2))<=600){
                if(!hset.contains(p.addPoint(x3, y3))){
              hset.add(p.addPoint(x3, y3));
            dem3++;
                }
            }
                if(dem3==12000) break;
        }
        //for (String string : hset) {
            //System.out.println(string);
            //Buffer(string);
        //}
        Buffer(hset.toString());
        System.out.println(hset.size());
    }
}
