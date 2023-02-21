package StockAnalysis;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
public class AddStock{

    public static void a() throws IOException{
        String tickerSymbol;
        System.out.println("");
        System.out.println("Enter Ticker Sysmbol:");
        try (Scanner tikSymbol = new Scanner(System.in)) {
        tickerSymbol = tikSymbol.next();
    }
             String st = "http://finance.yahoo.com/quote/"+tickerSymbol+"?p="+tickerSymbol+"&.tsrc=fin-srch";
             URL searchStock = new URL(st);
            
            // Get the input stream through URL Connection
            URLConnection con = searchStock.openConnection();
            InputStream is = con.getInputStream();
            try(BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                String line = null;
            
                // read each line and write to System.out
                while ((line = br.readLine()) != null){
                    System.out.println(line);
                }

    
}
    }
}
