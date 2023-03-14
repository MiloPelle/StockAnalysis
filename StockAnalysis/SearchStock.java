package StockAnalysis;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;  
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class SearchStock {

    public static String URL;
    public static String tickerSymbol;

    public static void search() throws IOException, NoSuchElementException{ 
        int i = 0;
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
            FileWriter saveName = new FileWriter("stockNames.txt");
            BufferedReader save = new BufferedReader(new FileReader("stockNames.txt"));
            BufferedWriter writeSave = new BufferedWriter(new FileWriter("stockNames.txt"));
            String last, line;
               Scanner blank = new Scanner(new FileReader("stockNames.txt"));
               saveName.write("%n");
               String blanks = blank.toString();
            if(option.equals("1")){
               while((line = save.readLine()) != null){
                last = line;
               }
               blank.close();
               saveName.close();            
            }else if(option.equals("2")){
               BufferedWriter pendNames = new BufferedWriter(new FileWriter("pendNames.txt"));
               pendNames.write(tickerSymbol);
               pendNames.newLine();
               pendNames.close();
               Home.home();
            }else if(option.equals("3")){
                Home.home();
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

          
    
    
    