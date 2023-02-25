package StockAnalysis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class saves {
    public static int aa;
    public static int ab;
    public void gatherSavedStocks() {
        System.out.println("Gathering Saved Stocks...");
        System.out.println("...");
        System.out.println("...");
        System.out.println("...");

        try{
            try (BufferedReader gatherStocks = new BufferedReader(new FileReader("stockNames.txt"))) {
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }finally{

        }
    }
}
