import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
public class websiteCatch{
    private String html = "";
    private String bdex = "<span id=\"yfs_l84_goog\">";
    private String adex = "</span></span> <span class=";
    //public websiteCatch(String htmlA){
    //    html = htmlA;
    //System.out.println(html);
    // }

    public void updateHtml(String htmlA){
        html = htmlA;
    }

    public String getStockPrice(){
        int start;
        int end;
        String bla = "</font></td> 				<td bgcolor=\"#FFFFFF\" align=\"center\"><font color=\"black\"><b";
        int htmlid = html.indexOf(bla)+bla.length();
        //String stock = html.substring(start,end);
        //int bla1 = html.indexOf(htmlid);
        System.out.println(html);
        String modHtml = html.substring(htmlid,htmlid+100);
        start = modHtml.indexOf(">");
        end = modHtml.indexOf("<");
        String stock = modHtml.substring(start+1,end);
        return stock;
    }

    /*
    public String getStockPrice(){
    int start;
    int end;
    String bla = "class=\"time_rtq_ticker\"><";
    int htmlid = html.indexOf("class=\"time_rtq_ticker\"><")+bla.length();
    //String stock = html.substring(start,end);
    //int bla1 = html.indexOf(htmlid);
    String modHtml = html.substring(htmlid,htmlid+100);
    start = modHtml.indexOf(">");
    end = modHtml.indexOf("<");
    String stock = modHtml.substring(start+1,end);
    return stock;
    }
     */
    public void getHtml(String urlName){
        html = "";
        try{
            URL url = new URL(urlName);
            URLConnection con = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String l;
            while ((l=in.readLine())!=null) {
                //System.out.println(html);
                html = html+l+"\n";
            }
            //System.out.println(html);
        }catch(Exception e){
            System.out.println("welp");
        }
    }

}