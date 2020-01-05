/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jobsearcher;

import java.util.Objects;

/**
 *
 * @author callu
 */
public class Word implements Comparable<Word>{
    
    private String word;
    private int count;
    
    public Word(String word){
        this.word = word;
        this.count = 1;
    }
    
    public void incCount(){
        this.count++;
    }
    
    public void setCount(int count){
        this.count = count;
    }
    
    public int getCount(){
        return this.count;
    }
    
    public String getWord(){
        return this.word;
    }

    @Override
    public int compareTo(Word t) {
       if (this.getCount() < t.getCount()) return -1;
       if (this.getCount() == t.getCount()) return 0;
       else return 1;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.word);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Word other = (Word) obj;
        if (!this.word.equals((other.getWord()))) {
            return false;
        }
        return true;
    }
    
    
    

    
}
