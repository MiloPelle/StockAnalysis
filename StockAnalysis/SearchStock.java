package StockAnalysis;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;  
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class SearchStock {
    public static void search() throws IOException{  
        String tickerSymbol;
        System.out.println("");
        System.out.println("Enter Ticker Sysmbol:");
        try (Scanner tikSymbol = new Scanner(System.in)) {
        tickerSymbol = tikSymbol.next();
        tikSymbol.close();
    }
        String URL = "http://finance.yahoo.com/quote/"+tickerSymbol+"?p="+tickerSymbol+"&.tsrc=fin-srch";
        System.out.println("Gathering Stock Info");
        Document doc = Jsoup.connect(URL).get();
        Elements contentA = doc.getElementsByClass("D(ib) Fz(18px)");
        Elements contentC = doc.getElementsByClass("Bxz(bb) Bdbw(1px) Bdbs(s) Bdc($seperatorColor) H(36px) ");
        System.out.println("|------------------------------------------------|");
        for(Element a: contentA)
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
        try (Scanner stockOptions = new Scanner(System.in)){
        String stockOp = stockOptions.next();
           if(stockOp=="1"){
                BufferedWriter saveStockData = new BufferedWriter(new FileWriter("saveStockData.txt"));
                BufferedWriter stockNames = new BufferedWriter(new FileWriter("stockNames.txt"));
                for(Element a: contentA)
                stockNames.write(a.text());
                saveStockData.write(URL);
                stockNames.newLine();
                saveStockData.newLine();
                stockNames.close();
                saveStockData.close();
                saves.aa++;
                saves.ab++;
            }else if(stockOp=="2"){
                BufferedWriter savePendData = new BufferedWriter(new FileWriter("savePendData.txt"));
                BufferedWriter pendNames = new BufferedWriter(new FileWriter("pendNames.txt"));
                for(Element a: contentA)
                pendNames.write(a.text());
                savePendData.write(URL);
                savePendData.newLine();
                pendNames.newLine();
                pendNames.close();
                savePendData.close();
                pends.ba++;
                pends.bb++;
            }
        stockOptions.close();    
    }
} catch (IOException e){
    e.printStackTrace();
}
}        


