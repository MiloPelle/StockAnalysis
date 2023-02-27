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
static String URL;
    public static void gatherSavedStocks() throws FileNotFoundException, IOException {
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
            System.out.println("If Their Is No Stocks Popping Up, You Have No Saved Stocks");            
        }else{
            String glURL = "http://finance.yahoo.com/quote/"+observer+"?p="+observer+"&.tsrc=fin-srch";
            Document doc = Jsoup.connect(glURL).get();
            Elements contentA = doc.getElementsByClass("D(ib) Fz(18px)");
            System.out.println("|------------------------------------------------|");
            for(Element a: contentA){
            i++;
            System.out.println("| "+i+". Name: "+a.text());
            gatherStocks.readLine();
            gatherLoop();
            }
        }
            gatherStocks.close();
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
                URL = "http://finance.yahoo.com/quote/"+URLkey+"?p="+URLkey+"&.tsrc=fin-srch";
            
            }else if(saveOpIn==2){
            Home.home();
        }
            saveOp.close();        
    }
    public static void StockDetailes() throws IOException, NoSuchElementException{
        String URL = saves.URL;
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
        System.out.println("|                     1. Back                    |");
        System.out.println("|                    2. Delete                   |");
        System.out.println("|                     3. Home                    |");
        System.out.println("|------------------------------------------------|");
        Scanner sds = new Scanner(System.in);
        String sdss = sds.next();
        if(sdss.equals("1")){
            gatherSavedStocks();
        }else if(sdss.equals("2")){
            delete();
        }else if(sdss.equals("3")){
            Home.home();
        }
    }
}
    public static void delete() throws IOException, NoSuchElementException{

    }
}