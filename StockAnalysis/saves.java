package StockAnalysis;

import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;
import java.io.BufferedReader;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class saves {

    public void gatherSavedStocks() throws FileNotFoundException, IOException {
        System.out.println("Gathering Saved Stocks...");
        System.out.println("...");
        System.out.println("...");
        System.out.println("...");

    
    }
    
    public static void gatherLoop() throws FileNotFoundException, IOException{

        BufferedReader gatherStocks = new BufferedReader(new FileReader("stockNames.txt"));
        String observer = gatherStocks.readLine();
        
        if(observer.equals("")){
            gatherStocks.close();
        }else{
            Document doc = Jsoup.connect(observer).get();
            Elements contentA = doc.getElementsByClass("D(ib) Fz(18px)");
            System.out.println("|------------------------------------------------|");
            System.out.println();
            for(Element a: contentA){
            System.out.println("| Name: "+a.text());
        }
    }
    }
}

