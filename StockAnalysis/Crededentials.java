package StockAnalysis;

import java.io.IOException;
import java.util.Scanner;

public class Crededentials{
    
    public static void credits() throws IOException{
        System.out.printf("|----------------------------------------------------|%n");
        System.out.printf("|                      Credits:                      |%n");
        System.out.printf("|----------------------------------------------------|%n");
        System.out.printf("|                   Milo Pelletier                   |%n");
        System.out.printf("|----------------------------------------------------|%n");
        System.out.printf("|                     References:                    |%n");
        System.out.printf("|----------------------------------------------------|%n");
        System.out.printf("| 1. Tim M. (1956, July 1). Find a line in a file and remove it. Stack Overflow. Retrieved March 27, 2023, from https://stackoverflow.com/questions/1377279/find-a-line-in-a-file-and-remove-it |%n");
        System.out.printf("| 2. Add jar files to Java Project Using Visual Studio Code. YouTube. (2021, June 1). Retrieved March 27, 2023, from https://www.youtube.com/watch?v=3Qm54znQX2E |%n");
        System.out.printf("| 3. baeldung, W. by: (2023, January 25). Formatting output with printf() in Java. Baeldung. Retrieved March 27, 2023, from https://www.baeldung.com/java-printstream-printf |%n");
        System.out.printf("| 4. Peck3277Peck3277 1, et al. “Handling Connection Errors and Jsoup.” Stack Overflow, 1 Feb. 1959, https://stackoverflow.com/questions/10245519/handling-connection-errors-and-jsoup. |%n");
        System.out.printf("| 5. Bufferedwriter (Java Platform SE 8 ) - oracle. (n.d.). Retrieved April 18, 2023, from https://docs.oracle.com/javase/8/docs/api/java/io/BufferedWriter.html |%n");
        System.out.printf("| 6. YouTube. (2018, May 20). How to web scrape stock data with Java using the jsoup library. YouTube. Retrieved April 23, 2023, from https://www.youtube.com/watch?v=tI1qGwhn_bs |%n");
        System.out.printf("| 7. KitKit 111 bronze badge, &amp; 18.7k66 gold badges3232 silver badges4141 bronze badges. (1969, December 1). Jsoup and for Loop Nosuchelementexception. Stack Overflow. Retrieved April 23, 2023, from https://stackoverflow.com/questions/75653875/jsoup-and-for-loop-nosuchelementexception/75658646#75658646 |%n");
        System.out.printf("|----------------------------------------------------|%n");
        System.out.printf("|                     Webscraping:                   |%n");
        System.out.printf("|----------------------------------------------------|%n");
        System.out.printf("|                     Yahoo Finance                  |%n");
        System.out.printf("|----------------------------------------------------|%n");
        System.out.printf("|                       Options:                     |%n");
        System.out.printf("|----------------------------------------------------|%n");
        System.out.printf("|                       1. Home                      |%n");
        System.out.printf("|----------------------------------------------------|%n");
        int credRedirect;
        Scanner creds = new Scanner(System.in);
        credRedirect = creds.nextInt();
        if(credRedirect==1){
            Main.home();
            creds.close();
        }else{
        System.out.println("Invalid Response");
        credits();
        }
    }
}