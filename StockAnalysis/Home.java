package StockAnalysis;
import java.util.Scanner;
public class Home{

    public static void main(String[] args){            

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
        
       try (Scanner choseOption = new Scanner(System.in)) {
            String option = choseOption.next();
            if(option.equals("1")){
               AddStock.a();
            }else if(option.equals("2")){
               Boolean OpenStock=true;
            }else if(option.equals("3")){
                int n = 3;
            }
        }
    }
        }
