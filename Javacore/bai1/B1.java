
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Son Cung
 */
public class B1 {
    public static void main(String[] args) {
        Random rd = new Random();
        Set<Integer> hs = new HashSet<>();
        Set<Integer> hs2 = new HashSet<>();
        Set<Integer> hs3 = new HashSet<>();
        Set<Integer> hs4 = new HashSet<>();
        while (true) {
            hs.add(rd.nextInt(300000));
            if(hs.size()==200000) break;
        }
        while (true) {
            hs2.add(rd.nextInt(300000));
            if(hs2.size()==200000) break;
        }
        System.out.println("Size hs = " +hs.size());
        System.out.println("Size hs2 = "+hs2.size());
       System.out.println("=========Hop cua hai tap hop===============");
        hs3.addAll(hs);
        hs3.addAll(hs2);
        System.out.println("Size cua hop 2 tap hop: "+ hs3.size());
        int dem=0;
        System.out.println("=====Giao cua hai tap hop=================");
        for (Integer h : hs) {
            if(hs2.contains(h)){
               // dem++;
                hs4.add(h);
               
            }
        }
        //System.out.println("So phan tu giao 2 tap hop = " +dem);
        System.out.println("Size giao cua 2 tap hop: "+hs4.size());
    }
}
