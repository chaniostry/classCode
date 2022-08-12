import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DocTest {
    @Test
    public void loginTest(){
        Cura cura1 = new Cura();
      var expectedUrl = "https://katalon-demo-cura.herokuapp.com/";
      var actualUrl = cura1.openSite(expectedUrl);
      Assert.assertEquals(expectedUrl,actualUrl);
      System.out.println("smoke test --- > pass");


      var expectedLabel = "Login";
      var actualLabel = cura1.openLoginPage();
      Assert.assertEquals(expectedLabel,actualLabel);
      System.out.println("page test --- > pass");

      String[] urls= cura1.login();
      Assert.assertNotEquals(urls[0],urls[1]);
      System.out.println("login test--- > pass");

   cura1.quit();





    }

}
