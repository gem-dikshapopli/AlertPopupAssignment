package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;


public class Main {
    public static void main(String[] args) {

        //----To launch https://chercher.tech/practice/practice-pop-ups-selenium-webdriver
        WebDriver driver=new ChromeDriver();
        driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //----To click on Alert i have made a locators.java class where i have stored all the xpaths

        try {
            driver.findElement(Locators.alert).click();
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        //----we need to switch to the alert for that we will use switchTo()

        Alert alertBox=driver.switchTo().alert();
        String alertMessage=alertBox.getText();

        //----display the Alert message
        System.out.println("***************** Alert Message******************");
        System.out.println(alertMessage);
        //-----Accept the alert
        alertBox.accept();



        //---Click on confirmation box and get the text and cancel it
        try {
            driver.findElement(Locators.conformationBox).click();
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }

        Alert conformBox= (Alert) driver.switchTo().alert();
        String conformationBoxText=conformBox.getText();
        System.out.println("********************Conformation Box Message**************");
        System.out.println(conformationBoxText);
        conformBox.dismiss();

        //-----Click on prompt ,enter value and accept it---
        try {
            driver.findElement(Locators.prompt).click();

        }catch (Exception e){
            e.printStackTrace();
        }

        Alert promptBox=(Alert)driver.switchTo().alert();
        // ----- Writing in the prompt
        promptBox.sendKeys("abcddhud");
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        //----To click on Ok Button
        promptBox.accept();

        //-------Double click on Double click me and get the text from alert
        Actions actions=new Actions(driver);
        try {

            actions.moveToElement(driver.findElement(Locators.doubleClick)).doubleClick().build().perform();
        }catch (Exception e){
            e.printStackTrace();
        }
        Alert doubleClickMe=(Alert)driver.switchTo().alert();
        String doubleClickText=doubleClickMe.getText();
        System.out.println("****************DoubleClickMe Text**************");
        System.out.println(doubleClickText);

        doubleClickMe.accept();


        //----Hover on Sub Menu and Click on Google-----

       actions.moveToElement(driver.findElement(Locators.hoverSubMenu)).build().perform();
       try{
           driver.findElement(By.id("link2")).click();
       }catch (Exception e){
           e.printStackTrace();
       }
        driver.close();




    }
}