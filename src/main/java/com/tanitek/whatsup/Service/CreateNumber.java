package com.tanitek.whatsup.Service;


import com.tanitek.whatsup.Repository.CountRepository;
import com.tanitek.whatsup.Repository.PhoneRepository;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

//@Service
public class CreateNumber implements Runnable {


    private PhoneRepository phoneRepository;
    private CountRepository countRepository;

    public CreateNumber(PhoneRepository phoneRepository, CountRepository countRepository) {
        this.phoneRepository=phoneRepository;
        this.countRepository=countRepository;

    }


    private FileWriter csvWriter = null;
    private CSVPrinter csvPrinter=null;

    private static String CLIENT_ID = "";
    private static String CLIENT_SECRET = "";
    //private static String REDIRECT_URI = "urn:ietf:wg:oauth:2.0:oob";
    private static String OAUTH_SCOPE = "https://www.googleapis.com/auth/webmasters.readonly";

    @Override
    public void run() {

        String key = "";
        String qry = "WhatsAppCrawler";


        URL url = null;
        try {
            url = new
                    URL("https://www.googleapis.com/customsearch/v1?key="
                    + key + "" + qry + "&alt=json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        /* int count = 0;


        Count count2 =countRepository.findById("csv").get();
        int count3=count2.getFilecount();




        try {
            csvWriter = new FileWriter(  "C:\\Users\\tntk\\Desktop\\whatsup\\src\\main\\resources\\csvdata\\"+count3 + "_csvdata.csv");
            csvPrinter = new CSVPrinter(csvWriter, CSVFormat.DEFAULT
                    .withHeader("First Name", "Mobile Phone"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] number = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[][] areacode = {{"501", "505", "506", "507", "551", "552", "553", "554", "555", "559"}
                , {"530", "531", "532", "533", "534", "535", "536", "537", "538", "539", "561"}
                , {"540", "541", "542", "543", "544", "545", "546", "547", "548", "549"}};

        for (int a = count2.getA(); a < 3; a++) {
            for (int b = count2.getB(); a < areacode[a].length; b++) {
                for (int c = count2.getC(); c < number.length; c++) {
                    for (int d = count2.getD(); d < number.length; d++) {
                        for (int e = count2.getE(); e < number.length; e++) {
                            for (int f = count2.getF(); f < number.length; f++) {
                                for (int g = count2.getG(); g < number.length; g++) {
                                    for (int h = count2.getH(); h < number.length; h++) {
                                        for (int i = count2.getI(); i < number.length; i++) {

                                            try {
                                                csvPrinter.printRecord("" , "+90" + areacode[a][b] + c + d + e + f + g + h + i);
                                            } catch (IOException ex) {
                                                ex.printStackTrace();
                                            }

                                            count++;
                                            if (count % 1000 == 0) {
                                                count3++;
                                                try {
                                                    Thread.sleep(1000);
                                                    Count count1=new Count();
                                                    count1.setCount("csv");
                                                    count1.setA(a);
                                                    count1.setB(b);
                                                    count1.setC(c);
                                                    count1.setD(d);
                                                    count1.setE(e);
                                                    count1.setF(f);
                                                    count1.setG(g);
                                                    count1.setH(h);
                                                    count1.setI(i);
                                                    count1.setFilecount(count3);
                                                    countRepository.save(count1);
                                                    csvPrinter.flush();
                                                    csvWriter.flush();



                                                    cleanUp1();
                                                    Thread.sleep(2000);
                                                    cleanUp();
                                                    Thread.sleep(2000);


                                                    csvWriter = new FileWriter(  "C:\\Users\\tntk\\Desktop\\whatsup\\src\\main\\resources\\csvdata\\"+count3 + "_csvdata.csv");
                                                    csvPrinter = new CSVPrinter(csvWriter, CSVFormat.DEFAULT
                                                            .withHeader("First Name", "Mobile Phone"));
                                                } catch (InterruptedException | IOException ex) {
                                                    ex.printStackTrace();
                                                }




                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }*/

    }
    private void cleanUp() throws IOException {
        csvWriter.close();
    }
    private void cleanUp1() throws IOException {
        csvPrinter.close();
    }

}
