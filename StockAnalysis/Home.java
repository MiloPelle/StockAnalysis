package StockAnalysis;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Home{

    public static void main(String[] args) throws IOException, NoSuchElementException{            
        //Home Screen
        System.out.printf("--------------------------------%n");
        System.out.printf("         Stock Analysis         %n");
        System.out.printf("       By: Milo Peleltier       %n");
        System.out.printf("--------------------------------%n");
        System.out.printf("        Choose An Option:       %n");
        System.out.printf("--------------------------------%n");
        System.out.printf("       1. New Stock             %n");
        System.out.printf("       2. Open Portfolio        %n");
        System.out.printf("       3. Pending Stocks        %n");
        System.out.printf("       4. About/Crededentials   %n");
        System.out.printf("--------------------------------%n");
        //makes new scanner for the option menu
       try (Scanner choseOption = new Scanner(System.in)) {
            String option = choseOption.next();
            if(option.equals("1")){
               SearchStock.search();
            }else if(option.equals("2")){
               saves.gatherSavedStocks();
            }else if(option.equals("3")){
                System.out.println("Not Availible");
            }
        choseOption.close();
        }
    }
    public static void home() throws IOException{
        //Home Screen Duplicate Because Cannot Call Main Method Again
        System.out.printf("--------------------------------%n");
        System.out.printf("         Stock Analysis         %n");
        System.out.printf("       By: Milo Peleltier       %n");
        System.out.printf("--------------------------------%n");
        System.out.printf("        Choose An Option:       %n");
        System.out.printf("--------------------------------%n");
        System.out.printf("       1. New Stock             %n");
        System.out.printf("       2. Open Portfolio        %n");
        System.out.printf("       3. Pending Stocks        %n");
        System.out.printf("       4. About/Crededentials   %n");
        System.out.printf("--------------------------------%n");
        //duplicate option scanner
       try (Scanner choseOption = new Scanner(System.in)) {
            String option = choseOption.next();
            if(option.equals("1")){
               SearchStock.search();
            }else if(option.equals("2")){
                saves.gatherSavedStocks();
            }else if(option.equals("3")){
                System.out.println("Not Availible");
            }else if(option.equals("4")){
                
            }
            choseOption.close();
       }
    }
}
