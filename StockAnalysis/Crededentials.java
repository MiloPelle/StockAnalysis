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
            Home.home();
            creds.close();
        }else{
        System.out.println("Invalid Response");
        credits();
        }
    }
}