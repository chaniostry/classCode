import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Cura {
    WebDriver driver;

    public Cura() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user1\\Desktop\\chromedriver.exe");
       this.driver= new ChromeDriver();
       this.driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
       this.driver.manage().window().maximize();

    }
    public String openSite( String url){
        this.driver.get(url);
        return driver.getCurrentUrl();
    }
    public String openLoginPage(){
        var loginPageBTN = this.driver.findElement(By.id("btn-make-appointment"));
        loginPageBTN.click();
        var loginLabel = this.driver.findElement(By.cssSelector("#login > div > div > div.col-sm-12.text-center > h2"));
        return loginLabel.getText();
    }
    public String[] login(){
        String[] urls = new String[2];
        var validUsername = "John Doe";
        var validPassword = "ThisIsNotAPassword";
        var usernameTB= this.driver.findElement(By.id("txt-username"));
        var passwordTB= this.driver.findElement(By.id("txt-password"));
        usernameTB.sendKeys(validUsername);
        passwordTB.sendKeys(validPassword);

        var loginBtn = this.driver.findElement(By.cssSelector("#btn-login"));
        urls[0]= this.driver.getCurrentUrl();
        loginBtn.click();
        urls[1] = this.driver.getCurrentUrl();

        return urls;

    }
    public void quit(){
        this.driver.quit();
    }
}
