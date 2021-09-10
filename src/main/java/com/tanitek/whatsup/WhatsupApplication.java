package com.tanitek.whatsup;
import org.junit.After;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class WhatsupApplication  {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src" + File.separator + "main" + File.separator + "resources" + File.separator +"chromedriver");
        SpringApplication.run(WhatsupApplication.class, args);

    }

}

