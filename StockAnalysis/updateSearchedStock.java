package StockAnalysis;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;  
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class updateSearchedStock{

public static void uss() throws IOException, NoSuchElementException{

    String URL = SearchStock.URL;
    System.out.println(URL);
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
    
        Scanner usso = new Scanner(System.in);
        String option = usso.next();
        if(option.equals("1")){
           BufferedWriter saveInfo = new BufferedWriter(new FileWriter("stockInfo.txt"));
           BufferedWriter saveName = new BufferedWriter(new FileWriter("stockNames.txt"));
           saveInfo.write(URL);
           saveName.write(a.text());
           saveInfo.newLine();
           saveName.newLine();
           saveInfo.close();
           saveName.close();
        }else if(option.equals("2")){
           BufferedWriter pendInfo = new BufferedWriter(new FileWriter("pendInfo.txt"));
           BufferedWriter pendNames = new BufferedWriter(new FileWriter("pendNames.txt"));
           pendInfo.write(URL);
           pendNames.write(a.text());
           pendInfo.newLine();
           pendNames.newLine();
           pendInfo.close();
           pendNames.close();
        }else if(option.equals("3")){
            Home.home();
        }else if(option.equals("4")){
            SearchStock.search();
        }else if(option.equals("5")){
            updateSearchedStock.uss();
        }
            usso.close();
    }
  }
}
