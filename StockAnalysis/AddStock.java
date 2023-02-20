package StockAnalysis;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
public class AddStock{

    public static void a(){
        try (Scanner tikSymbol = new Scanner(System.in)) {
        String tickerSymbol = tikSymbol.next();
        System.out.println("");
        System.out.println("Enter Ticker Sysmbol:");
        ab();
    }
    
}
    private static void ab() {
        WebDriver driver = new Html();
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("finance.yahoo.com/quote/"+tickerSymbol+"?p="+tickerSymbol+"&.tsrc=fin-srch");
        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
    }
    
}
