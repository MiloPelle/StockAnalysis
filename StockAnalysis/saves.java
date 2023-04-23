package StockAnalysis;

import org.jsoup.Connection;
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;
import java.io.File;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class saves {
static String URL;
private static final String TEMPLATE = "http://finance.yahoo.com/quote/%s?p=%s&.tsrc=fin-srch";
static String URLkey;

    public static void gatherSavedStocks() throws IOException {
        System.out.println("Gathering Saved Stocks...");
        System.out.println("...");
        System.out.println("...");
        System.out.println("...");
        System.out.println("This Might take A While");
        sn();
    }
    

        public static void showName(String name) throws IOException {
                String url = String.format(TEMPLATE, name, name);
                Connection conn = Jsoup.connect(url);
                Document doc = conn.get(); // throws java.io.IOException
                Elements contentA = doc.getElementsByClass("D(ib) Fz(18px)");
                for (Element a : contentA) {
                    System.out.println(a.text());
                }
            }
            public static void sn() throws IOException {
                try (Scanner gatherStocks = new Scanner(new File("stockNames.txt"))) {
                    while (gatherStocks.hasNextLine()) {
                        String name = gatherStocks.nextLine();
                        System.out.println("|--------------------------------------------------------------------|");
                        showName(name);
                        Connection.Response response = null;
                        try {
                            response = Jsoup.connect(URL)
                                    .userAgent("Mozilla/5.0 (Windows NT 6.0) AppleWebKit/536.5 (KHTML, like Gecko) Chrome/19.0.1084.46 Safari/536.5")
                                    .timeout(100000)
                                    .ignoreHttpErrors(true) 
                                    .execute();
                        } catch (IOException e) {
                            System.out.println("io - "+e);
                        }
                    
                        System.out.println("Status code = " + response.statusCode());   
                        System.out.println("Status msg  = " + response.statusMessage());
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
                URLkey = lines.skip(stockNum-1).findFirst().get();
                URL = "http://finance.yahoo.com/quote/"+URLkey+"?p="+URLkey+"&.tsrc=fin-srch";
                lines.close();
                StockDetailes();
            
            }else if(saveOpIn==2){
            Home.home();
        }
            saveOp.close();        
    }
    public static void StockDetailes() throws IOException{
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
        sds.close();
    }
}
    public static void delete() throws IOException{
        Scanner delete = new Scanner(System.in);
        System.out.println("Deleting...");
        File file = new File("stockNames.txt");
        List<String> out = Files.lines(file.toPath())
                        .filter(line -> !line.contains(URLkey))
                        .collect(Collectors.toList());
        Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
        System.out.println("Done!");
        System.out.println();
        delete.close();
        sn();
    }
}
