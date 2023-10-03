/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


// Generic programming in Java Basics
// How to link github to Netbeans projects
// https://www.youtube.com/watch?v=UOIPS-ewFHg


package com.ounis.genericprograming;

import java.util.ArrayList;
import java.util.List;


public class PairTest {
    
    public static void main(String... args) {
        
        List<String> ls;
        
        ls = new ArrayList<String>();
        
        String[] as = {"ROMANI", "ITE", "DOMUM"};
        Integer[] ai = {122, 8, 666,34, 56};
        
        Pair<String> pairs  = ArrayAlg.minmaxLen(as);
        System.out.println(pairs.getFirst());
        System.out.println(pairs.getSecond());
        
        Pair<Integer> pairi = ArrayAlg.minmax(ai);
        System.out.println(pairi.getFirst());
        System.out.println(pairi.getSecond());
        
        
//        użycie metody uogulnionej
        String[] names = {"Ritchie", "Stroustrup", "Gosling", "van Rossum", "Wall"};
        String name = ArrayAlg.<String>getMiddle(names);
        System.out.println(name);
        
//        String m = ArrayAlg.getMiddle(new String[2] {"asd", "asd"});
    }
    
}

class Pair2 <T extends Comparable> {
    
}

class Pair <T> {
    
    private T first;
    private T second;
    
    public Pair() {
        first = null;
        second = null;
    }
    public Pair(T aFirst, T aSecond) {
        this.first = aFirst;
        this.second = aSecond;
    }
    
    public T getFirst() {
        return this.first;
    }
    public T getSecond() {
        return this.second;
    }
    
    public void setFirst(T aFirst) {
        this.first = aFirst;
    }
    public void getSecond(T aSecond) {
        this.second = aSecond;
    }
}

 class ArrayAlg {
        
        
//        metoda uogulniona
        public static <T> T getMiddle(T[] a) {
            return a[a.length / 2];
        }
        
        public static Pair<String> minmax(String... a) {
            if (a == null || a.length == 0) 
                return null;
            String min = a[0];
            String max = a[0];
            for (int i=0;i<a.length;i++) {
                if (min.compareTo(a[i]) > 0) min = a[i];
                if (max.compareTo(a[i]) < 0) max = a[i];
            }
            return new Pair<String>(min, max);
        }
        
//      metoda minmax wersja uogulniona
//      ograniczona (extendes) do typów T implementujących interfejs 'Comparable'
        public static <T extends Comparable> Pair<T> minmax(T[] a) {
            if (a == null || a.length == 0)
                return null;
            T min = a[0];
            T max = a[0];
            for (int i=0; i<a.length;i++) {
                if (min.compareTo(a[i]) > 0) min = a[i];
                if (max.compareTo(a[i]) < 0) max = a[i];
            }
            return new Pair<T>(min, max);
        }
        

//        metoda minmax porównanie pod kątem długości łańcuchów
        public static Pair<String> minmaxLen(String... a) {
            if (a == null || a.length == 0)
                return null;
            String min = a[0];
            String max = a[0];
            
            for (int i=0;i<a.length;i++) {
                if (min.length() > a[i].length()) min = a[i];
                if (max.length() < a[i].length()) max = a[i];
            }
            
            return new Pair<>(min, max);
        }
    }
