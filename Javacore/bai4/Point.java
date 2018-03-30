/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai4;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Son Cung
 */
public class Point {
    int x,y;

    public Point() {
        
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public String addPoint(int x,int y){
        this.x=x;
        this.y=y;
        return ("Point{" + "x=" + x + ", y=" + y + '}'+"\n");
    }


    @Override
    public boolean equals(Object obj) {
        final Point other = (Point) obj;
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.x;
        hash = 67 * hash + this.y;
        return hash;
    }

    
    public static void main(String[] args) {
        Set<Point> set = new HashSet<>();
        Point a = new Point();
        a.addPoint(100, 200);
        Point b = new Point();
        b.addPoint(100, 150);
        Point c = new Point();
        c.addPoint(100, 200);
        set.add(a);
        System.out.println(a.equals(b));
        System.out.println(set.contains(c));
    }
    
    
    
}
