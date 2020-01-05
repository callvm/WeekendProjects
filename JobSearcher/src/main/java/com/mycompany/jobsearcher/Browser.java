/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jobsearcher;

import com.google.common.io.Files;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author callu
 */
public class Browser {

    private WebDriver driver;
    private WebElement jobsLink;
    private File f;

    public Browser(String search) {

        this.driver = new ChromeDriver();
        this.driver.get("https://www.google.com/search?q=jobs+" + search.replace(" ", "+"));
        this.jobsLink = this.driver.findElement(By.id("TSOTfe"));
        this.jobsLink.click();
        this.f = new File("output.txt");
    }

    public void getJobsList() throws IOException {

        List<WebElement> elementList;
        List<WebElement> originalList;
        List<WebElement> completedList = new ArrayList<WebElement>();
        PrintWriter writer = new PrintWriter("output.txt", "UTF-8");

        while (true) {

            elementList = this.driver.findElements(By.tagName("li"));
            originalList = elementList;

            if (!completedList.isEmpty()) {
                elementList.removeAll(completedList);
            }

            if (elementList.isEmpty()) {
                break;
            }

            for (WebElement we : elementList) {
                try {
                    we.click();
                    String text = driver.findElement(By.id("tl_ditsc")).getText(); 
                    writer.println(text);
                    completedList.add(we);

                } catch (Exception e) {
                    // e.printStackTrace();
                }
            }

            try {
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Browser.class.getName()).log(Level.SEVERE, null, ex);
            }

            List<WebElement> newList = this.driver.findElements(By.tagName("li"));

            if (newList == originalList) {
                writer.close();
                break;
            }
        }

    }

}
