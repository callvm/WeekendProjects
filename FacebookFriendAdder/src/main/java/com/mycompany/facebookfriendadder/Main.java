
package com.mycompany.facebookfriendadder;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


/**
 *
 * @author Callum Campbell
 */
public class Main {
    
    
    // Use arguments {username, password, chromedriver location}
    // i.e. callum@email.com myPassword C:\Users\Callum\Downloads\chromedriver.exe
    
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        System.setProperty("webdriver.chrome.driver", args[2]);

        ChromeDriver cd = new ChromeDriver(options);

        cd.get("http://www.facebook.com/");
        
        login(cd, args);

        while (true) {
            cd.get("http://www.facebook.com/?sk=ff");

            Thread.sleep(20000);

            List<WebElement> friendAdd = cd.findElementsByClassName("FriendRequestAdd");

            for (WebElement we : friendAdd) {
                System.out.println(we.getText() + " " + we.getAttribute("aria-label"));
                try {
                    we.click();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static void login(ChromeDriver cd, String[] args) {
        List<WebElement> loginEl;

        loginEl = cd.findElements(By.className("login_form_input_box"));

        loginEl.get(0).sendKeys(args[0]);
        loginEl.get(1).sendKeys(args[1]);

        WebElement loginB = cd.findElementByClassName("login_form_login_button");

        loginB.click();
    }

}
