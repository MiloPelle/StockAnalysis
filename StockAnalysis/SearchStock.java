package StockAnalysis;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class SearchStock {

    public static String URL;
    public static String tickerSymbol;

    public static void search() throws IOException{ 
        String tickerSymbol;
        String option;
        System.out.println("");
        System.out.println("Enter Ticker Sysmbol:");
        try (Scanner tikSymbol = new Scanner(System.in)) {
        tickerSymbol = tikSymbol.next();
        //the scanner saves the stock tickersymbol 
        URL = "http://finance.yahoo.com/quote/"+tickerSymbol+"?p="+tickerSymbol+"&.tsrc=fin-srch";
        //url made to search the stock on yahoo
        System.out.println("Gathering Stock Info...");
        Document doc = Jsoup.connect(URL).get();
        Elements contentA = doc.getElementsByClass("D(ib) Fz(18px)");
        Elements contentC = doc.getElementsByClass("Bxz(bb) Bdbw(1px) Bdbs(s) Bdc($seperatorColor) H(36px) ");
        System.out.println("|------------------------------------------------|");
        for(Element a: contentA){
        System.out.println("| Name: "+a.text());
        for(Element c: contentC)
        System.out.println("| "+c.text());
        Connection.Response response = null;
            try {
                response = Jsoup.connect(URL)
                        .userAgent("Mozilla/5.0 (Windows NT 6.0) AppleWebKit/536.5 (KHTML, like Gecko) Chrome/19.0.1084.46 Safari/536.5")
                        .timeout(100000)
                        .ignoreHttpErrors(true) 
                        .execute();
            } catch (IOException e) {
                System.out.println("io - "+e);
            }

            System.out.println("Status code = " + response.statusCode());   
            System.out.println("Status msg  = " + response.statusMessage());
        System.out.println("|------------------------------------------------|");
        System.out.println("|                     Options:                   |");
        System.out.println("|------------------------------------------------|");
        System.out.println("|                  1. Save Stock                 |");
        System.out.println("|                  2. Pend Stock                 |");
        System.out.println("|                     3. Home                    |");
        System.out.println("|              4. Find Another Stock             |");
        System.out.println("|                 5. Update Info                 |");
        System.out.println("|------------------------------------------------|");
        
            option = tikSymbol.next();
            if(option.equals("1")){
                try{
                    FileWriter saveName = new FileWriter("stockNames.txt", true);
                    BufferedWriter writeSave = new BufferedWriter(saveName);
                    writeSave.write(tickerSymbol);
                    writeSave.newLine();
                    writeSave.close();
                    Main.home();
                }finally{
                    
                }         
            }else if(option.equals("2")){
                try{
                    FileWriter pendName = new FileWriter("pendNames.txt", true);
                    BufferedWriter writePend = new BufferedWriter(pendName);
                    writePend.write(tickerSymbol);
                    writePend.newLine();
                    writePend.close();
                    Main.home();
                }finally{
                    
                }  
            }else if(option.equals("3")){
                Main.home();
            }else if(option.equals("4")){
                search();
            }else if(option.equals("5")){
                updateSearchedStock.uss();
            }
            tikSymbol.close();
        }
    }
}
}