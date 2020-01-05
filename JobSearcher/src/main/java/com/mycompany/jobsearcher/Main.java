/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jobsearcher;

import java.io.IOException;

/**
 *
 * @author callu
 */
public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length > 2) {
            String search = "";
            for (String a : args){
                search += a;
            }
            Browser b = new Browser(search);
            b.getJobsList();
            KeywordAnalyzer.generateReport();
        }
        else{
            System.out.println("Please enter at least two arguments");
        }
    }
}
