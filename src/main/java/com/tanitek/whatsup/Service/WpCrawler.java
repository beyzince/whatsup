package com.tanitek.whatsup.Service;

import com.tanitek.whatsup.Repository.PhoneRepository;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service


public class WpCrawler  {

    private final PhoneRepository phoneRepository;
    private static ChromeDriver driver;
    private final GooglePeople googlePeople;

    public WpCrawler(PhoneRepository phoneRepository,@Lazy GooglePeople googlePeople) {
        this.phoneRepository = phoneRepository;
        this.googlePeople = googlePeople;

    }
    public  void logout() {
        driver.quit();
    }
    public void run() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://web.whatsapp.com/");
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.navigate().refresh();
        Thread.sleep(5000);
        WebElement deneme = driver.findElement(By.xpath("//*[@title=\'Yeni sohbet\']"));
        deneme.click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div[2]/div[1]/span/div[1]/span/div[1]/div[1]/div/label/div/div[2]\n")).sendKeys("05");

        WebElement element = driver.findElement(By.xpath("//div[@data-testid='contact-list-key']"));



        JavascriptExecutor jsExec = (JavascriptExecutor) driver;

        List<String> myPeople = new ArrayList<>();
        int newCount;
        while (true){
            List<WebElement> kisiler = element.findElements(By.xpath("./div/div/div"));
            System.out.println("Kısıler sıze: " + kisiler.size());
            newCount = 0;
            for (WebElement kisi : kisiler) {
                if (!myPeople.contains(kisi.getText())){
                    System.out.println(kisi.getText());
                    myPeople.add(kisi.getText());
                    try{
                        System.out.println(kisi.findElement(By.tagName("img")).getAttribute("src"));

                    }catch (Exception e){
                        System.out.println("Hata");
                    }

                    newCount++;
                }

            }
            System.out.println("New added people count: " + newCount);
            if (newCount == 0) {
                driver.quit();


            }
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            jsExec.executeScript("document.getElementsByClassName('_3Bc7H KPJpj')[0].scrollTop += 1000");

        }

    }




}












        /*
        elements.get(0).findElement(By.xpath("//div[@data-testid='cell-frame-container']"));
        elements.get(1).findElement(By.xpath("//div[@data-testid='cell-frame-container']"));




//*[@id="pane-side"]/div[2]/div/div
        ////*[@id="pane-side"]/div[1]/div/div
        //*[@id="pane-side"]/div[1]/div/div/div[4]/div/div/div[1]/div
        int count = 2;
        String photo;
        String status;
        String phonenumber;
        boolean checkphoto = true;
        //boolean checkstatus = true;



        for (int i = 0; i < elements.size(); i++) {

            checkphoto = isPhotoCheck(driver.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[" + count + "]/div")));
            List<checkphone>=isPhoneCheck(driver.findElement(By.xpath()))
            //checkstatus = isStatusCheck(driver.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[" + count + "]/div/div/div[2]/div[2]/div[1]")));
            if (checkphoto) {
                photo = driver.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[" + count + "]/div/div/div[1]/div/div/img")).getAttribute("src");
                //System.out.println(photo);
                ////*[@id="pane-side"]/div[1]/div/div/div[11]/div/div/div[1]/div/div/img
                ////*[@id="pane-side"]/div[1]/div/div/div[8]/div/div/div[1]/div/div/img

            } else {
                photo = driver.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[" + count + "]/div/div/div[1]/div/div/div/span")).getAttribute("data-icon");
                ////*[@id="pane-side"]/div[1]/div/div/div[11]/div/div/div[1]/div/div/div/span
            }


            //if (checkstatus) {
               // status = driver.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[" + count + "]/div/div/div[2]/div[2]/div[1]/span")).getAttribute("title");

           // } else {
                //status = "No Status Information";
            //}
            phonenumber=driver.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[" + count + "]/div/div/div[2]/div[1]/div/span/span")).getAttribute("title");
            phonenumber=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div[2]/div[" + count + "]/span/div[1]/span/div[1]/div/section/div[4]/div[3]/div/div/span/span")).getAttribute("title");

            ////*[@id="app"]/div[1]/div[1]/div[2]/div[3]/span/div[1]/span/div[1]/div/section/div[4]/div[3]/div/div/span/span

            System.out.println(photo);
            //System.out.println(status);
            System.out.println(phonenumber);


//            Phonenumber phonenumber1 = new Phonenumber();
//            phonenumber1.setPhonenumber(phonenumber);
//            phonenumber1.setWpphoto(photo);
//           phonenumber1.setWpstatus(status);
//           phoneRepository.save(phonenumber1);

            count++;
            if (count>elements.size()){
                i=elements.size();
            }


        }

         */

    /*

    private boolean isPhotoCheck(WebElement element) {
        try {
            element.findElement(By.tagName("img"));
            //System.out.println("Element found!!! " + element);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            //System.out.println("NoSuchElementException!!");
            return false;
        }
    }

     */



    //private  boolean isPhoneCheck(WebElement element){
    //try{
    // element.findElements(By.tagName("div"));

    // return true;

    //}catch()

    /*


    private boolean isStatusCheck(WebElement element) {
        try {
            element.findElement(By.tagName("span"));
            //System.out.println("Element found!!! " + element);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            //System.out.println("NoSuchElementException!!");
            return false;
        }

     */
//}

//}