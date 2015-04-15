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
    public websiteCatch(String urlName){
        html = this.getHtml(urlName);
    }
    
    public void main(){
        int start = html.indexOf(bdex)+bdex.length();
        int end = html.indexOf(adex);
        String test = html.substring(start,end);
        System.out.println(test);
    }
    
    public String getHtml(String urlName){
        String html = "";
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
        return html;
    }
        
    
}