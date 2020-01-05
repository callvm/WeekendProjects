/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jobsearcher;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author callu
 */
public class KeywordAnalyzer {
    
    public static void generateReport() throws FileNotFoundException{
        ArrayList<Word> words = new ArrayList();
        int count = 0;
       // File f = new File("output.txt");
        
        Scanner s = new Scanner(new FileInputStream("output.txt"));
        
        while(s.hasNext()){
            count++;
            String line = fixFormat(s.next());
            if (!line.equals(" ")){
                
                Word w = new Word(line);
                
                if (words.contains(w)){
                    Word x = words.get(words.indexOf(w));
                    words.remove(w);
                    x.incCount();
                    words.add(x);
                }
                else{
                    words.add(w);
                }
                
            }
            
        }
        
        s.close();
        
        Collections.sort(words);
        System.out.println(count);
        for (Word w : words){
            System.out.println(w.getWord() + " : " + w.getCount());
        }
        
        
    }
    
    private static String fixFormat(String s){
       return s.toLowerCase()
                .replace(",", "")
                .replace(";", "")
                .replace("-", "")
                .replace("/", "")
                .replace("\\", "")
                .replace("(", "")
                .replace(")", "");
                
    }
    
}
