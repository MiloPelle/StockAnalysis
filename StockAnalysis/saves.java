package StockAnalysis;

import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;
import java.io.BufferedReader;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class saves {

    public void gatherSavedStocks() throws FileNotFoundException, IOException {
        System.out.println("Gathering Saved Stocks...");
        System.out.println("...");
        System.out.println("...");
        System.out.println("...");
        System.out.println("This Might take A While");
        gatherLoop();
    }
    
    public static void gatherLoop() throws FileNotFoundException, IOException{
        int i=0;
        BufferedReader gatherStocks = new BufferedReader(new FileReader("stockNames.txt"));
        String observer = gatherStocks.readLine();
        
        if(observer.equals("")){
            gatherStocks.close();
            System.out.println("Loaded Stocks");
            System.out.println("If Their Is No Stocks Popping Up, You Have No Save Stocks");            
        }else{
            Document doc = Jsoup.connect(observer).get();
            Elements contentA = doc.getElementsByClass("D(ib) Fz(18px)");
            System.out.println("|------------------------------------------------|");
            for(Element a: contentA){
            i++;
            System.out.println("| "+i+". Name: "+a.text());
            }
        }
            System.out.println("|--------------------------------------------------------------------|");
            System.out.println("|                               Options:                             |");
            System.out.println("|--------------------------------------------------------------------|");
            System.out.println("|                       1. See Stock Detailes                        |");
            System.out.println("|                               2. Home                              |");
            System.out.println("|--------------------------------------------------------------------|");
            Scanner saveOp = new Scanner(System.in);
            int saveOpIn = saveOp.nextInt();
            if(saveOpIn==1){
                System.out.println("Type Number Corresponding To Your Desired Stock");
                int stockNum = saveOp.nextInt();
                Stream<String> lines = Files.lines(Paths.get("stockNames.txt"));
                String URLkey = lines.skip(stockNum).findFirst().get();
                String URL = "http://finance.yahoo.com/quote/"+URLkey+"?p="+URLkey+"&.tsrc=fin-srch";
            
            }else if(saveOpIn==2){
            Home.home();
        }
            saveOp.close();        
    }
    public static void StockDetailes() throws IOException, NoSuchElementException{
        String URL = saves.URL;
    }
}

