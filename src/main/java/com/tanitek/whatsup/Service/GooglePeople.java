package com.tanitek.whatsup.Service;
import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;
import java.io.File;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;


@Service
public class GooglePeople {
    private static ChromeDriver driver;
    private final WpCrawler wpCrawler;
    public static WebDriverWait wait;

    File folder = new File("src/main/resources/csvdataa/");
    File[] listOfFiles = folder.listFiles((dir, name) -> !name.equals(".DS_Store"));
    String fileName;

    public GooglePeople(WpCrawler wpCrawler){
        this.wpCrawler = wpCrawler;
    }

    public void deleteData() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div[2]/div[6]/div[2]/div/div[1]/div/div[1]/div[2]"));
        action.moveToElement(we).click().build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"ow25\"]/div/div[1]/div/div[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div[4]/div/div/div/span[1]/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"ow25\"]/div/div[2]/div[5]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div[4]/div/div/div/span[4]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/div[4]/div/div[2]/div[3]/div/button[2]/div")).click();
    }


    public void insertData(){

        for (File file : listOfFiles) {
            if (file.isFile()) {
                fileName=file.getName();

                System.out.println(fileName);
                try{
                    Thread.sleep(1000);

                    driver.findElement(By.xpath("//*[@id=\"gb\"]/div[4]/div[2]/div/c-wiz/div/div[10]/a")).click();
                    driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/div[4]/div/div[2]/span/div/label/input")).sendKeys("/Users/arpanet/Desktop/whatsup/src/main/resources/csvdataa/"+fileName);
                    WebElement sendbutton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"yDmH0d\"]/div[4]/div/div[2]/div[2]/div/button[2]")));
                    sendbutton.click();
                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                }catch (Exception exception){
                    System.out.println("Error");
                }
            }
        }

    }

    public  void checkList() {

        WebElement element =driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz"));

        List<WebElement> googlePeople = element.findElements(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div[2]"));

        //deneme=driver.findElement(By.xpath("//span[@class = 'CAX6Sd']")).getText();

        //System.out.println(googlePeople);
        //Checking list, if it's empty insert new person, if not delete all people
        try{


            for (WebElement person:googlePeople){
                if(person.getText().contains("Henüz kişi yok")){
                    insertData();
                    driver.navigate().refresh();
                    Thread.sleep(1000);

                }else{
                    deleteData();
                }
            }
            Thread.sleep(10000);
        }catch (Exception e){
            System.out.println(e);

        }

        }

        public void GoogleRun() throws InterruptedException{
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 10);

            driver.get("https://contacts.google.com/?hl=tr");
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            //Gmail
            driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("hesabimhesabim.0606@gmail.com");
            //
            driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button")).click();
            //Password
            driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("deneme.1598756");
            //deneme.1598756
            driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button")).click();
            checkList();
            driver.quit();


    }


}
