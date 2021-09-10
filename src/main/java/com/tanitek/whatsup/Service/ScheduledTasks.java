package com.tanitek.whatsup.Service;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
@EnableScheduling

public class ScheduledTasks {
    private final GooglePeople googlePeople;
    private  final  WpCrawler wpCrawler;


    private  static  final Logger log= LoggerFactory.getLogger(ScheduledTasks.class);
    private  static  final SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");

    public ScheduledTasks(GooglePeople googlePeople, WpCrawler wpCrawler) {
        this.googlePeople = googlePeople;
        this.wpCrawler = wpCrawler;
    }

    //fixedrate=sabit oranlı
    //fixeddelay=sabit gecikmeli
    //initialdelay=başlangıc gecikmesi
    //cron zamanlama ifadesi

    //@Scheduled(fixedDelay=9000, initialDelay = 5000)
    @Scheduled(cron = "00 09 16,17 * * * ")
    public void executeTask2() throws InterruptedException {
        log.info("The time is now {}",dateFormat.format(new Date()));
        System.out.println(Thread.currentThread().getName()+"the task2 executed at");

        googlePeople.GoogleRun();
        Thread.sleep(10000);
        wpCrawler.run();


    }}












